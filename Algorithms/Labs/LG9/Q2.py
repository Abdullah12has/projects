import time
import random

start = time.time()


def heapify(arr, n, i):
    largest = i
    l=2*i+1
    r=2*i+2

    if l<n and arr[i]<arr[l]:
        largest=l

    if r<n and arr[largest]<arr[r]:
        largest=r

    if largest!=i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def heapSort(arr):
    n=len(arr)
    for i in range(n, -1, -1):
        heapify(arr, n, i)
    print ('Heapified Array: ', arr[1:12])
    for i in range(n-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)

arr=[]
for i in range(0,1000):
    arr.append(random.randrange (0,1000000))
print("Initial Array:", arr[1:12])
heapSort(arr)
end = time.time()
print(arr[:100])


