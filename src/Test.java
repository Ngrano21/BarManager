package src;

import Entres.*;

import java.util.*;

public class Test {

	// static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) {

		// add new Produit pour admin panel//

		Produit produit = new Produit();
		//------------------------------------------------------------------------
		//Cote Produit @pegasus03 saissir les Produits avec clavier 
		
		/* produit.ajouterP(new Produit(Donnees.Saissir_Entier("-Entre Id Produit :
		 "),Donnees.Saisie_Caracteres("-Entre Le Nom Du Produit :
		 "),Donnees.Saissir_Reel("Saissir Le Prix :
		 "),Donnees.Saisie_Caracteres("-Saissir La Categorie De La Produit : ")));*/
		//-------------------------------------------------------------------------
		
		produit.ajouterP(new Produit(1, "Smoothie", 1200, "Boisson"));
		produit.ajouterP(new Produit(2, "Pizza", 12000, "Norriture"));
		produit.ajouterP(new Produit(3, "Fanta", 800, "Boisson"));
		produit.ajouterP(new Produit(4, "Burger", 10000, "Norriture"));
		produit.ajouterP(new Produit(5, "Umucopo", 1000, "Norriture"));
		produit.ajouterP(new Produit(6, "Capati", 500, "Norriture"));
		produit.ajouterP(new Produit(7, "Eau", 100, "Boisson"));

		Bill bill = new Bill();
		
		// espace client pour choix d etre servir ou consulte la menu Des produit et
		// leurs prix
		
		int reponse;
		System.out.println("\n=================Choix Du Client========================\n");
		do {

			do {

				System.out.println("1. Faire Une Commande\n2. Voir Les Produits Commandés\n3. Quitter");
				reponse = Donnees.Saissir_Entier("\nChoisir L'index Ci en Haut Pour Continuer\n");
			} while (reponse > 3);

			if (reponse == 1) {
				bill.commande();
			} else if (reponse == 2) {

					bill.AfficherFacture();

			}

		} while (reponse < 3);

	}

}
