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
    int price;
    int minutes;

    public route(int code1, int code2, int price, int minutes) {
        this.code1 = code1;
        this.code2 = code2;
        this.price = price;
        this.minutes = minutes;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

}
