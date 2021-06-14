
public class Personne 
{
    private String Name;
    private String Prename;
    private int Age;
    private String Adress;


    //---- CONSTRUCTOR ----
    
    public Personne()
    {

    }

    public Personne(String n, String p, String a, int b)
    {
        set_name(n);
        set_Prename(p);
        set_Age(b);
        set_Adress(a);
    }

    //---------------- GETERS ------------------


    String get_Name()
    {
        return this.Name;
    }

    String get_Prename()
    {
        return this.Prename;
    }

    String get_Adress()
    {
        return this.Adress;
    }

    int get_Age()
    {
        return this.Age;
    }

    //------- SETERS ---------

    void set_Prename(String t)
    {
        this.Prename = t;
    }

    void set_name(String t)
    {
        this.Name = t;
    }

    void set_Adress(String t)
    {
        this.Adress = t;
    }

    void set_Age(int t)
    {
        this.Age = t;
    }
}
