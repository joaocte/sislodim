package br.com.idez.ddm.tourguide.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

import br.com.idez.ddm.tourguide.core.Record;
import br.com.idez.ddm.tourguide.core.UIController;

public class Sincronizacao extends Form implements CommandListener {

	private static Sincronizacao instance;

	private StringItem siTexto;

	private Command cmdCancelar;

	public Sincronizacao(String title) {
		super(title);

		siTexto = new StringItem("Deseja realmente iniciar a sincroniza��o?",
				null);

		cmdCancelar = new Command("Cancelar", Command.CANCEL, 1);
		addCommand(new Command("Sincronizar", Command.OK, 1));

		this.append(siTexto);

		this.addCommand(cmdCancelar);

		this.setCommandListener(this);
	}

	public static Sincronizacao getInstance() {
		if (instance == null) {
			instance = new Sincronizacao("Sincroniza��o");
		}
		return instance;
	}

	public void commandAction(Command cmd, Displayable displayable) {
		if (cmd.equals(cmdCancelar)) {
			System.out.println("VOLTAR Selecionado");
			try {
				UIController.getInstance().voltar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			conectar();
		}
	}

	public void conectar() {
		System.out.println("Criando Thread");
		siTexto = new StringItem("Sincronizando", null);

		new Thread(new Runnable() {

			public void run() {
				boolean automatica=false;
				do {
					try {
						UIController.getInstance().sincronizar(automatica);
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(Integer
								.parseInt(Record.getConfigMaxTime()) * 10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					automatica=true;
				} while (Record.getConfigSync().equals("ON"));

			}

		}).start();

	}

}
