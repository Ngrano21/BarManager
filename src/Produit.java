package src;

import java.util.ArrayList;

public class Produit {
	
	private int id;
	private int prix;
	private String nom;
	private String categorie;
	static ArrayList<Produit> listeProduit = new ArrayList<>();
	
	public Produit(int id, String nom, int prix, String categorie) {
		this.id = id;
		setNom(nom);
		setPrix(prix);
		setCategorie(categorie);
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

	 /* -------- Getters -------- */

	public int getPrix() {
		return prix;
	}



	public String getNom() {
		return nom;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
}
