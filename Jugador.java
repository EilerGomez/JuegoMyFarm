public class Jugador{
    public static int edad=0;
    public static String nombre="";
    public static String nombreenjuego="";
    public static double vida;
    public static double monedasOro=50;
    public static double puntos=30; 
    public static double maiz;
    public static double manzanas;
    public static double criasDeVacas;
    public static double criasDeGallinas;
    public static double gallinasVender;
    public static double vacasVender;
    public static double afrecho; 
    public static double trigo;
    public static double pasto;
    public static double huevos;
    public static double cuero;
    public static double carneVaca;
    public static double carneGallina;
    public static double huevosGallina;

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