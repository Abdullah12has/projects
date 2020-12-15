import time
import numpy as np
def polynom(arr,x):
    p=arr[0]
    power=1
    for i in range(1,len(arr)):
        power*=x
        p+=arr[i]*power
    return p

arr=np.random.randint(0,100001,1000)
x=int(input("Enter the value of X: "))
start=time.time()
ans=polynom(arr,x)
end=time.time()
print(ans)
print("\n",end-start," seconds")
