import java.io.*;
import java.util.*;

public class Maze {
    private Square[][] grid;
    private int rows, cols;
    private Square start, exit;

    public Maze() {
        //this doesn't exist in chat idk why
    }

    public boolean loadMaze(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String[] dims = br.readLine().trim().split("\\s+");
            rows = Integer.parseInt(dims[0]);
            cols = Integer.parseInt(dims[1]);
            grid = new Square[rows][cols];
            for (int r = 0; r < rows; r++) {
                String [] parts = br.readLine().trim().split("\\s+");
                for (int c = 0; c < cols; c++) {
                    int val = Integer.parseInt(parts[c]);
                    grid[r][c] = new Square (r, c, val);
                    if (val == Square.START) start = grid[r][c];
                    if (val == Square.EXIT) exit = grid[r][c];
                }
            }
            reset();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Square> getNeighbors(Square s) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayList<Square> n = new ArrayList<>();
        for (int [] d: dirs) {
            int nr = s.getRow() + d[0], nc = s.getCol() + d[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                Square sq = grid[nr][nc];
                if (!sq.isWall()) n.add(sq);
            }
        }
        return n;
    }

    public Square getStart() {
        return start;
    }

    public Square getExit() {
        return exit;
    }

    public void reset() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c].reset();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) sb.append(grid[r][c]).append(' ');
            sb.append('\n');
        }
        return sb.toString();
    }
}
