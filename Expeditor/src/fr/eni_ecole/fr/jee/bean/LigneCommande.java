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
@Table(name="LIGNE_COMMANDE")
public class LigneCommande implements Serializable {

	private static final long serialVersionUID = -4107009732162412816L;
	
	@Id
	@ManyToOne(optional=false)
	@JoinColumn(name="id_article")
	private Article article;
	
	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_commande")
	private Commande commande;
	
	@Column(name="num_ligne")
	private long num_ligne;
	
	@Column(name="qte")
	private long qte;

	public LigneCommande() { super(); }

	public LigneCommande(Article article, Commande commande, long num_ligne, long qte) {
		this();
		this.article = article;
		this.commande = commande;
		this.num_ligne = num_ligne;
		this.qte = qte;
	}

	public Article getArticle() { return article; }
	public void setArticle(Article article) { this.article = article; }

	public Commande getCommande() { return commande; }
	public void setCommande(Commande commande) { this.commande = commande; }

	public long getNum_ligne() { return num_ligne; }
	public void setNum_ligne(long num_ligne) { this.num_ligne = num_ligne; }

	public long getQte() { return qte; }
	public void setQte(long qte) { this.qte = qte; }
	
	public static long getSerialversionuid() { return serialVersionUID; }
	
}
