public class Tablero {
    char[][] tablero;
    int filas;
    int columnas;

    public Tablero(){
        filas = 3;
        columnas = 3;
        tablero = new char[filas][columnas];
        for (int i=0;i<filas;i++){
            for (int j=0;j<columnas;j++){
                tablero[i][j] = '_';
            }
        }
    }
    public void ponFicha(char ficha, Coordenada coord){
        tablero[coord.getFila()][coord.getColumna()] = ficha;
    }
    public void quitaFicha(Coordenada coord){
        tablero[coord.getFila()][coord.getColumna()] = '_';
    }
    public boolean esVacia (Coordenada coord){
        return tablero[coord.getFila()][coord.getColumna()] == '_';
    }
    public boolean hayFicha (char ficha, Coordenada coord){
        return tablero[coord.getFila()][coord.getColumna()] == ficha;
    }
    public boolean hayTresEnRaya (){
        for (int i=0;i<tablero.length;i++){
            if ((tablero[i][0] != '_') //Filas
                    && (tablero[i][0] == tablero[i][1])
                    && (tablero[i][0] == tablero[i][2])){
                return true;
            }
            if ((tablero[0][i] != '_') //Columnas
                    && (tablero[0][i] == tablero[1][i])
                    && (tablero[0][i] == tablero[2][i])){
                return true;
            }
        }
        if ((tablero[0][0] != '_') //Diagonal principal
            && (tablero[0][0] == tablero[1][1])
            && (tablero[0][0] == tablero[2][2])){
            return true;
        }
        if ((tablero[0][2] != '_') //Diagonal secundaria
                && (tablero[0][2] == tablero[1][1])
                && (tablero[0][2] == tablero[2][0])){
            return true;
        }
        return false;
    }
    public void mostrar(){
        for (int i=0;i<filas;i++){
            System.out.println();
            for (int j=0;j<columnas;j++){
                System.out.print(tablero[i][j]);
            }
        }
    }
}
