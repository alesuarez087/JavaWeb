package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Personaje;
import logic.Controlador;
import logic.ControladorPartida;

/**
 * Servlet implementation class servletSeleccion
 */
@WebServlet("/servletSeleccion")
public class servletSeleccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletSeleccion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnInicio") != null){
			if(request.getSession().getAttribute("personaje_1") != null && request.getSession().getAttribute("personaje_2") != null)
			{
				request.getSession().setAttribute("personaje_1", null);
				request.getSession().setAttribute("personaje_2", null);
			}
			request.getRequestDispatcher("/jspSelecion.jsp").forward(request, response);
		} else{
			String p1 = (String)request.getParameter("listado_1");
			String p2 = (String)request.getParameter("listado_2");
			Controlador ctrl = new Controlador(); 
			Personaje personaje1 = ctrl.getPersonaje(p1);
			Personaje personaje2 = ctrl.getPersonaje(p2);
			ControladorPartida ctrlpart = new ControladorPartida();
			ctrlpart.inicioPartida(personaje1, personaje2);
			request.getSession().setAttribute("personaje_1", personaje1);
			request.getSession().setAttribute("personaje_2", personaje2);
			request.getSession().setAttribute("turno", ctrlpart.getTurno().getNombre());
			request.getSession().setAttribute("controladorPartida",	ctrlpart);
			request.getRequestDispatcher("/jspPartida.jsp").forward(request, response);
		}
	}

}

