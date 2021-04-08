import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Bienvenida extends JFrame implements ActionListener{
    private JLabel etiqueta1, etiqueta2, etiquetanombre, etiquetaedad, etiquetanikname;
    private JButton boton1, boton2;
    private JTextField nombre, edad, nickName;
    
    public Bienvenida(){
        setLayout(null);
        //titulo e icono
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Bienvenido");
            getContentPane().setBackground(new Color(62,95,138));
            setIconImage(new ImageIcon(getClass().getResource("images/icono,logo.jpg")).getImage());
        //imagen que se muestra del logotipo del juego
            ImageIcon imagen = new ImageIcon("images/icono,logo.jpg");
            etiqueta1 = new JLabel(imagen);
            etiqueta1.setBounds(25,5,350,210);
            add(etiqueta1);

            etiqueta2 = new JLabel("Bienvenido a MyFarm");
            etiqueta2.setBounds(35,135,300,30);
            etiqueta2.setFont(new Font("Andale Mono", 3, 18));
            etiqueta2.setForeground(new Color(255,255,255));
            add(etiqueta2);
        //etiqueta y texto para nombre
            etiquetanombre = new JLabel("Ingrese su nombre: ");
            etiquetanombre.setBounds(45,212,200,30);
            etiquetanombre.setFont(new Font("Andale Mono", 1, 14));
            etiquetanombre.setForeground(new Color(255,255,255));
            add(etiquetanombre);

            nombre = new JTextField();
            nombre.setBounds(45,240,225,25);
            nombre.setBackground(new Color(224,224,224));
            nombre.setFont(new Font("Andale Mono", 1, 14));
            nombre.setForeground(new Color (0,0,0));
            add(nombre);

        //etiqueta y texto para edad:
            etiquetaedad = new JLabel("Ingrese su edad: ");
            etiquetaedad.setBounds(45,255,200,30);
            etiquetaedad.setFont(new Font("Andale Mono", 1, 14));
            etiquetaedad.setForeground(new Color(255,255,255));
            add(etiquetaedad);

            edad = new JTextField("");
            edad.setBounds(45,285,225,25);
            edad.setBackground(new Color(224,224,224));
            edad.setFont(new Font("Andale Mono", 1, 14));
            edad.setForeground(new Color (0,0,0));
            add(edad);

        //etiqueta y texto para el nikname:

            etiquetanikname = new JLabel("Ingrese su nombre en el juego: ");
            etiquetanikname.setBounds(45,310,230,30);
            etiquetanikname.setFont(new Font("Andale Mono", 1, 14));
            etiquetanikname.setForeground(new Color(255,255,255));
            add(etiquetanikname);

            nickName = new JTextField();
            nickName.setBounds(45,335,225,25);
            nickName.setBackground(new Color(224,224,224));
            nickName.setFont(new Font("Andale Mono", 1, 14));
            nickName.setForeground(new Color (0,0,0));
            add(nickName); 

        //botones de la pntalla de inicio
            boton1 = new JButton("Ingresar");
            boton1.setBounds(45,380,100,30);
            boton1.setBackground(new Color(225,0,0));
            boton1.setFont(new Font("Andale Mono", 1, 14));
            boton1.setForeground(new Color(255,255,255));
            boton1.addActionListener(this);
            add(boton1);

            boton2 = new JButton("Salir");
            boton2.setBounds(200,380,100,30);
            boton2.setBackground(new Color(255,0,0));
            boton2.setFont(new Font("Andale Mono", 1, 14));
            boton2.setForeground(new Color(255,255,255));
            boton2.addActionListener(this);
            add(boton2);

    }
    public void actionPerformed(ActionEvent e){
        Jugador jugador = new Jugador();
        if(e.getSource()==boton1){
            jugador.nombre = this.nombre.getText().trim();
            jugador.nombreenjuego = nickName.getText();
            Jugador.edad = Integer.parseInt(edad.getText());
            if(jugador.nombre.equals("") || jugador.nombreenjuego.equals("")&& edad.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debes llenar todos los datos");
            }
            else{
                
                TerminosYCondiciones licencia = new TerminosYCondiciones();
                licencia.setBounds(0,0,700,500);
                licencia.setVisible(true);
                licencia.setResizable(false);
                licencia.setLocationRelativeTo(null);
                this.setVisible(false);
            }
        }else if(e.getSource()==boton2){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        Bienvenida vb = new Bienvenida();
        vb.setBounds(0,0,400,450);
        vb.setVisible(true);
        vb.setResizable(false);
        vb.setLocationRelativeTo(null);
    }
}