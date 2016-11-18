package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import logic.ControladorPartida;
import utils.ApplicationException;

/**
 * Servlet implementation class servletPartida
 */
@WebServlet("/servletPartida")
public class servletPartida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPartida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String atacar = request.getParameter("evento_ataca");
		ControladorPartida ctrl = (ControladorPartida)request.getAttribute("controladorPartida");
		if(atacar.equals("Atacar"))
		{
			int atq = Integer.parseInt(request.getParameter("ataque"));
			try {
				if(ctrl.atacar(atq)){
				if(ctrl.getFin()){
					request.getSession().setAttribute("ganador", ctrl.getTurno().getNombre());
					request.getRequestDispatcher("/jspGanador.jsp").forward(request, response);
					}
					else{
						request.getRequestDispatcher("/jspPartida.jsp");
					}
				}
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				ctrl.defender();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/jspPartida.jsp");
		}
	}
}
