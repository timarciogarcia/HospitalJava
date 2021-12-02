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
import DAO.Dao_Raca;
import Model.JB_Raca;

/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/selectraca", "/updateraca", "/inserirraca" ,"/mainraca", "/deleteraca", "/reportraca" })
public class Raca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao_Database DAO = new Dao_Database();

	public Raca() {
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
		if (action.equals("/mainraca")) {
			frmracajsp(request, response);
		} else if (action.equals("/selectraca")) {
			selectraca(request, response);
		} else if (action.equals("/updateraca")) {
			updateraca(request, response);
		} else if (action.equals("/inserirraca")) {
			inserirraca(request, response);
		} else if (action.equals("/deleteraca")) {
			removerraca(request, response);
		} else {
			response.sendRedirect("Menu.jsp");
		}
	}


	protected void frmracajsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entrou na lista controller raca");
		Dao_Raca DB = new Dao_Raca();
		ArrayList<JB_Raca> lista = DB.listarRacas();
		request.setAttribute("raca", lista);
		RequestDispatcher rd = request.getRequestDispatcher("frmraca.jsp");
		rd.forward(request, response);
	}
	
	protected void selectraca(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Raca DB = new Dao_Raca();
		JB_Raca raca = new JB_Raca();
		
		String idraca = request.getParameter("idraca");
		
		raca.setIdraca(Integer.parseInt(idraca));
		
		// exec meted selecionar
		DB.selecionarraca(raca);
		// coloca os campos do bd no form
		request.setAttribute("idraca", raca.getIdraca());
		request.setAttribute("idespecie", raca.getIdespecie());
		request.setAttribute("nome", raca.getNome());
		request.setAttribute("nomeespecie", raca.getNomeEspecie());
		
		// encaminhar ao doc editar
		RequestDispatcher rd = request.getRequestDispatcher("frmracaeditar.jsp");
		rd.forward(request, response);
	}
	
	
	protected void updateraca(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar variaveis
		Dao_Raca DB = new Dao_Raca();
		JB_Raca raca = new JB_Raca();
		raca.setIdraca(Integer.parseInt(request.getParameter("idraca")));
		raca.setNome(request.getParameter("nome"));		
		raca.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));
		raca.setNomeEspecie(request.getParameter("nomeespecie"));		
		DB.updateraca(raca);
		response.sendRedirect("mainraca");
		
	}
	
	protected void inserirraca(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int TIPO = Integer.parseInt(request.getParameter("tipo"));
		Dao_Raca DB = new Dao_Raca();
		JB_Raca raca = new JB_Raca();

		if(TIPO==1){
			raca.setNome(request.getParameter("nome"));
			raca.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));
			DB.inserirraca(raca);
			response.sendRedirect("mainraca");	
		}else if(TIPO==2) {
			raca.setNome(request.getParameter("nome"));
			raca.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));
			DB.inserirraca(raca);
			RequestDispatcher dispatcher = request.getRequestDispatcher("frmracanovo.jsp");
			dispatcher.forward(request, response);
		}else if(TIPO==3) {
			response.sendRedirect("mainraca");
		}
	}
	
	protected void removerraca(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Raca DB = new Dao_Raca();
		JB_Raca raca = new JB_Raca();		
		int idraca = Integer.parseInt(request.getParameter("idraca"));
		raca.setIdraca(idraca);
		DB.removerraca(raca);
		response.sendRedirect("mainraca");
	}
	
}
