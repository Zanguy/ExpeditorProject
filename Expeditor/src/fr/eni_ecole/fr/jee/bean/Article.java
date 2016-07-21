package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ARTICLE")
public class Article implements Serializable {
	
	private static final long serialVersionUID = -2197573580891777639L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="libelle")
	private String nom;
	
	@Column(name="poids")
	private int poids;
	
	@OneToMany(mappedBy="article")
	private List<LigneCommande> lesLigneCommandes = new ArrayList<LigneCommande>();
	
	public Article() { super(); }
	
	public Article(long id, String nom, int poids){
		this();
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

	public List<LigneCommande> getLesLigneCommandes() { return lesLigneCommandes; }
	public void setLesLigneCommandes(List<LigneCommande> lesLigneCommandes) { this.lesLigneCommandes = lesLigneCommandes; }

	public static long getSerialversionuid() { return serialVersionUID; }
	
}
