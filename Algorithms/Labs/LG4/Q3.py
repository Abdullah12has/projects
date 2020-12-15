import time

text="NOBODY_NOTICED_HIM"
pattern="NOT"

def bruteForceStringMatch(t,p):
    for i in range(len(t)-len(p)+1):
        j=0
        while j<len(p) and p[j]==t[i+j]:
            j+=1
        if j==len(p):
            return i
    return -1

start=time.time()
ind=bruteForceStringMatch(text,pattern)
if ind>=0:
    print("First index of ",pattern,"in the text is ",ind)
else:
    print("Pattern not found")
end=time.time()
print(end-start)
