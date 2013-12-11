package programminginterview;

public class MaxSubsequentProduct {
	public static void main(String[] args) {
		//write a test case, use the example we discussed in slides.
		double[] nums = {1.63, 0.68, -3.00, -2.21, -0.72}; //expect LSP=7.35
		System.out.println("Max sum: "+MaxSubsequentProduct(nums));
	}
	static double MaxSubsequentProduct(double[] nums) {
		//as we discussed in slides, we need four support variables
		double globalMaxPos = 0;
		double globalMaxNeg = 0;
		double currPos = 1;
		double currNeg = 1;
		//now we start processing the values in the array
		for(int i=0; i<nums.length; i++) {
			//we process the K (nums[i]) based on its sign (pos/neg/zero)
			if(nums[i]>0) {
				currPos *= nums[i];
				if(currNeg != 1)//only update it when it is set before
					currNeg *= nums[i];
			} else if(nums[i]<0) {
				//firstly check if the currNeg has been set or not
				if(currNeg == 1) {
					//The positive value can be computed by using Neg*nums[i]
					currNeg = currPos * nums[i];
					//we need set neg value first otherwise we lost the postive so far
					//in case of neg value not set, the current pos product can be reset!
					currPos = 1;
				}
				else {
					//as we discussed we need set neg=pos*current value and vice versa
					double tempNeg = currNeg;
					currNeg = currPos * nums[i];
					currPos = tempNeg * nums[i];
				}
			} else { //it is 0
				currPos = 1;
				currNeg = 1;//reset both products
			}
			
			//now check if any current product can be set to global max pos/neg values
			if(currPos > globalMaxPos)
				globalMaxPos = currPos;
			if(currNeg < globalMaxNeg)
				globalMaxNeg = currNeg;//actually we do not need this global neg value, but for reference
			
			//last step, we need discard the current product if it is less than 1!
			if(currPos < 1)
				currPos = 1;
		}
		//do not forget to return the value
		return globalMaxPos;
	}
}
