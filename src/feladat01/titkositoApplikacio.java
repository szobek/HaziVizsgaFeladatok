package feladat01;

import java.util.Scanner;

public class titkositoApplikacio {

	public static void main(String[] args) {
		String eredeti="Tesztszöveg ellenőrzése";
		String titkositva = titkosit(eredeti);
		String dekodolva = decode(titkositva);
		
		System.out.println(eredeti);
		System.out.println(titkositva);
		System.out.println(dekodolva);
		
		
		
		System.out.print("adja meg a kódolandó szöveget: ");
		String kodolandoTxt;
		try (Scanner sc = new Scanner(System.in);){
			kodolandoTxt=sc.nextLine();
			String titkositott=titkosit(kodolandoTxt);
			System.out.println(titkositott);
			System.out.println(decode(titkositott));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static String titkosit(String titkositando) {
		
		String mitKellCserelni = "kstea ";
		String mireKellCserelni = "135790";
		String eredmeny = titkositando;
		
	    for (int i = 0; i < mitKellCserelni.length(); i++)
        {
            eredmeny = eredmeny.replace(mitKellCserelni.charAt(i), mireKellCserelni.charAt(i));
        }

	    if (eredmeny.length() > 1) {
	    		    	
	    	eredmeny = eredmeny.charAt(eredmeny.length()-1)+eredmeny.substring(0,eredmeny.length()-1);
	    	
	    }	    
		
		return eredmeny;
		
	}
	
	public static String decode(String dekodolando) {
		String mireKellCserelni = "kstea ";
		String mitKellCserelni = "135790";
		String eredmeny = dekodolando;
		
	    for (int i = 0; i < mitKellCserelni.length(); i++)
        {
            eredmeny = eredmeny.replace(mitKellCserelni.charAt(i), mireKellCserelni.charAt(i));
        }

	    if (eredmeny.length() > 1) {
	    		    	
	    	eredmeny = eredmeny.substring(1,eredmeny.length())+eredmeny.charAt(0);
	    	
	    }	    
		
		return eredmeny;
	}

}
