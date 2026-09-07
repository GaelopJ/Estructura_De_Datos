package Tareas.TareaTresArrayADT2D.Ajedrez;

public class Pieza {
    private String nombre;
    private String charUnicode;
    private String color;

    @Override
    public String toString() {
        return "Pieza{" +
                "nombre='" + nombre + '\'' +
                ", charUnicode='" + charUnicode + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCharUnicode() {
        return charUnicode;
    }

    public void setCharUnicode(String charUnicode) {
        this.charUnicode = charUnicode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Pieza(String nombre, String charUnicode, String color) {
        this.nombre = nombre;
        this.charUnicode = charUnicode;
        this.color = color;
    }
}

