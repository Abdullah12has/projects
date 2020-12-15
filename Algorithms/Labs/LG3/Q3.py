def long_words(lst):
    words=[]
    for i in lst:
        if len(i)>5:
            words.append(i)
    return words

def long_words_single(lst):
    return [word for word in lst if len(word)>5]

list=[]
wrd=input("Enter a word:")
while wrd!="STOP":
    list.append(wrd)
    wrd=input("Enter a word:")

print("Words size greater than 5 with standard loop",long_words(list))
print("Words size greater than 5 with single line for loop",long_words_single(list))
