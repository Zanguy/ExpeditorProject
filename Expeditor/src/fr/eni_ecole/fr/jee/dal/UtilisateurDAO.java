package fr.eni_ecole.fr.jee.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.eni_ecole.fr.jee.bean.Article;
import fr.eni_ecole.fr.jee.bean.Utilisateur;
import fr.eni_ecole.fr.jee.util.PersistenceManager;

public class UtilisateurDAO {
	
	public static Utilisateur checkerUtilisateur(String login, String password){
		Utilisateur u = null;
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		//Query query = em.createNativeQuery(CHECKER_UTILISATEUR, Utilisateur.class);
		Query query = em.createQuery("FROM Utilisateur WHERE login = :login AND password = :password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		
		try{
			u = (Utilisateur)query.getSingleResult();
		}catch (javax.persistence.NoResultException e){
			u = null;
		}
		
		
		trans.commit();
		em.close();
		
		return u;
	}
	
	public static List<Utilisateur> obtenirUtilisateurs(){
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query req = em.createQuery("FROM Utilisateur");
		
		liste = (List<Utilisateur>)req.getResultList();		
		
		trans.commit();
		em.close();
		
		return liste;
	}
	
	public static Utilisateur creerUtilisateur(Utilisateur u){
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		em.persist(u);
		
		trans.commit();
		em.close();
		
		return u;
	}
	
	public static void modifierUtilisateur(Utilisateur u){
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		em.merge(u);
		
		trans.commit();
		em.close();			
	}
}
