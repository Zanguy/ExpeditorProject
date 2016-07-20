package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="UTILISATEUR")
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 6263166639320050602L;

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_typ_user", referencedColumnName="id")
	private TypeUtilisateur typeUtilisateur;
	
	public Utilisateur() { super(); }
	
	public Utilisateur(String login, String password, String nom, String prenom, TypeUtilisateur typeUtilisateur) {
		this();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.typeUtilisateur = typeUtilisateur;
	}
	
	public int getId() {  return id; }
	public void setId(int id) { this.id = id; }
	
	public String getLogin() { return login; }
	public void setLogin(String login) { this.login = login; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }

	public String getPrenom() { return prenom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }

	public TypeUtilisateur getTypeUtilisateur() { return typeUtilisateur; }
	public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) { this.typeUtilisateur = typeUtilisateur; }

	public static long getSerialversionuid() { return serialVersionUID; }

}
