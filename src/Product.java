package src;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import src.exception;


/**
 * @author Estimé Jésus
 *
 */
public class Product {
	private int id;
     private String name;
     private int price;
     private String category;
     
     public Hashtable<Integer, Product> product_list = new  Hashtable<Integer,Product>();
	 
    public static void error_notifer() {
        System.out.println("Cher Administrateur, Desolé vous avez mal saisi, Veuillez bien saisir!");
    }
    public static void success_notifer() {
    	 System.out.println("Cher Administrateur,Félicitation, vous avez bien saisi !");
    }
	public void adding_initiale_product_in_product_list(){
		product_list.put(1,new Product(1,"Pizza",15000,"Nourriture")); 
		product_list.put(2, new Product(2,"Jus d'orange",1000,"Boisson"));
		product_list.put(3, new Product(3,"Lait frais",1200,"Boisson"));
		product_list.put(4, new Product(4,"Hamburger",15000,"Nourriture"));
		product_list.put(5,new Product(5,"Kebab",4000,"Nourriture"));
		product_list.put(6,new Product(6,"Primus",1500,"Boisson"));
		product_list.put(7,new Product(7,"Capati",500,"Nourriture"));
		product_list.put(8, new Product(8,"Omolette",2000,"Nourriture"));
		product_list.put(9,new Product(9,"Café",2500,"Boisson"));
		product_list.put(10,new Product(10,"Champagne",25000,"Boisson"));
	}
     
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
    
    
    public int insertid() {
    	int id=0;
    	System.out.print("Veuillez saisir l'id du produit à créer dans notre stock:");
    	id=exception.writeint(id);
		return id;
    }
    public String insertfullname() {
    	String name;
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Veuillez saisir le nom complet du produit à créer dans notre stock:");
    	name = sc.next();
		return name;
		
    }
    public int insertprice() {
		price=0;
    	System.out.print("Veuillez saisir le prix du produit à créer dans notre stock:");
    	price = exception.writeint(price);
		return price;
    }
    
    
    
    
    
    
    /**
     * @return
     */
    public String insertcategory() {
    	Scanner sc = new Scanner(System.in);
    	int a=0;
		do {
			System.out.println("Veuillez saisir le categorie prouit du produit à créer dans notre stock: ");
	    	System.out.println("Veuillez saisir  1. Pour  Boisson / 2. Nourriture");
	    	a=exception.writeint(a);
    		if(a==1) {
    			setCategory("Boisson");
    			success_notifer();
    			break;
    		}
    		else if(a==2) {
    			setCategory("Nourriture");
    			success_notifer();
    			break;
    		}
    		else {
    			error_notifer();
    		}
    	}while(a!=1 || a!=2);
		return category;
        
    }
    
  
    
    
    
    /**
     * @param id
     * @param name
     * @param price
     * @param category
     */
    public Product(int id,String name,int price,String category) {
    	this.id=id;
    	this.name=name;
    	this.price=price;
    	this.category=category;
    	product_list.put(this.id,this);
    }
    
    
    
    /**
     * 
     */
    public Product () {
		
    };

    

	
	public void addProduct(Product product) {
		do{
			product=new Product(insertid(),insertfullname(),insertprice(),insertcategory());
			if(product_list.containsKey(product.id)==false){
				product_list.put(product.id,product);
				System.out.println("Votre démandée est execute avec succèes, le produit est ajouté avec succèes!");
			}
			else {
				
				System.out.println("L'identificateur (id) de l'élement saisi est déja pris par un autre élement produit dans notre restaurant!\nVeuillez réessayer  cher Administrateur!");
			}
		}while(product_list.containsKey(product.id)==false);
    }
	
	
    
	
	
	
	
    // show Product
	public void showProductadmin(){
		System.out.println("\n\nVoici la liste des produits déjà enregistrés dans notre restaurant");
		Enumeration<Product> el;
		if(product_list.size()>0){
			el=product_list.elements();
			System.out.println("id( nom_produit , prix_produit , catégorie_produit )");
		    System.out.println("===================================================\n");
			while(el.hasMoreElements())
				System.out.println(((Product)el.nextElement()).identify_product());
			
		}
		else System.out.println("Pas des produits (nourritures et boissons) déjà enregistrés dans notre restaurant");
	}
	public String identify_product(){
		return this.id+"( "+this.name+" , "+this.price+" , "+this.getCategory()+" ).";
	}

	//show Product for our client

	public void showProductclient(){
		System.out.println("Voici la liste des produits");
		Enumeration<Product> el;
		if(product_list.size()>0){
			el=product_list.elements();
			System.out.println("Nom produit  ( prix produit , Catégorie produit )");
		    System.out.println("==================================================\n");
			while(el.hasMoreElements())
				System.out.println(((Product)el.nextElement()).identify_productclient());
			
		}
		else System.out.println("desole on a rien (nourritures et boissons) de disponible ");
	}
	public String identify_productclient(){
		return this.name+"( "+this.price+" , "+this.getCategory()+" ) .";
	}

	
	
	
	
	
	
	
	
	
	
	
	//delete Product
	public void deleteProduct() {

		if(product_list.size()>0) 
		{
			System.out.println("\n\nVeuillez sélectionner suivant l'id du produit à effacer contenant dans notre liste des produits! :");
		    showProductadmin();
		    System.out.println("\n");
		    System.out.print("Veuillez saisir l'id du produit à effacer : ");
		    int id_delete=0;
		    id_delete=0;
			id_delete=exception.writeint(id_delete);

			do{
				if(product_list.containsKey(id_delete)==true){
							    
					System.out.println("Etez-vous sûr de supprimer cette produit !");
					System.out.println("0. Pour Annuler / 1. Pour Confirmer");
					int a = 0;
					a=exception.writeint(a);
					do {
						if(a==0) {
							System.out.println("Merci! l'elément choisie est sauvée")
							;break;
						}
						else if(a==1) {
									product_list.remove(id_delete);
									System.out.println("Votre démandée de supprimer un produit dans notre restaurant est executée avec succèes cher Administrateur");		
									break;
						}
						else {
							error_notifer();
							break;
						}
					}while(a!=1||a!=0);
				}
				else{
					System.out.println("\n\nL'id saisie pour sa suppression ne correspondent pas dans notre produit restaurant!");
					System.out.println("Veuillez réessayez encore Cher Administrateur avec id correct!\n");
					break;
				}
	
			}while(product_list.containsKey(id_delete)==false);
		}
		else System.out.println("Pas des produits (nourritures et boissons) à effacer");
	    
	}
	
	
	
	
	
	
	
	
	//modify Product
	public void updateProduct() {
		
		if(product_list.size()>0) {
			System.out.println("\n\nVeuillez sélectionner suivant l'id du produit à modifier contenant dans notre liste des produits!\"");
		    showProductadmin();
		    System.out.println("\n");
		    System.out.print("Veuillez saisir l'id du produit à modifier :");
		    int id_update=0;
		    id_update=exception.writeint(id_update);
		    do{
				if(product_list.containsKey(id_update)==true)
				{
					System.out.println("Etez-vous sûr de modifier cette produit !");
					System.out.println("0. Pour Annuler / 1. Pour Confirmer");
					int a = 0;
					a=exception.writeint(a);
					do {
						if(a==0) {
							System.out.println(" Merci! l'elément  est reste comme auparavant");
						}
						else if(a==1) {
			
									product_list.get(id_update).setPrice(insertprice());	
									System.out.println("Votre démandée de modifier un produit dans notre restaurant est executée avec succèes cher Administrateur");
									break;
						}
						else {
							error_notifer();
						}
					}while(a!=1 || a!=0);
				}
				else{
					System.out.println("\n\nL'id saisie pour sa modification ne correspondent pas dans notre produit restaurant!");
					System.out.println("Veuillez réessayez encore Cher Administrateur avec id correct!\n");
					break;
				}

			}while(product_list.containsKey(id_update)==false);
		}
			
		else System.out.println("Pas des produits (nourritures et boissons) à mofifier");
	    
	}
	 
	
}
