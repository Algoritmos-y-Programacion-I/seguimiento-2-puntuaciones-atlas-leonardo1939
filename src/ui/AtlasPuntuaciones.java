//Entradas: 
// Numero de jugadores(Scanner)
// Numero de Rondas(Scanner)
// Puntaje de Jugador#
// Salidas:
// Puntaje Final 
//Este programa sirve para llevar la cuenta de el progreso de los jugadores y proporcionar al final un resultado de cual fueron sus puntajes
// y dar al ganador 
//Ejemplo:
//Ingrese el número de jugadores
//2
//Ingrese el número de rondas
//2
//Jugador1- Puntaje en ronda 1
//23
//Jugador1- Puntaje en ronda 2
//34
//Jugador2- Puntaje en ronda 1
//32
//Jugador2- Puntaje en ronda 2
//34
//Resultados finales
//Jugador1 Puntaje total: 57
//Jugador2 Puntaje total: 66
//El puntaje mas alto fue:
//Jugador2 con 66 puntos

import java.util.Scanner;

public class Atlas2 {
    public static Scanner escaner;
    public static String[] jugadores;
    public static int[] puntajes;

    public static void main(String args[]) {
        escaner = new Scanner(System.in);
        int NumeroJugadores = numJugadores();
        int Rondas = numRondas();
        jugadores = new String[NumeroJugadores];
        puntajes = new int[NumeroJugadores];
        
        for (int i = 0; i < NumeroJugadores; i++) {
            jugadores[i] = "Jugador" + (i + 1);
            puntajes[i] = 0;
            for (int j = 0; j < Rondas; j++) {
                puntajes[i] += obtenerPuntaje(jugadores[i], j + 1);
            }
        }
        mostrarResultados();
        mostrarGanador();
    }

    public static int numJugadores() {
        int NumeroJugadores;
        do {
            System.out.println("Ingrese el Numero de Jugadores");           
            NumeroJugadores = escaner.nextInt();
        } while (NumeroJugadores < 1 || NumeroJugadores > 10);
        return NumeroJugadores;
    }

    public static int numRondas() {
        int Rondas;
        do {
            System.out.println("Ingrese el Numero de Rondas");
            Rondas = escaner.nextInt();
        } while (Rondas < 1 || Rondas > 5);
        return Rondas;
    }

    public static int obtenerPuntaje(String jugador, int ronda) {
        int puntaje;
        do {
            System.out.println(jugador + "- Puntaje en ronda " + ronda);
            puntaje = escaner.nextInt();
        } while (puntaje < 0 || puntaje > 100);
        return puntaje;
    }

    public static void mostrarResultados() {
        System.out.println("Resultados Del Torneo ");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i] + " Puntaje total: " + puntajes[i]);
        }
    }

    public static void mostrarGanador() {
        if (jugadores.length == 0) return;
        int MejorPuntaje = puntajes[0];
        String ganador = jugadores[0];

        for (int i = 1; i < jugadores.length; i++) {
            if (puntajes[i] > MejorPuntaje ) {
                MejorPuntaje = puntajes[i];
                ganador = jugadores[i];
            }
        }
        System.out.println(" El jugador con la puntuación mas alta es: ");
        System.out.println(ganador + " con " + MejorPuntaje + " puntos");
    }
}
