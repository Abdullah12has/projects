def partition(arr,low,high):
    pivot=arr[low]
    s=low

    for i in range(low+1,high):
        if arr[i]<pivot:
            s+=1
            arr[s],arr[i]=arr[i],arr[s]
    arr[low],arr[s]=arr[s],arr[low]
    return s

arr=[10,7,8,9,1,5]
l=0
r=len(arr)-1
n=int(input("Enter the item number that will be searched as index value:"))
index=partition(arr,l,r)

while(index!=n):
    if index<n:
        l=index+1
    else:
        r=index-1
    index=partition(arr,l,r)

print("Partially Sorted array:",arr)
print(n,"th item of an array is: ",arr[index])
