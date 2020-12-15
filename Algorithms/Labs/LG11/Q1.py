import string

def shiftTable(p):
    m=len(p)
    table=dict((key,m) for key in string.ascii_lowercase)
    for j in range(m-1):
        table[p[j]]=m-1-j
    return table

def horspool(p,t):
    m=len(p)
    n=len(t)
    table=shiftTable(p)
    i=m-1
    while (i <= n-1):
        k=0
        while k<=m-1 and p[m-1-k]==t[i-k]:
            k+=1
        if k==m:
            return i-m+1
        else:
            i+=table[t[i]]
    return -1

file=open("impact.txt","r")
if file.mode=='r':
    content=file.read()
    print('File content is\n')
    print(content)
    pat=input('Enter a string to search: ')
    ind=horspool(pat,content)
    print(ind)
    file.close()
else:
    print('File not found!')

