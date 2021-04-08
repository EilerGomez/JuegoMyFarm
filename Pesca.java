import javax.swing.*;
public class Pesca extends Thread{
    public static double pecesEnAgua;
    public static double pecesCazados;
    public double contador;
    javax.swing.JLabel pezenagua;
    javax.swing.JLabel pescados;

    public Pesca(){
    }
    public void run(){
        contador=1;
        for(int i = 0; i<=100;i++){
            pezenagua.setText("Peces creciendo... " +contador++);
           
            try {
                Thread.sleep(100);  
            } catch (Exception e) {
              System.out.println("Error en el hilo " + e);
            }
        
        }
        if(contador>100){
           //pezenagua.setText("Es hora de pezcar!!!");
           pescados.setVisible(true);
            JOptionPane.showMessageDialog(null,"Hora de pescar!!!");
            int aleatorio = (int)(Math.random()*20+1);
            double aleatoriopeces = Double.valueOf(aleatorio);
            this.pecesEnAgua=(contador-20) + aleatoriopeces;
        }
    }
    public void recibeJLabel(javax.swing.JLabel pezenagua, javax.swing.JLabel pescados){
        this.pezenagua = pezenagua;
        this.pescados = pescados;
    }
    public double getpecesEnAgua(){
        return this.pecesEnAgua;
    }
    public double getpecesCazados(){
        return this.pecesCazados;
    }
    public void setpecesEnAgua(double pecesEnAgua){
        this.pecesEnAgua = pecesEnAgua;
    }
    public void setpecesCazados(double pecesCazados){
        this.pecesCazados=pecesCazados;
    }
    
}