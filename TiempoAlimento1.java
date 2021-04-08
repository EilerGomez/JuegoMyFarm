import javax.swing.*;
public class TiempoAlimento1 extends Thread{
    public int contador;
    public static boolean muerto = false;
    JLabel animalCreciendo;

    public TiempoAlimento1(JLabel animalCreciendo){
        this.animalCreciendo = animalCreciendo;
    }
    public void run(){
        for(int i=30; i>=0; i--){
            contador =i;
            animalCreciendo.setText(i + " <= tiempo para alimentar gallinas");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error en tiempo alimento de gallinas " + e);
            }
        }
        if(contador==0){
            CriarGallinas.cantidadGallinasCriando=0;
            JOptionPane.showMessageDialog(null, "Las gallinas han muerto de hambre");
            muerto=true;
            animalCreciendo.setText("");
        }
    }
}