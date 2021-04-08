import javax.swing.*;
public class CriarVacas extends Thread{
    public static double cantidadVacasCriando;
    public static double vidaVaca;
    public double contador;
    javax.swing.JLabel vacasCreciendo;
    TiempoAlimentar alimentoVaca;
    public static Thread hilovacaAlimento;

    public CriarVacas(javax.swing.JLabel vacasCreciendo){
        this.vacasCreciendo = vacasCreciendo;
    }
    public void run(){
        alimentoVaca = new TiempoAlimentar(this.vacasCreciendo);
        hilovacaAlimento = new Thread(alimentoVaca);
        for(int i=0; i<=50; i++){
            contador++;
            vacasCreciendo.setText("Vacas Creciendo: " + contador);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Error en el hilo de criar vacas " + e);
            }
        }
        if(contador>50){
            hilovacaAlimento.start();
            JOptionPane.showMessageDialog(null, "Hora de alimentar a las vacas");
            vacasCreciendo.setText("");
        }

    }
}