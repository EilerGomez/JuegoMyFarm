import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;
public class NuevaPartida extends JFrame implements ActionListener{
    private JLabel saludo, fondo;
    private JButton irNuevaPartida;

    public NuevaPartida(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Nueva Partida");
        setIconImage(new ImageIcon(getClass().getResource("images/icono,logo.jpg")).getImage());

        saludo= new JLabel("Hola: " + Jugador.nombre + " clic en ir,\n " + 
                                                    "para iniciar tu partida");
        saludo.setBounds(20,50,600,100);
        saludo.setFont(new Font("Stencil",3,16));
        saludo.setForeground(new Color(0,0,0));
        add(saludo);

        fondo=new JLabel(new ImageIcon("images/partida.jpg"));
        fondo.setBounds(0,0,650,650);
        add(fondo);

        irNuevaPartida = new JButton("Ir");
        irNuevaPartida.setBounds(200,150,90,30);
        irNuevaPartida.setFont(new Font("Georgia", 1, 12));
        irNuevaPartida.setForeground(new Color(255,255,255));
        irNuevaPartida.setBackground(new Color(0,0,0));
        add(irNuevaPartida);
        irNuevaPartida.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==irNuevaPartida){
            VentanaMenu vM = new VentanaMenu();
            vM.setBounds(0,0,1400,735);
            vM.setVisible(true);
            vM.setResizable(false);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        NuevaPartida np = new NuevaPartida();
        np.setBounds(0,0,530,350);
        np.setVisible(true);
        np.setResizable(false);
        np.setLocationRelativeTo(null);
    }
}