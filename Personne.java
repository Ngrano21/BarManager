
abstract class Personne
{
    protected String name;
    protected String prename;
    protected int age;
    protected String adress;


    //---- CONSTRUCTOR ----

    public Personne(String name, String prename, String adress, int age)
    {
        this.name = name;
        this.prename = prename;
        this.age = age;
        this.adress = adress;
    }

    //---------------- GETERS ------------------


    String get_Name()
    {
        return this.name;
    }

    String get_Prename()
    {
        return this.prename;
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

    void set_Prename(String t)
    {
        this.prename = t;
    }

    void set_name(String t)
    {
        this.name = t;
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
