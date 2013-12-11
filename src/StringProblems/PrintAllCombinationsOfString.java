
package StringProblems;

public class PrintAllCombinationsOfString {
    
    String string;
    int binaryArray[];
    public PrintAllCombinationsOfString(String str){
        this.string = str;
        int binaryArray[] = new int[str.length()+1];        
        this.combinations(binaryArray, string, 0, this.string.length());
    }
    
    
    public void combinations(int binaryArray[],String string,int k,int n){
        if(k == n){
            binaryArray[k] = 0;
            printCombinations(binaryArray, n, string);
            binaryArray[k] = 1;
            printCombinations(binaryArray, n, string);
            return;
        }
        binaryArray[k] = 0;
        combinations(binaryArray, string, k+1, n);
        binaryArray[k] = 1;
        combinations(binaryArray, string, k+1, n);
    }
    
    public void printCombinations(int binaryArray[],int n,String string){
        int sum = 0;
        String combinations = "";
        for(int i=0;i<n;i++){
            if(binaryArray[i] == 1){
                combinations += string.charAt(i);
                sum++;
            }
        }
        if(sum != 0){
            System.out.println(combinations);
        }
    }
    
    public static void main(String a[]){
        PrintAllCombinationsOfString combinations = new PrintAllCombinationsOfString("abc");
    }
    
    
}
