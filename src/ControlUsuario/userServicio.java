/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import Entidades.Usuario;

/**
 *
 * @author Yamit Cardozo
 */
public class userServicio {


    /**
     * contructor vacio
     */
    public userServicio()
    {}

    /**
     *  particiona los datos y los ubica en su respectivo campo
     * @param mensaje
     * @param u
     */
      public void usuarioDivision(String mensaje, Usuario u)
    {
        String lista[] = mensaje.split("&");
            u.setIdUsuario(lista[0]);
            u.setContraseña(lista[1]);
            u.setPrimerNombre(lista[2]);
            u.setPrimerApellido(lista[3]);
    }


}
