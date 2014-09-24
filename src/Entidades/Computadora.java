/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 * DTO compuitadora para recibir y enviar informacion
 * @author Yamit Cardozo
 */
public class Computadora {

    /**
     *  asignar y recibir idComputadoras
     */
    private String idComputadora;

    /**
     *  retorna id de la computadoras
     * @return
     */
    public String getIdComputadora() {
        return idComputadora;
    }

    /**
     * asigan id computadora
     * @param idComputadora
     */
    public void setIdComputadora(String idComputadora) {
        this.idComputadora = idComputadora;
    }

    //nota: la descripcion y el estado esta encargada por el administrador
    // la entidad registro esta encargada por el administrador
}
