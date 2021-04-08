import javax.swing.*;
public class Cosecha1 extends Thread{
    public static double manzanasquintales=0;
    public static double cosechaManzana=0;
    public static double aumentoManzanas=0;
    public double contador;
    public double cantidadplantassembrar;
    public static String tipplanta1;
    javax.swing.JLabel plantasCreciendo1;
    javax.swing.JLabel manzanasPlantado;
    javax.swing.JLabel manzanaCosechado;
    String planta;

    public Cosecha1(javax.swing.JLabel plantasCreciendo1, String tipplanta1, double cantidadplantassembrar, javax.swing.JLabel manzanasPlantado, javax.swing.JLabel manzanaCosechado){
        this.plantasCreciendo1 = plantasCreciendo1;
        this.tipplanta1 = tipplanta1;
        this.cantidadplantassembrar=cantidadplantassembrar;
        this.manzanasPlantado = manzanasPlantado;
        this.manzanaCosechado = manzanaCosechado;
    }
    public void run(){
        contador=0;
        for(int i = 0; i<=100; i++){
            plantasCreciendo1.setText("creciendo..." + contador++);
            try {
                Thread.sleep(100);  
            } catch (Exception e) {
              System.out.println("Error en el hilo " + e);
            }
        }
        if(contador>99){
                cosechaManzana=cantidadplantassembrar*1;
                manzanasPlantado.setVisible(false);
                manzanaCosechado.setVisible(true);
                JOptionPane.showMessageDialog(null,"Hora de cosechar Manzanas!"); 
        }
    }
    
}