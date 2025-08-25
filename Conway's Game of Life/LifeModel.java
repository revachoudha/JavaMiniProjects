import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration()
	{
		int[][] directions = {{ 0, 1 },  { 1, 0 },
                               { 0, -1 }, { -1, 0 },
                               { 1, 1 },  { -1, -1},
                               { 1, -1 }, { -1, 1 }};
		
		for (int r = 0; r < SIZE; r++) {
		    for (int c = 0; c < SIZE; c++) {
		        int live = 0;
		        
		        //this is to count the number of live neighbors
		        for (int[] dir : directions) {
		            int x = r + dir[0];
		            int y = c + dir[1];
		            
		            if (x>=0 && x < SIZE && y >= 0 && y < SIZE && (grid[x][y].isAliveNow())) {
		                live++;
		            }
		        }
		        
		        //check if live is <= 2  or >=3, then it will die
		        if (grid[r][c].isAliveNow() && (live < 2 || live > 3)) {
		            grid[r][c].setAliveNext(false);
		        }
		        
		        //check if dead and live = 3, then it will be alive
		        else if (!grid[r][c].isAliveNow() && live ==3) {
		            grid[r][c].setAliveNext(true);
		        }
		        
		        else {
		            grid[r][c].setAliveNext(grid[r][c].isAliveNow());
		        }
		    }
		}
		
		
		for (int r = 0; r < SIZE; r++) {
		    for (int c = 0; c < SIZE; c++) {
		        grid[r][c].setAliveNow(grid[r][c].isAliveNext());
		    }
		}
		
		
		
		/* 
		 * student code here 
		 */
	}
}