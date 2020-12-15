
import math
#
# Part of the romania roadmapp
#
location = {"arad": (1.75, 10.75), "zerind": (2.5, 12.5), "sibiu": (6.75, 9.25),
            "timisoara": (1.75, 7), "oradea": (3.3, 14), "lugoj": (4.8, 5.8),
            "mehadia": (5, 4), "drobeta": (4.8, 2.5), "craiova": (8.75, 1.75),
            "rimnicu": (8, 7), "fagaras": (10.5, 9), "pitesti": (11.75, 5.25),
            "bucharest": (15, 3.5), "giurgiu": (14, 1)}

map = [("arad", "zerind", 75),
       ("arad", "sibiu", 140),
       ("arad", "timisoara", 118),
       ("zerind", "oradea", 71),
       ("oradea", "sibiu", 151),
       ("timisoara", "lugoj", 111),
       ("lugoj", "mehadia", 70),
       ("mehadia", "drobeta", 75),
       ("drobeta", "craiova", 120),
       ("craiova", "rimnicu", 146),
       ("rimnicu", "sibiu", 80),
       ("craiova", "pitesti", 138),
       ("rimnicu", "pitesti", 97),
       ("sibiu", "fagaras", 99),
       ("pitesti", "bucharest", 101),
       ("fagaras", "bucharest", 211),
       ("giurgiu", "bucharest", 90)]


roadmap = map


def sld(node_point, goal):
    # dist = Straight Line Distance [ (x2-x1)^2 + (y2-y1)^2)^1/2
    dist = math.sqrt((goal[0]-node_point[0])**2 + (goal[1]-node_point[1])**2)
    return dist


def man(node_point, goal):
    dist = (goal[0]-node_point[0]) + (goal[1]-node_point[1])
    return dist


def sumof(node_point, goal):
    dist = man(node_point, goal) + sld(node_point, goal)
    return dist


def avgof(node_point, goal):
    dist = (man(node_point, goal) + sld(node_point, goal)) / \
        2  # it will be the average of first 2
    return dist


# This class represent a graph
class Graph:
    # Initialize the class
    def __init__(self, graph_dict=None, directed=True):
        self.graph_dict = graph_dict or {}
        self.directed = directed
        if not directed:
            self.make_undirected()
    # Create an undirected graph by adding symmetric edges

    def make_undirected(self):
        for a in list(self.graph_dict.keys()):
            for (b, dist) in self.graph_dict[a].items():
                self.graph_dict.setdefault(b, {})[a] = dist

    # Add a link from A and B of given distance, and also add the inverse link if the graph is undirected
    def connect(self, A, B, distance=1):
        self.graph_dict.setdefault(A, {})[B] = distance
        if not self.directed:
            self.graph_dict.setdefault(B, {})[A] = distance

    # Get neighbors or a neighbor
    def get(self, a, b=None):
        links = self.graph_dict.setdefault(a, {})
        if b is None:
            return links
        else:
            return links.get(b)
    # Return a list of nodes in the graph

    def nodes(self):
        s1 = set([k for k in self.graph_dict.keys()])
        s2 = set([k2 for v in self.graph_dict.values()
                  for k2, v2 in v.items()])
        nodes = s1.union(s2)
        return list(nodes)

# This class represent a node


class Node:

    # Initialize the class
    def __init__(self, name: str, parent: str):
        self.name = name
        self.parent = parent
        self.g = 0  # Distance to start node
        self.h = 0  # Distance to goal node
        self.f = 0  # Total cost

    # Compare nodes
    def __eq__(self, other):
        return self.name == other.name

    # Sort nodes
    def __lt__(self, other):
        return self.f < other.f

    # Print node
    def __repr__(self):
        return ('({0},{1})'.format(self.name, self.f))
# A* search


def astar_search(graph, heuristics, start, end):

    # Create lists for open nodes and closed nodes
    open = []
    closed = []

    # Create a start node and an goal node
    start_node = Node(start, None)
    goal_node = Node(end, None)
    # Add the start node
    open.append(start_node)

    # Loop until the open list is empty
    while len(open) > 0:
        # Sort the open list to get the node with the lowest cost first
        open.sort()
        # Get the node with the lowest cost
        current_node = open.pop(0)
        # Add the current node to the closed list
        closed.append(current_node)

        # Check if we have reached the goal, return the path
        if current_node == goal_node:
            path = []
            while current_node != start_node:
                path.append(current_node.name + ': ' + str(current_node.g))
                current_node = current_node.parent
            path.append(start_node.name + ': ' + str(start_node.g))
            # Return reversed path
            return path[::-1]
        # Get neighbours
        neighbors = graph.get(current_node.name)
        # Loop neighbors
        for key, value in neighbors.items():
            # Create a neighbor node
            neighbor = Node(key, current_node)
            # Check if the neighbor is in the closed list
            if(neighbor in closed):
                continue
            # Calculate full path cost
            neighbor.g = current_node.g + \
                graph.get(current_node.name, neighbor.name)
            neighbor.h = heuristics.get(neighbor.name)
            neighbor.f = neighbor.g + neighbor.h
            # Check if neighbor is in open list and if it has a lower f value
            if(add_to_open(open, neighbor) == True):
                # Everything is green, add neighbor to open list
                open.append(neighbor)
    # Return None, no path is found
    return None
# Check if a neighbor should be added to open list


def add_to_open(open, neighbor):
    for node in open:
        if (neighbor == node and neighbor.f > node.f):
            return False
    return True
# The main entry point for this module


def main():
    # Create a graph
    graph = Graph()
    # Create graph connections (Actual distance)
    graph.connect("arad", "zerind", 75)
    graph.connect("arad", "sibiu", 140)
    graph.connect("arad", "timisoara", 118)
    graph.connect("zerind", "oradea", 71)
    graph.connect("oradea", "sibiu", 151)
    graph.connect("timisoara", "lugoj", 111)
    graph.connect("lugoj", "mehadia", 70)
    graph.connect("mehadia", "drobeta", 75)
    graph.connect("drobeta", "craiova", 120)
    graph.connect("craiova", "rimnicu", 146)
    graph.connect("rimnicu", "sibiu", 80)
    graph.connect("craiova", "pitesti", 138)
    graph.connect("rimnicu", "pitesti", 97)
    graph.connect("sibiu", "fagaras", 99)
    graph.connect("pitesti", "bucharest", 101)
    graph.connect("fagaras", "bucharest", 211)
    graph.connect("giurgiu", "bucharest", 90)
# Make graph undirected, create symmetric connections
    graph.make_undirected()

# Create heuristics using the functions from starting city to goal city 
    heuristics = {}


#calculate H1
    goal = location['bucharest']
    for city in location:
        heuristics[city] = int(sld(location[city], goal))
# print("H1\n")
# print(heuristics)

#calculate H2
    goal = location['bucharest']
    for city in location:
        heuristics[city] = int(man(location[city], goal))  #the data becomes easy to understand if we round them using INT
# print("H2\n")
# print(heuristics)

#calculate H3
    goal = location['bucharest']
    for city in location:
        heuristics[city] = int(sumof(location[city], goal))
# print("H3\n")
# print(heuristics)

#calculate H4
    goal = location['bucharest']
    for city in location:
        heuristics[city] = int(avgof(location[city], goal))






# Run the search algorithm
    path = astar_search(graph, heuristics, 'arad', 'bucharest') # the one in the Instructor's example 
    print("The Shortest path using A* is: ")
    print(path)
# Tell python to run main method
if __name__ == "__main__":
    main()


