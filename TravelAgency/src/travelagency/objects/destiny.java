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
public class destiny {

    int code;
    String name;

    public destiny(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public void clear() {
        code = 0;
        name = "";
    }

    public destiny() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printIt() {
        System.out.println("¬.¬ ¬.¬ ¬.¬ ¬.¬ ¬.¬ ¬.¬ ¬.¬");
        System.out.println("Name: " + name);
        System.out.println("Code: " + code);
    }

}
