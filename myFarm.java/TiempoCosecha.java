import javax.swing.*;
public class TiempoCosecha extends Thread{
    public int contador;
    public static boolean podrido=false;
    JLabel plantasCreciendo;
    JLabel maizCosechado;
    int contadorLimpieza;
    double celdamaiz;
    double celdaSembrarMaiz;

    public TiempoCosecha(JLabel plantasCreciendo, JLabel maizCosechado, int contadorLimpieza, double celdamaiz, double celdaSembrarMaiz){
        this.plantasCreciendo=plantasCreciendo;
        this.maizCosechado=maizCosechado;
        this.contadorLimpieza=contadorLimpieza;
        this.celdamaiz=celdamaiz;
        this.celdaSembrarMaiz=celdaSembrarMaiz;
    }
    public void run(){
        for(int i=30; i>=0; i--){
            contador=i;
            plantasCreciendo.setText(i + "<= tiempo para cosechar maiz");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error en tiempo cosechar maiz " + e);
            }
        }if(contador==0){
            Cosecha.cosechaMaiz=0;
            contadorLimpieza++;
            celdamaiz=0;
            celdaSembrarMaiz=celdamaiz;
            maizCosechado.setVisible(false);
            JOptionPane.showMessageDialog(null, "Se ha secado la cosecha de maiz");
            podrido=true;
            plantasCreciendo.setText("");
        }
    }
}