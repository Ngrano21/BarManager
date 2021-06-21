package src;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) 
    {
        System.out.println("==============================================================");
        System.out.println("=========                                            =========");
        System.out.println("====          🍺🍗WELCOME IN OUR RESTAURANT🍖🍻          ====");
        System.out.println("=========                                            =========");
        System.out.println("==============================================================");

        
        
        // ====> client
        // helper variables and functions
        String m2 = "\n\n";
        String m1 = "\n"; 
        
        // pour acceder a l'administration on va utiliser le nombre 1172
        System.out.println(m2);
        String client_first_word = "i wanna ";
        System.out.println("How can we help you?");
        System.out.println("1. "+client_first_word+"See the menu");
        System.out.println("2. "+client_first_word+"Leave the Resto");
        
        int choice = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(m1);
            System.out.print(">>> ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(m1);
                    System.out.println("Here's our resto menu!");
                    System.out.println("======================");
                    String client_second_word = "i choose ";
                    System.out.println("1. "+client_second_word+" Fresh Cow Meat");
                    System.out.println("2. "+client_second_word+" Akabenze");
                    System.out.println("3. "+client_second_word+" Beshu");
                    System.out.println("4. "+client_second_word+" Urwarwa");
                    System.out.println(m1);
                    break;
                case 2:
                    System.out.println(m1);
                    System.out.println("OK, thanks for choosing us! welcome back again😘");
                    System.out.println(m1);
                    break;
                default:
                    System.out.println(m1);
                    System.out.println("I don't know what you mean (0_0)");
                    System.out.println(m1);
                    break;
            }
        } while(choice != 1 && choice != 2);
        
        

        // **** afficher des options
        /*
            - demander menu (liste des produits dispo)
            - choisir nourriture, boisson ou les deux
            - demander facture
            - sortir du resto (un message d'au revoir)
        */

        // ====> admin
        // **** afficher des options
        /*
            - ajouter un produit
            - voir tous les produits
            - suprimmer un produit
            - mettre a jour un produit
            - voir tout les commandes
            - generer une facture a partir des commandes
        */
    }
}