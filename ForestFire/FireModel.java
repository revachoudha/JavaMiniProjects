public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    private void recursiveFire(int r, int c)
    {
        if (r < 0 || r >= SIZE || c < 0 || c >= SIZE) 
            return;
        
        if (myGrid[r][c].getStatus() != FireCell.GREEN)
            return;

        myGrid[r][c].setStatus(FireCell.BURNING);

        recursiveFire(r - 1, c); // North
        recursiveFire(r + 1, c); // South
        recursiveFire(r, c - 1); // West
        recursiveFire(r, c + 1); // East
    }

    public void solve()
    {
        for (int c = 0; c < SIZE; c++) {
            recursiveFire(SIZE - 1, c);
        }

        boolean trouble = false;
        for (int c = 0; c < SIZE; c++) {
            if (myGrid[0][c].getStatus() == FireCell.BURNING) {
                trouble = true;
                break;
            }
        }

        if (trouble)
            System.out.println("Onett is in trouble!");
        else
            System.out.println("Onett is safe.");

        myView.updateView(myGrid);
    }
}