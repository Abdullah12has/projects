import csv


def write_to_txt(puzzles):
    with open('puzzles.txt', 'w') as writeFile:
        index = 1
        for puzzle in puzzles:
            writeFile.write(str(index) + ")\n")
            writeFile.write('-----\n')
            for i in puzzle:
                for j in i:
                    if j is i[0]:
                        writeFile.write('| ')
                    writeFile.write(j + ' | ')
                writeFile.write('\n-------------\n')
            writeFile.write('\n')
            index += 1
