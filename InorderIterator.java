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
public class InorderIterator implements CustomIterator {
    
    Stack<Node> ll = new Stack<Node>();  
    
    InorderIterator(Node node) {
        
        LeftPush(node);
        
    }
    private void LeftPush (Node actual) {  
        
     while (actual != null) {  
         
       ll.push(actual);  
       actual = actual.left;  
       
     }  
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
        
        LeftPush(a.right);  
   
        return a.contents;
    }
    
}
