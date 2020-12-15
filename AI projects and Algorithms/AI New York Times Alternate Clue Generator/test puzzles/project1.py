from selenium import webdriver
from time import sleep
import re
from datetime import *
from tkinter import *
import time
class ExtractPuzzle():
    def __init__(self):
        cpath = r"C:\Users\abdul\Desktop\AIproject\chromedriver.exe"
        self.driver = webdriver.Chrome(cpath)
       

    def Start(self):
        #EXTRACTING DATA


        self.driver.get('https://www.nytimes.com/crosswords/game/mini')
        sleep(2)
        startBtn = self.driver.find_element_by_xpath('//*[@id="root"]/div/div/div[4]/div/main/div[2]/div/div[2]/div[3]/div/article/div[2]/button/div')
        startBtn.click()
        sleep(2)
        r1 = self.driver.find_element_by_xpath('//*[@id="root"]/div/div/div[4]/div/main/div[2]/div/div/ul/div[2]/li[2]/button')

        r1.click()
        r2 = self.driver.find_element_by_xpath('//*[@id="root"]/div/div/div[4]/div/main/div[2]/div/div/ul/div[2]/li[2]/ul/li[3]/a')
        r2.click()
        sleep(2)


        r3 = self.driver.find_element_by_xpath('//*[@id="root"]/div/div[2]/div[2]/article/div[2]/button[2]/div')
        r3.click()
        sleep(2)
        c1 = self.driver.find_element_by_xpath('//*[@id="root"]/div/div[2]/div[2]/span')
        c1.click()
        sleep(2)
        element = self.driver.find_element_by_xpath('//*[@id="root"]/div/div/div[4]/div/main/div[2]')

        content = element.get_attribute("innerHTML")

        

        self.driver.close()

        file = open("file.txt", "w")
        file.write(content)
        file.close()
       
#main
bot = ExtractPuzzle()
bot.Start()

#Showing solved Puzzle----------------------------------------------
file = open("file.txt", "r")
content = file.read()

file.close()
output = " "
i = 1
numbers = []
while i <= 25:  #the total number of letters
    indexLetter = 'id="cell-id-' + str(i-1) + '"'
    index = content.find(indexLetter)
    letter = content[index + (len(indexLetter) + 8):index + (len(indexLetter) + 18)]

   
    if letter == 'Cell-block':
       
        row = int(i / 5)
        col = i % 5
      
        output += "-      "
        if i % 5 == 0:  #check if 5 have been completed so we move to next line
            output += " \n\n"
        i+=1

        continue

        
    else:
       
        index2 = content.find('text-anchor="middle"', index)
        indexStart = content.find('text-anchor="start"', index, index2)
        if indexStart != (-1):
            indexNumber = content.find("</text>", indexStart)
            letterNumber = content[indexNumber + 7]
            output += ""+letterNumber
            numbers.append(letterNumber) # array storing numbers
         
        else:
             output += " "
            
        index3 = content.find('</text>',index2)
        mainletter = content[index3-1]
        output += mainletter+"      "

    if i % 5 == 0:   # we need to get to new line after 5
        output += " \n\n"
    i+=1


# print(output) 
# till here it's just working on the console

#gui part_____________________

l2 = output.split("    ")
#print(l2)
today = date.today()
# print("\n                        "+str(today) )
# print("                        HUKAB")

#displaying the hints__________________________________

u = 1
#print("\n ACROSS:\n")

fifthclue = l2[5]
fifthclue = fifthclue[5]
sixthclue = l2[10]
sixthclue = sixthclue[5]
seventhclue = l2[15]
seventhclue = seventhclue[5]
e8clue = l2[15]
e8clue = e8clue[5]

txt = ["", "1 ", '4' , str(sixthclue)+" ", str(seventhclue)+" ", str(seventhclue)+" ", "1 ","2 ","3 ","4 ","5 "]



acrossclues = []
while u < 11: 
    t1 = content.split('Clue-text--3lZl7">') #splitting the html code using the class details to extract text
    a1 = t1[u].split('</span>')

    txt[u] +=  a1[0]
    # print(txt[u])
    acrossclues.append(txt[u])
    u += 1
    if u == 6:
         print(" ")
        
if(acrossclues[3][0] == acrossclues[4][0]):
    a = int (acrossclues[4][0]) + 1
    a = str(a) + acrossclues[4][1:]
    acrossclues[4] = a






#GUI INTERFACE

# def draw_table(c):

#     for i in range(50, 301, 50):
#         c.create_line([(i, 50), (i, 300)], tag='grid_line')

#     # Creates all horizontal lines at intevals of 100
#     for i in range(50, 301, 50):
#         c.create_line([(50, i), (300, i)], tag='grid_line')

# root = Tk()
# root.geometry('800x800') #resolution
# label_1= Label(root,text="New York Times Mini Puzzle", font=('Times New Roman','20')) #heading
# label_1.grid(row=0,column = 0, columnspan = 5)

# u = 0
# r = 1 #row
# col = 0 #column
# while u <25:
# #button 1 statisfying both the possibility of black box and clue box
#     if col < 5:
#         if l2[u][-1] == '-': #add black block
#             button_u = Button(root, bg="black",fg="black", width=8, height=4, font=('Times New Roman', '13'))
#             button_u.grid(row=r,column=col)
#         elif l2[u][-2] != '':
#             button_u = Button(root, text = l2[u][-2] + '\n' + '\n'  + '      ' +l2[u][-1], fg="black", width=8, height=4, anchor= NW, font=('Times New Roman', '13'), justify = LEFT, padx=2)
#             button_u.grid(row=r,column=col)    
#         else:
#             button_u = Button(root, text = l2[u][-1], fg="black", width=8, height=4, font=('Times New Roman', '13'))
#             button_u.grid(row=r,column=col)
#         col += 1
#         u += 1
#     else:
#         col = 0
#         r += 1


# now = datetime.now()

# current_time = now.strftime("%H:%M:%S")

# today = str(today) +"\n"+ str(current_time)

# button_cluesacross = Button(root, text = acrossclues[0] +'\n' + acrossclues[1] + '\n' + acrossclues[2] +'\n' + acrossclues[3] + '\n' + acrossclues[4], fg="Grey", width=20, height=25, font=('Times New Roman', '13'),wraplength = 175, anchor = NW, justify = LEFT, padx=2)
# button_cluesacross.grid(row=1,column=5, rowspan = 6)

# myLabel1= Label(root, text = 'Across', font=('Times New Roman', '20'))
# myLabel1.grid(row=0,column=5)

# button_cluesdown = Button(root, text = acrossclues[5] +'\n' + acrossclues[6] + '\n' + acrossclues[7] +'\n' + acrossclues[8] + '\n' + acrossclues[9] , fg="Grey", width=20, height=25, font=('Times New Roman', '13'), wraplength = 175, anchor = NW, justify = LEFT, padx=2)
# button_cluesdown.grid(row=1,column=6, rowspan = 6)

# myLabel2= Label(root, text = "Down", font=('Times New Roman', '20'))
# myLabel2.grid(row=0,column=6)

# myLabel3 = Label(root, text = today,  font=('Times New Roman', '12'))
# myLabel3.grid(row=6,column=4)

# myLabel4 = Label(root, text = "HUKAB", font=('Times New Roman', '12'))
# myLabel4.grid(row=7,column=4)


# root.mainloop()
