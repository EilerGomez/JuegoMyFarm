import javax.swing.*;
public class Cosecha extends Thread{
    public static double maizquintales=0;
    public static double cosechaMaiz=0;
    public static double aumentoMaiz=0;
    public double contador;
    public static String tipplanta;
    javax.swing.JLabel plantasCreciendo;
    javax.swing.JLabel maizCosechado;
    javax.swing.JLabel maizPlantado;
    String planta;
    public int contadorLimpieza;
    public double celdamaiz;
    public double celdaSembrarMaiz;
    public double cantidadplantassembrar;
    public TiempoCosecha tC;
    public static Thread hiloCosechamaiz;

    public Cosecha(){
        
    }
    public void run(){
        tC=new TiempoCosecha(plantasCreciendo, maizCosechado,contadorLimpieza,celdamaiz, celdaSembrarMaiz);
        hiloCosechamaiz = new Thread(tC);
        contador=0;
        for(int i = 0; i<=55; i++){
            plantasCreciendo.setText("creciendo..." + contador++);
            try {
                Thread.sleep(1000);  
            } catch (Exception e) {
              System.out.println("Error en el hilo " + e);
            }
        }
        if(contador>54){
                cosechaMaiz = cantidadplantassembrar*0.05;
                maizPlantado.setVisible(false);
                maizCosechado.setVisible(true);
                hiloCosechamaiz.start();
                JOptionPane.showMessageDialog(null,"Hora de cosechar Maiz!");
        }
        
    }
    public void recibeJlabelYCantidadplantas(javax.swing.JLabel plantasCreciendo, String tipplanta, double cantidadplantassembrar,javax.swing.JLabel maizPlantado, javax.swing.JLabel maizCosechado,
    int contadorLimpieza, double celdamaiz, double celdaSembrarMaiz ){
        this.plantasCreciendo = plantasCreciendo;
        this.tipplanta = tipplanta;
        this.cantidadplantassembrar = cantidadplantassembrar;
        this.maizPlantado = maizPlantado;
        this.maizCosechado = maizCosechado;
        this.contadorLimpieza=contadorLimpieza;
        this.celdamaiz=celdamaiz;
        this.celdaSembrarMaiz=celdaSembrarMaiz;
    }
}
