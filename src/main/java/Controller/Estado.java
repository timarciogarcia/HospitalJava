package Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Database;
import DAO.Dao_Estado;
import Model.JB_Estado;

/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/Controller", "/estado", "/insert", "/ValidaUsuario", "/selectestado", "/updateestado", "/inserirestado" ,"/main", "/deleteestado", "/reportestado" })
public class Estado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Dao_Database DAO = new Dao_Database();

	public Estado() {
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
		if (action.equals("/ValidaUsuario")) {
			ValidaUsuario(request, response);
		} else if (action.equals("/main")) {
			frmestadojsp(request, response);
		} else if (action.equals("/estado")) {
			frmestadojsp(request, response);
		} else if (action.equals("/selectestado")) {
			selectestado(request, response);
		} else if (action.equals("/updateestado")) {
			updateestado(request, response);
		} else if (action.equals("/inserirestado")) {
			inserirestado(request, response);
		} else if (action.equals("/deleteestado")) {
			try {
				removerestado(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("Menu.jsp");
		}
	}

	// ************************************************************************//
	// ************************************************************************//
	// ************************************************************************//
	// Analisa Dominio e Seta a Empresa que entrou
	// Valida Usuario e gera Obj para manter dados de Usuario e Empresa
	// Para ser usado no Log e Insert nas tabelas
	protected void ValidaUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String dominio = getDomainName(request.getParameter("dominio"));

		System.out.println("Entrou COntroller Action Usuario");
		System.out.println("usuario " + usuario);
		System.out.println("senha " + senha);
		System.out.println("host " + dominio);

	}

	protected static String getDomainName(String url) throws MalformedURLException {
		if (!url.startsWith("http") && !url.startsWith("https")) {
			url = "http://" + url;
		}
		URL netUrl = new URL(url);
		String Host = netUrl.getHost();
		if (Host.startsWith("www")) {
			Host = Host.substring("www".length() + 1);
		}
		return Host;
	}

	// ************************************************************************//
	// ************************************************************************//
	// ************************************************************************//
	protected void frmestadojsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("agenda.jsp");
		// receber dados javabeans;
		System.out.println("Entrou na lista controller");
		Dao_Estado DB = new Dao_Estado();
		ArrayList<JB_Estado> lista = DB.listarEstados();
		// test
		// for (int i = 0; i < lista.size(); i++) {
		// System.out.println(lista.get(i).getIdcon());
		// }
		// mandando a lista ao doc agenda .jsp
		request.setAttribute("estados", lista);
		RequestDispatcher rd = request.getRequestDispatcher("frmestado.jsp");
		rd.forward(request, response);
	}

	protected void selectestado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Estado DB = new Dao_Estado();
		JB_Estado estado = new JB_Estado();
		
		String idestado = request.getParameter("idestado");
		
		estado.setIdestado(Integer.parseInt(idestado));
		
		// exec meted selecionar
		DB.selecionarestado(estado);
		// coloca os campos do bd no form
		request.setAttribute("idestado", estado.getIdestado());
		request.setAttribute("uf", estado.getUf());
		request.setAttribute("nome", estado.getNome());
		
		System.out.println("so esse 1selectestado  " + estado.getIdestado());
		System.out.println("so esse 2selectestado  " + estado.getUf());
		System.out.println("so esse 3selectestado  " + estado.getNome());

		
		// encaminhar ao doc editar
		RequestDispatcher rd = request.getRequestDispatcher("frmestadoeditar.jsp");
		rd.forward(request, response);
	}

	protected void updateestado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar variaveis
		Dao_Estado DB = new Dao_Estado();
		JB_Estado estado = new JB_Estado();
		estado.setIdestado(Integer.parseInt(request.getParameter("idestado")));
		estado.setNome(request.getParameter("nome"));
		estado.setUf(request.getParameter("uf").substring(0, 2));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("uf").substring(0, 2));
		System.out.println(request.getParameter("idestado"));
		DB.updateestado(estado);
		response.sendRedirect("main");
		
	}
	
	protected void inserirestado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao_Estado DB = new Dao_Estado();
		JB_Estado estado = new JB_Estado();
		int TIPO = Integer.parseInt(request.getParameter("tipo"));

		System.out.println("tipo=" + request.getParameter("tipo").getClass().getSimpleName());
		System.out.println("tipo=" + TIPO);
		if(TIPO==1){
			estado.setNome(request.getParameter("nome"));
			estado.setUf(request.getParameter("uf"));
			DB.inserirestadoo(estado);
			response.sendRedirect("main");	
		}else if(TIPO==2) {
			estado.setNome(request.getParameter("nome"));
			estado.setUf(request.getParameter("uf"));
			DB.inserirestadoo(estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("frmestadonovo.jsp");
			dispatcher.forward(request, response);
		}else if(TIPO==3) {
			response.sendRedirect("main");
		}
	}

	protected void removerestado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		try {
			Dao_Estado DB = new Dao_Estado();
			JB_Estado estado = new JB_Estado();		
			int idestado = Integer.parseInt(request.getParameter("idestado"));
			estado.setIdestado(idestado);
			DB.removerestado(estado);
			response.sendRedirect("main");
			} catch (Exception ex) {
			System.out.println(ex);
			}
	}
}
