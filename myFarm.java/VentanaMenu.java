import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;


public class VentanaMenu extends JFrame implements ActionListener, Runnable{
    private JLabel etiqueta1, etiqueta2, etiqueta3, etiqueta4, imagenAgua, imagenGrama, imagenDesierto, bodega,pezenagua, bote, mercado, comprarSemillas;
    private JLabel semm,semM, venderProductos, VentaComidaAnimales, cantComidaAM, fertTerreno,  cantFRT, sembrarPlantas, plantasCreciendo;
    private JLabel cantPlantas, plantasCreciendo1, maizPlantado, manzanasPlantado, maizCosechado, manzanaCosechado, pescados, criarAnimales, vacasCreciendo;
    private JLabel gallinasCreciendo, cantidadAnimales, comprarCrias, cantidadCrias, criandoVacas, criandoGallinas, vacasCriando;
    private JLabel vacasGrandes, pollosCreciendo, gallinasGrandes, enLaGranja, cantidadComidaGrangero, tuVida, tiempoPartida, bienvenido, fondo, granjer;
    private JTextField field[] = new JTextField[25];
    private JTextField misPeces, maiz, oro, puntaje, semMaiz, semManzana, cantSemillas, cantVenta, cantComidaAnimal, cantFertilizante, cantPlantaSembrar;
    private JTextField manzanasqq, multifert, gallinasa, fungisidas, cantAnimals, criasVacas, criasGallinas, cantCrias, gallinas, vacas, trigoqq, afrechoqq, pastoqq;
    private JTextField lechelt, huevosU, cueroVaca, carneDeVaca, carneDeGallina, cantidadAlimentoGrangero; 
    private JMenuBar barra;
    private JButton aceptarAgua, aceptarBote, aceptarSemillas, aceptarVenta, comprarComidaAnimal, comprarFertilizante, aceptarSiembra;
    private JButton aceptarCosechar, aceptarAnimal, AceptarCriarAnimal, aceptarCompraCrias, aceptarFuncionEnCasa;
    private JMenu opciones, nuevo, acercaDe,mFondo;
    private JMenuItem miAcercaDe, miNuveaPartida, miRojo, miMorado, miNegro, miAzul, miReportes, salir ;
    private JComboBox comboAgua, comboSemillas, comboVenta, comidaAnimalesV, comidaAnimalesG, tipoAnimal, fertilizante, tipoPlanta, celdas, animalCriar, funcionAnimal, parcelaAnimal;
    private JComboBox comboCria, comboAlimentoHervivoro, comboAlimentoOmnivoro, comboFuncionCasa, comboAlimentoGrangero;
    private String barco1 = "<===>";
    private String barco2 = "<==T==>";
    //variables para cosechar y sembrar
             String tipplanta = "";
             String tipplanta1="";
             String cantidadpnatassembr = "";
             double cantidadplantassembrar;
             double celdamaiz;
             double celdamanzana;
             double celdaSembrarMaiz;
             double celdaSembrarManzanas;
             int contadorLimpieza;
             int vidaManzanas;
    ///
    //Variables para comprar fertilizantes
             double multf;
             double galli;
             double fungi;
    ///
    //variables para comprar o vender animales
        String cantidadDeCrias;
        double criasCantidad;
        String tipodeCria;
    ///
    //variables para criar los animales
        String tipoDeAnimal;
        String funcionanimal;
        String animalTipoCriar;
        int celdavaca;
        int celdaGallina;
        int contadorCrecimientoVaca;
        int contadorCrecimientoGall;
    ///
    //variables para la vida del granjero
        Thread tiempoVida[] = new Thread[10000];
        int contadorHilos=0;
        TiempoVida tmv;
        Thread hiloTiempo;
    ///
    //variables para sembrar plantas
        Cosecha1 cosechamanzan;
        Thread hilosembrar2;
        Thread hilosembrar1;
    ///
    Inicio in = new Inicio();
    Pesca pesca;
    Pesca pesca1;
    public void setpecesAgua(int pecesAgua){
    }

    @Override
    public void run(){
    }
    
    public VentanaMenu(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ventana Pricipal");
        getContentPane().setBackground(new Color(62,95,138));
        setIconImage(new ImageIcon(getClass().getResource("images/icono,logo.jpg")).getImage());
    //imagenes de las prcelas
        imagenGrama = new JLabel(new ImageIcon("images/Grama.png"));
        imagenGrama.setBounds(178,185,168,102);
        add(imagenGrama);

        imagenAgua = new JLabel(new ImageIcon("images/Agua1.png"));
        imagenAgua.setBounds(10,185,168,102);
        add(imagenAgua);

        imagenDesierto = new JLabel(new ImageIcon("images/Desierto1.jpg"));
        imagenDesierto.setBounds(340,185,168,102);
        add(imagenDesierto);
    //etiquetas principales
        etiqueta1 = new JLabel("Tu Granja");
        etiqueta1.setBounds(190,5,90,25);
        etiqueta1.setFont(new Font("Andale Mono", 1, 18));
        etiqueta1.setForeground(new Color(0,0,0));
        add(etiqueta1);

        etiqueta2 = new JLabel("Parcelas de Agua: " + in.contadorAgua);
        etiqueta2.setBounds(10,287,150,25);
        etiqueta2.setFont(new Font("Andale Mono", 1, 12));
        etiqueta2.setForeground(new Color(255,255,255));
        add(etiqueta2);

        etiqueta3 = new JLabel("Parcelas de Grama: " + in.contadorGrama);
        etiqueta3.setBounds(178,287,150,25);
        etiqueta3.setFont(new Font("Andale Mono", 1, 12));
        etiqueta3.setForeground(new Color(255,255,255));
        add(etiqueta3);

        etiqueta4 = new JLabel("Parcelas de Desierto: " + in.contadorDesierto);
        etiqueta4.setBounds(345,287,150,25);
        etiqueta4.setFont(new Font("Andale Mono", 1, 12));
        etiqueta4.setForeground(new Color(255,255,255));
        add(etiqueta4);
    //la granja o la tabla
        int posx1= 10;
       for(int i = 0; i<=4; i++){
           field[i] = new JTextField(in.parcela[i]);
           field[i].setBounds(posx1,30,90,30);
           field[i].setEditable(false);
           add(field[i]);
           posx1 = posx1 + 90;
       }
       int posx2= 10;
       for(int i = 5; i<=9; i++){
           field[i] = new JTextField(in.parcela[i]);
           field[i].setBounds(posx2,60,90,30);
           field[i].setEditable(false);
           add(field[i]);
           posx2 = posx2 + 90;
       }
       int posx3= 10;
       for(int i = 10; i<=14; i++){
           field[i] = new JTextField(in.parcela[i]);
           field[i].setBounds(posx3,90,90,30);
           field[i].setEditable(false);
           add(field[i]);
           posx3 = posx3 + 90;
       }
       int posx4= 10;
       for(int i = 15; i<=19; i++){
           field[i] = new JTextField(in.parcela[i]);
           field[i].setBounds(posx4,120,90,30);
           field[i].setEditable(false);
           add(field[i]);
           posx4 = posx4 + 90;
       }
       int posx5= 10;
       for(int i = 20; i<=24; i++){
           field[i] = new JTextField(in.parcela[i]);
           field[i].setBounds(posx5,150,90,30);
           field[i].setEditable(false);
           add(field[i]);
           posx5 = posx5 + 90;
       }

    //Agua:

        aceptarAgua = new JButton("Aceptar");
        aceptarAgua.setBounds(10,375,80,30);
        aceptarAgua.setBackground(new Color(0,0,0));
        aceptarAgua.setForeground(new Color(255,255,255));
        add(aceptarAgua);
        aceptarAgua.addActionListener(this);

        aceptarBote = new JButton("G.peces");
        aceptarBote.setBounds(95,375,80,30);
        aceptarBote.setBackground(new Color(0,0,0));
        aceptarBote.setForeground(new Color(255,255,255));
        aceptarBote.setEnabled(false);
        add(aceptarBote);
        aceptarBote.addActionListener(this);


    // pesca
                pezenagua = new JLabel("");
                pezenagua.setBounds(10,310,150,25);
                pezenagua.setFont(new Font("Time New Roman", 1, 12));
                pezenagua.setForeground(new Color(0,0,0));
                add(pezenagua);
               

                bote = new JLabel("Tu bote: ");
                bote.setBounds(10,325,150,25);
                bote.setFont(new Font("Time New Roman", 1, 12));
                bote.setForeground(new Color(0,0,0));
                add(bote);

                comboAgua = new JComboBox();
                comboAgua.setBounds(10,350,168,25);
                comboAgua.setBackground(new java.awt.Color(224,224,224));
                comboAgua.setFont(new java.awt.Font("Andale Mono", 1, 14));
                comboAgua.setForeground(new java.awt.Color(225,0,0));
                add(comboAgua);
                comboAgua.addItem("");
                comboAgua.addItem("Ir por la pezca");
                comboAgua.addItem("Comprar Yate, 200 Mo: <===>");
                comboAgua.addItem("Comprar barco, 300 Mo: <==T==>");

                pescados = new JLabel(new ImageIcon("images/pesca.PNG"));
                pescados.setBounds(10,405,165,75);
                pescados.setVisible(false);
                add(pescados);            
        
    //Bodega
        bodega = new JLabel("BODEGA ");
        bodega.setBounds(1130,5,150,25);
        bodega.setFont(new Font("Andale Mono", 1, 16));
        bodega.setForeground(new Color(0,255,0));
        add(bodega);

        misPeces = new JTextField("Peces: 0");
        misPeces.setBounds(1040,30,150,30);
        misPeces.setBackground(new Color(255,255,0));
        misPeces.setForeground(new Color(0,0,0));
        misPeces.setEditable(false);
        add(misPeces);
        
        maiz= new JTextField("maiz(qq): ");
        maiz.setBounds(1190,30,150,30);
        maiz.setBackground(new Color(255,255,0));
        maiz.setForeground(new Color(0,0,0));
        maiz.setEditable(false);
        add(maiz);

        semMaiz= new JTextField("sem. maiz: ");
        semMaiz.setBounds(1040,60,150,30);
        semMaiz.setBackground(new Color(255,255,0));
        semMaiz.setForeground(new Color(0,0,0));
        semMaiz.setEditable(false);
        add(semMaiz);

        
        manzanasqq= new JTextField("manzanas(qq): 0");
        manzanasqq.setBounds(1190,90,150,30);
        manzanasqq.setBackground(new Color(255,255,0));
        manzanasqq.setForeground(new Color(0,0,0));
        manzanasqq.setEditable(false);
        add(manzanasqq);

        semManzana= new JTextField("sem. manzana: ");
        semManzana.setBounds(1190,60,150,30);
        semManzana.setBackground(new Color(255,255,0));
        semManzana.setForeground(new Color(0,0,0));
        semManzana.setEditable(false);
        add(semManzana);

        multifert= new JTextField("Multifert(lt): 0");
        multifert.setBounds(1040,90,150,30);
        multifert.setBackground(new Color(255,255,0));
        multifert.setForeground(new Color(0,0,0));
        multifert.setEditable(false);
        add(multifert);
        
        gallinasa= new JTextField("Gallinasa(qq): 0");
        gallinasa.setBounds(1040,120,150,30);
        gallinasa.setBackground(new Color(255,255,0));
        gallinasa.setForeground(new Color(0,0,0));
        gallinasa.setEditable(false);
        add(gallinasa);

        fungisidas= new JTextField("Fungisidas(lt): 0");
        fungisidas.setBounds(1190,120,150,30);
        fungisidas.setBackground(new Color(255,255,0));
        fungisidas.setForeground(new Color(0,0,0));
        fungisidas.setEditable(false);
        add(fungisidas);

         //crias de animales

        criasVacas= new JTextField("Crias Vacas: 0");
        criasVacas.setBounds(1040,150,150,30);
        criasVacas.setBackground(new Color(255,255,0));
        criasVacas.setForeground(new Color(0,0,0));
        criasVacas.setEditable(false);
        add(criasVacas);

        criasGallinas= new JTextField("Crias Gallinas: 0");
        criasGallinas.setBounds(1190,150,150,30);
        criasGallinas.setBackground(new Color(255,255,0));
        criasGallinas.setForeground(new Color(0,0,0));
        criasGallinas.setEditable(false);
        add(criasGallinas);

        gallinas= new JTextField("Gallinas: 0");
        gallinas.setBounds(1040,180,150,30);
        gallinas.setBackground(new Color(255,255,0));
        gallinas.setForeground(new Color(0,0,0));
        gallinas.setEditable(false);
        add(gallinas);

        vacas= new JTextField("Vacas: 0");
        vacas.setBounds(1190,180,150,30);
        vacas.setBackground(new Color(255,255,0));
        vacas.setForeground(new Color(0,0,0));
        vacas.setEditable(false);
        add(vacas);

        trigoqq= new JTextField("trigo(qq): 0");
        trigoqq.setBounds(1040,210,150,30);
        trigoqq.setBackground(new Color(255,255,0));
        trigoqq.setForeground(new Color(0,0,0));
        trigoqq.setEditable(false);
        add(trigoqq);

        afrechoqq= new JTextField("afrecho(qq): 0");
        afrechoqq.setBounds(1190,210,150,30);
        afrechoqq.setBackground(new Color(255,255,0));
        afrechoqq.setForeground(new Color(0,0,0));
        afrechoqq.setEditable(false);
        add(afrechoqq);

        pastoqq= new JTextField("pasto(qq): 0");
        pastoqq.setBounds(1040,240,150,30);
        pastoqq.setBackground(new Color(255,255,0));
        pastoqq.setForeground(new Color(0,0,0));
        pastoqq.setEditable(false);
        add(pastoqq);
        
        lechelt= new JTextField("leche(lt): 0");
        lechelt.setBounds(1190,240,150,30);
        lechelt.setBackground(new Color(255,255,0));
        lechelt.setForeground(new Color(0,0,0));
        lechelt.setEditable(false);
        add(lechelt);
        
        huevosU= new JTextField("Huevos(u): 0");
        huevosU.setBounds(1040,270,150,30);
        huevosU.setBackground(new Color(255,255,0));
        huevosU.setForeground(new Color(0,0,0));
        huevosU.setEditable(false);
        add(huevosU);

        cueroVaca= new JTextField("cuero de vaca(u): 0");
        cueroVaca.setBounds(1190,270,150,30);
        cueroVaca.setBackground(new Color(255,255,0));
        cueroVaca.setForeground(new Color(0,0,0));
        cueroVaca.setEditable(false);
        add(cueroVaca);

        carneDeGallina= new JTextField("Carne Gallina (lb): 0");
        carneDeGallina.setBounds(1040,300,150,30);
        carneDeGallina.setBackground(new Color(255,255,0));
        carneDeGallina.setForeground(new Color(0,0,0));
        carneDeGallina.setEditable(false);
        add(carneDeGallina);
        
        carneDeVaca= new JTextField("carne Vaca(qq): 0");
        carneDeVaca.setBounds(1190,300,150,30);
        carneDeVaca.setBackground(new Color(255,255,0));
        carneDeVaca.setForeground(new Color(0,0,0));
        carneDeVaca.setEditable(false);
        add(carneDeVaca);
// Trabajos en la Grama
    // sembrar plantas y cosecharlas.
       sembrarPlantas = new JLabel("Sembrar Plantas");
       sembrarPlantas.setBounds(200, 305, 150,20);
       sembrarPlantas.setFont(new Font ("Georgia", 2, 14));
       sembrarPlantas.setForeground(new Color(255,255,0));
       add(sembrarPlantas);

       plantasCreciendo = new JLabel("");
       plantasCreciendo.setBounds(190, 320, 250,20);
       plantasCreciendo.setFont(new Font ("Lucida Console", 0, 12));
       plantasCreciendo.setForeground(new Color(0,0,0));
       add(plantasCreciendo);

       plantasCreciendo1 = new JLabel("");
       plantasCreciendo1.setBounds(190, 330, 250,20);
       plantasCreciendo1.setFont(new Font ("Lucida Console", 0, 12));
       plantasCreciendo1.setForeground(new Color(0,0,0));
       add(plantasCreciendo1);

        tipoPlanta= new JComboBox();
        tipoPlanta.setBounds(190,350,150,25);
        tipoPlanta.setBackground(new java.awt.Color(153,255,0));
        tipoPlanta.setFont(new java.awt.Font("Georgia", 1, 12));
        tipoPlanta.setForeground(new java.awt.Color(0,0,0));
        add(tipoPlanta);
        tipoPlanta.addActionListener(this);
        tipoPlanta.addItem("");
        tipoPlanta.addItem("Plantar Maiz");
        tipoPlanta.addItem("Plantar Manzanas");
        tipoPlanta.addItem("Cosechar maiz");
        tipoPlanta.addItem("Cosechar manzanas");
        tipoPlanta.addItem("Aplicar Multifert");
        tipoPlanta.addItem("Aplicar Gallinasa");
        tipoPlanta.addItem("Aplicar Fungisida");
        tipoPlanta.addItem("Limpiar el terreno");

        celdas= new JComboBox();
        celdas.setBounds(190,375,150,25);
        celdas.setBackground(new java.awt.Color(153,153,204));
        celdas.setFont(new java.awt.Font("Cambria Math", 1, 12));
        celdas.setForeground(new java.awt.Color(0,0,0));
        add(celdas);
        for(int i = 1; i<= in.contadorGrama; i++){
            celdas.addItem(i);
        }

        cantPlantas = new JLabel("Cantidad de plantas");
        cantPlantas.setBounds(190,393,150,25);
        cantPlantas.setForeground(new Color(0,0,0));
        add(cantPlantas);

        cantPlantaSembrar = new JTextField("");
        cantPlantaSembrar.setBounds(190,417,50,25);
        cantPlantaSembrar.setFont(new Font("Georgia", 3, 12));
        cantPlantaSembrar.setForeground(new Color(0,0,0));
        cantPlantaSembrar.setBackground(new Color(127,255,0));
        add(cantPlantaSembrar);
        
        aceptarSiembra = new JButton("Plantar");
        aceptarSiembra.setBounds(250,413,90,30);
        aceptarSiembra.setFont(new Font("Time New Roman", 0, 12));
        aceptarSiembra.setBackground(new Color(0,0,0));
        aceptarSiembra.setForeground(new Color(255,255,255));
        aceptarSiembra.setEnabled(false);
        add(aceptarSiembra);
        aceptarSiembra.addActionListener(this);

        aceptarCosechar = new JButton("Aceptar");
        aceptarCosechar.setBounds(230,445,90,30);
        aceptarCosechar.setFont(new Font("Time New Roman", 0, 12));
        aceptarCosechar.setBackground(new Color(0,0,0));
        aceptarCosechar.setForeground(new Color(255,255,255));
        add(aceptarCosechar);
        aceptarCosechar.addActionListener(this);

        maizPlantado = new JLabel(new ImageIcon("images/maizPlantando.jpg"));
        maizPlantado.setBounds(10,480,162,180);
        maizPlantado.setVisible(false);
        add(maizPlantado);

        manzanasPlantado = new JLabel(new ImageIcon("images/mm.PNG"));
        manzanasPlantado.setBounds(170,480,162,180);
        manzanasPlantado.setVisible(false);
        add(manzanasPlantado);

        manzanaCosechado = new JLabel(new ImageIcon("images/manzancosechar.PNG"));
        manzanaCosechado.setBounds(170,480,162,180);
        manzanaCosechado.setVisible(false);
        add(manzanaCosechado);

        maizCosechado = new JLabel(new ImageIcon("images/maizcosechar.jpg"));
        maizCosechado.setBounds(10,480,162,180);
        maizCosechado.setVisible(false);
        add(maizCosechado);

//trabajos en tierras decerticas
    //criar animales
        criarAnimales = new JLabel("Criar Animales");
        criarAnimales.setBounds(377, 305, 150,20);
        criarAnimales.setFont(new Font ("Georgia", 2, 14));
        criarAnimales.setForeground(new Color(255,255,0));
        add(criarAnimales);

        animalCriar= new JComboBox();
        animalCriar.setBounds(360,355,150,25);
        animalCriar.setBackground(new java.awt.Color(106,90,205));
        animalCriar.setFont(new java.awt.Font("Georgia", 1, 12));
        animalCriar.setForeground(new java.awt.Color(255,255,255));
        add(animalCriar);
        animalCriar.addItem("");
        animalCriar.addItem("Vacas");
        animalCriar.addItem("Gallinas");

        funcionAnimal= new JComboBox();
        funcionAnimal.setBounds(360,380,150,25);
        funcionAnimal.setBackground(new java.awt.Color(106,90,205));
        funcionAnimal.setFont(new java.awt.Font("Georgia", 1, 12));
        funcionAnimal.setForeground(new java.awt.Color(255,255,255));
        add(funcionAnimal);
        funcionAnimal.addActionListener(this);
        funcionAnimal.addItem("");
        funcionAnimal.addItem("Alimentar");
        funcionAnimal.addItem("Limpiar terreno");
        funcionAnimal.addItem("Llevar a la bodega");

        parcelaAnimal= new JComboBox();
        parcelaAnimal.setBounds(360,405,150,25);
        parcelaAnimal.setBackground(new java.awt.Color(106,90,205));
        parcelaAnimal.setFont(new java.awt.Font("Georgia", 1, 12));
        parcelaAnimal.setForeground(new java.awt.Color(255,255,255));
        add(parcelaAnimal);
        parcelaAnimal.addActionListener(this);
       for(int i =1; i<=in.contadorDesierto; i++){
           parcelaAnimal.addItem(i);
       }

       cantidadAnimales = new JLabel("Cantidad");
       cantidadAnimales.setBounds(360,428, 150,20);
       cantidadAnimales.setFont(new Font ("Georgia", 0, 12));
       cantidadAnimales.setForeground(new Color(0,0,0));
       add(cantidadAnimales);

       AceptarCriarAnimal = new JButton("Criar");
       AceptarCriarAnimal.setBounds(420,433,90,30);
       AceptarCriarAnimal.setFont(new Font("Time New Roman", 0, 12));
       AceptarCriarAnimal.setBackground(new Color(0,0,0));
       AceptarCriarAnimal.setForeground(new Color(255,255,255));
       add(AceptarCriarAnimal);
       AceptarCriarAnimal.addActionListener(this);

        aceptarAnimal = new JButton("Aceptar");
        aceptarAnimal.setBounds(370,465,90,30);
        aceptarAnimal.setFont(new Font("Time New Roman", 0, 12));
        aceptarAnimal.setBackground(new Color(0,0,0));
        aceptarAnimal.setForeground(new Color(255,255,255));
        add(aceptarAnimal);
        aceptarAnimal.addActionListener(this);

        cantAnimals = new JTextField("");
        cantAnimals.setBounds(360,443,58,20);
        cantAnimals.setFont(new Font("Lucida Console", 1, 12));
        cantAnimals.setBackground(new Color(106,90,205));
        cantAnimals.setForeground(new Color(255,255,255));
        add(cantAnimals);

        comboAlimentoHervivoro= new JComboBox();
        comboAlimentoHervivoro.setBounds(510,380,100,25);
        comboAlimentoHervivoro.setBackground(new java.awt.Color(106,90,205));
        comboAlimentoHervivoro.setFont(new java.awt.Font("Georgia", 1, 12));
        comboAlimentoHervivoro.setForeground(new java.awt.Color(255,255,255));
        add(comboAlimentoHervivoro);
        comboAlimentoHervivoro.setVisible(false);
        comboAlimentoHervivoro.addItem("");
        comboAlimentoHervivoro.addItem("Pasto");
        comboAlimentoHervivoro.addItem("Afrecho");
        comboAlimentoHervivoro.addItem("Maiz");

        comboAlimentoOmnivoro= new JComboBox();
        comboAlimentoOmnivoro.setBounds(510,380,100,25);
        comboAlimentoOmnivoro.setBackground(new java.awt.Color(106,90,205));
        comboAlimentoOmnivoro.setFont(new java.awt.Font("Georgia", 1, 12));
        comboAlimentoOmnivoro.setForeground(new java.awt.Color(255,255,255));
        add(comboAlimentoOmnivoro);
        comboAlimentoOmnivoro.setVisible(false);
        comboAlimentoOmnivoro.addItem("");
        comboAlimentoOmnivoro.addItem("Peces");
        comboAlimentoOmnivoro.addItem("trigo");
        comboAlimentoOmnivoro.addItem("Maiz");

        criandoVacas = new JLabel("");
        criandoVacas.setBounds(360, 320, 250,20);
        criandoVacas.setFont(new Font ("Time New Roman", 0, 12));
        criandoVacas.setForeground(new Color(0,0,0));
        add(criandoVacas);

        criandoGallinas = new JLabel("");
        criandoGallinas.setBounds(360, 335, 250,20);
        criandoGallinas.setFont(new Font ("Time New Roman", 0, 12));
        criandoGallinas.setForeground(new Color(0,0,0));
        add(criandoGallinas);

        vacasCriando = new JLabel( new ImageIcon("images/vacasCreciendo.PNG"));
        vacasCriando.setBounds(350,500,170,150);
        vacasCriando.setVisible(false);
        add(vacasCriando);

        vacasGrandes = new JLabel(new ImageIcon("images/vacasGrandes.PNG"));
        vacasGrandes.setBounds(350,500,170,150);
        vacasGrandes.setVisible(false);
        add(vacasGrandes);

        pollosCreciendo = new JLabel(new ImageIcon("images/gallinaCreciendo.PNG"));
        pollosCreciendo.setBounds(525,470,140,180);
        pollosCreciendo.setVisible(false);
        add(pollosCreciendo);
        
        gallinasGrandes = new JLabel(new ImageIcon("images/gallinaGrande.PNG"));
        gallinasGrandes.setBounds(525,470,140,180);
        gallinasGrandes.setVisible(false);
        add(gallinasGrandes);
// alimentar al grangero, estazar vacas, gallinas, etc
        comboFuncionCasa= new JComboBox();
        comboFuncionCasa.setBounds(680,560,160,25);
        comboFuncionCasa.setBackground(new java.awt.Color(0,70,255));
        comboFuncionCasa.setFont(new java.awt.Font("Georgia", 1, 12));
        comboFuncionCasa.setForeground(new java.awt.Color(255,255,255));
        add(comboFuncionCasa);
        comboFuncionCasa.addActionListener(this);
        comboFuncionCasa.addItem("");
        comboFuncionCasa.addItem("Destazar Vaca");
        comboFuncionCasa.addItem("Destazar Gallina");
        comboFuncionCasa.addItem("Comer (Granjero)");

        comboAlimentoGrangero= new JComboBox();
        comboAlimentoGrangero.setBounds(740,590,100,25);
        comboAlimentoGrangero.setBackground(new java.awt.Color(136,0,255));
        comboAlimentoGrangero.setFont(new java.awt.Font("Georgia", 1, 12));
        comboAlimentoGrangero.setForeground(new java.awt.Color(255,255,255));
        add(comboAlimentoGrangero);
        comboAlimentoGrangero.addActionListener(this);
        comboAlimentoGrangero.setVisible(false);
        comboAlimentoGrangero.addItem("");
        comboAlimentoGrangero.addItem("Peces");
        comboAlimentoGrangero.addItem("Tortillas");
        comboAlimentoGrangero.addItem("Carne Vaca");
        comboAlimentoGrangero.addItem("Carne Gallina");
        comboAlimentoGrangero.addItem("Manzanas");
        comboAlimentoGrangero.addItem("Leche");
        comboAlimentoGrangero.addItem("Huevos");

        enLaGranja = new JLabel("EN TU CASA");
        enLaGranja.setBounds(680,525,300,30);
        enLaGranja.setFont(new Font("Castellar", 1, 18));
        enLaGranja.setForeground(new Color(255,0,0));
        add(enLaGranja);

        cantidadComidaGrangero=new JLabel("Cantidad");
        cantidadComidaGrangero.setBounds(680,579,90,25);
        cantidadComidaGrangero.setForeground(new Color(0,0,0));
        add(cantidadComidaGrangero);

        cantidadAlimentoGrangero = new JTextField("");
        cantidadAlimentoGrangero.setBounds(680,598,58,20);
        cantidadAlimentoGrangero.setFont(new Font("Lucida Console", 1, 12));
        cantidadAlimentoGrangero.setBackground(new Color(0,90,255));
        cantidadAlimentoGrangero.setForeground(new Color(255,255,255));
        add(cantidadAlimentoGrangero);

        aceptarFuncionEnCasa = new JButton("Aceptar");
        aceptarFuncionEnCasa.setBounds(725,620,90,30);
        aceptarFuncionEnCasa.setFont(new Font("Time New Roman", 0, 12));
        aceptarFuncionEnCasa.setBackground(new Color(0,0,0));
        aceptarFuncionEnCasa.setForeground(new Color(255,255,255));
        add(aceptarFuncionEnCasa);
        aceptarFuncionEnCasa.addActionListener(this);

//
//hilos de plantas
        Cosecha cosechamaiz = new Cosecha();
        cosechamaiz.recibeJlabelYCantidadplantas(plantasCreciendo,tipplanta, cantidadplantassembrar, maizPlantado, maizCosechado, contadorLimpieza, celdamaiz, celdaSembrarMaiz);
        hilosembrar1= new Thread(cosechamaiz);

        cosechamanzan = new Cosecha1(plantasCreciendo1,tipplanta1, cantidadplantassembrar, manzanasPlantado, manzanaCosechado, hilosembrar2, contadorLimpieza);
        hilosembrar2= new Thread(cosechamanzan);
//
    
//Mercado
    //comprar semillas.
        mercado = new JLabel("MERCADO ");
        mercado.setBounds(1150,392,150,25);
        mercado.setFont(new Font("Stencil", 0, 16));
        mercado.setForeground(new Color(0,0,255));
        add(mercado);

        comboSemillas = new JComboBox();
        comboSemillas.setBounds(1050,442,145,25);
        comboSemillas.setBackground(new java.awt.Color(0,224,224));
        comboSemillas.setFont(new java.awt.Font("Andale Mono", 1, 12));
        comboSemillas.setForeground(new java.awt.Color(225,0,0));
        add(comboSemillas);
        comboSemillas.addItem("");
        comboSemillas.addItem("Semillas de maiz");
        comboSemillas.addItem("Semillas de Manzano");

        comprarSemillas = new JLabel("comprar semillas");
        comprarSemillas.setBounds(1050,419,110,25);
        comprarSemillas.setForeground(new Color(0,0,0));
        add(comprarSemillas);

        aceptarSemillas = new JButton("Comprar");
        aceptarSemillas.setBounds(1105,477,90,30);
        aceptarSemillas.setFont(new Font("Time New Roman", 1, 12));
        aceptarSemillas.setForeground(new Color(255,255,255));
        aceptarSemillas.setBackground(new Color(0,0,0));
        add(aceptarSemillas);
        aceptarSemillas.addActionListener(this);

        cantSemillas = new JTextField("  ");
        cantSemillas.setBounds(1050,482,50,25);
        cantSemillas.setFont(new Font("Andale Mono", 1, 14));
        cantSemillas.setForeground(new Color(255,0,0));
        cantSemillas.setBackground(new Color(0,255,255));
        add(cantSemillas);

        semm= new JLabel("Cantidad");
        semm.setBounds(1050,460,80,30);
        semm.setForeground(new Color(0,0,0));
        add(semm);
    //Vender productos

	  comboVenta = new JComboBox();
	  comboVenta.setBounds(1200,442,145,25);
	  comboVenta.setBackground(new java.awt.Color(0,224,224));
	  comboVenta.setFont(new java.awt.Font("Andale Mono", 1, 12));
	  comboVenta.setForeground(new java.awt.Color(0,0,0));
	  add(comboVenta);
	  comboVenta.addItem("");
	  comboVenta.addItem("Peces (unidad)");
	  comboVenta.addItem("Maiz (Quintales)");
      comboVenta.addItem("manzanas (quintales)");
      comboVenta.addItem("Gallinas");
      comboVenta.addItem("Vacas");
      comboVenta.addItem("Leche (lt)");
      comboVenta.addItem("Huevos (u)");
      comboVenta.addItem("Cuero Vacas (u)");
      comboVenta.addItem("Carne Vaca (qq)");
      comboVenta.addItem("Carne gallina(lb)");

	  venderProductos = new JLabel("Vender Productos");
	  venderProductos.setBounds(1200,419,110,25);
	  venderProductos.setForeground(new Color(0,0,0));
	  add(venderProductos);

	  semM= new JLabel("Cantidad");
	  semM.setBounds(1200,460,80,30);
	  semM.setForeground(new Color(0,0,0));
	  add(semM);

	  cantVenta = new JTextField("");
	  cantVenta.setBounds(1200,482,50,25);
	  cantVenta.setFont(new Font("Andale Mono", 1, 14));
	  cantVenta.setForeground(new Color(255,0,0));
	  cantVenta.setBackground(new Color(0,255,255));
	  add(cantVenta);

	  	aceptarVenta = new JButton("Vender");
        aceptarVenta.setBounds(1255,477,90,30);
        aceptarVenta.setFont(new Font("Time New Roman", 1, 12));
        aceptarVenta.setForeground(new Color(255,255,255));
        aceptarVenta.setBackground(new Color(0,0,0));
        add(aceptarVenta);
        aceptarVenta.addActionListener(this);

    //comprar comida para los animales
       VentaComidaAnimales = new JLabel("Comida para animales");
       VentaComidaAnimales.setBounds(1050,512, 150,25);
       VentaComidaAnimales.setForeground(new Color(0,0,0));
       add(VentaComidaAnimales);

        comidaAnimalesV = new JComboBox();
        comidaAnimalesV.setBounds(1050,562,145,25);
        comidaAnimalesV.setBackground(new java.awt.Color(0,224,224));
        comidaAnimalesV.setFont(new java.awt.Font("Andale Mono", 1, 12));
        comidaAnimalesV.setForeground(new java.awt.Color(0,0,0));
        comidaAnimalesV.setVisible(false);
        add(comidaAnimalesV);
        comidaAnimalesV.addItem("");
        comidaAnimalesV.addItem("Afrecho");
        comidaAnimalesV.addItem("Pasto");

        comidaAnimalesG = new JComboBox();
        comidaAnimalesG.setBounds(1050,562,145,25);
        comidaAnimalesG.setBackground(new java.awt.Color(0,224,224));
        comidaAnimalesG.setFont(new java.awt.Font("Andale Mono", 1, 12));
        comidaAnimalesG.setForeground(new java.awt.Color(0,0,0));
        comidaAnimalesG.setVisible(false);
        add(comidaAnimalesG);
        comidaAnimalesG.addItem("");
        comidaAnimalesG.addItem("trigo");
       

        tipoAnimal = new JComboBox();
        tipoAnimal.setBounds(1050,537,145,25);
        tipoAnimal.setBackground(new java.awt.Color(0,224,224));
        tipoAnimal.setFont(new java.awt.Font("Andale Mono", 1, 12));
        tipoAnimal.setForeground(new java.awt.Color(0,0,0));
        add(tipoAnimal);
        tipoAnimal.addActionListener(this);
        tipoAnimal.addItem("");
        tipoAnimal.addItem("Herbivoro");
        tipoAnimal.addItem("Omnivoro");

        cantComidaAnimal = new JTextField("");
        cantComidaAnimal.setBounds(1050,602,50,25);
        cantComidaAnimal.setFont(new Font("Andale Mono", 1, 14));
        cantComidaAnimal.setForeground(new Color(255,0,0));
        cantComidaAnimal.setBackground(new Color(0,255,255));
        add(cantComidaAnimal);

        cantComidaAM = new JLabel("Cantidad");
        cantComidaAM.setBounds(1050,582,90,25);
        cantComidaAM.setForeground(new Color(0,0,0));
        add(cantComidaAM);

        comprarComidaAnimal = new JButton("Comprar");
        comprarComidaAnimal.setBounds(1105,599,90,30);
        comprarComidaAnimal.setFont(new Font("Time New Roman", 1, 12));
        comprarComidaAnimal.setForeground(new Color(255,255,255));
        comprarComidaAnimal.setBackground(new Color(0,0,0));
        add(comprarComidaAnimal);
        comprarComidaAnimal.addActionListener(this);
    // fertilizantes para la tierra
       fertTerreno = new JLabel("Fertilizantes, terreno");
       fertTerreno.setBounds(1200,512, 150,25);
       fertTerreno.setForeground(new Color(0,0,0));
       add(fertTerreno);

        fertilizante = new JComboBox();
        fertilizante.setBounds(1200,537,145,25);
        fertilizante.setBackground(new java.awt.Color(0,224,224));
        fertilizante.setFont(new java.awt.Font("Andale Mono", 1, 12));
        fertilizante.setForeground(new java.awt.Color(225,0,0));
        add(fertilizante);
        fertilizante.addItem("");
        fertilizante.addItem("Multifert");
        fertilizante.addItem("Gallinasa");
        fertilizante.addItem("Fungisidas");

        cantFertilizante = new JTextField("");
        cantFertilizante.setBounds(1200,577,50,25);
        cantFertilizante.setFont(new Font("Andale Mono", 1, 14));
        cantFertilizante.setForeground(new Color(255,0,0));
        cantFertilizante.setBackground(new Color(0,255,255));
        add(cantFertilizante);

        cantFRT = new JLabel("Cantidad");
        cantFRT.setBounds(1200,557,90,25);
        cantFRT.setForeground(new Color(0,0,0));
        add(cantFRT);

        comprarFertilizante = new JButton("Comprar");
        comprarFertilizante.setBounds(1255,574,90,30);
        comprarFertilizante.setFont(new Font("Time New Roman", 1, 12));
        comprarFertilizante.setForeground(new Color(255,255,255));
        comprarFertilizante.setBackground(new Color(0,0,0));
        add(comprarFertilizante);
        comprarFertilizante.addActionListener(this);

    //comprar crias de animales
        comprarCrias = new JLabel("Crias y Animales");
        comprarCrias.setBounds(890,540, 200,25);
        comprarCrias.setForeground(new Color(0,0,0));
        add(comprarCrias);

        comboCria = new JComboBox();
        comboCria.setBounds(890,560,145,25);
        comboCria.setBackground(new java.awt.Color(0,224,224));
        comboCria.setFont(new java.awt.Font("Andale Mono", 1, 12));
        comboCria.setForeground(new java.awt.Color(0,0,0));
        add(comboCria);
        comboCria.addItem("");
        comboCria.addItem("Gallinas");
        comboCria.addItem("Vacas");

        cantCrias = new JTextField("");
        cantCrias.setBounds(890,600,50,25);
        cantCrias.setFont(new Font("Andale Mono", 1, 14));
        cantCrias.setForeground(new Color(255,0,0));
        cantCrias.setBackground(new Color(0,255,255));
        add(cantCrias);

        aceptarCompraCrias = new JButton("Comprar");
        aceptarCompraCrias.setBounds(945,595,90,30);
        aceptarCompraCrias.setFont(new Font("Time New Roman", 1, 12));
        aceptarCompraCrias.setForeground(new Color(255,255,255));
        aceptarCompraCrias.setBackground(new Color(0,0,0));
        add(aceptarCompraCrias);
        aceptarCompraCrias.addActionListener(this);

        cantidadCrias = new JLabel("Cantidad");
        cantidadCrias.setBounds(890,582,90,20);
        cantidadCrias.setForeground(new Color(0,0,0));
        add(cantidadCrias);

    
//Menu de arriba:
       barra = new JMenuBar();
       barra.setBackground(new Color(0,255,255));
       setJMenuBar(barra);

       opciones = new JMenu("Opciones");
       opciones.setBackground(new Color(255,0,0));
       opciones.setFont(new Font("Georgia", 1,14));
       opciones.setForeground(new Color(0,0,0));
       barra.add(opciones);

       miReportes= new JMenuItem("Reportes");
       miReportes.setFont(new Font("Georgia", 1,14));
       miReportes.setForeground(new Color(0,0,0));
       opciones.add(miReportes);
       miReportes.addActionListener(this);

       mFondo = new JMenu("Fondo");
       mFondo.setFont(new Font("Georgia", 1, 14));
       mFondo.setForeground(new Color(0,0,0));
       opciones.add(mFondo);

       //colores
        miRojo = new JMenuItem("Rojo");
        miRojo.setFont(new Font("Georgia", 1, 14));
        miRojo.setForeground(new Color(255,0,0));
        mFondo.add(miRojo);
        miRojo.addActionListener(this);

        miNegro = new JMenuItem("Negro");
        miNegro.setFont(new Font("Georgia", 1, 14));
        miNegro.setForeground(new Color(0,0,0));
        mFondo.add(miNegro);
        miNegro.addActionListener(this);

        miMorado = new JMenuItem("Morado");
        miMorado.setFont(new Font("Georgia", 1, 14));
        miMorado.setForeground(new Color(87,35,100));
        mFondo.add(miMorado);
        miMorado.addActionListener(this);

        miAzul = new JMenuItem("Azul");
        miAzul.setFont(new Font("Georgia", 1, 14));
        miAzul.setForeground(new Color(62,95,138));
        mFondo.add(miAzul);
        miAzul.addActionListener(this);
    //
       nuevo = new JMenu("Nuevo");
       nuevo.setBackground(new Color(255,0,0));
       nuevo.setFont(new Font("Georgia",1,14));
       nuevo.setForeground(new Color(0,0,0));
       barra.add(nuevo);

       miNuveaPartida = new JMenuItem("Partida");
       miNuveaPartida.setFont(new Font("Georgia", 1, 14));
       miNuveaPartida.setForeground(new Color(0,0,0));
       nuevo.add(miNuveaPartida);
       miNuveaPartida.addActionListener(this);

       acercaDe = new JMenu("Acerca de");
       acercaDe.setBackground(new Color(255,0,0));
        acercaDe.setFont(new Font("Georgia",1,14));
       acercaDe.setForeground(new Color(0,0,0));
       barra.add(acercaDe);

       miAcercaDe = new JMenuItem("El creador");
       miAcercaDe.setFont(new Font("Georgia", 1, 14));
       miAcercaDe.setForeground(new Color(0,0,0));
       acercaDe.add(miAcercaDe);
       miAcercaDe.addActionListener(this);

       salir = new JMenuItem("Salir");
       salir.setFont(new Font("Georgia",1,14));
       salir.setForeground(new Color(0,0,0));
       opciones.add(salir);
       salir.addActionListener(this);

       oro= new JTextField("Tu oro: " + Jugador.monedasOro);
       oro.setBounds(475,10,100,30);
       oro.setBackground(new Color(0,255,255));
       oro.setForeground(new Color(0,0,0));
       oro.setEditable(false);
       add(oro);
       puntaje= new JTextField("Puntos: " + Jugador.puntos);
       puntaje.setBounds(600,10,100,30);
       puntaje.setBackground(new Color(255,0,0));
       puntaje.setForeground(new Color(255,255,255));
       puntaje.setEditable(false);
       add(puntaje);

       tuVida = new JLabel("Vida: " + Jugador.vida);
       tuVida.setBounds(725,10,200,30);
       tuVida.setFont(new Font("Castellar",1,18));
       tuVida.setForeground(new Color(0,0,0));
       add(tuVida);

       tiempoPartida=new JLabel("");
       tiempoPartida.setBounds(860,10,100,30 );
       tiempoPartida.setFont(new Font("Showcard Gothic", 0,18));
       tiempoPartida.setForeground(new Color(0,0,0));
       add(tiempoPartida);

       TiempoPartida tmp = new TiempoPartida(tiempoPartida);
       hiloTiempo = new Thread(tmp);
       hiloTiempo.start();

        tmv = new TiempoVida(tuVida, aceptarAgua, aceptarSiembra, aceptarCosechar, AceptarCriarAnimal,
        aceptarAnimal, aceptarFuncionEnCasa, aceptarSemillas, aceptarVenta, comprarComidaAnimal,
       comprarFertilizante, aceptarCompraCrias, hiloTiempo);
       tiempoVida[contadorHilos]=new Thread(tmv);
       tiempoVida[contadorHilos].start();

       bienvenido = new JLabel("Bienvenido: " + Jugador.nombreenjuego);
       bienvenido.setBounds(560,90,500,50);
       bienvenido.setFont(new Font("Stencil",3,30));
       bienvenido.setForeground(new Color(255,0,0));
       add(bienvenido);

       granjer = new JLabel(new ImageIcon("images/Granjero.jpg"));
       granjer.setBounds(600,150,316,288);
       add(granjer);

       fondo=new JLabel(new ImageIcon("images/fondo.jpg"));
       fondo.setBounds(2,0,1350,660);
       add(fondo);



    }
//Eventos para los botones
    public void actionPerformed(ActionEvent e){
        tipplanta = tipoPlanta.getSelectedItem().toString();
        tipplanta1 =tipoPlanta.getSelectedItem().toString();

        //hilos de periodo de comida de las vacas y gallinas
            CriarVacas criarvacas = new CriarVacas(criandoVacas, vacasCriando);
            Thread hiloVacas = new Thread(criarvacas);

            CriarGallinas criargallinas = new CriarGallinas(criandoGallinas, pollosCreciendo);
            Thread hiloGallinas = new Thread(criargallinas);

        //

    //para pescar
        pesca = new Pesca();
        pesca.recibeJLabel(pezenagua, pescados);
        Thread hilo1 = new Thread(pesca);
        pesca1 = new Pesca();
        pesca1.recibeJLabel(pezenagua, pescados);
        Thread hilo2 = new Thread(pesca1);

        if(e.getSource()==aceptarBote){
            if(pesca.getpecesEnAgua()<100){
                hilo1.start();
            }else{
            }
        }
      if(e.getSource()==aceptarAgua){
          String seleccion = comboAgua.getSelectedItem().toString();
          if(seleccion.equals("Ir por la pezca")){
              if(bote.getText().equals("Tu bote: " + barco1) || bote.getText().equals("Tu bote: " + barco2)){
                    if(Pesca.pecesEnAgua<80){
                            JOptionPane.showMessageDialog(null,"No hay peces sufucientes en los " + in.contadorAgua + " pozos de agua, clik en G.peces para que empiecen a crecer.");

                    }else if(bote.getText().equals("Tu bote: " + barco1)){
                        pescados.setVisible(false);
                        Pesca.pecesCazados=Pesca.pecesCazados + Pesca.pecesEnAgua;
                        misPeces.setText("Peces: " + Pesca.pecesCazados);
                        Reportes.pecesGranja = Reportes.pecesGranja+Pesca.pecesEnAgua;
                        Reportes.peces1.setText("Peces: " + Reportes.pecesGranja);
                        hilo1.start();
                    }else if(bote.getText().equals("Tu bote: " + barco2)){
                        pescados.setVisible(false);
                        Pesca.pecesCazados=Pesca.pecesCazados + Pesca.pecesEnAgua + 40;
                        misPeces.setText("Peces: " + Pesca.pecesCazados);
                        hilo1.start();
                    }
                       
                }else{
                    JOptionPane.showMessageDialog(null,"No has comprado un barco para pezcar!, el mas caro te puede generar mas pesca!");
                }
              
            }else if(seleccion.equals("Comprar Yate, 200 Mo: <===>")){
                if(Jugador.monedasOro<200){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar este barco!");
                }else{
                    Jugador.monedasOro = Jugador.monedasOro - 200;
                    bote.setText("Tu bote: " + barco1);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    aceptarBote.setEnabled(true);
                }
            }else if(seleccion.equals("Comprar barco, 300 Mo: <==T==>")){
                if(Jugador.monedasOro<300){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar este barco!");
                }else{
                    Jugador.monedasOro = Jugador.monedasOro - 300;
                    bote.setText("Tu bote: " + barco2);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    aceptarBote.setEnabled(true);
                }
            }
        }
    //para comprar semillas
        if(e.getSource()==aceptarSemillas){
            String opSeleccionada = comboSemillas.getSelectedItem().toString();
            String seleccionCantidad=cantSemillas.getText().toString();
            double cantidadSemillas = Double.parseDouble(seleccionCantidad);
            if(opSeleccionada.equals("Semillas de maiz")){
                double cantidadOroxSemillasm = cantidadSemillas * 0.25;
                if(seleccionCantidad.equals("  ")){
                    JOptionPane.showMessageDialog(null, "Elije la cantidad de semillas");
                }else if(Jugador.monedasOro<cantidadOroxSemillasm){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar esta cantidad de semillas");
                }else{
                	Jugador.monedasOro = Jugador.monedasOro - cantidadOroxSemillasm;
                    Jugador.maiz =Jugador.maiz+ cantidadSemillas;
                    semMaiz.setText("sem. maiz: " + Jugador.maiz);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Reportes.semmill = Reportes.semmill + cantidadSemillas;
                    Reportes.semT.setText(""+Reportes.semmill);
                }
            }else if(opSeleccionada.equals("Semillas de Manzano")){
                double cantidadOroxSemillasM = cantidadSemillas * 0.25;
                if(Jugador.monedasOro<cantidadOroxSemillasM){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar esta cantidad de semillas");
                }else{
                    Jugador.monedasOro = Jugador.monedasOro - cantidadOroxSemillasM;
                    Jugador.manzanas = Jugador.manzanas + cantidadSemillas;
                    semManzana.setText("sem. manzana: " + Jugador.manzanas);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Reportes.semmill = Reportes.semmill + cantidadSemillas;
                    Reportes.semT.setText(""+Reportes.semmill);
                }
            }
    //para comprar fertilizantes para terreno
        }else if(e.getSource()==comprarFertilizante){
            String fertSeleccionado = fertilizante.getSelectedItem().toString();
            String catidadFert =  cantFertilizante.getText().toString();
            double cantfer = Double.parseDouble(catidadFert);
            if(fertSeleccionado.equals("Multifert")){
                if(Jugador.monedasOro<(cantfer*3)){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar el Multifert, cada litro te cuesta 3 MO");
                }else{
                    Jugador.monedasOro = Jugador.monedasOro - (cantfer*3);
                    multf = multf + cantfer;
                    oro.setText("Tu oro:  " + Jugador.monedasOro);
                    multifert.setText("Multifert(lt): " + multf);
                }
            }else if(fertSeleccionado.equals("Gallinasa")){
                if(Jugador.monedasOro<(cantfer*4)){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar la Gallinasa, cada litro te cuesta 4 MO");
                }else{
                    Jugador.monedasOro = Jugador.monedasOro -(cantfer*4);
                    galli = galli + cantfer;
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    gallinasa.setText("Gallinasa(qq): " + galli);
                }
            }else if(fertSeleccionado.equals("Fungisidas")){
                if(Jugador.monedasOro<(cantfer*5)){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar el Fungisida, cada litro te cuesta 5 MO");
                }else{
                    Jugador.monedasOro = Jugador.monedasOro - (cantfer*5);
                    fungi = fungi + cantfer;
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    fungisidas.setText("Fungisida(lt): " + fungi);

                }
            }
	//para vender produtos
        } else if(e.getSource()==aceptarVenta){

			String seleccionVenta = comboVenta.getSelectedItem().toString();
			String cantSeleccionada = cantVenta.getText().toString();
			double cantProducto = Double.parseDouble(cantSeleccionada);
            double oroPorVenta;

			if(seleccionVenta.equals("Peces (unidad)")){
                if(Pesca.pecesCazados<cantProducto){
                    JOptionPane.showMessageDialog(null, "No tienes la cantidad de peces para venderlos!");
                }else{
                    Pesca.pecesCazados = Pesca.pecesCazados - cantProducto;
                    oroPorVenta = cantProducto*0.25;
                    Jugador.monedasOro = Jugador.monedasOro + oroPorVenta;
                    double puntos = cantProducto*0.5;
                    Jugador.puntos = Jugador.puntos + puntos;
                    misPeces.setText("Peces: " + Pesca.pecesCazados);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
			}else if(seleccionVenta.equals("Maiz (Quintales)")){
                if(Cosecha.maizquintales<cantProducto){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de maiz para vender");
                }else{
                    Cosecha.maizquintales = Cosecha.maizquintales - cantProducto;
                    oroPorVenta = cantProducto*2;
                    Jugador.monedasOro = Jugador.monedasOro + oroPorVenta;
                    double puntosm = (cantProducto + oroPorVenta) * 0.5;
                    Jugador.puntos = Jugador.puntos + puntosm;
                    maiz.setText("maiz(qq): " + Cosecha.maizquintales);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
			}else if(seleccionVenta.equals("manzanas (quintales)")){
                if(Cosecha1.manzanasquintales<cantProducto){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de manzanas para vender");
                }else{
                    Cosecha1.manzanasquintales = Cosecha1.manzanasquintales - cantProducto;
                    oroPorVenta= cantProducto*10;
                    Jugador.monedasOro = Jugador.monedasOro + oroPorVenta;
                    double puntosman = (cantProducto + oroPorVenta)*0.5;
                    Jugador.puntos = Jugador.puntos + puntosman;
                    manzanasqq.setText("manzanas(qq): " + Cosecha1.manzanasquintales);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
            }
            else if(seleccionVenta.equals("Gallinas")){
                if(Jugador.gallinasVender<cantProducto){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de Gallinas para vender, compra crias en el mercado, crecelas y cuando esten grandes, podras venderlas");
                }else{
                    Jugador.gallinasVender = Jugador.gallinasVender - cantProducto;
                    gallinas.setText("Gallinas: " + Jugador.gallinasVender);
                    oroPorVenta=(cantProducto*30);
                    Jugador.monedasOro = Jugador.monedasOro + (cantProducto*30);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Jugador.puntos = Jugador.puntos + ((cantProducto*30)/15);
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
            }else if(seleccionVenta.equals("Vacas")){
                if(Jugador.vacasVender<cantProducto){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantida de Vacas para vender, compra crias en el mercado, crecelas y cuando esten grander podras venderlas");
                }else{
                    Jugador.vacasVender = Jugador.vacasVender - cantProducto;
                    vacas.setText("Vacas: " + Jugador.vacasVender);
                    oroPorVenta =(cantProducto*300);
                    Jugador.monedasOro = Jugador.monedasOro + (cantProducto*300);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Jugador.puntos = Jugador.puntos + (cantProducto*8);
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
            }else if(seleccionVenta.equals("Leche (lt)")){
                if(Jugador.lecheVaca<cantProducto){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de leche de vaca para vender");
                }else{
                    Jugador.lecheVaca = Jugador.lecheVaca-cantProducto;
                    lechelt.setText("Leche vaca(lt): " + Jugador.lecheVaca);
                    oroPorVenta = cantProducto*2;
                    Jugador.monedasOro = Jugador.monedasOro + oroPorVenta;
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Jugador.puntos=Jugador.puntos + cantProducto*1;
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
            }else if(seleccionVenta.equals("Huevos (u)")){
                if(Jugador.huevosGallina<cantProducto){
                    JOptionPane.showMessageDialog(null, "En la granja no hay esta cantidad de huevos de gallina");
                }else{
                    Jugador.huevosGallina = Jugador.huevosGallina - cantProducto;
                    huevosU.setText("Huevos (u): " + Jugador.huevosGallina);
                    oroPorVenta=cantProducto*0.25;
                    Jugador.monedasOro = Jugador.monedasOro + oroPorVenta;
                    Jugador.monedasOro = Math.round(Jugador.monedasOro*100.0)/100.0;
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Jugador.puntos = Jugador.puntos + cantProducto*0.5;
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
            }else if(seleccionVenta.equals("Cuero Vacas (u)")){
                if(Jugador.cueroVaca<cantProducto){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de cuero de vaca para vender");
                }else{
                    Jugador.cueroVaca = Jugador.cueroVaca -cantProducto;
                    cueroVaca.setText("cuero de Vaca(u): " + Jugador.cueroVaca);
                    oroPorVenta=cantProducto*30;
                    Jugador.monedasOro = Jugador.monedasOro + oroPorVenta;
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Jugador.puntos = Jugador.puntos + (cantProducto*10);
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
            }else if(seleccionVenta.equals("Carne Vaca (qq)")){
                if(Jugador.carneVaca<cantProducto){
                    JOptionPane.showMessageDialog(null, "La bodega no tiene esta cantidad de carne de vaca para vender");
                }else{
                    Jugador.carneVaca = Jugador.carneVaca- cantProducto;
                    carneDeVaca.setText("carne Vaca(qq): " + Jugador.carneVaca);
                    oroPorVenta = cantProducto*7;
                    Jugador.monedasOro = Jugador.monedasOro + oroPorVenta;
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Jugador.puntos = Jugador.puntos + cantProducto*5;
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
            }else if(seleccionVenta.equals("Carne gallina(lb)")){
                if(Jugador.carneGallina<cantProducto){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de carne de gallina para vender");
                }else{
                    Jugador.carneGallina = Jugador.carneGallina - cantProducto;
                    carneDeGallina.setText("Carne Gallina(lb): " + Jugador.carneGallina);
                    oroPorVenta = cantProducto*0.15;
                    Jugador.monedasOro = Jugador.monedasOro + oroPorVenta;
                    Jugador.monedasOro = Math.round(Jugador.monedasOro*100.0)/100.0;
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Jugador.puntos=Jugador.puntos + cantProducto*3;
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.oroG = Reportes.oroG + oroPorVenta;
                    Reportes.oroGranja.setText(""+Reportes.oroG);
                }
            }
    //para sembrar plantas
    
		}else if(e.getSource()==aceptarCosechar){
            cantidadpnatassembr = cantPlantaSembrar.getText().toString();
            cantidadplantassembrar=0 + Double.parseDouble(cantidadpnatassembr);
            if(tipplanta.equals("Plantar Maiz")){
               if((Jugador.maiz)<(cantidadplantassembrar*2)){
                    JOptionPane.showMessageDialog(null, "No tienes semillas para plantar esta cantidad de maiz, compra: " + (cantidadplantassembrar*2) + " semillas de maiz");
                }else if(Cosecha.cosechaMaiz==0){
                    JOptionPane.showMessageDialog(null, "No hay maiz para cosechar, llena todos los campos y haz " + 
                    "clic en el boton Plantar para empezar a plantar; debes comprar dos semillas para " + 
                    "cada planta.");
                    aceptarSiembra.setEnabled(true);

                }else{
                   JOptionPane.showMessageDialog(null,"Posiblemente no has cosechado esta planta");
                }
            }else if(tipplanta.equals("Plantar Manzanas")){
                if((Jugador.manzanas)<(cantidadplantassembrar*3)){
                    JOptionPane.showMessageDialog(null, "No tienes semillas para plantar esta cantidad de manzanas, compra: " + (cantidadplantassembrar*3) + " semillas de manzanas");
                }else if(Cosecha1.cosechaManzana==0){
                    JOptionPane.showMessageDialog(null,"No hay Manzanas para cosechar, llena todos los campos y haz " + 
                    "clic en el boton Plantar para empezar a plantar; debes comprar tres semillas para " + 
                    "cada planta.");
                    aceptarSiembra.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Posiblemente no has cosechado esta planta");
                }
            }else if(tipplanta.equals("Cosechar maiz")){
                if(Cosecha.cosechaMaiz<=0){
                    JOptionPane.showMessageDialog(null, "No hay maiz suficiente para cosechar, asegurese de haber plantado");
                }else{
                    Cosecha.hiloCosechamaiz.stop();
                    Cosecha.maizquintales = (Cosecha.maizquintales+ (Cosecha.cosechaMaiz))+ (Cosecha.aumentoMaiz*(Cosecha.cosechaMaiz*celdamaiz));
                    Cosecha.maizquintales = Math.round(Cosecha.maizquintales*100.0)/100.0;
                    maizCosechado.setVisible(false);
                    maiz.setText("maiz(qq): " + Cosecha.maizquintales);
                    Reportes.maizGranja=(Reportes.maizGranja+Cosecha.cosechaMaiz)+(Cosecha.aumentoMaiz*Cosecha.cosechaMaiz*celdamaiz);
                    Reportes.maizGranja=Math.round(Reportes.maizGranja*100.0)/100.0;
                    Reportes.tortillas1.setText("maiz: " + Reportes.maizGranja);
                    celdamaiz=0;
                    celdaSembrarMaiz = celdamaiz;
                    Cosecha.cosechaMaiz=0;
                }
            }else if(tipplanta.equals("Cosechar manzanas")){
                if(vidaManzanas==4&&Cosecha1.cosechaManzana!=0){
                    JOptionPane.showMessageDialog(null, "Las plantas de manzanas dejaron de producir, limpia el terreno y siembra nuevas Manzanas");
                }else if(Cosecha1.cosechaManzana<=0 && vidaManzanas==0){
                    JOptionPane.showMessageDialog(null, "No hay suficientes manzanas para cosechar, asegurese de haber plantado");
                }else if(Cosecha1.cosechaManzana==0){
                    JOptionPane.showMessageDialog(null, "No hay suficientes manzanas, espera a que puedan crecer");
                }
                else{
                    Cosecha1.manzanasquintales = (Cosecha1.manzanasquintales + (Cosecha1.cosechaManzana)) + (Cosecha1.aumentoManzanas*(Cosecha1.cosechaManzana*celdamanzana));
                    Cosecha1.manzanasquintales = Math.round(Cosecha1.manzanasquintales*100.0)/100.0;
                    manzanasqq.setText("manzanas(qq): " + Cosecha1.manzanasquintales);
                    Reportes.manzanasGranja=(Reportes.manzanasGranja + (Cosecha1.cosechaManzana)) + (Cosecha1.aumentoManzanas*(Cosecha1.cosechaManzana*celdamanzana));
                    Reportes.manzanas1.setText("mnz: " + Reportes.manzanasGranja);
                    Cosecha1.cosechaManzana=0;
                    vidaManzanas++;
                    Cosecha1.hiloCosechamanzan.stop();
                    manzanaCosechado.setVisible(false);
                    manzanasPlantado.setVisible(true);
                    hilosembrar2.start();
                }
            }else if(tipplanta.equals("Aplicar Multifert")){
                if(multf<cantidadplantassembrar){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de Multifert, anda al mercado para comprar!");
                }else{
                    multf = multf - cantidadplantassembrar;
                    multifert.setText("Multifert(lt): " + multf);
                    Cosecha1.aumentoManzanas = Cosecha1.aumentoManzanas + ((cantidadplantassembrar*1)/3);
                    Cosecha.aumentoMaiz = Cosecha.aumentoMaiz + 0.5 + ((cantidadplantassembrar*1)/10);
                }
            }else if(tipplanta.equals("Aplicar Gallinasa")){
                if(galli<cantidadplantassembrar){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de Gallinasa, anda el mercado para comprar!");
                }else{
                    galli = galli - cantidadplantassembrar;
                    gallinasa.setText("Gallinasa(qq): " + galli);
                    Cosecha1.aumentoManzanas = Cosecha1.aumentoManzanas +0.5+((cantidadplantassembrar*1)/2);
                    Cosecha.aumentoMaiz = Cosecha.aumentoMaiz +0.5+ ((cantidadplantassembrar*1)/5);
                }
            }else if(tipplanta.equals("Aplicar Fungisida")){
                if(fungi<cantidadplantassembrar){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de Fungisida, anda al mercado para comprar!");
                }else{
                    fungi = fungi-cantidadplantassembrar;
                    fungisidas.setText("Fungisidas(lt): " + fungi);
                    Cosecha1.aumentoManzanas = Cosecha1.aumentoManzanas +0.7+ ((cantidadplantassembrar*1));
                    Cosecha.aumentoMaiz = Cosecha.aumentoMaiz +0.5+ ((cantidadplantassembrar*1)/2);
                }
            }else if(tipplanta.equals("Limpiar el terreno")){
                if(Jugador.monedasOro<10){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para limpiar el terreno");
                }else{
                    JOptionPane.showMessageDialog(null, "Para limpiar el terreno le pagaste a un empleado el cual cobra 10 monedas de oro para hacer la limpieza");
                    contadorLimpieza=0;
                    Jugador.monedasOro = Jugador.monedasOro - 10;
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Cosecha1.aumentoManzanas =0;
                    Cosecha.aumentoMaiz =0;
                    manzanaCosechado.setVisible(false);
                    vidaManzanas=0;
                    celdamanzana=0;
                    Cosecha1.cosechaManzana=0;
                    celdaSembrarManzanas = celdamanzana;
                }
            }
        }else if(e.getSource()==aceptarSiembra){
            String celda = celdas.getSelectedItem().toString();
            cantidadpnatassembr = cantPlantaSembrar.getText().toString();
            cantidadplantassembrar=0 + Double.parseDouble(cantidadpnatassembr);
            if(tipplanta.equals("Plantar Maiz")){
                if(contadorLimpieza==4){
                    JOptionPane.showMessageDialog(null, "Necesitas limpiar algunos terrenos antes de seguir plantando Maiz");
                }else{
                    celdaSembrarMaiz = Double.parseDouble(celda);
                    if(celdaSembrarMaiz<=celdaSembrarManzanas){
                        JOptionPane.showMessageDialog(null,"Esta celda esta ocupada, has sembrado manzanas en ellas, intenta con otra");
                    }else if(celdaSembrarMaiz>celdaSembrarManzanas){
                        celdamaiz = celdaSembrarMaiz-celdaSembrarManzanas;
                        if(cantidadplantassembrar>(celdamaiz*25)){
                            JOptionPane.showMessageDialog(null, "No puedes sembrar esta cantidad de plantas de maiz en la celda(s), siembra una cantidad menos o utiliza mas celdas");
                        }else{
                            JOptionPane.showMessageDialog(null, "Dependiendo si has sembrado manzanas o no, la cantidad de celdas seran las que no estan ocupadas, no el numero que elijas");
                            maizPlantado.setVisible(true);
                            Jugador.maiz = Jugador.maiz - (cantidadplantassembrar*2);
                            semMaiz.setText("sem. maiz: " + Jugador.maiz);
                            Reportes.cantCeldas=Reportes.cantCeldas+celdamaiz;
                            Reportes.celdasT.setText(""+Reportes.cantCeldas);
                            hilosembrar1.start();
                            aceptarSiembra.setEnabled(false);
                            contadorLimpieza++;
                        }
                    }else{
                        celdamaiz = celdaSembrarMaiz;
                        JOptionPane.showMessageDialog(null, "Dependiendo si has sembrado manzanas o no, la cantidad de celdas seran las que no estan ocupadas, no el numero que elijas");
                        maizPlantado.setVisible(true);
                        Jugador.maiz = Jugador.maiz - (cantidadplantassembrar*2);
                        semMaiz.setText("sem. maiz: " + Jugador.maiz);
                        Reportes.cantCeldas=Reportes.cantCeldas+celdamaiz;
                        Reportes.celdasT.setText(""+Reportes.cantCeldas);
                        hilosembrar1.start();
                        aceptarSiembra.setEnabled(false); 
                        contadorLimpieza++;
                    }
                }
            }else if(tipplanta.equals("Plantar Manzanas")){
                if(contadorLimpieza==5){
                    JOptionPane.showMessageDialog(null, "Necesitas limpiar los terrenos antes de sembrar Manzanas");
                }else{
                    celdaSembrarManzanas = Double.parseDouble(celda);
                    if(celdaSembrarManzanas<=celdaSembrarMaiz){
                        JOptionPane.showMessageDialog(null, "Esta celda esta ocupada, has sembrado maiz en ellas, intenta con otra");
                    }else if(celdaSembrarManzanas>celdaSembrarMaiz){
                        celdamanzana = celdaSembrarManzanas - celdaSembrarMaiz;
                        if(cantidadplantassembrar>(celdamanzana*20)){
                            JOptionPane.showMessageDialog(null, "No puedes sembrar esta cantidad de plantas de manzanas en la celda(s), siembra una cantidad menos o utiliza mas celdas");
                        }else{
                            JOptionPane.showMessageDialog(null, "Dependiendo si has sembrado maiz o no, la cantidad de celdas seran las que no estan ocupadas, no el numero que elijas");
                            Reportes.cantCeldas=Reportes.cantCeldas+celdamanzana;
                            Reportes.celdasT.setText(""+Reportes.cantCeldas);
                            manzanasPlantado.setVisible(true);
                            Jugador.manzanas = Jugador.manzanas - (cantidadplantassembrar*3);
                            semManzana.setText("sem. manzanas: " + Jugador.manzanas);
                            hilosembrar2.start();
                            aceptarSiembra.setEnabled(false);
                            contadorLimpieza++;
                        }
                    }else{
                        celdamanzana = celdaSembrarManzanas;
                        manzanasPlantado.setVisible(true);
                        Jugador.manzanas = Jugador.manzanas - (cantidadplantassembrar*3);
                        semManzana.setText("sem. manzanas: " + Jugador.manzanas);
                        Reportes.cantCeldas=Reportes.cantCeldas+celdamanzana;
                        Reportes.celdasT.setText(""+Reportes.cantCeldas);
                        hilosembrar2.start();
                        aceptarSiembra.setEnabled(false);
                        contadorLimpieza++;
                    }
                }
            }
    // para comprar crias de animales
        }else if(e.getSource()==aceptarCompraCrias){
            cantidadDeCrias = cantCrias.getText().toString();
            criasCantidad = Double.parseDouble(cantidadDeCrias);
            tipodeCria = comboCria.getSelectedItem().toString();
            if(tipodeCria.equals("Gallinas")){
                if(Jugador.monedasOro<(criasCantidad*10)){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar esta cantidad de crias, cada cria esta valorada en 10 MO");
                }else{
                    Jugador.monedasOro=Jugador.monedasOro - (criasCantidad*10);
                    Jugador.monedasOro = Math.round(Jugador.monedasOro*100.0)/100.0;
                    Jugador.criasDeGallinas = Jugador.criasDeGallinas + (criasCantidad);
                    criasGallinas.setText("Crias Gallinas: " + Jugador.criasDeGallinas);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Reportes.criasTT = Reportes.criasTT + criasCantidad;
                    Reportes.criasT.setText(""+Reportes.criasTT);

                }
            }else if(tipodeCria.equals("Vacas")){
                if(Jugador.monedasOro<(criasCantidad*100)){
                    JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar esta cantidad de Crias, cada cria te cuesta 100 MO");
                }else{
                    Jugador.monedasOro = Jugador.monedasOro - (criasCantidad*100);
                    Jugador.monedasOro = Math.round(Jugador.monedasOro*100.0)/100.0;
                    Jugador.criasDeVacas = Jugador.criasDeVacas + criasCantidad;
                    criasVacas.setText("Crias Vacas: " + Jugador.criasDeVacas);
                    oro.setText("Tu oro: " + Jugador.monedasOro);
                    Reportes.criasTT = Reportes.criasTT + criasCantidad;
                    Reportes.criasT.setText(""+Reportes.criasTT);
                }
            }
    //para elegir alimento para los animales.
        }else if(e.getSource()==funcionAnimal||e.getSource()==animalCriar){
            tipoDeAnimal = animalCriar.getSelectedItem().toString();
            funcionanimal = funcionAnimal.getSelectedItem().toString();
            if(funcionanimal.equals("Alimentar")){
                if(tipoDeAnimal.equals("Vacas")){
                    comboAlimentoOmnivoro.setVisible(false);
                    comboAlimentoHervivoro.setVisible(true);
                }else if(tipoDeAnimal.equals("Gallinas")){
                    comboAlimentoOmnivoro.setVisible(true);
                    comboAlimentoHervivoro.setVisible(false);
                }
            }else if(funcionanimal.equals("Limpiar terreno")){
                if(tipoDeAnimal.equals("Vacas")||tipoDeAnimal.equals("Gallinas")||tipoDeAnimal.equals("")){
                    this.comboAlimentoHervivoro.setVisible(false);
                    this.comboAlimentoOmnivoro.setVisible(false);
                }
            }else if(funcionanimal.equals("Llevar a la bodega")){
                if(tipoDeAnimal.equals("Vacas")||tipoDeAnimal.equals("Gallinas")||tipoDeAnimal.equals("")){
                    this.comboAlimentoHervivoro.setVisible(false);
                    this.comboAlimentoOmnivoro.setVisible(false);
                }
            }
    
    //para elegir comprar tipo de alimento Hervivoro u Omnivoro
        }else if(e.getSource()==tipoAnimal){
            String tipodeAlimento = tipoAnimal.getSelectedItem().toString();
            if(tipodeAlimento.equals("Herbivoro")){
                comidaAnimalesV.setVisible(true);
                comidaAnimalesG.setVisible(false);
            }else if(tipodeAlimento.equals("Omnivoro")){
                comidaAnimalesV.setVisible(false);
                comidaAnimalesG.setVisible(true);
            }
    //para comprar el alimento de los animales
        }else if(e.getSource()==comprarComidaAnimal){
            String cantAlimento = cantComidaAnimal.getText();
            double alimentoCantidad = Double.parseDouble(cantAlimento);
            String tipoAnim = tipoAnimal.getSelectedItem().toString();
            if(tipoAnim.equals("Omnivoro")){
                String tipoDeComidaG = comidaAnimalesG.getSelectedItem().toString();
                if(tipoDeComidaG.equals("trigo")){
                    if(Jugador.monedasOro<(alimentoCantidad*30)){
                        JOptionPane.showMessageDialog(null,"No tienes suficientes monedas para comprar la cantidad de trigo, cada quital te cuesta 30 MO");
                    }else{
                        Jugador.monedasOro = Jugador.monedasOro - (alimentoCantidad*30);
                        oro.setText("Tu oro: " + Jugador.monedasOro);
                        Jugador.trigo = Jugador.trigo + alimentoCantidad;
                        trigoqq.setText("trigo(qq): " + Jugador.trigo);
                    }
                }
            }else if(tipoAnim.equals("Herbivoro")){
                String tipoDeComidaV=comidaAnimalesV.getSelectedItem().toString();
                if(tipoDeComidaV.equals("Afrecho")){
                    if(Jugador.monedasOro<(alimentoCantidad*20)){
                        JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar la cantidad de afrecho, cada quintal te cuesta 20 MO");
                    }else{
                        Jugador.monedasOro = Jugador.monedasOro - (alimentoCantidad*20);
                        oro.setText("Tu oro: " + Jugador.monedasOro);
                        Jugador.afrecho = Jugador.afrecho + alimentoCantidad;
                        afrechoqq.setText("afrecho(qq): " + Jugador.afrecho);
                    }
                }else if(tipoDeComidaV.equals("Pasto")){
                    if(Jugador.monedasOro<(alimentoCantidad*15)){
                        JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para comprar la cantidad de pasto, cada quintal te cuesta 15 MO");
                    }else{
                        Jugador.monedasOro = Jugador.monedasOro - (alimentoCantidad*15);
                        oro.setText("Tu oro: " + Jugador.monedasOro);
                        Jugador.pasto = Jugador.pasto + alimentoCantidad;
                        pastoqq.setText("pasto(qq): " + Jugador.pasto);
                    }
                }
            }
    //para empezar a criar un animal
        }else if(e.getSource()==AceptarCriarAnimal){
            animalTipoCriar = animalCriar.getSelectedItem().toString();
            String animalCantidad = cantAnimals.getText().toString();
            double cantidadAnimalCriar = Double.parseDouble(animalCantidad);
            String parcela = parcelaAnimal.getSelectedItem().toString();
            int parcelaanimal = Integer.parseInt(parcela);

            if(animalTipoCriar.equals("Vacas")){
                celdavaca = parcelaanimal-celdaGallina;
                if(Jugador.criasDeVacas<cantidadAnimalCriar){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de crias, debes comprarlas en el mercado!");
                    celdavaca =0;
                }else if(parcelaanimal<=celdaGallina){
                    JOptionPane.showMessageDialog(null, "Esta celda esta ocupada");
                    celdavaca =0;
                }
                else if(celdavaca<2){
                    JOptionPane.showMessageDialog(null, "No puedes criar esta cantidad de vacas, debes tener por lo menos dos celdas disponibles");
                    celdavaca =0;
                }else if(TiempoAlimentar.muerto==true){
                    JOptionPane.showMessageDialog(null, "Tienes vacas muertas, debes limpiar antes el terreno sino se contaminarán tus demas animales");
                }
                else{
                    celdavaca = parcelaanimal-celdaGallina;
                    Jugador.criasDeVacas = Jugador.criasDeVacas - cantidadAnimalCriar;
                    criasVacas.setText("Crias Vacas: " + Jugador.criasDeVacas);
                    CriarVacas.cantidadVacasCriando = CriarVacas.cantidadVacasCriando + cantidadAnimalCriar;
                    vacasCriando.setVisible(true);
                    hiloVacas.start();
                    
                }
            }else if(animalTipoCriar.equals("Gallinas")){
                celdaGallina =parcelaanimal-celdavaca;
                if(Jugador.criasDeGallinas<cantidadAnimalCriar){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de crias, debes comprarlas en el mercado!");
                    celdaGallina=0;
                }else if(parcelaanimal<=celdavaca){
                    JOptionPane.showMessageDialog(null, "Esta celda esta ocupada");
                    celdaGallina=0;
                }
                else if(celdaGallina<1){
                    JOptionPane.showMessageDialog(null, "No puedes criar esta cantidad de animales, debes tener por lo menos una parcela para ellos");
                    celdaGallina=0;
                }else if(TiempoAlimento1.muerto==true){
                    JOptionPane.showMessageDialog(null, "Tienes gallinas muertas, puedes contaminar a los demas animales, debes limpiar el terreno y empezar crias de nuevo!");
                }
                else{
                    celdaGallina =parcelaanimal-celdavaca;
                    Jugador.criasDeGallinas = Jugador.criasDeGallinas - cantidadAnimalCriar;
                    criasGallinas.setText("Crias Gallinas: " + Jugador.criasDeGallinas);
                    CriarGallinas.cantidadGallinasCriando=cantidadAnimalCriar;
                    pollosCreciendo.setVisible(true);
                    hiloGallinas.start();
                }
            }
    //para alimentar animales, pasarlos a la bodega, y limpiar el terreno
        }else if(e.getSource()==aceptarAnimal){
            String comidaHervivoro = comboAlimentoHervivoro.getSelectedItem().toString();
            String comidaOmnivoro = comboAlimentoOmnivoro.getSelectedItem().toString();
            funcionanimal = funcionAnimal.getSelectedItem().toString();
            animalTipoCriar = animalCriar.getSelectedItem().toString();
            if(funcionanimal.equals("Alimentar")){
                if(animalTipoCriar.equals("Vacas")){
                    if(comidaHervivoro.equals("Pasto")){
                        if(Jugador.pasto<(0.5*CriarVacas.cantidadVacasCriando)){
                            JOptionPane.showMessageDialog(null, "No es suficiente para alimentar a " + CriarVacas.cantidadVacasCriando +
                             " debes comprar " + (0.5*CriarVacas.cantidadVacasCriando) + " quintales de pasto ");
                        }else if(CriarVacas.cantidadVacasCriando==0){
                            JOptionPane.showMessageDialog(null, "No hay vacas que alimentar");
                        }else if(contadorCrecimientoVaca==10){
                            CriarVacas.hilovacaAlimento.stop();
                            vacasCriando.setVisible(false);
                            vacasGrandes.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Las vacas ya estan grandes, puedes venderlas o destazarlas");
                        }
                        else{
                            Jugador.pasto = Jugador.pasto - (0.25*CriarVacas.cantidadVacasCriando);
                            Jugador.pasto = Math.round(Jugador.pasto*100.0)/100.0;
                            pastoqq.setText("Pasto(qq): " + Jugador.pasto);
                            contadorCrecimientoVaca++;
                            int lechelitros = (int)(Math.random()*2+1);
                            Jugador.lecheVaca = Jugador.lecheVaca + ((1)+CriarVacas.cantidadVacasCriando*lechelitros);
                            lechelt.setText("leche (lt): " + Jugador.lecheVaca);
                            Reportes.lecheGranja=Reportes.lecheGranja+((1)+CriarVacas.cantidadVacasCriando*lechelitros);
                            Reportes.leche1.setText("leche(lt): " + Reportes.lecheGranja);
                            CriarVacas.hilovacaAlimento.stop();
                            hiloVacas.start();
                        }
                    }else if(comidaHervivoro.equals("Afrecho")){
                        if(Jugador.afrecho<(0.5*CriarVacas.cantidadVacasCriando)){
                            JOptionPane.showMessageDialog(null, "No es suficiente para alimentar a " + CriarVacas.cantidadVacasCriando +
                             " debes comprar " + (0.5*CriarVacas.cantidadVacasCriando) + " quintales de afrecho");
                        }else if(CriarVacas.cantidadVacasCriando==0){
                            JOptionPane.showMessageDialog(null, "No hay vacas que alimentar");
                        }else if(contadorCrecimientoVaca==10){
                            CriarVacas.hilovacaAlimento.stop();
                            vacasCriando.setVisible(false);
                            vacasGrandes.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Las vacas ya estan grandes, puedes venderlas o destazarlas");
                        }
                        else{
                            Jugador.afrecho = Jugador.afrecho - (0.20*CriarVacas.cantidadVacasCriando);
                            Jugador.afrecho = Math.round(Jugador.afrecho*100.0)/100.0;
                            afrechoqq.setText("afrecho(qq): " + Jugador.afrecho);
                            contadorCrecimientoVaca++;
                            int lechelitros = (int)(Math.random()*2+1);
                            Jugador.lecheVaca = Jugador.lecheVaca + ((2)+CriarVacas.cantidadVacasCriando*lechelitros);
                            lechelt.setText("leche (lt): " + Jugador.lecheVaca);
                            Reportes.lecheGranja=Reportes.lecheGranja+((2)+CriarVacas.cantidadVacasCriando*lechelitros);
                            Reportes.leche1.setText("leche(lt): " + Reportes.lecheGranja);
                            CriarVacas.hilovacaAlimento.stop();
                            hiloVacas.start();
                        }
                    }else if(comidaHervivoro.equals("Maiz")){
                        if(Cosecha.maizquintales<(0.25*CriarVacas.cantidadVacasCriando)){
                            JOptionPane.showMessageDialog(null, "No es suficiente para alimentar a " + CriarVacas.cantidadVacasCriando +
                            " debes comprar " + (0.5*CriarVacas.cantidadVacasCriando) + " quintales de maiz, o cosecharlo"); 
                        }else if(CriarVacas.cantidadVacasCriando==0){
                            JOptionPane.showMessageDialog(null, "No hay vacas que alimentar ");
                        }else if(contadorCrecimientoVaca==10){
                            CriarVacas.hilovacaAlimento.stop();
                            vacasCriando.setVisible(false);
                            vacasGrandes.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Las vacas ya estan grandes, puedes venderlas o destazarlas");
                        }
                        else{
                            Cosecha.maizquintales = Cosecha.maizquintales - (0.15*CriarVacas.cantidadVacasCriando);
                            Cosecha.maizquintales = Math.round(Cosecha.maizquintales*100.0)/100.0;
                            maiz.setText("maiz(qq) :" + Cosecha.maizquintales);
                            contadorCrecimientoVaca++;
                            int lechelitros = (int)(Math.random()*2+1);
                            Jugador.lecheVaca = Jugador.lecheVaca + ((0.5)+CriarVacas.cantidadVacasCriando*lechelitros);
                            lechelt.setText("leche (lt): " + Jugador.lecheVaca);
                            Reportes.lecheGranja=Reportes.lecheGranja+((0.5)+CriarVacas.cantidadVacasCriando*lechelitros);
                            Reportes.leche1.setText("leche(lt): " + Reportes.lecheGranja);
                            CriarVacas.hilovacaAlimento.stop();
                            hiloVacas.start();
                        }
                    }
                }else if(animalTipoCriar.equals("Gallinas")){
                    if(comidaOmnivoro.equals("Peces")){
                        if(Pesca.pecesCazados<(0.5*CriarGallinas.cantidadGallinasCriando)){
                            JOptionPane.showMessageDialog(null, "No tienes esta cantidad de peces para alimentar las gallinas, cada una de ellas se come medio pez");
                        }else if(CriarGallinas.cantidadGallinasCriando==0){
                            JOptionPane.showMessageDialog(null, "No hay gallinas que alimentar");
                        }else if(contadorCrecimientoGall==10){
                            CriarGallinas.tiempocomidaGallina.stop();
                            gallinasGrandes.setVisible(true);
                            pollosCreciendo.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Las gallinas han crecido, estan listas para venderlas o destazarlas");
                        }
                        else{
                            Pesca.pecesCazados = Pesca.pecesCazados - (0.5*CriarGallinas.cantidadGallinasCriando);
                            Pesca.pecesCazados = Math.round(Pesca.pecesCazados*100.0)/100.0;
                            misPeces.setText("Peces: " + Pesca.pecesCazados);
                            contadorCrecimientoGall++;
                            int huevos =(int) (Math.random()*4+1);
                            Jugador.huevosGallina = Jugador.huevosGallina + (CriarGallinas.cantidadGallinasCriando*huevos+1);
                            huevosU.setText("Huevos(u): " + Jugador.huevosGallina);
                            Reportes.huevosGranja = Reportes.huevosGranja+ (CriarGallinas.cantidadGallinasCriando*huevos+1);
                            Reportes.huevos1.setText("huevos: " + Reportes.huevosGranja);
                            CriarGallinas.tiempocomidaGallina.stop();
                            hiloGallinas.start();
                        }
                    }else if(comidaOmnivoro.equals("trigo")){
                        if(Jugador.trigo<(0.1*CriarGallinas.cantidadGallinasCriando)){
                            JOptionPane.showMessageDialog(null, "No tienes suficiente trigo para alimentar tus gallinas, cada una se come 10 libras de trigo");
                        }else if(CriarGallinas.cantidadGallinasCriando==0){
                            JOptionPane.showMessageDialog(null, "No hay gallinas que aliemntar");
                        }else if(contadorCrecimientoGall==10){
                            CriarGallinas.tiempocomidaGallina.stop();
                            gallinasGrandes.setVisible(true);
                            pollosCreciendo.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Las gallinas han crecido, estan listas para venderlas o destazarlas");
                        }else {
                            Jugador.trigo = Jugador.trigo - (0.1*CriarGallinas.cantidadGallinasCriando);
                            Jugador.trigo = Math.round(Jugador.trigo*100.0)/100.0;
                            trigoqq.setText("trigo(qq): " + Jugador.trigo);
                            contadorCrecimientoGall++;
                            int huevos =(int) (Math.random()*5+1);
                            Jugador.huevosGallina = Jugador.huevosGallina + (2 + (CriarGallinas.cantidadGallinasCriando*huevos));
                            huevosU.setText("Huevos(u): " + Jugador.huevosGallina);
                            Reportes.huevosGranja = Reportes.huevosGranja+  (2 + (CriarGallinas.cantidadGallinasCriando*huevos));
                            Reportes.huevos1.setText("huevos: " + Reportes.huevosGranja);
                            CriarGallinas.tiempocomidaGallina.stop();
                            hiloGallinas.start();
                        }
                    }else if(comidaOmnivoro.equals("Maiz")){
                        if(Cosecha.maizquintales<(0.1*CriarGallinas.cantidadGallinasCriando)){
                            JOptionPane.showMessageDialog(null, "No tienes suficiente maiz para alimentar a tus gallinas, cada una de ellas come 10 libras de maiz");
                        }else if(CriarGallinas.cantidadGallinasCriando==0){
                            JOptionPane.showMessageDialog(null, "No hay gallinas que alimentar");
                        }else if(contadorCrecimientoGall==10){
                            CriarGallinas.tiempocomidaGallina.stop();
                            gallinasGrandes.setVisible(true);
                            pollosCreciendo.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Las gallinas han crecido, estan listas para venderlas o destazarlas");
                        }else{
                            Cosecha.maizquintales = Cosecha.maizquintales - (0.1*CriarGallinas.cantidadGallinasCriando);
                            Cosecha.maizquintales = Math.round(Cosecha.maizquintales*100.0)/100.0;
                            maiz.setText("maiz(qq): " + Cosecha.maizquintales);
                            contadorCrecimientoGall++;
                            int huevos =(int) (Math.random()*6+1);
                            Jugador.huevosGallina = Jugador.huevosGallina + (CriarGallinas.cantidadGallinasCriando*huevos+3);
                            huevosU.setText("Huevos(u): " + Jugador.huevosGallina);
                            Reportes.huevosGranja = Reportes.huevosGranja+  (CriarGallinas.cantidadGallinasCriando*huevos+3);
                            Reportes.huevos1.setText("huevos: " + Reportes.huevosGranja);
                            CriarGallinas.tiempocomidaGallina.stop();
                            hiloGallinas.start();
                        }
                    }
                }
            }else if(funcionanimal.equals("Limpiar terreno")){
                if(funcionanimal.equals("Limpiar terreno")&&animalTipoCriar.equals("Gallinas")){
                    if(TiempoAlimento1.muerto==false){
                        JOptionPane.showMessageDialog(null, "Aun no es tiempo de limpiar el terreno");
                    }
                    else if(Jugador.monedasOro<10){
                        JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para limpiar el terreno, cada limpieza te cuesta 10 MO");
                    }else{
                        JOptionPane.showMessageDialog(null, "La limpia te cuesta 15 MO");
                        Jugador.monedasOro=Jugador.monedasOro - 10;
                        oro.setText("Tu oro: " + Jugador.monedasOro);
                        Jugador.puntos = Jugador.puntos - 10;
                        puntaje.setText("Puntos: " + Jugador.puntos);
                        CriarGallinas.cantidadGallinasCriando=0;
                        TiempoAlimento1.muerto=false;
                        celdaGallina=0;
                        
                    }
                }else if(funcionanimal.equals("Limpiar terreno") && animalTipoCriar.equals("Vacas")){
                    if(TiempoAlimentar.muerto==false){
                        JOptionPane.showMessageDialog(null, "Aun no es tiempo de limpiar el terreno");
                    }else if(Jugador.monedasOro<15){
                        JOptionPane.showMessageDialog(null, "No tienes suficientes monedas para limpiar el terreno, cada limpieza te cuesta 15 MO");
                    }else{
                        JOptionPane.showMessageDialog(null, "La limpia te cuesta 15 MO");
                        Jugador.monedasOro = Jugador.monedasOro-15;
                        oro.setText("Tu oro: " + Jugador.monedasOro);
                        Jugador.puntos = Jugador.puntos-15;
                        puntaje.setText("Puntos: " + Jugador.puntos);
                        CriarVacas.cantidadVacasCriando=0;
                        TiempoAlimentar.muerto=false;
                        celdavaca=0;
                    }
                }
            }else if(funcionanimal.equals("Llevar a la bodega")){
                if(animalTipoCriar.equals("Vacas")){
                    if(contadorCrecimientoVaca!=10){
                        JOptionPane.showMessageDialog(null, "Las vacas no estan listas para llevarlas a la bodega");
                    }else{
                        vacasGrandes.setVisible(false);
                        contadorCrecimientoVaca=0;
                        Jugador.vacasVender = Jugador.vacasVender + CriarVacas.cantidadVacasCriando;
                        vacas.setText("Vacas: " + Jugador.vacasVender);
                        CriarVacas.cantidadVacasCriando=0;
                        this.celdavaca=0;
                    }
                }else if(animalTipoCriar.equals("Gallinas")){
                    if(contadorCrecimientoGall!=10){
                        JOptionPane.showMessageDialog(null, "Las gallinas no están listas para llevarlas a la bodega");
                    }else{
                        contadorCrecimientoGall=0;
                        gallinasGrandes.setVisible(false);
                        Jugador.gallinasVender = Jugador.gallinasVender + CriarGallinas.cantidadGallinasCriando;
                        gallinas.setText("Gallinas: " + Jugador.gallinasVender);
                        CriarGallinas.cantidadGallinasCriando=0;
                        this.celdaGallina=0;
                    }
                }
            }
    // para trabajos en la casa o en la granja 
        }else if(e.getSource()==comboFuncionCasa){
            String funncionCasa = comboFuncionCasa.getSelectedItem().toString();
            if(funncionCasa.equals("Comer (Granjero)")){
                comboAlimentoGrangero.setVisible(true);
            }else if(funncionCasa.equals("Destazar Vaca")){
                comboAlimentoGrangero.setVisible(false);
            }else if(funncionCasa.equals("Destazar Gallina")){
                comboAlimentoGrangero.setVisible(false);
            }
        }
        else if(e.getSource()==aceptarFuncionEnCasa){
            String tipoComida = comboAlimentoGrangero.getSelectedItem().toString();
            String seleccion = comboFuncionCasa.getSelectedItem().toString();
            if(seleccion.equals("Destazar Vaca")){
                String cantFuncion = cantidadAlimentoGrangero.getText();
                double cantidadFuncion = Double.parseDouble(cantFuncion);
                if(Jugador.vacasVender<cantidadFuncion){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de vacas");
                }else{
                    Jugador.vacasVender = Jugador.vacasVender - cantidadFuncion;
                    vacas.setText("Vacas: " + Jugador.vacasVender);
                    Jugador.carneVaca = Jugador.carneVaca + (cantidadFuncion*5);
                    carneDeVaca.setText("Carne de Vaca(qq): " + Jugador.carneVaca);
                    Jugador.cueroVaca = Jugador.cueroVaca  + (cantidadFuncion);
                    cueroVaca.setText("cuero de vaca(u): " + Jugador.cueroVaca);
                    Jugador.puntos = Jugador.puntos + (cantidadFuncion*1.5);
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.destazz = Reportes.destazz + cantidadFuncion;
                    Reportes.aDestazados.setText(""+Reportes.destazz);
                    Reportes.carneGranja = Reportes.carneGranja+(cantidadFuncion*5);
                    Reportes.carne1.setText("carne: "+ Reportes.carneGranja);
                }
            }else if(seleccion.equals("Destazar Gallina")){
                String cantFuncion = cantidadAlimentoGrangero.getText();
                double cantidadFuncion = Double.parseDouble(cantFuncion);
                if(Jugador.gallinasVender<cantidadFuncion){
                    JOptionPane.showMessageDialog(null, "No tienes esta cantidad de gallinas!");
                }else{
                    Jugador.gallinasVender=Jugador.gallinasVender - cantidadFuncion;
                    gallinas.setText("Gallinas: " + Jugador.gallinasVender);
                    Jugador.carneGallina=Jugador.carneGallina + (cantidadFuncion*6);
                    carneDeGallina.setText("Carne Gallina(lb): " + Jugador.carneGallina);
                    Jugador.puntos = Jugador.puntos + (cantidadFuncion*1);
                    puntaje.setText("Puntos: " + Jugador.puntos);
                    Reportes.destazz = Reportes.destazz + cantidadFuncion;
                    Reportes.aDestazados.setText(""+Reportes.destazz);
                    Reportes.carneGranja = Reportes.carneGranja+(cantidadFuncion*0.06);
                    Reportes.carneGranja = Math.round(Reportes.carneGranja*100.0)/100.0;
                    Reportes.carne1.setText("carne: "+ Reportes.carneGranja);
                }
    //para alimentar al granjero
            }else if(seleccion.equals("Comer (Granjero)")){
                if(tipoComida.equals("Peces")){
                    if(Pesca.pecesCazados<1){
                        JOptionPane.showMessageDialog(null, "No tienes suficintes peces para alimentar al Grangero");
                    }else{
                        tiempoVida[contadorHilos].stop();
                        contadorHilos++;
                        tiempoVida[contadorHilos]=new Thread(tmv);
                        Pesca.pecesCazados = Pesca.pecesCazados - 1;
                        misPeces.setText("Peces: " + Pesca.pecesCazados);
                        Jugador.vida = Jugador.vida + (40);
                        Reportes.pecesG=Reportes.pecesG + 1;
                        Reportes.peces.setText("peces: " + Reportes.pecesG);
                        tiempoVida[contadorHilos].start();
                    }
                }else if(tipoComida.equals("Tortillas")){
                    if(Cosecha.maizquintales<0.05){
                        JOptionPane.showMessageDialog(null, "No tienes maiz para que coma tortillas");
                    }else{
                            tiempoVida[contadorHilos].stop();
                            contadorHilos++;
                            tiempoVida[contadorHilos]=new Thread(tmv);
                            Cosecha.maizquintales = Math.round((Cosecha.maizquintales - (0.05))*100.0)/100.0;
                            maiz.setText("maiz(qq): " + Cosecha.maizquintales);
                            Jugador.vida = Jugador.vida + (20);
                            Reportes.maizG = Reportes.maizG + Math.round(((0.05))*100.0)/100.0;
                            Reportes.tortillas.setText("maiz: " + Reportes.maizG);
                            tiempoVida[contadorHilos].start();
                    }
                }else if(tipoComida.equals("Carne Vaca")){
                    if(Jugador.carneVaca<0.01){
                        JOptionPane.showMessageDialog(null, "No tienes esta cantidad de carne para alimentar al granjero");
                    }else{
                        tiempoVida[contadorHilos].stop();
                        contadorHilos++;
                        tiempoVida[contadorHilos]=new Thread(tmv);
                        Jugador.carneVaca = Math.round((Jugador.carneVaca-0.01)*100.0)/100.0;
                        carneDeVaca.setText("Carne Vaca(qq): " + Jugador.carneVaca);
                        Reportes.carneG=Reportes.carneG + Math.round((0.01)*100)/100.0;
                        Reportes.carne.setText("carne: " + Reportes.carneG);
                        Jugador.vida = Jugador.vida + (50);
                        tiempoVida[contadorHilos].start();
                        
                    }
                }else if(tipoComida.equals("Carne Gallina")){
                    if(Jugador.carneGallina<0.02){
                        JOptionPane.showMessageDialog(null, "No tienes suficiente carne para alimentar al granjero");
                    }else{
                        tiempoVida[contadorHilos].stop();
                        contadorHilos++;
                        tiempoVida[contadorHilos]=new Thread(tmv);
                        Jugador.carneGallina =Math.round((Jugador.carneGallina - 0.02)*100)/100.0;
                        carneDeGallina.setText("Carne Gallina(lb): "  + Jugador.carneGallina);
                        Reportes.carneG=Reportes.carneG + Math.round((0.02)*100)/100.0;
                        Reportes.carne.setText("carne: " + Reportes.carneG);
                        Jugador.vida = Jugador.vida + (45);
                        tiempoVida[contadorHilos].start();    
                    }
                }else if(tipoComida.equals("Manzanas")){
                    if(Cosecha1.manzanasquintales<0.02){
                        JOptionPane.showMessageDialog(null, "No tienes suficientes manzanas para alimentar al granjero");
                    }else{
                        tiempoVida[contadorHilos].stop();
                        contadorHilos++;
                        tiempoVida[contadorHilos]=new Thread(tmv);
                        Cosecha1.manzanasquintales=Math.round((Cosecha1.manzanasquintales-0.02)*100.0)/100.0;
                        manzanasqq.setText("Manzanas: " + Cosecha1.manzanasquintales);
                        Reportes.manzanasG = Math.round((Reportes.manzanasG+0.02)*100.0)/100.0;
                        Reportes.manzanas.setText("Mnz(u): "+ Reportes.manzanasG);
                        Jugador.vida = Jugador.vida + (10);
                        tiempoVida[contadorHilos].start();
                    }
                }else if(tipoComida.equals("Leche")){
                    if(Jugador.lecheVaca<1){
                        JOptionPane.showMessageDialog(null, "No tienes suficiente leche para alimentar al granjero");
                    }else{
                        tiempoVida[contadorHilos].stop();
                        contadorHilos++;
                        tiempoVida[contadorHilos]=new Thread(tmv);
                        Jugador.lecheVaca = Jugador.lecheVaca -1;
                        lechelt.setText("Leche(lt): " + Jugador.lecheVaca);
                        Reportes.lecheG=Reportes.lecheG + 1;
                        Reportes.leche.setText("leche(lt): " + Reportes.lecheG);
                        Jugador.vida = Jugador.vida + (30);
                        tiempoVida[contadorHilos].start();
                    }
                }else if(tipoComida.equals("Huevos")){
                    if(Jugador.huevosGallina<3){
                        JOptionPane.showMessageDialog(null, "No tienes en la bodega huevos de gallinas para alimentar al granjero");
                    }else{
                        tiempoVida[contadorHilos].stop();
                        contadorHilos++;
                        tiempoVida[contadorHilos]=new Thread(tmv);
                        Jugador.huevosGallina=Jugador.huevosGallina-3;
                        huevosU.setText("Huevos(u): " + Jugador.huevosGallina);
                        Reportes.huevosG=Reportes.huevosG+3;
                        Reportes.huevos.setText("huevos(u): " + Reportes.huevosG);
                        Jugador.vida = Jugador.vida + (37);
                        tiempoVida[contadorHilos].start();   
                    }
                }
            }
    //para la parte de la barra
        }
        else if(e.getSource()==miAcercaDe){
            JOptionPane.showMessageDialog(null, "Desarrollado por Eiler Rigoberto Gomez Figueroa\n" +
                                            "           gomezeiler250@gmail.com\n " +
                                            "    Proyecto de IPC1 Ingenieia en Ciencias y Sistemas\n" +
                                            "                 12/04/2021");
        }if(e.getSource()==miRojo){
            getContentPane().setBackground(new Color(255,0,0));
         }
         if(e.getSource()==miNegro){
            getContentPane().setBackground(new Color(0,0,0));
         }
         if(e.getSource()==miMorado){
            getContentPane().setBackground(new Color(51,0,51));
         }if(e.getSource()==miAzul){
             getContentPane().setBackground(new Color(62,95,138));
         }
         else if(e.getSource()==miReportes){
             TerminosYCondiciones.rp.setVisible(true);
         }else if(e.getSource()==miNuveaPartida){

            NuevaPartida np = new NuevaPartida();
            np.setBounds(0,0,500,350);
            np.setVisible(true);
            np.setResizable(false);
            np.setLocationRelativeTo(null);
            this.setVisible(false);
            tiempoVida[contadorHilos].stop();
            Jugador.monedasOro=100;
            Jugador.vida=100;
            Jugador.maiz=0;
            Jugador.manzanas=0;
            Jugador.criasDeVacas=0;
            Jugador.criasDeGallinas=0;
            Jugador.gallinasVender=0;
            Jugador.vacasVender=0;
            Jugador.afrecho=0; 
            Jugador.trigo=0;
            Jugador.pasto=0;
            Jugador.lecheVaca=0;
            Jugador.cueroVaca=0;
            Jugador.carneVaca=0;
            Jugador.carneGallina=0;
            Jugador.huevosGallina=0;
            Cosecha.maizquintales=0;
            Cosecha.cosechaMaiz=0;
            Cosecha.aumentoMaiz=0;

            Cosecha1.manzanasquintales=0;
            Cosecha1.cosechaManzana=0;
            Cosecha1.aumentoManzanas=0;

            Pesca.pecesEnAgua=0;
            Pesca.pecesCazados=0;

            Reportes.oroG =0;
            Reportes.oroGranja.setText(""+Reportes.oroG);
            Reportes.destazz =0;
            Reportes.aDestazados.setText(""+ Reportes.destazz);
            Reportes.pecesGranja = 0;
            Reportes.peces1.setText("peces: "+ Reportes.pecesGranja);
            Reportes.maizGranja =0;
            Reportes.tortillas1.setText("maiz: "+Reportes.maizGranja);
            Reportes.lecheGranja=0;
            Reportes.leche1.setText("leche(lt): "+ Reportes.lecheGranja);
            Reportes.manzanasGranja =0;
            Reportes.manzanas1.setText("Mnz(qq): " +Reportes.manzanasGranja);
            Reportes.huevosGranja=0;
            Reportes.huevos1.setText("huevos: " + Reportes.huevosGranja);
            Reportes.carneGranja=0;
            Reportes.carne1.setText("carne: " + Reportes.carneGranja);
            Reportes.pecesG=0;
            Reportes.peces.setText(""+Reportes.pecesG);
            Reportes.maizG=0;
            Reportes.tortillas.setText(""+Reportes.maizG);
            Reportes.lecheG=0;
            Reportes.leche.setText(""+ Reportes.lecheG);
            Reportes.manzanasG=0;
            Reportes.manzanas.setText(""+ Reportes.manzanasG);
            Reportes.huevosG=0;
            Reportes.huevos.setText(""+Reportes.huevosG);
            Reportes.carneG=0;
            Reportes.carne.setText(""+Reportes.carneG);

            this.hiloTiempo.stop();

            Reportes.numPartidas[Reportes.contadorPatidas]="Partida: " + Reportes.contadorPatidas +"; Tiempo: " + TiempoPartida.tiempoPartida + "(segundos)";
            Reportes.txtArea.setText(Reportes.txtArea.getText()+"\n"+Reportes.numPartidas[Reportes.contadorPatidas]);
            TiempoPartida.tiempoPartida=0;
            Reportes.contadorPatidas++;

            this.hilosembrar1.stop();
            this.hilosembrar2.stop();
            Cosecha.hiloCosechamaiz.stop();
            Cosecha1.hiloCosechamanzan.stop();

            contadorHilos=0;
            tiempoVida[contadorHilos].start();
         }else if(e.getSource()==salir){
             System.exit(0);
         }
    }
    
//main
    public static void main(String[] args) {
        VentanaMenu vM = new VentanaMenu();
        vM.setBounds(0,0,1400,735);
        vM.setVisible(true);
        vM.setResizable(false);
      
    }

}
