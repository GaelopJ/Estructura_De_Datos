package Tareas.TareaTresArrayADT2D.GameOfLife;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        ArchivoJuegoDeLaVida juego = new ArchivoJuegoDeLaVida();
        juego.leerContenidoCSV();
        juego.imprimir();
        while (true){
            System.out.println();
            juego.cambioDeGeneracion();
            Thread.sleep(1000);

        }

    }

}
