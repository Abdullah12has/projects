import random
name=input("Enter your name and surname to password: ")
print(name)
sliceName=name[3:7]
print("Slicing the name (3,6):",sliceName)
randNum=random.randint(1,900)
print("Random number (1-900):",randNum)
password=sliceName+str(randNum)
print("Generated password",password)
