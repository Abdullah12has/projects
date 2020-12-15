import numpy as np
'''def dfs(graph,vertex,path):
    path.append(vertex)
    for i in graph:
        for j in path:
            if i==j:
                
            else:
                path=dfs(graph,i,path)
    return path'''

count=int(input("Enter the number of vertices: "))
vert=input("Enter the vertex list for graph:\n")
arr=list(vert)
print("Enter the adjacency matrix:")
adjMat=np.empty((count,count))
for i in range(count):
    row=input()
    row=row.split(' ')
    adjMat[i].extend(row)
        
print(adjMat)
        
