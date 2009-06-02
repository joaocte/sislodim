package br.faculdadeidez.psa.apresentacao.servlets;

import java.util.EventListener;
import java.util.EventObject;

import org.ajax4jsf.event.PushEventListener;

/**
 * Classe que faz o monitoramento do mapa
 *
 */
public class AtualizaMapa implements Runnable {

	/**
	 * Ouvinte no lado do servidor para execu��o do ajax
	 */
	PushEventListener listener;

	/**
	 * Propriedade que define se o monitoramento est� ativado
	 */
	private boolean enabled = false;

	/**
	 * Thread que faz a atualiza��o de tempos em tempos
	 */
	private Thread thread;

	/**
	 * M�todo principal da Thread
	 */
	@Override
	public void run() {
		while (thread != null) {
			try {
				listener.onEvent(new EventObject(this));
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
		}

	}

	/**
	 * Captura o listener do evento
	 * @param listener EventListener
	 */
	public void addListener(EventListener listener) {
		synchronized (listener) {
			if (this.listener != listener) {
				this.listener = (PushEventListener) listener;
			}
		}
	}


	/**
	 * Inicia a execu��o da Thread
	 */
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.setDaemon(true);
			thread.start();
			setEnabled(true);
		}
	}

	/**
	 * Para execu��o da Thread
	 */
	public void stop() {
		if (thread != null) {
			setEnabled(false);
			thread = null;
		}
	}


	/**
	 * M�todo getter do atributo enabled
	 * @return boolean
	 */
	public boolean getEnabled() {
		return enabled;
	}

	/**
	 * M�todo setter do atributo enabled
	 * @param enabled boolean
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}