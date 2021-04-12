import javax.swing.*;
public class TiempoCosecha1 extends Thread{
    public int contador;
    public static boolean podrido = false;
    JLabel plantasCreciendo1;
    JLabel manzanaCosechado, manzanasPlantado;
    int contadorLimpieza;
    Thread hilosembrar2;
    

    public TiempoCosecha1(JLabel plantasCreciendo1, JLabel manzanaCosechado,
    int contadorLimpieza, Thread hilosembrar2, JLabel manzanasPlantado){
        this.plantasCreciendo1=plantasCreciendo1;
        this.manzanaCosechado=manzanaCosechado;
        this.contadorLimpieza=contadorLimpieza;
        this.hilosembrar2=hilosembrar2;
        this.manzanasPlantado = manzanasPlantado;
    }

    public void run(){
        for(int i=30; i>=0; i--){
            contador=i;
            plantasCreciendo1.setText(i + "<= tiempo para cosechar manzanas");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error en tiempo cosechar manzanas" + e);
            }
        }if(contador==0){
            if(contadorLimpieza==4){
                JOptionPane.showMessageDialog(null, "Necesitas limpiar el terreno para seguir plantando manzanas");
            }else{
                Cosecha1.cosechaManzana=0;
                contadorLimpieza++;
                manzanaCosechado.setVisible(false);
                JOptionPane.showMessageDialog(null, "Se ha secado la cosecha de manzanas");
                manzanasPlantado.setVisible(true);
                hilosembrar2.start();
                podrido=true;
                plantasCreciendo1.setText("");
            }
        }
    }
}