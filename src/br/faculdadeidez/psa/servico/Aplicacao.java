package br.faculdadeidez.psa.servico;

public class Aplicacao {
public static void main(String[] args) {
	ComparacaoDistancia c = new ComparacaoDistancia();
		c.setOrigem("Santa Rita, PB");
		c.setDestino("Jo�o Pessoa, PB");
		System.out.println(c.getDistancia());
	}
}
