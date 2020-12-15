from state import print_solution_path
from Astar_search import A_star_search
from puzzle import generate
from write_to_file import write_to_txt

'''
    Generating N distinct puzzles
'''


def generate_n_puzzles(n):
    distinct_puzzles = []

    while len(distinct_puzzles) != n:
        puzzle = generate()

        if puzzle not in distinct_puzzles:
            distinct_puzzles.append(puzzle)

    return distinct_puzzles


# Generating 30 Distinct Puzzles
puzzles = generate_n_puzzles(30)

index = 1
path = None

# X and Y values for the puzzle solved with A* search

i = 0;
paths = []
for puzzle in puzzles:
    path, num_moves_w2 = A_star_search(puzzle)
    if index == 1 or index == 17:
        paths.append(path)
    index += 1

# Write puzzles (initial states) to txt
write_to_txt(puzzles)

# Print the trace for the two puzzle
print("\n\n----Trace for state no. 1:----\n\n")
print_solution_path(paths[0])
print("\n\n----Trace for state no. 17:----\n\n")
print_solution_path(paths[1])
