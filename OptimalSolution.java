import java.util.*;

class OptimalSolution
{
	public static void main(String args[])
	{
		final List<int[]> lista = new ArrayList<int[]>();
		lista.add(new int[]{1,3});
		lista.add(new int[]{2,5});
		lista.add(new int[]{3,7});
		lista.add(new int[]{4,10});


		final List<int[]> listb = new ArrayList<int[]>();
		listb.add(new int[]{1,2});
		listb.add(new int[]{2,3});
		listb.add(new int[]{3,4});
		listb.add(new int[]{4,5});

		int target = 10;

		int output[] = findOptimalSolution(lista, listb, target).get(0);

		System.out.println("Optimal pair : [" + output[0] + "," + output[1] + "]");

	}


	private static List<int[]> findOptimalSolution(List<int[]> lista, List<int[]> listb, int target)
	{
		TreeMap<Integer, List<int[]>> result = new TreeMap<Integer, List<int[]>>();


		for (int[] a : lista)
		{
			for (int[] b : listb)
			{
				int sum = a[1] + b[1];

				if (sum <= target)
				{
					if (result.containsKey(sum))
					{
						result.get(sum).add(new int[]{a[0], b[0]});
					}
					else
					{
						List<int[]> temp = new ArrayList<int[]>();
						temp.add(new int[]{a[0], b[0]});
						result.put(sum, temp);
					}

				}
 			}
		}


		if (result.size() == 0)
		{
			return new ArrayList<int[]>();
		}

		int key = Integer.valueOf(result.lastKey());

		return result.get(key);
	}
}