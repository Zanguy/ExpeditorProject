package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrateur
 *
 */

@Entity
@Table(name="ARTICLE")
public class Article implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2197573580891777639L;

	/**
	 * id de l'article
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	/**
	 * nom de l'article
	 */
	@Column(name="nom")
	private String nom;
	
	/**
	 * poids de l'article
	 */
	@Column(name="poids")
	private int poids;
	
	/**
	 * Constructeur par défault
	 */
	public Article (){
		
	}
	
	/**
	 * Constructeur
	 * 
	 * @param id
	 * 	id de l'article
	 * @param nom
	 * 	nom de l'article
	 * @param poids
	 * 	poids de l'article
	 */
	public Article (long id, String nom, int poids){
		this.id = id;
		this.nom = nom;
		this.poids = poids;
	}

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }

	public int getPoids() { return poids; }
	public void setPoids(int poids) { this.poids = poids; }
	
	
	
	
}
