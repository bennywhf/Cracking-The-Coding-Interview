import math
class polyexp:
    def __init__(self):
        self.container = {}


    def add_term(self,coeff,expo):
        self.container[expo] = coeff





class term:
    def __init__(self,coeff,expo):
        self.coeff = coeff
        self.expo = expo

    def __call__(self,x):
        return x**self.expo * self.coeff


class polynom:
    def __init__(self):
        self.terms = []
        self.terms_dict = {}

    def addTerm(self,T):
        self.terms.append(T)
        self.terms_dict[T.expo] = T.coeff

    def __call__(self,x):
        r = 0
        for i in self.terms:
            r += i(x)
        return r

    def __add__(self,other):
        r = polynom()
        for i in other.terms:
            t = term(self.terms_dict[i.expo]+i.coeff,i.expo)
            r.addTerm(t)
        return r
    


bin2hex = {'0000':'0',
           '0001':'1',
           '0010':'2',
           '0011':'3',
           '0100':'4',
           '0101':'5',
           '0110':'6',
           '0111':'7',
           '1000':'8',
           '1001':'9',
           '1010':'A',
           '1011':'B',
           '1100':'C',
           '1101':'D',
           '1110':'E',
           '1111':'F'}


def binEQhex(_bin,_hex):
    h = _hex
    b = _bin
    while(len(b) >= 4 and len(h) >= 1):
        if not(bin2hex[b[-4:]] == h[-1]):
            return False
        b = b[:-4]
        h = h[:-1]

    #to be finished!



def getWords(string):
    return string.split(' ')

def AllUnique(string):
    d = {}
    for word in getWords(string):
        try:
            d[word]
            return False
        except Exception:
            #if an error occurs, then first time seeing word
            d[word] = True
    return True



def compress(string):
    rstring = ''

    if(string == ''):
        return string

    current_char = string[0]
    count = 1

    for char in string[1:]: #for each character in string
        if not(char == current_char):
            rstring+=current_char
            rstring+=str(count)

            current_char = char
            count=1
        else:
            count+=1

    rstring+=current_char
    rstring+=str(count)

    
    if len(rstring) < len(string):
        return rstring
    return string

def ABS(x):
    #distance from 0
    return math.sqrt(x**2) + 0**math.sqrt(x**2) #if the distance is 0, then return 1 instead.



def Max(A,B):
    
    z = (B - A)/ABS(B - A) #distance between

    #if B is larger, then z = -1
    #else z = 1


    return B*(z+1)/2 + A*(-z+1)/2








class HT(object):
    def __init__(self,size):
        self.pegA = []
        for i in range(size,0,-1):
            self.pegA.append(i)
        self.pegB = []
        self.pegC = []

    def __str__(self):
        return str(self.pegA) + ' ' + str(self.pegB) + ' ' +str(self.pegC)


    def get(self,i):
        if i == 0:
            return self.pegA
        if i == 1:
            return self.pegB
        if i == 2:
            return self.pegC
    
    def move(self,pegs,pegd):
        try:
            self.get(pegd).append(self.get(pegs).pop())
        except IndexError as e:
            pass

    def height(self,peg):
        return len(self.get(peg))


def solve(size):
    h = HT(size)
    print(h)
    def moveStack(n,source,destination,mid):
        print(h)
        if(n == 0):
            h.move(source,destination)
        else:
            moveStack(n-1,source,mid,destination)
            h.move(source,destination)
            moveStack(n-1,mid,destination,source)
    moveStack(size,0,2,1)
    print(h)



class Stack(object):
    def __init__(self):
        self.cont = []

    def push(self,item):
        self.cont.append(item)

    def pop(self):
        if self.cont:
            return self.cont.pop()

    def peek(self):
        if self.cont:
            return self.cont[-1]

    def __bool__(self):
        if(self.cont):
            return True
        else:
            return False

    def isEmpty(self):
        if self.cont:
            return False
        return True

class MyQueue(object):
    def __init__(self):
        self.older = Stack()
        self.newer = Stack()


    def enqueue(self,item):
        self.newer.push(item)

    def dequeue(self):
        if(self.older):
            return self.older.pop()
        while(self.newer):
            self.older.push(self.newer.pop())
        if(self.older):
            return self.older.pop()

    def peek(self):
        if(self.older):
            return self.older.peek()
        while(self.newer):
            self.older.push(self.newer.pop())
        if(self.older):
            return self.older.peek()




def sort_stack(stack):
    sortedstack = Stack()

    if stack:
        sortedstack.push(stack.pop())


    while(stack):
        temp = stack.pop()

        while(temp > sortedstack.peek()):
            stack.push(sortedstack.pop())
            if sortedstack.isEmpty():
                break
        sortedstack.push(temp)

    while(sortedstack):
        stack.push(sortedstack.pop())



class UndirectedVertex(object):
    def __init__(self,label,*neighbors):
        self.label = label
        self.neighbors = []
        for i in neighbors:
            self.neighbors.append(i)
            i.addNeighbor(self)

    def addNeighbor(self,neighbor):
        if(neighbor not in self.neighbors):
            self.neighbors.append(neighbor)
            neighbor.add(self)

    def getNeighbors(self):
        return self.neighbors

class DirectedVertex(object):
    def __init__(self,label,*neighbors):
        self.label = label
        self.neighbors = []
        for i in neighbors:
            self.neighbors.append(i)

    def addNeighbor(self,neighbor):
        if(neighbor not in self.neighbors):
            self.neighbors.append(neighbor)

    def getNeighbors(self):
        return self.neighbors
    

class Dgraph(object):
    def __init__(self):
        self.vertices_dict = {}

    def addToGraph(self,label,*neighbors):
        v = DirectedVertex(label)
        self.vertices_dict[label] = v
        for i in neighbors:
            v.addNeighbor(self.vertices_dict[i])

    def getVertices(self):
        return self.vertices_dict.keys()

    def setNeighbor(self,vertexa,vertexb):
        self.vertices_dict[vertexa].addNeighbor(self.vertices_dict[vertexb])
