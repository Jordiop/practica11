package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CargarPrestamoID
 */
@WebServlet("/cargarprestamoid")
public class CargarPrestamoID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarPrestamoID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat = "";
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			resultat = Bbdd.buscarPresupuestoID(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultat);
	}

}
