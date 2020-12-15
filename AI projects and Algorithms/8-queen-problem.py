import queue as queue
import random as random
import copy 
N = 8
queen_positions = '31046715'
board = [[0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0]]



def queens_matrix(queen_positions):
    for i in range(8):
        for j in range(8):
            if (int(queen_positions[i]) == j):
                board[i][j] = 1
            else:
                board[i][j] = 0
        
    return board

def print_board(board):
    output = ""
    for i in range(8):
        for j in range(8):
            if (board[i][j] == 1):
                output += "  Q  "
            else:
                output += " [ ] "
        output += "\n\n"
    
    print(output)

# Function to determine if there is an attacking queen in the view of the given queen.
# Check for each queen
def find_attacking_queen(board, row, col):
    total_attacking_queens = 0

    # Check row on left side 
    for i in range(col): 
        if board[row][i] == 1: 
            total_attacking_queens += 1
    
    # Check upper diagonal on left side 
    for i, j in zip(range(row, -1, -1), range(col, -1, -1)): 
        if board[i][j] == 1: 
            total_attacking_queens += 1
    
    for i, j in zip(range(row, N, 1), range(col, -1, -1)): 
        if board[i][j] == 1: 
            total_attacking_queens += 1
    
    return total_attacking_queens -1


def all_attacking_queens(board_new):
    total = 0
    for row in range(8):
        for col in range(8):
            if (board_new[row][col] == 1):
                q_total = find_attacking_queen(board_new, row, col)
                total += q_total
                # print(q_total)
    return total

def create_board_dict(board_new):
    board_state = dict()
    board_state["board"] = board_new
    board_state["heu"] = all_attacking_queens(board_new)
    board_state["visited"] = False
    # print(board_state)
    return board_state


def create_new_board(board):
    col = random.randint(0,7)
    # print(col)
    move = random.randint(0,7)
    # print(move)
    new_board = copy.deepcopy(board)

    for i in range(8):
        new_board[col][i] = 0
    new_board[col][move] = 1
    return new_board

def create_list_of_boards(new_board, k):
    q = list()

    for i in range(k):
        nb = create_new_board(new_board['board'])
        nbd = create_board_dict(nb)
        q.append(nbd)
    q.sort
    return q
    
# there is a problem I couldn't solve here 
def beam_search(start_node, goal, k):
    visited_nodes = [] 

    if(start_node['heu'] == goal):
        return start_node
    else:
        node = start_node
        visited_nodes.append(node)
        node['visited'] = True
        next_nodes = create_list_of_boards(node, k)
        next_node = next_nodes.pop(0)
        while (next_node['visited'] != True ):
            node = next_node
            visited_nodes.append(node)
            node['visited'] = True
            if (node['heu'] == goal):
                return node
            next_nodes = create_list_of_boards(node, k)
            next_node = next_nodes.pop(0)
            print_board(node['board'])
            print(node['heu'])

    return node


def part_c_100_problems(b):
    q = create_list_of_boards(b, 100)

    for i in range(100):
        a = q.pop(0)
        beam_search(a, 0, 1)
        beam_search(a, 0, 10)
        beam_search(a, 0, 50)
        # won't be able to generate the graph because there is a problem in the beam search that needs to be solved first 

        

    


    





board = queens_matrix(queen_positions)

# print_board(board)
# all_attacking_queens(board)
# b = create_new_board(board)
# print_board(board)
# print_board(b)
board = create_board_dict(board)


# data = create_list_of_boards(board, 50)

# d = data.pop(0)

# bb = beam_search(board, 0, 50)

# print_board(bb['board'])


part_c_100_problems(board)