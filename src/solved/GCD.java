package solved;

public class GCD {
    
    public static void main(String... a){
        
        int n1 = 27, n2 = 14;
        
        while(n1!=n2){
            if(n1>n2){
                n1=n1-n2;
                System.out.println("n1 "+n1);
            }
                  
            else{                                 
               n2=n2-n1;
               System.out.println("n2 "+n2);
            }
                  
         }

        System.out.println("GCD of two number is "+n1);
        
    }
    
}
