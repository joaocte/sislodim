package br.faculdadeidez.psa.servico;

public class ComparacaoDistanciaException extends Exception {

	private static final long serialVersionUID = 1L;

	private Integer code;

	public ComparacaoDistanciaException() {

	}

	public ComparacaoDistanciaException(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		String message = null;
		switch (this.code) {
		case 1:
			message = "O campo origem � obrigat�rio";
			break;
		case 2:
			message = "O campo destino � obrigat�rio";
			break;
		case 3:
			message = "Problemas na URL";
			break;
		case 4:
			message = "Problemas Entrada e Sa�da";
			break;
		case 5:	
			message = "Problema n�o identificado";
			break;			
		case 6:
			message = "Endere�o n�o foi encontrado, ou servi�o pode ter sido modificado, verifique o source";
			break;			
		}
		return message;
	}

}