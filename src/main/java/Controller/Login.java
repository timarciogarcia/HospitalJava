package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.JB_Login;

/**
 * Servlet implementation class Login
 */
@WebServlet({"/Login","/LogOut","/Menu"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/Login")) {
			setuplogin(request, response);
		}else if (action.equals("/LogoUT")) {
			setuplogout(request, response);
		}else if (action.equals("/Menu")) {
			setupmenu(request, response);
		}else {
			setuplogout(request, response);
		}
			
	}
	
	protected void setuplogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    JB_Login login = new JB_Login();
			String dominio = request.getParameter("dominio");
			String usuario = request.getParameter("usuario");
			int idusuario = 10;

		    login.setDominio(dominio);
		    login.setIdusuario(idusuario);
		    login.setUsuario(usuario);
		    //setar o restante de acessos e etc
		    
			request.setAttribute("ObjUsuario", login);
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);		    
	}
			
	protected void setuplogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    response.sendRedirect("index.jsp");
	}

	protected void setupmenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.sendRedirect("Menu.jsp");
	}


}
