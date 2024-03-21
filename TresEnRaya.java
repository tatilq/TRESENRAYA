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
    public void jugar(){
        for (int i=0;i< jugadores.length;i++){
            System.out.print("-> Jugador ["+i+"] ");
            jugadores[i].putNombre();
        }
        while (jugadores[turno.quienToca()].getContador() <= 3 && !tablero.hayTresEnRaya()){
            System.out.println(">> '"+jugadores[turno.quienToca()].getNombre()+"' coloca tu ficha -> ["+jugadores[turno.quienToca()].getFicha()+"]");
            jugadores[turno.quienToca()].colocarFicha(tablero);
            turno.cambiar();
            tablero.mostrar();
        }
        while(!tablero.hayTresEnRaya()){
            System.out.println("<<REMINDER>> -> Ahora que ya están las 3 fichas de cada jugador colocadas, toca mover una ficha a otra posición!");
            System.out.println(">> '"+jugadores[turno.quienToca()].getNombre()+"' mueve y coloca tu ficha -> ["+jugadores[turno.quienToca()].getFicha()+"]");
            jugadores[turno.quienToca()].mueveFicha(tablero);
            turno.cambiar();
            tablero.mostrar();
        }
        turno.cambiar();
        jugadores[turno.quienToca()].haGanado(tablero);
    }
}
