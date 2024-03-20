import java.util.Scanner;

public class Jugador {
    String nombre;
    char ficha;
    int contador = 1;
    public Jugador (String nombre, char ficha){
        this.nombre = nombre;
        this.ficha = ficha;
    }
    public Jugador (char ficha){
        this.ficha = ficha;
    }
    public void putNombre (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriba su nombre:");
        this.nombre = sc.nextLine();
    }
    public void colocarFicha(Tablero tablero){
        Coordenada coord = new Coordenada();
        do{
            coord = coord.pedirPorTeclado();
            if (!tablero.esVacia(coord)){
                tablero.ponFicha(ficha,coord);
            }
        }while(tablero.esVacia(coord));
        contador++;
    }
    public void mueveFicha(Tablero tablero){
        Coordenada coord = new Coordenada();
        if (contador == 3){
            do{
                coord = coord.pedirPorTeclado();
                if (!tablero.hayFicha(ficha,coord)){
                    tablero.quitaFicha(coord);
                }
            }while(tablero.hayFicha(ficha,coord));


        }
    }
    public void haGanado (Tablero tablero){

    }
}
