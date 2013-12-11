package programminginterview;

class MyCalculator 
{
	//try a test case
	public static void main(String[] args)
	{
		String exp = "-1+((2-4)*(4+3)/2)+3-4*4";
		System.out.println(""+exp+" = "+Calculate(exp));
	}
	//define a method to decide the operator's priority
	private static int priority(char input)
	{
		switch(input)
		{
			case '(': return 3;//parenthesis have highest priority
			case ')': return 3;
			case '*': return 2;//multilication and division has lower priority than parenthesis
			case '/': return 2;
			case '+': return 1;//plus minus have the lowest operator priority
			case '-': return 1;
			default: return 0;//numbers lowest
		}
	}

	//now we define our big method calculate
	public static int Calculate(String exp)
	{
		//we can add a statement to know the status of running
		System.out.println("current exp:" + exp);
		//firstly we try to check if the exp is already a number or a simple expression or having high-level operators
		//the key recursive idea is to compute inner results if there is higher level operators until the result is returnable
		char[] inputs = exp.toCharArray();//we process string to char arrays for easy control
		//now we check the highest level operators and the count
		int highestPriority = 0;
		int operatorCount = 0;//this value is to keep track of how many operators remaining, mostly to deal with negative number cases
		for(int i=0; i<inputs.length;i++)
		{
			if(priority(inputs[i])>highestPriority)
				highestPriority = priority(inputs[i]);//update highest priority if necessary
			if(priority(inputs[i])>0)
				++operatorCount;
		}
		//after that. we can process in order
		if(operatorCount==0)//no operators remaining
			return Integer.parseInt(exp);//immediately return the result
		else if(highestPriority==1)//+- remaining
		{
			//we firstly deal with negative number!
			if(operatorCount==1 && inputs[0]=='-')//if only operator is the leading minus operator
				return Integer.parseInt(exp);
			//otherwise, we need find the operator and compute result
			int opePosition = -1;//set as -1 as non-set
			boolean ifPlusSign = true;//this is to know if plus or minus sign
			for(int i=0; i<inputs.length; i++)
			{
				//notice we may encounter the case of -1-1, thus the leading minus sign should be ignored
				if(inputs[i]=='+'||(inputs[i]=='-'&&i!=0))//we differentiate here because we need know if plus or minus sign
				{
					opePosition = i;
					ifPlusSign = inputs[i]=='+'?true:false;
					break;//when we find we return
				}
			}
			//after we identify the opePosition, we need find start/end of left and right operands
			int leftOperandStart = 0;//left operand must start with 0 index

			int rightOperandEnd = opePosition+1;
			//we need deal with negative value cases
			if(inputs[rightOperandEnd]=='-')
			{
				rightOperandEnd++;
			}
			while(rightOperandEnd<inputs.length && priority(inputs[rightOperandEnd])<1)
			{
				rightOperandEnd++;
			}

			//thus the two operands have been decided
			int leftOperand = Integer.parseInt(exp.substring(0, opePosition));
			int rightOperand = Integer.parseInt(exp.substring(opePosition+1, rightOperandEnd));
			
			//we define a inner result 
			int innerResult = 0;
			if(ifPlusSign)	innerResult = leftOperand + rightOperand;
			else	innerResult = leftOperand - rightOperand;

			//call the recursive part
			return Calculate(""+innerResult+exp.substring(rightOperandEnd));
		}
		else if(highestPriority==2)// / remaining
		{
			//otherwise, we need find the operator and compute result
			int opePosition = -1;//set as -1 as non-set
			boolean ifMultiplySign = true;//this is to know if plus or minus sign
			for(int i=0; i<inputs.length; i++)
			{
				//notice we may encounter the case of -1-1, thus the leading minus sign should be ignored
				if(inputs[i]=='*'||(inputs[i]=='/'&&i!=0))//we differentiate here because we need know if plus or minus sign
				{
					opePosition = i;
					ifMultiplySign = inputs[i]=='*'?true:false;
					break;//when we find we return
				}
			}
			//after we identify the opePosition, we need find start/end of left and right operands
			int leftOperandStart = opePosition-1;//left operand must start with 0 index
			//we need search towards left
			//we have to make sure indexes are valid
			while(leftOperandStart>=0 && priority(inputs[leftOperandStart])<1)
			{
				leftOperandStart--;
			}

			int rightOperandEnd = opePosition+1;
			//we need deal with negative value cases
			if(inputs[rightOperandEnd]=='-')
			{
				rightOperandEnd++;
			}
			while(rightOperandEnd<inputs.length && priority(inputs[rightOperandEnd])<1)
			{
				rightOperandEnd++;
			}

			//thus the two operands have been decided
			int leftOperand = Integer.parseInt(exp.substring(leftOperandStart+1, opePosition));
			int rightOperand = Integer.parseInt(exp.substring(opePosition+1, rightOperandEnd));
			
			//we define a inner result 
			int innerResult = 0;
			if(ifMultiplySign)	innerResult = leftOperand * rightOperand;
			else	innerResult = leftOperand / rightOperand;

			//call the recursive part
			return Calculate(exp.substring(0, leftOperandStart+1)+innerResult+exp.substring(rightOperandEnd));
		}
		else//there are parenthesis remaining
		{
			//we need know the start and end of first matched parenthesis pair
			int parOpen = -1;
			int parEnd = -1;
			int parOpenEndDiff = 0;
			for(int i=0; i<inputs.length; i++)
			{
				if(inputs[i]=='(')
				{
					parOpen = parOpen<0?i:parOpen;//we only update when first time we encoutner an open parenthesis
					parOpenEndDiff++;
				}
				else if(inputs[i]==')') 
				{
					parOpenEndDiff--;
					if(parOpenEndDiff==0)//if matched close parenthesis is found!
					{
						parEnd = i;
						break;
					}
				}
			}
			//thus the parenthesis start from parStart and end at parEnd
			int innerResult = Calculate(exp.substring(parOpen+1, parEnd));//we dropped the parenthesis
			return Calculate(exp.substring(0, parOpen) + innerResult + exp.substring(parEnd+1));
		}
	}
}
