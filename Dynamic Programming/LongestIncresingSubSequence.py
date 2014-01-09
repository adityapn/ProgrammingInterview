# Longest Increasing sub sequence
# in the below array 41,60,80 is longest increasing sub sequence
# Example : LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}
# Solution : Consider two pointer i and j , comparse i'th value j'th value
# If the i'th < j'th then increment the counter and also move i'th to j'th
# increment j'th by 1

def longSubSeq(li):
    if len(li) < 1:
        return None
    counter = 1
    main_list = []
    # temporary list holds only temporary series
    temp = []
    temp.append(li[0])
    i = 0
    j = 1
    # When the list is empty add the temp data do not look for length
    first = True
    
    max_length = len(li)
    while j< max_length:
        if li[i] < li[j]:
            counter = counter + 1
            temp.append(li[j])
            i = j
            j = j + 1
        else:
            # When the new sequence is greater than old one , replace it
            if len(temp) > len(main_list):                
                main_list = temp            
            temp = []
            i += 1            
            j = j+1
    # When the last m number are incresing then check it after the loop ,
    # Because loop escapes it 
    if len(temp) > len(main_list):
        main_list = temp            
    
    print main_list

li = [213,32,12,43,10,11,12,13,15,16,1,2,3,4,5,6]
longSubSeq(li)
