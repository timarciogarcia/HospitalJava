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
import DAO.Dao_Patologia;
import Model.JB_Patologia;

/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/mainpatologia", "/selectpatologia", "/updatepatologia", "/inserirpatologia" , "/deletepatologia", "/reportpatologia" })
public class Patologia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao_Database DAO = new Dao_Database();

	public Patologia() {
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
		if (action.equals("/mainpatologia")) {
			frmpatologiajsp(request, response);
		} else if (action.equals("/selectpatologia")) {
			selectpatologia(request, response);
		} else if (action.equals("/updatepatologia")) {
			updatepatologia(request, response);
		} else if (action.equals("/inserirpatologia")) {
			inserirpatologia(request, response);
		} else if (action.equals("/deletepatologia")) {
			removerpatologia(request, response);
		} else {
			response.sendRedirect("Menu.jsp");
		}
	}

	protected void frmpatologiajsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Patologia DB = new Dao_Patologia();
		ArrayList<JB_Patologia> lista = DB.listarpatologia();
		request.setAttribute("patologia", lista);
		RequestDispatcher rd = request.getRequestDispatcher("frmpatologia.jsp");
		rd.forward(request, response);
	}

	protected void selectpatologia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Patologia DB = new Dao_Patologia();
		JB_Patologia patologia = new JB_Patologia();
		
		String idpatologia = request.getParameter("idpatologia");
		
		patologia.setIdpatologia(Integer.parseInt(idpatologia));
		
		// exec meted selecionar
		DB.selecionarpatologia(patologia);
		// coloca os campos do bd no form
		request.setAttribute("idpatologia", patologia.getIdpatologia());
		request.setAttribute("nome", patologia.getNome());
		request.setAttribute("descricao", patologia.getDescricao());
		
		
		// encaminhar ao doc editar
		RequestDispatcher rd = request.getRequestDispatcher("frmpatologiaeditar.jsp");
		rd.forward(request, response);
	}

	protected void updatepatologia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar variaveis
		Dao_Patologia DB = new Dao_Patologia();
		JB_Patologia patologia = new JB_Patologia();
		patologia.setIdpatologia(Integer.parseInt(request.getParameter("idpatologia")));		
		patologia.setNome(request.getParameter("nome"));
		patologia.setDescricao(request.getParameter("descricao"));
		
		
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("idpatologia"));

		DB.updatepatologia(patologia);
		response.sendRedirect("mainpatologia");
		
	}
	
	protected void inserirpatologia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Patologia DB = new Dao_Patologia();
		JB_Patologia patologia = new JB_Patologia();
		int TIPO = Integer.parseInt(request.getParameter("tipo"));

		System.out.println("tipo=" + request.getParameter("tipo").getClass().getSimpleName());
		System.out.println("tipo=" + TIPO);
		if(TIPO==1){
			patologia.setNome(request.getParameter("nome"));
			patologia.setDescricao(request.getParameter("descricao"));
			DB.inserirpatologia(patologia);
			response.sendRedirect("mainpatologia");	
		}else if(TIPO==2) {
			patologia.setNome(request.getParameter("nome"));
			patologia.setDescricao(request.getParameter("descricao"));
			DB.inserirpatologia(patologia);
			RequestDispatcher dispatcher = request.getRequestDispatcher("frmpatologianovo.jsp");
			dispatcher.forward(request, response);
		}else if(TIPO==3) {
			response.sendRedirect("mainpatologia");
		}
	}

	protected void removerpatologia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Patologia DB = new Dao_Patologia();
		JB_Patologia patologia = new JB_Patologia();		
		int idpatologia = Integer.parseInt(request.getParameter("idpatologia"));
		patologia.setIdpatologia(idpatologia);
		DB.removerpatologia(patologia);
		response.sendRedirect("mainpatologia");
	}

}
