import java.util.*;

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(numberOfCacheMiss(6, new int[]{1,2,1,3,1,2}, 2));
    }
    
    /**
    num = 6

pages = [1,2,1,3,1,2]

maxCacheSize = 2
    
    
    
    **/
    
    private static int numberOfCacheMiss(int num, int pages[], int maxCacheSize)
    {
        Map<Integer, Node> cache = new HashMap<>();
        DoublyLinkedList dlist = new DoublyLinkedList();
        int cacheMiss = 0;
        
        for (int page : pages)
        {
            if (!cache.containsKey(page))
            {
                cacheMiss++;
                
                if (cache.size() >= maxCacheSize)
                {
                    int remove = dlist.deleteNodeFromFront();
                    cache.remove(remove);
                }
               
                Node nodeToBeAdded = dlist.insertNodeAtTheEnd(new Node(page));
                cache.put(page, nodeToBeAdded);
            }
            else
            {
                Node existedNode = cache.get(page);
                dlist.removeGivenNode(existedNode);
                dlist.insertNodeAtTheEnd(existedNode);
            }
        }
        
        return cacheMiss;
    }
}

 
    class Node 
    {
        int val;
        Node next;
        Node prev;
        
        Node(int val)
        {
            this.val = val;
        }
    }
    
    class DoublyLinkedList
    {
        Node head;
        Node tail;
        
        DoublyLinkedList()
        {
            head = null;
            tail = null;
        }
        
        public Node insertNodeAtTheEnd(Node insert)
        {
            if (head == null)
            {
                head = insert;
                tail = head;
                return head;
            }
            
            if (tail == null)
            {
                tail = insert;
                return tail;
            }
            
            tail.next = insert;
            insert.prev = tail;
            tail = insert;
            return tail;
        }
        
        public int deleteNodeFromFront()
        {
            int value = head.val;
            head = head.next;
            head.prev = null;
            return value;
        }
        
        public void removeGivenNode(Node remove)
        {
            if (remove == tail)
            {
                tail = remove.prev;
                remove = null;
                return;
            }
            
            if (remove == head)
            {
                head = remove.next;
                remove = null;
                return;
            }
            
            remove.prev.next = remove.next;
            remove.next.prev = remove.prev;
        }
        
    }