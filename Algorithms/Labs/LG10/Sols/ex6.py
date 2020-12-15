import pandas as pd
import matplotlib.pyplot as plt


df_score = pd.read_csv('scores.csv')

plt.figure(1) #opens a new active figure window
plt.clf() #clears the figure window

plt.subplot(1,2,1)
plt.hist(df_score['grades'],5,edgecolor='red') #plots scores with 5 bins/buckets
plt.xlabel('Bins set to 5')

plt.subplot(1,2,2)
plt.hist(df_score['grades'], color = 'red',edgecolor='green') 
plt.xlabel('Bins not specified (default:10)')
plt.show()

