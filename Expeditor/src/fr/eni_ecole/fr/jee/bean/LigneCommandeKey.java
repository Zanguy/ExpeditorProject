package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LigneCommandeKey implements Serializable {
	
	private static final long serialVersionUID = 1740343061362926811L;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_article",insertable=false, updatable=false)
	private Article article;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_commande",insertable=false, updatable=false)
	private Commande commande;

}
//Test