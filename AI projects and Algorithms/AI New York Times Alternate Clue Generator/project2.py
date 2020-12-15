import project1 as p1
import numpy as np
import pandas as pd
import re
from textblob import TextBlob as tb
import nltk
from nltk.corpus import wordnet
import selenium.webdriver as swd 
import io


def findDefD(word): #find def by webscraping 

    cpath = r"C:\Users\abdul\Desktop\AIproject\chromedriver.exe"
    # url2 = 'https://www.dictionary.com/'
    url1 = 'https://www.merriam-webster.com/' #will be using 2 dictionaries to check 
    content = ""
    try:

        browser = swd.Chrome(cpath)
        browser.get(url1)
        searchBox = browser.find_element_by_xpath('/html/body/div[1]/div/header/div/div[4]/form/div[1]/input')
        searchBox.send_keys(word)
        searchBox.submit()
        p1.sleep(3)
        element = browser.find_element_by_class_name('vg')
        content = element.get_attribute("innerHTML")
        browser.close()
    except:
        browser.close()

    with io.open("word.txt", "w", encoding="utf-8") as f:
        f.write(content)
        f.close()

    file = open("word.txt", "r")
    content = file.read()
    file.close()
    finaldef = []

    pattern = re.compile(r"<.*?>")
    definations = re.sub(pattern, "", content)

    finaldef = definations.split('\n')

    return finaldef[0]
    

def findDefW(word):  #find defination from the wordnet
    synset = wordnet.synsets(word)

    # print('Word and Type : ' + synset[0].name())
    # print('Synonym is: ' + synset[0].lemmas()[0].name())
    
    # print('Example is : ' + str(synset[0].examples()))
    try:
        return( synset[0].definition())
    except:
        return ""




    

def cleanword(word): #remove spaces and numbers
    p1 = re.compile(r"\s")
    p3 = re.compile(r"\d")
    w = word
    w = re.sub(p1, "", w)
    w = re.sub(p3, "", w)
    w = w.lower()
    return w

def cleanx2(word): #clean again to remove -
    p1 = re.compile(r"\s")
    p2 = re.compile(r"-")
    p3 = re.compile(r"\d")
    w = re.sub(p2, "", word)
    w = re.sub(p1, "", w)
    w = re.sub(p3, "", w)
    w = w.lower()
    return w

def compile_down_words(o): #compiles the down words 
    dwords = []
    for i in range(5):
        word = ""
        for j in range(5):
            word  += o[j][i]
        dwords.append(word)
    return dwords


def compile_words(o): # compiles across and down words 

    across = o.split('\n')

    awords = [] # Across words according to their index-1
    dwords = [] # Down words according to their index-1
    # Across word extraction
    for i in range(len(across)):
        w = cleanword(across[i])
        if w != '':
            awords.append(w)
    #Down word extraction
    dwords = compile_down_words(awords)



    for i in range(5):
        aw = cleanx2(awords[i])
        dw = cleanx2(dwords[i])
        awords[i] = aw
        dwords[i] = dw
    return awords, dwords


#___________________________________________________________________________ compiling part

def clean_clue(clue):
    p1 = re.compile(r";|\.|:")
    w = re.sub(p1, ";", clue)
    neww = w.split(";")

    
    return neww[0]

def find_new_clue(word):

    clue = findDefW(word)

    # if clue == '':
    #     clue = dict2.find_clue2(word)

    clue = clean_clue(clue) # making the clue short
    
    clue = clue.capitalize()

    return clue


def generate_clues_all(awords, dwords):
    new_across_clues = [] 
    new_down_clues = []

    for i in range(5):
        new_across_clues.append(find_new_clue(awords[i]))
        new_down_clues.append(find_new_clue(dwords[i]))

    return new_across_clues, new_down_clues










# nltk.download('wordnet')

awords, dwords = compile_words(p1.output)
new_across_clues, new_down_clues = generate_clues_all(awords, dwords)

print(p1.output)
print(p1.acrossclues)

print("Across words", awords)
print("Down words", dwords)
print("New Across words", new_across_clues)
print("New Down words", new_down_clues)



# print(p1.acrossclues)   #all the clues in this array 
# print(p1.output)  #the puzzle in txt form 
