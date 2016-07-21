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
@Table(name="ETAT_COMMANDE")
public class EtatCommande implements Serializable {

	private static final long serialVersionUID = -1475732684308936824L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="libelle")
	private String libelle;
	
	@OneToMany(mappedBy="etatCommande")
	private List<Commande> lesCommandes = new ArrayList<>();

	public EtatCommande() { super(); }

	public EtatCommande(int id, String libelle, List<Commande> lesCommandes) {
		this();
		this.id = id;
		this.libelle = libelle;
		this.lesCommandes = lesCommandes;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }

	public List<Commande> getLesCommandes() { return lesCommandes; }
	public void setLesCommandes(List<Commande> lesCommandes) { this.lesCommandes = lesCommandes; }
	
	public static long getSerialversionuid() { return serialVersionUID; }
	
}
