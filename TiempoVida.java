import javax.swing.*;
public class TiempoVida extends Thread{
    JLabel tuVida;
    JButton aceptarAgua;
    JButton aceptarSiembra;
    JButton aceptarCosechar;
    JButton AceptarCriarAnimal;
    JButton aceptarAnimal;
    JButton aceptarFuncionEnCasa;
    JButton aceptarSemillas;
    JButton aceptarVenta;
    JButton comprarComidaAnimal;
    JButton comprarFertilizante;
    JButton aceptarCompraCrias;
    Thread hiloTiempo;
    double i;

    public TiempoVida(JLabel tuVida, JButton aceptarAgua, JButton aceptarSiembra, JButton aceptarCosechar, JButton AceptarCriarAnimal,
     JButton aceptarAnimal, JButton aceptarFuncionEnCasa, JButton aceptarSemillas, JButton aceptarVenta, JButton comprarComidaAnimal, 
     JButton comprarFertilizante, JButton aceptarCompraCrias, Thread hiloTiempo){
        this.tuVida = tuVida;
        this.aceptarAgua=aceptarAgua;
        this.aceptarSiembra=aceptarSiembra;
        this.aceptarCosechar=aceptarCosechar;
        this.AceptarCriarAnimal=AceptarCriarAnimal;
        this.aceptarAnimal=aceptarAnimal;
        this.aceptarFuncionEnCasa=aceptarFuncionEnCasa;
        this.aceptarSemillas=aceptarSemillas;
        this.aceptarVenta=aceptarVenta;
        this.comprarComidaAnimal=comprarComidaAnimal;
        this.comprarFertilizante=comprarFertilizante;
        this.aceptarCompraCrias=aceptarCompraCrias;
        this.hiloTiempo = hiloTiempo;
    }
    public void run(){
        for(i=Jugador.vida; i>=0; i--){
            Jugador.vida =i;
            tuVida.setText("Vida: " + Jugador.vida);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
               System.out.println("Error en el hilo de vida " + e);
            }
            if(Jugador.vida ==10){
                JOptionPane.showMessageDialog(null, "Debes alimentar al grajero");
            }else if(Jugador.vida==0){
                aceptarAgua.setEnabled(false);
                aceptarSiembra.setEnabled(false);
                aceptarCosechar.setEnabled(false);
                AceptarCriarAnimal.setEnabled(false);
                aceptarAnimal.setEnabled(false);
                aceptarFuncionEnCasa.setEnabled(false);
                aceptarSemillas.setEnabled(false);
                aceptarVenta.setEnabled(false);
                comprarComidaAnimal.setEnabled(false);
                comprarFertilizante.setEnabled(false);
                aceptarCompraCrias.setEnabled(false);
                hiloTiempo.stop();
                JOptionPane.showMessageDialog(null, "Partida perdida");
            }
        }
    }
    public void detener(){
        i=-100;
    }
}