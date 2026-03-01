import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;

public class Sierpinski extends JPanel {

    // defines min side length for recursion base case
    private static final int minSideLength = 5;
    // defines initial size & recursion depth
    private static final int initialSide = 512;
    private static final int recursionDepth = 8;

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        
        // initial call for right triangle
        drawRightTriangleFractal(g, 0, 0, initialSide);
    }
    
    
    // recursively draws right triangle, origin is top left vertex of right angle
    private void drawRightTriangleFractal(Graphics g, int x, int y, int side) {
        // Base case: if side length is small enough stop recursion.
        if (side <= minSideLength) {
            return;
        }

        // draw current right triangle's outline.
        // vertices: (x, y), (x + side, y), (x, y + side)
        
        g.drawLine(x, y, x + side, y); // top
        g.drawLine(x, y, x, y + side); // left
        g.drawLine(x + side, y, x, y + side); // hypotenuse

        // recursively draws 3 smaller triangles with length side/2.
        int halfSide = side / 2;

        // top-left triangle (same origin)
        drawRightTriangleFractal(g, x, y, halfSide);

        // top-right triangle (new origin: x + halfSide, y)
        drawRightTriangleFractal(g, x + halfSide, y, halfSide);

        // bottom-left triangle (new origin: x, y + halfSide)
        drawRightTriangleFractal(g, x, y + halfSide, halfSide);
    }


    private void drawEquilateralTriangleFractal(Graphics g, int x, int y, int side, int depth) {
        if (depth == 0) {
            return;
        }

        int height = (int) (side * Math.sqrt(3.0) / 2.0);

        // vertices for the current triangle
        Point p1 = new Point(x, y); // bottom center
        Point p2 = new Point(x - side / 2, y - height); // top left
        Point p3 = new Point(x + side / 2, y - height); // top right

        // triangle outline
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
        g.drawLine(p2.x, p2.y, p3.x, p3.y);
        g.drawLine(p3.x, p3.y, p1.x, p1.y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Fractals");
        Sierpinski panel = new Sierpinski();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(initialSide + 50, initialSide + 50);
        frame.add(panel);
        frame.setVisible(true);
    }
}
