package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LIGNE_COMMANDE")
public class LigneCommande implements Serializable {

	private static final long serialVersionUID = -4107009732162412816L;
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_commande")
	private Commande commande;
	
	@Column(name="num_ligne")
	private int num_ligne;
	
	@Column(name="qte")
	private int qte;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_article")
	private Article article;
	
	public LigneCommande() {
		
	}

	public LigneCommande(int id, Commande commande, int num_ligne, int qte,
			Article article) {
		super();
		this.id = id;
		this.commande = commande;
		this.num_ligne = num_ligne;
		this.qte = qte;
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getNum_ligne() {
		return num_ligne;
	}

	public void setNum_ligne(int num_ligne) {
		this.num_ligne = num_ligne;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
}
