package br.faculdadeidez.psa.apresentacao.managedbean;

import java.util.List;

import br.faculdadeidez.psa.vo.ViaturaVO;

public class ViaturaBean extends GenericoBean {
	private List<ViaturaVO> listaTudo = null;
	private ViaturaVO viatura = new ViaturaVO();
	private String termoPesquisa = new String();

	public ViaturaVO getViatura() {
		return viatura;
	}

	public void setViatura(ViaturaVO viatura) {
		this.viatura = viatura;
	}

	public List<ViaturaVO> getListaTudo() {
		if (listaTudo == null || listaTudo.isEmpty()
				|| getTermoPesquisa().isEmpty())
			setListaTudo(getFachada().listarViaturas());
		else
			setTermoPesquisa(new String());
		return listaTudo;
	}

	public String delete() {
		ViaturaVO viaturaDaVez = (ViaturaVO) getElementoSelecionado();
		String mensagem= getFachada().deleteViatura(viaturaDaVez);
		if (mensagem.equals("removido"))
			adicionarMensagem("Deletado com sucesso!");
		return mensagem;
		
	}

	public String update() {
		ViaturaVO viaturaDaVez = (ViaturaVO) getElementoSelecionado();
		String mensagem=getFachada().updateViatura(viaturaDaVez);
		if (mensagem.equals("atualizado"))
			adicionarMensagem("Atualizado com sucesso!");
		return mensagem;
	}

	public String create() {
		String mensagem = getFachada().createViatura(viatura);

		if (mensagem.equals("viaturaExistente")) {
			adicionarMensagem("Viatura já existe");
		} else if (mensagem.equals("problemaInserir")) {
			adicionarMensagem("Error...");
		} else { 
			adicionarMensagem("Viatura criada com sucesso!");
			setViatura(new ViaturaVO());
			//redirecionaPagina("adminViatura.st?id=1", mensagem);
			
		}
		return mensagem;
	}

	public void pesquisar() {
		if (getTermoPesquisa().isEmpty()) {
			setListaTudo(getFachada().listarViaturas());
		} else {
			List<ViaturaVO> viaturas = getFachada().pesquisaViatura(
					getTermoPesquisa());
			if (viaturas.isEmpty())
				adicionarMensagem("Nenhuma viatura foi encontrada!");
			setListaTudo(viaturas);
		}
	}

	public void setListaTudo(List<ViaturaVO> listaTudo) {
		this.listaTudo = listaTudo;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

}
