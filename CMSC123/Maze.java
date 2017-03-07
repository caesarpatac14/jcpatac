package Maze;

import java.io.*;
import java.util.*;

/**
 * Created by jcpatac on 11/25/2016.
 */


/**
 * SQUARE CLASS
 */

class Square {
    private char type;
    private boolean visited;
    private int row;
    private int col;

    public Square(char type, boolean visited, int row, int col) {
        this.type = type;
        this.visited = visited;
        this.row = row;
        this.col = col;
    }

    public char getType() {
        return type;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setType(char type) {
        this.type = type;
    }

    public boolean isVisited() {
        return visited;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Square{" + "type=" + type + ", visited=" + visited + ", row=" + row + ", col=" + col + '}';
    }

    public Square clone() {
        return new Square(type, visited, row, col);
    }
}

/**
 * MAZE CLASS
 */

class Maze {

    public static final char START_MAZE = 'o';
    public static final char BLOCKED_SQUARE = '#';
    public static final char OPEN_SQUARE = '.';
    public static final char STEP = 'x';

    private Square[][] maze;
    private int rows;
    private int cols;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        maze = new Square[rows][cols];
    }

    public void setRow(int i, String row) {
        for (int j = 0; j < row.length(); j++) {
            maze[i][j] = new Square(row.charAt(j), false, i, j);
        }
    }

    public Square findStart() throws Exception {
        int posRow = -1;
        int posCol = -1;
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j].getType() == START_MAZE) {
                    posRow = i;
                    posCol = j;
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            throw new Exception("Starting point not found!");
        }
        return new Square(START_MAZE, found, posRow, posCol);
    }

    public void markVisited(Square square, boolean markIt) {
        maze[square.getRow()][square.getCol()].setVisited(markIt);
    }

    public void setAsPath(Square square, boolean set) {
        if (set) {
            maze[square.getRow()][square.getCol()].setType(STEP);
        }else {
            maze[square.getRow()][square.getCol()].setType(OPEN_SQUARE);
        }
    }

    public boolean isDeadEnd(Square square) {
        for (int i = 0; i < neighbors(square).size(); i++) {
            if (neighbors(square).get(i).getType() != BLOCKED_SQUARE && !neighbors(square).get(i).isVisited())
                return false;
        }
        return true;
    }

    private boolean withinMaze(Square square) {
        if (square.getRow() >= 0 && square.getRow() < rows && square.getCol() >= 0 && square.getCol() < cols) {
            return true;
        }
        return false;
    }

    public List<Square> neighbors(Square square) {

        List<Square> neighbors = new ArrayList<Square>(4);

        Square left = maze[square.getRow()][square.getCol() - 1];
        Square top = maze[square.getRow() - 1][square.getCol()];
        Square right = maze[square.getRow()][square.getCol() + 1];
        Square bottom = maze[square.getRow() + 1][square.getCol()];

        if (left.getType() != BLOCKED_SQUARE && !left.isVisited() && withinMaze(left)) {
            neighbors.add(left);
        }
        if (top.getType() != BLOCKED_SQUARE && !top.isVisited() && withinMaze(top)) {
            neighbors.add(top);
        }
        if (right.getType() != BLOCKED_SQUARE && !right.isVisited() && withinMaze(right)) {
            neighbors.add(right);
        }
        if (bottom.getType() != BLOCKED_SQUARE && !bottom.isVisited() && withinMaze(bottom)) {
            neighbors.add(bottom);
        }
        return neighbors;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res += maze[i][j].getType();
            }
            if (i < rows - 1) {
                res += "\n";
            }
        }
        return res;
    }

    public Maze clone() {
        Maze clone = new Maze(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                clone.maze[i][j] = maze[i][j].clone();
            }
        }
        return clone;
    }
}

/**
 * AGENDA CLASS (ABSTRACT)
 */

abstract class Agenda {

    private Class agClass;

    protected Agenda(Class agClass) {
        this.agClass = agClass;
    }

    public Agenda newInstance() throws Exception {
        return (Agenda) agClass.newInstance();
    }

    abstract void add(Square square);
    abstract boolean remove();
    abstract boolean isEmpty();
    abstract Square peek();
}

/**
 * STACK AGENDA CLASS
 */

class StackAgenda extends Agenda {

    private Stack<Square> stack;

    public StackAgenda() {
        super(StackAgenda.class);
        stack = new Stack<Square>();
    }

    @Override
    public void add(Square square) {
        stack.push(square);
    }

    @Override
    public boolean remove() {
        if (!isEmpty()) {
            stack.pop();
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Square peek() {
        if (!isEmpty()) {
            return stack.peek();
        }
        return null;
    }
}

/**
 * QUEUE AGENDA CLASS
 */

class QueueAgenda extends Agenda {

    Queue<Square> queue;

    public QueueAgenda() {
        super(QueueAgenda.class);
        queue = new LinkedList<Square>();
    }

    @Override
    public void add(Square square) {
        queue.offer(square);
    }

    @Override
    public boolean remove() {
        if (!isEmpty()) {
            queue.poll();
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Square peek() {
        if (!isEmpty()) {
            return queue.peek();
        }
        return null;
    }
}

/**
 * MAZE SOLVER CLASS
 */

class MazeSolver {

    public static final char START_MAZE = 'o';
    public static final char END_MAZE = '*';

    private Maze maze;
    private Maze solvedMaze;
    private Agenda agenda;

    private boolean solved;

    public MazeSolver(Maze maze, Agenda agenda) {
        this.maze = maze;
        this.agenda = agenda;
        solvedMaze = maze.clone();
    }

    public void solver() throws Exception {
        solve(solvedMaze.findStart());
    }

    public void printMaze() {
        String res;
        if (solved) {
            res = "SOLVED!" + "\n" + solvedMaze.toString();
        }else {
            res = "NO SOLUTION!" + "\n" + maze.toString();
        }
        try {
            File file = new File("C:\\Temp\\maze.out");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(res);
            bw.newLine();
            bw.newLine();
            bw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void solve(Square square) throws Exception {

        if (square.getType() == '*') {
            System.out.println(solvedMaze);
        }

        Agenda agenda1 = agenda.newInstance();
        Square currSquare = square;
        Stack<Square> solution = new Stack<Square>();

        solution.push(currSquare);

        agenda1.add(currSquare);

        while (!solution.isEmpty()) {
            currSquare = solution.peek();

            while (!agenda1.isEmpty()) {
                agenda1.remove();
            }

            if (currSquare.getType() == END_MAZE) {
                solved = true;
                break;
            }

            for (int i = 0; i < solvedMaze.neighbors(currSquare).size(); i++) {
                if (!solvedMaze.neighbors(currSquare).get(i).isVisited() && solvedMaze.neighbors(currSquare).get(i).getType() != START_MAZE) {
                    agenda1.add(solvedMaze.neighbors(currSquare).get(i));
                }
            }

            if (solvedMaze.isDeadEnd(currSquare)) {
                solution.pop();
            }else{
                if (!agenda1.isEmpty()) {
                    currSquare = agenda1.peek();
                    solvedMaze.markVisited(currSquare, true);
                    solution.push(currSquare);
                }
                else {
                    break;
                }
            }
        }
        if (solved) {
            while( !solution.empty() ){
                currSquare = solution.pop();
                if (currSquare.getType() != START_MAZE && currSquare.getType() != END_MAZE) {
                    solvedMaze.setAsPath(currSquare, true);
                }
            }
        }
    }

}


/**
 * MAIN CLASS
 */


class MazeSolverTester {
    public static void main(String[] args) {
        Maze maze;
        MazeSolver solveViaStack;
        MazeSolver solveViaQueue;
        BufferedReader bf = null;
        int testCases;

        try {
            bf = new BufferedReader(new FileReader("C:\\Temp\\maze.in"));
            testCases = Integer.parseInt(bf.readLine());
            for (int i = 0; i < testCases; i++) {
                String dimension = bf.readLine();
                String[] tokens = dimension.split(" ");
                int[] rAndc = new int[tokens.length];
                int x = 0;
                for (String str:tokens) {
                    rAndc[x++] = Integer.parseInt(str);
                }
                int rows = rAndc[0];
                int cols = rAndc[1];
                maze = new Maze(rows, cols);

                for (int j = 0; j < rows; j++) {
                    maze.setRow(j, bf.readLine());
                }

                solveViaStack = new MazeSolver(maze, new StackAgenda());
                solveViaStack.solver();
                solveViaStack.printMaze();


                solveViaQueue = new MazeSolver(maze, new QueueAgenda());
                solveViaQueue.solver();
                solveViaQueue.printMaze();

            }
            bf.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bf.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * There are two ways of making a bug-free code. Unfortunately, only the third one works.
 */