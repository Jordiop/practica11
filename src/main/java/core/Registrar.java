package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrar
 */
@WebServlet("/registrar")
public class Registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String resultat = "";
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Bbdd.registroDB(username, password);
			resultat = "Usuario registrado correctamente";
		} catch (Exception e) {
			// Mostram el resulat tant com a tornada per JS com al arxiu
			resultat = e.toString();
			GestionErrores.escribirErrores(e.toString());
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultat);
	}

}
