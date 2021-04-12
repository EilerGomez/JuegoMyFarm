import javax.swing.*;
public class TiempoAlimentar extends Thread{
    public int contador;
    public static boolean muerto=false;
    JLabel animalCreciendo;
    JLabel vacasCriando;

    public TiempoAlimentar(JLabel animalCreciendo, JLabel vacasCriando){
        this.animalCreciendo = animalCreciendo;
        this.vacasCriando= vacasCriando;
    }

    public void run(){
        for (int i=30; i>=0; i--){
            contador = i;
            animalCreciendo.setText(i + " <= tiempo para alimentar vacas");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error en el hilo de tiempo para alimentar " + e);
            }
        }
        if(contador==0){
            CriarVacas.cantidadVacasCriando=0;
            vacasCriando.setVisible(false);
            JOptionPane.showMessageDialog(null, "Tus vacas han muerto de ambre");
            muerto=true;
            animalCreciendo.setText("");
        }
    }
}