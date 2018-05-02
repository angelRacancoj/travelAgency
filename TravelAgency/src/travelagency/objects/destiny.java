package travelagency.objects;

/**
 *
 * @author angel
 */
public class destiny {

    int code;
    String name;
    int posicion;

    public destiny(int code, String name, int posicion) {
        this.code = code;
        this.name = name;
        this.posicion = posicion;
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

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void printIt() {
        System.out.println("¬.¬ ¬.¬ ¬.¬ ¬.¬ ¬.¬ ¬.¬ ¬.¬");
        System.out.println("Name: " + name);
        System.out.println("Code: " + code);
    }
}
