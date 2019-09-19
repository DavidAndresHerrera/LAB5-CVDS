/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet;

import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.*;
import java.util.*;


/**
 *
 * @author 2152069
 */

@ManagedBean(name = "guessBean")
@ApplicationScoped
@SessionScoped 
public class Game {
    
    private int numeroIntentos;
    private int puntaje;
    private boolean estadoJuego;
    private Random aleatorio ;
    private int numeroGenerado;
	private String ganaste;
	private ArrayList<Integer> intentos;
    public Game(){
        puntaje = 100000;
        estadoJuego = false;
        numeroIntentos = 0;
        aleatorio = new Random();
        aleatorio();
		intentos = new ArrayList<Integer>();
    }
    private void aleatorio() {
    	numeroGenerado = aleatorio.nextInt(10);
    }
	public int getNumeroGenerado(){
		return numeroGenerado;
	}
    public int getPuntaje(){
        return puntaje;
    }
    public int getNumeroIntentos(){
        return numeroIntentos;
    }
    public String getEstado(){
    	ganaste = "Ganaste tu puntaje es : "+puntaje;
    	if (estadoJuego) return ganaste;
        return "Estas jugando!!";
    }
    public boolean getEstadoJuego() {
    	return estadoJuego;
    }
    public int getNumeroAleatorio(){
        return numeroGenerado;
    }
	
	public ArrayList<Integer> getIntentos(){
		return intentos;
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
			intentos.add(ingresado);
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
		intentos.clear();
    }
    
}
