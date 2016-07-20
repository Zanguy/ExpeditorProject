package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TYPE_UTILISATEUR")
public class TypeUtilisateur implements Serializable {
	
	private static final long serialVersionUID = 8496928028311964191L;

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="libelle")
	private String libelle;
	
	@OneToMany(mappedBy="typeUtilisateur", targetEntity=Utilisateur.class, fetch=FetchType.EAGER)
	private List<Utilisateur> lesUtilisateurs;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	
	public static long getSerialversionuid() { return serialVersionUID; }
	
}
