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
import DAO.Dao_Vacina;
import Model.JB_Vacina;

/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/selectvacina", "/updatevacina", "/inserirvacina" ,"/mainvacina", "/deletevacina", "/reportvacina" })
public class Vacina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao_Database DAO = new Dao_Database();

	public Vacina() {
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
		if (action.equals("/mainvacina")) {
			frmvacinajsp(request, response);
		} else if (action.equals("/selectvacina")) {
			selectvacina(request, response);
		} else if (action.equals("/updatevacina")) {
			updatevacina(request, response);
		} else if (action.equals("/inserirvacina")) {
			inserirvacina(request, response);
		} else if (action.equals("/deletevacina")) {
			removervacina(request, response);
		} else {
			response.sendRedirect("Menu.jsp");
		}
	}


	protected void frmvacinajsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entrou na lista controller vacina");
		Dao_Vacina DB = new Dao_Vacina();
		ArrayList<JB_Vacina> lista = DB.listarVacinas();
		request.setAttribute("vacina", lista);
		RequestDispatcher rd = request.getRequestDispatcher("frmvacina.jsp");
		rd.forward(request, response);
	}
	
	protected void selectvacina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Vacina DB = new Dao_Vacina();
		JB_Vacina vacina = new JB_Vacina();
		
		String idvacina = request.getParameter("idvacina");
		
		vacina.setIdvacina(Integer.parseInt(idvacina));
		
		// exec meted selecionar
		DB.selecionarvacina(vacina);
		// coloca os campos do bd no form
		request.setAttribute("idvacina", vacina.getIdvacina());
		request.setAttribute("idgrupovacina", vacina.getIdgrupovacina());
		request.setAttribute("status", vacina.getStatus());
		request.setAttribute("nome", vacina.getNome());
		request.setAttribute("laboratorio", vacina.getLaboratorio());
		
		// encaminhar ao doc editar
		RequestDispatcher rd = request.getRequestDispatcher("frmvacinaeditar.jsp");
		rd.forward(request, response);
	}
	
	
	protected void updatevacina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar variaveis
		Dao_Vacina DB = new Dao_Vacina();
		JB_Vacina vacina = new JB_Vacina();
		vacina.setIdvacina(Integer.parseInt(request.getParameter("idvacina")));
		vacina.setIdgrupovacina(Integer.parseInt(request.getParameter("idgrupovacina")));
		vacina.setStatus(Integer.parseInt(request.getParameter("status")));
		vacina.setNome(request.getParameter("nome"));		
		vacina.setLaboratorio(request.getParameter("laboratorio"));		
		
		DB.updatevacina(vacina);
		response.sendRedirect("mainvacina");
		
	}
	
	protected void inserirvacina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int TIPO = Integer.parseInt(request.getParameter("tipo"));
		Dao_Vacina DB = new Dao_Vacina();
		JB_Vacina vacina = new JB_Vacina();

		if(TIPO==1){
			//vacina.setIdvacina(Integer.parseInt(request.getParameter("idvacina")));
			vacina.setIdgrupovacina(Integer.parseInt(request.getParameter("idgrupovacina")));
			vacina.setStatus(Integer.parseInt(request.getParameter("status")));
			vacina.setNome(request.getParameter("nome"));		
			vacina.setLaboratorio(request.getParameter("laboratorio"));		

			DB.inserirvacina(vacina);
			response.sendRedirect("mainvacina");	
		}else if(TIPO==2) {
			//vacina.setIdvacina(Integer.parseInt(request.getParameter("idvacina")));
			vacina.setIdgrupovacina(Integer.parseInt(request.getParameter("idgrupovacina")));
			vacina.setStatus(Integer.parseInt(request.getParameter("status")));
			vacina.setNome(request.getParameter("nome"));		
			vacina.setLaboratorio(request.getParameter("laboratorio"));		

			DB.inserirvacina(vacina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("frmvacinanovo.jsp");
			dispatcher.forward(request, response);
		}else if(TIPO==3) {
			response.sendRedirect("mainvacina");
		}
	}
	
	protected void removervacina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Vacina DB = new Dao_Vacina();
		JB_Vacina vacina = new JB_Vacina();		
		int idvacina = Integer.parseInt(request.getParameter("idvacina"));
		vacina.setIdvacina(idvacina);
		DB.removervacina(vacina);
		response.sendRedirect("mainvacina");
	}
	
}
