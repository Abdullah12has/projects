def HeapBottomUp(H):
    n = len(H)-1
    strt=n//2
    for i in range (strt, 0, -1):
        k=i
        v=H[k]
        heap=False

        while not heap and k*2<=n:
            j=2*k
            if j<n:
                if H[j]<H[j+1]:
                    j=j+1
            if v>= H[j]:
                heap = True
            else:
                H[k]=H[j]
                k=j

        H[k]=v
    return H

print("***NOTE: Ignore the first item in all the arrays (index 0)***")
print(" ")
HA=[0,2,9,7,6,5,8,10]
print("Beginning Array:", HA)
print("Array after heapify: ", HeapBottomUp(HA))

n=len(HA)-1
print("root node:",HA[1])
i=2
j=2
while (i<=n):
    print(j,". level nodes:")
    print(HA[i:i*2])
    i*=2
    j+=1



HA = [0,12,11,13,5,6,7]
print(" ")
print("Beginning Array:", HA)
print("Array after heapify: ", HeapBottomUp(HA))

n=len(HA)-1
print("root node:",HA[1])
i=2
j=2
while (i<=n):
    print(j,". level nodes:")
    print(HA[i:i*2])
    i*=2
    j+=1