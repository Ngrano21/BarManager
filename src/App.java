package src;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) 
    {
        Scanner ss = new Scanner(System.in);
        int continuer = 0;
        do {
            System.out.println("==============================================================");
            System.out.println("=========                                            =========");
            System.out.println("====       🍺🍗BIENVENUE DANS NOTRE RESTAURANT🍖🍻        ====");
            System.out.println("=========                                            =========");
            System.out.println("==============================================================");

            
            // ====> client
            // helper variables and functions
            String m2 = "\n\n";
            String m1 = "\n";
            
            // pour acceder a l'administration on va utiliser le nombre 1172
            System.out.println(m2);
            String client_first_word = "je veux ";
            System.out.println("Que peut-on faire pour toi?");
            System.out.println("1. "+client_first_word+"voir le menu");
            System.out.println("2. "+client_first_word+"quitter le resto");
            
            int choice = 0;
            do {
                Scanner sc = new Scanner(System.in);
                System.out.print(m1);
                System.out.print(">>> ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println(m1);
                        System.out.println("Voila notre menu!");
                        System.out.println("=================");
                        // String client_second_word = "je choisi ";
                        // la classe pour avoir les produits
                        Product produit = new Product();
                        produit.showProductclient();
                        // System.out.println("1. "+client_second_word+" Fresh Cow Meat");
                        // System.out.println("2. "+client_second_word+" Akabenze");
                        // System.out.println("3. "+client_second_word+" Beshu");
                        // System.out.println("4. "+client_second_word+" Urwarwa");
                        System.out.println(m1);
                        break;
                    case 2:
                        System.out.println(m1);
                        System.out.println("OK, merci pour votre visite...");
                        System.out.println(m1);
                        break;
                    case 1172:
                        int cx = 0;
                        do{
                            System.out.println(m1);
                            System.out.println("1. ajouter un produit");
                            System.out.println("2. voir tous les produits");
                            System.out.println("3. suprimmer un produit");
                            System.out.println("4. mettre a jour un produit");
                            System.out.println("5. voir tout les commandes");
                            System.out.println("6. generer une facture a partir des commandes");
                            System.out.println(m1);
                            // Scanner ss = new Scanner(System.in);
                            int chx = ss.nextInt();

                            // instance de la classe Product pour les operations de base
                            Product pr = new Product();
                            switch (chx) {
                                
                                case 1:
                                    // recuperation des donnee
                                    pr.setName(pr.insertfullname());
                                    pr.setCategory(pr.insertcategory());
                                    pr.setPrice(pr.insertprice());
                                    pr.setId(pr.insertid());
                                    // creation du nouveau produit
                                    pr.addProduct(pr);
                                    pr.showProductadmin();
                                    break;
                                case 2:
                                    pr.showProductadmin();
                                    break;
                                case 3:
                                    pr.deleteProduct();
                                    break;
                                case 4:
                                    pr.deleteProduct();
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                            }
                            System.out.println("vous voulez continuez a travaillez en tant que admin (1 => oui, 0 => non)");
                            cx = ss.nextInt();
                        } while(cx == 1);
                        
                        break;
                    default:
                        System.out.println(m1);
                        System.out.println("Je ne comprends pas (0_0)");
                        System.out.println(m1);
                        break;
                }
            } while(choice != 1 && choice != 2 && choice != 1172);
            System.out.print("vous voulez un peu de nos services (1 = oui, 0 = non) >>>...");
            Scanner sc = new Scanner(System.in);
            continuer = sc.nextInt();
        } while(continuer == 1);
        System.out.print("\n");
        System.out.print("Bye!, revenez bientot😘");
        ss.close();
    }
}
