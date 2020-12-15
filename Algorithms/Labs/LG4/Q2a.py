import numpy as np
import time
arr=np.random.randint(0,101,1000)

def swap(n1,n2):
    return n1,n2

def bubbleSort(arr):
    start=time.time()
    for i in range(len(arr)-1):
        for j in range(len(arr)-1):
            if arr[j+1]<arr[j]:
                arr[j],arr[j+1]=swap(arr[j+1],arr[j])
    end=time.time()
    return end-start

time=bubbleSort(arr)
print(arr)
print(time)
