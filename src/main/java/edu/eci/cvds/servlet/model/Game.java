/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet.model;

import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;




/**
 *
 * @author 2152069
 */

@ManagedBean(name = "guessBean")
@ApplicationScoped
public class Game {
    
    private int numeroIntentos;
    private int puntaje;
    private boolean estadoJuego;
    private Random aleatorio ;
    private int numeroGenerado;
    public Game(){
        puntaje = 100000;
        estadoJuego = false;
        numeroIntentos = 0;
        aleatorio = new Random();
        aleatorio();
    }
    private void aleatorio() {
    	numeroGenerado = aleatorio.nextInt(1000);
    }
    public int getPuntaje(){
        return puntaje;
    }
    public int getNumeroIntentos(){
        return numeroIntentos;
    }
    public String getEstado(){
    	String ganaste = "Ganaste tu puntaje es  "+puntaje;
    	if (estadoJuego) return ganaste;
        return "estas en juego";
    }
    public boolean getEstadoJuego() {
    	return estadoJuego;
    }
    public int getNumeroAleatorio(){
        return numeroGenerado;
    }
    public void setPuntaje(){
        puntaje = puntaje-10000;
    }
    public void setNumeroIntentos(int value){
        numeroIntentos = value;
    }
    public void setEstado(){
        estadoJuego = !estadoJuego;
    }
    
    public void guess(int ingresado){
        if (ingresado == numeroGenerado){
            estadoJuego = true;
        }
        else{
        	setPuntaje();
        	if (puntaje <= 0 ) {
        		
        		perdiste();
        	}
            numeroIntentos += 1;
        }
    }
    private void perdiste() {
    	estadoJuego = false;
    	puntaje = 0;
    }
    public void restart() {
    	puntaje = 100000;
    	estadoJuego = false;
    	aleatorio();
    	numeroIntentos = 0;
    }
    
}
