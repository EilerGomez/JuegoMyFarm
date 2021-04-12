public class Inicio{
   String suelo;
    int aleatorio;
    public static int i=26; 
    public static String parcela[] = new String [i];
    public static int contadorGrama, contadorAgua, contadorDesierto;
    int agua=0, grama=0,desierto=0;

    public int getAgua(){
        return this.agua;
    }
    public void setAgua(int agua){
        this.agua=agua;
    }
    public int getGrama(){
        return this.grama;
    }
    public void setGrama(int grama){
        this.grama=grama;
    }
    public int getDesierto(){
        return this.desierto;
    }
    public void setDesierto(int desierto){
        this.desierto=desierto;
    }
    

    public Inicio(){
        
        for(int i = 0; i<=24; i++){
            
            aleatorio = (int)(Math.random()*3+1);
            if(aleatorio==1){
                parcela[i] ="Grama";
                setGrama(getGrama() + 1);
            }else if(aleatorio == 2){
                parcela[i] = "Desierto";
                setDesierto(getDesierto() + 1);
            }else if(aleatorio==3){
                parcela[i]="Agua";
               setAgua(getAgua() + 1);
            }
            
            

        }
        contadorAgua = agua;
        contadorDesierto = desierto;
        contadorGrama = grama;
    }
  
}