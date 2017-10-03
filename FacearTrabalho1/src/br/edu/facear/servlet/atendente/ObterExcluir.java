package br.edu.facear.servlet.atendente;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Atendente;

import br.edu.facear.service.AtendenteService;


/**
 * Servlet implementation class ObterExcluir
 */
@WebServlet("/ObterExcluir")
public class ObterExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterExcluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Atendente empregador=null;
		Integer idempregador =new Integer(0);
		
		//Obter parâmetro id pela URL e Converter id para Integer
		String id=request.getParameter("id");
		
		if(id!=null && !id.equals(""))
			idempregador=Integer.parseInt(id);
		
		//Lógica para chamar service
		AtendenteService service=new AtendenteService();
		try {
			empregador=service.obterAtendentePorId(idempregador);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("empregador", empregador);
		
		//Redirecionar para detalhesCliente.jsp
		String nextPage="/excluirempregador.jsp";
		RequestDispatcher rd= getServletContext().getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
