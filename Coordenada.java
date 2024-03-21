import java.util.Scanner;

public class Coordenada {
    private int fila;
    private int columna;

    //Constructor
    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    public Coordenada() {
    }
    //Metodos getters
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    public Coordenada pedirPorTeclado (){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el valor de la fila: ");
        int fila = teclado.nextInt();
        System.out.print("Introduce el valor de la columna: ");
        int columna = teclado.nextInt();
        return new Coordenada(fila, columna);
    }

    @Override
    public String toString() {
        return "("+this.fila+","+this.columna+")";
    }
}
