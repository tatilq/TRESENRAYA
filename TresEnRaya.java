public class TresEnRaya {
    static Tablero tablero;
    static Jugador[] jugadores;
    static Turno turno;
    static  final char FICHA_JUG_1 = 'X';
    static  final char FICHA_JUG_2 = 'O';
    public TresEnRaya() {
        turno = new Turno(); //Objeto Turno
        tablero = new Tablero(); //Objetvo Tablero
        jugadores = new Jugador[2]; //Objeto Jugador
        jugadores[0] = new Jugador(FICHA_JUG_1);
        jugadores[1] = new Jugador(FICHA_JUG_2);
    }
    public static void jugar(){
        TresEnRaya partida = new TresEnRaya(); //Para probar las funcionalidades dentro de la misma clase
        for (int i=0;i< jugadores.length;i++){
            System.out.print("-> Jugador ["+i+"] ");
            jugadores[i].putNombre();
        }
        while (jugadores[turno.quienToca()].getContador() <= 3){
            jugadores[turno.quienToca()].colocarFicha(tablero);
            turno.cambiar();
            tablero.mostrar();
        }
        while(!tablero.hayTresEnRaya()){
            jugadores[turno.quienToca()].mueveFicha(tablero);
            turno.cambiar();
            tablero.mostrar();
        }
    }

    public static void main(String[] args) {
        jugar();
    }
}
