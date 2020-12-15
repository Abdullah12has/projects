import time

def sumUsingFor(n):
    start=time.time()
    sum=0
    for i in range(n+1):
        sum+=i
    end=time.time()-start
    print("sum is",sum,"required",end,"seconds")

def sumUsingFormulae(n):
    start=time.time()
    sum=n*(n+1)/2
    end=time.time()
    return sum,start-end

for a in range(5):
    sumUsingFor(100000)

print("Sum is %.1f  required %.1f seconds if we use formulae"%sumUsingFormulae(100000))
