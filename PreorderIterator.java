/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw03;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Stack;
import javax.swing.tree.TreeNode;

/**
 *
 * @author admin
 */
public class PreorderIterator implements CustomIterator{
    
    ArrayDeque<Node> ll = new ArrayDeque<Node>();  
    
    public PreorderIterator(Node node) {
        
        if (node != null)
            ll.push(node);
        
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
        if (a.right != null) ll.push(a.right);  
        if (a.left != null) ll.push(a.left);  
        
        
        
        return a.contents;
    }


}
    
