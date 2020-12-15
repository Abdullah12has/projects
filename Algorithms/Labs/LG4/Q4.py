import time
testlist=[1,2,32,8,17,19,42,13,0]
search=int(input("Enter a search value: "))

def sequentialSearch(arr,k):
    i=0
    while i<(len(arr)+1) and arr[i]!=k:
        i+=1
    if i<len(arr):
        return i
    else:
        return -1

start=time.time()
index=sequentialSearch(testlist,search)
end=time.time()
if index!=-1:
    print("Value found in index",index)
else:
    print("Value not found")

print("Passed time in execution:",end-start)
