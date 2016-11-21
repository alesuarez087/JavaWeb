package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ControladorPartida ctrl = (ControladorPartida)request.getSession().getAttribute("controladorPartida");
		if(request.getParameter("btnAtaca") != null)
		{
			int atq = Integer.parseInt(request.getParameter("ataque"));
			try {
				if(ctrl.atacar(atq)){
					if(ctrl.getFin()){
						request.getSession().setAttribute("ganador", ctrl.getTurno().getNombre());
						request.getRequestDispatcher("/jspGanador.jsp").forward(request, response);
						}
					else{
						request.getSession().setAttribute("turno", ctrl.getTurno().getNombre());
						request.getSession().setAttribute("controladorPartida", ctrl);
						request.getRequestDispatcher("/jspPartida.jsp").forward(request, response);
					}
				}
				else
				{
					request.getSession().setAttribute("turno", ctrl.getTurno().getNombre());
					request.getSession().setAttribute("controladorPartida", ctrl);
					request.getRequestDispatcher("/jspPartida.jsp").forward(request, response);
				}
				
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("btnDefiende") != null)
			{
				try {
					ctrl.defender();
					request.getSession().setAttribute("turno", ctrl.getTurno().getNombre());
					request.getSession().setAttribute("controladorPartida", ctrl);
					request.getRequestDispatcher("/jspPartida.jsp").forward(request, response);
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
	}
}
