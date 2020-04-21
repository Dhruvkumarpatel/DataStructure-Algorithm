class productSuggestions
{
	  class Node{
        Node children[];
        boolean isEndOfWord;
        
        List<String> Suggestions;
        
        Node()
        {
            this.children = new Node[26];
            isEndOfWord = false;
            this.Suggestions = new ArrayList();
        }
    }
    
   private void insertProduct(String product, Node root)
   {
       Node node = root;
       
       for (int i=0; i<product.length(); i++)
       {
           int index = product.charAt(i) - 'a';
           if (node.children[index] == null)
           {
               node.children[index] = new Node();
           }
           if (node.Suggestions.size() < 3)
           {
               node.Suggestions.add(product);
           }
           
           node = node.children[index];
       }
       
       if (node.Suggestions.size() < 3)
       {
           node.Suggestions.add(product);
       }
       
       node.isEndOfWord = true;
   }
    
    private List<String> search(String word, Node root)
    {
        Node node = root;
        
        for (int i=0; i<word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            
            if (node.children[index] == null)
            {
                return new ArrayList<>();
            }
            
            node = node.children[index];
        }
        
        return node.Suggestions;
    }
   
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);
        
        final List<List<String>> result = new ArrayList<List<String>>();
        
        final Node root = new Node();
        
        for (String product : products)
        {
            insertProduct(product, root);
        }
        
        String key = "";
        
        for (int i=0; i<searchWord.length(); i++)
        {
            key += searchWord.charAt(i);
            
            result.add(search(key, root));
        }
        
        return result;
    }
	
}