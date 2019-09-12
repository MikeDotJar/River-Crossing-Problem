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
public class RiverCrossing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("You must help the zebras and lions cross the river following these conditions:\n1. The raft needs at least one animal per move\n2. If the zebras are ever outnumbered, the lions will kill them\n3. The animals cannot swim; the MUST use the raft");
        System.out.println("\nThe simple graphic below represents the situation. All animals must be brought to the right side using the raft in the river.\nA 'Z' represents a zebra while an 'L' represents a lion\n");
        System.out.println("--------------------------------\n"
                + "           |       |    Z L    \n"
                + "Right Side | River |    Z L    Left Side\n"
                + "  (Goal)   |       |    Z L    \n"
        + "--------------------------------\n");
        Solution s = new Solution();
    }
    
}
