/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrossing;

import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class Solution {
    public static LinkedList<Node> frontier = new LinkedList<Node>();
    public static LinkedList<Node> explored = new LinkedList<Node>();
    Node root;
    
    Solution(){
       root = new Node(); 
       BFS(root);
    }
    
    Solution(int zebras, int lions){
        root = new Node(zebras,lions);
        BFS(root);
    }
    
    public void BFS(Node n){
        if(goalTest(n)){
            return;
        }
        frontier.add(n);
        while(frontier.peekFirst() != null){
            Node tempNode = frontier.pollLast();
            explored.add(tempNode);
            addToFrontier(tempNode);
        }
    }
    
    public boolean goalTest(Node n){
        return n.getLionLeft() == 3 && n.getZebraLeft() == 3;
    }
    
    public boolean followsConstraints(Node n){
        if(n.getLionRight() > n.getZebraRight()){
            if(n.getZebraRight() > 0){
                return false;
            }
        }
        
        if(n.getLionLeft() > n.getZebraLeft()){
            if(n.getZebraLeft() > 0){
                return false;
            }
        }
        return true;
    }
    
    public boolean isInFrontier(Node n){
        String node = n.getZebraRight() + "" + n.getZebraLeft() + "" + n.getLionRight() + "" + n.getLionLeft() + "" + n.getSide();
        for(int i = 0; i < frontier.size(); i++){
            Node tempNode = frontier.get(i);
            String temp = tempNode.getZebraRight() + "" + tempNode.getZebraLeft() + "" + tempNode.getLionRight() + "" + tempNode.getLionLeft() + "" + tempNode.getSide();
            if(node.equals(temp)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isExplored(Node n){
        String node = n.getZebraRight() + "" + n.getZebraLeft() + "" + n.getLionRight() + "" + n.getLionLeft() + "" + n.getSide();
        for(int i = 0; i < explored.size(); i++){
            Node tempNode = explored.get(i);
            String temp = tempNode.getZebraRight() + "" + tempNode.getZebraLeft() + "" + tempNode.getLionRight() + "" + tempNode.getLionLeft() + "" + tempNode.getSide();
            if(node.equals(temp)){
                return true;
            }
        }
        return false;
    }
    
    public void findPath(Node n){
        System.out.println("Follow these steps to complete the crossing and ensure the zebras' safety");
        int count = 2;
        System.out.println("Step 1: " + n.getMovement());
        Node tempNode = n.parent;
        while(tempNode.parent != null){
            System.out.println("Step " + count + ": " + tempNode.getMovement());
            count++;
            tempNode = tempNode.parent;
        }
        System.out.println("\nWhat it looks like after all steps: \n");
        System.out.println("-----------------------------------\n"
                + "            Z L    |       |        \n"
            + "Right Side  Z L    | River |       Left Side\n"
               + "  (Goal)    Z L    |       |        \n"
        + "-----------------------------------");
        System.exit(0);
        
    }
    
    private void addToFrontier(Node n) {
        
        
        if(n.getSide()){
            if(n.getZebraRight() >= 2){
                n.twoZebras = new Node(n.getZebraRight() - 2, n.getLionRight(), n.getZebraLeft() + 2, n.getLionLeft(),n);
                n.twoZebras.setMovement("send 2 zebras left");
                if(!followsConstraints(n.twoZebras) || isInFrontier(n.twoZebras) || isExplored(n.twoZebras)){
                    n.twoZebras = null;
                }
                else if(goalTest(n.twoZebras)){
                    findPath(n.twoZebras);
                    return;
                }
                else{
                    frontier.addFirst(n.twoZebras);
                }
            }
            
            if(n.getLionRight() >= 2){
                n.twoLions = new Node(n.getZebraRight(), n.getLionRight() - 2, n.getZebraLeft(), n.getLionLeft() + 2,n);
                n.twoLions.setMovement("send 2 lions left");
                if(!followsConstraints(n.twoLions) || isInFrontier(n.twoLions) || isExplored(n.twoLions)){
                    n.twoLions = null;
                }
                else if(goalTest(n.twoLions)){
                    findPath(n.twoLions);
                    return;
                }
                else{
                    frontier.addFirst(n.twoLions);
                }
            }
            
            if(n.getLionRight() >= 1 && n.getZebraRight() >= 1){
                n.oneOfEach = new Node(n.getZebraRight() - 1, n.getLionRight() - 1, n.getZebraLeft() + 1, n.getLionLeft() + 1,n);
                n.oneOfEach.setMovement("send 1 zebra and 1 lion left");
                if(!followsConstraints(n.oneOfEach) || isInFrontier(n.oneOfEach) || isExplored(n.oneOfEach)){
                    n.oneOfEach = null;
                }
                else if(goalTest(n.oneOfEach)){
                    findPath(n.oneOfEach);
                    return;
                }
                else{
                    frontier.addFirst(n.oneOfEach);
                }
            }
            
            if(n.getZebraRight() >= 1){
                n.oneZebra = new Node(n.getZebraRight() - 1, n.getLionRight(), n.getZebraLeft() + 1, n.getLionLeft(),n);
                n.oneZebra.setMovement("send 1 zebra left");
                if(!followsConstraints(n.oneZebra) || isInFrontier(n.oneZebra) || isExplored(n.oneZebra)){
                    n.oneZebra = null;
                }
                else if(goalTest(n.oneZebra)){
                    findPath(n.oneZebra);
                    return;
                }
                else{
                    frontier.addFirst(n.oneZebra);
                }
            }
            
            if(n.getLionRight() >= 1){
                n.oneLion = new Node(n.getZebraRight(), n.getLionRight() - 1, n.getZebraLeft(), n.getLionLeft() + 1,n);
                n.oneLion.setMovement("send 1 lion left");
                if(!followsConstraints(n.oneLion) || isInFrontier(n.oneLion) || isExplored(n.oneLion)){
                    n.oneLion = null;
                }
                else if(goalTest(n.oneLion)){
                    findPath(n.oneLion);
                    return;
                }
                else{
                    frontier.addFirst(n.oneLion);
                }
            }
        }
        else{
            if(n.getZebraLeft() >= 2){
                n.twoZebras = new Node(n.getZebraRight() + 2, n.getLionRight(), n.getZebraLeft() - 2, n.getLionLeft(),n);
                n.twoZebras.setMovement("send 2 zebras right");
                if(!followsConstraints(n.twoZebras) || isInFrontier(n.twoZebras) || isExplored(n.twoZebras)){
                    n.twoZebras = null;
                }
                else if(goalTest(n.twoZebras)){
                    findPath(n.twoZebras);
                    return;
                }
                else{
                    frontier.addFirst(n.twoZebras);
                }
            }
            
            if(n.getLionLeft() >= 2){
                n.twoLions = new Node(n.getZebraRight(), n.getLionRight() + 2, n.getZebraLeft(), n.getLionLeft() - 2,n);
                n.twoLions.setMovement("send 2 lions right");
                if(!followsConstraints(n.twoLions) || isInFrontier(n.twoLions) || isExplored(n.twoLions)){
                    n.twoLions = null;
                }
                else if(goalTest(n.twoLions)){
                    findPath(n.twoLions);
                    return;
                }
                else{
                    frontier.addFirst(n.twoLions);
                }
            }
            
            if(n.getLionLeft() >= 1 && n.getZebraRight() >= 1){
                n.oneOfEach = new Node(n.getZebraRight() + 1, n.getLionRight() + 1, n.getZebraLeft() - 1, n.getLionLeft() - 1,n);
                n.oneOfEach.setMovement("send 1 zebra and 1 lion right");
                if(!followsConstraints(n.oneOfEach) || isInFrontier(n.oneOfEach) || isExplored(n.oneOfEach)){
                    n.oneOfEach = null;;
                }
                else if(goalTest(n.oneOfEach)){
                    findPath(n.oneOfEach);
                    return;
                }
                else{
                    frontier.addFirst(n.oneOfEach);
                }
            }
            
            if(n.getZebraLeft() >= 1){
                n.oneZebra = new Node(n.getZebraRight() + 1, n.getLionRight(), n.getZebraLeft() - 1, n.getLionLeft(),n);
                n.oneZebra.setMovement("send 1 zebra right");
                if(!followsConstraints(n.oneZebra) || isInFrontier(n.oneZebra) || isExplored(n.oneZebra)){
                    n.oneZebra = null;
                }
                else if(goalTest(n.oneZebra)){
                    findPath(n.oneZebra);
                    return;
                }
                else{
                    frontier.addFirst(n.oneZebra);
                }
            }
            
            if(n.getLionLeft() >= 1){
                n.oneLion = new Node(n.getZebraRight(), n.getLionRight() + 1, n.getZebraLeft(), n.getLionLeft() - 1,n);
                n.oneLion.setMovement("send 1 lion right");
                if(!followsConstraints(n.oneLion) || isInFrontier(n.oneLion) || isExplored(n.oneLion)){
                    n.oneLion = null;
                }
                else if(goalTest(n.oneLion)){
                    findPath(n.oneLion);
                    return;
                }
                else{
                    frontier.addFirst(n.oneLion);
                }
            }
        }
    }
    
    
}
