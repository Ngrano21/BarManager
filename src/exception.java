import java.util.InputMismatchException;
import java.util.Scanner;

public class exception {

    /** author : Estimé Jésus (class gestion erreur console ) */

    
    //la classe pour saisir un entier (parametre  = variable de conservation de valeur ) est faite par une méthode de récursivité
    //initialiser d'abord la variable de saisi qui va prendre la valeur!
    // exemple de déclaration dans la classe extérieur : int valeur=exception.writeint(valeur);
    public static int writeint(int a){
            Scanner sc = new Scanner(System.in);
            try{
                a = sc.nextInt();
                return(a);
            } catch(InputMismatchException e){
                System.out.println("Désole, Veuillez insérer un nombre entier s'il vous plait!");
                System.out.print("=>");
                return(writeint(a));
        }
    }

    //la classe pour saisir un float (réel simple) (parametre  = variable de conservation de valeur ) est faite par une méthode de récursivité
    //initialiser d'abord la variable de saisi qui va prendre la valeur!
    public static float writefloat(float a){
        Scanner sc = new Scanner(System.in);
        try{
            a = sc.nextFloat();
            return(a);
        } catch(InputMismatchException e){
            System.out.println("Désole, Veuillez insérer un réel s'il vous plait!");
            System.out.print("=>");
            return(writefloat(a));
    }
}
}