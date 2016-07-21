package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LigneCommandeKey implements Serializable {
	
	private static final long serialVersionUID = 1740343061362926811L;

	@Column(name = "id_commande")
    private int idCommande;

    @Column(name = "id_article")
    private int idArticle;

}
//Test