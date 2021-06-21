
abstract class Personne
{
    protected String fullname;
    protected int age;
    protected String adress;

    
    //---- CONSTRUCTOR ----

    public Personne(String fullname, String adress, int age)
    {
        this.fullname = fullname;
        this.age = age;
        this.adress = adress;
    }

    //---------------- GETERS ------------------

    String get_fullname()
    {
        return this.fullname;
    }

    String get_Adress()
    {
        return this.adress;
    }

    int get_Age()
    {
        return this.age;
    }

    //------- SETERS ---------

    void set_fullname(String t)
    {
        this.fullname = t;
    }

    void set_Adress(String t)
    {
        this.adress = t;
    }

    void set_Age(int t)
    {
        this.age = t;
    }
}
