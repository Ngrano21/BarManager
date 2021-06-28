package src;

public class Testproduct {
    public static void main(String[] args) {
		System.out.println("Test");
		Product produit = new Product();
		produit.adding_initiale_product_in_product_list();
		produit.showProductadmin();
		produit.updateProduct();
		produit.showProductclient();
	}
}
