package fr.eni_ecole.jee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.fr.jee.bean.Utilisateur;
import fr.eni_ecole.fr.jee.dal.UtilisateurDAO;
import fr.eni_ecole.fr.jee.util.Constant;

/**
 * Servlet implementation class RetourAcceuilServlet
 */
public class RetourAcceuilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetourAcceuilServlet() {
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
		
		Utilisateur u = (Utilisateur)request.getSession().getAttribute("UtilisateurConnecte");
		if(u != null){
			if(u.getTypeUtilisateur().getLibelle().toLowerCase().equals(Constant.EMPLOYE.toLowerCase())){
				RequestDispatcher req = request.getRequestDispatcher("/Employe/indexEmploye");
				req.forward(request, response);
			}else if(u.getTypeUtilisateur().getLibelle().toLowerCase().equals(Constant.MANAGER.toLowerCase())){
				RequestDispatcher req = request.getRequestDispatcher("/Manager/indexManager");
				req.forward(request, response);
			}
		}else{
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}

}
