package solved;

public class ReverSentence {
    
    public static void main(String ...s){
    
        String str = " Man Under the table ";
        str = reverse(str);
        String temp  = "";
        
        for(int i=0;i<str.length();i++){
                
              if((str.charAt(i)+"").equals(" ")||i == str.length()-1 ){
                   if(i == str.length()-1){
                       temp += str.charAt(i);
                   }
                   System.out.print(" "+reverse(temp));
                   temp = "";
              }
              temp += str.charAt(i);
        }
    
    }
    static String reverse(String s){        
        return new StringBuilder(s).reverse().toString();    
    }
    
}
