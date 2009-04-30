package br.com.idez.http;

import java.io.DataInputStream;
import java.io.IOException;

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
	private static final String servletHost = "http://localhost:8080/Sislodim/MIDServlet?";
	private static TransmissaoDados instance = null;

	private TransmissaoDados() {

	}

	public static TransmissaoDados getInstance() {
		if (instance == null) {
			instance = new TransmissaoDados();
		}
		return instance;
	}

	public void enviarDados(double longitude, double latitude, String viatura)
			throws IOException {
		/**
		 * Nesse momento pe�o para o JME abrir uma conex�o pra mim, � o JME
		 * intercede com o device para minha comunica��o
		 */
		 HttpConnection conexao = (HttpConnection) Connector.open(servletHost
		 + "longitude=" + longitude + "&latitude=" + latitude
		 + "&codVtr=" + viatura);
		

		// Define o tipo de requisi��o
		conexao.setRequestMethod(HttpConnection.GET);
		DataInputStream stream = conexao.openDataInputStream();
		String content = conexao.getHeaderField("Content-Type");
		System.out.println("Content-Type: " + content);

		String agent = conexao.getHeaderField("User-Agent");
		System.out.println("User-Agent: " + agent);

		String server = conexao.getHeaderField("Server");
		System.out.println("Server: " + server);

		System.out.println("Response: " + conexao.getResponseMessage());
		System.out.println("Response Code: " + conexao.getResponseCode());

		/**
		 * Retorno a sa�da da requisi��o em um inputStream caso queira fazer
		 * algum tratamento
		 */
		// InputStream inputStream = conexao.openInputStream();
		// System.out.println(inputStream.toString());
	}

}
