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
 * Servlet implementation class CadastrarServlet
 */
@WebServlet("/CadastrarServlet")
public class CadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarServlet() {
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
		
		String nome=request.getParameter("nome");
		String email=request.getParameter("email");
		String cpf=request.getParameter("cpf");
		String celular=request.getParameter("celular");
		
		String sexo=request.getParameter("sexo");
		String cidade=request.getParameter("cidade");
		String serial=request.getParameter("serial");
		String data=request.getParameter("data");
		String hora=request.getParameter("hora");
		String defeito=request.getParameter("defeito");
		String valorconserto=request.getParameter("valorconserto");
		String status=request.getParameter("status");
		
		
		ServicoService service=new ServicoService();
		
		//Obter do Banco de Dados
		;
		try {
			Servico c = service.cadastrar(nome,email,cpf,celular,sexo,cidade,
					serial,data,hora,defeito,valorconserto,status);
			
			request.setAttribute("Servico", c);
			
			
			
			//String nextPage="/cadastro.html";
			
			//if(c != null) {
				//nextPage="/principal.jsp";
			//}
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/inicial.html");
			rd.forward(request, response);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Colocar na área de memória da sessão

		
		
	}

}
