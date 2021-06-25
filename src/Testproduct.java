package src;

public class Testproduct {
    public static void main(String[] args) {
		System.out.println("Test");
		Product produit = new Product();
		produit.addProduct(produit);
		produit.showProductadmin();
		produit.updateProduct();
		produit.showProductclient();
	}
}
