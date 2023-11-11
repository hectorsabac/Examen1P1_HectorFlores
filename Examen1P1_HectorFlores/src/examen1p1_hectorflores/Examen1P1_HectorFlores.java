package examen1p1_hectorflores;
import java.util.Scanner;
import java.util.Random;

//Piedad Eduardo, que te quiero <3
public class Examen1P1_HectorFlores {
    static Scanner sc = new Scanner(System.in);
    
    public static void trifuerza(){
        System.out.println("Trifuerza");
                System.out.println("Ingrese el tamaño de la trifuerza. Debe ser par y mayor o igual a 20 y divisible entre 4.");
                int size = sc.nextInt();//pide size
                int altura = size / 2 + 1;//saca la altura
                int base = size + 1;//saca la base
                
                int media1 = base / 2 + 1;//calcula el valor b de el borde izquierdo del triangulo
                int media2 = media1;//calcula el valor b de el borde derecho del triangulo      
                
                while (size % 2 == 1 || size < 20 || size % 4 == 0){//valida que sea valido hasta que se ingrese un valor valido
                    System.out.println("Ingrese un tamaño valido");
                    size = sc.nextInt();
                }//valida que el size ingresado sea valido
                
                int c = 0;//se usa para agregar asteriscos a partirde la mitad del triangulo a el borde izquierdo y derecho
                
                for (int a = 1; a <= altura; a++){
                    for (int b = 1; b <= base; b++){
                        
                        
                        if (b >= media1 && b <= media2 && a < altura/2+1){//hace el pico de la trifuerza
                            System.out.print("*");
                        } else if (a >= altura / 2 + 1 && ((b >= media1 && b <= media1 + c) || (b >= media2-c && b<= media2))){
                            System.out.print("*");//hace el espacio que tiene los dos triangulos inferiores
                        } else {
                            System.out.print(" ");
                        }
                    }
                    media1 --;//corre el borde izquierdo 1 hacia la izquierdq
                    media2 ++;//corre el borde derech 1 hacia la derecha
                    System.out.println("");
                    if (a >= altura/2+1){
                           c+=2;
                        }//suma c asteriscos a los bordes a partir de la mitad inferior del triangulo
                }
                
                
    }
    
    public static void main(String[] args) {
        System.out.println("Menu:");
        System.out.println("1. Fight or flight");
        System.out.println("2. Trifuerza");
        System.out.println("Ingresar cualquier otro numero sale del programa");
        System.out.println("");
        System.out.println("Ingrese su opcion: ");
        int opcion = sc.nextInt();
        
        while (opcion == 1 || opcion == 2){
            switch  (opcion){
            case 1:
                System.out.println("Fight or flight");
                int distancia = new Random().nextInt((30-15)+1)+15;//distancia random entre jugador y zombie
                int balas = 25;//Balas del jugador
                int vida_zombie = 25;//Vida del zombie
                int damage = 0;//declara la variable de daño sin asignarle nada aun
                int avance = 0;//declara cuanto avanza el zombie cada ronda sin asignarle valor aun
                double prob_damage = 0.65;//Probabilidad de que el jugador atine un tiro
                
                System.out.println("Cual es el nivel de experiencia del jugador?");
                System.out.println("1. Principiante: +0% de probabilidad de hacer daño");
                System.out.println("2. Intermedio: +5% de probabilidad de hacer daño");
                System.out.println("3. Experto: +15% de probabilidad de hacer daño");
                System.out.println("");
                System.out.println("En que nivel de experiencia se encuentra?");
                
                int nivel = sc.nextInt();//pide el nivel del jugador
                while (nivel < 1 || nivel > 3){
                    System.out.println("Ingrese un numero dentro de las opciones de nivel (1-3)");
                    nivel = sc.nextInt();
                }
                
                switch (nivel){//suma a la probabilidad de daño de acuerdo al nivel
                    case 2:
                        prob_damage += 0.05;
                        break;
                    case 3:
                        prob_damage += 0.15;
                        break;
                }
                
                char respuesta = 's';
                int random_prob_damage = 0;
               
                while (respuesta == 's' || respuesta == 'S'){
                    System.out.println("----------------------------------------");
                    System.out.println("El zombie se encuentra a " + distancia + " metros!");
                    System.out.println("El jugador cuenta con " + balas + " balas!");
                    System.out.println("");
                    random_prob_damage = (new Random().nextInt((100-1)+1)+1);//genera un numero entre 1 y 100
                    double por = random_prob_damage*0.01;//lo transfroma a decimal
                    
                    
                    if (por <= prob_damage){//aplica la probabilidad de que el tiro atine o no
                        damage = new Random().nextInt((7-1)+1)+1;//calcula el daño random que se va a inflingir
                        vida_zombie -= damage;//resta este a la vida del zombie
                        System.out.println("Hit! El tiro ha reducido el HP del zombie por: " + damage + "!");
                    } else {//si no atina, el zombie avanza 
                        avance = new Random().nextInt((5-3)+1)+3;//calucla una distancia random, la cual el zombie avanzara
                        distancia -= avance;//resta la distancia de la distancia actual del zombie
                        System.out.println("Ha fallado! El zombie avanza " + avance + " metros");
                    }
                    balas --;//resta 1 bala cada ronda

                    if (vida_zombie <= 0 && distancia > 0){//valida si gana o pierde y la razon de la misma. Sale del while
                        vida_zombie = 0;
                        System.out.println("Ha ganado! La vida del zombie es 0");
                        respuesta = 'n';
                    } else if (distancia <= 0){
                        distancia = 0;
                        System.out.println("Ha perdido, el zombie lo ha alcanzado antes de morir");
                        respuesta = 'n';
                    } else if (balas == 0){
                        System.out.println("Ha perdido, se ha quedado sin balas :c");
                        respuesta = 'n';
                    } else {
                        System.out.println("Vida restante del zombie es " + vida_zombie + "HP");
                    
                        System.out.println("Esta listo para la siguiente ronda? [s/n]");
                        respuesta = sc.next().charAt(0);
                    }
                }
                break;
            case 2:
                trifuerza();
                break;
            } 
            
            System.out.println("Menu:");
            System.out.println("1. Fight or flight");
            System.out.println("2. Trifuerza");
            System.out.println("Ingresar cualquier otro numero sale del programa");
            System.out.println("");
            System.out.println("Ingrese su opcion: ");
            opcion = sc.nextInt();
        }
        System.out.println("Salio del programa");
    }
    
}
