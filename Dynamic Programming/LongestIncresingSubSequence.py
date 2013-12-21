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
    items = []
    items.append(li[0])
    i = 0
    j = 1
    max_length = len(li)
    while j< max_length:
        if li[i] < li[j]:
            counter = counter + 1
            items.append(li[j])
            i = j
            j = j + 1
        else:
            j = j+1
    print items

li = [10, 22, 9, 33, 21, 50, 41, 60, 80]
longSubSeq(li)
