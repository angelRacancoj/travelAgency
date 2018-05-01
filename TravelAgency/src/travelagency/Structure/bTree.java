/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency.Structure;

import FileManager.Order;
import java.util.LinkedList;
import travelagency.exceptions.errorException;
import travelagency.objects.destiny;

/**
 *
 * @author angel
 */
public class bTree {

    int order;
    Bnode root;

    Order organize;
    private destiny middleDest = new destiny();
    private Bnode newBnode;
    int nodePosicion = 0;

    public bTree() {
        this.order = 0;
        this.root = new Bnode(order);
        this.organize = new Order();
    }

    public bTree(int maxSize) {
        this.order = maxSize;
        this.root = new Bnode(maxSize);
        this.newBnode = new Bnode(maxSize);
        this.organize = new Order();
    }

    public void printBtree() {
        printTreeInorder(this.root);
    }

    private void printTreeInorder(Bnode readNode) {
        for (int i = 0; i < readNode.getDestinys().size(); i++) {
            readNode.getDestiny(i).printIt();
        }
        for (int j = 0; j < readNode.getNodes().size(); j++) {
            printTreeInorder(readNode.getBnode(j));
        }
    }

    public boolean existNode(int code) {
        nodePosicion = 0;
        if (!root.isDestinyListEmpty()) {
            return (RecursiveExistNode(root, code, 0) != null);
        } else {
            return false;
        }
    }

    // modificar la busqueda similar al RecursiveFindNode y ver si es necesario solicitar verificar que el tamaño del arreglo sea mayor a la posicion
    private destiny RecursiveExistNode(Bnode nodeIn, int code, int nodePosicion) {
        if (!(nodePosicion > order - 1) && (nodeIn.destinys.size() <= nodePosicion)) {
            if (nodeIn.getDestiny(nodePosicion).getCode() == code) {
                return nodeIn.getDestiny(nodePosicion);
            } else if ((nodeIn.getDestiny(nodePosicion).getCode() != code) && (code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion) != null)) {
                if ((code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion) != null)) {
                    return RecursiveExistNode(nodeIn.getBnode(nodePosicion), code, 0);
                } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion + 1) != null)) {
                    return RecursiveExistNode(nodeIn.getBnode(nodePosicion + 1), code, 0);
                } else {
                    return null;
                }
            } else {
                return RecursiveExistNode(nodeIn, code, nodePosicion + 1);
            }
        } else {
            return null;
        }
    }

    public Bnode findNode(int code) throws errorException {
        nodePosicion = 0;
        if (root != null) {
            return RecursiveFindNode(root, code, 0);
        } else {
            return null;
        }
    }

    private Bnode RecursiveFindNode(Bnode nodeIn, int code, int nodePosicion) throws errorException {
        if (!(nodePosicion > order - 1) && (nodeIn.destinys.size() <= nodePosicion)) {
            if (nodeIn.getNodes().isEmpty()) {
                return nodeIn;
            } else {
                if ((code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion) != null)) {
                    return RecursiveFindNode(nodeIn.getBnode(nodePosicion), code, 0);
                } else if ((nodeIn.getDestiny(nodePosicion + 1) != null) && (code > nodeIn.getDestiny(nodePosicion).getCode()) && (code > nodeIn.getDestiny(nodePosicion + 1).getCode())) {
                    return RecursiveFindNode(nodeIn, code, nodePosicion + 1);
                } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion + 1) != null)) {
                    return RecursiveFindNode(nodeIn.getBnode(nodePosicion + 1), code, 0);
                } else {
                    throw new errorException("error searching the node");
                }
            }
        } else {
            throw new errorException("error, node doesn't exist");
        }
    }

    /**
     *
     * @param code
     * @param name
     * @return
     * @throws errorException
     */
    public void addNode(int code, String name) throws errorException {
        if (!existNode(code)) {
            destiny newDestiny = new destiny(code, name);
            Bnode aux = new Bnode(order);
            aux.destinys.add(newDestiny);
            if (root == null) {
                root.addDestiny(newDestiny);
            } else {
                root = addNode(root, aux, code, 0);
            }
        } else {
            throw new errorException("Node: " + code + ", " + name + " already exist");
        }
    }
    //enviar los datos como paramentros y almancenar cuando se detecte que el hijo ya tiene 4 hijos

    private Bnode addNode(Bnode nodeIn, Bnode newDestiny, int code, int nodePosicion) throws errorException {

        if (!(nodePosicion > order - 1)) {
            if (nodeIn.isBnodesListEmpty()) {
                nodeIn = AddOrDivide(nodeIn, newDestiny);
                return nodeIn;
            } else {
                if ((code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion) != null)) {
                    Bnode auxA = nodeIn;
                    Bnode aux = addNode(nodeIn.getBnode(nodePosicion), newDestiny, code, 0);
                    if ((aux.getDestinys().size() == 1)) {
                        return AddOrDivide(nodeIn, aux);
                    } else {
                        return root;
                    }
                } else if ((nodeIn.destinys.size() > nodePosicion) && (nodeIn.getDestiny(nodePosicion + 1) != null)
                        && (code > nodeIn.getDestiny(nodePosicion).getCode()) && (code > nodeIn.getDestiny(nodePosicion + 1).getCode())) {
                    return addNode(nodeIn, newDestiny, code, (nodePosicion + 1));

                } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion + 1) != null)) {
                    Bnode aux = addNode(nodeIn.getBnode(nodePosicion), newDestiny, code, 0);
                    if ((aux.getDestinys().size() == 1)) {
                        return AddOrDivide(nodeIn, aux);
                    } else {
                        return root;
                    }
                } else {
                    throw new errorException("error adding the node");
                }
            }
        } else {
            throw new errorException("error, enable to add the node");
        }
    }

    private void addNodeEmpty(Bnode nodeIn, Bnode newDestiny, int code, int nodePosicion) throws errorException {

        if (!(nodePosicion > order - 1)) {
            if (nodeIn.isBnodesListEmpty()) {
                AddOrDivideEj(nodeIn, newDestiny);
            } else {
                if ((code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion) != null)) {
                    addNodeEmpty(nodeIn.getBnode(nodePosicion), newDestiny, code, 0);
                    if ((nodeIn.getBnode(nodePosicion).destinySize() == 1)) {
                        //add the split tree
                        Bnode auxBnodeA;
                        auxBnodeA = nodeIn.getBnode(nodePosicion);

                        nodeIn.deleteBnode(nodePosicion);
                        AddOrDivideEj(nodeIn, auxBnodeA);
                    }

                } else if ((nodeIn.destinys.size() > nodePosicion) && (nodeIn.getDestiny(nodePosicion + 1) != null)
                        && (code > nodeIn.getDestiny(nodePosicion).getCode()) && (code > nodeIn.getDestiny(nodePosicion + 1).getCode())) {
                    addNodeEmpty(nodeIn, newDestiny, code, (nodePosicion + 1));

                } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion + 1) != null)) {
                    addNodeEmpty(nodeIn.getBnode(nodePosicion), newDestiny, code, 0);
                    if ((nodeIn.getBnode(nodePosicion).destinySize() == 1)) {
                        //add the split tree
                        Bnode auxBnodeA;
                        auxBnodeA = nodeIn.getBnode(nodePosicion);

                        nodeIn.deleteBnode(nodePosicion);
                        AddOrDivideEj(nodeIn, auxBnodeA);
                    }
                } else {
                    throw new errorException("error adding the node");
                }
            }
        } else {
            throw new errorException("error, enable to add the node");
        }
    }

    private Bnode AddOrDivide(Bnode nodeIn, Bnode newDestiny) throws errorException {
        if (nodeIn.nodeFull()) {
            return dividedAndAddNode(nodeIn, newDestiny);
        } else {

            nodeIn.addDestiny(newDestiny.getDestiny(0));
            nodeIn.addBnode(newDestiny.getNodes());
            return nodeIn;
        }
    }

    private void AddOrDivideEj(Bnode nodeIn, Bnode newDestiny) throws errorException {
        if (nodeIn.nodeFull()) {
            dividedAndAddNodeEj(nodeIn, newDestiny);
        } else {

            nodeIn.addDestiny(newDestiny.getDestiny(0));
            nodeIn.addBnode(newDestiny.getNodes());
        }
    }

    private Bnode dividedAndAddNode(Bnode nodeIn, Bnode newDestiny) {

        if (nodeIn != null) {
            int size = nodeIn.getMaxSize();
            int middle = 0;

            LinkedList<destiny> help = new LinkedList<>();
            help.addAll(nodeIn.getDestinys());
            help.add(newDestiny.getDestiny(0));
            organize.bubleSortDestinys(help);

            middle = ((help.size() / 2));

            Bnode auxBnodeRoot = new Bnode(size);
            Bnode auxBnodeA = new Bnode(size);
            Bnode auxBnodeB = new Bnode(size);

            auxBnodeRoot.destinys.add(help.get(middle + 1));

            for (int i = 0; i < middle; i++) {
                auxBnodeA.addDestiny(help.get(i));
            }

            for (int j = (middle + 1); j < help.size(); j++) {
                auxBnodeB.addDestiny(help.get(j));
            }

            if (!newDestiny.isBnodesListEmpty()) {
                LinkedList<Bnode> Bhelp = new LinkedList<>();
                Bhelp.addAll(newDestiny.getNodes());
                Bhelp.add(auxBnodeA);
                Bhelp.add(auxBnodeB);
                organize.bubleSortBnodes(Bhelp);

                Bnode auxBnodeC = new Bnode(size);
                Bnode auxBnodeD = new Bnode(size);

                int Bmiddle = ((Bhelp.size() % 2) - 1);

                for (int k = 0; k <= Bmiddle; k++) {
                    auxBnodeC.addBnode(Bhelp.get(k));
                }

                for (int l = (Bmiddle + 1); l < Bhelp.size(); l++) {
                    auxBnodeC.addBnode(Bhelp.get(l));
                }

                auxBnodeRoot.addBnode(auxBnodeC);
                auxBnodeRoot.addBnode(auxBnodeD);

                return auxBnodeRoot;

            } else {
                auxBnodeRoot.addBnode(auxBnodeA);
                auxBnodeRoot.addBnode(auxBnodeB);
                return auxBnodeRoot;
            }
        } else {
            return null;
        }

    }

    private void dividedAndAddNodeEj(Bnode nodeIn, Bnode newDestiny) throws errorException {

        if (nodeIn != null) {
            int size = nodeIn.getMaxSize();
            int middle = 0;

            LinkedList<destiny> help = new LinkedList<>();
            help.addAll(nodeIn.getDestinys());
            help.add(newDestiny.getDestiny(0));
            organize.bubleSortDestinys(help);

            middle = ((help.size() / 2));

            Bnode auxBnodeRoot = new Bnode(size);
            Bnode auxBnodeA = new Bnode(size);
            Bnode auxBnodeB = new Bnode(size);

            auxBnodeRoot.destinys.add(help.get(middle + 1));

            for (int i = 0; i < middle; i++) {
                auxBnodeA.addDestiny(help.get(i));
            }

            for (int j = (middle + 1); j < help.size(); j++) {
                auxBnodeB.addDestiny(help.get(j));
            }

            if (!newDestiny.isBnodesListEmpty()) {
                LinkedList<Bnode> Bhelp = new LinkedList<>();
                Bhelp.addAll(newDestiny.getNodes());
                Bhelp.add(auxBnodeA);
                Bhelp.add(auxBnodeB);
                organize.bubleSortBnodes(Bhelp);

                Bnode auxBnodeC = new Bnode(size);
                Bnode auxBnodeD = new Bnode(size);

                int Bmiddle = ((Bhelp.size() % 2) - 1);

                for (int k = 0; k <= Bmiddle; k++) {
                    auxBnodeC.addBnode(Bhelp.get(k));
                }

                for (int l = (Bmiddle + 1); l < Bhelp.size(); l++) {
                    auxBnodeC.addBnode(Bhelp.get(l));
                }

                auxBnodeRoot.addBnode(auxBnodeC);
                auxBnodeRoot.addBnode(auxBnodeD);

                nodeIn.destinys.clear();
                nodeIn.nodes.clear();

                nodeIn.addAllDestiny(auxBnodeRoot.getDestinys());
                nodeIn.addBnode(auxBnodeRoot.getNodes());

            } else {
                auxBnodeRoot.addBnode(auxBnodeA);
                auxBnodeRoot.addBnode(auxBnodeB);

                nodeIn.nodes.clear();
                nodeIn.addBnode(auxBnodeRoot.getNodes());
            }
        }
    }

    public boolean EmptyTree() {
        return (root == null);
    }

    public Bnode getRoot() {
        return root;
    }

    public void setRoot(Bnode newRoot) {
        this.root = newRoot;
    }

    public int getOrder() {
        return order;
    }

    void setOrder(int newOrder) {
        this.order = newOrder;
    }

}

/*        if (!(nodePosicion > order - 1)) {
//            if (nodeIn.getNodes().isEmpty()) {
//                return nodeIn;
//            } else {
//                if ((code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion) != null)) {
//                    return RecursiveFindNode(nodeIn.getBnode(nodePosicion), code, 0);
//                } else if (nodeIn.getDestiny(nodePosicion + 1) != null) {
//                    if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && code > nodeIn.getDestiny(nodePosicion + 1).getCode()) {
//                        return RecursiveFindNode(nodeIn, code, nodePosicion + 1);
//                    } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion + 1) != null)) {
//                        return RecursiveFindNode(nodeIn.getBnode(nodePosicion + 1), code, 0);
//                    } else {
//                        return null;
//                    }
//                } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion + 1) != null)) {
//                    return RecursiveFindNode(nodeIn.getBnode(nodePosicion + 1), code, 0);
//                } else {
//                    return null;
//                }
//            }
//        } else {
//            return null;
        }*/
