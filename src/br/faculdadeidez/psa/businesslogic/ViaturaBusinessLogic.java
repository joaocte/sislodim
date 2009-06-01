package br.faculdadeidez.psa.businesslogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.faculdadeidez.psa.db.dao.DAOViatura;
import br.faculdadeidez.psa.servico.GoogleMaps;
import br.faculdadeidez.psa.vo.BairroVO;
import br.faculdadeidez.psa.vo.CoordenadaVO;
import br.faculdadeidez.psa.vo.MensagemValidacaoVO;
import br.faculdadeidez.psa.vo.ViaturaVO;
/**
* Classe que implementa regras de neg�cio referente a Entidade Viatura
* Abstrai a camada de persistencia JPA e realiza valida��es de neg�cio 
*/
public class ViaturaBusinessLogic {
	/**
	 * M�todo para deletar um objeto Viatura
	 * @param ViaturaVO vo -> objeto a ser removido do banco
	 * @return String -> indica sucesso ou falha 
	 */
	public String delete(ViaturaVO vo) {
		try {
			DAOViatura dViatura = new DAOViatura();
			if (dViatura.findByField("codigo", vo.getCodigo()).isEmpty())
				return "viaturaInexistente";
			ViaturaVO via = dViatura.find(vo.getCodigo());
			via.setAtivo(false);
			dViatura.update(via);
			return "removido";
		} catch (Exception e) {
			return "problemaRemover";
		}
	}
	
	/**
	 * M�todo para atualizar um objeto Viatura
	 * @param ViaturaVo vo
	 * @return String
	 */
	public String update(ViaturaVO vo) {
		try {
			// valida os dados inseridos
			List<MensagemValidacaoVO> erros = validaDados(vo);

			if (!MensagemValidacao.isValido(erros))
				return MensagemValidacao.getMensagensValidacao(erros);

			DAOViatura dViatura = new DAOViatura();
			if (dViatura.findByField("codigo", vo.getCodigo()).isEmpty()
					&& vo.getCodigo() != null)
				return "viaturaInexistente";
			dViatura.update(vo);
			if (vo.getAtivo())
				return "atualizado";
			else
				return "atualizadoDeletado";
		} catch (Exception e) {
			 
			return "problemaAtualizar";
		}
	}
	
	/**
	 * M�todo para criar um objeto Viatura
	 * @param ViaturaVO vo
	 * @return String
	 */
	public String create(ViaturaVO vo) {
		try {
			// valida os dados inseridos
			List<MensagemValidacaoVO> erros = validaDados(vo);

			if (!MensagemValidacao.isValido(erros))
				return MensagemValidacao.getMensagensValidacao(erros);

			DAOViatura dViatura = new DAOViatura();
			if (dViatura.findByField("codigo", vo.getCodigo()).isEmpty()) {
				dViatura.persist(vo);
				return "inserido";
			} else
				return "viaturaExistente";
		} catch (Exception e) {
			return "problemaInserir";
		}
	}
	
	/**
	 * M�todo para listar todas Viaturas
	 * @return List<ViaturaVO>
	 */
	public List<ViaturaVO> listar() {
		DAOViatura dViatura = new DAOViatura();
		return dViatura.findAll();
	}
	
	/**
	 * M�todo para listar todas Viaturas ativas
	 * @return List<ViaturaVO>
	 */
	public List<ViaturaVO> listarAtivos() {
		DAOViatura dViatura = new DAOViatura();
		return dViatura.findAllActivated();
	}
	
	/**
	 * M�todo para listar todas Viaturas por codigo
	 * @param String codigo
	 * @return List<ViaturaVO>
	 */
	public List<ViaturaVO> pesquisar(String codigo) {

		DAOViatura dViatura = new DAOViatura();
		List<ViaturaVO> retorno = dViatura.pesquisaViaturas(codigo);
		return retorno;
	}

	private List<MensagemValidacaoVO> validaDados(ViaturaVO vo) {
		ArrayList<MensagemValidacaoVO> erros = new ArrayList<MensagemValidacaoVO>();

		erros.add(new MensagemValidacaoVO("C�digo", "O c�digo � obrigat�rio",
				Boolean.valueOf(vo.getCodigo().isEmpty())));
		erros.add(new MensagemValidacaoVO("C�digo",
				"O c�digo deve ser menor que 4 d�gitos", Boolean.valueOf(vo
						.getCodigo().length() > 4)));
		erros.add(new MensagemValidacaoVO("C�digo",
				"O c�digo deve ser apenas d�gitos", Boolean.valueOf(!vo
						.getCodigo().matches("^[0-9]*$"))));
		return erros;
	}
	
	/**
	 * M�todo para listar todas Viaturas ativas
	 * @param String chave
	 * @return List<ViaturaVO>
	 */
	public ViaturaVO find(String chave) {

		return new DAOViatura().find(chave);
	}

	/**
	 * Este m�todo deve retornar as viaturas ativas no hor�rio em que o operador
	 * trabalha sendo dividido por turno. O m�todo deve recuperar a hora do
	 * sistema e definir em qual turno a consulta foi efetuada, a partir disso
	 * buscar no banco as viaturas que est�o escaladas naquele turno.
	 * 
	 * @return
	 */
	public List<ViaturaVO> getViaturasEscalaTurno() {
		DAOViatura dViatura = new DAOViatura();
		List<ViaturaVO> retorno = dViatura.findViaturasEscalaAtivas();
		return retorno;
	}

	/**
	 * Descri��o: Este m�todo deve retornar a viatura mais pr�xima da coordenada
	 * passada, deve ser utilizado o Service criado por Theo para fazer os
	 * c�lculos.
	 * 
	 * @param viaturasDesocupadas
	 * @param coordenadaDestino
	 * @return ViaturaVO
	 */
	public ViaturaVO getViaturaProxima(List<ViaturaVO> viaturasDesocupadas,
			CoordenadaVO coordenadasDestino) {

		ViaturaVO viaturaMaisProxima = null;
		double menorDistancia = 0;
		GoogleMaps gmaps;

		for (ViaturaVO vtr : viaturasDesocupadas) {
			CoordenadasBusinessLogic coordenadaBL = new CoordenadasBusinessLogic();
			CoordenadaVO coordenadaViatura = coordenadaBL
					.getUltimaCoordenadaViatura(vtr);
			String origem = coordenadaViatura.getLatitude() + ","
					+ coordenadaViatura.getLongitude();
			double distanciaAtual ;
			gmaps = coordenadaBL.calculaViaturaMaisProxima(origem);
			try {
				distanciaAtual = Double.parseDouble( gmaps.getDistancia());
			} catch (Exception e) {
				// TODO: handle exception
				distanciaAtual = 999999999;
			}
			
			if (viaturaMaisProxima == null) {
				viaturaMaisProxima = vtr;
				menorDistancia = distanciaAtual;
			} else {
				if ((menorDistancia > distanciaAtual) && (distanciaAtual != 0)) {
					viaturaMaisProxima = vtr;
					menorDistancia = distanciaAtual;
				}
			}
		}

		return viaturaMaisProxima;
	}
	
	/**
	 * M�todo que retorna a proxima viatura
	 * @param CoordenadaVO coordenadasDestino
	 * @return ViaturaVO
	 */
	public ViaturaVO getViaturaProxima(CoordenadaVO coordenadasDestino) {
		return getViaturaProxima(getViaturasDesocupadas(), coordenadasDestino);
	}

	/**
	 * Sobrecarga do m�todo getViaturasDesocupadas. Este m�todo por padr�o
	 * retorna as viaturas desocupadas de acordo com turno e escala
	 * [getViaturasEscalasTurno()]
	 * 
	 * @return
	 */
	public List<ViaturaVO> getViaturasDesocupadas() {
		List<ViaturaVO> viaturas = getViaturasEscalaTurno();
		return getViaturasDesocupadas(viaturas);
	}

	/**
	 * Retorna as viaturas desocupadas de acordo com a lista de viaturas
	 * passadas como parametro
	 * 
	 * @param viaturas
	 * @return
	 */
	public List<ViaturaVO> getViaturasDesocupadas(List<ViaturaVO> viaturas) {
		List<ViaturaVO> viaturasDesocupadas = new ArrayList<ViaturaVO>();

		for (ViaturaVO vtr : viaturas) {
			if (!vtr.getOcupada()) {
				viaturasDesocupadas.add(vtr);
			}
		}

		return viaturasDesocupadas;
	}
	
	/**
	 * Retorna uma lista de todos os bairros das escalas atuais da viatura
	 * 
	 * @param viatura
	 * @param dataPesquisa
	 * @return
	 */
	public List<BairroVO> listaBairrosSetorEscalaViatura(String viatura, Calendar dataPesquisa) { 
		DAOViatura dViatura = new DAOViatura();
		return dViatura.findViaturasEscalasBairros(viatura, dataPesquisa);
	}
}
