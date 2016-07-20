package fr.eni_ecole.fr.jee.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrateur
 *
 */

@Entity
@Table(name="LIGNE_COMMANDE")
public class LigneCommande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4107009732162412816L;
	
	/**
	 * id de l'article
	 */
	@Id
	@Column(name="id_commande")
	private long id;
	
}
