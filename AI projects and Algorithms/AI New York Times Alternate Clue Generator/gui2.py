import sys
import PySimpleGUI as sg
import random


BOX_SIZE = 30

layout = [
            [sg.Text('Crossword Puzzle'), sg.Text('', key='_OUTPUT_')],
            [sg.Graph((600,600), (0,450), (450,0), background_color='white', key='_GRAPH_')],
            [sg.Text("Across Clues"), sg.Text('', key='_OUTPUT_')]
         ]

window = sg.Window('Puzzle').Layout(layout).Finalize()

g = window.FindElement('_GRAPH_')

for row in range(5):
    for i in range(5):
        if random.randint(0,100) > 10:
            g.DrawRectangle((i*BOX_SIZE+5,row*BOX_SIZE+3), (i*BOX_SIZE+BOX_SIZE+5,row*BOX_SIZE+BOX_SIZE+3), line_color='black')
        else:
            g.DrawRectangle((i*BOX_SIZE+5,row*BOX_SIZE+3), (i*BOX_SIZE+BOX_SIZE+5,row*BOX_SIZE+BOX_SIZE+3), line_color='black', fill_color='black')

        g.DrawText('{}'.format(row*6+i+1),(i*BOX_SIZE+10,row*BOX_SIZE+8))

while True:             # Event Loop
    event, values = window.Read()
    print(event, values)
    if event is None or event == 'Exit':
        break

window.Close()