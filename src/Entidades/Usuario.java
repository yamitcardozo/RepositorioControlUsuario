/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 * Dto para enviar y recibir datos de logue.
 * @author Yamit Cardozo
 */
public class Usuario {

    /**
     *  para asiganr y recibir idUsuario
     */
    private String idUsuario;
     /**
     *  para asiganr y recibir contraseñas
     */
    private String contraseña;
    /**
     *  para asiganr y recibir primerNombre
     */
    private String primerNombre;
    /**
     *  para asiganr y recibir primerApellido
     */
    private String primerApellido;

    /**
     * retorna contraseña del usuario
     * @return
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * asigna contraseña del usuario
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     *  retorna el id del usuario
     * @return
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * asigna el id con el usuario
     * @param idUsuario
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *  retorna el primer apellido del usuario
     * @return
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * asigan el primer apellido del usuario
     * @param primerApellido
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     *  retorna el primer nombre del usuario
     * @return
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * asigna el primer nombre del usuario
     * @param primerNombre
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    // nota: en el idUsuario, se utiliza su idUsuario o usuario
}
