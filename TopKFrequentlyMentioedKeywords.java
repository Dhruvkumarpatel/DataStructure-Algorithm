import java.util.*;

class A
{
	public static void main(String args[])
	{
		int k = 2;
		String keywords[] = new String[] {"anacell", "cetracular", "betacellular"};
		String reviews[] = new String[] {"Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell"};


  String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
	String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
			"betacellular has great services", "deltacellular provides much better services than betacellular",
			"cetracular is worse than anacell", "Betacellular is better than deltacellular.", };

  		System.out.print("[");

  		for (String word : findTopKFrequentKeywordsFromReview(keywords2, reviews2, k))
  		{
  			System.out.print(word +" ");
  		}

  		System.out.print("]");
	}

	private static String[] findTopKFrequentKeywordsFromReview(String keywords[], String reviews[], int k)
	{
		final TreeMap<String, Integer> keywordsToFrequency = new TreeMap<String, Integer>();

		for (String keyword : keywords)
		{
			keywordsToFrequency.put(keyword, 0);
		}

		for (String review : reviews)
		{

			final Map<String, Boolean> keywordVisitedInReview = new HashMap<String, Boolean>();

			String splitBySpace[] = review.split(" ");

			for (String word : splitBySpace)
			{
				word = word.toLowerCase().trim();

				if (word.contains(","))
				{
					word = word.replace(",", "");
				}

				if (isThisWordaKeyword(word, keywords))
				{

					if (!keywordVisitedInReview.containsKey(word))
					{
						keywordVisitedInReview.put(word, true);
						keywordsToFrequency.put(word, keywordsToFrequency.get(word) + 1);
					}
				}
			}
		}

		Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
		maxHeap.addAll(keywordsToFrequency.entrySet());

		final String output[] = new String[k];

		int p = 0;

		while(!maxHeap.isEmpty() && k-- > 0) 
		{

			output[p] = maxHeap.poll().getKey();
			p++;
		}

		return output;

	}


	private static boolean isThisWordaKeyword(String word, String[] keywords)
	{
		return Arrays.asList(keywords).contains(word);
	}
}