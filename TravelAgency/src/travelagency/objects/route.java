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
public class route {

    destiny destinyA;
    destiny destinyB;
    int px;
    int py;
    double price;
    int minutes;

    public route(destiny destA, destiny destB, int px, int py, double price, int minutes) {
        this.destinyA = destA;
        this.destinyB = destB;
        this.px = px;
        this.py = py;
        this.price = price;
        this.minutes = minutes;
    }

    public void printRoute() {
        if ((price > 0) && (minutes > 0)) {
            System.out.println("Code 1: " + this.destinyA.getCode() + "\tCode 2: " + this.destinyB.getCode() + "\tPx: " + this.px + "\tPy: " + this.py + "\tPrize: " + this.price + "\tTrip time: " + this.minutes);
            System.out.println("<^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^>");
        }
    }

    public route() {
    }

    public destiny getDestinyA() {
        return destinyA;
    }

    public void setDestinyA(destiny destinyA) {
        this.destinyA = destinyA;
    }

    public destiny getDestinyB() {
        return destinyB;
    }

    public void setDestinyB(destiny destinyB) {
        this.destinyB = destinyB;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

}
