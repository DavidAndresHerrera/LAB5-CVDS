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
        numeroGenerado = aleatorio.nextInt(1000);
    }
    public int getPuntaje(){
        return puntaje;
    }
    public int getNumeroIntentos(){
        return numeroIntentos;
    }
    public boolean getEstado(){
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
            setEstado();
        }
        else{
            setPuntaje();
        }
    }
}
