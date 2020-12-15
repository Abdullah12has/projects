import matplotlib.pyplot as plt
import numpy as np
plt.clf()
x = np.arange(1,11)
y = x**2

plt.subplot(2,1,1)
plt.plot(x,y,'r:*')
plt.xlabel('x')
plt.ylabel('y')
plt.title('y is equal to x squared')
plt.legend(['y = x**2'])

plt.subplot(2,1,2)
plt.plot(x,y,'k-.>')
plt.xlabel('x')
plt.ylabel('y')
plt.title('y is equal to x squared')
plt.legend(['y = x**2'])

plt.grid('on')
plt.grid('off')
plt.show()
