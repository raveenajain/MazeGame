// Assignment 10

/* Jain, Raveena 
 * raveena97
 * Sai, Sreeya
 * ssai123
 */

import java.util.*;
import javalib.impworld.*;
import java.awt.Color;
import javalib.worldimages.*;


// to represent a Vertex
class Vertex { 

    Posn location; // unique way to identify each vertex
    // each "wall" of the cell
    // if boolean flag is false, DO NOT draw that wall 
    boolean top; 
    boolean bottom;
    boolean left; 
    boolean right; 
    // Vertex neighbors
    Vertex friendtop;
    Vertex friendbottom;
    Vertex friendleft;
    Vertex friendright;
    boolean hasTraveled; 
    static final int SIZE = 20; // to represent the size of the cell

    // to override hashcode 
    public int hashCode() {
        return this.location.x + this.location.y * 100;
    }

    // constructor 
    Vertex(Posn location) {
        this.location = location;
        this.top = true;
        this.bottom = true;
        this.left = true;
        this.right = true;
        this.hasTraveled = false; 
    } 

    // convenience constructor for testing 
    Vertex(Posn location, Vertex friendtop, Vertex friendbottom, 
            Vertex friendleft, Vertex friendright) {
        this.location = location; 
        this.friendtop = friendtop;
        this.friendbottom = friendbottom;
        this.friendleft = friendleft;
        this.friendright = friendright;
    } 

    // to override equals
    public boolean equals(Object obj) {
        if (!(obj instanceof Vertex)) {
            return false;
        }
        Vertex v = (Vertex)obj; 
        return this.location.x == v.location.x &&
                this.location.y == v.location.y; 
    }

    // to render a horizontal line 
    WorldImage makeWallHorizontal() {
        return new LineImage(new Posn(SIZE, 0), Color.BLACK);
    }

    // to render a vertical line
    WorldImage makeWallVertical() {
        return new LineImage(new Posn(0, SIZE), Color.BLACK);
    }

    // to render a square with a color depending on the input  
    WorldImage drawSquare(int red, int green, int blue) {
        return new RectangleImage(Vertex.SIZE, Vertex.SIZE, OutlineMode.SOLID, 
                new Color(red, green, blue));
    }
}

// to represent an edge 
class Edge {
    Vertex side1; 
    Vertex side2; 
    int weight; 

    // constructor 
    Edge(Vertex side1, Vertex side2, int weight) {
        this.side1 = side1;
        this.side2 = side2;
        this.weight = weight; 
    }

    // convenience constructor for testing purposes
    Edge(int weight, Vertex side1, Vertex side2) {
        this.weight = weight; 
        this.side1 = side1;
        this.side2 = side2; 
    }
}

// to compare the weights of two edges 
class WeightComparator implements Comparator<Edge> {

    // to compare the weights of two edges  
    public int compare(Edge e1, Edge e2) {
        return e1.weight - e2.weight;
    }
}

// to represent a player 
class Players {
    Vertex vx;
    WorldImage piece;
    int moves;
    ArrayList<Vertex> player1toggle; 
    ArrayList<Vertex> player2toggle;

    Players() {
        player1toggle = new ArrayList<Vertex>();
        player2toggle = new ArrayList<Vertex>();
    }

    // EFFECT: to move Player 1 (webcat) based on the user input 
    void movePlayer1(String input, int height, int width) {
        if (this.vx.location.x >= 0 && input.equals("left") 
                && (!this.vx.left)) {
            this.vx = this.vx.friendleft; 
            player1toggle.add(vx);
            moves = moves + 1; 
        }
        if (this.vx.location.x < (width * Vertex.SIZE) - Vertex.SIZE / 2 
                && input.equals("right") && (!this.vx.right)) {
            this.vx = this.vx.friendright; 
            player1toggle.add(vx);
            moves = moves + 1;
        }
        if (this.vx.location.y >= 0 && input.equals("up")
                && (!this.vx.top)) {
            this.vx = this.vx.friendtop; 
            player1toggle.add(vx);
            moves = moves + 1;
        }
        if (this.vx.location.y < (height * Vertex.SIZE) - Vertex.SIZE 
                && input.equals("down") && (!this.vx.bottom)) {
            this.vx = this.vx.friendbottom; 
            player1toggle.add(vx);
            moves = moves + 1;
        }
    }

    // EFFECT: to move Player 2 (webdog) based on the user input 
    void movePlayer2(String input, int height, int width) {
        if (this.vx.location.x >= 0 && input.equals("a") 
                && (!this.vx.left)) {
            this.vx = this.vx.friendleft; 
            player2toggle.add(vx);
            moves = moves + 1;
        }
        if (this.vx.location.x < (width * Vertex.SIZE) - Vertex.SIZE / 2 
                && input.equals("d") && (!this.vx.right)) {
            this.vx = this.vx.friendright; 
            player2toggle.add(vx);
            moves = moves + 1;
        }
        if (this.vx.location.y >= 0 && input.equals("w")
                && (!this.vx.top)) {
            this.vx = this.vx.friendtop;
            player2toggle.add(vx);
            moves = moves + 1;
        }
        if (this.vx.location.y < (height * Vertex.SIZE) - Vertex.SIZE 
                && input.equals("s") && (!this.vx.bottom)) {
            this.vx = this.vx.friendbottom; 
            player2toggle.add(vx);
            moves = moves + 1;
        }
    }
}

// to represent a Deque 
class Deque<T> {
    Sentinel<T> header; 

    // constructor 
    Deque() {
        this.header = new Sentinel<T>(); 
    }

    // convenience constructor 
    Deque(Sentinel<T> s) {
        this.header = s;
    }

    // counts the number of nodes in a list Deque, not including the header node
    int size() {
        return header.sizeHelp(); 
    }

    // EFFECT: to insert the given value at the front of this list 
    void addAtHead(T t) {
        this.header.atHelper(t, this.header.next, this.header.next, this.header);
    }

    // EFFECT: to insert the given value at the end of this list 
    void addAtTail(T t) {
        this.header.atHelper(t, this.header.prev, this.header, this.header.prev);
    }

    // returns the data of the first node of this list
    // EFFECT: removes the first node
    T removeFromHead() {
        return this.header.removeHelp(this.header.next);
    }   

    // returns the data of the last node of this list
    // EFFECT: removes the last node
    T removeFromTail() {
        return this.header.removeHelp(this.header.prev);
    }

    // does this Deque contain the given element?
    boolean contains(T element) {
        return this.header.next.containsHelp(element);
    }

    // to remove the given node from this Deque<T>
    void removeNode(ANode<T> a) {
        this.header.removeHelp(a); 
    }

    // is this Deque empty?
    boolean isEmpty() {
        return this.header.next.isEmptyHelp();
    }
}

// to represent the abstract class ANode<T> 
abstract class ANode<T> { 
    ANode<T> next;
    ANode<T> prev; 

    // constructor 
    ANode(ANode<T> next, ANode<T> prev) {
        this.next = next;
        this.prev = prev; 
    }

    // to return the size of ANode<T>
    abstract int size();

    // to return the size of the next ANode<T>
    int sizeHelp() {
        return next.size();
    }        

    // EFFECT: to add the given T to an ANode<T>
    void atHelper(T t, ANode<T> x, ANode<T> y, ANode<T> z) {
        x = new Node<T>(t, y, z); 
    }

    // to return this ANode's data
    // EFFECT: to remove this ANode<T>
    abstract T remove(); 

    // does this ANode<T> contain the given element?
    abstract boolean containsHelp(T element); 

    // is this ANode<T> empty?
    abstract boolean isEmptyHelp();
}

// to represent a Sentinel<T>
class Sentinel<T> extends ANode<T> {

    // constructor 
    Sentinel() {
        super(null, null);
        updateSentinel(this, this);
    }

    // EFFECT: to update the fields of this Sentinel<T>
    void updateSentinel(ANode<T> n, ANode<T> p) {
        this.next = n;
        this.prev = p;
    }

    // to return the size of this Sentinel<T>
    int size() {
        return 0;
    }

    // returns the data of the ANode
    // EFFECT: to remove the given ANode<T>
    T removeHelp(ANode<T> x) {
        return x.remove(); 
    }

    // throws an exception because a Sentinel<T> does not have data to return
    T remove() {
        throw new RuntimeException("CANNOT REMOVE FROM A SENTINEL");
    }

    // does this Sentinel contain the given data?
    boolean containsHelp(T element) { 
        return false; 
    }

    // is this Sentinel<T> empty?
    boolean isEmptyHelp() {
        return true;
    }
}

// to represent a Node<T>
class Node<T> extends ANode<T> {
    T data; 

    // constructor 
    Node(T data) {
        super(null, null); 
        this.data = data; 
    }

    // convenience constructor 
    Node(T d, ANode<T> n, ANode<T> p) { 
        super(n, p); 
        updateNodes(n, p);
        this.data = d;
    }

    // EFFECT: to update the fields of this node 
    // throws an exception if either ANode<T> is null
    void updateNodes(ANode<T> n, ANode<T> p) {
        if ((n == null) || (p == null)) { 
            throw new IllegalArgumentException("VALUE NULL"); 
        } 
        else 
        {
            this.next = n;
            n.prev = this;
            this.prev = p; 
            p.next = this;
        } 
    }

    // to return the size of a list of Nodes<T>
    int size() {
        return 1 + this.next.size();
    }

    // to return the removed Nodes<T> data
    // EFFECT: to fix the links/remove this Node<T> 
    T remove() {
        this.next.prev = this.prev;
        this.prev.next = this.next;
        return this.data; 
    }

    // is this Node<T>'s data the same as the given element?
    boolean containsHelp(T element) {
        if (this.data.equals(element)) {
            return true;
        }
        else {
            return this.next.containsHelp(element); 
        }
    }

    // is this Node<T> empty?
    boolean isEmptyHelp() {
        return false;
    }
}

// to represent a mutable collection of items
interface ICollection<T> {

    // is this collection empty?
    boolean isEmpty();

    // EFFECT: adds the given item to the collection
    void add(T item);

    // to return the first item of the collection
    // EFFECT: removes that first item
    T remove();

    // is the given element in this?
    boolean contains(T element); 
}

// to represent a Stack<T>
class Stack<T> implements ICollection<T> {
    Deque<T> contents;

    // constructor 
    Stack() {
        this.contents = new Deque<T>();
    }

    // convenience constructor for testing 
    Stack(Deque<T> contents) {
        this.contents = contents; 
    }

    // is this Stack<T> empty?
    public boolean isEmpty() {
        return this.contents.isEmpty();
    }

    // to return the data of the removed Stack<T>
    // EFFECT: removes the first element of the stack<T>
    public T remove() {
        return this.contents.removeFromHead();
    }

    // EFFECT: to add the given item to the front of the Stack<T>
    public void add(T item) {
        this.contents.addAtHead(item);
    }

    // is the given element in this Stack<T>?
    public boolean contains(T element) {
        return this.contents.contains(element);
    }
}

// to represent a Queue<T>
class Queue<T> implements ICollection<T> {
    Deque<T> contents;

    // constructor 
    Queue() {
        this.contents = new Deque<T>();
    }

    // convenience constructor for testing 
    Queue(Deque<T> contents) {
        this.contents = contents; 
    }

    // is this Queue<T> empty?
    public boolean isEmpty() {
        return this.contents.isEmpty();
    }

    // to return the data of the removed Queue<T>
    // EFFECT: removes the last element of the Queue<T>
    public T remove() {
        return this.contents.removeFromHead();
    }

    // EFFECT: to add the given item to the end of the Queue
    public void add(T item) {
        this.contents.addAtTail(item); 
    }

    // is the given element in this Queue<T>?
    public boolean contains(T element) {
        return this.contents.contains(element);
    }
}

// to represent the MazeGame 
class MazeGame extends World {
    int height;
    int width;
    ArrayList<ArrayList<Vertex>> verticesInTree; // all vertices 
    ArrayList<Edge> edgesInTree; // spanning tree
    ArrayList<Edge> worklist; // sorted edges 
    Random rand = new Random(); 
    HashMap<Posn, Posn> representatives;
    HashMap<Vertex, Edge> cameFromEdge;
    Stack<Vertex> dfsWorklist; // for the implementation of Depth First Search
    Queue<Vertex> bfsWorklist; // for the implementation of Breath First Search
    Players p1; // player 1 
    Players p2; // player 2
    boolean breathcondition; // true when key pressed to start this search algorithm
    boolean depthcondition; // true when key pressed to start this search algorithm
    ArrayList<Vertex> alreadySeen; 
    Boolean endSearch; // true when search is finished. path will be constructed
    // to initialize the visibility of the path the players have taken
    Boolean togglevisibility1;
    Boolean togglevisibility2;
    int counter; // for testing onTick

    // constructor  
    MazeGame(int height, int width) {
        this.height = height; 
        this.width = width; 
        this.verticesInTree = new ArrayList<ArrayList<Vertex>>(); 
        this.createVertices(); // to create vertices and add them to verticesInTree
        this.worklist = new ArrayList<Edge>();
        this.createEdges(1, 1); // to create all of the edges in the board
        this.edgesInTree = new ArrayList<Edge>();
        this.representatives = new HashMap<Posn, Posn>();
        this.sortEdges();
        this.mapVertices();
        this.createSpanning();
        this.updateWall();
        this.cameFromEdge = new HashMap<Vertex, Edge>(); 
        this.dfsWorklist = new Stack<Vertex>();
        this.bfsWorklist = new Queue<Vertex>();
        // to initialize the worklists for breadth and depth first search to
        // contain the first node to start the search algorithm
        this.dfsWorklist.add(verticesInTree.get(0).get(0));
        this.bfsWorklist.add(verticesInTree.get(0).get(0));
        this.alreadySeen = new ArrayList<Vertex>();
        this.counter = 0; 

        // GAMEPLAY
        this.p1 = new Players(); // WEBCAT
        this.p2 = new Players(); // WEBDOG
        // to initialize the image of each player
        this.p1.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 20, 100));
        this.p2.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 181, 100));
        // to initialize the starting positions of the players
        this.p1.vx = verticesInTree.get(0).get(0);
        this.p2.vx = verticesInTree.get(0).get(0);
        breathcondition = false;
        depthcondition = false; 
        this.endSearch = false; 
        this.togglevisibility1 = false;
        this.togglevisibility2 = false;
    }

    // convenience constructor for testing 
    MazeGame(int height, int width, ArrayList<ArrayList<Vertex>> verticesInTree) {
        this.height = height;
        this.width = width;
        this.verticesInTree = verticesInTree;
        this.worklist = new ArrayList<Edge>();
        this.createEdges(1, 1);
        this.edgesInTree = new ArrayList<Edge>();
        this.representatives = new HashMap<Posn, Posn>();
        this.sortEdges();
        this.mapVertices();
        this.updateWall();
        this.cameFromEdge = new HashMap<Vertex, Edge>(); 
        this.dfsWorklist = new Stack<Vertex>();
        this.bfsWorklist = new Queue<Vertex>();
        this.dfsWorklist.add(verticesInTree.get(0).get(0));
        this.bfsWorklist.add(verticesInTree.get(0).get(0));
        this.alreadySeen = new ArrayList<Vertex>(); 
        this.counter = 0; 
        // GAMEPLAY
        this.p1 = new Players();
        this.p2 = new Players();
        this.p1.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 20, 100));
        this.p2.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 181, 100));
        this.p1.vx = verticesInTree.get(0).get(0); 
        this.p2.vx = verticesInTree.get(0).get(0);
        breathcondition = false;
        depthcondition = false; 
    }

    // EFFECT: to fix each vertices' links with its neighbors' 
    void fixFriends(ArrayList<ArrayList<Vertex>> aav) {
        for (int i = 0; i < width; i = i + 1) {
            for (int j = 0; j < height; j = j + 1) { 
                Vertex v = aav.get(i).get(j); 
                if (i == 0) {
                    v.friendleft = v;
                }
                else {
                    v.friendleft = aav.get(i - 1).get(j);
                }
                if (j == 0) {
                    v.friendtop = v;
                }
                else {
                    v.friendtop = aav.get(i).get(j - 1);
                }
                if (j == height - 1) {
                    v.friendbottom = v;
                }
                else {
                    v.friendbottom = aav.get(i).get(j + 1);
                }
                if (i == width - 1) {
                    v.friendright = v;
                }
                else {
                    v.friendright = aav.get(i + 1).get(j);
                }
            }
        }
    }

    // EFFECT: to update the ArrayList<ArrayList<Vertex>> and create vertices
    void createVertices() {
        for (int i = 0; i < width; i = i + 1) { // x coordinates
            ArrayList<Vertex> an = new ArrayList<Vertex>();
            for (int j = 0; j < height; j = j + 1) { // y coordinates
                Vertex n = new Vertex(new Posn(i, j));
                an.add(n); 
            }
            verticesInTree.add(an); 
        }  
        // EFFECT: to initialize fixFriends
        this.fixFriends(verticesInTree);
    }

    // EFFECT: to update and add Edges to our ArrayList with  
    // randomly assigned weights and updated "side" fields
    void createEdges(int hb, int vb) {
        for (int i = 0; i < verticesInTree.size(); i = i + 1) {
            ArrayList<Vertex> an = this.verticesInTree.get(i);
            for (int j = 0; j < an.size(); j = j + 1) {
                Vertex n = an.get(j); 
                Posn p = n.location;  
                if (p.x != width - 1) {
                    Edge e1 = new Edge(n, verticesInTree.get(i + 1).get(j), 
                            rand.nextInt(width * height) * vb) ;
                    worklist.add(e1); 
                }
                if (p.y != height - 1) {
                    Edge e2 = new Edge(n, verticesInTree.get(i).get(j + 1), 
                            rand.nextInt(width * height) * hb) ;
                    worklist.add(e2); 
                }
            }
        }
    }

    // EFFECT: to map each vertices' representative to itself
    void mapVertices() {
        for (int i = 0; i < verticesInTree.size(); i = i + 1) {
            for (int j = 0; j < verticesInTree.get(i).size(); j = j + 1) {
                representatives.put(verticesInTree.get(i).get(j).location, 
                        verticesInTree.get(i).get(j).location);
            }
        }
    }

    // EFFECT: to sort the Edges of edgesInTree by weight 
    void sortEdges() {
        Collections.sort(worklist, new WeightComparator());
    }

    // to return a given posn's representative
    Posn find(HashMap<Posn, Posn> hm, Posn p) {
        if (hm.get(p) == p) {
            return p; 
        }
        else {
            return this.find(hm, hm.get(p));
        }
    }

    // EFFECT: to set the value of one representative's representative to the other
    void union(HashMap<Posn, Posn> hm, Posn p1, Posn p2) {
        hm.put(this.find(hm, p2), this.find(hm, p1)); 
    }

    // to add edges from the worklist to the spanning  
    // tree based on Kruskal's algorithm
    ArrayList<Edge> createSpanning() {
        while (edgesInTree.size() < (height * width) - 1) {
            Edge e = this.worklist.get(0);
            if (this.find(representatives, e.side1.location) ==  
                    this.find(representatives, e.side2.location)) { 
                worklist.remove(0);
            }
            else {               
                this.edgesInTree.add(e);
                this.union(representatives, e.side1.location, e.side2.location);
                worklist.remove(0);
            }
        }        
        return this.edgesInTree;          
    }

    // EFFECT: to update the vertex's field to false if there 
    // is an edge running through the vertex's "wall"
    void updateWall() {
        for (Edge e : edgesInTree) {
            if (e.side2.location.x - e.side1.location.x == 1) {
                e.side1.right = false; 
                e.side2.left = false; 
            }
            else if (e.side1.location.x - e.side2.location.x == 1) {
                e.side2.right = false; 
                e.side1.left = false;                
            }
            else if (e.side2.location.y - e.side1.location.y == 1) {
                e.side1.bottom = false; 
                e.side2.top = false; 
            }
            else if (e.side1.location.y - e.side2.location.y == 1) {
                e.side2.bottom = false; 
                e.side1.top = false; 
            }
        }
    }

    // to find all the Edges who's given vertex is side1 or side2
    ArrayList<Edge> findEdges(ArrayList<Edge> ae, Vertex v) {
        ArrayList<Edge> result = new ArrayList<Edge>(); 
        for (Edge e : ae) {
            if (e.side1.equals(v) || e.side2.equals(v)) {
                result.add(e); 
            }
        }
        return result; 
    }

    // to return the path from the source to the target 
    ArrayList<Vertex> reconstruct(HashMap<Vertex, Edge> hm, Vertex v) {
        ArrayList<Vertex> av = new ArrayList<Vertex>();    
        while (!verticesInTree.get(0).get(0).equals(hm.get(v).side1)) {
            av.add(v); 
            if (hm.get(v).side2.equals(v)) {
                v = hm.get(v).side1;
            }
            else {
                v = hm.get(v).side2;
            }
        }
        av.add(hm.get(v).side2);
        av.add(hm.get(v).side1);
        return av; 
    }

    // to search using Breath First Search
    ArrayList<Vertex> bfs(Vertex to) {
        return search(to, bfsWorklist);
    }

    // to search using Depth First Search
    ArrayList<Vertex> dfs(Vertex to) {
        return search(to, dfsWorklist);
    }

    // to search for the path from the start to the finish of the maze 
    ArrayList<Vertex> search(Vertex to, ICollection<Vertex> worklist) {
        if ((!worklist.isEmpty())) {
            Vertex next = worklist.remove();
            if (next.equals(to)) {
                reconstruct(cameFromEdge, next); 
                alreadySeen.add(to);
                endSearch = true; 
            }
            else {
                // add all the neighbors of next to the  
                // worklist for further processing
                ArrayList<Edge> ae = this.findEdges(edgesInTree, next);
                // NOTE: the given Vertex in findEdges can be an Edge's side1 or
                // side 2 which is why we "ifs" to check both sides below
                for (Edge e : ae) {
                    if (e.side1.equals(next) && !(alreadySeen.contains(e.side2))) { 
                        worklist.add(e.side2);
                        cameFromEdge.put(e.side2, e);
                    }
                    if (e.side2.equals(next) && !(alreadySeen.contains(e.side1))) {
                        worklist.add(e.side1);
                        cameFromEdge.put(e.side1, e);
                    }
                }  
                alreadySeen.add(next);
            }
        }
        return alreadySeen;
    }

    // to draw all the walls of the maze 
    // if the boolean flags are true, then render the wall
    WorldScene drawWalls(WorldScene w) {
        for (Edge e : edgesInTree) {
            int xc1 = (e.side1.location.x * Vertex.SIZE) 
                    + Vertex.SIZE / 2; // x coordinate
            int yc1 = (e.side1.location.y * Vertex.SIZE) 
                    + Vertex.SIZE / 2 ; // y coordinate
            if (e.side1.left) {
                w.placeImageXY(e.side1.makeWallVertical(), xc1 
                        - Vertex.SIZE / 2, yc1);  
            }
            if (e.side1.right) {
                w.placeImageXY(e.side1.makeWallVertical(), xc1 
                        + Vertex.SIZE / 2, yc1); 
            }
            if (e.side1.top) {
                w.placeImageXY(e.side1.makeWallHorizontal(), xc1, yc1 
                        - Vertex.SIZE / 2); 
            }
            if (e.side1.bottom) {
                w.placeImageXY(e.side1.makeWallHorizontal(), xc1, yc1 
                        + Vertex.SIZE / 2);
            }
            int xc2 = (e.side2.location.x * Vertex.SIZE) 
                    + Vertex.SIZE / 2; // x coordinate
            int yc2 = (e.side2.location.y * Vertex.SIZE) 
                    + Vertex.SIZE / 2 ; // y coordinate
            if (e.side2.left) {
                w.placeImageXY(e.side2.makeWallVertical(), xc2 
                        - Vertex.SIZE / 2, yc2);  
            }
            if (e.side2.right) {
                w.placeImageXY(e.side2.makeWallVertical(), xc2 
                        + Vertex.SIZE / 2, yc2); 
            }
            if (e.side2.top) {
                w.placeImageXY(e.side2.makeWallHorizontal(), xc2, yc2 
                        - Vertex.SIZE / 2); 
            }
            if (e.side2.bottom) {
                w.placeImageXY(e.side2.makeWallHorizontal(), xc2, yc2 
                        + Vertex.SIZE / 2);
            }
        }
        return w; 
    }

    // to reset the maze and render a new one with the same dimensions 
    void reset(String input) {
        if (input.equals("r")) {
            new MazeGame(height, width); 
            this.verticesInTree = new ArrayList<ArrayList<Vertex>>();
            this.createVertices(); 
            this.worklist = new ArrayList<Edge>();
            this.createEdges(1, 1);
            this.edgesInTree = new ArrayList<Edge>();
            this.representatives = new HashMap<Posn, Posn>();
            this.sortEdges();
            this.mapVertices();
            this.createSpanning();
            this.updateWall();
            this.cameFromEdge = new HashMap<Vertex, Edge>(); 
            this.dfsWorklist = new Stack<Vertex>();
            this.bfsWorklist = new Queue<Vertex>();
            this.dfsWorklist.add(verticesInTree.get(0).get(0));
            this.bfsWorklist.add(verticesInTree.get(0).get(0));
            this.alreadySeen = new ArrayList<Vertex>(); 
            this.endSearch = false; 
            // gameplay
            this.p1 = new Players();
            this.p2 = new Players();
            this.p1.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 20, 100));
            this.p2.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 181, 100));
            this.p1.vx = verticesInTree.get(0).get(0);
            this.p2.vx = verticesInTree.get(0).get(0);
            breathcondition = false;
            depthcondition = false; 
        }
    }

    // to create a new maze with either a horizontal or vertical bias 
    void mazeBias(String input) {
        if (input.equals("h")) { // horizontal bias
            new MazeGame(height, width); 
            this.verticesInTree = new ArrayList<ArrayList<Vertex>>();
            this.createVertices(); 
            this.worklist = new ArrayList<Edge>();
            this.createEdges(1 + rand.nextInt(50), 1); // creates a random bias
            this.edgesInTree = new ArrayList<Edge>();
            this.representatives = new HashMap<Posn, Posn>();
            this.sortEdges();
            this.mapVertices();
            this.createSpanning();
            this.updateWall();
            this.cameFromEdge = new HashMap<Vertex, Edge>(); 
            this.dfsWorklist = new Stack<Vertex>();
            this.bfsWorklist = new Queue<Vertex>();
            this.dfsWorklist.add(verticesInTree.get(0).get(0));
            this.bfsWorklist.add(verticesInTree.get(0).get(0));
            this.alreadySeen = new ArrayList<Vertex>(); 
            this.endSearch = false; 
            // gameplay
            this.p1 = new Players();
            this.p2 = new Players();
            this.p1.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 20, 100));
            this.p2.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 181, 100));
            this.p1.vx = verticesInTree.get(0).get(0);
            this.p2.vx = verticesInTree.get(0).get(0);
            breathcondition = false;
            depthcondition = false; 
        }
        if (input.equals("g")) { // vertical bias 
            new MazeGame(height, width); 
            this.verticesInTree = new ArrayList<ArrayList<Vertex>>();
            this.createVertices(); 
            this.worklist = new ArrayList<Edge>();
            this.createEdges(1, 1 + rand.nextInt(50)); // creates a random bias
            this.edgesInTree = new ArrayList<Edge>();
            this.representatives = new HashMap<Posn, Posn>();
            this.sortEdges();
            this.mapVertices();
            this.createSpanning();
            this.updateWall();
            this.cameFromEdge = new HashMap<Vertex, Edge>(); 
            this.dfsWorklist = new Stack<Vertex>();
            this.bfsWorklist = new Queue<Vertex>();
            this.dfsWorklist.add(verticesInTree.get(0).get(0));
            this.bfsWorklist.add(verticesInTree.get(0).get(0));
            this.alreadySeen = new ArrayList<Vertex>(); 
            this.endSearch = false; 
            // GAMEPLAY
            this.p1 = new Players();
            this.p2 = new Players();
            this.p1.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 20, 100));
            this.p2.piece = new CircleImage(8, OutlineMode.SOLID, new Color(255, 181, 100));
            this.p1.vx = verticesInTree.get(0).get(0);
            this.p2.vx = verticesInTree.get(0).get(0);
            breathcondition = false;
            depthcondition = false; 
        }
    }

    // EFFECT: to let the players move based on the user input
    public void onKeyEvent(String input) {
        this.p1.movePlayer1(input, this.height, this.width);
        this.p2.movePlayer2(input, this.height, this.width);
        this.mazeBias(input);
        if (input.equals("b")) { // breath first search
            breathcondition = true;
            depthcondition = false; 
            this.alreadySeen = new ArrayList<Vertex>();
            this.bfsWorklist = new Queue<Vertex>();
            this.bfsWorklist.add(verticesInTree.get(0).get(0));
            this.cameFromEdge = new HashMap<Vertex, Edge>();
            this.endSearch = false; 
        }
        if (input.equals("v")) {  // depth first search
            depthcondition = true; 
            breathcondition = false;
            this.alreadySeen = new ArrayList<Vertex>();
            this.dfsWorklist = new Stack<Vertex>();
            this.dfsWorklist.add(verticesInTree.get(0).get(0));
            this.cameFromEdge = new HashMap<Vertex, Edge>();
            this.endSearch = false;
        }
        if (input.equals("o")) { //player 1 toggle
            this.togglevisibility1 = !togglevisibility1;
        }
        if (input.equals("p")) { //player 2 toggle
            this.togglevisibility2 = !togglevisibility2;
        }
        this.reset(input); 
    }

    // EFFECT: to draw the given ArrayList onto the given WorldScene 
    void drawPaths(ArrayList<Vertex> av, WorldScene w, int red, int green, int blue) {
        for (Vertex v : av) {
            w.placeImageXY(v.drawSquare(red, green, blue), 
                    v.location.x * Vertex.SIZE + Vertex.SIZE / 2, 
                    v.location.y * Vertex.SIZE + Vertex.SIZE / 2);
        }
    }

    // EFFECT: to animate the search paths 
    public void onTick() {
        this.counter = this.counter + 1; // for testing purposes 
        if (breathcondition && !endSearch) {
            this.bfs(this.verticesInTree.get(width - 1).get(height - 1)); 
        }
        if (depthcondition && !endSearch) {
            this.dfs(this.verticesInTree.get(width - 1).get(height - 1)); 
        }
    }

    // to initially draw the world scene with maze image, the starting and ending 
    // points and the players, and a score
    // depending on user input, more elements will be added onto the scene
    public WorldScene makeScene() {
        WorldScene scene = this.getEmptyScene();
        scene.placeImageXY(new RectangleImage(width * Vertex.SIZE, 
                height * Vertex.SIZE, 
                OutlineMode.SOLID, Color.gray), (width * Vertex.SIZE) / 2, 
                (height * Vertex.SIZE) / 2); // grey background
        scene.placeImageXY(new RectangleImage(Vertex.SIZE, Vertex.SIZE, 
                OutlineMode.SOLID, new Color(0, 200, 0)), 0 + Vertex.SIZE / 2, 
                0 + Vertex.SIZE / 2); // starting vertex
        scene.placeImageXY(new RectangleImage(Vertex.SIZE, Vertex.SIZE, 
                OutlineMode.SOLID, new Color(150, 0, 150)), width * Vertex.SIZE - 
                Vertex.SIZE / 2, height * Vertex.SIZE - Vertex.SIZE / 2); // ending vertex
        this.drawPaths(alreadySeen, scene, 127, 169, 214);
        if (endSearch) {
            this.drawPaths(this.reconstruct(cameFromEdge, 
                    verticesInTree.get(width - 1).get(height - 1)), scene, 24, 17, 219);
        }      
        if (togglevisibility1) {
            this.drawPaths(p1.player1toggle, scene, 230, 243, 47);
        }
        if (togglevisibility2) {
            this.drawPaths(p2.player2toggle, scene, 255, 102, 178);
        }
        WorldScene result = this.drawWalls(scene); // all black lines/"walls"
        if (p1.vx.equals(verticesInTree.get(width - 1).get(height - 1)) 
                && p2.vx.equals(verticesInTree.get(width - 1).get(height - 1))
                && p1.moves > p2.moves) {
            scene.placeImageXY(new TextImage("WEBDOG WINS ◖⚆ᴥ⚆◗", height + Vertex.SIZE / 5, 
                    Color.white), (width * Vertex.SIZE) / 2, (height * Vertex.SIZE) / 2); 
        }
        if (p1.vx.equals(verticesInTree.get(width - 1).get(height - 1)) 
                && p2.vx.equals(verticesInTree.get(width - 1).get(height - 1))
                && p1.moves < p2.moves) {
            scene.placeImageXY(new TextImage("WEBCAT WINS ^ↀᴥↀ^", height + Vertex.SIZE / 5, 
                    Color.white), (width * Vertex.SIZE) / 2, (height * Vertex.SIZE) / 2);
        }
        if (p1.vx.equals(verticesInTree.get(width - 1).get(height - 1)) 
                && p2.vx.equals(verticesInTree.get(width - 1).get(height - 1))
                && p1.moves == p2.moves) {
            scene.placeImageXY(new TextImage("DOGS AND CATS ARE ==", 
                    height + Vertex.SIZE / 5, Color.white), (width * Vertex.SIZE) / 2, 
                    (height * Vertex.SIZE) / 2);
        }
        result.placeImageXY(this.p2.piece, (p2.vx.location.x * Vertex.SIZE) + 
                Vertex.SIZE / 2, (p2.vx.location.y * Vertex.SIZE) 
                + Vertex.SIZE / 2); // webdog, yellow circle
        result.placeImageXY(this.p1.piece, (p1.vx.location.x * Vertex.SIZE) + 
                Vertex.SIZE / 2, (p1.vx.location.y * Vertex.SIZE) 
                + Vertex.SIZE / 2); // webcat, red circle
        result.placeImageXY(new TextImage("WEBCAT MOVES: " + p1.moves + "      "
                + "WEBDOG MOVES: " + p2.moves, height / 2 + height / 4, Color.BLACK),
                width / 2 * Vertex.SIZE, height * Vertex.SIZE + Vertex.SIZE / 2); // score
        return result;
    }
}
