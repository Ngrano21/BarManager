package Entres;
import java.util.*;
import java.io.*;

public class Saissir {
  //Scanner nt gera am IOException
	//private static Scanner sc =null;
	private static BufferedReader sc=null;
 static {
// sc =new Scanner(System.in);
	 sc=new BufferedReader(new InputStreamReader(System.in)); 

 }
 public static int Saissir_Entier(String msg) {
	 int a=0;
	 String b="";
	   if(sc!=null){
      	 System.out.print(msg);
	 do {
		 try {
			 b=sc.readLine();
			 a=Integer.parseInt(b);
			 break;
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 
		 catch(NumberFormatException et) {
			 System.out.println("Entrez l'entier S'il Vous Plait!!!");
		 }
	 }while(true);
	return a;
	   }
	return a;
 }
 public static float Saissir_Reel(String msg) {
	 float c=0;
	 String b="";
	 if(sc!=null){
      	 System.out.print(msg);
	 do {
		 try {
			 b=sc.readLine();
			 c=Float.parseFloat(b);
			 break;
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 
		 catch(NumberFormatException et) {
			 System.out.println("Entrez un Reel S'il Vous Plait!!!!");
		 }
	 }while(true);
	return c;
	 }
	return c; 
 }
 public static String Saisie_Caracteres(String msg){
 	
 	String b="";
 	if(sc!=null){
     	 System.out.print(msg);
     	 try {
				b=sc.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	return b;
 }
	return b;
 }
}
 

