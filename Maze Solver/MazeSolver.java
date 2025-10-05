import java.util.*;

public abstract class MazeSolver {
    private Maze maze;
    private boolean initialized = false;
    private boolean solved = false;
    private boolean unsolvable = false;
    
    public MazeSolver (Maze maze) {
        this.maze = maze;
    }
    public abstract void makeEmpty();
    public abstract boolean isEmpty();
    public abstract void add(Square s);
    public abstract Square next();

    public boolean isSolved() {
        return solved||unsolvable;
    }

    public void step() {
        if (isSolved()) return;

        if (!initialized) {
            makeEmpty();
            maze.reset();
            Square start = maze.getStart();
            add(start);
            start.setStatus(Square.WORKING);
            initialized = true;
            return;
        }

        if (isEmpty()) {
            unsolvable = true;
            return;
        }

        Square cur = next();

        if (cur.isExit()) {
            backtrackAndMark(cur);
            solved = true;
            return;
        }

        for (Square nb : maze.getNeighbors(cur)) {
            if (nb.getStatus() == Square.UNKNOWN) {
                nb.setPrevious(cur);
                nb.setStatus(Square.WORKING);
                add(nb);
            }
        }

        if (!cur.isStart() && !cur.isExit()) {
            cur.setStatus(Square.EXPLORED);
        }
    }

    public String getPath() {
        if (unsolvable) {
            return "No path to exit.";
        }

        if (!solved) {
            return "Solving...";
        }

        List<Square> rev = new ArrayList<>();
        for (Square t = maze.getExit(); t != null; t= t.getPrevious()) {
            rev.add(t);
        }
        Collections.reverse(rev);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rev.size(); i++) {
            Square s = rev.get(i);
            sb.append("(").append(s.getRow()).append(",").append(s.getCol()).append(")");
            if (i < rev.size() - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

    public void solve() {
        makeEmpty();
        maze.reset();
        initialized = true;
        solved = false;
        unsolvable = false;

        Square start = maze.getStart();
        add(start);
        start.setStatus(Square.WORKING);

        while (!isEmpty()) {
            Square cur = next();

            if (cur.isExit()) {
                backtrackAndMark(cur);
                solved = true;
                return;
            }

            for (Square nb : maze.getNeighbors(cur)) {
                if (nb.getStatus() == Square.UNKNOWN) {
                    nb.setPrevious(cur);
                    nb.setStatus(Square.WORKING);
                    add(nb);
                }
            }

            if (!cur.isStart() && !cur.isExit()) {
                cur.setStatus(Square.EXPLORED);
            }
        }
        unsolvable = true;
    }

    protected void backtrackAndMark(Square end) {
        for (Square t = end; t != null; t = t.getPrevious()) {
            if (!t.isStart() && !t.isExit()) t.setStatus(Square.ON_EXIT_PATH);
        }
    }

}
