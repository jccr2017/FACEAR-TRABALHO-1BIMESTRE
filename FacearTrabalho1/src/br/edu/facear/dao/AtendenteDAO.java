package br.edu.facear.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Atendente;
import br.edu.facear.service.AtendenteService;

public class AtendenteDAO extends GenericDAO{

	private PreparedStatement ps;
	
	private String CADASTRAR_SQL ="INSERT INTO atendente (nome,email,cpf,celular,"
			+ "idade,sexo,cidade,senha) values(?, ?, ?, ?,?,?,?,?);";

	
	private String LOGIN_SQL ="SELECT * FROM  atendente WHERE EMAIL = ? AND SENHA = ?;";
	
	private String ALTERAR_CLIENTE="UPDATE   atendente SET nome=?,"
			+ "email=?,cpf=?,celular=?,idade=?,sexo=?,cidade=?,senha=? WHERE id=?;";
	
	private String SELECIONA="SELECT * FROM   atendente WHERE ID=?;";
	
	private String LISTAR_CLIENTE="SELECT * FROM   atendente;";
	
	private String EXCLUIR_CLIENTE="DELETE FROM   atendente WHERE ID=?;";
	
	
	
////////////////////////////////////
	
	public Atendente cadastrar(String nome,String email,String cpf,String celular,
			String idade,String sexo,String cidade,String senha)
					throws SQLException, ClassNotFoundException, IOException {
		Atendente c=null;
		
		//Abrir conexão
		openConnection();
		
		//Preparar script
		ps = connect.prepareStatement(CADASTRAR_SQL);
		ps.setString(1, nome);
		ps.setString(2, email);
		ps.setString(3, cpf);
		ps.setString(4, celular);
		ps.setString(5, idade);
		ps.setString(6, sexo);
		ps.setString(7, cidade);
		ps.setString(8, senha);

		
		ps.executeUpdate();
		
		closeConnection();
		
		return c;
	}
	

	///////////////////////////////////////////////////////////////////////////////////
		
	public Atendente autenticar(String email, String senha) throws SQLException, ClassNotFoundException, IOException {
		Atendente c=null;
		//Abrir uma conexão
		openConnection();
		
		//Preparar o script
		ps = connect.prepareStatement(LOGIN_SQL);
		ps.setString(1, email);
		ps.setString(2, senha);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs != null)
			while(rs.next()) {
				c=new Atendente(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("cpf")
						,rs.getString("celular"),rs.getString("idade"),rs.getString("sexo")
						,rs.getString("cidade")
						,rs.getString("senha"));
			}
		
		//Fechar a conexão
		closeConnection();
		
		return c;
	}

	
	////////////////////////////////////////////////////////////////////////


public void alterar(String id,String nome, String email, String cpf,
		String celular,String idade,String sexo,String cidade,
String senha) throws 
SQLException, ClassNotFoundException, IOException {
	
	//Cliente c=new Cliente(id, nome, cpf, email, senha);
	
	Integer idAtendente = Integer.parseInt(id);
	
	//Abrir conexão
	openConnection();
	
	ps = connect.prepareStatement(ALTERAR_CLIENTE);
	ps.setString(1, nome);
	ps.setString(2, email);
	ps.setString(3, cpf);
	ps.setString(4, celular);
	ps.setString(5, idade);
	ps.setString(6, sexo);
	ps.setString(7, cidade);
	ps.setString(8, senha);
	ps.setInt(9, idAtendente);
	
	ps.execute();
	
	//Fechar conexão
	closeConnection();
}



/////////////////////////////////////////////////////////////////////////


public Atendente obterAtendentePorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
	Atendente c=null;
	AtendenteService service=new AtendenteService();
	
	List<Atendente> listaAtendente=service.listaAtendentees();
	
	openConnection();
	
	ps=connect.prepareStatement(SELECIONA);
	ps.setInt(1, id);
	
	for(int i=0;i<listaAtendente.size();i++) {
		if(id==listaAtendente.get(i).getId()) {
			c=listaAtendente.get(i);
		}
	}
	
	closeConnection();
	
	return c;
}

//////////////////////////////////////////////////////////////////

public List<Atendente> listarAtendentees() throws ClassNotFoundException, IOException, SQLException{
	List<Atendente> lista = new ArrayList<Atendente>();
	// Abrir conexão
	openConnection();
	
	// Executar o script
	ps = connect.prepareStatement(LISTAR_CLIENTE);
	ResultSet rs = ps.executeQuery();
	
	//Analisar o retorno do script
	if(rs != null){
		while(rs.next()){
			Atendente c = new Atendente(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("cpf")
					,rs.getString("celular"),rs.getString("idade"),rs.getString("sexo")
					,rs.getString("cidade")
					,rs.getString("senha"));
			lista.add(c);
		}
	}
	
	closeConnection();
	
	return lista;
}



///////////////////////////////////////////////////////////////////

public void excluir(String id) throws SQLException, ClassNotFoundException, IOException {
	Integer idAtendente=Integer.parseInt(id);
	
	//Abrir conexão
	openConnection();
	
	ps = connect.prepareStatement(EXCLUIR_CLIENTE);
	ps.setInt(1, idAtendente);
	
	ps.execute();
	
	//Fechar conexão
	closeConnection();
}








}
