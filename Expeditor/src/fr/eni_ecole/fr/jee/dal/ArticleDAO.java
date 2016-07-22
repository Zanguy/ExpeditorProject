package fr.eni_ecole.fr.jee.dal;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.eni_ecole.fr.jee.bean.Article;
import fr.eni_ecole.fr.jee.bean.Commande;
import fr.eni_ecole.fr.jee.util.PersistenceManager;


public class ArticleDAO {
	private final static String RECHERCHE_ARTICLE = "From Article";
	private final static String RECHERCHE_ARTICLE_LIBELLE = "From Article a WHERE a.nom = :nom";

	
	
	public static List<Article> getAllArticle(){
		
		List<Article> listeArticle =null;
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query req = em.createQuery(RECHERCHE_ARTICLE);
		
		listeArticle = (List<Article>) req.getResultList();
		
		
		trans.commit();
		em.close();
		
		return listeArticle;
	}
	
	public static Article findById(Article a){
		
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Article article = (Article)em.find(Article.class, a.getId());
		
		trans.commit();
		em.close();
		
		return article;
	}
	
	public static void createArticle(Article a){
		
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		a.setId(Long.valueOf(-1));
		em.merge(a);
		
		trans.commit();
		em.close();
		
	}
	
	public static void updateArticle(Article a){
		
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		em.merge(a);
		
		trans.commit();
		em.close();
		
	}

	public static Article findByLibelle(String nom) {
		
		Article a = null;
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query req = em.createQuery(RECHERCHE_ARTICLE_LIBELLE);
		req.setParameter("nom", nom);
		
		a = (Article) req.getResultList().get(0);
		
		trans.commit();
		em.close();
		
		return a;
		
	}
	
}
















