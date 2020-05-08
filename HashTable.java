import java.util.Iterator;
import java.util.*;
class HashTable{

	LinkedList array[];
	int size;

	HashTable(int size)
	{
		this.size = size;
		array = new LinkedList[size];

		for (int i=0; i<size; i++)
		{
			array[i] = new LinkedList<>();
		}

	}

	public void insert(int element)
	{
		int index = hashFunction(element);
		array[index].add(element);
	}

	public boolean contains(int element)
	{
		int index = hashFunction(element);

		LinkedList<Integer> list = array[index];

		return  list.contains(element);
	}

	public void delete(int element)
	{
		int index = hashFunction(element);

		LinkedList<Integer> list = array[index];

		Iterator iterate = list.iterator();

		while (iterate.hasNext())
		{
			if ((Integer)iterate.next() == element)
			{
				iterate.remove();
			}
		}

		for (int listElement : list)
		{
			System.out.println(listElement);
		}
	}


	public int search(int index)
	{
		LinkedList<Integer> list = array[index];

		for (int retrievedValue : list)
		{
			return retrievedValue;
		}

		return -1;
	}

	public int hashFunction(int element)
	{
		int index = element % size;

		System.out.println(index+" for an "+ element);

		return index;
	}

	public static void main(String args[])
	{
		HashTable table = new HashTable(7);
		table.insert(9379798797);
		table.insert(700);
		table.insert(76);
		table.insert(85);
		table.insert(92);
		table.insert(73);
		table.insert(101);

		table.delete(85);
		System.out.println(table.contains(85));
		System.out.println(table.search(6));
	}
}