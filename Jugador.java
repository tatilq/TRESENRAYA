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
                if(!tablero.esVacia(coord)){
                    System.out.println("-> Coordenada OCUPADA. Vuelve a intentarlo!");
                }
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
                System.out.println("-> Quita tu ficha de la posición que decidas.");
                coord = coord.pedirPorTeclado();
                if (!tablero.hayFicha(ficha,coord)){
                    System.out.println("-> Coordenada sin ficha o ocupada por otra distinta!");
                }
            }while(!tablero.hayFicha(ficha,coord));
            if (tablero.hayFicha(ficha,coord)){
                System.out.println("La ficha contenida en "+coord.toString()+" se moverá a...");
                tablero.quitaFicha(coord);
            }
            do{
                System.out.println("-> Coloca tu ficha en una nueva posición.");
                coord = coord.pedirPorTeclado();
            }while(!tablero.esVacia(coord));
            if (tablero.esVacia(coord)){
                System.out.println("La nueva posición para la ficha es "+coord.toString());
                tablero.ponFicha(ficha,coord);
            }
        }
    }
    public void haGanado (Tablero tablero){
        if (tablero.hayTresEnRaya()){
            System.out.println("Jugador: '"+this.nombre+"' HA GANADO \\^_^/!");
        }
        tablero.mostrar();
    }

    public int getContador() {
        return contador;
    }

    public char getFicha() {
        return ficha;
    }

    public String getNombre() {
        return nombre;
    }
}
