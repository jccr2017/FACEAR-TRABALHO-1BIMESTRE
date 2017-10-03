package br.edu.facear.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.edu.facear.dao.ServicoDAO;
import br.edu.facear.model.Servico;

public class ServicoService {
	
	public Servico autenticar(String email, String senha) throws ClassNotFoundException, IOException {
		
		ServicoDAO dao=new ServicoDAO();
		Servico c = null;
		try {
			c = dao.autenticar(email, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	////////////////////////////
	
	public Servico cadastrar(String nome,String email,String cpf,String celular,String sexo,String cidade,
			String serial,String data,String hora,String defeito,String valorconserto,String status) throws ClassNotFoundException, IOException {
		ServicoDAO dao=new ServicoDAO();
		Servico c=null;
		
		try {
			c=dao.cadastrar(nome,email,cpf,celular,sexo,cidade,
					serial,data,hora,defeito,valorconserto,status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	public List<Servico> listaServicos() throws ClassNotFoundException, IOException{
		ServicoDAO dao=new ServicoDAO();
		List<Servico> listaServico=null;
		try {
			listaServico = dao.listarServicos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaServico;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Servico obterServicoPorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
		ServicoDAO dao=new ServicoDAO();
		Servico c=dao.obterServicoPorId(id);
		return c;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	public void excluir(String id) throws SQLException, ClassNotFoundException, IOException {
		ServicoDAO dao=new ServicoDAO();
		
		dao.excluir(id);
	}
	

	///////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void alterar(String id,String nome,String email,String cpf,String celular,String sexo,String cidade,
			String serial,String data,String hora,String defeito,String valorconserto,String status) throws SQLException, ClassNotFoundException, IOException {
		ServicoDAO dao=new ServicoDAO();
		
		dao.alterar(id,nome,email,cpf,celular,sexo,cidade,
				serial,data,hora,defeito,valorconserto,status);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	public Servico achacpf(String cpf) throws ClassNotFoundException, IOException {
		
		ServicoDAO dao=new ServicoDAO();
		Servico c = null;
		try {
			c = dao.achacpf(cpf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	
	

}
