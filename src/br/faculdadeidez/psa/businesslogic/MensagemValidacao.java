package br.faculdadeidez.psa.businesslogic;

import java.util.List;

import br.faculdadeidez.psa.vo.MensagemValidacaoVO;

/**
 * Classe repons�vel por adicionar mensagens de erros 
 *
 */
public class MensagemValidacao {

	/*
	 * Retorna uma String contendo todas os campos que ficaram inv�lidos
	 */
	public static String getMensagensValidacao(List<MensagemValidacaoVO> lista) {
		StringBuilder str = new StringBuilder();

		for (MensagemValidacaoVO msg : lista) {
			if (msg.getInvalido()) {
				str.append(msg.getMensagem());
				str.append(", ");
			}
		}
		str = str.replace(str.length()-2, str.length(), "");
		return str.toString();
	}
	
	/**
	 * M�todo para verificar se as mensagens s�o validas
	 * @param List<MensagemValidacaoVO> lista
	 * @return boolean
	 */
	public static Boolean isValido(List<MensagemValidacaoVO> lista) {

		for (MensagemValidacaoVO msg : lista) {
			if (msg.getInvalido())
				return false;
		}

		return true;
	}
}
