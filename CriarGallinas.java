import javax.swing.*;
public class CriarGallinas extends Thread{
    public static double cantidadGallinasCriando;
    public double contador;
    javax.swing.JLabel criandoGallinas;
    JLabel pollosCreciendo;
    TiempoAlimento1 alimentogallina;
    public static Thread tiempocomidaGallina;

    public CriarGallinas(javax.swing.JLabel criandoGallinas, JLabel pollosCreciendo){
        this.criandoGallinas =criandoGallinas;
        this.pollosCreciendo = pollosCreciendo;
    }

    public void run(){
        alimentogallina = new TiempoAlimento1(criandoGallinas, pollosCreciendo);
        tiempocomidaGallina = new Thread(alimentogallina);
        for(int i=0; i<=40; i++){
            contador++;
            criandoGallinas.setText("Gallinas creciendo: " + contador);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
               System.out.println("Error en el hilo de gallinas creciendo " + e);
            } 
        }
        if(contador>40){
            tiempocomidaGallina.start();
            JOptionPane.showMessageDialog(null, "Hora de alimentar a las gallinas");
            criandoGallinas.setText("");
        }
    }
}