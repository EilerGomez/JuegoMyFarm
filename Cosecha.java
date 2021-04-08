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
    public double cantidadplantassembrar;

    public Cosecha(){
        
    }
    public void run(){
        contador=0;
        for(int i = 0; i<=100; i++){
            plantasCreciendo.setText("creciendo..." + contador++);
            try {
                Thread.sleep(100);  
            } catch (Exception e) {
              System.out.println("Error en el hilo " + e);
            }
        }
        if(contador>100){
                cosechaMaiz = cantidadplantassembrar*0.05;
                maizPlantado.setVisible(false);
                maizCosechado.setVisible(true);
                JOptionPane.showMessageDialog(null,"Hora de cosechar Maiz!");
        }
        
    }
    public void recibeJlabelYCantidadplantas(javax.swing.JLabel plantasCreciendo, String tipplanta, double cantidadplantassembrar,javax.swing.JLabel maizPlantado, javax.swing.JLabel maizCosechado ){
        this.plantasCreciendo = plantasCreciendo;
        this.tipplanta = tipplanta;
        this.cantidadplantassembrar = cantidadplantassembrar;
        this.maizPlantado = maizPlantado;
        this.maizCosechado = maizCosechado;
    }
}
