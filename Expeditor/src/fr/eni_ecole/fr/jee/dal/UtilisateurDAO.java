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
	private final static String OBTENIR_UTILISATEURS = 
			"SELECT * "
		  + "FROM UTILISATEUR;";
	
	private final static String CHECKER_UTILISATEUR = 
			  "SELECT * "
			+ "FROM UTILISATEUR "
			+ "WHERE login = ? "
			+ "AND password = CONVERT(VARCHAR(40), HASHBYTES('SHA1', ?));";
	
	private final static String CREER_UTILISATEUR = 
			  "INSERT INTO UTILISATEUR (login, password, nom, prenom, id_typ_user)"
			+ "VALUES (?, CONVERT(VARCHAR(40), HASHBYTES('SHA1', ?)), ?, ?, ?);";
	
	private final static String MODIFIER_UTILISATEUR = 
			"UPDATE UTILISATEUR"
		  + "SET login = ?,"
		  + 	"  nom = ?"
		  + 	"  prenom = ?"
		  + "WHERE id = ?;";
	
	public static boolean checkerUtilisateur(String login, String password){
		boolean b = false;
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query query = em.createNativeQuery(CHECKER_UTILISATEUR, Utilisateur.class);
		query.setParameter(1, login);
		query.setParameter(2, password);
		
		trans.commit();
		em.close();
		
		Utilisateur u = (Utilisateur)query.getSingleResult();
		
		//Si mon objet est non nul, c'est que mon utilisateur a été matché dans la BDD
		if(u != null){
			b = true;
		}
		
		return b;
	}
	
	public static List<Utilisateur> obtenirUtilisateurs(){
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		liste = (List<Utilisateur>)em.createQuery(OBTENIR_UTILISATEURS);		
		
		trans.commit();
		em.close();
		
		return liste;
	}
	
	public static void creerUtilisateur(Utilisateur u){
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query q = em.createNativeQuery(CREER_UTILISATEUR);
		q.setParameter(1, u.getLogin());
		q.setParameter(2, u.getLogin());
		//q.setParameter(3, arg1)
		
		trans.commit();
		em.close();
		
	}
	
	public static void modifierUtilisateur(){
		
	}
}
