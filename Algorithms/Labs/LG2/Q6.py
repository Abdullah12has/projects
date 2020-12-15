import math
import time
def seive(n):
    arr=[]
    for i in range(2,n+1):
        arr.append(i)
    for i in range(2,math.floor(math.sqrt(n))+1):
        if arr[i-2]!=0:
            j=i+i
            while j<=n:
                arr[j-2]=0
                j=j+i
    while 0 in arr:
        arr.remove(0)
    return arr

def primeFactorization(num):
    primeNums=seive(num)
    factors=[]
    for i in range(len(primeNums)):
        while num%primeNums[i]==0 and num!=0:
            num/=primeNums[i]
            factors.append(primeNums[i])
    return factors

n=int(input("Non-negative integer >=2 please: "))
m=int(input("Another Non-negative integer >=2 please: "))

start=time.time()
fact1=primeFactorization(n)
fact2=primeFactorization(m)

print("Prime factors of n ",fact1)
print("Prime factors of m ",fact2)

common=[]
j=0
for i in fact1:
    if i==fact2[j]:
        common.append(i)
        j+=1
print("\nCommon prime factors are:",common)
gcd=1
for i in common:
    gcd*=i

print("Greatest common divisor:",gcd)
end=time.time()
print("Passed time in execution:",end-start)

    
        
