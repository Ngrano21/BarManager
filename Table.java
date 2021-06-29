

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintWriter;


public class Table 
{
    private int tableId;
    private static int nbrTable = 25; 
    private static int reservation[] = new int[nbrTable];
    private File temp = null;
     private FileWriter obj = null;
     private PrintWriter wr = null;
    
    /* --- CONSTRUCTOR --- **/


    public Table(int num) throws IOException
    {
        setTableId(num);
        //--- Table availability verification 

        if(nbrTable > 0)
        {

            // --- Table number verification

            if(getTableId() < nbrTable)
            {

                // --- Enter table number verification

                if(reservation[num] == 0)
                {
                    setTableId(num);
                    setOccupied(getTableId());
                    System.out.println("\nLa table "+getTableId()+" est maintenant prise.");
                    
                    //File temp = null;
                    createTempBillFile();
                    this.obj = new FileWriter(this.temp.getAbsolutePath());
                    this.wr = new PrintWriter(this.obj);
                    nbrTable--; //décrementation du nombre de table dispo
                }
                else
                {
                    System.out.println("\nDesolee Cette table est prise .\n<veuillez en prendre une autre\nMerci de votre comprehension et de votre fidelite");
                }
            }
            else
            {
                System.out.println("\ncCe numero de table n'existe pas!");
            }

        }
        else
        {
            System.out.println("\nDesolee toutes les tables sont prises.");
        }
    }

 
 
 /** 
  * @param t
  */
 /*------------------------------------------------------------------------------------------------------------------------------------------------ */

                         /* --- SETERS --- */

    public void setTableId(int t)
    {
        this.tableId = t;
    }

                         
     /** 
      * @return int
      */
     /* --- GETERS --- */

    public int getTableId()
    {
        return this.tableId;
    }

    public static int getTableState(int t)
    {
        return reservation[t];
    }

    public static int getNbrTable()
    {
        return nbrTable;
    }
 
 /** 
  * @param t
  * @throws IOException
  */
 /*------------------------------------------------------------------------------------------------------------------------------------------------ */
                         /* ---Method --- */

    /* --- Temp File creation --- */

    public void createTempBillFile() throws IOException
    {
            

            
            
               try {
                this.temp = File.createTempFile("temp", null, new File("temp"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
               if(this.temp.exists())
               {
                   //System.out.println("\nFile created :" + this.temp.getAbsolutePath());
               }
               else
               {
                   System.out.println("\nLe fichier n'as pas ete creer");
               }
         
       
    }

    
    /** 
     * @param nameP
     * @param prixU
     * @param quantity
     */
    /* --- Temp File writing ---*/

    public void writeTempBillFile( String nameP, int prixU, int quantity) throws IOException
    {
        

            
                  wr.printf("%s %d %d %d \n", nameP, prixU, quantity, prixU *quantity);
                  wr.flush();
                  //wr.close();
                 System.out.println("\nLe fiechier a bien ete closed");

    }

    
    /** 
     * @param t
     */
    /* --- Temp File suppression --- */

    public Boolean deleteTempBillFile()
    {
        if(this.temp.delete())
        {
            //System.out.println("\nTemp file deleted !");
            return true;
        }
        else
        {
           // System.out.println("\nErreur de supression");
            return false;
        }
    }


    /** 
     * @param t
     * @param tr
     * @throws InterruptedException
     * @throws FileNotFoundException
     * @ShowConsomation print Actual cosomation and total
     */
    
    /* --- cosomation check(Temp File reader) --- */

    public void ShowConsomation() throws InputMismatchException, InterruptedException
    {

        int total = 0,totalBill = 0;
        try
        {
          Scanner bg = new Scanner(this.temp);
          System.out.println("\nLa consommation actuel a la table "+getTableId()+ " est de :");
          while(bg.hasNext())
          {
             App.latence(160);
             System.out.print("\n... "+ bg.next());
             if(bg.hasNextInt())
                   System.out.print(" : "+ bg.nextInt() +"FBU");
             else
             {
                System.out.print(" "+ bg.next());
                System.out.print(" : "+ bg.nextInt() +"FBU");
             }
             System.out.print(" *"+ bg.nextInt() + " : ");
             total = bg.nextInt();
             System.out.print(total +"FBU");
             totalBill += total;
             

          }
          App.latence(75);
          System.out.println("\n\t Total Actuel : "+ totalBill +"FBU");
          bg.close();
        }
        catch(IOException e)
        {
            System.out.println("Erruer!");
            e.printStackTrace();
        }
    }

    
    /** 
     * @throws InterruptedException
     * @throws FileNotFoundException
     * @billGenerator print Table consomation and close temp file and set the table free
     */
    /* --- Bill generator(Temp File reader) --- */

    public  void billGenerator() throws InputMismatchException, InterruptedException
    {
        int total = 0,totalBill = 0;
        wr.close();
        try
        {
          Scanner bg = new Scanner(this.temp);
          System.out.println("\nTable "+ getTableId() +" votre Facture est de :");
          while(bg.hasNext())
          {
            App.latence(160);
             System.out.print("\n... "+ bg.next());
             if(bg.hasNextInt())
                   System.out.print(" : "+ bg.nextInt() +"FBU");
             else
             {
                System.out.print(" "+ bg.next());
                System.out.print(" : "+ bg.nextInt() +"FBU");
             }
             System.out.print(" *"+ bg.nextInt() + " : ");
             total = bg.nextInt();
             System.out.print(total +"FBU");
             totalBill += total;
             

          }
          App.latence(75);
          System.out.println("\n\t Facture : "+ totalBill +"FBU");
          bg.close();
        }
        catch(IOException e)
        {
            System.out.println("Erruer!");
            e.printStackTrace();
        }
        
        if(this.deleteTempBillFile())
        {
          setFree(getTableId());
          nbrTable++;
        }
        else
          System.out.println("\nErreur de suppression \na la facturation.");
    }


    /* --- Set all table free (initialize to null) --- */

    public static void setAllFree()
    {
        int i;
        for( i = 0; i < nbrTable;i++)
           reservation[i] = 0;
    }

    
    /** 
     * @param t
     */
    /* --- Set a table as occupied --- */

    public void setOccupied(int t)
    {
        reservation[t] = 1;
    }

    /* --- Set a table free --- */

    public static void setFree(int t)
    {
        reservation[t] = 0;
    }

    /* --- Free table count --- */

    public void countFree()
    {
        int i, count = 0;
        for( i = 0; i < nbrTable; i++)
        {
            if(reservation[i] == 0)
               count++;
        }

        System.out.println("\n"+ count +" sont siponible.");
    }

    /* --- Bills Log file --- */


                    /* --- END --- */
}