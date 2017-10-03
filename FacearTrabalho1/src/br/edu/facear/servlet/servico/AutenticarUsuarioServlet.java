package br.edu.facear.servlet.servico;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Servico;


import br.edu.facear.service.ServicoService;

/**
 * Servlet implementation class AutenticarUsuarioServlet
 */
@WebServlet("/AutenticarUsuarioServlet")
public class AutenticarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
	
		ServicoService service=new ServicoService();
		
		//Obter do Banco de Dados
		
		try {
			
			Servico c = service.autenticar(email, senha);
			
			
			request.setAttribute("Servico", c);
			
			String nextPage = "/index.html";
			
			if(c != null) {
				nextPage = "/principal.jsp";
				
			RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
			rd.forward(request, response);
				
			}else {
				
				nextPage = "/loginincorreto.html";
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
				rd.forward(request, response);
				
				
				
			}

			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Colocar na área da memória da sessão

		
		
		
		
	}

}
