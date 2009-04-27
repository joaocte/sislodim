package br.faculdadeidez.psa.businesslogic;

import java.util.ArrayList;
import java.util.List;

import br.faculdadeidez.psa.db.dao.DAOBairro;
import br.faculdadeidez.psa.db.dao.DAOViatura;
import br.faculdadeidez.psa.vo.BairroVO;
import br.faculdadeidez.psa.vo.MensagemValidacaoVO;
import br.faculdadeidez.psa.vo.SetorVO;
import br.faculdadeidez.psa.vo.ViaturaVO;

public class ViaturaBusinessLogic {
	public String delete(ViaturaVO vo){
		try {
			DAOViatura dViatura = new DAOViatura();
			if(dViatura.findByField("codigo", vo.getCodigo()).isEmpty())
				return "viaturaInexistente";
			ViaturaVO via = dViatura.find(vo.getCodigo());
			via.setAtivo(false);
			dViatura.update(via);
			return "removido";
		} catch (Exception e) {
			// TODO: handle exception
			return "problemaRemover";
		}
	}
	
	public String update(ViaturaVO vo){
		try {
			// valida os dados inseridos
			List<MensagemValidacaoVO> erros = validaDados(vo);
			
			if(!MensagemValidacao.isValido(erros))
				return MensagemValidacao.getMensagensValidacao(erros);			
			
			DAOViatura dViatura = new DAOViatura();							
			if(dViatura.findByField("codigo", vo.getCodigo()).isEmpty() && vo.getCodigo() != null)
				return "viaturaInexistente";
			dViatura.update(vo);
			if (vo.getAtivo())
			return "atualizado";
			else return "atualizadoDeletado";
		} catch (Exception e) {
			// TODO: handle exception
			return "problemaAtualizar";
		}
	}
	
	public String create(ViaturaVO vo){
		try {
			// valida os dados inseridos
			List<MensagemValidacaoVO> erros = validaDados(vo);
			
			if(!MensagemValidacao.isValido(erros))
				return MensagemValidacao.getMensagensValidacao(erros);
			
			DAOViatura dViatura = new DAOViatura();	
			if(dViatura.findByField("codigo", vo.getCodigo()).isEmpty()){	
				dViatura.persist(vo);
				return "inserido";
			}else
				return "viaturaExistente";
		} catch (Exception e) {
			// TODO: handle exception
			return "problemaInserir";
		}
	}
	

	public List<ViaturaVO> listar(){
		DAOViatura dViatura = new DAOViatura();
		return dViatura.findAll();		
	}
	
	public List<ViaturaVO> listarAtivos(){
		DAOViatura dViatura = new DAOViatura();
		return dViatura.findAllActivated();		
	}
	
	public List<ViaturaVO> pesquisar(String valor){
		DAOViatura dViatura = new DAOViatura();
		List<ViaturaVO> retorno = dViatura.findByField("codigo", valor);
		return retorno;
	}
	
	private List<MensagemValidacaoVO> validaDados(ViaturaVO vo){
		ArrayList<MensagemValidacaoVO> erros = new ArrayList<MensagemValidacaoVO>();
		
		erros.add(new MensagemValidacaoVO("C�digo", "O c�digo � obrigat�rio", Boolean.valueOf(vo.getCodigo().isEmpty())));
		erros.add(new MensagemValidacaoVO("C�digo", "O c�digo deve ser menor que 4 d�gitos", Boolean.valueOf(vo.getCodigo().length() > 4)));
		erros.add(new MensagemValidacaoVO("C�digo", "O c�digo deve ser apenas d�gitos", Boolean.valueOf(!vo.getCodigo().matches("^[0-9]*$"))));
		return erros;
	}
	
	public ViaturaVO find(String chave){
		return new DAOViatura().find(chave);
	}
}
