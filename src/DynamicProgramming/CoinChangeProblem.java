package DynamicProgramming;

/*
 * Coing change proble using dynamic programming 
 */

import java.util.ArrayList;
import java.util.List;

public class CoinChangeProblem {
    
    public static void main(String ...a){
        int coins[] = {1,2,5};
        int change = 24;
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
        for(int i=0;i<length;i++){
            int d = minDifference(coins, change);
            if(d > 0){
                i = 0;
                change = change - d;
                changeCoins.add(d);
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
                if(diff < difference){                    
                    coin = coins[i];
                }
            }            
        }        
        return coin;        
    }    
}
