package src;

import java.lang.reflect.Array;
import java.util.*;

public class Bill{
<<<<<<< HEAD

	Product product=new Product();

=======
	
	//création d'une instance 'kbd' de la classe Scanner
>>>>>>> d2d37d84b5a1ac91bf17563f02709e6cf4ef9572
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
		
<<<<<<< HEAD
		System.out.println("------------Liste des produits--------------");
		product.showProduct();
=======
		Produit.showProduits();
>>>>>>> d2d37d84b5a1ac91bf17563f02709e6cf4ef9572
		
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
<<<<<<< HEAD
			for (Product produit : product.product_list.values()) {
				if(!produit.getName().equalsIgnoreCase(commandeClient)) {
=======
			
//			Verification si la commande du client figure bien dans la liste
			
			for (Produit produit : Produit.listeProduit) {
				if(!produit.nom.equalsIgnoreCase(commandeClient)) {
>>>>>>> d2d37d84b5a1ac91bf17563f02709e6cf4ef9572
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
<<<<<<< HEAD
				System.out.println("Le produit saisi ne figure pas parmi ceux affich�s ci-dessus.");
				System.out.println("Veuillez saisir un produit qui figure parmi ces derniers.");
=======
				System.out.println("\nLe produit saisi ne figure pas parmi ceux affichés ci-dessus.");
				System.out.println("\nVeuillez saisir un produit qui figure parmi ces derniers.");
>>>>>>> d2d37d84b5a1ac91bf17563f02709e6cf4ef9572
			}
			
		}while(b);
		
<<<<<<< HEAD
		System.out.print("Entrez la quantit� : ");
=======
		System.out.print("\nEntrez La Quantité : ");
>>>>>>> d2d37d84b5a1ac91bf17563f02709e6cf4ef9572
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
