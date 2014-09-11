/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import AccesoDatos.impleLecturaRegUsuario;
import ControlException.ExceptionFlujo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator2
 */
// persona
public class hilosEjecucion extends Thread {

    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int id;
    private userServicio usServicio;
    private impleLecturaRegUsuario iml;
    private Logger log = Logger.getLogger(hilosEjecucion.class);

    public hilosEjecucion(int id) {
        this.id = id;
    }

    @Override
    public void run()  {
        try {
            usServicio = new userServicio();
//        SocketControl s = new SocketControl();
//        Flujos f = new Flujos();
//
//        sk = s.instanciaSocket("127.0.0.1", 10578);
//        dos = new DataOutputStream(f.flujoSocket(sk));
//
//        try {
//            //dos = new DataOutputStream(sk.getOutputStream());
//            dis = new DataInputStream(sk.getInputStream());
//
//            System.out.println(id + " envía saludo");
//            dos.writeUTF(usServicio.getUsuario()+"&"+usServicio.getContraseña()+"&"+
//                    usServicio.getFechaInicio()+"&"+usServicio.getHoraInicio()+"&");
//            String respuesta="";
//            respuesta = dis.readUTF();
//
//            usServicio.asignacionAtributos(respuesta);
//
//            System.out.println(id + " Servidor devuelve saludo: welcome " + respuesta);
//
//            dis.close();
//            dos.close();
//            sk.close();
//        } catch (/*IOException ex*/ Exception e) {
//            e.printStackTrace();
//            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
//        }
            iml = new impleLecturaRegUsuario();
            String d = iml.leerRegUsuario();
            usServicio.asignacionAtributos(d);
            log.info("envio de usuario existente en el sistema" + d);
        } catch (ExceptionFlujo ex) {
             new ExceptionFlujo(ex);
        }
    }

         /*long minPrime;
         hilosEjecucion(long minPrime) {
             this.minPrime = minPrime;
         }

         public void run() {
             // compute primes larger than minPrime
              ConectorCliente c = new ConectorCliente();
              c.iniciar();
         }*/

}
