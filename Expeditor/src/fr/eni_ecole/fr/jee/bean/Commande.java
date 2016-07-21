package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMMANDE")
public class Commande implements Serializable {
	
	private static final long serialVersionUID = -2056667874072513760L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="num_commande")
	private String numCommande;
	
	@Column(name="date_creation")
	private Date dateCreation;
	
	@Column(name="poids_total")
	private int poidsTotal;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="adresse")
	private String adresse;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="etat_commande", referencedColumnName="id")
	private EtatCommande etatCommande;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="utilisateur")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="commande")
	private List<LigneCommande> lesLigneCommandes = new ArrayList<>();

	public Commande() { super(); }

	public Commande(long id, String numCommande, Date dateCreation, int poidsTotal, String nom, String adresse, EtatCommande etatCommande, Utilisateur utilisateur) {
		this();
		this.id = id;
		this.numCommande = numCommande;
		this.dateCreation = dateCreation;
		this.poidsTotal = poidsTotal;
		this.nom = nom;
		this.adresse = adresse;
		this.etatCommande = etatCommande;
		this.utilisateur = utilisateur;
	}

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getNumCommande() { return numCommande; }
	public void setNumCommande(String numCommande) { this.numCommande = numCommande; }

	public Date getDateCreation() { return dateCreation; }
	public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

	public int getPoidsTotal() { return poidsTotal; }
	public void setPoidsTotal(int poidsTotal) { this.poidsTotal = poidsTotal; }

	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }

	public String getAdresse() { return adresse; }
	public void setAdresse(String adresse) { this.adresse = adresse; }

	public EtatCommande getEtatCommande() { return etatCommande; }
	public void setEtatCommande(EtatCommande etatCommande) { this.etatCommande = etatCommande; }

	public Utilisateur getUtilisateur() { return utilisateur; }
	public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

	public static long getSerialversionuid() { return serialVersionUID; }

	public List<LigneCommande> getLigneCommandes() { return lesLigneCommandes; }
	public void setLigneCommandes(List<LigneCommande> lesLigneCommandes) { this.lesLigneCommandes = lesLigneCommandes; }

}
