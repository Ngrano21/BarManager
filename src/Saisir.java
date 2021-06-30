import java.io.*;

public class Saisir {
  //Scanner nt gera am IOException
	//private static Scanner sc =null;
	//private static BufferedReader sc=null;




	public static int Saissir_Entier() throws IOException {
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		int a=0;
		String b="";
			if(sc!=null){
				System.out.print(" ");
				do {
					try {
						b=sc.readLine();
						a=Integer.parseInt(b);
						break;
					}
					catch(IOException e) {
						e.printStackTrace();
					}
				
					catch(NumberFormatException et) {
						System.out.println("Entrez un entier S'il Vous Plait!!!");
					}
				}while(true);

				return a;
		}
		else {
				return a;
		}
	}
	public static float Saissir_Reel() throws IOException {
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		float c=0;
		String b="";
		if(sc != null){
			System.out.print(" ");
			do {
				try {
					b=sc.readLine();
					c=Float.parseFloat(b);
					break;
				} catch(IOException e) {
					e.printStackTrace();
				}
			
				catch(NumberFormatException et) {
					System.out.println("Entrez un Reel S'il Vous Plait!!!!");
				}
			}while(true);

			return c;
		}
		else {
			return c; 
		}
	}
	public static String Saisie_Caracteres() {
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		String b="";
		if(sc!=null){
			System.out.print(" ");
			try {
				b=sc.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			return b;
		}
		else {
			return b;
		}
	}

}