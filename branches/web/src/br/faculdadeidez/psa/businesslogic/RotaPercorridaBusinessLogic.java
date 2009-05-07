package br.faculdadeidez.psa.businesslogic;

import java.util.List;

import br.faculdadeidez.psa.db.dao.DAOCoordenada;
import br.faculdadeidez.psa.db.dao.DAOUsuario;
import br.faculdadeidez.psa.vo.CoordenadaVO;
import br.faculdadeidez.psa.vo.MensagemValidacaoVO;
import br.faculdadeidez.psa.vo.RotaPercorridaVO;
import br.faculdadeidez.psa.vo.UsuarioVO;

public class RotaPercorridaBusinessLogic {

	public List<CoordenadaVO> listar() {
		DAOCoordenada dCoordenada = new DAOCoordenada();
		return dCoordenada.findAll();
	}
	
	public List<CoordenadaVO> listarForaDeArea(){
		DAOCoordenada dCoordenada = new DAOCoordenada();
		return dCoordenada.findByField("foraDeArea", "true");
	}
	
}
