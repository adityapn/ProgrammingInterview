
# KMP String pattren with complexity of O(n+m)


def KMP(string,match):
    n = len(string)
    m = len(match)
    i = 0
    j = 0
    # Just for sake of algo perfomance
    count_times_used = 0
    while i < n:
        count_times_used+=1
        if match[j] == string[i]:
            if j == m-1:
                print "Found at "+str(i-m+1)+" no.times.checked : "+str(count_times_used)
                return
            i += 1
            j += 1
        elif j>0:            
            j = j-1 # We can use failure function 
        else:
            i += 1
        


KMP("ASFDEHHAASSDSDASASEDWA","SASE")
