package solved;

public class WordsPalindrome {
    
    static String str = "race car  ";
    
   public static void main(String ...a){       
       str = str.replaceAll(" ", "");
       if(str.equals(reverse(str))){
           System.out.println("Pallin");
       }else{
           System.out.println("not");
       }                 
   }
   static String reverse(String s){       
       return new StringBuffer(s).reverse().toString();
   }
    
}
