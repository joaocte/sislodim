package br.com.idez.http;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

public class TransmissaoDados {
	/**
	 * Lembrando que esse m�todo � tempor�rio at� que seja apresentado um
	 * framework para trasmiss�o de dados que abrange transmiss�o HTTP O
	 * framework ser� aprensentado ou desenvolvido na pr�xima aula de
	 * Desenvolvimento para dispositivos m�veis (09/04/2009) Alterar os tipos
	 * para o que melhor adequar
	 */

	/**
	 * Essa classes foi testa com um script php e funcionou corretamente no
	 * nosso caso s� precisa substituir o endere�o da URL
	 */
	private static final String servletHost = "http://localhost/sislodim/index.php?";
	private static TransmissaoDados instance = null;

	private TransmissaoDados() {
	
	}

	public static TransmissaoDados getInstance() {
		if (instance == null) {
			instance = new TransmissaoDados();
		}
		return instance;
	}

	public void enviarDados(double longitude, double latitude, int viatura)
			throws IOException {
		/**
		 * Nesse momento pe�o para o JME abrir uma conex�o pra mim, � o JME
		 * intercede com o device para minha comunica��o
		 */
		HttpConnection conexao = (HttpConnection) Connector.open(servletHost
				+ "longitude=" + longitude + "&latitude=" + latitude
				+ "&viatura=" + viatura);

		// Define o tipo de requisi��o
		conexao.setRequestMethod(HttpConnection.GET);

		/**
		 * Retorno a sa�da da requisi��o em um inputStream caso queira fazer
		 * algum tratamento
		 */
		//InputStream inputStream = conexao.openInputStream();
		//System.out.println(inputStream.toString());

	}

}
