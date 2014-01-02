# Find the differnce between money and coins use the ones which give min
# Chanage 

coins = [25,10,5,1]
coins.sort()
money = 121

def count(money , coins ):
    if money == 0 or len(coins) == 0:
        return 0
    change = []
    number = len(coins)
    i = 0
    while i < number:
        minCoin = coinWithMinDifference(money,coins)
        i = i + 1
        if minCoin is not 0:
            change.append(minCoin)
            money = money - minCoin
            i = 0
        
    print change
        
def coinWithMinDifference(money,coins):
    final = 0
    diff = money
    for coin in coins:
        minus = money - coin
        if minus > -1:
            if minus < diff:                
                final = coin
    return final

    

count(money,coins)
    
        
        
