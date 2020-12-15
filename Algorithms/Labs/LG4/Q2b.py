import numpy as np
import time
arr=np.random.randint(0,101,1000)

def swap(n1,n2):
    return n1,n2

def bubbleSort(arr):
    start=time.time()
    exchange=True
    i=0
    while i<(len(arr)-1) and exchange:
        exchange=False
        for j in range(len(arr)-1-i):
            if arr[j+1]<arr[j]:
                arr[j+1],arr[j]=swap(arr[j],arr[j+1])
                exchange=True
        i+=1
    end=time.time()

    return end-start
        
tim=bubbleSort(arr)
print(arr)
print(tim)
