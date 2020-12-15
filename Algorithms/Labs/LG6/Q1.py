import time
import random

def insertionSort(a):
    start=time.time()
    for i in range(1,len(a)):
        val=a[i]
        j=i-1
        while j>=0 and a[j]>val:
            a[j+1]=a[j]
            j-=1
        a[j+1]=val
    end=time.time()
    return end-start

for i in range(5):
    alist=[]
    for j in range(0,1000):
        alist.append(random.randrange(0,1000000))
    print("Some part of the array",(i+1),"",alist[:10])
    print("%10.7f seconds" %insertionSort(alist))
