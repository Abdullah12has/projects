'''def gcd(m,n):
    while(n!=0):
        r=m%n
        m=n
        n=r
    return m'''

def gcd(m,n):
    if(n==0):
        return m
    else:
        return gcd(n,m%n)

n1=int(input("Enter first number for GCD  :"))
n2=int(input("Enter second number for GCD  :"))
print("GCD from euclid's ",gcd(n1,n2))
