tree = [0, 'start', 'E', 'T', 'I', 'A', 'N', 'M', 'S', 'U', 'R', 'W', 'D', 'K', 'G', 'O', 'H', 'V', 'F',
        'Ü', 'L', ' ', 'P', 'J', 'B', 'X', 'C', 'Y', 'Z', 'Q', 'Ç', 'İ']


def getmessage(code):
    j = 1
    pos = 0
    msg = ''
    index = 0
    codedarray = code.split()
    for letterArr in codedarray:
        for char in letterArr:
            if char == '.':
                pos = j * 2
            elif char == '-':
                pos = j * 2 + 1
            j = pos
            index += 1
        try:
            msg += tree[pos]
            j = 1
            pos = 0
        except IndexError:
            return "Invalid Morse Code at the %d'th position of the code array" % (index-1)
    return msg


code = '.-- .. - .... .-.- -- -.-- .-.- -... . ... - .-.- .-- .. ... .... . ...'
message = getmessage(code)
print(message)

code=input('Enter your own morse code:')
print(getmessage(code))


