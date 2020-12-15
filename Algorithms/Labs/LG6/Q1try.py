import time
import numpy as np
def insertionSort(a):
    n=len(a)
    for i in range(1,n):
        v=a[i]
        j=i-1
        while j>=0 and a[j]>v:
            a[j+1]=a[j]
            j-=1
        a[j+1]=v
    return a

for i in range(4):
    print("Some part of array",i)
    arr=np.random.randint(0,100001,1000)
    start=time.time()
    arr=insertionSort(arr)
    end=time.time()
    print(arr[500:510])
    print(end-start,"seconds\n")
