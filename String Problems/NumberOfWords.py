# -*- coding: utf-8 -*-
#Given a string, count number of words in it.
#The words are separated by following characters: space (‘ ‘)
#or new line (‘\n’) or tab (‘\t’) or a combination of these.

def words(string):
    count = 1
    flag = False
    position = 0
    for i in string:        
        if ( i == "\n"  or i == "\t" or i == " " ) and (string[position+1] != " " and string[position+1] != "\n" and string[position+1] != "\t"):
            count = count + 1
        position = position + 1
                        
    return count

if __name__ == "__main__":
    print words("one          two         three \n \n\n four \t\t five six")

