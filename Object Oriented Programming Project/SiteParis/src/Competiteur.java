import java.util.*;

/**
 * @author Baudouin KOUASSI
 */

public class Competiteur {

	private String nom;
	private LinkedList<Competition> mesCompetitions;

	// CONSTRUCTEURS

	/**
	 * constructeur par defaut
	 */
	public Competiteur() {
		setCompetitions(null);
	}

	/**
	 * constructeur avec nom
	 */
	public Competiteur(String nom) {
		setNom(nom);
		setCompetitions(null);
	}

	/**
	 * constructeur avec nom et liste des competitions
	 */
	public Competiteur(String nom, LinkedList<Competition> listeCompetitions) {
		setNom(nom);
		setCompetitions(listeCompetitions);
	}

	// GETTERS ET SETTERS

	/**
	 * Getter de l'attribut nom
	 * 
	 * @return retourne le nom du Competiteur.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter de l'attribut nom
	 * 
	 * @param nom (le nom du competiteur)
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de la liste des competitions
	 * 
	 * @return Retourne la liste des competitions auquel participe le compétiteurs
	 */
	public LinkedList<Competition> getCompetitions() {
		return mesCompetitions;
	}

	/**
	 * Setter de la liste des competitions
	 * 
	 * @param listeCompetitions (la liste des competitions auquel participe le
	 *                          competiteur)
	 */
	public void setCompetitions(LinkedList<Competition> listeCompetitions) {
		mesCompetitions = listeCompetitions;
	}

}
