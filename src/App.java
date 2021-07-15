import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;

/**
 * author b3rking
 */

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
            String[] name = new String[10];
            name[0] = "O";
            name[1] = "T";
            name[2] = "A";
            name[3] = "K";
            name[4] = "U";
            name[5] = "";
            name[6] = "T";
            name[7] = "E";
            name[8] = "A";
            name[9] = "M";
            System.out.println("\n");
            System.out.print("\t");
            for(int i = 0; i < 10; i++)
            {
               latence(545);
               System.out.print("\t"+name[i]);
            }

            System.out.println("\n");
            System.out.print("\t     ");
            for(int i = 0; i < 80; i++)
            {
               latence(100);
               if (i <= 39) {
                  System.out.print(">");
               } else if(i == 40) {
                  System.out.print("*");
               } else {
                  System.out.print("<");
               }
            }
            
            latence(1000);
            ClearConsole();

            System.out.print("\n\n  Chargement des modules...");
            for(int i = 1; i < 101; i += 5)
            {
               latence(200);
               System.out.print("# # ");
               if (i == 96) {
                  System.out.print("100%");
               }
            }
            latence(1000);
            ClearConsole();
            System.out.print("\n\n  Chargement terminé. Lancement du programme.");
            latence(3000);
            ClearConsole();

      do
      {
            ClearConsole();
            System.out.println("==============================================================");
            System.out.println("=========                                            =========");
            System.out.println("====        😎 BIENVENUE DANS OTAKU's RESTAURANT 🤩       ====");
            System.out.println("=========                                            =========");
            System.out.println("==============================================================");
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
            System.out.println("4. consommation Actuel. ");
            latence(200);
            System.out.println("5. Facture. ");
            latence(200);
            System.out.println("6. Voir l'historique des factures. ");
            latence(200);
            System.out.println("7. Voir l'historique des factures a une date precise. ");
            latence(200);
            System.out.println("8. Voir l'historique des factures d'une table precise. ");
            latence(200);
            System.out.println("9. Voir l'historique des factures d'une table precise a une date precise. ");
            latence(70);
            System.out.print(":: >>> ");
            option = Saisir.Saissir_Entier();
          switch(option)
          {
              case 0:
                 Table.clearFolder();
                 System.exit(0);
                 break;
              case 1:
                 ClearConsole();
                 int id;
                 Table.showFree();
                 do{
                     System.out.print("\nNumero de la table ? >>> ");
                     id = Saisir.Saissir_Entier();
                   }while(id >= Table.getNbrTable() && id < 1);
                 id -= 1;
                 if(Table.getTableState(id) == 0)
                 {
                  reserv.add(new Table(id));
                 }
                 else if(Table.getTableState(id) == -1)
                 {
                    System.out.println("\nCette table n'existe pas.");
                 }
                 else
                 {
                    System.out.println("\nTable occupe!");
                 }
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
                     do
                     {
                       System.out.print("\nEntrez le numero de la table >>> ");
                       idt = Saisir.Saissir_Entier();
                     }while(idt < 1);
                       idt -= 1;
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
                        
                      do
                      {
                         System.out.print("\nEntrez le numero du Produit >>> ");
                         com = Saisir.Saissir_Entier();
                      }while(com < 0 || com > Product.product_list.size());

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
                    
                    do
                    {
                     do
                     {
                       System.out.print("Entrez le numero de la table >>> ");
                       revoir_idt = Saisir.Saissir_Entier() ;
                     }while(revoir_idt < 1);
                       revoir_idt -= 1;
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
                 do
                 {
                  do
                  {
                    System.out.print("Entrez le numero de la table >>> ");
                    bill_idt = Saisir.Saissir_Entier();
                  }while(bill_idt < 1);
                    bill_idt -= 1;
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
                 System.out.print("\n1. Pour refaire une Facture.\n0. Pour arreter .\n>>> ");
                 re_bill = Saisir.Saissir_Entier();
                 
                }while(re_bill != 0);
                break;
              case 6 :
                System.out.println();
                Table.showLog();
                break;
              case 7 :
                String date = "";
                System.out.print("\nentrez la date sous le format : \nAnnee/mois/jour : ");
                date = Saisir.Saisie_Caracteres();
                System.out.println();
                Table.showSearchedLog(date);
                break;
              case 8 :
                int tabl = -1;
                do
                {
                  System.out.print("\nentrez le numero de table : ");
                  tabl = Saisir.Saissir_Entier();
                  if(tabl < 1)
                    System.out.println("cette table n'existe pas");
                }while(tabl < 1);
                System.out.println();
                Table.showSearchedLog(tabl);
                break;
              case 9 :
                String dat = "";
                System.out.print("\nentrez la date sous le format : \nAnnee/mois/jour : ");
                dat = Saisir.Saisie_Caracteres();
                System.out.println();
                int tae = -1;
                do
                {
                  System.out.print("\nentrez le numero de table : ");
                  tae = Saisir.Saissir_Entier();
                  if(tae < 1)
                    System.out.println("cette table n'existe pas");
                }while(tae < 1);
                System.out.println();
                Table.showSearchedLog(tae,dat);
                break;
              default :
                System.out.print("\nCette option n'existe pas, choisissez en une aurtes !");
                break;
          }
          
          System.out.print("\n\n--------------------------------------------");
          System.out.print("\n0. Pour arreter le programme\n1. Pour continuer\n>>> ");
          choice = Saisir.Saissir_Entier();
          ClearConsole();

      }while(choice != 0);
      System.out.print("\n");
      System.out.print("Bye!, revenez bientot😘");
   }
}