// Assignment 10

/* Jain, Raveena 
 * raveena97
 * Sai, Sreeya
 * ssai123
 */

import java.awt.Color;
import java.util.*;
import tester.*;
import javalib.impworld.WorldScene;
import javalib.worldimages.*;

//examples and tests 
class ExamplesMaze {

    MazeGame mg2x2;
    MazeGame mg3x3;
    MazeGame mg15x20;
    MazeGame mg10x7;
    MazeGame mg5x2;
    Comparator<Edge> comp; 

    Vertex v1;
    Vertex v2;
    Vertex v3;
    Vertex v4;
    Vertex v5;
    Vertex v6;
    Vertex v7;
    Vertex v8;
    Vertex v9;
    Vertex v10;
    Vertex v11;
    Vertex v12;
    Vertex v13;
    Vertex v14;
    Vertex v15;
    Vertex v16;
    Vertex v17;
    Vertex v18;
    Vertex v19;    
    Vertex v20;
    Vertex v21;
    Vertex v22;
    Vertex v23;
    Vertex v24;
    Vertex v25;
    Vertex v26;
    Vertex v27;
    Vertex v28;

    Edge e1;
    Edge e2;
    Edge e3;
    Edge e4;
    Edge e5;
    Edge e6;
    Edge e7;
    Edge e8;
    Edge e9;
    Edge e10;
    Edge e11;
    Edge e12;

    ArrayList<Vertex> av1; 
    ArrayList<Vertex> av2; 
    ArrayList<Vertex> av3;
    ArrayList<Vertex> av4;
    ArrayList<Vertex> av5;
    ArrayList<Vertex> av6;
    ArrayList<Vertex> av7;
    ArrayList<Vertex> av8;
    ArrayList<Vertex> av9;
    ArrayList<Vertex> av10;

    ArrayList<ArrayList<Vertex>> aan1; 
    ArrayList<ArrayList<Vertex>> aav2;

    ArrayList<Edge> ae1; 
    ArrayList<Edge> ae2; 
    ArrayList<Edge> ae3;
    ArrayList<Edge> eitup;

    Posn p1;
    Posn p2;
    Posn p3;

    HashMap<Posn, Posn> onehashbrown;
    HashMap<Posn, Posn> twohashbrowns;
    HashMap<Vertex, Edge> threehashbrowns; 

    Sentinel<String> mt;
    Sentinel<String> s1;
    Sentinel<String> s2;
    Sentinel<String> s3;
    Sentinel<String> s4;
    Sentinel<String> s5;
    Sentinel<String> s6;
    Sentinel<String> s7;
    Sentinel<String> s8;
    Sentinel<String> s9;

    Node<String> n1;
    Node<String> n2;
    Node<String> n3;
    Node<String> n4;
    Node<String> n5;
    Node<String> n6;
    Node<String> n7;
    Node<String> n8;
    Node<String> n9;
    Node<String> n10;
    Node<String> n11;
    Node<String> n12;
    Node<String> n13;
    Node<String> n14; 
    Node<String> n15;
    Node<String> n16;
    Node<String> n17;
    Node<String> n18;
    Node<String> n19;
    Node<String> n20;
    Node<String> n21;
    Node<String> n22;
    Node<String> n23;
    Node<String> n24; 
    Node<String> n25;
    Node<String> n26;
    Node<String> n27;
    Node<String> n28;
    Node<String> n29; 
    Node<String> n30;
    Node<String> n31;
    Node<String> n32; 
    Node<String> n33;
    Node<String> n34;
    Node<String> n35;
    Node<String> n36;
    Node<String> hello;
    Node<String> bye;
    Node<String> hi;
    Node<String> front;
    Node<String> end;
    Node<String> finale; 

    Deque<String> deque1;
    Deque<String> deque2;
    Deque<String> deque3;
    Deque<String> dequehello;
    Deque<String> dequebye;
    Deque<String> dequehi;
    Deque<String> dequefront;
    Deque<String> dequeend;
    Deque<String> dequefinale;
    Deque<String> dequeremovemid;

    ICollection<String> stackmt;
    ICollection<String> qmt;
    ICollection<String> stack1;
    ICollection<String> stack2;
    ICollection<String> stack3;
    ICollection<String> stack4;
    ICollection<String> q1;
    ICollection<String> q2;
    ICollection<String> q3;
    ICollection<String> q4;
    ICollection<String> q5;

    Players player; 

    void initMaze() {

        mg2x2 = new MazeGame(2, 2);
        mg15x20 = new MazeGame(15, 20);
        mg10x7 = new MazeGame(10, 7);

        comp = new WeightComparator(); 

        v1 = new Vertex(new Posn(0, 0)); 
        v2 = new Vertex(new Posn(0, 1)); 
        v3 = new Vertex(new Posn(0, 2)); 
        v4 = new Vertex(new Posn(1, 0));
        v5 = new Vertex(new Posn(1, 1)); 
        v6 = new Vertex(new Posn(1, 2)); 
        v7 = new Vertex(new Posn(2, 0)); 
        v8 = new Vertex(new Posn(2, 1));
        v9 = new Vertex(new Posn(2, 2));

        v10 = new Vertex(new Posn(0, 0));
        v11 = new Vertex(new Posn(0, 1));
        v12 = new Vertex(new Posn(0, 2));
        v13 = new Vertex(new Posn(0, 3));
        v14 = new Vertex(new Posn(0, 4));
        v15 = new Vertex(new Posn(1, 0));
        v16 = new Vertex(new Posn(1, 1));
        v17 = new Vertex(new Posn(1, 2));
        v18 = new Vertex(new Posn(1, 3));
        v19 = new Vertex(new Posn(1, 4));

        v20 = new Vertex(new Posn(0, 0), v20, null, v20, null); 
        v21 = new Vertex(new Posn(0, 1), v21, null, v20, null); 
        v22 = new Vertex(new Posn(0, 2), v22, null, v21, v22); 
        v23 = new Vertex(new Posn(1, 0), v20, null, v23, null);
        v24 = new Vertex(new Posn(1, 1), v21, null, v23, null); 
        v25 = new Vertex(new Posn(1, 2), v22, null, v24, v25); 
        v26 = new Vertex(new Posn(2, 0), v23, v26, v26, null); 
        v27 = new Vertex(new Posn(2, 1), v24, v27, v26, null);
        v28 = new Vertex(new Posn(2, 2), v25, v28, v27, v28);
        v27.friendright = v28;
        v26.friendright = v27;
        v25.friendbottom = v28;
        v24.friendbottom = v27;
        v24.friendright = v25;
        v23.friendbottom = v26;
        v23.friendright = v24;
        v22.friendbottom = v25;
        v21.friendbottom = v24;
        v21.friendright = v22;
        v20.friendbottom = v23;
        v20.friendright = v21; 

        e1 = new Edge(2, null, null);
        e2 = new Edge(4, null, null);
        e3 = new Edge(6, null, null);
        e4 = new Edge(8, null, null);
        e5 = new Edge(10, null, null);

        e6 = new Edge(2, v10, v11);
        e7 = new Edge(2, v10, v15);
        e8 = new Edge(2, v11, v12);
        e9 = new Edge(2, v12, v13);
        e10 = new Edge(2, v13, v14);
        e11 = new Edge(2, v13, v18);
        e12 = new Edge(2, v18, v19);

        av1 = new ArrayList<Vertex>();
        av2 = new ArrayList<Vertex>();
        av3 = new ArrayList<Vertex>();
        av4 = new ArrayList<Vertex>();
        av5 = new ArrayList<Vertex>();
        av6 = new ArrayList<Vertex>();
        av7 = new ArrayList<Vertex>();
        av8 = new ArrayList<Vertex>();
        av9 = new ArrayList<Vertex>();
        av10 = new ArrayList<Vertex>();

        aan1 = new ArrayList<ArrayList<Vertex>>();
        aav2 = new ArrayList<ArrayList<Vertex>>();

        ae1 = new ArrayList<Edge>(); 
        ae2 = new ArrayList<Edge>(); 
        ae3 = new ArrayList<Edge>(); 

        p1 = new Posn(0, 0);
        p2 = new Posn(0, 1);
        p3 = new Posn(1, 0);

        onehashbrown = new HashMap<Posn, Posn>();
        onehashbrown.put(p1, p1);
        onehashbrown.put(p2, p1);
        onehashbrown.put(p3, p2);

        twohashbrowns = new HashMap<Posn, Posn>();
        twohashbrowns.put(p1, p2);
        twohashbrowns.put(p2, p2);
        twohashbrowns.put(p3, p2);

        threehashbrowns = new HashMap<Vertex, Edge>(); 
        threehashbrowns.put(v11, e6);  
        threehashbrowns.put(v15, e7);
        threehashbrowns.put(v12, e8);
        threehashbrowns.put(v13, e9);
        threehashbrowns.put(v14, e10);
        threehashbrowns.put(v18, e11);
        threehashbrowns.put(v19, e12);

        mt = new Sentinel<String>(); 
        s1 = new Sentinel<String>();
        s2 = new Sentinel<String>();
        s3 = new Sentinel<String>();
        s4 = new Sentinel<String>();
        s5 = new Sentinel<String>();
        s6 = new Sentinel<String>();
        s7 = new Sentinel<String>();
        s8 = new Sentinel<String>();
        s9 = new Sentinel<String>();

        n1 = new Node<String>("abc", this.s1, this.s1); 
        n2 = new Node<String>("bcd", this.s1, this.n1);
        n3 = new Node<String>("cde", this.s1, this.n2);
        n4 = new Node<String>("def", this.s1, this.n3);

        n5 = new Node<String>("zy", this.s2, this.s2); 
        n6 = new Node<String>("yx", this.s2, this.n5);
        n7 = new Node<String>("xw", this.s2, this.n6);
        n8 = new Node<String>("wv", this.s2, this.n7);  
        n9 = new Node<String>("vu", this.s2, this.n8);
        n10 = new Node<String>("ut", this.s2, this.n9); 

        hello = new Node<String>("Hello", s3, s3);
        bye = new Node<String>("Bye", s4, s4);
        front = new Node<String>("Front", s6, s6);
        end = new Node<String>("End", s7, s7);

        n11 = new Node<String>("abc", this.s4, this.bye); 
        n12 = new Node<String>("bcd", this.s4, this.n11);
        n13 = new Node<String>("cde", this.s4, this.n12);
        n14 = new Node<String>("def", this.s4, this.n13);

        n15 = new Node<String>("abc", this.s5, s5); 
        n16 = new Node<String>("bcd", this.s5, this.n15);
        n17 = new Node<String>("cde", this.s5, this.n16);
        n18 = new Node<String>("def", this.s5, this.n17);
        hi = new Node<String>("Hi", s5, this.n18);

        front = new Node<String>("Front", s6, s6);
        n19 = new Node<String>("zy", this.s6, this.front); 
        n20 = new Node<String>("yx", this.s6, this.n19);
        n21 = new Node<String>("xw", this.s6, this.n20);
        n22 = new Node<String>("wv", this.s6, this.n21);  
        n23 = new Node<String>("vu", this.s6, this.n22);
        n24 = new Node<String>("ut", this.s6, this.n23);

        n25 = new Node<String>("zy", this.s7, this.s7); 
        n26 = new Node<String>("yx", this.s7, this.n25);
        n27 = new Node<String>("xw", this.s7, this.n26);
        n28 = new Node<String>("wv", this.s7, this.n27);  
        n29 = new Node<String>("vu", this.s7, this.n28);
        n30 = new Node<String>("ut", this.s7, this.n29);
        end = new Node<String>("End", this.s7, this.n30);

        n31 = new Node<String>("zy", this.s8, this.s8); 
        n32 = new Node<String>("yx", this.s8, this.n31);
        n33 = new Node<String>("xw", this.s8, this.n32);
        finale = new Node<String>("Finale", this.s8, this.n33);

        n34 = new Node<String>("zy", this.s9, this.s9); 
        n35 = new Node<String>("xw", this.s9, this.n34);
        n36 = new Node<String>("Finale", this.s9, this.n35);

        deque1 = new Deque<String>(); 
        deque2 = new Deque<String>(s1); 
        deque3 = new Deque<String>(s2); 
        dequehello = new Deque<String>(s3);
        dequebye = new Deque<String>(s4);
        dequehi = new Deque<String>(s5);
        dequefront = new Deque<String>(s6);
        dequeend = new Deque<String>(s7);
        dequefinale = new Deque<String>(s8); 
        dequeremovemid = new Deque<String>(s9); 

        stackmt = new Stack<String>();
        qmt = new Queue<String>();
        stack1 = new Stack<String>(dequehello);
        stack2 = new Stack<String>(dequebye);
        stack3 = new Stack<String>(deque1);
        stack4 = new Stack<String>(deque2);
        q1 = new Queue<String>(dequefront);
        q2 = new Queue<String>(dequeend);
        q3 = new Queue<String>(dequehi);
        q4 = new Queue<String>(deque2);
        q5 = new Queue<String>(deque3);

        player = new Players(); 

        {
            ae1.add(e1); 
            ae1.add(e3);
            ae1.add(e2);
            ae1.add(e4);

            ae2.add(e1); 
            ae2.add(e2);
            ae2.add(e3);
            ae2.add(e4);

            ae3.add(e6);
            ae3.add(e7);
            ae3.add(e8);
            ae3.add(e9);
            ae3.add(e10);
            ae3.add(e11);
            ae3.add(e12);

            av1.add(v1); 
            av1.add(v2); 
            av1.add(v3); 
            av2.add(v4); 
            av2.add(v5); 
            av2.add(v6); 
            av3.add(v7); 
            av3.add(v8); 
            av3.add(v9);
            av4.add(v10);
            av4.add(v11);
            av4.add(v12);
            av4.add(v13);
            av4.add(v14);
            av5.add(v15);
            av5.add(v16);
            av5.add(v17);
            av5.add(v18);
            av5.add(v19);

            av6.add(v15);
            av6.add(v10);

            av7.add(v12);
            av7.add(v11); 
            av7.add(v10);

            av8.add(v14);
            av8.add(v13); 
            av8.add(v12); 
            av8.add(v11);
            av8.add(v10); 

            av9.add(v19);
            av9.add(v18); 
            av9.add(v13); 
            av9.add(v12); 
            av9.add(v11); 
            av9.add(v10); 

            av10.add(v1);

            aan1.add(av1);
            aan1.add(av2);
            aan1.add(av3);
            aav2.add(av4);
            aav2.add(av5);
        }
        mg3x3 = new MazeGame(3, 3, aan1);
        mg5x2 = new MazeGame(5, 2, aav2);
    }

    // to test all exceptions thrown 
    boolean testExceptions(Tester t) {
        this.initMaze();
        return t.checkException(new RuntimeException("CANNOT REMOVE FROM A SENTINEL"),
                s2, "remove") && 
                t.checkException(new IllegalArgumentException("VALUE NULL"), 
                        n2, "updateNodes", null, n2) &&
                t.checkException(new IllegalArgumentException("VALUE NULL"), 
                        n6, "updateNodes", n5, null) &&
                t.checkException(new IllegalArgumentException("VALUE NULL"), 
                        n32, "updateNodes", null, null);
    }

    // to test makeWallHorizontal
    void testMakeWallHorizontal(Tester t) {
        this.initMaze();
        t.checkExpect(v1.makeWallHorizontal(), 
                new LineImage(new Posn(Vertex.SIZE, 0), Color.BLACK));
        t.checkExpect(v5.makeWallHorizontal(), 
                new LineImage(new Posn(Vertex.SIZE, 0), Color.BLACK));
        t.checkExpect(v4.makeWallHorizontal(), 
                new LineImage(new Posn(Vertex.SIZE, 0), Color.BLACK));
        t.checkExpect(v12.makeWallHorizontal(), 
                new LineImage(new Posn(Vertex.SIZE, 0), Color.BLACK));
    }

    // to test makeWallVertical
    void testMakeWallVertical(Tester t) {
        this.initMaze();
        t.checkExpect(v1.makeWallVertical(), 
                new LineImage(new Posn(0, Vertex.SIZE), Color.BLACK));
        t.checkExpect(v5.makeWallVertical(), 
                new LineImage(new Posn(0, Vertex.SIZE), Color.BLACK));
        t.checkExpect(v4.makeWallVertical(), 
                new LineImage(new Posn(0, Vertex.SIZE), Color.BLACK));
        t.checkExpect(v12.makeWallVertical(), 
                new LineImage(new Posn(0, Vertex.SIZE), Color.BLACK));
    }

    // to test drawSquare
    void testDrawSquare(Tester t) {
        this.initMaze();
        t.checkExpect(v1.drawSquare(127, 169, 214), new RectangleImage(Vertex.SIZE, 
                Vertex.SIZE, OutlineMode.SOLID, new Color(127, 169, 214))); 
        t.checkExpect(v10.drawSquare(12, 227, 15), new RectangleImage(Vertex.SIZE, 
                Vertex.SIZE, OutlineMode.SOLID, new Color(12, 227, 15))); 
        t.checkExpect(v14.drawSquare(0, 0, 0), new RectangleImage(Vertex.SIZE, 
                Vertex.SIZE, OutlineMode.SOLID, new Color(0, 0, 0))); 
        t.checkExpect(v20.drawSquare(20, 40, 60), new RectangleImage(Vertex.SIZE, 
                Vertex.SIZE, OutlineMode.SOLID, new Color(20, 40, 60))); 
        t.checkExpect(v1.drawSquare(24, 17, 219), new RectangleImage(Vertex.SIZE, 
                Vertex.SIZE, OutlineMode.SOLID, new Color(24, 17, 219))); 
        t.checkExpect(v10.drawSquare(16, 34, 234), new RectangleImage(Vertex.SIZE, 
                Vertex.SIZE, OutlineMode.SOLID, new Color(16, 34, 234))); 
    }

    // to test compare
    void testCompare(Tester t) {
        this.initMaze();
        t.checkExpect(comp.compare(e1, e3), -4); 
        t.checkExpect(comp.compare(e1, e4), -6);
        t.checkExpect(comp.compare(e3, e2), 2);
        t.checkExpect(comp.compare(e4, e5), -2);
        t.checkExpect(comp.compare(e2, e5), -6);
        t.checkExpect(comp.compare(e5, e3), 4);
    }

    // to test movePlayer1
    void testMovePlayer1(Tester t) { 
        this.initMaze();
        player.vx = v1;
        t.checkExpect(player.moves, 0);  
        player.movePlayer1("left", 2, 2);
        t.checkExpect(player.vx, v1);
        player.movePlayer1("up", 2, 2);
        t.checkExpect(player.vx, v1);
        player.vx = v9;
        player.movePlayer1("right", 2, 2);
        t.checkExpect(player.vx, v9);
        player.movePlayer1("bottom", 2, 2);
        t.checkExpect(player.vx, v9);
        this.initMaze();
        player.vx = v24; 
        t.checkExpect(player.moves, 0);  
        player.movePlayer1("left", 4, 4);
        t.checkExpect(player.vx, v23);
        player.movePlayer1("right", 4, 4);
        t.checkExpect(player.vx, v24);
        player.movePlayer1("up", 4, 4);
        t.checkExpect(player.vx, v21);
        player.movePlayer1("down", 4, 4);
        t.checkExpect(player.vx, v24);
    }

    // to test movePlayer2
    void testMovePlayer2(Tester t) { 
        this.initMaze();
        player.vx = v1;
        t.checkExpect(player.moves, 0);  
        player.movePlayer1("left", 2, 2);
        t.checkExpect(player.vx, v1);
        player.movePlayer2("up", 2, 2);
        t.checkExpect(player.vx, v1);
        player.vx = v9;
        player.movePlayer2("right", 2, 2);
        t.checkExpect(player.vx, v9);
        player.movePlayer2("bottom", 2, 2);
        t.checkExpect(player.vx, v9);
    }

    // to test createVertices
    // side effect caused by calling fixFriends tested separately 
    void testCreateVertices(Tester t) {
        this.initMaze(); 
        t.checkExpect(mg3x3.verticesInTree, aan1); 
        t.checkExpect(mg15x20.verticesInTree.size(), 20);
        t.checkExpect(mg15x20.verticesInTree.get(0).size(), 15);
        t.checkExpect(mg15x20.verticesInTree.get(4).size(), 15);
        t.checkExpect(mg15x20.verticesInTree.get(7).size(), 15);
        t.checkExpect(mg15x20.verticesInTree.get(10).size(), 15);
        t.checkExpect(mg15x20.verticesInTree.get(14).size(), 15);
        t.checkExpect(mg10x7.verticesInTree.size(), 7);
        t.checkExpect(mg10x7.verticesInTree.get(0).size(), 10);
        t.checkExpect(mg10x7.verticesInTree.get(2).size(), 10);
        t.checkExpect(mg10x7.verticesInTree.get(5).size(), 10);
        t.checkExpect(mg10x7.verticesInTree.get(6).size(), 10);
    }

    // to test createEdges
    void testCreateEdges(Tester t) {
        this.initMaze(); 
        t.checkRange(this.mg2x2.worklist.get(0).weight, 0, 4);
        t.checkRange(this.mg3x3.worklist.get(0).weight, 0, 9);
        t.checkRange(this.mg3x3.worklist.get(2).weight, 0, 9);
        t.checkRange(this.mg15x20.worklist.get(5).weight, 0, 300);
        t.checkRange(this.mg15x20.worklist.get(9).weight, 0, 300);
        t.checkRange(this.mg10x7.worklist.get(5).weight, 0, 70);
        t.checkRange(this.mg10x7.worklist.get(4).weight, 0, 70);
        t.checkExpect(this.mg3x3.worklist.size(), 12);
        t.checkExpect(this.mg5x2.worklist.size(), 13);
    }

    // to test mapVertices
    void testMapVertices(Tester t) {
        this.initMaze();
        Vertex n1 = this.mg3x3.verticesInTree.get(0).get(0);
        Vertex v2 = this.mg3x3.verticesInTree.get(2).get(1);
        Vertex v3 = this.mg5x2.verticesInTree.get(1).get(1);
        Vertex v4 = this.mg5x2.verticesInTree.get(1).get(2);
        t.checkExpect(mg3x3.representatives.get(n1.location), n1.location);
        t.checkExpect(mg3x3.representatives.get(v2.location), v2.location);
        t.checkExpect(mg5x2.representatives.get(v3.location), v3.location);
        t.checkExpect(mg5x2.representatives.get(v4.location), v4.location);
    }

    // to test sortEdges
    void testSortEdges(Tester t) {
        this.initMaze();
        t.checkExpect(mg3x3.worklist.get(0).weight <= 
                mg3x3.worklist.get(1).weight, true); 
        t.checkExpect(mg3x3.worklist.get(1).weight <=
                mg3x3.worklist.get(2).weight, true);
        t.checkExpect(mg5x2.worklist.get(2).weight <=
                mg5x2.worklist.get(3).weight, true);
        t.checkExpect(mg5x2.worklist.get(4).weight <=
                mg5x2.worklist.get(5).weight, true);
        t.checkExpect(mg5x2.worklist.get(4).weight <=
                mg5x2.worklist.get(5).weight, true);
    }

    // to test find
    void testFind(Tester t) {
        this.initMaze();
        Posn p1 = onehashbrown.get(0);
        Posn p2 = onehashbrown.get(1);
        Posn p3 = onehashbrown.get(2);
        Posn p4 = twohashbrowns.get(0);
        Posn p5 = twohashbrowns.get(1);
        Posn p6 = twohashbrowns.get(2);
        t.checkExpect(mg3x3.find(onehashbrown, p1), p1);
        t.checkExpect(mg3x3.find(onehashbrown, p2), p1);
        t.checkExpect(mg3x3.find(onehashbrown, p3), p1);
        t.checkExpect(mg3x3.find(twohashbrowns, p4), p5);
        t.checkExpect(mg3x3.find(twohashbrowns, p5), p5);
        t.checkExpect(mg3x3.find(twohashbrowns, p6), p5);
    }

    // to test union
    void testUnion(Tester t) {
        this.initMaze();
        Posn p2 = onehashbrown.get(1);
        Posn p4 = twohashbrowns.get(0);
        Posn p5 = twohashbrowns.get(1);
        Posn p6 = twohashbrowns.get(2);
        mg3x3.union(onehashbrown, p2, p2);
        mg3x3.union(onehashbrown, p4, p4);
        mg3x3.union(onehashbrown, p5, p4);
        t.checkExpect(mg3x3.find(onehashbrown, p2), p2);
        t.checkExpect(onehashbrown.get(p2), p2);
        t.checkExpect(mg3x3.find(twohashbrowns, p4), p4);
        t.checkExpect(twohashbrowns.get(p4), p4);
        t.checkExpect(mg3x3.find(twohashbrowns, p5), p4);
        t.checkExpect(twohashbrowns.get(p5), p4);
        t.checkExpect(mg3x3.find(twohashbrowns, p6), p4);
        t.checkExpect(twohashbrowns.get(p6), p4);
    }

    // to test createSpanning
    // this method has side effects caused by union and  
    // find. both of these methods are tested above 
    void testCreateSpanning(Tester t) {
        this.initMaze();
        mg3x3.createSpanning(); 
        mg5x2.createSpanning(); 
        t.checkExpect(mg2x2.edgesInTree.size(), 3); 
        t.checkExpect(mg3x3.edgesInTree.size(), 8); 
        t.checkExpect(mg5x2.edgesInTree.size(), 9); 
        t.checkExpect(mg10x7.edgesInTree.size(), 69); 
        t.checkExpect(mg15x20.edgesInTree.size(), 299); 
        t.checkExpect(mg3x3.worklist.size() < 12, true); 
        t.checkExpect(mg5x2.worklist.size() < 13, true); 
        t.checkExpect(mg10x7.worklist.size() < 73, true); 
    }

    // to test updateWall
    void testUpdateWall(Tester t) {
        this.initMaze();
        boolean b1 = !mg2x2.edgesInTree.get(1).side1.top;
        boolean b2 = !mg2x2.edgesInTree.get(1).side1.bottom;
        boolean b3 = !mg2x2.edgesInTree.get(1).side1.left;
        boolean b4 = !mg2x2.edgesInTree.get(1).side1.right;
        boolean b5 = !mg10x7.edgesInTree.get(6).side1.top;
        boolean b6 = !mg10x7.edgesInTree.get(6).side1.bottom;
        boolean b7 = !mg10x7.edgesInTree.get(6).side1.left;
        boolean b8 = !mg10x7.edgesInTree.get(6).side1.right;
        boolean b9 = !mg15x20.edgesInTree.get(10).side2.top;
        boolean b10 = !mg15x20.edgesInTree.get(10).side2.bottom;
        boolean b11 = !mg15x20.edgesInTree.get(10).side2.left;
        boolean b12 = !mg15x20.edgesInTree.get(10).side2.right;
        t.checkExpect(b1 || b2 || b3 || b4, true); 
        t.checkExpect(b5 || b6 || b7 || b8, true);
        t.checkExpect(b9 || b10 || b11 || b12, true);
    }

    // to test the method sizeHelp
    void testSizeHelp(Tester t) {
        this.initMaze();
        t.checkExpect(s1.sizeHelp(), 4);
        t.checkExpect(s3.sizeHelp(), 1);
        t.checkExpect(s5.sizeHelp(), 5); 
        t.checkExpect(s7.sizeHelp(), 7); 
        t.checkExpect(n10.sizeHelp(), 0); 
        t.checkExpect(n20.sizeHelp(), 4);
        t.checkExpect(n30.sizeHelp(), 1);
    }

    // to test the method size
    void testSize(Tester t) {
        this.initMaze();
        t.checkExpect(deque1.size(), 0);
        t.checkExpect(deque2.size(), 4);
        t.checkExpect(deque3.size(), 6); 
        t.checkExpect(dequehello.size(), 1);
        t.checkExpect(dequehi.size(), 5);
    }

    // to test add 
    void testAdd(Tester t) {
        stack3.add("Hello");
        stack4.add("Bye");
        t.checkExpect(this.stack3, this.stack1);
        t.checkExpect(this.stack4, this.stack2);
        this.initMaze();
        q4.add("Hi");
        q5.add("End");
        t.checkExpect(this.q4, this.q3);
        t.checkExpect(this.q5, this.q2);
    }

    // to test the method addAtHead
    void testAddAtHead(Tester t) {
        this.initMaze();
        deque1.addAtHead("Hello");
        deque2.addAtHead("Bye");
        deque3.addAtHead("Front");
        t.checkExpect(this.deque1, this.dequehello);
        t.checkExpect(this.deque2, this.dequebye);
        t.checkExpect(this.deque3, this.dequefront);
    }

    // to test the method addAtTail
    void testAddAtTail(Tester t) {
        this.initMaze();
        deque2.addAtTail("Hi");
        deque1.addAtTail("Hello");
        t.checkExpect(this.deque2, this.dequehi); 
        t.checkExpect(this.deque1, this.dequehello);
        this.initMaze(); 
        deque3.addAtTail("End");
        t.checkExpect(this.deque3, this.dequeend);
    }

    // to test the method removeHelp
    void testRemoveHelp(Tester t) {
        this.initMaze();
        t.checkExpect(this.s5.removeHelp(hi), "Hi"); 
        t.checkExpect(this.s6.removeHelp(front), "Front"); 
        t.checkExpect(this.s7.removeHelp(end), "End"); 
        t.checkExpect(this.s8.removeHelp(n32), "yx");
        // to check if links have been fixed
        t.checkExpect(this.dequehi, this.deque2);
        t.checkExpect(this.dequefront, this.deque3);
        t.checkExpect(this.dequeend, this.deque3);
        t.checkExpect(this.dequefinale, this.dequeremovemid);
    }

    // to test the method remove
    void testRemove(Tester t) {
        this.initMaze();
        t.checkExpect(this.bye.remove(), "Bye"); 
        t.checkExpect(this.n32.remove(), "yx"); 
        t.checkExpect(this.end.remove(), "End"); 
        // to check if links have been fixed
        t.checkExpect(this.dequebye, this.deque2);
        t.checkExpect(this.dequefinale, this.dequeremovemid);
        t.checkExpect(this.dequeend, this.deque3);
        this.initMaze(); 
        t.checkExpect(this.stack1.remove(), "Hello"); 
        t.checkExpect(this.stack2.remove(), "Bye"); 
        t.checkExpect(this.q1.remove(), "Front"); 
        t.checkExpect(this.q2.remove(), "zy"); 
    }

    // to test removeFromHead
    void testRemoveFromHead(Tester t) {
        this.initMaze();
        t.checkExpect(this.dequehello.removeFromHead(), "Hello"); 
        t.checkExpect(this.dequebye.removeFromHead(), "Bye"); 
        t.checkExpect(this.dequehi.removeFromHead(), "abc"); 
        t.checkExpect(this.dequefront.removeFromHead(), "Front"); 
        // to check if links have been fixed
        t.checkExpect(this.dequehello, this.deque1);
        t.checkExpect(this.dequebye, this.deque2);
        t.checkExpect(this.dequefront, this.deque3);
    }

    // to test removeFromTail 
    void testRemoveFromTail(Tester t) {
        this.initMaze();
        t.checkExpect(this.dequehi.removeFromTail(), "Hi");
        t.checkExpect(this.dequehello.removeFromTail(), "Hello");
        t.checkExpect(this.dequeend.removeFromTail(), "End");
        // to check if links have been fixed
        t.checkExpect(this.dequehi, this.deque2);
        t.checkExpect(this.dequehello, this.deque1); 
        t.checkExpect(this.dequeend, this.deque3);
    }

    // to test hashCode (override)
    void testHashCode(Tester t) {
        this.initMaze();
        // tests for vertices
        // test if each vertex has a unique value
        t.checkExpect(v1.hashCode(), 0); 
        t.checkExpect(v2.hashCode(), 100); 
        t.checkExpect(v3.hashCode(), 200); 
        t.checkExpect(v4.hashCode(), 1);
        t.checkExpect(v5.hashCode(), 101);
    }

    // to test equals (override)
    void testEquals(Tester t) {
        this.initMaze();
        t.checkExpect(n1.equals(n1), true);
        t.checkExpect(n10.equals(n10), true);
        t.checkExpect(n5.equals(n8), false);
        t.checkExpect(n22.equals(n30), false);
        t.checkExpect(mg3x3.verticesInTree.get(mg3x3.width - 1).get(
                mg3x3.height - 1).equals(new Vertex(new Posn(2, 2))), true);
    }

    // to test contains and containsHelp
    void testContains(Tester t) {
        this.initMaze();
        t.checkExpect(dequeremovemid.contains("Finale"), true);
        t.checkExpect(dequehello.contains("Hello"), true);
        t.checkExpect(dequebye.contains("bcd"), true);
        t.checkExpect(dequeend.contains("yes"), false);
        t.checkExpect(dequefront.contains("no"), false);
        t.checkExpect(mt.containsHelp("yes"), false);
        t.checkExpect(s4.containsHelp("no"), false);
        t.checkExpect(n11.containsHelp("abc"), true); 
        t.checkExpect(n12.containsHelp("bcd"), true); 
        t.checkExpect(n13.containsHelp("zzzz"), false); 
        t.checkExpect(n14.containsHelp("okok"), false); 
        t.checkExpect(stack2.contains("Bye"), true); 
        t.checkExpect(stackmt.contains("zz"), false);
        t.checkExpect(q1.contains("Front"), true); 
        t.checkExpect(q2.contains("End"), true); 
        t.checkExpect(q2.contains("zz"), false); 
    }

    // to test isEmpty and isEmptyHelp
    void testIsEmpty(Tester t) {
        this.initMaze();
        t.checkExpect(this.deque1.isEmpty(), true); 
        t.checkExpect(this.deque2.isEmpty(), false); 
        t.checkExpect(this.deque3.isEmpty(), false); 
        t.checkExpect(this.mt.isEmptyHelp(), true); 
        t.checkExpect(this.s1.isEmptyHelp(), true); 
        t.checkExpect(this.s2.isEmptyHelp(), true); 
        t.checkExpect(this.hello.isEmptyHelp(), false); 
        t.checkExpect(this.bye.isEmptyHelp(), false); 
        t.checkExpect(this.front.isEmptyHelp(), false); 
        t.checkExpect(this.stackmt.isEmpty(), true); 
        t.checkExpect(this.stack1.isEmpty(), false); 
        t.checkExpect(this.qmt.isEmpty(), true); 
        t.checkExpect(this.q1.isEmpty(), false); 
    }

    // to test removeNode 
    void testRemoveNode(Tester t) {
        this.initMaze();
        this.dequefront.removeNode(front); 
        this.dequehi.removeNode(hi);
        this.dequefinale.removeNode(n32); 
        // to check if links have been fixed
        t.checkExpect(this.dequefront, this.deque3);
        t.checkExpect(this.dequehi, this.deque2);
        t.checkExpect(this.dequefinale, this.dequeremovemid);
    }

    // to test fixFriends 
    void testFixFriends(Tester t) {
        this.initMaze();
        this.mg3x3.fixFriends(aan1);
        this.mg3x3.fixFriends(aan1);
        t.checkExpect(this.v1.friendright, v4);
        t.checkExpect(this.v1.friendleft, v1);
        t.checkExpect(this.v1.friendtop, v1);
        t.checkExpect(this.v1.friendleft, v1);
        t.checkExpect(this.v9.friendright, v9);
        t.checkExpect(this.v9.friendleft, v6);
        t.checkExpect(this.v9.friendtop, v8);
        t.checkExpect(this.v9.friendbottom, v9);
        t.checkExpect(this.v5.friendright, v8);
        t.checkExpect(this.v5.friendleft, v2);
        t.checkExpect(this.v5.friendtop, v4);
        t.checkExpect(this.v5.friendbottom, v6);
    }

    // to test findEdge
    void testFindEdge(Tester t) {
        this.initMaze();
        t.checkExpect(this.mg3x3.findEdges(ae3, v10).size(), 2);
        t.checkExpect(this.mg3x3.findEdges(ae3, v13).size(), 3);
        t.checkExpect(this.mg3x3.findEdges(ae3, v12).size(), 2);
        t.checkExpect(this.mg3x3.findEdges(ae3, v19).size(), 1);
    }

    // to test reconstruct
    void testReconstruct(Tester t) {
        this.initMaze();
        t.checkExpect(mg3x3.reconstruct(threehashbrowns, v15), av6); 
        t.checkExpect(mg3x3.reconstruct(threehashbrowns, v12), av7); 
        t.checkExpect(mg3x3.reconstruct(threehashbrowns, v14), av8); 
        t.checkExpect(mg3x3.reconstruct(threehashbrowns, v19), av9); 
    }

    // to test search
    void testSearch(Tester t) {
        this.initMaze();
        mg3x3.search(mg3x3.verticesInTree.get(mg3x3.width - 1).get(mg3x3.height - 1), 
                mg3x3.dfsWorklist);
        t.checkExpect(mg3x3.alreadySeen, av10);
        mg5x2.search(mg5x2.verticesInTree.get(mg5x2.width - 1).get(mg5x2.height - 1), 
                mg5x2.dfsWorklist);
        t.checkExpect(mg5x2.alreadySeen, av10);
        this.initMaze();
        mg3x3.search(mg3x3.verticesInTree.get(mg3x3.width - 1).get(mg3x3.height - 1), 
                mg3x3.bfsWorklist);
        t.checkExpect(mg3x3.alreadySeen, av10);
        mg5x2.search(mg5x2.verticesInTree.get(mg5x2.width - 1).get(mg5x2.height - 1), 
                mg5x2.bfsWorklist);
        t.checkExpect(mg5x2.alreadySeen, av10);
    }

    // to test bfs
    void testBfs(Tester t) {
        this.initMaze();
        mg3x3.bfs(mg3x3.verticesInTree.get(mg3x3.width - 1).get(mg3x3.height - 1));
        t.checkExpect(mg3x3.alreadySeen, av10);
        mg5x2.bfs(mg5x2.verticesInTree.get(mg5x2.width - 1).get(mg5x2.height - 1));
        t.checkExpect(mg5x2.alreadySeen, av10);
    }

    // to test dfs
    void testDfs(Tester t) {
        this.initMaze();
        mg3x3.dfs(mg3x3.verticesInTree.get(mg3x3.width - 1).get(mg3x3.height - 1));
        t.checkExpect(mg3x3.alreadySeen, av10);
        mg5x2.dfs(mg5x2.verticesInTree.get(mg5x2.width - 1).get(mg5x2.height - 1));
        t.checkExpect(mg5x2.alreadySeen, av10);
    }

    // to test drawPaths
    void testDrawPaths(Tester t) {
        this.initMaze();
        mg2x2.drawPaths(av3, mg2x2.getEmptyScene(), 127, 169, 214); 
        WorldScene scene1 = mg2x2.getEmptyScene(); 
        for (Vertex v : av3) {
            scene1.placeImageXY(v.drawSquare(127, 169, 214), 
                    v.location.x * Vertex.SIZE + Vertex.SIZE / 2, 
                    v.location.y * Vertex.SIZE + Vertex.SIZE / 2); 
        }
        mg5x2.drawPaths(av4,  mg5x2.getEmptyScene(), 24, 17, 219); 
        WorldScene scene2 =  mg5x2.getEmptyScene(); 
        for (Vertex v : av4) {
            scene1.placeImageXY(v.drawSquare(24, 17, 219), 
                    v.location.x * Vertex.SIZE + Vertex.SIZE / 2, 
                    v.location.y * Vertex.SIZE + Vertex.SIZE / 2); 
        }
        mg15x20.drawPaths(av7, mg15x20.getEmptyScene(), 230, 243, 47); 
        WorldScene scene3 = mg15x20.getEmptyScene(); 
        for (Vertex v : av7) {
            scene1.placeImageXY(v.drawSquare(230, 243, 47), 
                    v.location.x * Vertex.SIZE + Vertex.SIZE / 2, 
                    v.location.y * Vertex.SIZE + Vertex.SIZE / 2); 
        }
        mg10x7.drawPaths(av3, mg10x7.getEmptyScene(), 255, 102, 178); 
        WorldScene scene4 = mg10x7.getEmptyScene(); 
        for (Vertex v : av3) {
            scene1.placeImageXY(v.drawSquare(255, 102, 178), 
                    v.location.x * Vertex.SIZE + Vertex.SIZE / 2, 
                    v.location.y * Vertex.SIZE + Vertex.SIZE / 2); 
        }
        t.checkExpect(scene1 == mg2x2.getEmptyScene(), false); 
        t.checkExpect(scene2 ==  mg5x2.getEmptyScene(), false); 
        t.checkExpect(scene3 == mg15x20.getEmptyScene(), false);
        t.checkExpect(scene4 == mg10x7.getEmptyScene(), false);
    }

    // to test drawWalls
    void testDrawWalls(Tester t) {
        this.initMaze();
        WorldScene w1 = mg5x2.getEmptyScene();
        WorldScene w2 = mg10x7.getEmptyScene();
        WorldScene w3 = mg15x20.getEmptyScene();
        WorldScene w4 = mg2x2.getEmptyScene();
        WorldScene w5 = mg3x3.getEmptyScene();
        t.checkExpect(mg5x2.drawWalls(w1) == mg5x2.getEmptyScene(), false);
        t.checkExpect(mg10x7.drawWalls(w2) == mg10x7.getEmptyScene(), false);
        t.checkExpect(mg15x20.drawWalls(w3) == mg15x20.getEmptyScene(), false);
        t.checkExpect(mg2x2.drawWalls(w4) == mg2x2.getEmptyScene(), false);
        t.checkExpect(mg3x3.drawWalls(w5) == mg3x3.getEmptyScene(), false);
    }

    // to test reset
    void testReset(Tester t) {
        this.initMaze();
        mg10x7.reset("r");
        t.checkExpect(mg10x7.height, 10);  
        t.checkExpect(mg10x7.width, 7);  
        t.checkExpect(mg10x7.breathcondition, false);
        t.checkExpect(mg10x7.depthcondition, false); 
        t.checkExpect(mg10x7.p1.vx.location, new Posn(0, 0));
        t.checkExpect(mg10x7.p2.vx.location, new Posn(0, 0));
        t.checkExpect(mg10x7.p1.moves, 0); 
        t.checkExpect(mg10x7.p2.moves, 0); 
    }
    
    // to test onKeyEvent
    // reset and mazeBias tested separately 
    void testOnKeyEvent(Tester t) {
        this.initMaze();
        mg5x2.onKeyEvent("b");
        t.checkExpect(mg5x2.breathcondition, true);
        t.checkExpect(mg5x2.depthcondition, false);
        t.checkExpect(mg5x2.endSearch, false);
        mg15x20.onKeyEvent("v");
        t.checkExpect(mg15x20.breathcondition, false);
        t.checkExpect(mg15x20.depthcondition, true);
        t.checkExpect(mg15x20.endSearch, false);
        this.initMaze();
        mg10x7.onKeyEvent("o");
        t.checkExpect(mg10x7.togglevisibility1, true); 
        mg10x7.onKeyEvent("p");
        t.checkExpect(mg10x7.togglevisibility1, true);
    }
    
    // to test onTick
    void testOnTick(Tester t) {
        this.initMaze();
        mg10x7.onTick();
        t.checkExpect(mg10x7.counter, 1); 
        mg10x7.onTick();
        t.checkExpect(mg10x7.counter, 2); 
        mg10x7.onTick();
        t.checkExpect(mg10x7.counter, 3); 
        mg10x7.onTick();
        t.checkExpect(mg10x7.counter, 4); 
    }
    
    // to test mazeBias
    void testMazeBias(Tester t) {
        this.initMaze();
        mg10x7.mazeBias("h"); 
        t.checkRange(mg10x7.edgesInTree.get(10).weight, 1, 3500); 
        t.checkRange(mg10x7.edgesInTree.get(4).weight, 1, 3500); 
        t.checkExpect(mg10x7.height, 10);  
        t.checkExpect(mg10x7.width, 7);  
        t.checkExpect(mg10x7.breathcondition, false);
        t.checkExpect(mg10x7.depthcondition, false); 
        t.checkExpect(mg10x7.p1.vx.location, new Posn(0, 0));
        t.checkExpect(mg10x7.p2.vx.location, new Posn(0, 0));
        t.checkExpect(mg10x7.p1.moves, 0); 
        t.checkExpect(mg10x7.p2.moves, 0); 
        mg10x7.mazeBias("g"); 
        t.checkRange(mg10x7.edgesInTree.get(10).weight, 1, 3500); 
        t.checkRange(mg10x7.edgesInTree.get(4).weight, 1, 3500); 
        t.checkExpect(mg10x7.height, 10);  
        t.checkExpect(mg10x7.width, 7);  
        t.checkExpect(mg10x7.breathcondition, false);
        t.checkExpect(mg10x7.depthcondition, false); 
        t.checkExpect(mg10x7.p1.vx.location, new Posn(0, 0));
        t.checkExpect(mg10x7.p2.vx.location, new Posn(0, 0));
        t.checkExpect(mg10x7.p1.moves, 0); 
        t.checkExpect(mg10x7.p2.moves, 0); 
    }

    // to test makeScene
    void testMakeScene(Tester t) {
        this.initMaze();
        mg5x2.endSearch = false; 
        mg10x7.endSearch = false;
        mg15x20.endSearch = false;
        mg2x2.endSearch = false;
        mg3x3.endSearch = false;
        mg5x2.togglevisibility1 = false; 
        mg10x7.togglevisibility1 = false;
        mg15x20.togglevisibility1 = false;
        mg2x2.togglevisibility1 = false;
        mg3x3.togglevisibility1 = false;
        mg5x2.togglevisibility2 = false; 
        mg10x7.togglevisibility2 = false;
        mg15x20.togglevisibility2 = false;
        mg2x2.togglevisibility2 = false;
        mg3x3.togglevisibility2 = false;
        t.checkExpect(mg5x2.makeScene() == mg5x2.getEmptyScene(), false);
        t.checkExpect(mg10x7.makeScene() == mg10x7.getEmptyScene(), false);
        t.checkExpect(mg15x20.makeScene() == mg15x20.getEmptyScene(), false);
        t.checkExpect(mg2x2.makeScene() == mg2x2.getEmptyScene(), false);
        t.checkExpect(mg3x3.makeScene() == mg3x3.getEmptyScene(), false);
    }

    // to run the game
    void testMaze(Tester t) {
        MazeGame m = new MazeGame(20, 30);
        m.bigBang(m.width * Vertex.SIZE, m.height * Vertex.SIZE + Vertex.SIZE, 0.00001); 
    }
} 

