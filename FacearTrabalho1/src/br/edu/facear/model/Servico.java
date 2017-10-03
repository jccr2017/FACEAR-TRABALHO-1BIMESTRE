package br.edu.facear.model;

public class Servico {
	
	
	/////////////////////////// ESTA CLASSE REPRESENTA A CLASSE SERVIÇO////////////////////////
	
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private String celular;
	private String sexo;
	private String cidade;
	private String serial;
	private String data;
	private String hora;
	private String valorconserto;
	private String defeito;
	private String status;
	
	
	
	
	
	
	
	
	public Servico(Integer id, String nome, String email, String cpf, String celular, String sexo, String cidade,
			String serial, String data, String hora, String valorconserto, String defeito, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.celular = celular;
		this.sexo = sexo;
		this.cidade = cidade;
		this.serial = serial;
		this.data = data;
		this.hora = hora;
		this.valorconserto = valorconserto;
		this.defeito = defeito;
		this.status = status;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getValorconserto() {
		return valorconserto;
	}
	public void setValorconserto(String valorconserto) {
		this.valorconserto = valorconserto;
	}
	public String getDefeito() {
		return defeito;
	}
	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

    

}
