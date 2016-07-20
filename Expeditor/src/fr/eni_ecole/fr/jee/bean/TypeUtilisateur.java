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
@Table(name="TYPE_UTILISATEUR")
public class TypeUtilisateur implements Serializable {
	
	private static final long serialVersionUID = 8496928028311964191L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="libelle")
	private String libelle;
	
	@OneToMany(mappedBy="typeUtilisateur", targetEntity=Utilisateur.class, fetch=FetchType.EAGER)
	private List<Utilisateur> lesUtilisateurs = new ArrayList<>();
	
	public TypeUtilisateur() { super(); }
	
	public TypeUtilisateur(int id, String libelle, List<Utilisateur> lesUtilisateurs) {
		this();
		this.id = id;
		this.libelle = libelle;
		this.lesUtilisateurs = lesUtilisateurs;
	}
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	
	public List<Utilisateur> getUtilisateurs() { return this.lesUtilisateurs; }
	public void setUtilisateurs(List<Utilisateur> lesUtilisateurs) { this.lesUtilisateurs = lesUtilisateurs; }
	
	public static long getSerialversionuid() { return serialVersionUID; }
	
}
