/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency.objects;

/**
 *
 * @author angel
 */
public class reservacion {

    String clientName;
    int noReservacion;

    destiny init;
    destiny end;

    route route1;
    route route2;
    route route3;

    public reservacion(String clientName, int noReservacion, destiny init, destiny end, route route1, route route2, route route3) {
        this.clientName = clientName;
        this.noReservacion = noReservacion;
        this.init = init;
        this.end = end;
        this.route1 = route1;
        this.route2 = route2;
        this.route3 = route3;
    }

    public reservacion(String clientName, int noReservacion, destiny init, destiny end, route route1, route route2) {
        this.clientName = clientName;
        this.noReservacion = noReservacion;
        this.init = init;
        this.end = end;
        this.route1 = route1;
        this.route2 = route2;
    }

    public reservacion(String clientName, int noReservacion, destiny init, destiny end, route route1) {
        this.clientName = clientName;
        this.noReservacion = noReservacion;
        this.init = init;
        this.end = end;
        this.route1 = route1;
    }

    public reservacion() {
        this.clientName = "";
        this.noReservacion = 0;
    }

    public void cleanReservacion() {
        this.clientName = "";
        this.noReservacion = 0;
        this.route1 = null;
        this.route2 = null;
        this.route3 = null;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getNoReservacion() {
        return noReservacion;
    }

    public void setNoReservacion(int noReservacion) {
        this.noReservacion = noReservacion;
    }

    public route getRoute1() {
        return route1;
    }

    public void setRoute1(route route1) {
        this.route1 = route1;
    }

    public route getRoute2() {
        return route2;
    }

    public void setRoute2(route route2) {
        this.route2 = route2;
    }

    public route getRoute3() {
        return route3;
    }

    public void setRoute3(route route3) {
        this.route3 = route3;
    }

}
