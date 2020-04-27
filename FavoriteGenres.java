// "static void main" must be defined in a public class.
public class FavoriteGenres {
    public static void main(String[] args) {
        
        final Map<String, List<String>> userSongs = new HashMap<String, List<String>>();
        
        final List<String> list1 = new ArrayList<String>();
        list1.add("song1");
        list1.add("song2");
        list1.add("song3");
        list1.add("song4");
        list1.add("song8");
        userSongs.put("David", list1);
        
        final List<String> list2 = new ArrayList<String>();
        list2.add("song5");
        list2.add("song6");
        list2.add("song7");
        userSongs.put("Emma", list2);
        
        final Map<String, List<String>> songGenres = new HashMap<String, List<String>>();
        
        final List<String> list3 = new ArrayList<String>();
        list3.add("song1");
        list3.add("song3");
        songGenres.put("Rock", list3);
        
        final List<String> list4 = new ArrayList<String>();
        list4.add("song7");
        songGenres.put("Dubstep", list4);
        
        final List<String> list5 = new ArrayList<String>();
        list5.add("song2");
        list5.add("song4");
        songGenres.put("Techno", list5);
        
        final List<String> list6 = new ArrayList<String>();
        list6.add("song5");
        list6.add("song6");
        songGenres.put("Pop", list6);
        
        final List<String> list7 = new ArrayList<String>();
        list7.add("song8");
        list7.add("song9");
        songGenres.put("Jazz", list7);
        
        System.out.println ("Output :");
        
        for (Map.Entry<String, List<String>> m : returnFavoriteGenre(userSongs, songGenres).entrySet())
        {
            System.out.print(m.getKey()+":");
            
            final List<String> genres = m.getValue();
            
            for (String a : genres)
            {
                 System.out.print(a +",");
            }
            
            System.out.println();
        }
            
        
    }
    
    private static Map<String, List<String>> returnFavoriteGenre(final Map<String, List<String>> userSongs, final Map<String, List<String>> songGenres)
    {
        final Map<String, List<String>> result = new HashMap<String, List<String>>();
        
        
        // map for song -> genre
        final Map<String, String> songToGenre = new HashMap<String, String>();
        
        for (Map.Entry<String, List<String>> m : songGenres.entrySet())
        {
            final List<String> songs = m.getValue();
            for (String a : songs)
            {
                songToGenre.put(a, m.getKey());
            }
        }
        
        System.out.println("------"+ songToGenre);
        
        for (Map.Entry<String, List<String>> n: userSongs.entrySet())
        {
            final Map<String, Integer> genreToAppearance = new HashMap<String, Integer>();
            
            int maxCount = 0;
            
            result.put(n.getKey(), new ArrayList());
            
            final List<String> songs = n.getValue();
            
            for (String a : songs)
            {
                final String genre = songToGenre.get(a);
                System.out.println("------"+ genreToAppearance +"----"+a + "--------------"+genre);
                
                final int count = genreToAppearance.getOrDefault(genre, 0) + 1;
                genreToAppearance.put(genre, count);
                maxCount = Math.max(count, maxCount);
            }
            
            for (String genre : genreToAppearance.keySet())
            {
                if (genreToAppearance.get(genre) == maxCount)
                {
                    result.get(n.getKey()).add(genre);
                }
                
            }
            
        }
        
        return result;
    }
}