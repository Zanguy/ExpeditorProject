package fr.eni_ecole.fr.jee.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.eni_ecole.fr.jee.bean.Commande;
import fr.eni_ecole.fr.jee.util.PersistenceManager;

public class CommandeDAO {
	public static final String OBTENIR_COMMANDE_EMPLOYE = "FROM Commande "
			+ "WHERE etatCommande.id = 1 "
			+ "AND utilisateur IS NULL "
			+ "ORDER BY dateCreation ASC";
	public static Commande obtenirCommandeEmploye(){
		List<Commande> liste = null;
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query req = em.createQuery(OBTENIR_COMMANDE_EMPLOYE);
		
		liste = (List<Commande>)req.getResultList();
		
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
}
