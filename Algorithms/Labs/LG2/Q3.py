cars={
    "Honda CR-V":125000,
    "Volkswagen":135000,
    "Toyota Yaris":55000,
    "Volkswagen Toureg":255000,
    "Honda Civic":95000
    }

print("Original Dictionary:")
print(cars)
print("\nPrices over 100000")
for x in cars:
    if cars[x]>100000:
        print(x,cars[x])

for x in cars:
    if cars[x]<100000:
        cars[x]=99000

print("\nUpdated Dictionary:\n",cars)
