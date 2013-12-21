'''
Suppose there is a circle. There are n petrol pumps on that circle.
You are given two sets of data.

1. The amount of petrol that petrol pump will give.
2. Distance from that petrol pump to the next petrol pump.

Calculate the first point from where a truck will be able to complete the
circle (The truck will stop at each petrol pump and it has infinite capacity).
Expected time complexity is O(n). Assume for 1 litre petrol,
the truck can go 1 unit of distance.

For example, let there be 4 petrol pumps with amount of petrol and
distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}.
The first point from where truck can make a circular tour is 2nd petrol pump.
Output should be “start = 1″ (index of 2nd petrol pump).

We can use a Queue to store the current tour.
We first enqueue first petrol pump to the queue,
we keep enqueueing petrol pumps till we either complete the tour,
or current amount of petrol becomes negative.
If the amount becomes negative, then we keep dequeueing petrol pumps
till the current amount becomes positive or queue becomes empty.

http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/

'''

def find_starting_pump(pump):
    (start, end) = (0, 1)
    petrol = pump[start][0] - pump[start][1]
    while end != start:
        while petrol < 0:
            petrol -= pump[start][0] - pump[start][1]
            start = (start + 1) % len(pump)
            if not start:
                return -1
        petrol += pump[end][0] - pump[end][1]
        end = (end + 1) % len(pump)
    return start
 
if __name__ == "__main__":
    pumps = [(4,6), (6,5), (7,3), (4,5)]
    print find_starting_pump(pumps)
