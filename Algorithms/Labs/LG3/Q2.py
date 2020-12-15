import time
import numpy as np

def mult_tble():
    start = time.time()
    mtb = []
    for row in range(1,300):
        tbitem = []
        for col in range(1,300):
            tbitem.append(row * col)
        mtb.append(tbitem)
        end = time.time()
    print(mtb)
    return end-start


def mult_table(n):
    start = time.time()
    rng = np.arange(1, n+1)
    rng = rng * rng[:,None]
    end = time.time()
    print(rng)
    return end-start

print("Function performed %10.15f seconds"%mult_tble())
print("----------------------")
print("Function performed %10.15f seconds"%mult_table(300))

print("Algorithm with numpy is more efficient")
