package br.com.idez.ui;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

import br.com.idez.core.UIController;

public class ConsultarOcorrencia extends Form implements CommandListener{
	private static ConsultarOcorrencia instance;
	
	private Command cmdBack;
	private Command cmdOk;	
	
	private ConsultarOcorrencia(String title) {
		super(title);
		this.append("Digite a placa do ve�culo para pesquisar ocorr�ncias relacionadas ao ve�culo: ");
		this.append(new TextField("Placa do ve�culo: ", null, 7, TextField.ANY));
		
		this.cmdBack = new Command("Voltar", Command.BACK, 1);
		this.cmdOk = new Command("Ok", Command.OK, 1);
		
		this.addCommand(cmdBack);
		this.addCommand(cmdOk);	
		
		this.setCommandListener(this);
	}
	
	public static ConsultarOcorrencia getInstance() {
		if (instance == null) {
			instance = new ConsultarOcorrencia("3. Consultar Ocorr�ncias");
		}
		return instance;		
	}
	
	public void commandAction(Command cmd, Displayable disp) {
		
		if (cmd.equals(cmdOk)) {
			/**
			 * Consulta ocorr�ncias em um servi�o
			 */
			try {	
				System.out.println("Iniciando consulta de ocorr�ncia...");
				//UIController.getInstance().login(tfLogin.getString(), tfSenha.getString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (cmd.equals(cmdBack)) {
			/**
			 * Volta a aplica��o para a tela anterior, que nesse caso � o menu
			 */
			try {	
				UIController.getInstance().voltar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}		

}
