package br.com.faculdadeidez.ddm.streetrunner;

import java.util.Vector;

import javax.microedition.lcdui.game.Sprite;

public class Pista extends Thread {
	public static final int ESQUERDA_DIREITA = 1;
	public static final int DIREITA_ESQUERDA = 2;

	private Vector veiculos;
	private int sentido;
	private int timer;
	private int larguraVeiculo;
	private int larguraTela;

	public Pista() {
		veiculos = new Vector();
		this.sentido = ESQUERDA_DIREITA;
		this.larguraTela = 320;
		this.larguraVeiculo = 32;
	}

	public Pista(int sentido, int larguraVeiculo, int larguraTela) {
		veiculos = new Vector();
		this.sentido = sentido;
		this.larguraTela = larguraTela;
		this.larguraVeiculo = larguraVeiculo;
	}

	public int getLarguraVeiculo() {
		return larguraVeiculo;
	}

	public void setLarguraVeiculo(int largura_veiculo) {
		this.larguraVeiculo = largura_veiculo;
	}

	public int getLarguraTela() {
		return larguraTela;
	}

	public void setLarguraTela(int largura_tela) {
		this.larguraTela = largura_tela;
	}

	public void addVeiculo(Sprite veiculo) {
		veiculos.addElement(veiculo);
	}

	public int getSentido() {
		return sentido;
	}

	public void setSentido(int sentido) {
		this.sentido = sentido;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public void run() {
		while (true) {
			atualizarPosicoes();
			try {
				sleep(timer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void atualizarPosicoes() {
		if (this.sentido == DIREITA_ESQUERDA) {
			for (int i = 0; i < veiculos.size(); i++) {
				Sprite veiculo = (Sprite) veiculos.elementAt(i);
				int x;

				x = veiculo.getX();
				if ((x + this.larguraVeiculo) < 0) {
					x = larguraTela;
				}

				veiculo.setPosition(x - 1, veiculo.getY());
			}
		} else if (this.sentido == ESQUERDA_DIREITA) {
			for (int i = 0; i < veiculos.size(); i++) {
				Sprite veiculo = (Sprite) veiculos.elementAt(i);
				int x;

				x = veiculo.getX();
				if (x > larguraTela) {
					x = 0;
				}

				veiculo.setPosition(x + 1, veiculo.getY());
			}
		}
	}
	
	public Vector getVeiculos(){
		return this.veiculos;
	}
}
