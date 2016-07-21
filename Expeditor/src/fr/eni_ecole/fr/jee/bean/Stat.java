package fr.eni_ecole.fr.jee.bean;

public class Stat {
	private String nomEmploye;
	private int nbCommandes;
	
	
	public Stat(String nomEmploye, int nbCommandes) {
		super();
		this.nomEmploye = nomEmploye;
		this.nbCommandes = nbCommandes;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public int getNbCommandes() {
		return nbCommandes;
	}

	public void setNbCommandes(int nbCommandes) {
		this.nbCommandes = nbCommandes;
	}		
}
