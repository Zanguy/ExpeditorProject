package fr.eni_ecole.fr.jee.dal;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.eni_ecole.fr.jee.bean.Article;
import fr.eni_ecole.fr.jee.util.PersistenceManager;


public class ArticleDAO {
	private final static String RECHERCHE_ARTICLE = "select * from ARTICLE";

	public static List<Article> rechercheArticleNonAttribue(Article animateur) {
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		List<Article> listeArticle = (List<Article>)em.createQuery(RECHERCHE_ARTICLE);
		
		
		trans.commit();
		em.close();
		
		return listeArticle;
	}
	
}
















