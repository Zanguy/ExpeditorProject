package fr.eni_ecole.fr.jee.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.eni_ecole.fr.jee.bean.Commande;
import fr.eni_ecole.fr.jee.bean.LigneCommande;
import fr.eni_ecole.fr.jee.bean.Stat;
import fr.eni_ecole.fr.jee.util.PersistenceManager;

public class CommandeDAO {
	public static final String OBTENIR_COMMANDE_EMPLOYE = "FROM Commande "
			+ "WHERE etatCommande.id = 1 "
			+ "AND utilisateur IS NULL "
			+ "ORDER BY dateCreation ASC";
	
	public static final String OBTENIR_COMMANDES = 
			"FROM Commande "
		+   "WHERE etatCommande.id != 3";
	
	public static Commande obtenirCommandeEmploye(){
		List<Commande> liste = null;
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query req = em.createQuery(OBTENIR_COMMANDE_EMPLOYE);
		
		liste = (List<Commande>)req.getResultList();
	
		//List<LigneCommande> test = liste.get(0).getLigneCommandes();
		
		trans.commit();
		em.close();
		
		if(liste.isEmpty()){
			return null;
		}else{
			return liste.get(0);
		}
	}
	
	public static void modifierCommande(Commande c){
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		em.merge(c);
		
		trans.commit();
		em.close();
	}
	
	public static List<Commande> obtenirCommandes(){
		List<Commande> liste = new ArrayList<Commande>();
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query req = em.createQuery(OBTENIR_COMMANDES);
		
		liste = (List<Commande>)req.getResultList();
		
		trans.commit();
		em.close();
		
		return liste;
	}
	
	public static List<Stat> obtenirStatistiquesJournalieres(){
		List<Stat> liste = new ArrayList<Stat>();
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query req = em.createNativeQuery("SELECT u.prenom + ' ' + UPPER(u.nom) as nomPersonne, COUNT(*) as nbCommandes "
										+ "FROM COMMANDE c "
										+ "INNER JOIN UTILISATEUR u ON c.utilisateur = u.id "
										+ "WHERE etat_commande = 3 "
										+ "AND CONVERT(CHAR(10), c.date_modif, 121) = CONVERT(CHAR(10), GETDATE(), 121) "
										+ "GROUP BY u.prenom + ' ' + UPPER(u.nom);");
		
		List list = req.getResultList();
		
		//Le getResult renvoie les bonnes lignes.
		//Il faut juste binder les objets Stats dans la liste.
		
		trans.commit();
		em.close();
		
		return liste;
	}
}
