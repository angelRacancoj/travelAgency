/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelManager;

import java.util.LinkedList;
import travelagency.Structure.bTree;
import travelagency.objects.reservacion;
import travelagency.objects.route;

/**
 *
 * @author angel
 */
public class reservacionManager {

    bTree tree;
    travelAndRoute TR;
    LinkedList<reservacion> reservacionList;
    LinkedList<route> routeList;

    public reservacionManager(bTree tree, travelAndRoute TR) {
        this.tree = tree;
        this.TR = TR;
        this.reservacionList = new LinkedList<>();
        this.routeList = new LinkedList<>();
    }

}
