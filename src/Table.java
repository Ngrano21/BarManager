

import java.io.File;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.List;
import java.io.PrintWriter;


public class Table 
{
    private int tableId;
    private static int nbrTable = 25; 
    private static int reservation[] = new int[nbrTable];
    private static File temp = null;
    private FileWriter obj = null;
    private static PrintWriter wr = null;
    
    /* --- CONSTRUCTOR --- **/


    public Table(int num) throws IOException
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
                    //File temp = null;
                    createTempBillFile();
                    obj = new FileWriter(temp.getAbsolutePath());
                    wr = new PrintWriter(obj);
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
                temp = File.createTempFile("temp", null, new File("P:/projet et cours/programation/Java/projets/School/Exam Project/src/temp"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
               if(temp.exists())
               {
                   System.out.println("\nFile created :" + temp.getAbsolutePath());
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
        

            
                 //FileWriter obj = new FileWriter(temp.getAbsolutePath());
                 //PrintWriter wr = new PrintWriter(obj);
                 wr.printf("%s %d %d %d \n", nameP, prixU, quantity, prixU *quantity);
                 //wr.close();
                 System.out.println("\nLe fiechier a bien ete closed");

    }

    
    /** 
     * @param t
     */
    /* --- Temp File suppression --- */

    public static void deleteTempBillFile()
    {
        if(temp.delete())
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

    public static void billGenerator( int tr) throws InputMismatchException
    {
        int total = 0,totalBill = 0;
        wr.close();
        try
        {
          Scanner bg = new Scanner(temp);

          while(bg.hasNext())
          {
             System.out.print("\n"+ bg.next());
             System.out.print(" : "+ bg.nextInt() +"FBU");
             System.out.print(" *"+ bg.nextInt() + " : ");
             total = bg.nextInt();
             System.out.print(total +"FBU");
             totalBill += total;
             

          }
          
          System.out.println("\n\t Total : "+ totalBill +"FBU");
          bg.close();
        }
        catch(IOException e)
        {
            System.out.println("Erruer!");
            e.printStackTrace();
        }
        
        deleteTempBillFile();
        if(temp == null)
        {
          setFree(tr);
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
