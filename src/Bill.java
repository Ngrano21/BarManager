package facture;

import java.util.*;

public class Bill{
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
		Produit.showProduits();
		
		boolean b = false;
		String commandeClient;
		int prixCommande = 0;
		int quantiteCommande = 1;
		
		do {
			
			System.out.print("Votre Commande ici : ");
			commandeClient = kbd.next();
			for (Produit produit : Produit.listeProduit) {
				if(!produit.nom.equalsIgnoreCase(commandeClient)) {
					b=true;
				}
				else {
					b = false;
					commandeClient = produit.nom;
					prixCommande = produit.prix;
					break;
				}
			}
			
			if(b) {
				System.out.println("Le produit saisi ne figure pas parmi ceux affichés ci-dessus.");
				System.out.println("Veuillez saisir un produit qui figure parmi ces derniers.");
			}
			
		}while(b);
		
		System.out.print("Entrez la quantité : ");
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