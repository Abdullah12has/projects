import matplotlib.pyplot as plt

#clears the current figure window
plt.clf()

#creates the plot with x, y values red circle markers 
plt.plot([1,2,3,4], [1,4,9,16], 'ro')

#changes the limits of the x and y axis
#[xmin, xmax, ymin, ymax]
plt.axis([0, 6, 0, 20])
plt.show()
