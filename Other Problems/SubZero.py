def subZero(li):
    temp = 0
    for i in range(0,len(li)):
        temp =0
        for j in range(i,len(li)):
            temp = temp + li[j]
            if temp == 0 :
                print("From {0} to {1} ",i,j)
                return
    print("Not found ")


def main():
    li = [1,2,3,4,-7]
    subZero(li)
    
            
if __name__ == "__main__":main()
