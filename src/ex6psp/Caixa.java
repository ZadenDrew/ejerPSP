/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6psp;

import java.util.Random;

/**
 *
 * @author oracle
 */
public class Caixa extends Thread {

    static double dinero = 0.0;
    static int aleatorio = 0;
    String nombre;
    static Random rd;

    /* constructor caixa */
    public Caixa(String nombre) {
        super(nombre);
        this.nombre = nombre;
        rd = new Random();
    }

    /* método sincronizado para ingresar diñeiro na caixa */
    synchronized void ingresar() {
        System.out.println(getName() + " accede ó diñeiro da caixa: " + dinero);

        aleatorio = (int) (rd.nextInt(10));

        dinero = dinero + (double) aleatorio;
        System.out.println(nombre + " ingresa " + aleatorio);
        System.out.println(nombre + " total: " + dinero + "\n");
        notifyAll();
    }

    /* método sincronizado para extraer diñeiro da caixa */
    synchronized void extraer() {
        System.out.println(getName() + " accede ó diñeiro da caixa: " + dinero);

        aleatorio = (int) (rd.nextInt(10));
        /* si o diñeiro en caixa é menor que 0 non se realiza a sustración 
         ou en caso de que o diñeiro a sustraer sexa maior á cantidade que se 
         ten na caixa*/
        if (dinero <= 0 || aleatorio >= dinero) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex);
            }
        } else {
            dinero = dinero - (double) aleatorio;
        }

        System.out.println(nombre + " extrae " + aleatorio);
        System.out.println(nombre + " total: " + dinero + "\n");
        notifyAll();
    }

    @Override
    public void run() {
        if ("Consumidor".equalsIgnoreCase(nombre)) {
            for (int i = 0; i < 5; i++) {
                extraer();
            }
        }

        if ("Productor".equalsIgnoreCase(nombre)) {
            for (int i = 0; i < 10; i++) {
                ingresar();
            }
        }
    }
}
