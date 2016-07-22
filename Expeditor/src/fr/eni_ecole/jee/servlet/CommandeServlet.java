package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.fr.jee.bean.Commande;
import fr.eni_ecole.fr.jee.bean.EtatCommande;
import fr.eni_ecole.fr.jee.bean.LigneCommande;
import fr.eni_ecole.fr.jee.bean.Utilisateur;
import fr.eni_ecole.fr.jee.dal.CommandeDAO;
import fr.eni_ecole.fr.jee.util.Convert;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String type = "";
		String where = "/";
		
		if (request.getAttribute("type") != null) {
			type = (String) request.getAttribute("type");
		}
		
		
		switch (type) {
		case "getAllCommande":
			
			getAllCommande(request, response);
			where = "/Manager/indexManager.jsp";
			
			break;
		case "getComandeEmploye":
			Commande c = CommandeDAO.obtenirCommandeEmploye();
			c.setUtilisateur((Utilisateur) request.getSession().getAttribute(
					"UtilisateurConnecte"));
			c.setEtatCommande(new EtatCommande());
			c.getEtatCommande().setId(2);
			request.setAttribute("commande", c);

			where = "/Employe/indexEmploye.jsp";

			break;
		default:
			break;
		}
		
		if ("enregistrerCommande".equals(request.getParameter("action"))) {
			long id = Long.parseLong(request.getParameter("id"));
			Commande comm = CommandeDAO.findById(id);
			EtatCommande et = new EtatCommande();
			et.setId(3);
			comm.setEtatCommande(et);
			CommandeDAO.modifierCommande(comm);
		}else if ("importCommande".equals(request.getParameter("action"))) {
			
			if(request.getParameter("fichier") != null && !((String)request.getParameter("fichier")).isEmpty()){
				String filePath = (String)request.getParameter("fichier");
				List<Commande> liste = null;
				if(filePath.endsWith(".csv")){
					liste = Convert.convertFromCSV();
				}else if (filePath.endsWith(".cxls")){
					liste = Convert.convertFromXLS();
				}
				
				for (Commande item : liste) {
					CommandeDAO.creerCommande(item);
					for (LigneCommande lc : item.getLesLigneCommandes()) {
						//CommandeDAO.creerLigneCommande(lc);
					}
				}
			}
			getAllCommande(request, response);
			where = "/Manager/indexManager.jsp";
		}
		
		RequestDispatcher req = request
				.getRequestDispatcher(where);
		req.forward(request, response);
		
	}

	private void getAllCommande(HttpServletRequest request,
			HttpServletResponse response) {
		List<Commande> list = CommandeDAO.obtenirCommandes();
		request.setAttribute("ListeCommande", list);

	}
}
