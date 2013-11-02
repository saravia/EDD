package eucl_al;
import java.util.Scanner;
public class Euclides {
	private static Scanner scan;
	public static String resta( String s1, String s2 ) {
		      ListaEnlazada<Integer> numero1 = new ListaEnlazada<Integer>();    //Creo una lista
		      ListaEnlazada<Integer> numero2 = new ListaEnlazada<Integer>();    //Creo una lista
		      ListaEnlazada<Integer> resultado = new ListaEnlazada<Integer>();  //Creo una lista
		      ListaEnlazada<Integer> auxiliar = new ListaEnlazada<Integer>();   //Creo una lista
		      int l1 = s1.length();
		      int l2 = s2.length();
		 while ( s2.length() != l1 )
		         s2 = "0" + s2;
             for ( int i = l1 - 1; i >= 0; i-- ) {
		         numero1.insertar( (int) s1.charAt(i) );               //A�ado los numeros a la lista
		         numero2.insertar(9- (int)s2.charAt(i));        //A�ado los numeros a la lista
		      }
		      int llevar = 0;
             for ( int i = 0; i < l1; i++ ) {
		         int d1 = 0, d2 = 0;		         
		            d1 = numero1.sacar(i);                 //Convierto la cadena a enteros
		            d2 = numero2.sacar(i);                 //Convierto la cadena a enteros    
		         int x = d1 + d2 + llevar;               //Sumo cada elemento de cada lista		                       
		         auxiliar.insertar( x % 10 );                 //a�ado a la lista auxiliar el modulo de la suma
		         llevar = x / 10;                             
		      }
             for ( int i = 0; i < l1; i++ ) {
		         int x = auxiliar.sacar(i) + llevar;          
		         resultado.insertar( x % 10 );
		         llevar = x / 10;
		      }
		      String result = new String();
		      if (s1.equals(s2)) result = "0";
		      else {		         
		         int i;
		         for ( i = resultado.size() - 1; i >= 0; i-- )
		            if (resultado.sacar(i) != 0)
		               break;
		         for ( ; i >= 0; i-- )
		            result = result + resultado.sacar(i);
		      }
		      return result;
		   }
		  public static boolean comparar( String a , String b ) {
		      int x = a.length();
		      int y = b.length();
		      String s1 = a;
		      String s2 = b;
		      if( x > y )
		         return true; 
		      if( x == y && s1.compareTo(s2) > 0 )
		         return true;
		      if( x == y && s1.compareTo(s2) == 0 )
		         return true;
		      else
		         return false;
		  }
	public static void main(String[] args) throws Exception
	    {    
	        scan = new Scanner(System.in);
	        String aux,aux2;
	        int y;
	        System.out.println("Numero 1: ");
	        String s1 = scan.next();
	        System.out.println("Numero 2: ");
	        String s2 = scan.next();
            String s3="";
            String sig1 = "" + s1.charAt(0), sig2 = ""+ s2.charAt(0);
            
          if ( sig1.equals("-") ) s1 = s1.substring( 1, s1.length() );
  	      if ( sig2.equals("-") ) s2 = s2.substring( 1, s2.length() );
  	      if ( sig1.equals("+") ) s1 = s1.substring( 1, s1.length() );
	      if ( sig2.equals("+") ) s2 = s2.substring( 1, s2.length() );
            if(s1.equals("0") || s2.equals("0"))
            System.out.println("El mcd es 0");
            if(!comparar(s1, s2)){
            aux2=s1;
            s1=s2;
            s2=aux2;             }
	        y=s2.length();
	        String num1=s1;
	        String num2=s2;
	        for(int i=0;i<num2.length();i++)
	             s3=s3+num1.charAt(i);	
	       while(!s3.equals("0")){
	       while(y<s1.length()){
	        	while(comparar(s3,num2))
	        		s3=resta(s3, num2);
	        	 if(s3.equals("0"))
	        		 s3="";
	                s3+=num1.charAt(y);
	               y++;          }
	       while(comparar(s3,num2))
       		s3=resta(s3, num2);
	       if(s3.equals("0"))
	    	   System.out.println("El Mcd es \n"+num2);
	       else{
	    	   aux=s3;
	           s3=num2;
	           num2=aux;
	            }
	        }
	       }
}
