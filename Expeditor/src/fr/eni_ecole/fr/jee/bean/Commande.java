package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMMANDE")
public class Commande implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="num_commande")
	private String numCommande;
	
	private Date dateCreation;
	
	private int poidsTotal;
	
	private String nom;
	
	private String adresse;
	
	//private EtatCommande etatCommande;
	
	private Utilisateur utilisateur;
	
}
