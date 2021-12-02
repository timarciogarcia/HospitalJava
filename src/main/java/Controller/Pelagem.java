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
import DAO.Dao_Pelagem;
import Model.JB_Pelagem;

/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/mainpelagem", "/selectpelagem", "/updatepelagem", "/inserirpelagem" , "/deletepelagem", "/reportpelagem" })
public class Pelagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao_Database DAO = new Dao_Database();

	public Pelagem() {
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
		if (action.equals("/mainpelagem")) {
			frmpelagemjsp(request, response);
		} else if (action.equals("/selectpelagem")) {
			selectpelagem(request, response);
		} else if (action.equals("/updatepelagem")) {
			updatepelagem(request, response);
		} else if (action.equals("/inserirpelagem")) {
			inserirpelagem(request, response);
		} else if (action.equals("/deletepelagem")) {
			removerpelagem(request, response);
		} else {
			response.sendRedirect("Menu.jsp");
		}
	}

	protected void frmpelagemjsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Pelagem DB = new Dao_Pelagem();
		ArrayList<JB_Pelagem> lista = DB.listarpelagem();
		request.setAttribute("pelagem", lista);
		RequestDispatcher rd = request.getRequestDispatcher("frmpelagem.jsp");
		rd.forward(request, response);
	}

	protected void selectpelagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Pelagem DB = new Dao_Pelagem();
		JB_Pelagem pelagem = new JB_Pelagem();
		
		String idpelagem = request.getParameter("idpelagem");
		
		pelagem.setIdpelagem(Integer.parseInt(idpelagem));
		
		// exec meted selecionar
		DB.selecionarpelagem(pelagem);
		// coloca os campos do bd no form
		request.setAttribute("idpelagem", pelagem.getIdpelagem());
		request.setAttribute("nome", pelagem.getNome());
		
		
		// encaminhar ao doc editar
		RequestDispatcher rd = request.getRequestDispatcher("frmpelagemeditar.jsp");
		rd.forward(request, response);
	}

	protected void updatepelagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar variaveis
		Dao_Pelagem DB = new Dao_Pelagem();
		JB_Pelagem pelagem = new JB_Pelagem();
		pelagem.setIdpelagem(Integer.parseInt(request.getParameter("idpelagem")));		
		pelagem.setNome(request.getParameter("nome"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("idpelagem"));
		DB.updatepelagem(pelagem);
		response.sendRedirect("mainpelagem");
		
	}
	
	protected void inserirpelagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Pelagem DB = new Dao_Pelagem();
		JB_Pelagem pelagem = new JB_Pelagem();
		int TIPO = Integer.parseInt(request.getParameter("tipo"));

		System.out.println("tipo=" + request.getParameter("tipo").getClass().getSimpleName());
		System.out.println("tipo=" + TIPO);
		if(TIPO==1){
			pelagem.setNome(request.getParameter("nome"));
			DB.inserirpelagem(pelagem);
			response.sendRedirect("mainpelagem");	
		}else if(TIPO==2) {
			pelagem.setNome(request.getParameter("nome"));
			DB.inserirpelagem(pelagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("frmpelagemnovo.jsp");
			dispatcher.forward(request, response);
		}else if(TIPO==3) {
			response.sendRedirect("mainpelagem");
		}
	}

	protected void removerpelagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Pelagem DB = new Dao_Pelagem();
		JB_Pelagem pelagem = new JB_Pelagem();		
		int idpelagem = Integer.parseInt(request.getParameter("idpelagem"));
		pelagem.setIdpelagem(idpelagem);
		DB.removerpelagem(pelagem);
		response.sendRedirect("mainpelagem");
	}

}
