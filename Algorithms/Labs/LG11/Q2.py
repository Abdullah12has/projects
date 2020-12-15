import pandas as pd
def dijkstra(graph,src,dest):
    distances={}
    predecessors={}
    Q={}

    if src not in graph:
        raise TypeError('The root of the shortest path tree cannot be found')
    if dest not in graph:
        raise TypeError('The target of the shortest path tree cannot be found')
    for v in graph:
        distances[v]=float('inf')
        predecessors[v]=None
        Q[v]=float('inf')
    distances[src]=0
    Q[src]=0

    while Q:
        u=min(Q,key=Q.get)
        del Q[u]
        for neighbor in graph[u]:
            if neighbor in Q:
                new_distance=distances[u]+graph[u][neighbor]
                if new_distance<distances.get(neighbor):
                    distances[neighbor]=new_distance
                    Q[neighbor]=new_distance
                    predecessors[neighbor]=u
    return (distances,predecessors)

graph={}
vertex=[]

n=int(input("Enter the number of vertices: "))
print("Enter the vertex list for the matrix:")
for j in input():
    vertex.append(j)
DF=pd.read_excel("matrix.xlsx")
for i in range(n):
    key1=vertex[i]
    dict2={}
    for j in range(n):
        key2=vertex[j]
        if DF.iloc[i][j]!=0:
            dict2[key2]=DF.iloc[i][j]
    graph[key1]=dict2
print('Graph', graph)

src=input("Enter the source: ")
dest=input("Enter the destination point: ")
dist,prev=dijkstra(graph,src,dest)

path=[]
pred=dest
while pred!=None:
    path.append(pred)
    pred=prev.get(pred,None)
print('Shortest path: '+str(path)+" cost="+str(dist[dest]))

n=5
vertex=['0','1','2','3','4']

graph={'0':{'1':3,'3':7,'4':8},
       '1':{'3':4,'2':1},
       '2':{'3':2},
       '3':{'4':3},
       '4':{}}
src='0'
dest='2'
dist,prev=dijkstra(graph,src,dest)

path=[]
pred=dest
while pred!=None:
    path.append(pred)
    pred=prev.get(pred,None)
print('Shortest path for graph 2: '+str(path)+" cost="+str(dist[dest]))
