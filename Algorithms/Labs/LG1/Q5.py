name=input("Enter your name: ")
print("Your name has",len(name),"characters")
print("Your name contains",name.find('a'),"'a' characters")
blankPos=name.find(' ')
print("Position of blank from start:",blankPos)
surname=name[blankPos+1::]
print("Surname is",surname)
print("Position of your surname from beginning:",blankPos)
print("Your name in lowercase: ",name.lower())
print("Your name in uppercase: ",name.upper())
print("Length of name is ",blankPos,"Length of surname is",len(surname))
print("After replace all 'a' to 'w'  ",name.replace('a','w'))
