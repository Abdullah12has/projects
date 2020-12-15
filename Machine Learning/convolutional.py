import cv2
import numpy as np
from scipy import misc 
#reducing the image and extracting meaningful content and then displaying it 
i = misc.ascent()

import matplotlib.pyplot as plt


iNew = np.copy(i)

sizeX = iNew.shape[0]
sizeY = iNew.shape[1]

filter = [ [-1, 0, 1], [-2, 0, 2], [-1, 0, 1]]
weight = 1

for x in range(1,sizeX-1):
  for y in range(1,sizeY-1):
      output_pixel = 0.0
      output_pixel = output_pixel + (i[x - 1, y-1] * filter[0][0])
      output_pixel = output_pixel + (i[x, y-1] * filter[0][1])
      output_pixel = output_pixel + (i[x + 1, y-1] * filter[0][2])
      output_pixel = output_pixel + (i[x-1, y] * filter[1][0])
      output_pixel = output_pixel + (i[x, y] * filter[1][1])
      output_pixel = output_pixel + (i[x+1, y] * filter[1][2])
      output_pixel = output_pixel + (i[x-1, y+1] * filter[2][0])
      output_pixel = output_pixel + (i[x, y+1] * filter[2][1])
      output_pixel = output_pixel + (i[x+1, y+1] * filter[2][2])
      output_pixel = output_pixel * weight
      if(output_pixel<0):
        output_pixel=0
      if(output_pixel>255):
        output_pixel=255
      iNew[x, y] = output_pixel

new_x = int(sizeX/2)
new_y = int(sizeY/2)
newImage = np.zeros((new_x, new_y))
for x in range(0, sizeX, 2):
  for y in range(0, sizeY, 2):
    pixels = []
    pixels.append(iNew[x, y])
    pixels.append(iNew[x+1, y])
    pixels.append(iNew[x, y+1])
    pixels.append(iNew[x+1, y+1])
    pixels.sort(reverse=True)
    newImage[int(x/2),int(y/2)] = pixels[0]

plt.gray()
plt.grid(False)
plt.imshow(newImage)
plt.show()
