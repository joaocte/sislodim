package br.com.idez.ui;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

import br.com.idez.core.UIController;

public class ConsultarOcorrenciaResultado extends Form implements CommandListener{
	private static ConsultarOcorrenciaResultado instance;
	
	private Command cmdBack;
	private Command cmdOk;	
	private TextField txtPlacaVeiculo;
	private StringItem lblProprietario;
	private StringItem lblCPF;
	private TextField txtOcorrencia;
		
	private ConsultarOcorrenciaResultado(String title, String xml) {
		super(title);
		
		this.txtPlacaVeiculo = new TextField("Placa do ve�culo: ", null, 7, TextField.ANY);
		this.lblProprietario = new StringItem("Nome: ", "");
		this.lblCPF = new StringItem("CPF: ", "");
		this.txtOcorrencia = new TextField("Ocorr�ncia: ", "", 255, TextField.UNEDITABLE);
			
		this.append(txtPlacaVeiculo);
		this.append(new ImageItem("", null, ImageItem.LAYOUT_NEWLINE_AFTER, ""));
		this.append(lblProprietario);
		this.append(new ImageItem("", null, ImageItem.LAYOUT_NEWLINE_AFTER, ""));		
		this.append(lblCPF);
		this.append(new ImageItem("", null, ImageItem.LAYOUT_NEWLINE_AFTER, ""));
		this.append(txtOcorrencia);
		
		this.cmdBack = new Command("Voltar", Command.BACK, 1);
		this.cmdOk = new Command("Ok", Command.OK, 1);
		
		processaXmlRecebido(xml);
		
		this.addCommand(cmdBack);
		this.addCommand(cmdOk);	
		
		this.setCommandListener(this);
	}
	
	private void processaXmlRecebido(String xml) { 
		
	}
	
	public static ConsultarOcorrenciaResultado getInstance(String retornoXML) {
		if (instance == null) {
			instance = new ConsultarOcorrenciaResultado("3. Consultar Ocorr�ncias", retornoXML);
		}
				
		return instance;		
	}
	
	public void commandAction(Command cmd, Displayable disp) {
		
		if (cmd.equals(cmdBack)) {
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
