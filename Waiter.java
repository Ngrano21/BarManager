

public class Waiter extends Personne 
{
    private int id;
    private int Salary;

    public
      Waiter(String n, String p, String a, int b, int s )
      {
          super (n,p,a,b);
          set_Salary(s);
          id++;

      }

        //---- GETTERS ----

      public int get_id()
      {
          return id;
      }

      public int get_Salary()
      {
          return Salary;
      }

       //---- SETTERS ----

      public void set_Salary(int a)
      {
          Salary = a;
      }

}
