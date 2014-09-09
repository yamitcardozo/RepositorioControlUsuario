/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlSocket;

import ControlUsuario.VentanaPrincipal;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator2
 */
public class SocketControl {

      private Logger log = Logger.getLogger(SocketControl.class);
    /**
     *  crea una instancia de Socket  por cada llamado,con las excepciones
     *  propias de este, UnknownHostException,IOException,IllegalArgumentException,
     *  parametro hilera ip de comunicacion, puesto es el puerto de comunicacion
     * @param hilera
     * @param puerto
     * @return
     */
    public Socket instanciaSocket(String hilera, int puerto){
        log.info("metodo instanciaSocket de la clase SocketControl");
        Socket s = null;
        try{
        s = new Socket(hilera, puerto);
        }catch(UnknownHostException e)
        {log.error(e.getMessage());}
        catch(IOException e)
        { log.error(e.getMessage());}
        catch(SecurityException e)
        {log.error(e.getMessage());}
        catch(IllegalArgumentException e)
        {log.error(e.getMessage());}
        return s;
    }

}
