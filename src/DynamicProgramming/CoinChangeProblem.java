package DynamicProgramming;

/*
 * Coin change problem using dynamic programming 
 */

import java.util.ArrayList;
import java.util.List;

public class CoinChangeProblem {
    
    public static void main(String ...a){
        int coins[] = {1,5,10,25};
        int change = 81;
        List<Integer> result;
        result = makeChange(coins, change);
        if(result != null){
            System.out.println(""+result);
        }else{
            System.out.println("Empty");
        }
    }
    
    static List<Integer> makeChange(int coins[],int change){
        if(change == 0)
            return null;
        
        int length = coins.length;
        List<Integer> changeCoins = new ArrayList<Integer>();
        int i = 0;
        while(i<length){
            int d = minDifference(coins, change);
            i++;
            if(d > 0){
            	changeCoins.add(d);                
                change = change - d;
                i = 0;
            }            
        }
        return changeCoins;
    }
    static int minDifference(int coins[],int money){        
        int coin = 0;
        int length = coins.length;
        int difference = money - coins[0];
        for(int i=0;i<length;i++){
            int diff = money - coins[i];
            if(diff > -1){
                if(diff <= difference){                    
                    coin = coins[i];
                    difference = diff;
                }
            }
           
        }             
        return coin;        
    }    
}
