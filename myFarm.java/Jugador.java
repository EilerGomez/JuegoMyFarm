import javax.swing.JLabel;
public class Jugador{
    public static int edad=0;
    public static String nombre="";
    public static String nombreenjuego="";
    public static double vida=100;
    public static double monedasOro=1000;
    public static double puntos=0; 
    public static double maiz;
    public static double manzanas;
    public static double criasDeVacas;
    public static double criasDeGallinas;
    public static double gallinasVender;
    public static double vacasVender;
    public static double afrecho; 
    public static double trigo;
    public static double pasto;
    public static double lecheVaca;
    public static double cueroVaca;
    public static double carneVaca;
    public static double carneGallina;
    public static double huevosGallina;
    public static JLabel tuVida;
    //public static TiempoVida tmv = new TiempoVida();
    //public static Thread tiempoVida = new Thread(Jugador.tmv);
    //public static Thread tiempoVida1 = new Thread(Jugador.tmv);


    public Jugador(JLabel tuVida){
        this.tuVida = tuVida;
    }
    public Jugador(){

    }

    public String getNombre(){
        return this.nombre;
    }
    public String getNombreenjuego(){
        return this.nombreenjuego;
    }
    public int getEdad(){
        return this.edad;
    }
    public void setMonedasOro(double monedasOro){
        this.monedasOro = monedasOro;
    }

    

}