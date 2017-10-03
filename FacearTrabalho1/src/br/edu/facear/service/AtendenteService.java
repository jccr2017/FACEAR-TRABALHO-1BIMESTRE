package br.edu.facear.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.edu.facear.dao.AtendenteDAO;
import br.edu.facear.model.Atendente;

public class AtendenteService {
	
	
	public Atendente cadastrar(String nome,String email,String cpf,
			String celular,String idade,String sexo,String cidade,String senha) throws ClassNotFoundException, IOException {
		AtendenteDAO dao=new AtendenteDAO();
		Atendente c=null;
		
		try {
			c=dao.cadastrar( nome, email, cpf,
					 celular, idade, sexo, cidade,senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	public Atendente autenticar(String email, String senha) throws ClassNotFoundException, IOException {
		
		AtendenteDAO dao=new AtendenteDAO();
		Atendente c = null;
		try {
			c = dao.autenticar(email, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/////////////////////////////////////////////////////////////
	
	public void alterar(String id,String nome, String email, String cpf,
			String celular,String idade,String sexo,String cidade,String senha) throws SQLException, ClassNotFoundException, IOException {
		AtendenteDAO dao=new AtendenteDAO();
		
		dao.alterar(id,nome, email, cpf,
				 celular, idade, sexo, cidade,
				 senha);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	public Atendente obterAtendentePorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
		AtendenteDAO dao=new AtendenteDAO();
		Atendente c=dao.obterAtendentePorId(id);
		return c;
	}
	
	
	///////////////////////////////////////////////////////]
	
	
	public List<Atendente> listaAtendentees() throws ClassNotFoundException, IOException{
		AtendenteDAO dao=new AtendenteDAO();
		List<Atendente> listaAtendente=null;
		try {
			listaAtendente = dao.listarAtendentees();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaAtendente;
	}
	
	////////////////////////////////////////////////////////////////////////////////
	
	public void excluir(String id) throws SQLException, ClassNotFoundException, IOException {
		AtendenteDAO dao=new AtendenteDAO();
		
		dao.excluir(id);
	}
	
	

}
