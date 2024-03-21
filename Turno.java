public class Turno {
    static int turno; //Variará entre 0 y 1
    public Turno(){
        turno = 0; //Se inicizaliza en 0
    }
    public int quienToca(){
        return turno;
    }
    public int quienNoToca(){
        return (turno == 0) ? 1 : 0;
    }
    public void cambiar(){
        if (turno == 0){
            turno = 1;
        } else if (turno == 1){
            turno = 0;
        }
    }
}
