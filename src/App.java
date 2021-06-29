
import java.io.IOException;
import java.lang.Thread;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import java.util.ArrayList;

public class App 
{
   public final static void ClearConsole()
   {
      System.out.print("\033[H\033[2J");  
      System.out.flush(); 
   }
     
    public final static void latence(int t) throws InterruptedException
    {
       Thread.sleep(t);
    }
    public static void main(String[] args) throws IOException, InterruptedException
    {
      ArrayList<Table> reserv = new ArrayList<Table>();
      int choice = -1;
      Table.setAllFree();
      

            System.out.println("==============================================================");
            System.out.println("=========                                            =========");
            System.out.println("====       BIENVENUE DANS NOTRE RESTAURANT                ====");
            System.out.println("=========                                            =========");
            System.out.println("==============================================================");

            System.out.print("\n\n\t\t  Loading");
            for(int i = 0; i < 5; i++)
            {
               latence(545);
               System.out.print(" .");
            }

            

      do
      {
         ClearConsole();
          int option = -1;
          latence(200);
          System.out.println("0. Fermer le programme. ");
          latence(200);
          System.out.println("1. Reserver une table. ");
          latence(200);
          System.out.println("2. Voir le Menu.  ");
          latence(200);
          System.out.println("3. Passer une commande. ");
          latence(200);
          System.out.println("4. Voir la consommation. ");
          latence(200);
          System.out.println("5. Facture. ");
          latence(70);
          System.out.print(":: >>> ");
          option = Saisir.Saissir_Entier();
          switch(option)
          {
              case 0:
                 System.exit(0);
                 break;
              case 1:
                 ClearConsole();
                 int id;
                 do{
                 System.out.print("\nNumero de la table ? >>> ");
                 id = Saisir.Saissir_Entier();
                 }while(id >= Table.getNbrTable());
                 if(Table.getTableState(id) == 0)
                     reserv.add(new Table(id));
                  else
                    System.out.println("\nTable occupe!");
                 break;
              case 2 :
                 ClearConsole();
                 System.out.print("\nShow Menu !");
                 Product.showProductclient();
                 break;
              case 3 :
                 ClearConsole();
                 int refaire = -1;
                 do
                 {
                    int idt,qt,com;
                    int idx = -1;
                    Product.showProductclient();
                    
                    do
                    {
                     System.out.print("\nEntrez le numero de la table >>> ");
                       idt = Saisir.Saissir_Entier();
                       for( int i = 0; i < reserv.size(); i++)
                       {
                          if(reserv.get(i).getTableId() == idt)
                          {
                             idx = i;
                             break;
                          }
                       }
                    }while(idx >= reserv.size());
                    if(idx == -1)
                    {
                        System.out.println("\nCette Table n'as pas de client");
                    }
                    else
                    {
                        System.out.print("\nEntrez le numero du Produit >>> ");
                      do
                      {
                         com = Saisir.Saissir_Entier();
                      }while(com < 0);

                        System.out.print("\nEntrez la quantite >>> ");
                      do
                      {
                        qt = Saisir.Saissir_Entier();
                      }while(qt < 1);
                        reserv.get(idx).writeTempBillFile(Product.commande(com).getName(), Product.commande(com).getPrice(), qt);
                    }
                    System.out.print("\n1. Pour refaire une commande.\n0. Pour arreter de commander.\n>>> ");
                    refaire = Saisir.Saissir_Entier();
                    
                 }while(refaire != 0);
                 break;
              case 4 :
                 ClearConsole();
                 int revoir = -1;
                 do
                 {
                    int revoir_idt,revoir_idx = -1;
                    System.out.print("Entrez le numero de la table >>> ");
                    do
                    {
                       revoir_idt = Saisir.Saissir_Entier() ;
                       for( int i = 0; i < reserv.size(); i++)
                       {
                          if(reserv.get(i).getTableId() == revoir_idt)
                          {
                             revoir_idx = i;
                             break;
                          }
                        }
                    }while(revoir_idx >= reserv.size());

                    if(revoir_idx == -1)
                       System.out.println("\nCette Table n'as pas de client");
                    else
                    {
                      reserv.get(revoir_idx).ShowConsomation();
                    }
                    System.out.print("\n1. Pour revoir la consommation.\n0. Pour arreter.\n>>> ");
                    revoir = Saisir.Saissir_Entier();
                    
                 }while(revoir != 0);
                 break;
              case 5 :
                ClearConsole();
                int re_bill = -1;
                do
                {
                 int bill_idt,bill_idx = -1;
                 System.out.print("Entrez le numero de la table >>> ");
                 do
                 {
                    bill_idt = Saisir.Saissir_Entier();
                    for( int i = 0; i < reserv.size(); i++)
                    {
                       if(reserv.get(i).getTableId() == bill_idt)
                       {
                          bill_idx = i;
                          break;
                       }
                     }
                 }while(bill_idx >= reserv.size());
                 if(bill_idx == -1)
                      System.out.println("\nCette Table n'as pas de client");
                 else
                 {
                    reserv.get(bill_idx).billGenerator();
                    reserv.remove(bill_idx);
                 }
                 System.out.print("\n1. Pour refaire une commande.\n0. Pour arreter de commander.\n>>> ");
                 re_bill = Saisir.Saissir_Entier();
                 
                }while(re_bill != 0);
              default :
                System.out.print("\nCette option n'existe pas, choisissez en une aurtes !");
          }
          
          System.out.print("\n\n--------------------------------------------");
          System.out.print("\n0. Pour arreter le programme\n1. Pour continuer\n>>> ");
          choice = Saisir.Saissir_Entier();

      }while(choice != 0);


            


}

}