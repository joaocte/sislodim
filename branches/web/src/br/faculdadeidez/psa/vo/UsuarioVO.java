package br.faculdadeidez.psa.vo;

import java.io.Serializable;

/**
 * Classe respons�vel por transportar objetoUsuario
 * entre as camadas.
 */
@SuppressWarnings("serial")
public class UsuarioVO implements Serializable{
	/**
	 * Propriedade privada id
	 */
	private int id;
	
	/**
	 * Propriedade privada nome
	 */
	private String nome;
	
	/**
	 * Propriedade privada login
	 */
	private String login;
	
	/**
	 * Propriedade privada senha
	 */
	private String senha;
	
	/**
	 * Propriedade privada ativo
	 */
	private boolean ativo;
	
	/**
	 * Propriedade privada 
	 */
	private String cpf;
	
	/**
	 * Propriedade privada rg
	 */
	private String rg;
	
	/**
	 * Propriedade privada orgExpeditor
	 */
	private String orgExpeditor;
	
	/**
	 * Propriedade privada tipoPermissao
	 */
	private short tipoPermissao;
	
	
	/**
	 * Construtor da classe
	 */
	public UsuarioVO() {
		 
	}
	
	/**
	 * Sobrecarga do construtor padr�o
	 * @param String nome
	 * @param String login
	 * @param String senha
	 * @param String cpf
	 * @param String rg
	 * @param String orgExpeditor
	 * @param short tipoPermissao
	 */
	public UsuarioVO(String nome, String login, String senha, String cpf, String rg, String orgExpeditor, String tipoPermissao) {		
		setSenha(senha);
		setLogin(login);
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		setOrgExpeditor(orgExpeditor);
		setTipoPermissao(Short.valueOf(tipoPermissao));
	}
	
	/**
	 * Sobrecarga do construtor padr�o 
	 * @param String nome
	 * @param String login
	 * @param String senha
	 * @param int id
	 * @param boolean ativo
	 * @param String cpf
	 * @param String rg
	 * @param String orgExpeditor
	 * @param short tipoPermissao
	 */
	public UsuarioVO(String nome, String login, String senha, int id, boolean ativo, String cpf, String rg, String orgExpeditor, String tipoPermissao) {
		setAtivo(ativo);
		setId(id);
		setSenha(senha);
		setLogin(login);
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		setOrgExpeditor(orgExpeditor);
		setTipoPermissao(Short.valueOf(tipoPermissao));
	}
	
	/**
	 * M�todo getter da propriedade tipoPermissao
	 * @return short tipoPermissao
	 */
	public short getTipoPermissao() {
		return tipoPermissao;
	}
	
	/**
	 * M�todo setter da propriedade tipoPermissao
	 * @param short tipoPermissao
	 */
	public void setTipoPermissao(short tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}
	
	/**
	 * M�todo getter da propriedade id
	 * @return int id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * M�todo setter da propriedade id
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * M�todo getter da propriedade nome
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo setter da propriedade nome
	 * @param String nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * M�todo getter da propriedade login
	 * @return String login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * M�todo setter da propriedade login
	 * @param String login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * M�todo getter da propriedade senha
	 * @return String senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * M�todo setter da propriedade senha
	 * @param Senha senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * M�todo getter da propriedade ativo
	 * @return boolean ativo
	 */
	public boolean getAtivo() {
		return ativo;
	}
	
	/**
	 * M�todo setter da propriedade ativo
	 * @param boolean ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	/**
	 * M�todo getter da propriedade cpf
	 * @return String cpf
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * M�todo setter da propriedade cpf
	 * @param String cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("[^0-9]*", "");
	}
	
	/**
	 * M�todo getter da propriedade rg
	 * @return String rg
	 */
	public String getRg() {
		return rg;
	}
	
	/**
	 * M�todo setter da propriedade rg
	 * @param String rg
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	/**
	 * M�todo getter da propriedade orgExpeditor
	 * @return String orgExpeditor
	 */
	public String getOrgExpeditor() {
		return orgExpeditor;
	}
	
	/**
	 * M�todo setter da propriedade orgExpeditor
	 * @param String orgExpeditor
	 */
	public void setOrgExpeditor(String orgExpeditor) {
		this.orgExpeditor = orgExpeditor;
	}	

}
