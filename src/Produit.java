package facture;

import java.util.ArrayList;

public class Produit {
	
	private int id;
	int prix;
	String nom;
	String categorie;
	static ArrayList<Produit> listeProduit = new ArrayList<>();
	
	public Produit(int id, String nom, int prix, String categorie) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public Produit() {
		
	}
	
	public void ajouterP(Produit produit) {
		listeProduit.add(produit);
	}
	
	public static void showProduits() {
		System.out.println("Nom        Prix        Categorie");
		for (Produit produit : listeProduit) {
			System.out.println(produit.getNom() + "    " + produit.getPrix() + "    " + produit.getCategorie());
		}
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
}
