package fr.eni_ecole.fr.jee.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.eni_ecole.fr.jee.bean.Commande;
import fr.eni_ecole.fr.jee.util.PersistenceManager;

public class CommandeDAO {
	public static Commande obtenirCommandeEmploye(){
		Commande c = null;
		EntityManager em = PersistenceManager.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		Query req = em.createQuery("FROM Commande WHERE etatCommande.id = 1 AND utilisateur IS NULL ORDER BY dateCreation ASC");
		
		c = (Commande)req.getSingleResult();
		
		trans.commit();
		em.close();
		
		return c;
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
