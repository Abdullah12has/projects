def avg(arr):
    sum=0
    for i in arr:
        sum+=i
    return sum/len(arr)

def rem(arr,avg):
    for i in arr:
        if i<avg:
            arr.remove(i)
            return arr
    
arr=[]
for i in range(5):
    num=int(input("Enter a number: "))
    arr.append(num)
avg=avg(arr)
print("Average is",avg)
print("List of numbers ",arr)
arr.sort()
print("Sorted format of the list ",arr)

arr.reverse()
print("Reverse format of the list ",arr)

arr=rem(arr,avg)
print("Final format of list:",arr)

