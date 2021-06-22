package src;

import java.util.*;

public class Bill{

	Product product=new Product();

	static Scanner kbd = new Scanner(System.in);
	private Hashtable<String, Integer> commandesQuantite = new Hashtable<>();
	private Hashtable<String, Integer> commandesPrix = new Hashtable<>();
	
	public Hashtable<String, Integer> getCommandesPrix() {
		return commandesQuantite;
	}
	
	public void setCommandesPrix(Hashtable<String, Integer> commandesPrix) {
		this.commandesQuantite = commandesPrix;
	}
	
	public String commande() {
		
		System.out.println("------------Liste des produits--------------");
		product.showProduct();
		
		boolean b = false;
		String commandeClient;
		int prixCommande = 0;
		int quantiteCommande = 1;
		
		do {
			
			System.out.print("Votre Commande ici : ");
			commandeClient = kbd.next();
			for (Product produit : product.product_list.values()) {
				if(!produit.getName().equalsIgnoreCase(commandeClient)) {
					b=true;
				}
				else {
					b = false;
					commandeClient = produit.getName();
					prixCommande = produit.getPrice();
					break;
				}
			}
			
			if(b) {
				System.out.println("Le produit saisi ne figure pas parmi ceux affich�s ci-dessus.");
				System.out.println("Veuillez saisir un produit qui figure parmi ces derniers.");
			}
			
		}while(b);
		
		System.out.print("Entrez la quantit� : ");
		quantiteCommande = kbd.nextInt();
		System.out.println("Veuillez patientez!!\nVotre commande arrive bientot.");
		if(commandesQuantite.containsKey(commandeClient)) {
			quantiteCommande = quantiteCommande + commandesQuantite.get(commandeClient);
		}
		commandesQuantite.put(commandeClient, quantiteCommande);
		commandesPrix.put(commandeClient, prixCommande);
		
		return commandeClient;
		
	}

	public Hashtable<String, Integer> getCommandesQuantite() {
		return commandesQuantite;
	}

	public void setCommandesQuantite(Hashtable<String, Integer> commandesQuantite) {
		this.commandesQuantite = commandesQuantite;
	}
	
//	public String toString() {
//		
//	}
	
}