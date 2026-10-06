package Tareas.TareaSieteLista;

public class PolloAsado {
    private String estilo;
    private double precio;

    public PolloAsado(String estilo, double precio) {
        this.estilo = estilo;
        this.precio = precio;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PolloAsado pollo = (PolloAsado) obj;
        return Double.compare(pollo.precio, precio) == 0 && estilo.equals(pollo.estilo);
    }

    @Override
    public String toString() {
        return "Pollo[" + estilo + " - $" + precio + "]";
    }
}
