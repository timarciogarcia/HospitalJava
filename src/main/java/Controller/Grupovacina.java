package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Database;
import DAO.Dao_Grupovacina;
import Model.JB_Grupovacina;

/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/maingrupovacina", "/selectgrupovacina", "/updategrupovacina", "/inserirgrupovacina" , "/deletegrupovacina", "/reportgrupovacina" })
public class Grupovacina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao_Database DAO = new Dao_Database();

	public Grupovacina() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/maingrupovacina")) {
			frmgrupovacinajsp(request, response);
		} else if (action.equals("/selectgrupovacina")) {
			selectgrupovacina(request, response);
		} else if (action.equals("/updategrupovacina")) {
			updategrupovacina(request, response);
		} else if (action.equals("/inserirgrupovacina")) {
			inserirgrupovacina(request, response);
		} else if (action.equals("/deletegrupovacina")) {
			removergrupovacina(request, response);
		} else {
			response.sendRedirect("Menu.jsp");
		}
	}

	protected void frmgrupovacinajsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Grupovacina DB = new Dao_Grupovacina();
		ArrayList<JB_Grupovacina> lista = DB.listargrupovacinas();
		request.setAttribute("grupovacina", lista);
		RequestDispatcher rd = request.getRequestDispatcher("frmgrupovacina.jsp");
		rd.forward(request, response);
	}

	protected void selectgrupovacina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Grupovacina DB = new Dao_Grupovacina();
		JB_Grupovacina grupovacina = new JB_Grupovacina();
		
		String idgrupovacina = request.getParameter("idgrupovacina");
		
		grupovacina.setIdgrupovacina(Integer.parseInt(idgrupovacina));
		
		// exec meted selecionar
		DB.selecionargrupovacina(grupovacina);
		// coloca os campos do bd no form
		request.setAttribute("idgrupovacina", grupovacina.getIdgrupovacina());
		request.setAttribute("nome", grupovacina.getNome());
		
		
		// encaminhar ao doc editar
		RequestDispatcher rd = request.getRequestDispatcher("frmgrupovacinaeditar.jsp");
		rd.forward(request, response);
	}

	protected void updategrupovacina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar variaveis
		Dao_Grupovacina DB = new Dao_Grupovacina();
		JB_Grupovacina grupovacina = new JB_Grupovacina();
		grupovacina.setIdgrupovacina(Integer.parseInt(request.getParameter("idgrupovacina")));		
		grupovacina.setNome(request.getParameter("nome"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("idgrupovacina"));
		DB.updategrupovacina(grupovacina);
		response.sendRedirect("maingrupovacina");
		
	}
	
	protected void inserirgrupovacina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Grupovacina DB = new Dao_Grupovacina();
		JB_Grupovacina grupovacina = new JB_Grupovacina();
		int TIPO = Integer.parseInt(request.getParameter("tipo"));

		System.out.println("tipo=" + request.getParameter("tipo").getClass().getSimpleName());
		System.out.println("tipo=" + TIPO);
		if(TIPO==1){
			grupovacina.setNome(request.getParameter("nome"));
			DB.inserirgrupovacina(grupovacina);
			response.sendRedirect("maingrupovacina");	
		}else if(TIPO==2) {
			grupovacina.setNome(request.getParameter("nome"));
			DB.inserirgrupovacina(grupovacina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("frmgrupovacinanovo.jsp");
			dispatcher.forward(request, response);
		}else if(TIPO==3) {
			response.sendRedirect("maingrupovacina");
		}
	}

	protected void removergrupovacina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Grupovacina DB = new Dao_Grupovacina();
		JB_Grupovacina grupovacina = new JB_Grupovacina();		
		int idgrupovacina = Integer.parseInt(request.getParameter("idgrupovacina"));
		grupovacina.setIdgrupovacina(idgrupovacina);
		DB.removergrupovacina(grupovacina);
		response.sendRedirect("maingrupovacina");
	}

}
