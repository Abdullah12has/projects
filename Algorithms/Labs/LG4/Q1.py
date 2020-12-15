import numpy as np
import time
arr=np.random.randint(0,10000,10000)

def swap(n1,n2):
    return n1,n2
    

def selectionSort(arr):
    start=time.time()
    for i in range(len(arr)-1):
        min=i
        for j in range(i+1,len(arr)):
            if arr[j]<arr[min]:
                min=j
        arr[min],arr[i]=swap(arr[i],arr[min])
    end=time.time()
    return end-start

tim=selectionSort(arr)
print(len(arr))
print(arr[:100])
print(tim)
