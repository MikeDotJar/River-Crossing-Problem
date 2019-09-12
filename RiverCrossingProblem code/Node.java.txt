/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrossing;

/**
 *
 * @author Admin
 */
public class Node {
    
    boolean rightSide;
    int zebraRight;
    int lionRight;
    int zebraLeft;
    int lionLeft;
    String movement;
    Node twoZebras, oneZebra, twoLions, oneLion, oneOfEach, parent;
    
    Node(){
        zebraRight = 3;
        lionRight = 3;
        if(parent == null){
            rightSide = true;
        }
        else{
            rightSide = !parent.rightSide;
        }
    }
    
    Node(int zebraRight, int lionRight){
        this.zebraRight = zebraRight;
        this.lionRight = lionRight;
        if(parent == null){
            rightSide = true;
        }
        else{
            rightSide = !parent.rightSide;
        }
    }
    
    Node(int zebraRight, int lionRight, int zebraLeft, int lionLeft, Node n){
        this.zebraRight = zebraRight;
        this.lionRight = lionRight;
        this.zebraLeft = zebraLeft;
        this.lionLeft = lionLeft;
        parent = n;
        if(parent == null){
            rightSide = true;
        }
        else{
            rightSide = !parent.rightSide;
        }
    }
    
    public void setZebraRight(int zebraRight){
        this.zebraRight = zebraRight;
    }
    
    public void setLionRight(int lionRight){
        this.lionRight = lionRight;
    }
    
    public void setZebraLeft(int zebraLeft){
        this.zebraLeft = zebraLeft;
    }
    
    public void setLionLeft(int lionLeft){
        this.lionLeft = lionLeft;
    }
    
    public void setSide(){
        if(parent == null){
            rightSide = true;
        }
        else{
            rightSide = !parent.rightSide;
        }
    }
    
    public void setMovement(String movement){
        this.movement = movement;
    }
    
    public int getZebraRight(){
        return zebraRight;
    }
    
    public int getLionRight(){
        return lionRight;
    }
    
    public int getZebraLeft(){
        return zebraLeft;
    }
    
    public int getLionLeft(){
        return lionLeft;
    }
    
    public boolean getSide(){
        return rightSide;
    }
    
    public String getMovement(){
        return movement;
    }
}
