import javax.swing.JLabel;
public class TiempoPartida extends Thread{
    public static int tiempoPartida=0;
    JLabel partidaTiempo;

    public TiempoPartida(JLabel partidaTiempo){
        this.partidaTiempo=partidaTiempo;
    }

    public void run(){
        for(int i = 0; i>=0; i++){
            tiempoPartida=i;
            partidaTiempo.setText("Time: " + tiempoPartida);
            try {
               Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Error en el hilo del tiempo" + e);
            }
            
        }
    }
}