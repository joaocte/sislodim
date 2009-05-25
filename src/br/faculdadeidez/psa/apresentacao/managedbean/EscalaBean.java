package br.faculdadeidez.psa.apresentacao.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.faculdadeidez.psa.vo.EscalaVO;
import br.faculdadeidez.psa.vo.ViaturaVO;

public class EscalaBean extends GenericoBean {
	/**
	 * Respons�vel por mostrar os objetos na tabela gen�rica
	 */
	private List<EscalaVO> listaTudo = null;
	/**
	 * Respons�vel por representar a entidade Escala
	 */
	private EscalaVO escala = new EscalaVO();
	/**
	 * M�todo getter do atributo escala
	 * @return EscalaVO
	 */
	public EscalaVO getEscala() {
		return escala;
	}

	/**
	 * M�todo setter do atributo escala
	 * @param escala EscalaVO
	 */
	public void setEscala(EscalaVO escala) {
		this.escala = escala;
	}

	/**
	 * M�todo getter do atributo listaTudo
	 * @return List<EscalaVO>
	 */
	public List<EscalaVO> getListaTudo() {
		if (listaTudo == null || canUpdate())
			setListaTudo(getFachada().listarEscalas());
		return listaTudo;
	}

	/**
	 * M�todo que envia os dados para deletar a escala
	 * @return String
	 */
	public String delete() {
		EscalaVO escalaDaVez = (EscalaVO) getElementoSelecionado();
		String mensagem = getFachada().deleteEscala(escalaDaVez);
		adicionaMensagemUsuario(mensagem);
		
		// for�a atualiza��o
		setListaTudo(null);
		
		return mensagem;
	}

	/**
	 * M�todo que envia os dados a serem atualizados
	 * @return String
	 */
	public String update() {
		EscalaVO escalaDaVez = (EscalaVO) getElementoSelecionado();
		escalaDaVez.setViaturas(escala.getViaturas());		
		String mensagem = getFachada().updateEscala(escalaDaVez);
		adicionaMensagemUsuario(mensagem);		
		setElementoSelecionado(null);
		
		// for�a atualiza��o
		setListaTudo(null);
		
		return mensagem;
	}

	/**
	 * M�todo que envia os dados para escala ser cadastrada
	 * @return
	 */
	public String create() {			
		String mensagem = getFachada().createEscala(escala);
		setEscala(new EscalaVO());
		adicionaMensagemUsuario(mensagem);
		return mensagem;
	}

	/**
	 * M�todo que envia os dados para pesquisar nas escalas cadastradas
	 */
	public void pesquisar() {		
		if (getTermoPesquisa() == "") {
			setListaTudo(getFachada().listarEscalas());
		} else {
			int codigoSetor = 0;
			
			// valida��o
			try { 
				codigoSetor = Integer.parseInt(getTermoPesquisa());
			}
			catch(Exception exc) {
				// ocorreu um erro tentando converter, este n�o � um n�mero v�lido
				adicionarMensagemErro("Este n�o � um c�digo de escala v�lido!");
				
				// por padr�o, lista tudo
				setListaTudo(getFachada().listarEscalas());
				return;
			}
			
			List<EscalaVO> escalas = getFachada().pesquisaEscala(codigoSetor);
			if (escalas.isEmpty())
				adicionarMensagem("Nenhuma escala foi encontrada!");
			else {
				if (escalas.size() > 1)
					adicionarMensagem("Foram encontrados " + escalas.size()
							+ " resultados para a busca por "
							+ getTermoPesquisa());
				else
					adicionarMensagem("Foi encontrado " + escalas.size()
							+ " resultado para a busca por "
							+ getTermoPesquisa());
				setListaTudo(escalas);
			}
		}
	}

	/**
	 * M�todo setter do atributo listaTudo
	 * @param listaTudo
	 */
	public void setListaTudo(List<EscalaVO> listaTudo) {
		this.listaTudo = listaTudo;
	}

	/**
	 * M�todo que adiciona uma mensagem a ser mostrada para o usu�rio
	 * @param mensagem String
	 */
	private void adicionaMensagemUsuario(String mensagem) {
		if (mensagem.equals("escalaExistente")) {
			adicionarMensagem("Escala j� existe");
		} else if (mensagem.equals("problemaInserir")) {
			adicionarMensagem("Houve um problema ao tentar criar a escala,\n contacte o administrador");
		} else if (mensagem.equals("inserido")) {
			adicionarMensagem("Escala criada com sucesso!");
			setEscala(new EscalaVO());
		} else if (mensagem.equals("dadoInvalido")) {
			adicionarMensagem("Estes dados n�o s�o v�lidos");
		} else if (mensagem.equals("removido"))
			adicionarMensagem("Deletado com sucesso!");
		else if (mensagem.equals("problemaRemover")) {
			adicionarMensagem("Houve um problema ao tentar remover,\n contacte o administrador");
		} else if (mensagem.equals("atualizado"))
			adicionarMensagem("Atualizado com sucesso!");
		else if (mensagem.equals("escalaInexistente")) {
			adicionarMensagem("Escala n�o existe no banco de dados");
		} else if (mensagem.equals("problemaAtualizar")) {
			adicionarMensagem("Houve um problema ao tentar atualizar,\n contacte o administrador");
		} else if (mensagem.equals("datafim_ant_dataini")) {
			adicionarMensagemErro("N�o � poss�vel cadastrar uma escala com data final anterior a data inicial.");
		} else if (mensagem.equals("dataini_ant_dataatual")) { 
			adicionarMensagemErro("N�o � poss�vel cadastrar uma escala com data inicial anterior a atual.");
		} else if (mensagem.startsWith("mesma_viatura_escalas_diferentes")) {
			String codigoViatura = mensagem.substring(mensagem.indexOf('|')+1);
			adicionarMensagemErro("A viatura '"+ codigoViatura +"' j� est� definida em outra escala entre esta data inicial e final.");
		} else {
			adicionarMensagem(mensagem);
		}
	}

	/**
	 * M�todo que define as viaturas de uma escala
	 * @param listaViaturas
	 */
	public void setViaturasEscala(List<String> listaViaturas) {
		List<ViaturaVO> viaturas = new ArrayList<ViaturaVO>();
		for (String chave : listaViaturas) {
			viaturas.add(getFachada().pesquisaViatura(chave));
		}
		escala.setViaturas(viaturas);
	}
	/**
	 * M�todo que retorna as viaturas da escala
	 * @return List<String>
	 */
	public List<String> getViaturasEscala() {
		if (getElementoSelecionado() != null) {
			List<String> listaAtuais = new ArrayList<String>();
			List<ViaturaVO> viaturas = ((EscalaVO) getElementoSelecionado())
					.getViaturas();

			for (ViaturaVO viaturaVO : viaturas) {
				listaAtuais.add(String.valueOf(viaturaVO.getCodigo()));
			}
			return listaAtuais;
		}
		return null;
	}
	/**
	 * M�todo que retorna uma lista de SelectItem contendo as viaturas escaladas para aquele turno
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getListaViaturas() {
		List<SelectItem> listItensViaturas = new ArrayList<SelectItem>();
		SelectItem selectItem;
		List<ViaturaVO> viaturas = getFachada().pesquisarViaturasEscalaTurno();

		if (viaturas.size() > 0) {
			for (ViaturaVO viatura : viaturas) {
				selectItem = new SelectItem(); 
				selectItem.setLabel(viatura.getCodigo());
				selectItem.setValue(viatura.getCodigo());
				listItensViaturas.add(selectItem);
			}
		} else {
			selectItem = new SelectItem();
			selectItem.setLabel("Nenhuma viatura escalada");
			selectItem.setValue("x");
			listItensViaturas.add(selectItem);
		}
		return listItensViaturas;
	}

}
