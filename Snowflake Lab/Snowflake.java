import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel {
    public SnowFlakePanel() {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        super.paintComponent(g);

        /*
         * DRAWING CODE BELOW
         */
        g.setColor(Color.BLUE);
        
        // Use the smaller dimension to ensure the snowflake fits
        int size = Math.min(width, height) / 3; 
        
        // Initial call to draw the snowflake at the center of the panel
        drawStar(g, width / 2, height / 2, size);
    }

    /**
     * Draws a 6-pointed star recursively to create a snowflake pattern.
     */
    public void drawStar(Graphics g, int x, int y, int size) {
        // Base case: stop recursion when the line length is sufficiently small 
        if (size < 2) {
            return;
        }

        // Draw six lines radiating from the center (x, y)
        for (int i = 0; i < 6; i++) {
            // Calculate angles at 0, 1*(2pi)/6, 2*(2pi)/6, etc.
            double theta = i * (2 * Math.PI / 6); 

            // Calculate endpoint coordinates using trigonometry
            int x2 = x + (int) (size * Math.cos(theta));
            int y2 = y + (int) (size * Math.sin(theta));

            // Draw the line from center to calculated endpoint
            g.drawLine(x, y, x2, y2);

            // Recursively draw smaller stars at the end of each line 
            drawStar(g, x2, y2, size / 3);
        }
    }
}

public class Snowflake {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnowFlakePanel());
        frame.pack();
        frame.setVisible(true);
    }
}