/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FlujoDeDatos;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator2
 */
public class Flujos {

       private Logger log = Logger.getLogger(Flujos.class);
/**
 *  crea un flujo de trtansporte de datos para Socket,con la excepcion
 *  propia de este, IOException, parametro s que envia el socket para asignarle
 *  un flujo
 * @param s
 * @return
 */
        public OutputStream flujoSocket(Socket s)
        {
            log.info("metodo flujoSocket de la clase Flujos");
            OutputStream o = null;
        try {
            o = s.getOutputStream();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
                 return o;
        }
}
