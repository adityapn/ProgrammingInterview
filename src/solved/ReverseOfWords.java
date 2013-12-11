/*
 *  Given string is “Hey hi how ru ?”. then print “? Ru how hi hey”.
 */
package solved;

public class ReverseOfWords {
    
    public static void main(String ...s){
    
        String str = "Hey hi how ru";
        String rev = reverse(str);
        String temp = "";
        for(int i=0;i<rev.length();i++){
              
               if((rev.charAt(i)+"").equals(" ")){
                       System.out.print(reverse(temp)+" ");                     
                       temp = "";
               }
               temp += rev.charAt(i)+"";
            
        }
    
    }
    static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    
}
