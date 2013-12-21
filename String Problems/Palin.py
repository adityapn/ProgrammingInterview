def pali(str):
    start,end = 0,len(str)-1
    flag = True
    for i in range(0,len(str)):
        if str[start+i] != str[end-i]:
            flag = False
    if(flag):
        print "Palin"
    else:
        print "not"

def main():
    pali("141")
    pali("1441")
    pali("mofo")

if __name__ == "__main__":main()
    
