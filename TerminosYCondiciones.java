import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class TerminosYCondiciones extends JFrame implements ActionListener, ChangeListener{
    private JCheckBox check1;
    private JLabel etiqueta1, etiqueta2;
    private JButton boton1, boton2;
    private JTextArea textArea1;
    private JScrollPane scroll1;
    String nombre = "";
    public static Reportes rp = new Reportes();

    public TerminosYCondiciones (){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencia de uso");
        getContentPane().setBackground(new Color(62,95,138));
        setIconImage(new ImageIcon(getClass().getResource("images/icono,logo.jpg")).getImage());
        Jugador jugador = new Jugador();
        nombre = jugador.nombre;

            rp.setBounds(0,0,500,500);
            rp.setResizable(false);
            rp.setVisible(false);
            rp.setLocationRelativeTo(null);

        etiqueta1 = new JLabel("TERMINOS Y CONDICIONES");
        etiqueta1.setBounds(215,5,200,30);
        etiqueta1.setFont(new Font("Andale Mono", 1, 14));
        etiqueta1.setForeground(new Color(0,0,0));
        add(etiqueta1);
        
        textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setFont(new Font("Andale Mono", 0, 9));
        textArea1.setText("\n\n          TERMINOS Y CONDICIONES" +
         "\n\n USTED UTILIZA EL SITIO O CUALQUIER SOFTWARE, SERVICIO O MATERIAL DISPONIBLE " +
         "\n A TRAVÉS DEL SITIO POR SU PROPIA CUENTA Y RIESGO. NI MYFARM, NI NINGUNA " +
         "\n DE SUS ENTIDADES AFILIADAS, NI NINGÚN TERCERO INVOLUCRADO EN LA CREACIÓN, PRODUCCIÓN O  " +
         "\n FUNCIONAMIENTO DEL SITIO, NI NINGUNO DE SUS RESPECTIVOS DIRECTORES, FUNCIONARIOS, EMPLEADOS, " +
         "\n AGENTES, ACCIONISTAS, OTORGANTES DE LICENCIA Y REPRESENTANTES, SON RESPONSABLES DE NINGÚN DAÑO" +
         "\n DIRECTO, INDIRECTO, PUNITIVO, INCIDENTAL, ESPECIAL, EMERGENTE, EJEMPLAR U OTRO DAÑO O " +
         " \n RELACIONADO CON EL USO DE ESTE SITIO, LOS SERVICIOS, EL SOFTWARE, EL CONTENIDO O EL CONTENIDO DEL " + 
         "\n USUARIO, SEAN DE TIPO CONTRACTUAL, EXTRACONTRACTUAL, POR RESPONSABILIDAD OBJETIVA O DE CUALQUIER OTRO TIPO," +
         "\n AÚN CUANDO SE HUBIERA INFORMADO DE LA POSIBILIDAD DE QUE SE PRODUJERAN TALES DAÑOS, INCLUIDOS, SIN " +
         "\n LIMITARSE A, LOS DAÑOS POR PÉRDIDA DE BENEFICIOS, USO, DATOS, PÉRDIDA DE OTROS INTANGIBLES Y PÉRDIDA " +
         "\n DE SEGURIDAD DE LA INFORMACIÓN QUE HAYA PROPORCIONADO EN RELACIÓN CON SU USO DEL SITIO, LOS SERVICIOS," +
         "\n EL SOFTWARE, EL CONTENIDO O EL CONTENIDO DEL USUARIO, O LA INTERCEPTACIÓN NO AUTORIZADA DE DICHA INFORMACIÓN" +
         "\n POR TERCEROS, INCLUSO SI SE HA NOTIFICADO PREVIAMENTE TALES DAÑOS O PÉRDIDAS. EN PARTICULAR, Y SIN LIMITACIÓN," +
         "\n NI THE MYFARM NI LAS ENTIDADES AFILIADAS SERAN RESPONSABLES DE LOS DAÑOS QUE RESULTEN DE CUALQUIER " +
         "\n TIPO DE USO O IMPOSIBILIDAD DE USO DE ESTE SITIO, LOS SERVICIOS O EL SOFTWARE O QUE DERIVEN DEL CONTENIDO O " +
         "\n DEL CONTENIDO DEL USUARIO PUBLICADO EN EL SITIO POR MYFARM O UN TERCERO. EN CASO DE DISCONFORMIDAD," +
         "\n LA ÚNICA SOLUCIÓN ES DEJAR DE UTILIZAR ESTE SITIO. ");
        scroll1 = new JScrollPane(textArea1);
        scroll1.setBounds(10,40,650,200);
        add(scroll1);

        check1 = new JCheckBox("Yo " + nombre + " Acepto");
        check1.setBounds(10,250,300,30);
        check1.addChangeListener(this);
        add(check1);

        boton1 = new JButton("Continuar");
        boton1.setBounds(10,290,100,30);
        boton1.setBackground(new Color(0,255,0));
        boton1.setEnabled(false);
        boton1.addActionListener(this);
        add(boton1);

        boton2 = new JButton("No Acepto");
        boton2.setBounds(120,290,100,30);
        boton2.setBackground(new Color(0,0,255));
        boton2.setForeground(new Color(255,255,255));
        boton2.setEnabled(true);
        boton2.addActionListener(this);
        add(boton2);

        ImageIcon imagen = new ImageIcon("images/icono,logo.jpg");
        etiqueta2 = new JLabel(imagen);
        etiqueta2.setBounds(360,250,300,200);
        add(etiqueta2); 

    }
    public void stateChanged(ChangeEvent e){
        if(check1.isSelected()==true){
            boton1.setEnabled(true);
            boton2.setEnabled(false);
        }else{
            boton1.setEnabled(false);
            boton2.setEnabled(true);

        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==boton1){
          VentanaMenu vM = new VentanaMenu();
          vM.setBounds(0,0,1400,735);
          vM.setVisible(true);
          vM.setResizable(false);
          this.setVisible(false);
        }else if(e.getSource()==boton2){
            Bienvenida vb = new Bienvenida();
            vb.setBounds(0,0,400,450);
            vb.setVisible(true);
            vb.setResizable(false);
            vb.setLocationRelativeTo(null);

            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        TerminosYCondiciones licencia = new TerminosYCondiciones();
        licencia.setBounds(0,0,700,500);
        licencia.setVisible(true);
        licencia.setResizable(false);
        licencia.setLocationRelativeTo(null); 
    }
}