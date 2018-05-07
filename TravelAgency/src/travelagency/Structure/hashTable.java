/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency.Structure;

import java.util.LinkedList;
import travelagency.exceptions.errorException;
import travelagency.objects.reservacion;

/**
 *
 * @author angel
 */
public class hashTable {

    int tableSize = 30;
    LinkedList<reservacion> RSlist;

    public hashTable() {
        RSlist = new LinkedList<>();
        setInitSize();
    }

    private void setInitSize() {
        for (int i = 0; i < tableSize; i++) {
            RSlist.add(new reservacion());
        }
    }

    public void setReservacion(reservacion newRS) throws errorException {
        if (isTableFull()) {
            reHash();
            setReservacion(newRS);
        } else {
            int posicion = newRS.getNoReservacion() % tableSize;
            if (isEmpty(posicion) && (getReservacion(posicion) == null)) {
                RSlist.get(posicion).setClientName(newRS.getClientName());
                RSlist.get(posicion).setNoReservacion(newRS.getNoReservacion());
                RSlist.get(posicion).setRoute1(newRS.getRoute1());
                if (newRS.getRoute2() != null) {
                    RSlist.get(posicion).setRoute2(newRS.getRoute2());
                }

                if (newRS.getRoute3() != null) {
                    RSlist.get(posicion).setRoute3(newRS.getRoute2());
                }
            } else {
                int i = 1;
                int newPosicion = 0;
                do {
                    newPosicion = (newRS.getNoReservacion() + 2 * i) % tableSize;

                    if (isEmpty(newPosicion)) {
                        RSlist.get(newPosicion).setClientName(newRS.getClientName());
                        RSlist.get(newPosicion).setNoReservacion(newRS.getNoReservacion());
                        RSlist.get(newPosicion).setRoute1(newRS.getRoute1());
                        if (newRS.getRoute2() != null) {
                            RSlist.get(newPosicion).setRoute2(newRS.getRoute2());
                        }

                        if (newRS.getRoute3() != null) {
                            RSlist.get(newPosicion).setRoute3(newRS.getRoute2());
                        }
                        break;
                    }
                    i++;

                } while (newPosicion < tableSize);

                if (newPosicion > tableSize) {
                    throw new errorException("can't add the reservacion, table almost full");
                }
            }
        }
    }

    public reservacion getReservacion(int reservacionNum) {
        int posicion = reservacionNum % tableSize;

        if (!isEmpty(posicion)) {
            if (RSlist.get(posicion).getNoReservacion() == reservacionNum) {
                return RSlist.get(posicion);
            } else {
                int i = 1;
                int newPosicion = 0;
                do {
                    newPosicion = (reservacionNum + 2 * i) % tableSize;

                    if (!isEmpty(newPosicion) && (RSlist.get(newPosicion).getNoReservacion() == reservacionNum)) {
                        return RSlist.get(posicion);
                    }
                    i++;

                } while (newPosicion < tableSize);

                return null;
            }
        } else {
            return null;
        }
    }

    private void reHash() throws errorException {
        LinkedList<reservacion> auxList = new LinkedList<>();
        auxList.addAll(RSlist);
        tableSize = RSlist.size() * 2;
        RSlist.clear();
        setInitSize();

        for (int i = 0; i < auxList.size(); i++) {
            setReservacion(auxList.get(i));
        }
    }

    public boolean isTableFull() {
        return (numeOfNodes() / RSlist.size() > .75);
    }

    private int numeOfNodes() {
        int numNodes = 0;
        for (int i = 0; i < RSlist.size(); i++) {
            if (!isEmpty(i)) {
                numNodes++;
            }
        }
        return numNodes;
    }

    private boolean isEmpty(int posicion) {
        return (RSlist.get(posicion).getClientName().replaceAll(" ", "").replaceAll("\t", "").equalsIgnoreCase("") && (RSlist.get(posicion).getNoReservacion() == 0));
    }
}
