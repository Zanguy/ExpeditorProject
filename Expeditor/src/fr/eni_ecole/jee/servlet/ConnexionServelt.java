package fr.eni_ecole.jee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.fr.jee.bean.Utilisateur;
import fr.eni_ecole.fr.jee.dal.UtilisateurDAO;
import fr.eni_ecole.fr.jee.util.*;

/**
 * Servlet implementation class ConnexionServelt
 */
public class ConnexionServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Utilisateur u = UtilisateurDAO.checkerUtilisateur(login, password);
		
		if(u != null){
			request.getSession().setAttribute("UtilisateurConnecte", u);
			request.getSession().setAttribute("erreurLogin", "");
			if(u.getTypeUtilisateur().getLibelle().toLowerCase().equals(Constant.EMPLOYE.toLowerCase())){
				request.setAttribute("type", "getComandeEmploye");
				RequestDispatcher req = request.getRequestDispatcher("/commande");
				req.forward(request, response);
			}else if(u.getTypeUtilisateur().getLibelle().toLowerCase().equals(Constant.MANAGER.toLowerCase())){
				request.setAttribute("type", "getAllCommande");
				RequestDispatcher req = request.getRequestDispatcher("/commande");
				req.forward(request, response);
			}
		}else{
			request.getSession().setAttribute("erreurLogin", "Login ou mot de passe invalide !");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}
