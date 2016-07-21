package fr.eni_ecole.jee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.fr.jee.bean.Commande;
import fr.eni_ecole.fr.jee.bean.EtatCommande;
import fr.eni_ecole.fr.jee.bean.Utilisateur;
import fr.eni_ecole.fr.jee.dal.CommandeDAO;

/**
 * Servlet implementation class CommandeServlet
 */
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {
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
		Commande c = CommandeDAO.obtenirCommandeEmploye();
		c.setUtilisateur((Utilisateur)request.getSession().getAttribute("UtilisateurConnecte"));
		c.setEtatCommande(new EtatCommande());
		c.getEtatCommande().setId(2);
		request.setAttribute("commande", c);
		
		RequestDispatcher req = request.getRequestDispatcher("/Employe/indexEmploye.jsp");
		req.forward(request, response);
		
		
	}

}
