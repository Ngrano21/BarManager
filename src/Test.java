package facture;

import java.util.*;

public class Test {
	
	static Scanner kbd = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Produit produit = new Produit(); 
		produit.ajouterP(new Produit(1, "Smoothie", 1200, "Boisson"));
		produit.ajouterP(new Produit(2, "Pizza", 12000, "Norriture"));
		produit.ajouterP(new Produit(3, "Fanta", 800, "Boisson"));
		produit.ajouterP(new Produit(4, "Burger", 10000, "Norriture"));
		produit.ajouterP(new Produit(5, "Umucopo", 1000, "Norriture"));
		produit.ajouterP(new Produit(6, "Capati", 500, "Norriture"));
		produit.ajouterP(new Produit(7, "Eau", 100, "Boisson"));
		
		Bill bill = new Bill();
		
		int reponse;
		
		do {
			
			do {
				System.out.println("1. Faire une commande\n2. Voir les produits commandés\n3. Quitter");
				reponse = kbd.nextInt();
			}while(reponse > 3);
		
			if(reponse == 1) {
				bill.commande();
			}
			else if(reponse == 2) {
				Iterator<String> tabCle = bill.getCommandesQuantite().keySet().iterator();
				System.out.println("------------Produits commandés-------------");
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
