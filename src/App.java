

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.Scanner;

import java.util.ArrayList;

public class App 
{
    public static void main(String[] args) throws IOException
    {
        /*
         *Test
         *de la classe
         *Table
        */

        Table.setAllFree();

        System.out.println("\n\nLa table est : "+ Table.getTableState(12) +"\n\n");

        ArrayList<Table> tablee = new ArrayList<Table>();

    	Table table = new Table(22);
        table.writeTempBillFile("Fanta", 1000, 3);
        table.writeTempBillFile("Bajou", 1100, 2);
        table.writeTempBillFile("Bechou", 1500, 2);
        table.writeTempBillFile("Brochettes", 3500, 6);

        System.out.println("\n\nLa table est : "+ Table.getTableState(12) +"\n\n");

        System.out.println("\n\nLa table est : "+ Table.getTableState(22) +"\n\n");
        //table.writeTempBillFile("Ragout", 6500, 4);

        Table.billGenerator(22);
        

    	
        var continuer = 0;
        do {
            System.out.println("==============================================================");
            System.out.println("=========                                            =========");
            System.out.println("====       BIENVENUE DANS NOTRE RESTAURANT                ====");
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
                sc.close();
                switch (choice) {
                    case 1:
                        System.out.println(m1);
                        System.out.println("Voila notre menu!");
                        System.out.println("=================");
                        String client_second_word = "je choisi ";
                        System.out.println("1. "+client_second_word+" Fresh Cow Meat");
                        System.out.println("2. "+client_second_word+" Akabenze");
                        System.out.println("3. "+client_second_word+" Beshu");
                        System.out.println("4. "+client_second_word+" Urwarwa");
                        System.out.println(m1);
                        break;
                    case 2:
                        System.out.println(m1);
                        System.out.println("OK, merci pour votre visite...");
                        System.out.println(m1);
                        break;
                    case 1172:
                        System.out.println(m1);
                        System.out.println("1. ajouter un produit");
                        //addProduct=>Products.java
                        System.out.println("2. voir tous les produits");
                        //showProduct=>Products.java
                        System.out.println("3. suprimmer un produit");
                        //deleteProduct=>Products.java
                        System.out.println("4. mettre a jour un produit");
                        //updateProduct
                        System.out.println("5. voir tout les commandes");
                        System.out.println("6. generer une facture a partir des commandes");
                        System.out.println(m1);
                        break;
                    default:
                        System.out.println(m1);
                        System.out.println("Je ne comprends pas (0_0)");
                        System.out.println(m1);
                        break;
                }
            } while(choice != 1 && choice != 2 && choice != 1172);
            System.out.print("vous voulez un peu de nos services (1 = oui, 0 = non) >>>...");
            Scanner chx = new Scanner(System.in);
            if(chx.hasNext())
            {
                continuer = chx.nextInt();
            }
            chx.close();
            
        } while(continuer == 1);
        System.out.print("\n");
        System.out.print("Bye!, revenez bientot😘");
    }
}