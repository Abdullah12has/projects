import time
import numpy as np

def polynom(a,x):
    p=0
    for i in range(len(a)-1,0,-1):
        power=1
        for j in range(1,i):
            power*=x
            p+=a[i]*power
    return p

a=np.random.randint(0,100001,1000)
x=2
start=time.time()
ans=polynom(a,x)
end=time.time()
print(ans)
print(end-start)
