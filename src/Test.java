package src;

import Entres.*;

import java.util.*;

public class Test {

	// static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) {

		// add new Produit pour admin panel//

		Product produit = new Product();
		//------------------------------------------------------------------------
		//Cote Produit @pegasus03 saissir les Produits avec clavier 
		
		/* produit.ajouterP(new Produit(Donnees.Saissir_Entier("-Entre Id Produit :
		 "),Donnees.Saisie_Caracteres("-Entre Le Nom Du Produit :
		 "),Donnees.Saissir_Reel("Saissir Le Prix :
		 "),Donnees.Saisie_Caracteres("-Saissir La Categorie De La Produit : ")));*/
		//-------------------------------------------------------------------------
		
		produit.add(new Product(1, "Smoothie", 1200, "Boisson"));
		produit.ajouterP(new Product(2, "Pizza", 12000, "Norriture"));
		produit.ajouterP(new Product(3, "Fanta", 800, "Boisson"));
		produit.ajouterP(new Product(4, "Burger", 10000, "Norriture"));
		produit.ajouterP(new Product(5, "Umucopo", 1000, "Norriture"));
		produit.ajouterP(new Product(6, "Capati", 500, "Norriture"));
		produit.ajouterP(new Product(7, "Eau", 100, "Boisson"));

		Bill bill = new Bill();
		
		// espace client pour choix d etre servir ou consulte la menu Des produit et
		// leurs prix
		
		int reponse;
		System.out.println("\n=================Choix Du Client========================\n");
		do {

			do {
				System.out.println("1. Faire une commande\n2. Voir les produits command�s\n3. Quitter");
				reponse = kbd.nextInt();
			}while(reponse > 3);
		
			if(reponse == 1) {
				bill.commande();
			} else if (reponse == 2) {

					bill.AfficherFacture();

			}
			else if(reponse == 2) {
				Iterator<String> tabCle = bill.getCommandesQuantite().keySet().iterator();
				System.out.println("------------Produits command�s-------------");
				for (int i = 0; i < bill.getCommandesPrix().size(); i++) {
					String commandec = null;
					if(tabCle.hasNext()) {
						commandec = tabCle.next();
					}
					int nbreFois = bill.getCommandesQuantite().get(commandec);
					int prixc = bill.getCommandesPrix().get(commandec);
					
					System.out.println(commandec +  "     " + nbreFois +" fois" + prixc);
					
				}
			}
			
		}while(reponse < 3);
		
	}

}
