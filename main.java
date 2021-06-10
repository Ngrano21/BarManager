public class main 
{
    public static void main(String[] args) 
    {
        int chx=2;
        String Password = "abcd";

        System.out.println("\t==== SYSTEM MANNAGEMENT ===\n\n");
        Waiter a = new Waiter("Ngabirano" , "Donald" , "Gihosha", 22, 235499);
        
        switch (chx) {
            case 1:
              if(Password == "PASS")
              {

              }
              else
               System.exit(1);
                
                break;
        
            case 2:
            System.out.println(a.Name + " "+ a.Prename + " waiter id : " + a.get_id() + " waiter Salary : " + a.get_Salary());
            System.out.println(a.get_Salary());
               
                break;

            default:
                break;
        }
    }    
}
