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
    public TiempoCosecha1 tC1;
    public static Thread hiloCosechamanzan;
    Thread hilosembrar2;
    int contadorLimpieza;

    public Cosecha1(javax.swing.JLabel plantasCreciendo1, String tipplanta1, double cantidadplantassembrar, javax.swing.JLabel manzanasPlantado, javax.swing.JLabel manzanaCosechado,
     Thread hilosembrar2, int contadorLimpieza){
        this.plantasCreciendo1 = plantasCreciendo1;
        this.tipplanta1 = tipplanta1;
        this.cantidadplantassembrar=cantidadplantassembrar;
        this.manzanasPlantado = manzanasPlantado;
        this.manzanaCosechado = manzanaCosechado;
        this.hilosembrar2 = hilosembrar2;
        this.contadorLimpieza=contadorLimpieza;
    }
    public void run(){
        tC1= new TiempoCosecha1(plantasCreciendo1, manzanaCosechado, contadorLimpieza,hilosembrar2, manzanasPlantado);
        hiloCosechamanzan = new Thread(tC1);
        contador=0;
        for(int i = 0; i<=50; i++){
            plantasCreciendo1.setText("creciendo..." + contador++);
            try {
                Thread.sleep(1000);  
            } catch (Exception e) {
              System.out.println("Error en el hilo " + e);
            }
        }
        if(contador>49){
                cosechaManzana=cantidadplantassembrar*1;
                manzanasPlantado.setVisible(false);
                manzanaCosechado.setVisible(true);
                hiloCosechamanzan.start();
                JOptionPane.showMessageDialog(null,"Hora de cosechar Manzanas!"); 
        }else{
            manzanasPlantado.setVisible(true);
        }
    }
    
}