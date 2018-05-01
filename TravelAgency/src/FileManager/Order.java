/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import java.util.LinkedList;
import travelagency.Structure.Bnode;
import travelagency.objects.destiny;

/**
 *
 * @author angel
 */
public class Order {

    public void bubleSortDestinys(LinkedList<destiny> destinysList) {
        int cambios = 0;

        do {
            cambios = 0;

            for (int i = 0; i < (destinysList.size() - 1); i++) {
                if (destinysList.get(i).getCode() > destinysList.get(i + 1).getCode()) {
                    destiny A = destinysList.get(i);
                    destiny B = destinysList.get(i + 1);
                    destinysList.set(i, B);
                    destinysList.set(i + 1, A);
                    cambios++;
                }
            }
        } while (cambios > 0);
    }

    public void bubleSortBnodes(LinkedList<Bnode> BnodeList) {
        int cambios = 0;

        do {
            cambios = 0;

            for (int i = 0; i < (BnodeList.size() - 1); i++) {
                if (BnodeList.get(i).getDestiny(0).getCode() > BnodeList.get(i + 1).getDestiny(0).getCode()) {
                    Bnode A = BnodeList.get(i);
                    Bnode B = BnodeList.get(i + 1);
                    BnodeList.set(i, B);
                    BnodeList.set(i + 1, A);
                    cambios++;
                }
            }
        } while (cambios > 0);
    }

}
