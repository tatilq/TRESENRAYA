public class Turno {
    //ATRIBUTOS

    public int turno;
    //CONSTRUCTOR
    public Turno()
    {

    }

    //METODOS
    public void setTurno(int turno)
    {
       this.turno = turno;
    }
    public int getTurno()
    {
        return turno;
    }
    // devuelve el valor actual del atributo “turno”
    public int quienToca()
    {
        return this.turno;
    }
    // devuelve el valor opuesto al que contiene el atributo “turno”
    public int quienNoToca( )
    {
        return this.turno;
    }
    //cambia el valor del atributo “turno”.
    public void cambiar( )
    {

    }

}

