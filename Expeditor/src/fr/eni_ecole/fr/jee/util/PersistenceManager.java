package fr.eni_ecole.fr.jee.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	 
	  private static final PersistenceManager manager = new PersistenceManager();
	  
	  protected EntityManagerFactory emf;
	  
	  public static PersistenceManager getInstance() {
	    return manager;
	  }
	  
	  private PersistenceManager() {
	  }
	 
	  /**
	   * Lazy-loading du EntiyManagerFactory (car couteux)
	   * @return
	   */
	  public EntityManagerFactory getEntityManagerFactory() {
	    
	    if (emf == null) {
	    	this.emf = Persistence.createEntityManagerFactory("ExpeditorJPA");
	    }
	    return emf;
	  }
	  
	  public void closeEntityManagerFactory() {
	    
	    if (emf != null) {
	      emf.close();
	      emf = null;
	    }
	  }
	  
	  /**
	   * Obtenir une nouvelle instance de EntityManager depuis cet EntityManagerFactory.
	   * @return
	   */
	  public static EntityManager createEntityManager()  {
		  return getInstance().getEntityManagerFactory().createEntityManager();
	  }

	}






