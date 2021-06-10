
public class Personne 
{
    public String Name;
    public String Prename;
    public int Age;
    public String Adress;

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

    //---------- GETERS ---------


    String get_Name()
    {
        return Name;
    }

    String get_Prename()
    {
        return Prename;
    }

    String get_Adress()
    {
        return Adress;
    }

    int get_Age()
    {
        return Age;
    }

    //------- SETERS ---------

    void set_Prename(String t)
    {
        Prename = t;
    }

    void set_name(String t)
    {
        Name = t;
    }

    void set_Adress(String t)
    {
        Adress = t;
    }

    void set_Age(int t)
    {
        Age = t;
    }
}
