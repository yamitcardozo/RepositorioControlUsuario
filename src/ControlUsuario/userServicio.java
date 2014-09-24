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

//    public String usuarioDivision(String mensaje, Usuario u)
//    {
//        String lista[] = mensaje.split("&");
//        if(lista.length==3)
//        {
//            u.setIdUsuario(lista[1]);
//            u.setContraseña(lista[2]);
//            u.setPrimerNombre(lista[3]);
//            u.setPrimerApellido(lista[4]);
//            return lista[0];
//        }
//
//
//        return "NA";
//    }

      public void usuarioDivision(String mensaje, Usuario u)
    {
        String lista[] = mensaje.split("&");
            u.setIdUsuario(lista[0]);
            u.setContraseña(lista[1]);
            u.setPrimerNombre(lista[2]);
            u.setPrimerApellido(lista[3]);
    }
//     private static String contraseña = "NA";
//     private static String usuario = "NA";
//     private static String FechaInicio = "NA";
//     private static String horaInicio="NA";
//
//     // get y set del objeto que se utilizara como servicio
//     //de transferencia de datos.
//    public String getFechaInicio() {
//        return FechaInicio;
//    }
//
//    public void setFechaInicio(String FechaInicio) {
//        this.FechaInicio = FechaInicio;
//    }
//
//    public String getHoraInicio() {
//        return horaInicio;
//    }
//
//    public void setHoraInicio(String horaInicio) {
//        this.horaInicio = horaInicio;
//    }
//    public String getContraseña() {
//        return contraseña;
//    }
//
//    public void setContraseña(String contraseña) {
//        this.contraseña = contraseña;
//    }
//
//    public String getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(String usuario) {
//        this.usuario = usuario;
//    }

//    public void asignacionAtributos(String mensaje){
//        int tamaño = mensaje.length();
//        String hilera="";
//        char caracter;
//        int indicador1=0;
//        int indicador2=0;
//        int indicador3=0;
//        for(int i=0;i<tamaño;i++){
//            caracter = mensaje.charAt(i);
//
//            if(caracter=='&'){
//                if(indicador1==0){
//                    usuario = hilera;
//                    indicador1=1;
//                }else if (indicador2==0){
//                    contraseña = hilera;
//                    indicador2=1;
//                }else if(indicador3==0){
//                    FechaInicio = hilera;
//                    indicador3=1;
//                }
//                else{
//                    horaInicio=hilera;
//                }
//                hilera="";
//            }else{
//            hilera=hilera+caracter;
//            }
//        }
//    }
}
