package com.appspot.gpgsaluj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CtrlSaludo", urlPatterns = { "/CtrlSaludo" })
public class CtrlSaludo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			final String nombre = request.getParameter("nombre");
			if (nombre == null || nombre.isEmpty()) {
				throw new Exception("Falta el nombre.");
			} else {
				request.setAttribute("respuesta", "Saludos a " + nombre + ".");
			}
		} catch (Exception e) {
			log("Error calculando saludo.", e);
			request.setAttribute("respuesta", e.getMessage());
		}
		final RequestDispatcher rd = request.getRequestDispatcher("FormRespuesta.jsp");
		rd.forward(request, response);
	}
}