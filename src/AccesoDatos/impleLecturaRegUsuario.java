/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

import ControlException.ExceptionFlujo;
import ControlUsuario.userServicio;
import LogicaDeNegocio.InterfazLecturaRegusuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Administrator2
 */
public class impleLecturaRegUsuario implements InterfazLecturaRegusuario {

    /**
     * leer la informacion del servidor por intermedio de un socket
     */
    public String leerRegUsuario() throws ExceptionFlujo  {
        DataOutputStream dos;
        Socket sk;
        DataInputStream dis;
        String respuesta = null;

        userServicio usServicio = new userServicio();
        try {
            
            sk = new Socket("127.0.0.1", 10578);
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());
            
            dos.writeUTF(usServicio.getUsuario()+"&"+usServicio.getContraseña()+"&"+
                    usServicio.getFechaInicio()+"&"+usServicio.getHoraInicio()+"&");
            
            respuesta = dis.readUTF();
            dis.close();
            dos.close();
            sk.close();

        } catch (Exception ex) {
            throw new ExceptionFlujo(ex);
        }
      
        return respuesta;
    }

}
