import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 


/**
 * author Ngrano21
 */

public class Table 
{
    private int tableId;
    private static int nbrTable = 25; 
    private static int reservation[] = new int[nbrTable];
    private File temp = null;
    private static File log = new File("log.txt");
    private File verify = new File("temp");
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
 
 /*---------------------------------------------------------------------------------------------------------------*/

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
    /*-------------------------------------------------------------------------------------------------------------*/
    /* ---Method --- */

    // Temp File creation

    public void createTempBillFile() throws IOException
    {
      try
      {
        if(verify.mkdir())
        {

        }
        else
        {

        }
      }
      catch (SecurityException e)
      {
          System.out.println("Exceptions security ");
          e.printStackTrace();
      }

      if(log.createNewFile())
      {
          
      }

        try 
        {
            this.temp = File.createTempFile("temp", null, new File(verify.getAbsolutePath()));
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        if(this.temp.exists())
        {
            
        }
        else
        {
            System.out.println("\nLe fichier n'a pas ete creer");
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
    }

    
    /** 
     * @param t
     */
    /* --- Temp File suppression --- */

    public Boolean deleteTempBillFile()
    {
        if(this.temp.delete())
        {
            return true;
        }
        else
        {
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
            while(!bg.hasNextInt())
            {
                System.out.print(" "+ bg.next());
            }
            System.out.print(" : "+ bg.nextInt() +"FBU");
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
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
          LocalDateTime now = LocalDateTime.now();
          String date = dtf.format(now);

          System.out.print("\n    "+ date +"\n");
          System.out.println("Table "+ getTableId() +" votre Facture est de :");

          while(bg.hasNext())
          {
            App.latence(160);
            System.out.print("\n... "+ bg.next());
            while(!bg.hasNextInt())
            {
                System.out.print(" "+ bg.next());
            }
            System.out.print(" : "+ bg.nextInt() +"FBU");
            System.out.print(" *"+ bg.nextInt() + " : ");
            total = bg.nextInt();
            System.out.print(total +"FBU");
            totalBill += total;
          
          }
          
          App.latence(75);
          System.out.println("\n\t Facture : "+ totalBill +"FBU");
          if(log.canRead() && log.canWrite())
          {
              Scanner lg = new Scanner(temp);
              BufferedWriter logf = new BufferedWriter(new FileWriter(log, true));
              logf.append(date +" : Table -"+ getTableId()+"\n");
              //logf.flush();
              String tmp = "";
              while(lg.hasNextLine())
              {
                  tmp = lg.nextLine();
                  logf.append(tmp +"\n");
                  //logf.flush();
              }
              logf.append("\n\t   Total : " +totalBill);
              logf.append("\n---------------------------------------\n\n");


              lg.close();
              logf.close();

          }
          else
          {
              System.out.print("\n the log file can't be read or written");
          }
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

    /* --- Show Bill log or HIstoric --- */
    
    public static void showLog()
    {
        try
        {
            if(log.exists())
            {
               Scanner hist = new Scanner(log);
               while(hist.hasNext())
               {
                   System.out.println(hist.nextLine());
               }
               hist.close();
            }
            else
            {
                System.out.println("The log file doesn't exist. ");
            }


        }
        catch(FileNotFoundException e)
        {
            System.out.println("Erreur : "+ e.getMessage());
        }
    }

    /* --- Search by date the bills --- */

    public static void showSearchedLog(String t)
    {
        String limit = "---------------------------------------";
        boolean verification = false;
        try
        {
            if(log.exists())
            {
                Scanner bf = new Scanner(log);
                String temp;
                while(bf.hasNextLine())
                {
                    temp = bf.nextLine();
                    if(temp.contains(t))
                    {
                        verification = true;
                        System.out.println(temp);
                        while(bf.hasNextLine())
                        {
                            temp = bf.nextLine();
                            System.out.println(temp);
                            if(temp.contains(limit))
                            {
                                break;
                            }
                        }
                    }
                }
                if(!verification)
                  System.out.println("Aucune facture touver pour cette date : "+t);
                bf.close();
            }
            else
            {
                System.out.println("Le fichier log n'existe pas");
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
    /* --- Search by date the bills --- */

    public static void showSearchedLogTb(int t)
    {
        String limit = "---------------------------------------";
        String tp = null;
        boolean verification = false;

        if(t <= getNbrTable())
        {
          tp = (new StringBuilder()).append("-").append(String.valueOf(t)).toString();
          try
          {
            if(log.exists())
            {
                Scanner bf = new Scanner(log);
                String temp;
                while(bf.hasNextLine())
                {
                    temp = bf.nextLine();
                    if(temp.contains(tp))
                    {
                        verification = true;
                        System.out.println(temp);
                        while(bf.hasNextLine())
                        {
                            temp = bf.nextLine();
                            System.out.println(temp);
                            if(temp.contains(limit))
                            {
                                break;
                            }
                        }
                    }
                }
                if(!verification)
                   System.out.println("Aucune facture trouver pour la table -"+t);

                bf.close();
            }
            else
            {
                System.out.println("Le fichier log n'existe pas");
            }
          }
          catch(FileNotFoundException e)
          {
            e.printStackTrace();
          }
        }
        else
        {
            System.out.println("cette table n'existe pas");
        }

    }


    /* --- Set all table free (initialize to null) --- */

    public static void setAllFree()
    {
        File del = new File("temp");
        if(del.delete())
        {

        }
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

    /* --- END --- */
}