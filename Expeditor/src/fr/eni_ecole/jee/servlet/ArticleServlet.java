package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.fr.jee.bean.Article;
import fr.eni_ecole.fr.jee.dal.ArticleDAO;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleServlet() {
		super();
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
		// TODO Auto-generated method stub

		switch ((String) request.getParameter("action")) {
		case "liste":
			getAllArticle(request, response);
			break;
		case "ajout":
			save(request, response);
			break;

		default:
			break;
		}

	}

	private void save(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//Vérification Add or update
		
		String id= request.getParameter("id");
		
		Article article = new Article();
		article.setNom(request.getParameter("nom"));
		article.setPoids(Integer.parseInt(request.getParameter("poids")));
		if (id  != null && !id.isEmpty()) {
			article.setId(Integer.parseInt(id));
			ArticleDAO.updateArticle(article);
		} else {
			ArticleDAO.createArticle(article);
		}

		getAllArticle(request, response);
	}

	private void getAllArticle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Article> list = ArticleDAO.getAllArticle();
		request.setAttribute("listeArticle", list);

		RequestDispatcher req = request
				.getRequestDispatcher("/Manager/gestionArticles.jsp");
		req.forward(request, response);

	}

}
