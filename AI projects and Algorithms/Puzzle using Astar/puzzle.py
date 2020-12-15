import random
import copy

# PuzzleData puzzle
PuzzleData = [
    ['1', '2', '3'],
    ['4', '5', '6'],
    ['7', '8', 'X']]

'''
    Generating a random puzzle in here
'''


def generate():
    no_steps = random.randint(20, 2522)

    puzzle = copy.deepcopy(PuzzleData)

    # Moving empty slot random number of times
    for i in range(no_steps):
        puzzle = move_random(puzzle)

    return puzzle


'''
    Finding any index in the puzzle is done in here for using both vertical and horizontal data of any index
'''


def find_index(puzzle, value):
    for i in range(len(puzzle)):
        for j in range(len(puzzle[i])):
            if puzzle[i][j] == value:
                return i, j
    return None



'''
 Finding the possible moves in the puzzle by using this function. I will use this on State class during 
 the state operations are continued
'''


def find_possible_moves(puzzle):
    # Location of empty slot
    (i, j) = find_index(puzzle, 'X')

    # Possible moves
    moves = []

    # Up movement
    if i > 1 or (i == 1 and j == 0):
        moves.append('up')

    # Down movement
    if i < len(puzzle) - 1:
        moves.append('down')

    # Right movement
    if i > 0 and j < len(puzzle[i]) - 1:
        moves.append('right')

    # Left movement
    if i > 0 and j > 0:
        moves.append('left')

    return moves


'''
    Randomly move the empty tile to an available spot
'''


def move_random(puzzle):
    # Possible moves
    moves = find_possible_moves(puzzle)

    # Choice index
    choice = moves[random.randint(0, len(moves) - 1)]

    # Moving the tile according to random choice
    return move(puzzle, choice)


'''
    Moving operations are done in here for each 4 cases. First, the index is found and using the index, we can
    make the movement operations
'''


def move(puzzle, dir):
    # Location of Empty slot
    (x_i, x_j) = find_index(puzzle, 'X')

    puzzle_cp = copy.deepcopy(puzzle)

    # Apply move cases
    if dir == 'up':
        puzzle_cp[x_i - 1][x_j], puzzle_cp[x_i][x_j] = puzzle_cp[x_i][x_j], puzzle_cp[x_i - 1][x_j]
    elif dir == 'down':
        puzzle_cp[x_i + 1][x_j], puzzle_cp[x_i][x_j] = puzzle_cp[x_i][x_j], puzzle_cp[x_i + 1][x_j]
    elif dir == 'right':
        puzzle_cp[x_i][x_j + 1], puzzle_cp[x_i][x_j] = puzzle_cp[x_i][x_j], puzzle_cp[x_i][x_j + 1]
    elif dir == 'left':
        puzzle_cp[x_i][x_j - 1], puzzle_cp[x_i][x_j] = puzzle_cp[x_i][x_j], puzzle_cp[x_i][x_j - 1]

    return puzzle_cp
