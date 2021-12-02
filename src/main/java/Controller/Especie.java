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
import DAO.Dao_Especie;
import Model.JB_Especie;

/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/mainespecie", "/selectespecie", "/updateespecie", "/inserirespecie" , "/deleteespecie", "/reportespecie" })
public class Especie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao_Database DAO = new Dao_Database();

	public Especie() {
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
		if (action.equals("/mainespecie")) {
			frmespeciejsp(request, response);
		} else if (action.equals("/selectespecie")) {
			selectespecie(request, response);
		} else if (action.equals("/updateespecie")) {
			updateespecie(request, response);
		} else if (action.equals("/inserirespecie")) {
			inserirespecie(request, response);
		} else if (action.equals("/deleteespecie")) {
			removerespecie(request, response);
		} else {
			response.sendRedirect("Menu.jsp");
		}
	}

	protected void frmespeciejsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Especie DB = new Dao_Especie();
		ArrayList<JB_Especie> lista = DB.listarespecies();
		request.setAttribute("especie", lista);
		RequestDispatcher rd = request.getRequestDispatcher("frmespecie.jsp");
		rd.forward(request, response);
	}

	protected void selectespecie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Especie DB = new Dao_Especie();
		JB_Especie especie = new JB_Especie();
		
		String idespecie = request.getParameter("idespecie");
		
		especie.setIdespecie(Integer.parseInt(idespecie));
		
		// exec meted selecionar
		DB.selecionarespecie(especie);
		// coloca os campos do bd no form
		request.setAttribute("idespecie", especie.getIdespecie());
		request.setAttribute("nome", especie.getNome());
		
		
		// encaminhar ao doc editar
		RequestDispatcher rd = request.getRequestDispatcher("frmespecieeditar.jsp");
		rd.forward(request, response);
	}

	protected void updateespecie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar variaveis
		Dao_Especie DB = new Dao_Especie();
		JB_Especie especie = new JB_Especie();
		especie.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));		
		especie.setNome(request.getParameter("nome"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("idespecie"));
		DB.updateespecie(especie);
		response.sendRedirect("mainespecie");
		
	}
	
	protected void inserirespecie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Especie DB = new Dao_Especie();
		JB_Especie especie = new JB_Especie();
		int TIPO = Integer.parseInt(request.getParameter("tipo"));

		System.out.println("tipo=" + request.getParameter("tipo").getClass().getSimpleName());
		System.out.println("tipo=" + TIPO);
		if(TIPO==1){
			especie.setNome(request.getParameter("nome"));
			DB.inserirespecie(especie);
			response.sendRedirect("mainespecie");	
		}else if(TIPO==2) {
			especie.setNome(request.getParameter("nome"));
			DB.inserirespecie(especie);
			RequestDispatcher dispatcher = request.getRequestDispatcher("frmespecienovo.jsp");
			dispatcher.forward(request, response);
		}else if(TIPO==3) {
			response.sendRedirect("mainespecie");
		}
	}

	protected void removerespecie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Especie DB = new Dao_Especie();
		JB_Especie especie = new JB_Especie();		
		int idespecie = Integer.parseInt(request.getParameter("idespecie"));
		especie.setIdespecie(idespecie);
		DB.removerespecie(especie);
		response.sendRedirect("mainespecie");
	}

}
