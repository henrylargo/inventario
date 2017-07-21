/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.util;

import java.util.List;

/**
 *
 * @author Hp
 */
public final class Util {

    /**
     * Metodo generico para determinar si un objecto es nulo
     * @param object param to set
     * @return
     */
    public static Boolean esNulo(Object object) {
        return object == null;
    }

    /**
     * Metodo generico para determinar si un String, Lista, etc esta vacio
     *
     * @param object param to set
     * @return
     */
    public static Boolean esVacio(Object object) {
        if (esNulo(object)) {
            return true;
        } else if (object instanceof String) {
            if (((String) object).trim().equals("")) {
                return true;
            }

        } else if (object instanceof List) {
            List<Object> lista = (List<Object>) object;
            if (lista.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que verifica si el parametro enviado es ACT o INA, el valor
     * se utiliza para desplegar valor en <p:selectBooleanButton> 
     * @param estado valor a verificar
     * @return true si es ACT, false caso contrario
     */
    public static boolean esActivo(String estado){
        boolean activo = true;
        if (estado.equals(Constantes.ESTADO_INACTIVO)) {
            activo = false;
        }
        return activo;
    }
    
    /**
     * Metodo que verifica si el parametro enviado es true o false, el valor
     * se utiliza para ser almacenado
     * @param activo boolean a evaluar
     * @return ACT si es true, INA caso contrario
     */
    public static String esActivo(boolean activo) {
        String estado = Constantes.ESTADO_ACTIVO;
        if (!activo) {
            estado = Constantes.ESTADO_INACTIVO;
        }
        return estado;
    }

}