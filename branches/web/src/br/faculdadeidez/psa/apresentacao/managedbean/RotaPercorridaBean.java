package br.faculdadeidez.psa.apresentacao.managedbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import br.faculdadeidez.psa.vo.RotaPercorridaVO;
import br.faculdadeidez.psa.vo.SetorVO;
import br.faculdadeidez.psa.vo.ViaturaVO;

/**
 * ManagedBean de rotas percorridas
 * 
 */
public class RotaPercorridaBean extends GenericoBean {
	/**
	 * Respons�vel por armazenar o conte�do de uma rota
	 */
	private RotaPercorridaVO rotaPercorrida = new RotaPercorridaVO();
	/**
	 * Respons�vel por representar a entidade Setor
	 */
	private SetorVO setorVO = new SetorVO();
	/**
	 * Respons�vel por definir a localidade do tempo
	 */
	private Locale locBr = new Locale("pt", "br");
	/**
	 * Respons�vel por armazenar a data inicial da rota
	 */
	private Calendar periodoInicio = Calendar.getInstance(locBr);
	/**
	 * Respons�vel por armazenar a data final da rota
	 */
	private Calendar periodoFim = Calendar.getInstance(locBr);

	/**
	 * Define se a viatura saiu do setor
	 */
	private Boolean foraDeSetor = false;
	/**
	 * Armazena o tipo de relat�rio a ser gerado
	 */
	private String tipoDeRelatorio;
	/**
	 * Armazena as rotas percorridas
	 */
	private List<RotaPercorridaVO> rotas;
	/**
	 * Respons�vel pelo caminho do relat�rio
	 */
	private String saida;
	/**
	 * Respons�vel pela viatura do filtro
	 */
	private String viatura;

	/**
	 * M�todo que retorna uma lista de SelectItem contendo a lista de viaturas do relat�rio
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getListaViaturas() {
		List<SelectItem> listaViaturas = new ArrayList<SelectItem>();
		SelectItem itemDefault = new SelectItem();
		itemDefault.setLabel("todas");
		itemDefault.setValue("todas");
		listaViaturas.add(itemDefault);

		for (ViaturaVO viatura : getFachada().listarViaturas()) {
			SelectItem selectItem = new SelectItem();
			selectItem.setLabel(viatura.getCodigo());
			selectItem.setValue(viatura.getCodigo());
			listaViaturas.add(selectItem);
		}
		return listaViaturas;
	}

	/**
	 * M�todo getter do atributo saida
	 * @return String
	 */
	public String getSaida() {
		return saida;
	}
	

	/**
	 * M�todo getter do atributo rotaPercorrida
	 * @return RotaPercorridaVO
	 */
	public RotaPercorridaVO getRotaPercorrida() {
		return rotaPercorrida;
	}

	/**
	 * M�todo setter do atributo rotaPercorrida
	 * 
	 * @param rotaPercorrida
	 *            RotaPercorridaVO
	 */
	public void setRotaPercorrida(RotaPercorridaVO rotaPercorrida) {
		this.rotaPercorrida = rotaPercorrida;
	}

	/**
	 * M�todo getter do atributo setorVO
	 * 
	 * @return SetorVO
	 */
	public SetorVO getSetorVO() {
		return setorVO;
	}

	/**
	 * M�todo setter do atributo setorVO
	 * 
	 * @param setorVO
	 *            SetorVO
	 */
	public void setSetorVO(SetorVO setorVO) {
		this.setorVO = setorVO;
	}

	/**
	 * M�todo getter do atributo periodoInicio
	 * 
	 * @return Date
	 */
	public Calendar getPeriodoInicio() {
		return periodoInicio;
	}

	/**
	 * M�todo setter do atributo periodoInicio
	 * 
	 * @param periodoInicio
	 *            Date
	 */
	public void setPeriodoInicio(Calendar periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	/**
	 * M�todo getter do atributo periodoFim
	 * 
	 * @return Calendar
	 */
	public Calendar getPeriodoFim() {
		return periodoFim;
	}

	/**
	 * M�todo setter do atributo periodoFim
	 * 
	 * @param peridoFim
	 *            Calendar
	 */
	public void setPeriodoFim(Calendar peridoFim) {
		this.periodoFim = peridoFim;
	}

	/**
	 * M�todo getter do atributo foraDeSetor
	 * 
	 * @return Boolean
	 */
	public Boolean getForaDeSetor() {
		return foraDeSetor;
	}

	/**
	 * M�todo setter do atributo foraDeSetor
	 * 
	 * @param foraDeSetor
	 *            Boolean
	 */
	public void setForaDeSetor(Boolean foraDeSetor) {
		this.foraDeSetor = foraDeSetor;
	}

	/**
	 * M�todo que retorna as rotas de um periodo
	 * 
	 * @return List<RotaPercorridaVO>
	 */
	public List<RotaPercorridaVO> getRotas() {
		rotas = new ArrayList<RotaPercorridaVO>();
		rotas = getFachada()
				.listarRotas(periodoInicio, periodoFim, foraDeSetor);
		return rotas;

	}

	/**
	 * M�todo que retorna as rotas de um periodo
	 * 
	 * @return List<RotaPercorridaVO>
	 */
	public List<RotaPercorridaVO> getListaTudo() {
		return rotas;
	}

	/**
	 * M�todo getter do atributo tipoDeRelatorio
	 * 
	 * @return String
	 */
	public String getTipoDeRelatorio() {
		if (foraDeSetor) {
			tipoDeRelatorio = "Relat�rio de Rotas Fora do Setor";
		} else {
			tipoDeRelatorio = "Relat�rio de Rotas";
		}
		return tipoDeRelatorio;
	}

	/**
	 * M�todo que define par�metro fora do setor
	 * 
	 * @return String
	 */
	public String viaturaForaDoSetor() {
		foraDeSetor = true;
		getRotas();
		return "exibirRelatorios";

	}

	/**
	 * M�todo que define par�metro fora do setor
	 * 
	 * @return String
	 */
	public String viaturaNoSetor() {
		this.foraDeSetor = false;
		return "exibirRelatorios";

	}
	/**
	 * M�todo getter do atributo viatura
	 * @return String
	 */
	public String getViatura() {
		return viatura;
	}

	/**
	 * M�todo setter do atributo viatura
	 * @param viatura String
	 */
	public void setViatura(String viatura) {
		this.viatura = viatura;
	}

	/**
	 * M�todo respons�vel por gerar no relat�rio
	 * @return String
	 */
	public String geraRelatorio() {
		saida = getFachada().gerarRelatorio(rotas, foraDeSetor);
		return "exibeRelatorio";

	}

}
