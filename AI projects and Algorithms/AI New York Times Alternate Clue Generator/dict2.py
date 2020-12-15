import numpy as np
import pandas as pd

def find_clue2(word):

    w = word.capitalize()
    pd.options.display.max_colwidth = 100


    mean_df = pd.read_excel('meaning.xlsx')

    nparr1 = mean_df["Word"].to_numpy
    nparr2 = mean_df["Meaning"].to_numpy

    for i in range(nparr1):
        if word == nparr1[i]:
            index = i

    

    print(index)

    # filter = mean_df["Word"]== w

    # a = mean_df.where(filter, axis=1)
    # print("SAA", a)


    # a = a.dropna()

    # i = a.index.values

    # j = mean_df["Meaning"][i]



    # return j


print(find_clue2("sisi"))





