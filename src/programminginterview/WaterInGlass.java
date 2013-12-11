package programminginterview;

/**
 *Amazon interview
 * 
 * There are some glasses with equal capacity as 1 litre. The glasses are kept as follows:

    			   1
		         2   3
		      4    5    6
		    7    8    9   10
   You can put water to only top glass. If you put more than 1 litre water to 1st glass, 
 * water overflows and fills equally in both 2nd and 3rd glasses. Glass 5 will get water 
 * from both 2nd glass and 3rd glass and so on.
   If you have X litre of water and you put that water in top glass, 
 * how much water will be contained by jth glass in ith row?

 * Example. If you will put 2 litre on top.

 * 1st – 1 litre
 * 2nd – 1/2 litre
 * 3rd – 1/2 litre
 * 
 */

public class WaterInGlass {
    
    
    // Returns the amount of water in j'th glass of i'th row
static float findWater(int i, int j, float X)
{
    // A row number i has maximum i columns. So input column number must
    // be less than i
    if (j > i)
    {
        System.out.println("Incorrect Input");        
        return -1;
    }
 
    // There will be i*(i+1)/2 glasses till ith row (including ith row)
    float[] glass = new float[(i * (i + 1) / 2)*4];
    
    // Initialize all glasses as empty
    for(int count=0;count<glass.length;count++){
                  glass[count] = 0;
    }
 
    // Put all water in first glass
    int index = 0;
    glass[index] = X;
 
    // Now let the water flow to the downward glassses till the
    // amount of water X is not 0 and row number is less than or
    // equal to i (given row)
    for (int row = 1; row <= i && X !=0.0; ++row)
    {
        // Fill glasses in a given row. Number of columns in a row
        // is equal to row number
        for (int col = 1; col <= row; ++col, ++index)
        {
            // Get the water from current glass
            X = glass[index];
 
            // Keep the amount less than or equal to
            // capacity in current glass
            glass[index] = (X >= 1.0f) ? 1.0f : X;
 
            // Get the remaining amount
            X = (X >= 1.0f) ? (X - 1) : 0.0f;
 
            // Distribute the remaining amount to the down two glasses
            glass[index + row] += X / 2;
            glass[index + row + 1] += X / 2;
        }
    }
 
    // The index of jth glass in ith row will be i*(i-1)/2 + j - 1
    return glass[i*(i-1)/2 + j - 1];
}
 
// Driver program to test above function
public static void main(String s[])
{
    int i = 2, j = 2;
    float X = (float) 2.0; // Total amount of water
        float findWater = findWater(i, j, X);
    System.out.println("Water level is "+findWater);
}
    
}
