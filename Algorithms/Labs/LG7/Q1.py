import time
import random
def partition(A, lo, hi):
    i = lo
    j = hi + 1
    pivot = A[lo]
    while True:
        while True:
            i += 1
            if A[i] >= pivot:
                break
        while True:
            j -= 1
            if A[j] <= pivot:
                break
        if i >= j:
            return j
        A[i],A[j]=A[j],A[i]
  
def quickSort(arr,low,high): 
    if low < high: 
        pi = partition(arr,low,high)
        quickSort(arr, low, pi-1) 
        quickSort(arr, pi+1, high)

arr=[]
for i in range(10000):
    arr.append(random.randint(0,100))
start=time.time()
quickSort(arr,0,len(arr)-1)
end=time.time()
print(end-start)
print(arr[:1000])
