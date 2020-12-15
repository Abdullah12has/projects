
class Item:
    """
    The object represents a node and caries its ako and is-a relationship information
    """
    def __init__(self, name, super_classes):
        self.name = name
        self.super_classes = super_classes

    def fish_hook_pairs(self):
        to_return = []
        if len(self.super_classes) > 0:
            to_return.append([self, self.super_classes[0]])
            for i in range(len(self.super_classes) - 1):
                to_return.append([self.super_classes[i], self.super_classes[i+1]])
        return to_return

    def get_list(self):
        to_return = []
        queue = [self]
        while len(queue) != 0:
            to_return.append(queue[0])
            for x in queue[0].super_classes:
                queue.append(x)
            queue.pop(0)
        to_return.extend(queue)
        return to_return






# Objects of example 1

ios_base = Item("ios_base", [])
ios = Item("ios", [ios_base])
istream = Item("istream", [ios])
ostream = Item("ostream", [ios])
istream_withassign = Item("istream_withassign", [istream])
iostream = Item("iostream", [istream, ostream])
ostream_withassign = Item("ostream_withassign", [ostream])
iostream_withassign = Item("iostream_withassign", [iostream])

ls = istream_withassign.get_list()
pair_list = []
class_list = []
for a in ls:
    pair_list.extend(a.fish_hook_pairs())

pair_right = []
pair_left = []
flag = False

for a in pair_list:
    pair_left.append(a[0])
    pair_right.append(a[1])

while len(pair_left) != 0:
    for l in pair_left:
        flag = False
        for r in pair_right:
            if l.name == r.name:
                flag = True
        if not flag:
            if l not in class_list:
                class_list.append(l)
            index = pair_left.index(l)
            pair_left.pop(index)
            pair_right.pop(index)
            pair_list.pop(index)
class_list.append(ios_base)
print("\nClass precedence list for istream_withassign:")
for x in class_list:
    print(x.name)

ls = iostream_withassign.get_list()
pair_list = []
class_list = []
for a in ls:
    pair_list.extend(a.fish_hook_pairs())

pair_right = []
pair_left = []
flag = False

for a in pair_list:
    pair_left.append(a[0])
    pair_right.append(a[1])

while len(pair_left) != 0:
    for l in pair_left:
        flag = False
        for r in pair_right:
            if l.name == r.name:
                flag = True
        if not flag:
            if l not in class_list:
                class_list.append(l)
            index = pair_left.index(l)
            pair_left.pop(index)
            pair_right.pop(index)
            pair_list.pop(index)
class_list.append(ios_base)
print("\nClass precedence list for iostream_withassign:")
for x in class_list:
    print(x.name)

ls = ostream_withassign.get_list()
pair_list = []
class_list = []
for a in ls:
    pair_list.extend(a.fish_hook_pairs())

pair_right = []
pair_left = []
flag = False

for a in pair_list:
    pair_left.append(a[0])
    pair_right.append(a[1])

while len(pair_left) != 0:
    for l in pair_left:
        flag = False
        for r in pair_right:
            if l.name == r.name:
                flag = True
        if not flag:
            if l not in class_list:
                class_list.append(l)
            index = pair_left.index(l)
            pair_left.pop(index)
            pair_right.pop(index)
            pair_list.pop(index)
class_list.append(ios_base)
print("\nClass precedence list for ostream_withassign:")
for x in class_list:
    print(x.name)





# Objects of example 2

Graph = Item("Graph", [])
GraphWrapper= Item("GraphWrapper", [Graph])
Astar = Item("Astar", [GraphWrapper])
GraphLBwrapper = Item("GraphLBwrapper", [GraphWrapper])
BaseSequenceSpaceGraphLBwrapper = Item("BaseSequenceSpaceGraphLBwrapper", [GraphLBwrapper])
RotamerToSequenceGraphLBwrapper = Item("RotamerToSequenceGraphLBwrapper", [BaseSequenceSpaceGraphLBwrapper])
SequenceSpaceGraphLBwrapper = Item("SequenceSpaceGraphLBwrapper", [BaseSequenceSpaceGraphLBwrapper])

ls = Astar.get_list()
pair_list = []
class_list = []
for a in ls:
    pair_list.extend(a.fish_hook_pairs())

pair_right = []
pair_left = []
flag = False

for a in pair_list:
    pair_left.append(a[0])
    pair_right.append(a[1])

while len(pair_left) != 0:
    for l in pair_left:
        flag = False
        for r in pair_right:
            if l.name == r.name:
                flag = True
        if not flag:
            if l not in class_list:
                class_list.append(l)
            index = pair_left.index(l)
            pair_left.pop(index)
            pair_right.pop(index)
            pair_list.pop(index)
class_list.append(Graph)
print("\nClass precedence list for Astar:")
for x in class_list:
    print(x.name)
    
    
ls = RotamerToSequenceGraphLBwrapper.get_list()
pair_list = []
class_list = []
for a in ls:
    pair_list.extend(a.fish_hook_pairs())

pair_right = []
pair_left = []
flag = False

for a in pair_list:
    pair_left.append(a[0])
    pair_right.append(a[1])

while len(pair_left) != 0:
    for l in pair_left:
        flag = False
        for r in pair_right:
            if l.name == r.name:
                flag = True
        if not flag:
            if l not in class_list:
                class_list.append(l)
            index = pair_left.index(l)
            pair_left.pop(index)
            pair_right.pop(index)
            pair_list.pop(index)
class_list.append(Graph)
print("\nClass precedence list for RotamerToSequenceGraphLBwrapper:")
for x in class_list:
    print(x.name)


ls = SequenceSpaceGraphLBwrapper.get_list()
pair_list = []
class_list = []
for a in ls:
    pair_list.extend(a.fish_hook_pairs())

pair_right = []
pair_left = []
flag = False

for a in pair_list:
    pair_left.append(a[0])
    pair_right.append(a[1])

while len(pair_left) != 0:
    for l in pair_left:
        flag = False
        for r in pair_right:
            if l.name == r.name:
                flag = True
        if not flag:
            if l not in class_list:
                class_list.append(l)
            index = pair_left.index(l)
            pair_left.pop(index)
            pair_right.pop(index)
            pair_list.pop(index)
class_list.append(Graph)
print("\nClass precedence list for SequenceSpaceGraphLBwrapper:")
for x in class_list:
    print(x.name)




# Objects of example 3


puddleMetaObject = Item("puddle::MetaObject", [])
puddleMetaNamedObject = Item("puddle::MetaNamedObject", [puddleMetaObject])
puddleMetaScopedObject = Item("puddle::MetaScopedObject", [puddleMetaObject])
puddleMetaNamedScopedObject = Item("puddle::MetaNamedScopedObject", [puddleMetaScopedObject,puddleMetaNamedObject])
puddleMetaType = Item("puddle::MetaType", [puddleMetaNamedScopedObject])
puddleMetaScope = Item("puddle::MetaScope", [puddleMetaNamedScopedObject])
puddleMetaTemplatedType = Item("puddle::MetaTemplatedType", [puddleMetaType])
puddleMetaClass = Item("puddle::MetaClass", [puddleMetaScope, puddleMetaType])
puddleMetaTemplatedClass = Item("puddle::MetaTemplatedClass", [puddleMetaTemplatedType,puddleMetaClass])


ls = puddleMetaTemplatedClass.get_list()
pair_list = []
class_list = []
for a in ls:
    pair_list.extend(a.fish_hook_pairs())

pair_right = []
pair_left = []
flag = False

for a in pair_list:
    pair_left.append(a[0])
    pair_right.append(a[1])

while len(pair_left) != 0:
    for l in pair_left:
        flag = False
        for r in pair_right:
            if l.name == r.name:
                flag = True
        if not flag:
            if l not in class_list:
                class_list.append(l)
            index = pair_left.index(l)
            pair_left.pop(index)
            pair_right.pop(index)
            pair_list.pop(index)
class_list.append(puddleMetaObject)
print("\nClass precedence list for puddle::MetaTemplatedClass:")
for x in class_list:
    print(x.name)






