package br.com.idez.ui;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

import br.com.idez.core.UIController;
import br.com.idez.ui.util.Alerta;

public class ConsultarVeiculo extends Form implements CommandListener{
	private static ConsultarVeiculo instance;
	
	private Command cmdBack;
	private Command cmdOk;		
	private TextField txtPlacaVeiculo;
	
	private ConsultarVeiculo(String title) {
		super(title);
		this.append("Digite a placa do ve�culo que deseja pesquisar: ");
		
		this.txtPlacaVeiculo = new TextField("Placa do ve�culo: ", null, 7, TextField.ANY);		
		this.cmdBack = new Command("Voltar", Command.BACK, 1);
		this.cmdOk = new Command("Ok", Command.OK, 1);
		
		this.append(txtPlacaVeiculo);

		this.addCommand(cmdBack);
		this.addCommand(cmdOk);
		
		this.setCommandListener(this);
	}
	
	public static ConsultarVeiculo getInstance() {
		if (instance == null) {
			instance = new ConsultarVeiculo("1. Consultar Ve�culos");
		}
		return instance;		
	}
	
	public void commandAction(Command cmd, Displayable disp) {
		
		if (cmd.equals(cmdOk)) {
			/**
			 * Consulta informa��es do ve�culo em um servi�o
			 */
			try {	
				System.out.println("Iniciando consulta de ve�culo...");
				
				if(this.txtPlacaVeiculo.getString().equals("")) {
					UIController.getInstance().setCurrent(Alerta.getInstance("Voc� deve informar a placa do ve�culo", 1));				
				}
				else { 				
					UIController.getInstance().consultaVeiculo(this.txtPlacaVeiculo.getString());
				}
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
