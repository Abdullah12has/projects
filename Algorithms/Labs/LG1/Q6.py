def sum(list):
    total=0
    for i in list:
        if i%2==1:
            total+=i
    return total

list=[]
inp=int(input("Enter an integer value except  (0):"))
while inp!=0:
    list.append(inp)
    inp=int(input("Enter an integer value except  (0):"))
print(sum(list))
    
