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

    int code1;
    int code2;
    int px;
    int py;
    double price;
    int minutes;

    public route(int code1, int code2, int px, int py, double price, int minutes) {
        this.code1 = code1;
        this.code2 = code2;
        this.px = px;
        this.py = py;
        this.price = price;
        this.minutes = minutes;
    }

    public void printRoute() {
        if ((price > 0) && (minutes > 0)) {
            System.out.println("Code 1: " + this.code1 + "\tCode 2: " + this.code2 + "\tPx: " + this.px + "\tPy: " + this.py + "\tPrize: " + this.price + "\tTrip time: " + this.minutes);
            System.out.println("<^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^> <^>");
        }
    }

    public route() {
    }

    public int getCode1() {
        return code1;
    }

    public void setCode1(int code1) {
        this.code1 = code1;
    }

    public int getCode2() {
        return code2;
    }

    public void setCode2(int code2) {
        this.code2 = code2;
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
