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
 * Servlet implementation class Buscaporcpf
 */
@WebServlet("/Buscaporcpf")
public class Buscaporcpf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscaporcpf() {
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
		
		String cpf=request.getParameter("cpf");
		
		
		ServicoService service=new ServicoService();
		
		//Obter do Banco de Dados
					
			Servico c;
	
				try {
					c = service.achacpf(cpf);
					
					request.setAttribute("cliente", c);
					//request.getSession().setAttribute("Servico",c);
					
					
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/detalhesCliente.jsp");
					rd.forward(request, response);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		


			
	}

}
