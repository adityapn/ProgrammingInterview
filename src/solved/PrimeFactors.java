package solved;

public class PrimeFactors {
    
    public static void main(String s[]){
        primeFactors(315);
    }
    static void primeFactors(int n){
        int till = n>>2;
        int loop = 2;
        for(int i=2;i<=till;i++){
            
            if(n%i == 0){                
                if(isPrime(i))
                    System.out.print(" "+i);            
            }
        
        }
        System.out.println("");
    
    }
    static boolean isPrime(int num){
        
        int count = 0;
        for(int i=1;i<=num;i++){
            
            if(num%i == 0)
                count++;            
            if(count > 2 )
                return false;        
        }
        
        return true;    
    }
    
}
