package br.edu.facear.servlet.atendente;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.edu.facear.model.Servico;

import br.edu.facear.service.ServicoService;

/**
 * Servlet implementation class ObterAlterarCliente
 */
@WebServlet("/ObterAlterarCliente")
public class ObterAlterarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterAlterarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Servico cliente=null;
		//Obter par�metro id pela URL e Converter id para Integer
		Integer idCliente=Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("cliente", cliente);
		
		//Redirecionar para detalhesCliente.jsp
		String nextPage="/detalhesCliente.jsp";
		RequestDispatcher rd= getServletContext().getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
		
		//L�gica para chamar service
		ServicoService service=new ServicoService();
		try {
			cliente=service.obterServicoPorId(idCliente);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
