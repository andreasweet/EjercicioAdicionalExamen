package com.example.ejercicioadicionalexamen.Modelos;

import java.io.Serializable;

public class Partido implements Serializable {
    String equipo1;
    String equipo2;
    String resultado;
    String comentario;

    public Partido() {
    }


    public Partido(String equipo1, String equipo2, String resultado, String comentario) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
        this.comentario = comentario;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "equipo1='" + equipo1 + '\'' +
                ", equipo2='" + equipo2 + '\'' +
                ", resultado='" + resultado + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
