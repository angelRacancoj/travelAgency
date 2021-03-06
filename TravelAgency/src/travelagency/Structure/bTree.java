/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency.Structure;

import FileManager.ManejadorArchivo;
import FileManager.Order;
import java.io.IOException;
import java.util.LinkedList;
import travelManager.travelAndRoute;
import travelagency.exceptions.errorException;
import travelagency.objects.destiny;

/**
 *
 * @author angel
 */
public class bTree {

    String textOut = "";
    ManejadorArchivo files;

    int numNodes;
    int order;
    Bnode root;

    travelAndRoute travelList;
    Order organize;
    int nodePosicion = 0;

    public bTree(int maxSize, travelAndRoute newTR) {
        this.order = maxSize;
        this.root = new Bnode(maxSize);
        this.organize = new Order();
        numNodes = 0;
        this.travelList = newTR;
        files = new ManejadorArchivo();
    }

    public void printBtree() {
        printTreeInorder(this.root);
    }

    /**
     * this method is designed to be used in frames
     *
     * @param code1
     * @param code2
     * @param price
     * @param time
     * @throws errorException
     */
    public void addTR(int code1, int code2, double price, int time) throws errorException {
        destiny auxA = RecursiveExistNodeEj(root, code1, 0);
        destiny auxB = RecursiveExistNodeEj(root, code2, 0);

        if ((auxA != null) && (auxB != null)) {
            travelList.setRoute(auxA, auxB, code1, code2, price, time);
        } else {
            throw new errorException("Invalid codes: " + code1 + ", " + code2);
        }
    }

    /**
     * This method was designed to be used in the entry file
     *
     * @param code1In
     * @param code2In
     * @param priceIn
     * @param timeIn
     * @throws errorException
     */
    public void addTR(String code1In, String code2In, String priceIn, String timeIn) throws errorException {
        int code1 = Integer.parseInt(code1In);
        int code2 = Integer.parseInt(code2In);
        double price = Double.parseDouble(priceIn);
        int time = Integer.parseInt(timeIn);

        destiny auxA = RecursiveExistNodeEj(root, code1, 0);
        destiny auxB = RecursiveExistNodeEj(root, code2, 0);

        if ((auxA != null) && (auxB != null)) {
            travelList.setRoute(auxA, auxB, code1, code2, price, time);
        } else {
            throw new errorException("Invalid codes: " + code1 + ", " + code2);
        }
    }

    private void printTreeInorder(Bnode readNode) {
        for (int i = 0; i < readNode.getDestinys().size(); i++) {
            readNode.getDestiny(i).printIt();
        }
        for (int j = 0; j < readNode.getNodes().size(); j++) {
            printTreeInorder(readNode.getBnode(j));
        }
    }

    public boolean existNode(int code) throws errorException {
        nodePosicion = 0;
        if (!root.isDestinyListEmpty()) {
            return (RecursiveExistNodeEj(root, code, 0) != null);
        } else {
            return false;
        }
    }

    /**
     * this method is designed to be use in the frames
     *
     * @param code
     * @param name
     * @throws errorException
     */
    public void addNode(int code, String name) throws errorException {

        destiny newDestiny = new destiny(code, name, 0);
        Bnode aux = new Bnode(order);
        aux.destinys.add(newDestiny);
        if (root.isDestinyListEmpty()) {
            root.addDestiny(newDestiny);
            travelList.addRows(numNodes);
            numNodes++;
        } else {
            if (!existNode(code)) {
                newDestiny.setPosicion(numNodes);
                addNodeEmpty(root, aux, code, 0);
                travelList.addRows(numNodes);
                numNodes++;
            } else {
                throw new errorException("Node: " + code + ", " + name + " already exist");
            }
        }

    }

    /**
     * this method take all data as an String to add to the tree
     *
     * @param codeSt
     * @param name
     * @throws errorException
     */
    public void addNode(String codeSt, String name) throws errorException {

        int code = Integer.valueOf(codeSt);

        destiny newDestiny = new destiny(code, name, 0);
        Bnode aux = new Bnode(order);
        aux.destinys.add(newDestiny);
        if (root.isDestinyListEmpty()) {
            root.addDestiny(newDestiny);
            travelList.addRows(numNodes);
            numNodes++;
        } else {
            if (!existNode(code)) {
                newDestiny.setPosicion(numNodes);
                addNodeEmpty(root, aux, code, 0);
                travelList.addRows(numNodes);
                numNodes++;
            } else {
                throw new errorException("Node: " + code + ", " + name + " already exist");
            }
        }

    }

    /**
     * this method find the destiny by a recursive way
     *
     * @param nodeIn
     * @param code
     * @param nodePosicion
     * @return
     * @throws errorException
     */
    public destiny RecursiveExistNodeEj(Bnode nodeIn, int code, int nodePosicion) throws errorException {

        if (!(nodePosicion > order - 1)) {
            if (nodeIn.getDestiny(nodePosicion).getCode() == code) {
                return nodeIn.getDestiny(nodePosicion);
            } else if (nodeIn.isBnodesListEmpty()) {
                boolean found = false;
                int i = 0;
                do {
                    if (nodeIn.getDestiny(i).getCode() == code) {
                        return nodeIn.getDestiny(i);
                    }
                    i++;
                } while (!found && (i < nodeIn.destinySize()));
                return null;
            } else {
                if ((code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn == root) && (nodeIn.getDestinys().size() == 1) && (!nodeIn.isBnodesListEmpty())) {
                    return RecursiveExistNodeEj(nodeIn.getBnode(nodePosicion), code, 0);

                } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn == root) && (nodeIn.getDestinys().size() == 1) && (!nodeIn.isBnodesListEmpty())) {
                    return RecursiveExistNodeEj(nodeIn.getBnode(nodePosicion + 1), code, 0);

                } else if ((code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion) != null)) {
                    return RecursiveExistNodeEj(nodeIn.getBnode(nodePosicion), code, 0);

                } else if (((nodeIn.destinys.size() - 1) > nodePosicion) && (code > nodeIn.getDestiny(nodePosicion).getCode())
                        && (code > nodeIn.getDestiny(nodePosicion + 1).getCode()) && (nodeIn.getDestiny(nodePosicion + 1) != null)) {
                    return RecursiveExistNodeEj(nodeIn, code, nodePosicion + 1);

                } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion + 1) != null)) {
                    return RecursiveExistNodeEj(nodeIn.getBnode(nodePosicion + 1), code, 0);

                } else {
                    throw new errorException("error adding the node");
                }
            }
        } else {
            throw new errorException("error, enable to add the node");
        }
    }

    //enviar los datos como paramentros y almancenar cuando se detecte que el hijo ya tiene 4 hijos
    private void addNodeEmpty(Bnode nodeIn, Bnode newDestiny, int code, int nodePosicion) throws errorException {

        if (!(nodePosicion > order - 1)) {
            if (nodeIn.isBnodesListEmpty()) {
                AddOrDivideEj(nodeIn, newDestiny);
            } else {
                if ((code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn == root) && (nodeIn.getDestinys().size() == 1)) {
                    addNodeEmpty(nodeIn.getBnode(nodePosicion), newDestiny, code, 0);
                    if ((nodeIn.getBnode(nodePosicion).destinySize() == 1)) {
                        //add the split tree
                        Bnode auxBnodeA;
                        auxBnodeA = nodeIn.getBnode(nodePosicion);

                        nodeIn.deleteBnode(nodePosicion);
                        AddOrDivideEj(nodeIn, auxBnodeA);
                    }
                } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn == root) && (nodeIn.getDestinys().size() == 1)) {
                    addNodeEmpty(nodeIn.getBnode(nodePosicion + 1), newDestiny, code, 0);
                    if ((nodeIn.getBnode(nodePosicion + 1).destinySize() == 1)) {
                        //add the split tree
                        Bnode auxBnodeA;
                        auxBnodeA = nodeIn.getBnode(nodePosicion + 1);

                        nodeIn.deleteBnode(nodePosicion + 1);
                        AddOrDivideEj(nodeIn, auxBnodeA);
                    }
                } else if ((code < nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion) != null)) {
                    addNodeEmpty(nodeIn.getBnode(nodePosicion), newDestiny, code, 0);
                    if ((nodeIn.getBnode(nodePosicion).destinySize() == 1)) {
                        //add the split tree
                        Bnode auxBnodeA;
                        auxBnodeA = nodeIn.getBnode(nodePosicion);

                        nodeIn.deleteBnode(nodePosicion);
                        AddOrDivideEj(nodeIn, auxBnodeA);
                    }

                } else if (((nodeIn.destinys.size() - 1) > nodePosicion) && (code > nodeIn.getDestiny(nodePosicion).getCode())
                        && (code > nodeIn.getDestiny(nodePosicion + 1).getCode()) && (nodeIn.getDestiny(nodePosicion + 1) != null)) {
                    addNodeEmpty(nodeIn, newDestiny, code, (nodePosicion + 1));

                } else if ((code > nodeIn.getDestiny(nodePosicion).getCode()) && (nodeIn.getBnode(nodePosicion + 1) != null)) {
                    addNodeEmpty(nodeIn.getBnode(nodePosicion + 1), newDestiny, code, 0);
                    if ((nodeIn.getBnode(nodePosicion + 1).destinySize() == 1)) {
                        //add the split tree
                        Bnode auxBnodeA;
                        auxBnodeA = nodeIn.getBnode(nodePosicion + 1);

                        nodeIn.deleteBnode(nodePosicion + 1);
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

    private void AddOrDivideEj(Bnode nodeIn, Bnode newDestiny) throws errorException {
        if (nodeIn.nodeFull()) {
            dividedAndAddNodeEj(nodeIn, newDestiny);
        } else {

            nodeIn.addDestiny(newDestiny.getDestiny(0));
            nodeIn.addBnode(newDestiny.getNodes());
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

            auxBnodeRoot.destinys.add(help.get(middle));

            for (int i = 0; i < middle; i++) {
                auxBnodeA.addDestiny(help.get(i));
            }

            for (int j = (middle + 1); j < help.size(); j++) {
                auxBnodeB.addDestiny(help.get(j));
            }

            if (!newDestiny.isBnodesListEmpty()) {
                LinkedList<Bnode> Bhelp = new LinkedList<>();
                Bhelp.addAll(newDestiny.getNodes());
                Bhelp.addAll(nodeIn.getNodes());
                organize.bubleSortBnodes(Bhelp);

                Bnode auxBnodeC = new Bnode(size);
                Bnode auxBnodeD = new Bnode(size);

                int Bmiddle = ((Bhelp.size() / 2));

                for (int k = 0; k < Bmiddle; k++) {
                    auxBnodeC.addBnode(Bhelp.get(k));
                }

                for (int l = (Bmiddle); l < Bhelp.size(); l++) {
                    auxBnodeD.addBnode(Bhelp.get(l));
                }

                auxBnodeA.addBnode(auxBnodeC.getNodes());
                auxBnodeB.addBnode(auxBnodeD.getNodes());

                auxBnodeRoot.addBnode(auxBnodeA);
                auxBnodeRoot.addBnode(auxBnodeB);

                nodeIn.destinys.clear();
                nodeIn.nodes.clear();

                nodeIn.addAllDestiny(auxBnodeRoot.getDestinys());
                nodeIn.addBnode(auxBnodeRoot.getNodes());

            } else {
                auxBnodeRoot.addBnode(auxBnodeA);
                auxBnodeRoot.addBnode(auxBnodeB);

                nodeIn.nodes.clear();
                nodeIn.destinys.clear();
                nodeIn.addBnode(auxBnodeRoot.getNodes());
                nodeIn.addAllDestiny(auxBnodeRoot.getDestinys());
            }
        }
    }

    /**
     * show the bTree using graph
     *
     * @throws IOException
     */
    public void treeGraphLR() throws IOException {
        textOut = "";
        textOut = "digraph G { \ngraph [rankdir = \"LR\"];\nnode [shape = record,height=.1];\n";
        treeText(root);
        textOut += "}";
        files.guardarArchivo("/home/angel/grafica.dot", textOut);

        files.runGraphviz("/home/angel/grafica");
    }

    public void treeGraph() throws IOException {
        textOut = "";
        textOut = "digraph G {\nnode [shape = record,height=.1];\n";
        treeText(root);
        textOut += "}";
        files.guardarArchivo("/home/angel/grafica1.dot", textOut);

        files.runGraphviz("/home/angel/grafica1");
    }

    public void treeGraphPrueba() throws IOException {
        textOut = "";
        textOut = "digraph G {\nsubgraph cluster1{\nnode [shape = record,height=.1];\n";
        treeText(root);
        textOut += "}\n";
        textOut += "subgraph cluster2{ \ngraph [rankdir = \"LR\"];\nnode [shape = record,height=.1];\n";
        treeTextLR(root);
        textOut += "}\n}";
        files.guardarArchivo("/home/angel/grafica.dot", textOut);

        files.runGraphviz("/home/angel/grafica");
    }

    private void treeText(Bnode readNode) {
        textOut += ("node" + readNode.getDestiny(0).getName() + readNode.getDestiny(0).getCode() + "[shape=record, label = \"");
        for (int i = 0; i < readNode.getDestinys().size(); i++) {
            readNode.getDestiny(i).printIt();
            if (i == 0) {
                textOut += ("{<f0>" + readNode.getDestiny(i).getName() + "|<f1>" + readNode.getDestiny(i).getCode() + "}|");
            } else if (i != (readNode.getDestinys().size() - 1)) {
                textOut += ("{" + readNode.getDestiny(i).getName() + "|" + readNode.getDestiny(i).getCode() + "}|");
            } else {
                textOut += ("{" + readNode.getDestiny(i).getName() + "|" + readNode.getDestiny(i).getCode() + "}\"];\n");
            }
        }
        for (int j = 0; j < readNode.getNodes().size(); j++) {
            textOut += ("\"node" + readNode.getDestiny(0).getName() + readNode.getDestiny(0).getCode()
                    + "\":f1 -> \"node" + readNode.getBnode(j).getDestiny(0).getName() + readNode.getBnode(j).getDestiny(0).getCode() + "\":f0;\n");
            treeText(readNode.getBnode(j));
        }
    }

    private void treeTextLR(Bnode readNode) {
        textOut += ("node" + readNode.getDestiny(0).getName() + readNode.getDestiny(0).getCode() + "LR [shape=record, label = \"");
        for (int i = 0; i < readNode.getDestinys().size(); i++) {
            readNode.getDestiny(i).printIt();
            if (i == 0) {
                textOut += ("{<f0>" + readNode.getDestiny(i).getName() + "|<f1>" + readNode.getDestiny(i).getCode() + "}|");
            } else if (i != (readNode.getDestinys().size() - 1)) {
                textOut += ("{" + readNode.getDestiny(i).getName() + "|" + readNode.getDestiny(i).getCode() + "}|");
            } else {
                textOut += ("{" + readNode.getDestiny(i).getName() + "|" + readNode.getDestiny(i).getCode() + "}\"];\n");
            }
        }
        for (int j = 0; j < readNode.getNodes().size(); j++) {
            textOut += ("\"node" + readNode.getDestiny(0).getName() + readNode.getDestiny(0).getCode()
                    + "LR\":f1 -> \"node" + readNode.getBnode(j).getDestiny(0).getName() + readNode.getBnode(j).getDestiny(0).getCode() + "LR\":f0;\n");
            treeTextLR(readNode.getBnode(j));
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

    public int getNumNodes() {
        return numNodes;
    }

    public void setNumNodes(int numNodes) {
        this.numNodes = numNodes;
    }

}
