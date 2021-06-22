package src;

import java.lang.reflect.Array;
import java.util.*;

public class Bill{
	
	//création d'une instance 'kbd' de la classe Scanner
	static Scanner kbd = new Scanner(System.in);
	
//	Déclaration de trois tableaux dynamique de type ArrayList
//		qteCmd qui contient comme valeurs la quantité de chaque commande par produit
//		prixUni qui coontient comme valeurs le prix unitaire de chaque commande
//		cmdClient qui contient comme valeurs la commande faite par le client
	
	private ArrayList<String> cmdClient = new ArrayList<>();
	private ArrayList<Integer> qteCmd = new ArrayList<>();
	private ArrayList<Float> prixUni = new ArrayList<>();
	
//	setters et getters / accesseurs et mutateurs pour les ArrayList cmdClient, prixUni et qteCmd
	
	public ArrayList<String> getCmdClient() {
		return cmdClient;
	}
	
	public ArrayList<Float> getprixUni() {
		return prixUni;
	}
	
	public ArrayList<Integer> getqteCmd() {
		return qteCmd;
	}

	public void setCmdClient(ArrayList<String> cmdClient) {
		this.cmdClient = cmdClient;
	}

	public void setPrixUni(ArrayList<Float> prixUni) {
		this.prixUni = prixUni;
	}

	public void setQteCmd(ArrayList<Integer> qteCmd) {
		this.qteCmd = qteCmd;
	}

	
//	Methode qui permet a l'utilisateur de choisir sa commande 
//	et complete les Arraylist cmdClient, prixUni et qteCmd 
//	selon les commandes faites par le client
	
	public void commande() {
		
//		Affichage des produits(plats) proposés par le restaurant
		
		System.out.println("\n==========Liste des produits==========\n");
		
//		Appel de la fonction 'showProduits' contenant la liste des produits(plats) proposés par le restaurant
		
		Produit.showProduits();
		
//		Déclaration des variables nécessaires à l'éxécution de la méthode
//			b qui prendra vrai comme valeur lorsque le client saisi un produit(plat) ne figurant pas dans la liste faux dans le cas contraire
//			commandeClient qui recupèrera la commande faite par le client
//			prixCommande qui recupèrera le prix de cette dernière
//			quantitéCommande qui recupèrera la quantité de la commande du client
		
		boolean b = false;
		String commandeClient;
		float prixCommande = 0;
		int quantiteCommande = 1;
		
		do {
			
			System.out.print("\nVotre Commande ici : \n");
			commandeClient = kbd.next();
			
//			Verification si la commande du client figure bien dans la liste
			
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
				System.out.println("\nLe produit saisi ne figure pas parmi ceux affichés ci-dessus.");
				System.out.println("\nVeuillez saisir un produit qui figure parmi ces derniers.");
			}
			
		}while(b);
		
		System.out.print("\nEntrez La Quantité : ");
		quantiteCommande = kbd.nextInt();
		System.out.println("\nVeuillez patientez!!\nVotre commande arrive bientot.");
		
//		Ajout de la commande, son prix et sa quantité dans les tableaux
		
		cmdClient.add(commandeClient);
		qteCmd.add(quantiteCommande);
		prixUni.add(prixCommande);
		
	}
	//Affiche la facture total du client cote admin
	
	public void AfficherFacture() {
		System.out.println("\n=========================FACTURE========================\n");
		System.out.println("\nCommandes   \tQuantité       \tPrix unitaire      \tPrix total\n");
		float total = 0;
		for (int i = 0; i < cmdClient.size(); i++) {
			System.out.println(cmdClient.get(i) + "          " + qteCmd.get(i) + "         " + prixUni.get(i) + "         " + prixUni.get(i)*qteCmd.get(i));
			total = (prixUni.get(i)*qteCmd.get(i)) + total;
		}
		System.out.println("\n-------------------------------------------\n");
		System.out.println("\nTotal Du Facture  : " + total);
		System.out.println("\n--------------------------------------------\n");
	}
	
}
