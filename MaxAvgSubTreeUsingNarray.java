package com.cerner.indigo.info.dicom.service;

import java.util.HashMap;
import java.util.Map;

//"static void main" must be defined in a public class.
public class Main {
 
 private static double maxAvg = 0.0;
 
 private static Map<Node, Double> map = new HashMap<>();
 
 public static void main(String[] args) {
     
     Node root = new Node(20);
     Node child1 = new Node(12);
     Node child2 = new Node(18);
     root.childrens.add(child1);
     root.childrens.add(child2);
     
     child1.childrens.add(new Node(11));
     child1.childrens.add(new Node(2));
     child1.childrens.add(new Node(3));
     
     child2.childrens.add(new Node(15));
     child2.childrens.add(new Node(8));
     
     maximumAvg(root);

     for (Map.Entry<Node, Double> m : map.entrySet())
     {
         if (m.getValue() == maxAvg)
         {
             System.out.println ("output :"+m.getKey().data);
             break;
         }
     }
     
 }

 private static double[] maximumAvg(Node root)
 {
     if (root.childrens.isEmpty())
     {
         return new double[]{0.0,0.0};
     }
     
     double sum = 0.0;
     double count = 0.0;
     
     for (Node child : root.childrens)
     {
         double[] subchild = maximumAvg(child);
         
         sum += subchild[0];
         count += subchild[1];
         
         if (child.childrens.isEmpty())   
         {
             sum += child.data;
             count += 1;
         }
     }
     
     sum += root.data;
     count += 1;
     
     double avg = sum / count;
     
     map.put(root, avg);
     
     maxAvg = Math.max(maxAvg, avg);
     
    
      
     return new double[]{sum, count};
 }
}
