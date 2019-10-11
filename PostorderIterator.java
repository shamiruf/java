/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw03;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 *
 * @author admin
 */
public class PostorderIterator implements CustomIterator{
    
    Stack<Node> ll = new Stack<Node>();  
    
    private void LeafNext(Node actual) {  
        
     while (actual != null) {  
       ll.push(actual);  
       if (actual.left != null) {  
         actual = actual.left;  
       } else {  
         actual = actual.right;  
       }  
     }  
   }  
    
    public PostorderIterator(Node node) {
        
        LeafNext(node);
        
    }
    
    @Override
    public boolean hasNext() {
        
        return !ll.isEmpty();
        
    }
    
    @Override
    public int next() {
        
        if(!hasNext()) {
            
            throw new NoSuchElementException("No nodes");  
        }
        
        Node a = ll.pop(); 
        if (!ll.isEmpty()) {
            Node top = ll.peek();
            if (a == top.left) {
                LeafNext(top.right);
            }
        }
        
        return a.contents;
    }
}
