package travelagency.Structure;

import FileManager.Order;
import java.util.LinkedList;
import travelagency.exceptions.errorException;
import travelagency.objects.destiny;

/**
 *
 * @author angel
 */
public class Bnode {

    Order organize;
    LinkedList<destiny> destinys;
    LinkedList<Bnode> nodes;
    int maxSize;

    public Bnode(int maxSize) {
        this.destinys = new LinkedList<>();
        this.destinys.clear();
        this.nodes = new LinkedList<>();
        this.nodes.clear();
        this.maxSize = maxSize;
        this.organize = new Order();
    }

    public void clear(int size) {
        this.maxSize = size;
        this.destinys.clear();
        this.nodes.clear();
    }

    /**
     *
     * @return true
     */
    public boolean isBnodesListEmpty() {
        return nodes.isEmpty();
    }

    /**
     *
     * @return true
     */
    public boolean isDestinyListEmpty() {
        return destinys.isEmpty();
    }

    /**
     * Add a Destiny to Bnode's Destinys list
     *
     * @param newDestiny
     */
    public void addDestiny(destiny newDestiny) {
        this.destinys.add(newDestiny);
        if (this.destinys.size() > 1) {
            organize.bubleSortDestinys(destinys);
        }
    }

    public void addAllDestiny(LinkedList<destiny> destinyIn) {
        this.destinys.addAll(destinys);
        if (this.destinys.size() > 1) {
            organize.bubleSortDestinys(destinys);
        }
    }

    /**
     * Add a Bnode to the Bnode's Bnodes list
     *
     * @param newBnode
     */
    public void addBnode(Bnode newBnode) {
        this.nodes.add(newBnode);
        if (this.nodes.size() > 1) {
            organize.bubleSortBnodes(nodes);
        }
    }

    public void deleteBnode(int posicion) {
        this.nodes.remove(posicion);
    }

    /**
     * Add all elements from list to the node list
     *
     * @param nodesIn
     * @throws errorException
     */
    public void addBnode(LinkedList<Bnode> nodesIn) throws errorException {
        if ((nodes.size() + nodesIn.size() > maxSize)) {
            throw new errorException("tree exceeded size");
        } else {
            this.nodes.addAll(nodesIn);
            organize.bubleSortBnodes(nodes);
        }
    }

    /**
     * If destiny's list is at the limit got by the masSize - 1
     *
     * @return true
     */
    public boolean nodeFull() {
        return ((maxSize - 1) == destinys.size());
    }

    /**
     * If destiny's list is at the middle got by the masSize - 1
     *
     * @return true
     */
    public boolean semiFull() {
        return ((maxSize / 2) > destinys.size());
    }

    public destiny getDestiny(int i) {
        return destinys.get(i);
    }

    public void replaceDestiny(int i, destiny newDestiny) {
        destinys.set(i, newDestiny);
    }

    public Bnode getBnode(int i) {
        return nodes.get(i);
    }

    public void replaceBnode(int i, Bnode newNode) {
        nodes.set(i, newNode);
    }

    /**
     * return the size if the list of destinys
     *
     * @return
     */
    public int destinySize() {
        return destinys.size();
    }

    public LinkedList<destiny> getDestinys() {
        return destinys;
    }

    public void setDestinys(LinkedList<destiny> destinys) {
        this.destinys = destinys;
    }

    public LinkedList<Bnode> getNodes() {
        return nodes;
    }

    public void setNodes(LinkedList<Bnode> nodes) {
        this.nodes = nodes;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

}
