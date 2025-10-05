public class MazeSolverWithStack extends MazeSolver {
    private final MyStack worklist;

    public MazeSolverWithStack(Maze maze) {
        super(maze);
        this.worklist = new MyStack();
    }

    @Override
    public void makeEmpty() {
        worklist.clear();
    }

    @Override
    public boolean isEmpty() {
        return worklist.isEmpty();
    }

    @Override
    public void add(Square s) {
        worklist.push(s);
    }

    @Override
    public Square next() {
        return worklist.pop();
    }
}