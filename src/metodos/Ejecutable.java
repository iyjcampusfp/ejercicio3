package metodos;

import java.util.Scanner;

public class Ejecutable {
    
    public static void main(String[] args) {
        
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        
        System.out.print("¿Cuántas contraseñas quiere crear? → ");
        String contraseñas[] = new String[sc1.nextInt()];
        boolean esfuerte[] = new boolean[contraseñas.length];
        
        System.out.print("Las contraseñas han de ser de un mínimo de 5 o 13.\n" +
                         "Si introduce un número que no esté entre esos, se hará \n" +
                         "con el mínimo o máximo de longitud.\n");
        
        
        for(int i=0;i<contraseñas.length;i++){
            System.out.print("¿Qué longitud quiere para su contraseña número " + (i+1) + "? → ");
            int longitud = sc2.nextInt();
            
            Password nuevo = new Password(longitud);
            
            contraseñas[i] = nuevo.getContraseña();
            
            esfuerte[i] = nuevo.esFuerte();
        }
        
        System.out.println( "------------------------" );
        
        for(int i=0;i<contraseñas.length;i++){
            System.out.print(contraseñas[i] + "\t");
            System.out.println(esfuerte[i]);
        }
    }
}
