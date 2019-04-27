
import java.util.LinkedList;

/**
 * 
 * @author prou
 *
 */
public class TestMetier {

	public static void testConstructeurSiteDeParisMetier() {

		System.out.println("\n testConstructeurSiteDeParisMetier");

		SiteDeParisMetier siteDeParisMetier = null;

		// construction incorrecte

		try {
			siteDeParisMetier = new SiteDeParisMetier(null);
			System.out.println(
					"construire un site de paris avec un password gestionnaire invalide (non instancié) n'a pas levé l'exception MetierException");
		} catch (MetierException e) {
		} catch (Exception e) {
			System.out.println(
					"construire un site de paris avec un password gestionnaire invalide (non instancié) n'a pas levé l'exception MetierException mais "
							+ e.getClass().getName());
		}

		try {
			siteDeParisMetier = new SiteDeParisMetier("ax2a3t");
			System.out.println(
					"construire un site de paris avec un password gestionnaire invalide (moins de 8 caracteres) n'a pas levé l'exception MetierException ");
		} catch (MetierException e) {
		} catch (Exception e) {
			System.out.println(
					"construire un site de paris avec un password gestionnaire invalide (moins de 8 caracteres) n'a pas levé l'exception MetierException mais "
							+ e.getClass().getName());
		}

		try {
			siteDeParisMetier = new SiteDeParisMetier("qsdf452 3e");
			System.out.println(
					"construire un site de paris avec un password gestionnaire invalide (un espace) n'a pas levé l'exception MetierException ");
		} catch (MetierException e) {
		} catch (Exception e) {
			System.out.println(
					"construire un site de paris avec un password gestionnaire invalide (un espace) n'a pas levé l'exception MetierException mais "
							+ e.getClass().getName());
		}

		try {
			siteDeParisMetier = new SiteDeParisMetier("qsdf-523e");
			System.out.println(
					"construire un site de paris avec un password gestionnaire invalide (un -) n'a pas levé l'exception MetierException ");
		} catch (MetierException e) {
		} catch (Exception e) {
			System.out.println(
					"construire un site de paris avec un password gestionnaire invalide (un -) n'a pas levé l'exception MetierException mais "
							+ e.getClass().getName());
		}

		// construction correcte d'un site

		try {
			siteDeParisMetier = new SiteDeParisMetier("bmyjp2011");
		} catch (Exception e) {
			System.out.println(
					"\n construire un site de paris avec un password gestionnaire valide a levé une exception ");
			e.printStackTrace();
		}

	}

	public static void testValiditePasswordGestionnaire() {

		System.out.println("\n testValiditePasswordGestionnaire");

		try {

			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			// demande de validite avec password invalide

			try {
				siteDeParisMetier.validitePasswordGestionnaire(null);
				System.out.println(
						"validitePasswordGestionnaire avec un password gestionnaire invalide (non instancié) n'a pas levé l'exception MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"validitePasswordGestionnaire avec un password gestionnaire invalide (non instancié)  n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.validitePasswordGestionnaire("ax2a3t");
				System.out.println(
						"validitePasswordGestionnaire avec un password gestionnaire invalide (moins de 8 caracteres) n'a pas levé l'exception MetierException ");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"validitePasswordGestionnaire avec un password gestionnaire invalide (moins de 8 caracteres)  n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.validitePasswordGestionnaire("qsdf452 3e");
				System.out.println(
						"validitePasswordGestionnaire avec un password gestionnaire invalide (un espace) n'a pas levé l'exception MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"validitePasswordGestionnaire avec validitePasswordGestionnaire avec un password gestionnaire invalide (un espace)  n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.validitePasswordGestionnaire("qsdf-523e");
				System.out.println(
						"validitePasswordGestionnaire avec un password gestionnaire invalide (un -) n'a pas levé l'exception MetierException ");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"validitePasswordGestionnaire avec validitePasswordGestionnaire avec un password gestionnaire invalide (un -)  n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

		} catch (Exception e) {
			System.out.println("\n Exception imprévue : " + e);
			e.printStackTrace();
		}

	}

	public static void testInscrireDesinscrireJoueur() {

		System.out.println("\n testInscrireDesinscrireJoueur");

		try {

			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			// inscription correcte de joueurs

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"),
					new String("nanard"), new String("ilesCaimans"));
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"),
					new String("fanfan"), new String("ilesCaimans"));
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"),
					new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"),
					new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"),
					new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"),
					new String("zinzin"), new String("ilesCaimans"));

			// inscription incorrecte de joueurs

			try {
				siteDeParisMetier.inscrireJoueur("Maradona", null, "world1Champ", new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec un prenom invalide (non instancié) n'a pas levé l'exception JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un prenom invalide (non instancié)  n'a pas levé l'exception JoueurException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(null, "Diego", "world2Champ", new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec un nom invalide (non instancié) n'a pas levé l'exception JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un nom invalide (non instancié)  n'a pas levé l'exception JoueurException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Maradonaa", "Diegoa", null, new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec un pseudo invalide (non instancié) n'a pas levé l'exception JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un pseudo invalide (non instancié)  n'a pas levé l'exception JoueurException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Maradonab", "Diegob", "world3Champ", null);
				System.out.println(
						"inscrire un joueur avec un password gestionnaire  invalide (non instancié) n'a pas levé l'exception MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un password gestionnaire  invalide (non instancié) n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(new String("Duran"), new String(" "), "world4Champ",
						new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec un prénom invalide (un seul caractère : espace) n'a pas levé l'exception JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un prénom invalide (un seul caractère : espace)  n'a pas levé l'exception JoueurException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Dur an", "Carlos", "world5Champ", new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec un nom invalide (Dur an) n'a pas levé l'exception JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un nom invalide (Dur an)  n'a pas levé l'exception JoueurException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("D'Espagne", "Philippe", "leRoi", new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec un nom invalide (un caractère ') n'a pas levé l'exception JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un nom invalide (un caractère ')  n'a pas levé l'exception JoueurException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(new String("Nobel"), new String("Alfred"), new String("tnt"),
						new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec un pseudo invalide (moins de 4 caractères) n'a pas levé l'exception JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un pseudo invalide (moins de 4 caractères)  n'a pas levé l'exception JoueurException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Nobela", "Alfreda", "tnt.43", new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec un pseudo invalide (un caractère .) n'a pas levé l'exception JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un pseudo invalide (un caractère .)  n'a pas levé l'exception JoueurException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Durana", "Robertoa", "worldChampa", "abef");
				System.out.println(
						"inscrire un joueur avec un password gestionnaire  invalide (moins de 8 caractères) n'a pas levé l'exception MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un password gestionnaire  invalide (moins de 8 caractères) n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Duranb", "Robertob", "worldChampb", "onSaitJamais");
				System.out.println(
						"inscrire un joueur avec un password gestionnaire  incorrect n'a pas levé l'exception MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un password gestionnaire  incorrect n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"),
						new String("ilesCaimans"));
				System.out.println("inscrire un joueur existant n'a pas levé l'exception JoueurExistantException");
			} catch (JoueurExistantException e) {
			} catch (Exception e) {
				System.out
						.println("inscrire un joueur existant  n'a pas levé l'exception JoueurExistantException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"), "titi",
						new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec même nom et prénom n'a pas levé l'exception JoueurExistantException");
			} catch (JoueurExistantException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec même nom et prénom   n'a pas levé l'exception JoueurExistantException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(new String("Martin"), new String("Pierre"), new String("momo"),
						new String("ilesCaimans"));
				System.out.println(
						"inscrire un joueur avec un pseudo existant n'a pas levé l'exception JoueurExistantException");
			} catch (JoueurExistantException e) {
			} catch (Exception e) {
				System.out.println(
						"inscrire un joueur avec un pseudo existant  n'a pas levé l'exception JoueurExistantException mais "
								+ e.getClass().getName());
			}

			// désinscription incorrecte de joueurs

			try {
				siteDeParisMetier.desinscrireJoueur(new String("lolita"), new String("avfrqwxx"), new String("tryui"),
						new String("ilesCaimans"));
				System.out.println(
						"désinscrire un joueur inexistant n'a pas levé l'exception JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"désinscrire un joueur inexistant n'a pas levé l'exception JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.desinscrireJoueur(new String("Prou"), new String("Bernard"), new String("nanard"),
						"ilesVierges");
				System.out.println(
						"désinscrire un joueur avec un  password gestionnaire incorrect n'a pas levé l'exception MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"désinscrire un joueur avec un  password gestionnaire incorrect n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			// désinscription correcte d'un joueur
			siteDeParisMetier.desinscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"),
					new String("ilesCaimans"));

			// désinscription incorrecte d'un joueur déja désinscrit

			try {
				siteDeParisMetier.desinscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"),
						new String("ilesCaimans"));
				System.out.println(
						"désinscrire un joueur déjà retiré n'a pas levé l'exception JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"désinscrire un joueur déjà retiré n'a pas levé l'exception JoueurInexistantException mais "
								+ e.getClass().getName());
			}

		} catch (Exception e) {
			System.out.println("\n Exception imprévue : " + e);
			e.printStackTrace();
		}

	}

	public static void testAjouterCompetition() {

		System.out.println("\n testAjouterCompetition");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);

			// ajout incorrect de compétition

			try {
				siteDeParisMetier.ajouterCompetition(new String("finaleRG2055"), new DateFrancaise(4, 8, 2055),
						new String[] { "Clijsters", "Navratilova" }, null);
				System.out.println(
						"l'ajout d'une compétition avec un password gestionnaire invalide (non instancié)  n'a pas levé l'exception MetierException ");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un password gestionnaire invalide (non instancié) n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2065", new DateFrancaise(4, 8, 2055),
						new String[] { "Clijsters", "Navratilova" }, "12aze");
				System.out.println(
						"l'ajout d'une compétition avec un password gestionnaire invalide (moins de 8 caractères)  n'a pas levé l'exception MetierException ");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un password gestionnaire invalide (moins de 8 caractères) n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2075", new DateFrancaise(4, 8, 2055),
						new String[] { "Clijsters", "Navratilova" }, "ilesXCaimans");
				System.out.println(
						"l'ajout d'une compétition avec un password gestionnaire incorrect  n'a pas levé l'exception MetierException ");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un password gestionnaire incorrect n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition(null, new DateFrancaise(4, 8, 2011),
						new String[] { "Clijsters", "Zvonareva" }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un nom invalide (non instancié) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un nom invalide (non instancié)  n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("Championnat DeFrance2014", new DateFrancaise(27, 6, 2013, 20, 00),
						new String[] { new String("Lyon"), new String("Nantes"), new String("Lens"),
								new String("Marseille"), "Paris", new String("Rennes"), "StEtienne",
								new String("Lille"), "Nancy", "Toulouse", },
						new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un nom invalide (avec espace) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un nom invalide (avec espace)  n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finale|RG2012", new DateFrancaise(4, 8, 2011),
						new String[] { "Clijsters", "Zvonareva" }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un nom invalide (caractere |) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un nom invalide (caractere |)  n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("RGA", new DateFrancaise(4, 8, 2011),
						new String[] { "Clijsters", "Zvonareva" }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un nom invalide (moins de 4 caractères) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un nom invalide (moins de 4 caractères)  n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2032", null, new String[] { "Clijsters", "Zvonareva" },
						new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec une date invalide (non instanciée) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec une date invalide (non instanciée) n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2044", new DateFrancaise(4, 8, 20441), null,
						new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un tableau de compétiteurs invalide (non instancié) n'a pas levé l'exception MetierException ");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un tableau de compétiteurs invalide (non instancié)  n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2044", new DateFrancaise(4, 8, 20441),
						new String[] { "Clijsters" }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un seul compétiteur    n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un seul compétiteur   n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2044", new DateFrancaise(4, 8, 20441),
						new String[] { "Clijsters", null }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un nom de compétiteur invalide (non instancié) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un nom de compétiteur invalide (non instancié)  n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2014", new DateFrancaise(4, 8, 2011),
						new String[] { "Clij sters", "Zvonareva" }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un nom de compétiteur invalide (avec espace) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un nom de compétiteur invalide (avec espace)  n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2015", new DateFrancaise(4, 8, 2011),
						new String[] { "Clijters", "Zvo" }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un nom de compétiteur invalide (moins de 4 caracteres) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un nom de compétiteur invalide (moins de 4 caracteres)  n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2016", new DateFrancaise(4, 8, 2011),
						new String[] { "Cler*s", "Zvonareva" }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec un nom de compétiteur invalide (caractere *) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un nom de compétiteur invalide (caractere *)  n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2017", new DateFrancaise(4, 8, 2011),
						new String[] { "Zvonareva", "Zvonareva" }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec deux compétiteurs de même nom  n'a pas levé l'exception CompetitionException");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec un nom de compétiteur avec deux compétiteurs de même nom n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2018", new DateFrancaise(4, 8, 2009),
						new String[] { "Clijsters", "Zvonareva" }, new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition avec date passée n'a pas levé l'exception CompetitionException");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"l'ajout d'une compétition avec avec date passée n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			// ajout correct de compétition

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2016"),
					new DateFrancaise(4, 6, 2016, 15, 00),
					new String[] { new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"),
							new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre" },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2017"),
					new DateFrancaise(27, 6, 2017, 20, 00),
					new String[] { new String("Lyon"), new String("Nantes"), new String("Lens"),
							new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"),
							"Nancy", "Toulouse", },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2018"), new DateFrancaise(7, 6, 2018, 15, 00),
					new String[] { new String("Tsonga"), new String("Nadal") }, new String("ilesCaimans"));

			try {
				siteDeParisMetier.ajouterCompetition(
						new String("ChampionnatDeFrance2016"), new DateFrancaise(4, 6, 2016, 15, 00), new String[] {
								new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre" },
						new String("ilesCaimans"));
				System.out.println(
						"l'ajout d'une compétition existante n'a pas levé l'exception CompetitionExistanteException");
			} catch (CompetitionExistanteException e) {
			}

		} catch (Exception e) {
			System.out.println("\n Exception imprévue : " + e);
			e.printStackTrace();
		}
	}

	public static void testCrediterDebiterJoueur() {

		System.out.println("\n testCrediterDebiterJoueur");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));
			DateFrancaise.setDate(1, 1, 2010);

			// inscription de joueurs

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"),
					new String("nanard"), new String("ilesCaimans"));
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"),
					new String("fanfan"), new String("ilesCaimans"));
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"),
					new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"),
					new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"),
					new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"),
					new String("zinzin"), new String("ilesCaimans"));

			// TESTS SUR LES CREDITS

			// Password Gestionnaire non instanci�

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 5,
						null);
				System.out.println("Crediter un Joueur avec un password non instanci� n'a pas lev� MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out
						.println("Crediter un Joueur avec un password non instanci� n'a pas lev� MetierException mais "
								+ e.getClass().getName());
			}

			// Password Gestionnaire invalide

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 5,
						new String("12*/-!�12"));
				System.out.println("Crediter un Joueur avec un password invalide n'a pas lev� MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println("Crediter un Joueur avec un password invalide n'a pas lev� MetierException mais "
						+ e.getClass().getName());
			}

			// Password Gestionnaire incorrect

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 5,
						new String("incorrec"));
				System.out.println("Crediter un Joueur avec un password incorrect n'a pas lev� MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println("Crediter un Joueur avec un password incorrect n'a pas lev� MetierException mais "
						+ e.getClass().getName());
			}

			// SommeEnJetons negative

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), -5,
						new String("ilesCaimans"));
				System.out.println("Crediter un Joueur avec une somme n�gative n'a pas lev� MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println("Crediter un Joueur avec une somme n�gative n'a pas lev� MetierException mais "
						+ e.getClass().getName());
			}

			// Nom non instanci�

			try {
				siteDeParisMetier.crediterJoueur(null, new String("Bernard"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println("Crediter un Joueur dont le nom est non instanci� n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("Crediter un Joueur dont le nom est non instanci� n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// Nom invalide

			try {
				siteDeParisMetier.crediterJoueur(new String("84*/!zeghsdf"), new String("Bernard"),
						new String("nanard"), 5, new String("ilesCaimans"));
				System.out.println("Crediter un Joueur dont le nom est invalide n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("Crediter un Joueur dont le nom est invalide n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// Prenom non instanci�
			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), null, new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println("Crediter un Joueur dont le pr�nom est non instanci� n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"Crediter un Joueur dont le pr�nom est non instanci� n'a pas lev� JoueurException mais "
								+ e.getClass().getName());
			}

			// Prenom invalide

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("8/*-/*8"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println("Crediter un Joueur dont le pr�nom est invalide n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("Crediter un Joueur dont le pr�nom est invalide n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// pseudo non instanci�

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), null, 5,
						new String("ilesCaimans"));
				System.out.println("Crediter un Joueur dont le pseudo est non isntanci� n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"Crediter un Joueur dont le pseudo est non instanci� n'a pas lev� JoueurException mais "
								+ e.getClass().getName());
			}

			// Pseudo invalide

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("456/**/*="), 5,
						new String("ilesCaimans"));
				System.out.println("Crediter un Joueur dont le pseudo est non invalide n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("Crediter un Joueur dont le pseudo est invalide n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// Nom, Prenom, pseudo inexsitants

			// Nom inexistant

			try {
				siteDeParisMetier.crediterJoueur(new String("Rupi"), new String("Bernard"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out
						.println("Crediter un Joueur dont le Nom n'existe pas n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"Crediter un Joueur dont le Nom n'existe pas n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Prenom inexistant

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Boubou"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"Crediter un Joueur dont le pr�nom n'existe pas n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"Crediter un Joueur dont le pr�nom n'existe pas n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Pseudo inexistant

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nounou"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"Crediter un Joueur dont le pseudo n'existe pas n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"Crediter un Joueur dont le pseudo n'existe pas n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Combinaison Nom, Prenom incorrecte

			try {
				siteDeParisMetier.crediterJoueur(new String("Nadou"), new String("Bernard"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"Un joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"Un  joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Combinaison Nom, pseudo incorrecte

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("zinzin"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"Un 2 joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"Un joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Combinaison Prenom, Pseudo incorrecte

			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("fanfan"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"Un 3 joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"Un joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// TESTS DEBITS

			// Password Gestionnaire non instanci�

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 5,
						null);
				System.out.println("debiter un Joueur avec un password non instanci� n'a pas lev� MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println("debiter un Joueur avec un password non instanci� n'a pas lev� MetierException mais "
						+ e.getClass().getName());
			}

			// Password Gestionnaire invalide

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 5,
						new String("12*!/!�12"));
				System.out.println("debiter un Joueur avec un password invalide n'a pas lev� MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println("debiter un Joueur avec un password invalide n'a pas lev� MetierException mais "
						+ e.getClass().getName());
			}

			// Password Gestionnaire incorrect

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 5,
						new String("incorrec"));
				System.out.println("debiter un Joueur avec un password invalide n'a pas lev� MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println("debiter un Joueur avec un password invalide n'a pas lev� MetierException mais "
						+ e.getClass().getName());
			}

			// SommeEnJetons negative

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), -5,
						new String("ilesCaimans"));
				System.out.println("debiter un Joueur avec une somme n�gative n'a pas lev� MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println("debiter un Joueur avec une somme n�gative n'a pas lev� MetierException mais "
						+ e.getClass().getName());
			}

			// Nom non instanci�

			try {
				siteDeParisMetier.debiterJoueur(null, new String("Bernard"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println("debiter un Joueur dont le nom est non instanci� n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("debiter un Joueur dont le nom est non instanci� n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// Nom invalide

			try {
				siteDeParisMetier.debiterJoueur(new String("84*!zeghsdf"), new String("Bernard"), new String("nanard"),
						5, new String("ilesCaimans"));
				System.out.println("debiter un Joueur dont le nom est invalide n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("debiter un Joueur dont le nom est invalide n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// Prenom non instanci�
			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), null, new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println("debiter un Joueur dont le pr�nom est non instanci� n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out
						.println("debiter un Joueur dont le pr�nom est non instanci� n'a pas lev� JoueurException mais "
								+ e.getClass().getName());
			}

			// Prenom invalide

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("8/*-/*8"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println("debiter un Joueur dont le pr�nom est invalide n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("debiter un Joueur dont le pr�nom est invalide n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// pseudo non instanci�

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), null, 5,
						new String("ilesCaimans"));
				System.out.println("debiter un Joueur dont le pseudo est non isntanci� n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out
						.println("debiter un Joueur dont le pseudo est non instanci� n'a pas lev� JoueurException mais "
								+ e.getClass().getName());
			}

			// Pseudo invalide

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("1*1/2*="), 5,
						new String("ilesCaimans"));
				System.out.println("debiter un Joueur dont le pseudo est non invalide n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("debiter un Joueur dont le pseudo est invalide n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// Nom, Prenom, pseudo inexsitants

			// Nom inexistant

			try {
				siteDeParisMetier.debiterJoueur(new String("Rupi"), new String("Bernard"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println("debiter un Joueur dont le Nom n'existe pas n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"debiter un Joueur dont le Nom n'existe pas n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Prenom inexistant

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Boubou"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"debiter un Joueur dont le pr�nom n'existe pas n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"debiter un Joueur dont le pr�nom n'existe pas n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Pseudo inexistant

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nounou"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"debiter un Joueur dont le pseudo n'existe pas n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"debiter un Joueur dont le pseudo n'existe pas n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Combinaison Nom, Prenom incorrecte

			try {
				siteDeParisMetier.debiterJoueur(new String("Nadou"), new String("Bernard"), new String("nanard"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"Un joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"Un joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Combinaison Nom, pseudo incorrecte

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("zinzin"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"Un joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"Un joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Combinaison Prenom, Pseudo incorrecte

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("fanfan"), 5,
						new String("ilesCaimans"));
				System.out.println(
						"Un joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println(
						"Un joueur dont la combinaison Nom, Pr�nom, pseudo est incorrecte n'a pas lev� JoueurInexistantException mais "
								+ e.getClass().getName());
			}

			// Le Joueur poss�de assez d'argent pour �tre d�bit�

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 2000,
						new String("ilesCaimans"));
				System.out.println(
						"Un joueur ayant un compte insuffisant pour un d�bit de cette somme n'a pas lev�l'exception JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"Un joueur ayant un compte insuffisant pour un d�bit de cette somme n'a pas lev� l'exception JoueurException mais "
								+ e.getClass().getName());
			}

		} catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}

	}

	public static void testMiserVainqueur() {

		System.out.println("\n testMiserVainqueur");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);

			// inscription de joueurs

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"),
					new String("nanard"), new String("ilesCaimans"));
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"),
					new String("fanfan"), new String("ilesCaimans"));
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"),
					new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"),
					new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"),
					new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"),
					new String("zinzin"), new String("ilesCaimans"));

			// cr�dit de joueurs

			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1789,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), 1917,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 1848,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 785,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1123,
					new String("ilesCaimans"));

			// ajout de comp�tions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"),
					new DateFrancaise(4, 6, 2012, 15, 00),
					new String[] { new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"),
							new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre" },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00),
					new String[] { new String("Tsonga"), new String("Nadal") }, new String("ilesCaimans"));

			// Miser incorrectement sur un vainqueur ( probl�mes de pseudo, password, mise
			// en jetons,
			// vainqueur, competition, date, etc )

			DateFrancaise.setDate(27, 6, 2013, 20, 10);

			// password pas li� au pseudo

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), "passwdfa", 40,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("miser avec un password joueur faux n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println("miser avec un password joueur faux n'a pas lev� JoueurInexistantException mais "
						+ e.getClass().getName());
			}

			// pseudo inexistant

			try {
				siteDeParisMetier.miserVainqueur("jeann", new String(passwdBernard), 40,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("miser avec un pseudo qui n'existe pas n'a pas lev� JoueurInexistantException");
			} catch (JoueurInexistantException e) {
			} catch (Exception e) {
				System.out.println("miser avec un pseudo qui n'existe pas n'a pas lev� JoueurInexistantException mais "
						+ e.getClass().getName());
			}

			// pseudo joueur invalide

			try {
				siteDeParisMetier.miserVainqueur("zz*:!eu", new String(passwdBernard), 40,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("miser avec un pseudo invalide n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"miser avec un pseudo invalide n'a pas lev� JoueurException mais " + e.getClass().getName());
			}

			// pseudo joueur non instanci�

			try {
				siteDeParisMetier.miserVainqueur(null, new String(passwdBernard), 40,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("miser avec un pseudo non instanci� n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("miser avec un pseudo non instanci� n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// password joueur invalide

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), "aze*:!", 40,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("miser avec un password invalide n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"miser avec un password invalide n'a pas lev� JoueurException mais " + e.getClass().getName());
			}

			// password joueur non instanci�
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), null, 40, new String("ChampionnatDeFrance2012"),
						new String("Lyon"));
				System.out.println("miser avec un password joueur non instanci� n'a pas lev� JoueurException");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println("miser avec un password joueur  non instanci� n'a pas lev� JoueurException mais "
						+ e.getClass().getName());
			}

			// Competition Inexistante

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40,
						new String("TourDuRwanda2018"), new String("Lyon"));
				System.out
						.println("miser sur une competition inexistante n'a pas lev� CompetitionInexistanteException");
			} catch (CompetitionInexistanteException e) {
			} catch (Exception e) {
				System.out.println(
						"miser sur une competition inexistante n'a pas lev� CompetitionInexistanteException mais "
								+ e.getClass().getName());
			}

			// Date de cloture dans le pass�

			DateFrancaise.setDate(27, 6, 2030, 20, 10); // On se place dans le futur pour que les dates de clotures
														// soient dans le pass�
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println(
						"miser sur une competition dont la date de cloture est dans le pass� n'a pas lev� CompetitionException");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"miser sur une competition dont la date de cloture est dans le pass� n'a pas lev� CompetitionException mais "
								+ e.getClass().getName());
			}

			DateFrancaise.setDate(27, 6, 2010, 20, 10); // On remet la bonne date !

			// Competition invalide

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, "9*88!rd",
						new String("Lyon"));
				System.out.println("miser sur une competition invalide n'a pas lev� CompetitionException");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println("miser sur une competition invalide n'a pas lev� CompetitionException mais "
						+ e.getClass().getName());
			}

			// Competition non instanci�e

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, null,
						new String("Lyon"));
				System.out.println("miser sur une competition non instanci�e n'a pas lev� CompetitionException");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println("miser sur une competition non instanci�e n'a pas lev� CompetitionException mais "
						+ e.getClass().getName());
			}

			// Vainqueur envisag� inexistant dans la comp�tition

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40,
						new String("ChampionnatDeFrance2012"), new String("JeanFelix"));
				System.out.println(
						"Envisager un vainqueur inexistant ou pas dans la competition n'a pas lev� CompetitionException");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"Envisager un vainqueur inexistant ou pas dans la competition n'a pas lev� CompetitionException mais "
								+ e.getClass().getName());
			}

			// Vainqueur envisag� non instanci�

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40,
						new String("ChampionnatDeFrance2012"), null);
				System.out.println("Envisager un vainqueur non instanci� n'a pas lev� CompetitionException");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println("Envisager un vainqueur non instanci� n'a pas lev� CompetitionException mais "
						+ e.getClass().getName());
			}

			// miser une somme n�gative

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), -40,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("miser avec miseEnjeton negative n'a pas lev� MetierException");

			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"miser avec miseEnjeton negative sans lever MetierException  mais " + e.getClass().getName());
			}
			// Compte en Jetons insuffisant

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard),
						2000 /* Bernard avait 1789 sur son compte */, new String("ChampionnatDeFrance2012"),
						new String("Lyon"));
				System.out.println("Miser avec un Compte insuffisant n'a pas lev� JoueurException");

			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"Miser avec un Compte insuffisant n'a pas lev� JoueurException mais " + e.getClass().getName());
			}

			// TESTS : APRES AVOIR MISE, ON A BIEN DEBITE LES BONS JOUEURS

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 1000,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));

			} catch (Exception e) {
				System.out.println(
						"Miser correctement (1) a lev� l'exception impr�vue suivante" + e.getClass().getName());
			}

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 789,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));

			} catch (Exception e) {
				System.out.println(
						"Miser correctement (2) a lev� l'exception impr�vue suivante " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 1,
						new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println(
						" Le compte de nanard aurait d� �tre insuffisant car on a d�j� pari� 1000+789 alors qu'il avait un solde de 1789. JoueurException aurait d� �tre lev�e donc le d�bit n'est pas correctement effectu� au moment de miser");

			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"Le compte de nanard aurait d� �tre insuffisant car on a d�j� pari� 1000+789 alors qu'il avait un solde de 1789. JoueurException doit �tre lev�e et non pas "
								+ e.getClass().getName());
			}
		} catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}

	}

	public static void testSolderVainqueur() {

		System.out.println("\n testSolderVainqueur");
		// tests solder pour des competitions avec parieurs non gagnants ou sans parieur
		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);

			// inscription de joueurs

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"),
					new String("nanard"), new String("ilesCaimans"));
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"),
					new String("fanfan"), new String("ilesCaimans"));
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"),
					new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"),
					new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"),
					new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"),
					new String("zinzin"), new String("ilesCaimans"));

			// cr�dit de joueurs

			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1789,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), 1917,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 1848,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 785,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1123,
					new String("ilesCaimans"));

			// ajout de comp�tions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"),
					new DateFrancaise(4, 6, 2012, 15, 00),
					new String[] { new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"),
							new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre" },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00),
					new String[] { new String("Tsonga"), new String("Nadal") }, new String("ilesCaimans"));

			// parier correctement sur un vainqueur

			siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40,
					new String("ChampionnatDeFrance2012"), new String("Lyon"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), new String(passwdFrancoise), 20,
					new String("ChampionnatDeFrance2012"), new String("Brest"));
			siteDeParisMetier.miserVainqueur(new String("zinzin"), new String(passwdSylvain), 40,
					new String("ChampionnatDeFrance2012"), new String("Lille"));
			siteDeParisMetier.miserVainqueur(new String("aure"), new String(passwdAureliane), 37,
					new String("ChampionnatDeFrance2012"), new String("Marseille"));

			// solder incorrectement un vainqueur

			try {
				siteDeParisMetier.solderVainqueur(new String("finaleRG2012"), new String("Nadal"),
						new String("ilesCaimans"));
				System.out.println("une comp�tition non termin�e a �t� sold�e sans lever CompetitionException");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println("une comp�tition non termin�e a �t� sold�e sans lever CompetitionException mais "
						+ e.getClass().getName());
			}

			DateFrancaise.setDate(27, 6, 2013, 20, 10);

			try {
				siteDeParisMetier.solderVainqueur(new String("finaleRG2012"), "Federer", new String("ilesCaimans"));
				System.out.println(
						"une comp�tition avec un vainqueur inexistant a �t� sold�e sans lever CompetitionException");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"uune comp�tition avec un vainqueur inexistant a �t� sold�e sans lever CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.solderVainqueur(new String("finaleRG2012"), new String("Tsonga"), "ilesCimans");
				System.out.println(
						"une comp�tition a �t� sold�e avec un password gestionnaire incorrect sans lever MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"uune comp�tition a �t� sold�e avec un password gestionnaire incorrect sans lever MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.solderVainqueur(new String("finaleRG2012"), new String("Tsonga"), "il*ns");
				System.out.println(
						"une comp�tition a �t� sold�e avec un password gestionnaire invalide sans lever MetierException");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"une comp�tition a �t� sold�e avec un password gestionnaire invalide sans lever MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.solderVainqueur("ChampionnatDeRance2012", new String("Marseille"),
						new String("ilesCaimans"));
				System.out
						.println("une comp�tition inexistante est  sold�e sans lever CompetitionInexistanteException");
			} catch (CompetitionInexistanteException e) {
			} catch (Exception e) {
				System.out.println(
						"uune comp�tition inexistante est  sold�e sans lever CompetitionInexistanteException mais "
								+ e.getClass().getName());
			}

			// solder correctement un vainqueur

			DateFrancaise.setDate(4, 6, 2012, 18, 10);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2012"), "Nancy",
					new String("ilesCaimans"));
			DateFrancaise.setDate(7, 6, 2012, 18, 30);
			siteDeParisMetier.solderVainqueur(new String("finaleRG2012"), new String("Tsonga"),
					new String("ilesCaimans"));

			// solder une competition d�ja sold�e
			try {
				siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2012"), "Nancy",
						new String("ilesCaimans"));
				System.out
						.println("une comp�tition d�ja sold�e est  sold�e sans lever CompetitionInexistanteException");
			} catch (CompetitionInexistanteException e) {
			} catch (Exception e) {
				System.out
						.println("une comp�tition d�ja sold�e  sold�e sans lever CompetitionInexistanteException mais "
								+ e.getClass().getName());
			}

			// on v�rifie deux cr�dits restants

			// nanard doit avoir une cr�dit de 1789

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1790,
						new String("ilesCaimans"));
				System.out.println(
						"le credit de bernard devrait �tre inf�rieur � 1790, et l'exception JoueurException aurait d� �tre lev�e");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"le credit de bernard devrait �tre inf�rieur � 1790, et l'exception JoueurException aurait d� �tre lev�e mais c'est : "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1749,
						new String("ilesCaimans"));
			} catch (JoueurException e) {
				System.out.println(
						"le credit de bernard devrait �tre �gal � 1749 car il a mis� 40 euros auparavant dans ce test, sur Lyon qui n'est oas vainqueur de cette compet, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} catch (Exception e) {
				System.out.println(
						"le credit de bernard devrait �tre �gal � 1749 car il a mis� 40 euros auparavant dans ce test, sur Lyon qui n'est oas vainqueur de cette compet, et l'exception suivante n'aurait pas du �tre lev�e"
								+ e.getClass().getName());
			}

			// aure doit avoir un cr�dit de 785

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 786,
						new String("ilesCaimans"));
				System.out.println(
						"le credit d'aure devrait �tre inf�rieur � 786, et l'exception JoueurException aurait d� �tre lev�e");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"le credit d'aure devrait �tre inf�rieur � 786, et l'exception JoueurException aurait d� �tre lev�e mais c'est : "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 748,
						new String("ilesCaimans"));
			} catch (JoueurException e) {
				System.out.println(
						"le credit d'aure devrait �tre �gal � 748, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} catch (Exception e) {
				System.out.println(
						"le credit d'aure devrait �tre �gal � 748, et aucune exception n'aurait d� �tre lev�e mais c'est : "
								+ e.getClass().getName());
			}

		} catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}

		// tests solder pour des competitions avec parieurs, avec un gagnant, avec
		// plusieurs gagnants
		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);

			// inscription de joueurs

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"),
					new String("nanard"), new String("ilesCaimans"));
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"),
					new String("fanfan"), new String("ilesCaimans"));
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"),
					new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"),
					new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"),
					new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"),
					new String("zinzin"), new String("ilesCaimans"));

			// cr�dit de joueurs

			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1789,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), 1917,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 1848,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 785,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1123,
					new String("ilesCaimans"));

			// ajout de comp�tions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"),
					new DateFrancaise(4, 6, 2012, 15, 00),
					new String[] { new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"),
							new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre" },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"),
					new DateFrancaise(27, 6, 2013, 20, 00),
					new String[] { new String("Lyon"), new String("Nantes"), new String("Lens"),
							new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"),
							"Nancy", "Toulouse", },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00),
					new String[] { new String("Tsonga"), new String("Nadal") }, new String("ilesCaimans"));

			// parier correctement sur un vainqueur

			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 50, new String("finaleRG2012"),
					new String("Tsonga"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 70, new String("finaleRG2012"),
					new String("Nadal"));
			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 200, new String("finaleRG2012"),
					new String("Tsonga"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 20, new String("finaleRG2012"),
					new String("Tsonga"));
			siteDeParisMetier.miserVainqueur(new String("zinzin"), passwdSylvain, 40, new String("finaleRG2012"),
					new String("Nadal"));

			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 40,
					new String("ChampionnatDeFrance2012"), new String("Lyon"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 20,
					new String("ChampionnatDeFrance2012"), new String("Brest"));
			siteDeParisMetier.miserVainqueur(new String("zinzin"), passwdSylvain, 40,
					new String("ChampionnatDeFrance2012"), new String("Lille"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 37,
					new String("ChampionnatDeFrance2012"), new String("Marseille"));

			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 80,
					new String("ChampionnatDeFrance2013"), new String("Nantes"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 30,
					new String("ChampionnatDeFrance2013"), new String("Rennes"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 48,
					new String("ChampionnatDeFrance2013"), new String("Nantes"));

			// solder correctement les trois competitions

			DateFrancaise.setDate(4, 6, 2012, 18, 10);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2012"), new String("Marseille"),
					new String("ilesCaimans"));
			DateFrancaise.setDate(7, 6, 2012, 18, 30);
			siteDeParisMetier.solderVainqueur(new String("finaleRG2012"), new String("Tsonga"),
					new String("ilesCaimans"));
			DateFrancaise.setDate(27, 6, 2013, 23, 00);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2013"), new String("Nantes"),
					new String("ilesCaimans"));

			// on v�rifie trois cr�dits restants

			// nanard doit avoir un cr�dit de 1868

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1869,
						new String("ilesCaimans"));
				System.out.println(
						"le credit de bernard devrait �tre inf�rieur � 1869, et l'exception JoueurException aurait d� �tre lev�e");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"le credit de bernard devrait �tre inf�rieur � 1869, et l'exception JoueurException aurait d� �tre lev�e mais c'est : "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1868,
						new String("ilesCaimans"));
			} catch (JoueurException e) {
				System.out.println(
						"le credit de bernard devrait �tre �gal � 1868, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} catch (Exception e) {
				System.out.println(
						"le credit de bernard devrait �tre �gal � 1868, et aucune exception n'aurait d� �tre lev�e mais c'est : "
								+ e.getClass().getName());
			}

			// aure doit avoir un cr�dit de 904

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 905,
						new String("ilesCaimans"));
				System.out.println(
						"le credit d'aure devrait �tre inf�rieur � 905, et l'exception JoueurException aurait d� �tre lev�e");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"le credit d'aure devrait �tre inf�rieur � 905, et l'exception JoueurException aurait d� �tre lev�e mais c'est : "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 904,
						new String("ilesCaimans"));
			} catch (JoueurException e) {
				System.out.println(
						"le credit d'aure devrait �tre �gal � 904, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} catch (Exception e) {
				System.out.println(
						"le credit d'aure devrait �tre �gal � 904, et aucune exception n'aurait d� �tre lev�e mais c'est : "
								+ e.getClass().getName());
			}

			// zinzin doit avoir un cr�dit de 1043

			try {
				siteDeParisMetier.debiterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1044,
						new String("ilesCaimans"));
				System.out.println(
						"le credit de zinzin devrait �tre inf�rieur � 1044, et l'exception JoueurException aurait d� �tre lev�e");
			} catch (JoueurException e) {
			} catch (Exception e) {
				System.out.println(
						"le credit de zinzin devrait �tre inf�rieur � 1044, et l'exception JoueurException aurait d� �tre lev�e mais c'est : "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.debiterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1043,
						new String("ilesCaimans"));
			} catch (JoueurException e) {
				System.out.println(
						"le credit de zinzin devrait �tre �gal � 1043, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} catch (Exception e) {
				System.out.println(
						"le credit de zinzin devrait �tre �gal � 1043, et aucune exception n'aurait d� �tre lev�e mais c'est : "
								+ e.getClass().getName());
			}

		} catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}

	}

	public static void testConsulterCompetitions() {

		System.out.println("\n testConsulterCompetitions");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);

			if (siteDeParisMetier.consulterCompetitions().size() != 0)
				System.out.println(
						"consulterCompetitions  rend une  liste non vide alors que  le site  vient d'être crée et sans qu'il y ait eu d'ajout de competitions");

			// ajout de compétions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"),
					new DateFrancaise(4, 6, 2012, 15, 00),
					new String[] { new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"),
							new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre" },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"),
					new DateFrancaise(27, 6, 2013, 20, 00),
					new String[] { new String("Lyon"), new String("Nantes"), new String("Lens"),
							new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"),
							"Nancy", "Toulouse", },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00),
					new String[] { new String("Tsonga"), new String("Nadal") }, new String("ilesCaimans"));

			if (siteDeParisMetier.consulterCompetitions().size() != 3)
				System.out.println("consulterCompetitions ne rend pas la liste des trois compétitions ajoutées");

			LinkedList<LinkedList<String>> competitions = siteDeParisMetier.consulterCompetitions();
			for (LinkedList<String> l : competitions) {
				if (l.get(0).equals(new String("ChampionnatDeFrance2012"))
						&& (!l.get(1).equals(new DateFrancaise(4, 6, 2012, 15, 00).toString())))
					System.out.println("probleme sur affichage ChampionnatDeFrance2012 ");
				if (l.get(0).equals(new String("ChampionnatDeFrance2013"))
						&& (!l.get(1).equals(new DateFrancaise(27, 6, 2013, 20, 00).toString())))
					System.out.println("probleme sur affichage ChampionnatDeFrance2013 ");
				if (l.get(0).equals(new String("finaleRG2012"))
						&& (!l.get(1).equals(new DateFrancaise(7, 6, 2012, 15, 00).toString())))
					System.out.println("probleme sur affichage finaleRG2012 ");
			}

			// solder correctement un vainqueur

			DateFrancaise.setDate(7, 6, 2012, 18, 30);
			siteDeParisMetier.solderVainqueur(new String("finaleRG2012"), new String("Tsonga"),
					new String("ilesCaimans"));

			if (siteDeParisMetier.consulterCompetitions().size() != 2)
				System.out.println("consulterCompetitions ne rend pas la liste des deux compétitions restantes");

			competitions = siteDeParisMetier.consulterCompetitions();
			for (LinkedList<String> l : competitions) {
				if (l.get(0).equals(new String("ChampionnatDeFrance2012"))
						&& (!l.get(1).equals(new DateFrancaise(4, 6, 2012, 15, 00).toString())))
					System.out.println("probleme sur affichage ChampionnatDeFrance2012 ");
				if (l.get(0).equals(new String("ChampionnatDeFrance2013"))
						&& (!l.get(1).equals(new DateFrancaise(27, 6, 2013, 20, 00).toString())))
					System.out.println("probleme sur affichage ChampionnatDeFrance2013 ");
				if (l.get(0).equals(new String("finaleRG2012")))
					System.out.println("la finaleRG2012 a été soldée et ne devrait pas être dans la liste");
			}

		} catch (Exception e) {
			System.out.println("\n Exception imprévue : " + e);
			e.printStackTrace();
		}
	}

	public static void testConsulterCompetiteurs() {

		System.out.println("\n testConsulterCompetiteurs");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			try {
				siteDeParisMetier.consulterCompetiteurs(null);
				System.out.println(
						"consulterCompetiteurs avec une competition invalide (non instancié) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"consulterCompetiteurs avec une competition invalide (non instancié) n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.consulterCompetiteurs("i2");
				System.out.println(
						"consulterCompetiteurs avec une competition invalide (moins de 4 caractères) n'a pas levé l'exception CompetitionException ");
			} catch (CompetitionException e) {
			} catch (Exception e) {
				System.out.println(
						"consulterCompetiteurs avec une competition invalide (moins de 4 caractères) n'a pas levé l'exception CompetitionException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.consulterCompetiteurs("inconnu");
				System.out.println(
						"consulterCompetiteurs avec une competition inexistante n'a pas levé l'exception CompetitionInexistanteException ");
			} catch (CompetitionInexistanteException e) {
			} catch (Exception e) {
				System.out.println(
						"consulterCompetiteurs avec une competition inexistante n'a pas levé l'exception CompetitionInexistanteException mais "
								+ e.getClass().getName());
			}

			DateFrancaise.setDate(1, 1, 2010);

			// ajout de compétions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"),
					new DateFrancaise(4, 6, 2012, 15, 00),
					new String[] { new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"),
							new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre" },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"),
					new DateFrancaise(27, 6, 2013, 20, 00),
					new String[] { new String("Lyon"), new String("Nantes"), new String("Lens"),
							new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"),
							"Nancy", "Toulouse", },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00),
					new String[] { new String("Tsonga"), new String("Nadal") }, new String("ilesCaimans"));

			LinkedList<String> competiteurs = siteDeParisMetier
					.consulterCompetiteurs(new String("ChampionnatDeFrance2012"));
			if (competiteurs.size() != 10)
				System.out.println(
						"consulterCompetiteurs ne rend pas une liste de deux compétiteurs pour le  ChampionnatDeFrance2012");
			if (!competiteurs.contains(new String("Lyon")))
				System.out.println(
						"consulterCompetiteurs ne rend pas pour le ChampionnatDeFrance2012 le compétiteur Lyon");
			if (!competiteurs.contains(new String("Rennes")))
				System.out.println(
						"consulterCompetiteurs ne rend pas pour le ChampionnatDeFrance2012 le compétiteur Rennes");
			if (!competiteurs.contains("Auxerre"))
				System.out.println(
						"consulterCompetiteurs ne rend pas pour le ChampionnatDeFrance2012 le compétiteur Auxerre");

			competiteurs = siteDeParisMetier.consulterCompetiteurs(new String("finaleRG2012"));
			if (competiteurs.size() != 2)
				System.out.println(
						"consulterCompetiteurs ne rend pas une liste de deux compétiteurs pour la  finaleRG2012");
			if (!competiteurs.contains(new String("Nadal")))
				System.out.println("consulterCompetiteurs ne rend pas pour la finaleRG2012 le compétiteur Nadal");
			if (!competiteurs.contains(new String("Tsonga")))
				System.out.println("consulterCompetiteurs ne rend pas pour la finaleRG2012 le compétiteur Tsonga");
		} catch (Exception e) {
			System.out.println("\n Exception imprévue : " + e);
			e.printStackTrace();
		}
	}

	public static void testConsulterJoueurs() {

		System.out.println("\n testConsulterJoueurs");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			try {
				siteDeParisMetier.consulterJoueurs(null);
				System.out.println(
						"consulterJoueurs avec un password invalide (non instancié) n'a pas levé l'exception MetierException ");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"consulterJoueurs avec un password invalide (non instancié) n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.consulterJoueurs("i2");
				System.out.println(
						"consulterJoueurs avec un password invalide (moins de 4 caractères) n'a pas levé l'exception MetierException ");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"consulterJoueurs avec un password invalide (moins de 4 caractères) n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			try {
				siteDeParisMetier.consulterJoueurs("inconnu");
				System.out.println(
						"consulterJoueurs avec un password incorrect n'a pas levé l'exception MetierException ");
			} catch (MetierException e) {
			} catch (Exception e) {
				System.out.println(
						"consulterJoueurs avec un password incorrect n'a pas levé l'exception MetierException mais "
								+ e.getClass().getName());
			}

			if (siteDeParisMetier.consulterJoueurs(new String("ilesCaimans")).size() != 0)
				System.out.println(
						"consulterJoueurs  rend une  liste non vide alors que  le site  vient d'être crée et sans qu'il y ait eu d'inscription de joueurs");

			DateFrancaise.setDate(1, 1, 2010);

			// inscription de joueurs

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"),
					new String("nanard"), new String("ilesCaimans"));
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"),
					new String("fanfan"), new String("ilesCaimans"));
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"),
					new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"),
					new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"),
					new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"),
					new String("zinzin"), new String("ilesCaimans"));

			if (siteDeParisMetier.consulterJoueurs(new String("ilesCaimans")).size() != 6)
				System.out.println(
						"consulterJoueurs  rend une  liste qui n'a pas 6 éléments alors qu'il y a eu inscription de 6 joueurs");

			// crédit de joueurs

			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1789,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), 1917,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 1848,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 785,
					new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1123,
					new String("ilesCaimans"));

			LinkedList<LinkedList<String>> joueurs = siteDeParisMetier.consulterJoueurs(new String("ilesCaimans"));
			for (LinkedList<String> l : joueurs) {
				if (l.get(2).equals(new String("momo"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Morgane"))
								|| !l.get(3).equals("" + 1848) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur momo après crédit");

				if (l.get(2).equals(new String("nanard"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Bernard"))
								|| !l.get(3).equals("" + 1789) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur nanard après crédit");

				if (l.get(2).equals(new String("zinzin"))
						&& (!l.get(0).equals(new String("Nadou")) || !l.get(1).equals(new String("Sylvain"))
								|| !l.get(3).equals("" + 1123) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur zinzin après crédit");

				if (l.get(2).equals(new String("aure"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Aureliane"))
								|| !l.get(3).equals("" + 785) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur aure après crédit");
			}

			// ajout de compétions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"),
					new DateFrancaise(4, 6, 2012, 15, 00),
					new String[] { new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"),
							new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre" },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"),
					new DateFrancaise(27, 6, 2013, 20, 00),
					new String[] { new String("Lyon"), new String("Nantes"), new String("Lens"),
							new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"),
							"Nancy", "Toulouse", },
					new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00),
					new String[] { new String("Tsonga"), new String("Nadal") }, new String("ilesCaimans"));

			// mises de joueurs

			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 40,
					new String("ChampionnatDeFrance2012"), new String("Lyon"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 20,
					new String("ChampionnatDeFrance2012"), new String("Brest"));
			siteDeParisMetier.miserVainqueur(new String("zinzin"), passwdSylvain, 40,
					new String("ChampionnatDeFrance2012"), new String("Lille"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 37,
					new String("ChampionnatDeFrance2012"), new String("Marseille"));

			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 80,
					new String("ChampionnatDeFrance2013"), new String("Nantes"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 30,
					new String("ChampionnatDeFrance2013"), new String("Rennes"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 48,
					new String("ChampionnatDeFrance2013"), new String("Nantes"));

			joueurs = siteDeParisMetier.consulterJoueurs(new String("ilesCaimans"));
			for (LinkedList<String> l : joueurs) {

				if (l.get(2).equals(new String("momo"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Morgane"))
								|| !l.get(3).equals("" + 1848) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur momo après paris");
				if (l.get(2).equals(new String("nanard"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Bernard"))
								|| !l.get(3).equals("" + 1669) || !l.get(4).equals("" + 120)))
					System.out.println("probleme sur affichage du joueur nanard après paris");
				if (l.get(2).equals(new String("zinzin"))
						&& (!l.get(0).equals(new String("Nadou")) || !l.get(1).equals(new String("Sylvain"))
								|| !l.get(3).equals("" + 1083) || !l.get(4).equals("" + 40)))
					System.out.println("probleme sur affichage du joueur zinzin après paris");
				if (l.get(2).equals(new String("aure"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Aureliane"))
								|| !l.get(3).equals("" + 700) || !l.get(4).equals("" + 85)))
					System.out.println("probleme sur affichage du joueur aure après paris");
			}

			DateFrancaise.setDate(4, 6, 2012, 18, 10);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2012"), new String("Marseille"),
					new String("ilesCaimans"));

			joueurs = siteDeParisMetier.consulterJoueurs(new String("ilesCaimans"));
			for (LinkedList<String> l : joueurs) {

				if (l.get(2).equals(new String("momo"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Morgane"))
								|| !l.get(3).equals("" + 1848) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur momo après premier solder");

				if (l.get(2).equals(new String("nanard"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Bernard"))
								|| !l.get(3).equals("" + 1669) || !l.get(4).equals("" + 80)))
					System.out.println("probleme sur affichage du joueur nanard après premier solder");

				if (l.get(2).equals(new String("zinzin"))
						&& (!l.get(0).equals(new String("Nadou")) || !l.get(1).equals(new String("Sylvain"))
								|| !l.get(3).equals("" + 1083) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur zinzin après premier solder");
				if (l.get(2).equals(new String("aure"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Aureliane"))
								|| !l.get(3).equals("" + 837) || !l.get(4).equals("" + 48)))
					System.out.println("probleme sur affichage du joueur aure après premier solder");
			}

			DateFrancaise.setDate(27, 6, 2013, 23, 00);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2013"), new String("Nantes"),
					new String("ilesCaimans"));

			joueurs = siteDeParisMetier.consulterJoueurs(new String("ilesCaimans"));
			for (LinkedList<String> l : joueurs) {

				if (l.get(2).equals(new String("momo"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Morgane"))
								|| !l.get(3).equals("" + 1848) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur momo après deuxieme solder");

				if (l.get(2).equals(new String("nanard"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Bernard"))
								|| !l.get(3).equals("" + 1767) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur nanard après deuxieme solder");

				if (l.get(2).equals(new String("zinzin"))
						&& (!l.get(0).equals(new String("Nadou")) || !l.get(1).equals(new String("Sylvain"))
								|| !l.get(3).equals("" + 1083) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur zinzin après deuxieme solder");
				if (l.get(2).equals(new String("aure"))
						&& (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Aureliane"))
								|| !l.get(3).equals("" + 896) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur aure après deuxieme solder");
			}

		} catch (Exception e) {
			System.out.println("\n Exception imprévue : " + e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		testConstructeurSiteDeParisMetier();
		testValiditePasswordGestionnaire();
		testInscrireDesinscrireJoueur();
		testCrediterDebiterJoueur();
		testAjouterCompetition();
		testMiserVainqueur();
		testSolderVainqueur();
		testConsulterCompetitions();
		testConsulterCompetiteurs();
		testConsulterJoueurs(); // Il reste que celui - ci

	}
}