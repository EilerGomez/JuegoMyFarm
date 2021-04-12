import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;
public class Reportes extends JFrame implements ActionListener{
    private JLabel delJugador, nombre, nik, edad, partidas, oroPorGranja, alimentoporGranja, alimentoConsumido, animales, plantas, crias, destazadas, semillas, celdas;
    private JLabel fondo;
    public static JTextField oroGranja, peces, tortillas, manzanas, carne, huevos, leche;
    public static JTextField peces1, tortillas1, manzanas1, carne1, huevos1, leche1;
    public static JTextField criasT, aDestazados, semT, celdasT;
    public static String numPartidas[]= new String[10000];
    public static int contadorPatidas=1;
    public static JTextArea txtArea;
    private JScrollPane scroll1;
    private JButton regresar;
    public static double oroG, criasTT, destazz, semmill, cantCeldas, pecesGranja, maizGranja, lecheGranja, manzanasGranja, huevosGranja, carneGranja;
    public static double pecesG, maizG, lecheG, manzanasG, huevosG, carneG;
    public Reportes(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Reportes");
        getContentPane().setBackground(new Color(95,168,160));
        setIconImage(new ImageIcon(getClass().getResource("images/icono,logo.jpg")).getImage());

        delJugador = new JLabel("DATOS DEL JUGADOR");
        delJugador.setBounds(10,10,300,30);
        delJugador.setFont(new Font("Georgia", 1,12));
        delJugador.setForeground(new Color(0,0,0));
        add(delJugador);

        nombre = new JLabel("Nombre: " + Jugador.nombre);
        nombre.setBounds(20,25,200,30);
        nombre.setFont(new Font("Georgia", 1,12));
        nombre.setForeground(new Color(0,0,0));
        add(nombre);

        nik = new JLabel("NickName: " + Jugador.nombreenjuego);
        nik.setBounds(20,40,200,30);
        nik.setFont(new Font("Georgia", 1,12));
        nik.setForeground(new Color(0,0,0));
        add(nik);

        edad = new JLabel("Edad: " + Jugador.edad);
        edad.setBounds(20,55,200,30);
        edad.setFont(new Font("Georgia", 1,12));
        edad.setForeground(new Color(0,0,0));
        add(edad);

        txtArea = new JTextArea("");
        scroll1 = new JScrollPane(txtArea);
        scroll1.setBounds(20,95,230,100);
        txtArea.setEditable(false);
        add(scroll1);

        partidas = new JLabel("PARTIDAS");
        partidas.setBounds(10,70,200,30);
        partidas.setFont(new Font("Georgia", 1,14));
        partidas.setForeground(new Color(0,0,0));
        add(partidas);

        oroPorGranja = new JLabel("Oro generado por la granja: ");
        oroPorGranja.setBounds(20,195,200,30);
        oroPorGranja.setFont(new Font("Georgia", 1,12));
        oroPorGranja.setForeground(new Color(0,0,0));
        add(oroPorGranja);
        
        oroGranja = new JTextField("");
        oroGranja.setBounds(258,198,60,20);
        oroGranja.setForeground(new Color(0,0,0));
        oroGranja.setBackground(new Color(0,255,255));
        oroGranja.setEditable(false);
        add(oroGranja);

        alimentoporGranja = new JLabel("Alimento generado por la granja: ");
        alimentoporGranja.setBounds(20,210,300,30);
        alimentoporGranja.setFont(new Font("Georgia", 1,12));
        alimentoporGranja.setForeground(new Color(0,0,0));
        add(alimentoporGranja);

        alimentoConsumido = new JLabel("Alimento consumido por el granjero: ");
        alimentoConsumido.setBounds(20,255,300,30);
        alimentoConsumido.setFont(new Font("Georgia", 1,12));
        alimentoConsumido.setForeground(new Color(0,0,0));
        add(alimentoConsumido);

    //consumido por el granjero
        peces= new JTextField("Peces: 0.0");
        peces.setBounds(20,276,70,25);
        peces.setForeground(new Color(0,0,0));
        peces.setBackground(new Color(0,255,255));
        peces.setEditable(false);
        add(peces);

        tortillas= new JTextField("maiz: 0.0");
        tortillas.setBounds(90,276,70,25);
        tortillas.setForeground(new Color(0,0,0));
        tortillas.setBackground(new Color(0,255,255));
        tortillas.setEditable(false);
        add(tortillas);

        leche= new JTextField("leche(lt): 0.0");
        leche.setBounds(160,276,70,25);
        leche.setForeground(new Color(0,0,0));
        leche.setBackground(new Color(0,255,255));
        leche.setEditable(false);
        add(leche);

        manzanas= new JTextField("Mzn(u): 0.0");
        manzanas.setBounds(230,276,70,25);
        manzanas.setForeground(new Color(0,0,0));
        manzanas.setBackground(new Color(0,255,255));
        manzanas.setEditable(false);
        add(manzanas);

        huevos= new JTextField("huevos(u): 0.0");
        huevos.setBounds(300,276,70,25);
        huevos.setForeground(new Color(0,0,0));
        huevos.setBackground(new Color(0,255,255));
        huevos.setEditable(false);
        add(huevos);

        carne= new JTextField("carne(lb): 0.0");
        carne.setBounds(370,276,70,25);
        carne.setForeground(new Color(0,0,0));
        carne.setBackground(new Color(0,255,255));
        carne.setEditable(false);
        add(carne);

    //producidos por la granja

        peces1= new JTextField("Peces: 0.0");
        peces1.setBounds(20,230,70,25);
        peces1.setForeground(new Color(0,0,0));
        peces1.setBackground(new Color(0,255,255));
        peces1.setEditable(false);
        add(peces1);

        tortillas1= new JTextField("maiz: 0.0");
        tortillas1.setBounds(90,230,70,25);
        tortillas1.setForeground(new Color(0,0,0));
        tortillas1.setBackground(new Color(0,255,255));
        tortillas1.setEditable(false);
        add(tortillas1);

        leche1= new JTextField("leche(lt): 0.0");
        leche1.setBounds(160,230,70,25);
        leche1.setForeground(new Color(0,0,0));
        leche1.setBackground(new Color(0,255,255));
        leche1.setEditable(false);
        add(leche1);

        manzanas1= new JTextField("Mzn(qq): 0.0");
        manzanas1.setBounds(230,230,70,25);
        manzanas1.setForeground(new Color(0,0,0));
        manzanas1.setBackground(new Color(0,255,255));
        manzanas1.setEditable(false);
        add(manzanas1);

        huevos1= new JTextField("huevos(u): 0.0");
        huevos1.setBounds(300,230,70,25);
        huevos1.setForeground(new Color(0,0,0));
        huevos1.setBackground(new Color(0,255,255));
        huevos1.setEditable(false);
        add(huevos1);

        carne1= new JTextField("carne(lb): 0.0");
        carne1.setBounds(370,230,70,25);
        carne1.setForeground(new Color(0,0,0));
        carne1.setBackground(new Color(0,255,255));
        carne1.setEditable(false);
        add(carne1);
    //
    // animales y semillas

        criasT= new JTextField("0.0");
        criasT.setBounds(258,318,50,15);
        criasT.setForeground(new Color(0,0,0));
        criasT.setBackground(new Color(0,255,255));
        criasT.setEditable(false);
        add(criasT);

        aDestazados= new JTextField("0.0");
        aDestazados.setBounds(258,335,50,15);
        aDestazados.setForeground(new Color(0,0,0));
        aDestazados.setBackground(new Color(0,255,255));
        aDestazados.setEditable(false);
        add(aDestazados);

        semT= new JTextField("0.0");
        semT.setBounds(258,363,50,15);
        semT.setForeground(new Color(0,0,0));
        semT.setBackground(new Color(0,255,255));
        semT.setEditable(false);
        add(semT);

        celdasT= new JTextField("0.0");
        celdasT.setBounds(258,377,50,15);
        celdasT.setForeground(new Color(0,0,0));
        celdasT.setBackground(new Color(0,255,255));
        celdasT.setEditable(false);
        add(celdasT);



        animales = new JLabel("ANIMALES ");
        animales.setBounds(10,300,200,30);
        animales.setFont(new Font("Georgia", 1,14));
        animales.setForeground(new Color(0,0,0));
        add(animales);

        crias = new JLabel("Crias en todas las partidas: ");
        crias.setBounds(20,315,200,30);
        crias.setFont(new Font("Georgia", 1,12));
        crias.setForeground(new Color(0,0,0));
        add(crias);
        
        destazadas = new JLabel("Animales destazados: ");
        destazadas.setBounds(20,330,200,30);
        destazadas.setFont(new Font("Georgia", 1,12));
        destazadas.setForeground(new Color(0,0,0));
        add(destazadas);

        plantas = new JLabel("PLANTAS ");
        plantas.setBounds(10,345,200,30);
        plantas.setFont(new Font("Georgia", 1,14));
        plantas.setForeground(new Color(0,0,0));
        add(plantas);

        semillas = new JLabel("Semillas en todas las partidas: ");
        semillas.setBounds(20,360,300,30);
        semillas.setFont(new Font("Georgia", 1,12));
        semillas.setForeground(new Color(0,0,0));
        add(semillas);

        celdas = new JLabel("Celdas sembradas: ");
        celdas.setBounds(20,375,200,30);
        celdas.setFont(new Font("Georgia", 1,12));
        celdas.setForeground(new Color(0,0,0));
        add(celdas);

        regresar = new JButton("Regresar");
        regresar.setBounds(50,413,90,30);
        regresar.setFont(new Font("Time New Roman", 0, 12));
        regresar.setBackground(new Color(0,0,0));
        regresar.setForeground(new Color(255,255,255));
        add(regresar);
        regresar.addActionListener(this);

        fondo=new JLabel(new ImageIcon("images/Reportes.jpg"));
        fondo.setBounds(0,0,500,440);
        add(fondo);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==regresar){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        Reportes rp = new Reportes();
        rp.setBounds(0,0,500,500);
        rp.setResizable(false);
        rp.setVisible(true);
        rp.setLocationRelativeTo(null);
    }
}