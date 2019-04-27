
public class Pari {

	/**
	 * le numéro du pari en autoIncrement
	 */
	private static long idPari = 0;

	/**
	 * la compétition concernée par le pari
	 */
	private Competition competition;

	/**
	 * le nombre de jetons misé sur la compétition
	 */
	private long mise;

	/**
	 * Le joueur qui parie
	 */
	private Joueur parieur;
	/**
	 * le compétiteur qui est le vainqueur envisagé par le joueur qui parie
	 */
	private Competiteur vainqueurEnvisage;

	// GETTERS ET SETTERS

	/**
	 * Getter de l'attribut idPari
	 * @return retourne le numéro du pari.
	 */
	public long getIdPari() {
		return idPari;
	}

	/**
	 * Setter de l'attribut idPari
	 * @param idPari
	 */
	public void setIdPari(long numPari) {
		idPari = numPari;
	}

	/**
	 * Getter de l'attribut mise
	 * @return retourne le nombre de jetons misés
	 */
	public long getMise() {
		return mise;
	}

	/**
	 * Setter de l'attribut mise
	 * @param mise la mise en jetons du parieur
	 */
	public void setMise(long mise) {
		this.mise = mise;
	}

	/**
	 * Getter de l'attribut competition
	 * @return Retourne la compétition concernée par le pari.
	 */
	public Competition getCompetition() {
		return competition;
	}

	/**
	 * Setter de l'attribut competition
	 * @param competition 
	 */
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	/**
	 * Getter de l'attribut parieur
	 * @return Retourne le joueur qui parie
	 */
	public Joueur getParieur() {
		return parieur;
	}

	/**
	 * Setter de l'attribut parieur
	 * @param parieur le joueur qui parie.
	 */
	public void setParieur(Joueur parieur) {
		this.parieur = parieur;
	}

	/**
	 * Getter de l'attribut vainqueurEnvisage</tt>
	 * @return Retourne le compétiteur qui est 
	 * le vainqueur envisagé par le parieur
	 */
	public Competiteur getVainqueurEnvisage() {
		return vainqueurEnvisage;
	}

	/**
	 * Setter de l'attribut vainqueurEnvisage
	 * @param vainqueurEnvisage Le competiteur qui est le vainqueur envisagé
	 */
	public void setCompetiteur(Competiteur vainqueurEnvisage) {
		this.vainqueurEnvisage = vainqueurEnvisage;
	}

	// CONSTRUCTEURS

	/**
	 * Constructeur avec les paramètres
	 */
	public Pari(Joueur parieur, Competition compet, Competiteur vainqueurEnvisage, long mise) {
		idPari++;
		this.setIdPari(idPari);
		this.setMise(mise);
		this.setCompetition(compet);
		this.setParieur(parieur);
		this.setCompetiteur(vainqueurEnvisage);
	}

}
