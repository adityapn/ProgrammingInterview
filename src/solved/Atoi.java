/*
 * Atoi ( Ascii to Integer ) f for float 
 */

package solved;

public class Atoi {
    
    static String numb = "123";
    static int con  = 0;
    
    public static void main(String s[]){    
        atoi(numb);
        System.out.println("Number is  "+con);
    }
   
    public static void atoi(String s){
            int len = s.length();
            int power = len - 1;
            int temp ;
            for(int i=0;i<len;i++){
                  int  one =  Character.getNumericValue(s.charAt(i));                                     
                   temp = (int) (one* Math.pow(10, power-i));
                   con = con + temp;
                  System.out.println(i+" "+con);
            }
    }
    
}
