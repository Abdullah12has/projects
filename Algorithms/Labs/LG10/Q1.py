import matplotlib.pyplot as plt
import numpy as np
plt.clf()
n_groups = 5
index = np.arange(n_groups)
means_men = (20, 35, 30, 35, 27)
means_women = (25, 32, 34, 20, 25)
bar_width = 0.25
plt.bar(index, means_men, bar_width, align='edge')
plt.bar(index, means_women, -bar_width, align='edge')
plt.xlabel('Group')
plt.ylabel('Scores')
plt.title('Scores by group and gender')
plt.legend(['Men', 'Women'])
plt.show()
