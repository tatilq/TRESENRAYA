import java.util.Scanner;

public class Jugador {
    private String nombre;
    private char ficha;
    private int contador = 1;
    public Jugador (String nombre, char ficha){
        this.nombre = nombre;
        this.ficha = ficha;
    }
    public Jugador (char ficha){
        this.ficha = ficha;
    }
    public void putNombre (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriba su nombre: ");
        this.nombre = sc.nextLine();
    }
    public void colocarFicha(Tablero tablero){
        if (contador <= 3){
            Coordenada coord = new Coordenada();
            do{
                coord = coord.pedirPorTeclado();
            }while(!tablero.esVacia(coord));
            if (tablero.esVacia(coord)){
                tablero.ponFicha(ficha,coord);
            }
        }
        if (this.contador >= 3){
            this.contador = 3;
        }
        this.contador++;
    }
    public void mueveFicha(Tablero tablero){
        Coordenada coord = new Coordenada();
        if (this.contador >= 3){
            this.contador = 3;
        }
        if (this.contador == 3){
            do{
                coord = coord.pedirPorTeclado();
            }while(!tablero.hayFicha(ficha,coord));
            if (tablero.hayFicha(ficha,coord)){
                tablero.quitaFicha(coord);
            }
            do{
                coord = coord.pedirPorTeclado();
            }while(!tablero.esVacia(coord));
            if (tablero.esVacia(coord)){
                tablero.ponFicha(ficha,coord);
            }
        }
    }
    public void haGanado (Tablero tablero){
        if (tablero.hayTresEnRaya()){
            System.out.println("El jugador '"+this.nombre+"' es el ganador!");
        }
        tablero.mostrar();
    }

    public int getContador() {
        return contador;
    }
}
