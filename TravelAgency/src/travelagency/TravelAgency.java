/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import travelagency.Structure.bTree;
import travelagency.exceptions.errorException;

/**
 *
 * @author angel
 */
public class TravelAgency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        bTree myTree = new bTree(5);
        try {
            myTree.addNode(25, "A");
            myTree.addNode(31, "B");
            myTree.addNode(8, "C");
            myTree.addNode(15, "D");
            myTree.addNode(41, "E");
            myTree.addNode(49, "F");
            myTree.addNode(71, "G");
            myTree.addNode(90, "H");
            myTree.addNode(5, "I");
            myTree.addNode(6, "J");
            myTree.addNode(1, "K");
            myTree.addNode(2, "L");
            myTree.addNode(3, "M");
            myTree.addNode(4, "N");
            myTree.addNode(7, "O");
            myTree.addNode(11, "P");
            myTree.addNode(19, "Q");
            myTree.addNode(28, "R");
            myTree.addNode(60, "S");
            myTree.addNode(66, "T");
            myTree.addNode(100, "U");
            myTree.addNode(14, "V");
            myTree.addNode(62, "W");
            myTree.addNode(50, "X");
            myTree.addNode(33, "Y");
            myTree.addNode(35, "Z");
            myTree.addNode(95, "AA");
            myTree.addNode(99, "AB");
            myTree.addNode(80, "AC");
        } catch (errorException e) {
            System.out.println(e);
        }

        myTree.printBtree();
    }

}
