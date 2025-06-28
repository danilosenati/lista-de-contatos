package model;

public class JavaBeans {
	private int idContato;
	private String nome;
	private String telefone;
	private String email;
	
	// CONSTRUTOR PADRÃO
	public JavaBeans() {
		super();
	}
	
	// CONSTRUTOR COM PARAMETRO
	
	public JavaBeans(int idContato, String nome, String telefone, String email) {
		super();
		this.idContato = idContato;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	
	public int getIdContato() {
		return idContato;
	}
	

	public void setIdContato(int id) {
		this.idContato = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}