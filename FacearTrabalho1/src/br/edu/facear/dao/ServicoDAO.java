package br.edu.facear.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Servico;
import br.edu.facear.service.ServicoService;

public class ServicoDAO extends GenericDAO{
	
	private PreparedStatement ps;
	
	private String LOGIN_SQL ="SELECT * FROM servico WHERE EMAIL = ? AND SENHA = ?;";
	
	private String LISTAR_Servico="SELECT * FROM  servico;";
	private String EXCLUIR_Servico="DELETE FROM  servico WHERE ID=?;";
	private String ALTERAR_Servico="UPDATE  servico SET nome=?,email=?,cpf=?,celular=?,sexo=?,cidade=?,serial=?,data=?,hora=?,defeito=?,valorconserto=?,status=? WHERE id=?;";

	private String SELECIONA="SELECT * FROM  servico WHERE ID=?;";
	
	private String ACHACPF="SELECT * FROM servico WHERE cpf=?";
	
	private String CADASTRAR_SQL ="INSERT INTO servico (nome,email,cpf,celular,sexo,cidade,"
			+ "serial,data,hora,defeito,valorconserto,status) values(?,?,?,?,?,?,?,?,?,?,?,?"
			+ ");";

	
	public Servico cadastrar(String nome,String email,String cpf,String celular,String sexo,String cidade,
			String serial,String data,String hora,String defeito,String valorconserto,String status)
					throws SQLException, ClassNotFoundException, IOException {
		Servico c=null;
		
		//Abrir conexão
		openConnection();
		
		//Preparar script
		ps = connect.prepareStatement(CADASTRAR_SQL);
		ps.setString(1, nome);
		ps.setString(2, email);
		ps.setString(3, cpf);
		ps.setString(4, celular);
		ps.setString(5, sexo);
		ps.setString(6, cidade);
		ps.setString(7, serial);
		ps.setString(8, data);
		ps.setString(9, hora);
		ps.setString(10,defeito);
		ps.setString(11,valorconserto);
		ps.setString(12, status);
		
		
		
		ps.executeUpdate();
		
		/*ResultSet rs=ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				c=new Servico(rs.getInt("id"), rs.getString(rs.getString("nome")), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
			}
		}*/
		
		//Fechar conexão
		closeConnection();
		
		return c;
	}
	
	
	//private String PROCURAR="SELECT * FROM produto WHERE  nome LIKE ?";
	
	public Servico autenticar(String email, String senha) throws SQLException, ClassNotFoundException, IOException {
		Servico c=null;
		//Abrir uma conexão
		openConnection();
		
		//Preparar o script
		ps = connect.prepareStatement(LOGIN_SQL);
		ps.setString(1, email);
		ps.setString(2, senha);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs != null)
			while(rs.next()) {
				c=new Servico(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),
						rs.getString("cpf")
						,rs.getString("celular"),rs.getString("sexo"),rs.getString("cidade"),
						rs.getString("serial"),rs.getString("data"),rs.getString("hora"),
						rs.getString("valorconserto"),rs.getString("defeito"),rs.getString("status"));
			}
		
		//Fechar a conexão
		closeConnection();
		
		return c;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////


	///////////////////////////////////////////////////////////////////////////////////////////
	
	public List<Servico> listarServicos() throws ClassNotFoundException, IOException, SQLException{
		List<Servico> lista = new ArrayList<Servico>();
		// Abrir conexão
		openConnection();
		
		// Executar o script
		ps = connect.prepareStatement(LISTAR_Servico);
		ResultSet rs = ps.executeQuery();
		
		//Analisar o retorno do script
		if(rs != null){
			while(rs.next()){
				Servico c = new Servico(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),
						rs.getString("cpf")
						,rs.getString("celular"),rs.getString("sexo"),rs.getString("cidade"),
						rs.getString("serial"),rs.getString("data"),rs.getString("hora"),
						rs.getString("valorconserto"),rs.getString("defeito"),rs.getString("status"));
				lista.add(c);
			}
		}
		
		closeConnection();
		
		return lista;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	public Servico obterServicoPorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
		Servico c=null;
		ServicoService service=new ServicoService();
		List<Servico> listaServico=service.listaServicos();
		
		openConnection();
		
		ps=connect.prepareStatement(SELECIONA);
		ps.setInt(1, id);
		
		for(int i=0;i<listaServico.size();i++) {
			if(id==listaServico.get(i).getId()) {
				c=listaServico.get(i);
			}
		}
		
		closeConnection();
		
		return c;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public void excluir(String id) throws SQLException, ClassNotFoundException, IOException {
		Integer idServico=Integer.parseInt(id);
		
		//Abrir conexão
		openConnection();
		
		ps = connect.prepareStatement(EXCLUIR_Servico);
		ps.setInt(1, idServico);
		
		ps.execute();
		
		//Fechar conexão
		closeConnection();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	public void alterar(String id,String nome,String email,String cpf,String celular,String sexo,String cidade,
			String serial,String data,String hora,String defeito,String valorconserto,String status) throws SQLException, ClassNotFoundException, IOException {
		//Servico c=new Servico(id, nome, cpf, email, senha);
		
		Integer idServico = Integer.parseInt(id);
		
		//Abrir conexão
		openConnection();
		
		ps = connect.prepareStatement(ALTERAR_Servico);
		ps.setString(1, nome);
		ps.setString(2, email);
		ps.setString(3, cpf);
		ps.setString(4, celular);
		ps.setString(5, sexo);
		ps.setString(6, cidade);
		ps.setString(7, serial);
		ps.setString(8, data);
		ps.setString(9, hora);
		ps.setString(10,defeito);
		ps.setString(11,valorconserto);
		ps.setString(12, status);
		ps.setInt(13, idServico);
		
		ps.execute();
		
		//Fechar conexão
		closeConnection();
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////
	public Servico achacpf(String cpf) throws SQLException, ClassNotFoundException, IOException {
		Servico c=null;
		//Abrir uma conexão
		openConnection();
		
		//Preparar o script
		ps = connect.prepareStatement(ACHACPF);
		ps.setString(1, cpf);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs != null)
			while(rs.next()) {
				c=new Servico(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),
						rs.getString("cpf")
						,rs.getString("celular"),rs.getString("sexo"),rs.getString("cidade"),
						rs.getString("serial"),rs.getString("data"),rs.getString("hora"),
						rs.getString("valorconserto"),rs.getString("defeito"),rs.getString("status"));
			}
		
		//Fechar a conexão
		closeConnection();
		
		return c;
	}
	

}
