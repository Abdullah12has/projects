import numpy as np
import time 
# Python program for implementation of Radix Sort taken from GeeksforGeeks (citation in the report)
def countingSort(arr, exp1): 
	n = len(arr)
	output = [0] * (n) 
	count = [0] * (10) 
	for i in range(0, n): 
		index = (arr[i]/exp1) 
		count[ int((index)%10) ] += 1
	for i in range(1,10): 
		count[i] += count[i-1] 
	# output array 
	i = n-1
	while i>=0: 
		index = (arr[i]/exp1) 
		output[ count[ int((index)%10) ] - 1] = arr[i] 
		count[ int((index)%10) ] -= 1
		i -= 1

	# Copying the output array to arr[], 
	i = 0
	for i in range(0,len(arr)): 
		arr[i] = output[i] 
# Method to do Radix Sort 
def radixSort(arr): 
	max1 = max(arr) 
	exp = 1
	while max1/exp > 0: 
		countingSort(arr,exp) 
		exp *= 10

# Main 



# nlist = np.arange(1, 1000, 1)
# nlist = np.random.randint(0,1000,1000)
# nlist = np.random.randint(0,10000,10000)
# nlist = np.arange(1000, 1, -1)
nlist = np.arange(10000, 1, -1)

arr = nlist

print("Initial Array:", arr[1:12])
start=time.time()
radixSort(arr)
end=time.time()
n = len(arr)
print ("Sorted Array:", arr[1:12])
print("Seconds",end-start)


