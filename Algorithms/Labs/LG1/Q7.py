def gcd(m,n):
    t=n
    while t!=0:
        if m%t==0:
            if n%t==0:
                return t
        t=t-1
    return 0

n1=int(input("A non-negative integer please: "))
n2=int(input("Another non-negative integer please: "))
print("GCD from consecutive check :",gcd(n1,n2))
