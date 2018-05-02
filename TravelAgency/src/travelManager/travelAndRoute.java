package travelManager;

import java.util.LinkedList;
import travelagency.exceptions.errorException;
import travelagency.objects.route;

/**
 *
 * @author angel
 */
public class travelAndRoute {

    int dimension;
    LinkedList<LinkedList<route>> adyacentMatrix;

    public travelAndRoute() {
        this.adyacentMatrix = new LinkedList<>();
        this.dimension = 0;
    }

    public void addRows(int size) {
        dimension = size + 1;
        adyacentMatrix.add(new LinkedList<>());
        if (size < adyacentMatrix.size()) {
            for (int i = 0; i < dimension; i++) {
                route routeAux = new route();
                adyacentMatrix.get(adyacentMatrix.size() - 1).add(routeAux);
            }
            redimension();
        }
    }

    private void redimension() {
        int lastSize = adyacentMatrix.getLast().size();
        int matrixSize = adyacentMatrix.size();
        for (int i = 0; i < matrixSize; i++) {
            int listSize = adyacentMatrix.get(i).size();
            for (int j = listSize; j < lastSize; j++) {
                adyacentMatrix.get(i).add(new route());
            }
        }
    }

    // revisar xq lo agrega los datos
    public void setRoute(int code1, int code2, int px, int py, double prize, int minute) throws errorException {
        if ((code1 < adyacentMatrix.size())) {
            if (code2 < adyacentMatrix.get(code1).size()) {
                if ((prize != 0) && (minute != 0)) {
                    adyacentMatrix.get(code1).get(code2).setCode1(code1);
                    adyacentMatrix.get(code1).get(code2).setCode2(code2);
                    adyacentMatrix.get(code1).get(code2).setPx(px);
                    adyacentMatrix.get(code1).get(code2).setPy(py);
                    adyacentMatrix.get(code1).get(code2).setCode2(code2);
                    adyacentMatrix.get(code1).get(code2).setMinutes(minute);
                    adyacentMatrix.get(code1).get(code2).setPrice(prize);

                    adyacentMatrix.get(code2).get(code1).setCode1(code2);
                    adyacentMatrix.get(code2).get(code1).setCode2(code1);
                    adyacentMatrix.get(code2).get(code1).setPx(py);
                    adyacentMatrix.get(code2).get(code1).setPy(px);
                    adyacentMatrix.get(code2).get(code1).setMinutes(minute);
                    adyacentMatrix.get(code2).get(code1).setPrice(prize);
                } else {
                    throw new errorException("Invalid atributs");
                }
            } else {
                throw new errorException("Invalid columm");
            }
        } else {
            throw new errorException("Invalid row");
        }
    }

    public void cleanRoute(int code1, int code2, int px, int py, double prize, int minute) throws errorException {
        if ((code1 < adyacentMatrix.size())) {
            if (code2 < adyacentMatrix.get(code1).size()) {
                if ((prize != 0) && (minute != 0)) {
                    adyacentMatrix.get(code1).get(code2).setCode1(0);
                    adyacentMatrix.get(code1).get(code2).setCode2(0);
                    adyacentMatrix.get(code1).get(code2).setPx(0);
                    adyacentMatrix.get(code1).get(code2).setPy(0);
                    adyacentMatrix.get(code1).get(code2).setMinutes(0);
                    adyacentMatrix.get(code1).get(code2).setPrice(0);

                    adyacentMatrix.get(code2).get(code1).setCode1(0);
                    adyacentMatrix.get(code2).get(code1).setCode2(0);
                    adyacentMatrix.get(code2).get(code1).setPx(0);
                    adyacentMatrix.get(code2).get(code1).setPy(0);
                    adyacentMatrix.get(code2).get(code1).setMinutes(0);
                    adyacentMatrix.get(code2).get(code1).setPrice(0);
                } else {
                    throw new errorException("Invalid atributs");
                }
            } else {
                throw new errorException("Invalid columm");
            }
        } else {
            throw new errorException("Invalid row");
        }
    }

    public void printMatrix() {
        int matrixSize = adyacentMatrix.size();
        for (int i = 0; i < matrixSize; i++) {
            int listSize = adyacentMatrix.get(i).size();
            for (int j = 0; j < listSize; j++) {
                adyacentMatrix.get(i).get(j).printRoute();
            }
            System.out.println("ççççççççççççççççççççççççççççççççççççççççççççççççççççççççççççççççççççççç");
        }
    }
}
