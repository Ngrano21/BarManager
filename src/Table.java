package src;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//import java.util.List;
import java.io.PrintWriter;
//import java.io.FileNotFoundException;

public class Table 
{
    private int tableId;
    private static int nbrTable = 25; 
    private static int reservation[] = new int[nbrTable];
    
    /* --- CONSTRUCTOR --- **/


    public Table(int num)
    {
        setTableId(num);
        //--- Table availability verification 

        if(nbrTable > 0)
        {

            // --- Table number verification

            if(getTableId() < 25)
            {

                // --- Enter table number verification

                if(reservation[num] == 0)
                {
                    setOccupied(num);
                    File temp = null;
                    createTempBillFile(temp);
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
                         /* --- SETERS --- */

    public int getTableId()
    {
        return this.tableId;
    }
 
 /** 
  * @param t
  */
 /*------------------------------------------------------------------------------------------------------------------------------------------------ */
                         /* ---Method --- */

    /* --- Temp File creation --- */

    public void createTempBillFile(File t)
    {
            

            try
            {
               t = File.createTempFile("tmp", null, new File("/temp"));
               if(t.createNewFile())
               {
                   //System.out.println("\nFile created :" + t.getName());
               }
               else
               {
                   System.out.println("\nLe fichier n'as pas ete creer");
               }
           }
           catch(IOException e)
           {
               System.out.println("\nune erreur est survenue.");
               e.printStackTrace();
           }
       
    }

    
    /** 
     * @param t
     * @param nameP
     * @param prixU
     * @param quantity
     */
    /* --- Temp File writing ---*/

    public void writeTempBillFile(File t, String nameP, int prixU, int quantity)
    {
        

            try
            {
                 FileWriter obj = new FileWriter(t.getAbsolutePath());
                 PrintWriter wr = new PrintWriter(obj);
                 wr.printf("%s :%dFBU *%d : %dFBU\n", nameP, prixU, quantity, prixU *quantity);
                 wr.close();
                 System.out.println("\nLe fiechier a bien ete closed");
            }
            catch(IOException e)
            {
                 System.out.println("\nUne ereur est survenue");
                 e.printStackTrace();
            }
    }

    
    /** 
     * @param t
     */
    /* --- Temp File suppression --- */

    public void deleteTempBillFile(File t)
    {
        if(t.delete())
        {

        }
        else
        {
            System.out.println("\nErreur de supression");
        }
    }

    
    /** 
     * @param t
     * @param tr
     * @throws FileNotFoundException
     */
    /* --- Bill generator(Temp File reader) --- */

    public void billGenerator( File t, int tr) throws FileNotFoundException
    {
        int total = 0,totalBill = 0;
        
          Scanner sc = new Scanner(t);

          while(sc.hasNextLine())
          {
             System.out.print("\n"+ sc.next()+ " : " + sc.nextInt() + "FBU" + " *"+ sc.nextInt() + " : ");
             //System.out.print(" : "+ sc.nextInt() +"FBU");
             //System.out.print(" *"+ sc.nextInt() + " : ");
             total = sc.nextInt();
             System.out.print(total +"FBU");
             totalBill += total;

          }
          System.out.println("\n\t Total : "+ totalBill +"FBU");
          sc.close();
        
        deleteTempBillFile(t);
        if(t == null)
        {
          setFree(tr);
          nbrTable++;
        }
        else
          System.out.println("\nErreur de suppression \na la facturation.");
    }

    /* --- Set all table free (initialize to null) --- */

    public void setAllFree()
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

    
    /** 
     * @param t
     */
    /* --- Set a table free --- */

    public void setFree(int t)
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
