package solved;

public class LCM {
    
    public static void main(String sp[]){    
        System.out.println("LCM Of 14 , 3 "+lcm(14,3));
    }
    
    static int lcm(int num1, int num2){
        
        if (num1 % num2 == 0)
            return num1;

        if (num2 % num1 == 0)
            return num2;
        
        // Finds the biggest number
        int n = (num1 <= num2) ? num2 : num1;
    
        for (; ; n++){
            System.out.println("n : "+n);
            if(n % num1 == 0 && n % num2 == 0) // The number that both can divide
                return n;
        }
   }
    
}
