package br.edu.facear.servlet.servico;

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
 * Servlet implementation class ObterClienteServlet
 */
@WebServlet("/ObterClienteServlet")
public class ObterClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		Cliente cliente=null;
		Integer idCliente=new Integer(0);
		
	String id=request.getParameter("id");
		
		if(id!=null && !id.equals(""))
			idCliente=Integer.parseInt(id);

		
		request.setAttribute("cliente", cliente);
		
		*/
		
		////////////////////////////////////////////////////////
		
		/*
		//Redirecionar para detalhesCliente.jsp
		Cliente cliente=null;
		
		//Obter parâmetro id pela URL e Converter id para Integer
		Integer idCliente=Integer.parseInt(request.getParameter("id"));
		
		//Lógica para chamar service
		ClienteService service=new ClienteService();

		try {
			cliente=service.obterClientePorId(idCliente);
			String nextPage="/detalhesCliente.jsp";
			RequestDispatcher rd= getServletContext().getRequestDispatcher(nextPage);
			rd.forward(request, response);
			
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	*/
		
		
		Servico cliente=null;
		
		//Obter parâmetro id pela URL e Converter id para Integer
		Integer idCliente=Integer.parseInt(request.getParameter("id"));
		
		//Lógica para chamar service
	 ServicoService service=new ServicoService();
	
				try {
					cliente=service.obterServicoPorId(idCliente);
					
					
					
					request.setAttribute("cliente", cliente);
					
					//Redirecionar para detalhesCliente.jsp
					String nextPage="/detalhesCliente.jsp";
					RequestDispatcher rd= getServletContext().getRequestDispatcher(nextPage);
					rd.forward(request, response);
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
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
