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
import fr.eni_ecole.fr.jee.bean.TypeUtilisateur;
import fr.eni_ecole.fr.jee.bean.Utilisateur;
import fr.eni_ecole.fr.jee.dal.ArticleDAO;
import fr.eni_ecole.fr.jee.dal.CommandeDAO;
import fr.eni_ecole.fr.jee.dal.UtilisateurDAO;
import fr.eni_ecole.fr.jee.util.Constant;

/**
 * Servlet implementation class UtilisateurServlet
 */
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
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

		String where = "/";
		
		switch ((String) request.getParameter("action")) {
		case "getAllUtilisateur":
			
			getAllUtilisateur(request, response);
			break;
		case "enregistrerUtilisateur" :
			
			addOrUpdateUtilisateur(request, response);
			
			
			break;
		default:
			break;
		}
		
	}
	
	private void addOrUpdateUtilisateur(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u = new Utilisateur();
		
		String id = (String)request.getAttribute("id");
		
		u.setLogin((String)request.getAttribute("login"));
		u.setPassword((String)request.getAttribute("password"));
		u.setNom((String)request.getAttribute("nom"));
		u.setPrenom((String)request.getAttribute("prenom"));
		
		TypeUtilisateur tu = new TypeUtilisateur();
		if(((String)request.getAttribute("type")).equals(Constant.EMPLOYE)){
			tu.setLibelle(Constant.EMPLOYE);
			tu.setId(1);
		}if(((String)request.getAttribute("type")).equals(Constant.MANAGER)){
			tu.setLibelle(Constant.MANAGER);
			tu.setId(2);
		}
		
		u.setTypeUtilisateur(tu);
		
		if (id  != null && !id.isEmpty()) {
			u.setId(Integer.parseInt(id));
			UtilisateurDAO.modifierUtilisateur(u);
		} else {
			UtilisateurDAO.creerUtilisateur(u);
		}
		
		getAllUtilisateur(request, response);
		
	}

	private void getAllUtilisateur (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		List<Utilisateur> list = UtilisateurDAO.obtenirUtilisateurs();
		request.setAttribute("ListeUtilisateur", list);

		RequestDispatcher req = request
				.getRequestDispatcher("/Manager/gestionEmployes.jsp");
		req.forward(request, response);
	}
	
}
