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

        // pour acceder a l'administration on va utiliser le nombre 1172
        
        // ====> client
        String client_first_word = "i wanna ";
        System.out.println("How can we help you?");
        System.out.println("1. "+client_first_word+" See the menu");
        System.out.println("2. "+client_first_word+" Leave the Resto");
        
        int choice = 0;
        do {
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Here's our resto menu!");
                    break;
                case 2:
                    System.out.println("OK, thanks for choosing us! welcome back again😘");
                    break;
                default:
                    System.out.println("I don't know what you mean (0_0)");
                    break;
            }
        } while(choice != 1 && choice != 2);
        
        // String client_second_word = "i choose ";
        // System.out.println("1. "+client_second_word+" See the menu");
        // System.out.println("2. "+client_second_word+" See the menu");

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