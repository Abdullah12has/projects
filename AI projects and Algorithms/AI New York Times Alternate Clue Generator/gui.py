import project1 as p1
import project2 as p2

#GUI INTERFACE


root = p1.Tk()
root.geometry('800x800') #resolution
label_1= p1.Label(root,text="New York Times Mini Puzzle", font=('Times New Roman','20')) #heading
label_1.grid(row=0,column = 0, columnspan = 5)

# #Creating border color
# Border = LabelFrame(root,bd=5, bg="blue", relief=FLAT)
# Border.pack(padx=10, pady=10) 


u = 0
r = 1 #row
col = 0 #column
while u <25:
#button 1 statisfying both the possibility of black box and clue box
    if col < 5:
        if p1.l2[u][-1] == '-': #add black block
            button_u = p1.Button(root, bg="black", fg ="black",bd =2, width=8, height=4, font=('Times New Roman', '13'))
            button_u.grid(row=r,column=col)
        elif p1.l2[u][-2] != '':
            button_u = p1.Button(root, text = p1.l2[u][-2] + '\n' + '\n'  + '      ' + p1.l2[u][-1], bd = 1 ,fg="black", width=8, height=4, anchor= p1.NW, font=('Times New Roman', '13'), justify = p1.LEFT)
            button_u.grid(row=r,column=col)    
        else:
            button_u = p1.Button(root, text = p1.l2[u][-1],  fg="black", width=8, height=4, font=('Times New Roman', '13'))
            button_u.grid(row=r,column=col)
        col += 1
        u += 1
    else:
        col = 0
        r += 1


now = p1.datetime.now()

current_time = now.strftime("%H:%M:%S")

today = str(p1.today) +"\n"+ str(current_time)

button_cluesacross = p1.Button(root, text = "ORIGINAL CLUES:" + '\n' +  p1.acrossclues[0] +'\n' + p1.acrossclues[1] + '\n' + p1.acrossclues[2] +'\n' + p1.acrossclues[3] + '\n' + p1.acrossclues[4] + '\n' + '\n' + "NEW ACROSS:"+ '\n' + "1 " + p2.new_across_clues[0] +'\n' + "4 " + p2.new_across_clues[1] + '\n' + "6 " + p2.new_across_clues[2] + '\n' + "7 " + p2.new_across_clues[3] + '\n' + "8 " + p2.new_across_clues[4]  , fg="Black", width=21,bg ="white", height=25, font=('Times New Roman', '12'),wraplength = 190, anchor = p1.NW, justify = p1.LEFT, padx=2)
button_cluesacross.grid(row=1,column=5, rowspan = 6)

myLabel1= p1.Label(root, text = 'Across', font=('Times New Roman', '20'))
myLabel1.grid(row=0,column=5)

button_cluesdown = p1.Button(root, text = "ORIGINAL CLUES:" + '\n' + p1.acrossclues[5] +'\n' + p1.acrossclues[6] + '\n' + p1.acrossclues[7] +'\n' + p1.acrossclues[8] + '\n' + p1.acrossclues[9] + '\n' + '\n' + "NEW DOWN:" + '\n' + "1 " + p2.new_down_clues[2]+ '\n' + "2 " + p2.new_down_clues[3]+ '\n' + "3 " + p2.new_down_clues[4]+ '\n' + "4 " + p2.new_down_clues[0]+ '\n' + "5 " + p2.new_down_clues[1], fg="Black", width=21, bg= "white", height=25, font=('Times New Roman', '12'), wraplength = 180, anchor = p1.NW, justify = p1.LEFT, padx=2)
button_cluesdown.grid(row=1,column=6, rowspan = 6)

myLabel2= p1.Label(root, text = "Down", font=('Times New Roman', '20'))
myLabel2.grid(row=0,column=6)

myLabel3 = p1.Label(root, text = today,  font=('Times New Roman', '12'))
myLabel3.grid(row=6,column=4)

myLabel4 = p1.Label(root, text = "HUKAB", font=('Times New Roman', '12'))
myLabel4.grid(row=7,column=4)


root.mainloop()