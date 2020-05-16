package metodos;

import java.util.regex.Pattern;

public class Password {
    //                     Atributos
    private int longitud;
    private String contraseña;
    
    //                     Constructores
    //Constructor por defecto
    public Password(){
        generarPassword();
    }
    
    //Constructor de longitud
    public Password( int longitud ){
        setLongitud(longitud);
        generarPassword();
    }
    
    //                      Métodos
    //                  Getters y setters
    public int getLongitud(){
        return this.longitud;
    }
    
    public String getContraseña(){
        return this.contraseña;
    }
    
    //En el setter de longitud, establezco un mínimo y un máximo
    //con constantes, para que si el usuario incumple los límites,
    //se establezca según el mínimo o el máximo.
    public void setLongitud( int longitud ){
        final int minimo = 5;
        final int maximo = 13;
        
        if( longitud<minimo ){
            this.longitud = minimo;
        }else if(longitud>maximo){
            this.longitud = maximo;
        }else{
            this.longitud = longitud;
        }  
    }
    
    //                  Métodos personales
    public boolean esFuerte(){
        //Prejuicio
        boolean fuerte = false;
        
        //Realizar un contador de números, mayusculas y minusculas
        int contador_numeros = 0;

        int contador_mayusculas = 0;
       
        int contador_minusculas = 0;
        
        String contraseña[] = getContraseña().split("");
        
        //1 bucle que tenga 3 ifs, y añada +1 al contador de numeros, mayusculas
        //o minusculas
        
        for(int i=0;i<contraseña.length;i++){
            if( Pattern.matches("[0-9]",contraseña[i]) ){
                contador_numeros++;
            }
            
            if( Pattern.matches("[A-Z]",contraseña[i]) || "Ñ".equals(contraseña[i]) ){
                contador_mayusculas++;
                
            }
            
            if( Pattern.matches("[a-z]",contraseña[i]) || "ñ".equals(contraseña[i]) ){
                contador_minusculas++;
            }
        }
        
        if( contador_mayusculas>4 && contador_minusculas>1 && contador_numeros>5 ){
            fuerte = true;
        }
        
        return fuerte;
    }
    
    public void generarPassword(){
        String losnumeros = "0123456789";
        String lasmayusculas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String lasminusculas = "abcdefghijklmnñopqrstuvwxyz";
        
        String contraseña = "";
        
        for( int i=0;i<getLongitud();i++ ){
            //Generar un número aleatorio cada vuelta entre 1 y 3,
            //dependiendo de ese número aleatorio meterá
            //en el array un número, una mayúscula o una
            //minúscula.
            
            //Después, generar otro número aleatorio dependiendo de lo larga
            //que sea la cadena de números, mayúsculas o minúsculas y añadir
            //esa posición al array de listaContraseña
            
            int aleatorio1 = (int) (Math.random()*3)+1;
            int aleatorio2;
            
            if( aleatorio1==1 ){
                //Mete un número en el array
                aleatorio2 = (int) (Math.random()*losnumeros.length());
                
                contraseña += losnumeros.charAt(aleatorio2);
            }else if( aleatorio1==2 ){
                //Mete una mayúscula en el array
                aleatorio2 = (int) (Math.random()*lasmayusculas.length());
                contraseña += lasmayusculas.charAt(aleatorio2);
            }else if( aleatorio1==3 ){
                //Mete una minúscula en el array
                aleatorio2 = (int) (Math.random()*lasminusculas.length());
                contraseña += lasminusculas.charAt(aleatorio2);
            }
        }
        
        this.contraseña = contraseña;
        
    }
    
}
