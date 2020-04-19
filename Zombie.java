import java.util.*;

class Zombie
{
	public static void main(String[] args) {

		int inputGrid[][] = new int[][]{{1}};


 		System.out.print("Output :"+findNumberOfHours(inputGrid));
		
	}

	private static int findNumberOfHours(int inputGrid[][])
	{
		int rows = inputGrid.length;
		int cols = inputGrid[0].length;

		int count = 0;

		int noHuman = 0;

		int hour = 0;

		int total = rows * cols;

		final Queue<int[]> queue = new LinkedList<int[]>();

		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<cols; j++)
			{
				if (inputGrid[i][j] == 1)
				{
					queue.add(new int[]{i, j});
					count++;
				}

				if (inputGrid[i][j] == 0)
				{
					noHuman++;
				}
			}
		}

		if (noHuman == 0)
		{
			return 0;
		}

		// no zombies
		if (count == 0)
		{
			return -1;
		}


		int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		while (!queue.isEmpty())
		{


			if (count == total)
			{
				return hour;
			}


			int size = queue.size();

			for (int i=0; i<size; i++)
			{
				int element[] = queue.remove();

				for (int dir[] : dirs)
				{
					int ni= dir[0] + element[0];
					int nj = dir[1] + element[1];

					if (ni>=0 && ni<rows && nj>=0 && nj<cols && inputGrid[ni][nj] == 0)
					{
						inputGrid[ni][nj] = 1;
						queue.add(new int[]{ni, nj});
						count++;
					}
				}

			}

			hour++;
		}

		return -1;
	}
}