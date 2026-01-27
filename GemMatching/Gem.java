/**
 * Author: Reva Choudha
 * Objective: represent a signle gem with a specific color and point value
 */
import java.awt.Font;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{	
	private GemType type;
	private int points;

	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
//		
//		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
//		
//		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}

	public Gem() {
		//create a gem with random color and point value
		GemType[] types = GemType.values();
		this.type = types[(int)(Math.random()*types.length)];
		int[] possiblePoints = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        this.points = possiblePoints[(int) (Math.random() * possiblePoints.length)];
	}

	public Gem(GemType type, int points) {
		//create a gem with the specified color and point value
		this.type = type;
        this.points = points;
	}
	public String toString() {
		// return a string representation of the gem
		return type + " " + points;
	}
	public GemType getType() {
		// get the type of the gem
		return type;
	}
	public int getPoints() {
		// get point value of the gem
		return points;
	}
	public void draw(double x, double y) {
		// draw gem at (x, y)
		String filename = "gem_" + type.toString().toLowerCase() + ".png";
		StdDraw.picture(x, y, filename);
		StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
        StdDraw.text(x, y, "" + points);
	}
}
