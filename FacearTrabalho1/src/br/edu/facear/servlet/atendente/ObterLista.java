package br.edu.facear.servlet.atendente;

import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.edu.facear.model.Servico;
import br.edu.facear.service.ServicoService;

/**
 * Servlet implementation class ObterLista
 */
@WebServlet("/ObterLista")
public class ObterLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterLista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		////////////////////////

		
	
		
	
	ServicoService service = new ServicoService();

		try {
			ArrayList<Servico> lista = (ArrayList<Servico>) 
												service.listaServicos();
			
			request.setAttribute("listaClientes", lista);
		
			
		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = getServletContext().
				getRequestDispatcher("/listarClientes.jsp");
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
