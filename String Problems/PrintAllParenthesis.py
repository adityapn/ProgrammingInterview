

string = ["" for i in range(6)]

def printParenthesis(pos,number,open=0,close=0):
    global string
    if close == number:
        temp = ""
        for st in string:
            temp += st
        print temp        
        return
    else:
        if open > close:
            string[pos]= "}"
            print "open > close ("+str(pos+1)+","+str(number)+","+str(open)+","+str(close+1)+")"
            printParenthesis(pos+1,number,open,close+1)            
        if open < number:
            string[pos] = "{"
            print "open < number ("+str(pos+1)+","+str(number)+","+str(open+1)+","+str(close)+")"
            printParenthesis(pos+1,number,open+1,close)
    
printParenthesis(0,2)
            
    
