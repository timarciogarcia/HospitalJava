package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Departamento;
import Model.JB_Departamento;

/**
 * Servlet implementation class Departamento
 */
@WebServlet({ "/selecionardepartamento", "/alterardepartamento", "/inserirdepartamento" ,"/maindepartamento", "/excluirdepartamento" })
public class Departamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Departamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Depto Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/maindepartamento")) {
			listardepartamento(request, response);
		} else if (action.equals("/selecionardepartamento")) {
			selecionardepartamento(request, response);
		} else if (action.equals("/alterardepartamento")) {
			alterardepartamento(request, response);
		} else if (action.equals("/inserirdepartamento")) {
			inserirdepartamento(request, response);
		} else if (action.equals("/excluirdepartamento")) {
			excluirdepartamento(request, response);
		} else {
			response.sendRedirect("Menu.jsp");
		}
	}
	
	protected void listardepartamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("agenda.jsp");
		// receber dados javabeans;
		System.out.println("Entrou na lista controller");
		Dao_Departamento DB = new Dao_Departamento();
		ArrayList<JB_Departamento> lista = DB.listardepartamento();
		// test
		// for (int i = 0; i < lista.size(); i++) {
		// System.out.println(lista.get(i).getIdcon());
		// }
		// mandando a lista ao doc agenda .jsp
		request.setAttribute("departamento", lista);
		RequestDispatcher rd = request.getRequestDispatcher("frmdepartamento.jsp");
		rd.forward(request, response);
	}

	protected void selecionardepartamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Departamento DB = new Dao_Departamento();
		JB_Departamento departamento = new JB_Departamento();
		String iddepartamento = request.getParameter("iddepartamento");
		departamento.setIddepartamento(Integer.parseInt(iddepartamento));
		// exec meted selecionar
		DB.selecionardepartamento(departamento);
		// coloca os campos do bd no form
		request.setAttribute("iddepartamento", departamento.getIddepartamento());
		request.setAttribute("nome", departamento.getNome());
		// encaminhar ao doc editar
		RequestDispatcher rd = request.getRequestDispatcher("frmdepartamentoeditar.jsp");
		rd.forward(request, response);
	}

	protected void alterardepartamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar variaveis
		Dao_Departamento DB = new Dao_Departamento();
		JB_Departamento Departamento = new JB_Departamento();
		Departamento.setIddepartamento(Integer.parseInt(request.getParameter("iddepartamento")));
		Departamento.setNome(request.getParameter("nome"));
		DB.alterardepartamento(Departamento);
		response.sendRedirect("maindepartamento");
		
	}
	
	protected void inserirdepartamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Departamento DB = new Dao_Departamento();
		JB_Departamento Departamento = new JB_Departamento();
		int TIPO = Integer.parseInt(request.getParameter("tipo"));

		System.out.println("tipo=" + request.getParameter("tipo").getClass().getSimpleName());
		System.out.println("tipo=" + TIPO);
		if(TIPO==1){
			Departamento.setNome(request.getParameter("nome"));
			DB.inserirdepartamento(Departamento);
			response.sendRedirect("maindepartamento");	
		}else if(TIPO==2) {
		System.out.println("entrou no salvar novo depto");
		Departamento.setNome(request.getParameter("nome"));
			DB.inserirdepartamento(Departamento);
			RequestDispatcher dispatcher = request.getRequestDispatcher("frmdepartamentonovo.jsp");
			dispatcher.forward(request, response);
		}else if(TIPO==3) {
			response.sendRedirect("maindepartamento");
		}
	}

	protected void excluirdepartamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Departamento DB = new Dao_Departamento();
		JB_Departamento Departamento = new JB_Departamento();		
		int iddepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
		Departamento.setIddepartamento(iddepartamento);
		DB.excluirdepartamento(Departamento);
		response.sendRedirect("maindepartamento");
	}
	

	
}
