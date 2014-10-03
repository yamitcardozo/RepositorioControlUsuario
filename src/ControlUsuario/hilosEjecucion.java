/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlException.ExceptionFlujo;
import Entidades.Usuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator2
 */
// persona
public class hilosEjecucion extends Thread  {

    /**
     *  socket para hacer la comunicacion de cliente servidor
     */
    protected static Socket sk;
    /**
     *  objeto para realizar flujos de salida de datos
     */
    protected DataOutputStream dos;
      /**
     *  objeto para realizar flujos de entreda de datos
     */
    protected DataInputStream dis;
    /**
     *  id de contador de usuario en momento determinado
     */
    private int id;
    /**
     *  DTO  para almacenar informacion de usuario
     */
    private Usuario usUsuario;
    /**
     *  realiza servicios de usuario
     */
    private userServicio usServicio;
    /**
     *  log para almacenar informacion de errores
     */
    Logger log = Logger.getLogger(hilosEjecucion.class);

    int verificador=0;
    private JTextArea mensajeChat;

    private int creado;
//    /**
//     *  parametro para ingreso usuario
//     */
//     private boolean loguser = false;
//      /**
//     *  parametro para cerra cesion
//     */
//     private boolean logcierre = false;
     /**
      *  contructor asigna parametro cierre de cesion
      */
//     public hilosEjecucion()
//     {
//         logcierre = true;
//     }
    /**
     *  constructor hilos de ejecucion de  cada cliente
     * @param id
     */

//    public hilosEjecucion(int id,Usuario usuario,Socket sk) {
//
//        this.id = id;
//        this.sk = sk;
//        usUsuario = usuario;
//        usServicio = new userServicio();
//
//         try
//        {
//         dis = new DataInputStream(sk.getInputStream());
//         dos = new DataOutputStream(sk.getOutputStream());
//        }catch(Exception ex)
//        {
//            new ExceptionFlujo(ex);
//        }
//
//
//    }
    public hilosEjecucion(VentanaPrincipal f) {

//        this.creado = creado;
        sk=null;
        mensajeChat=null;
        dos=null;
//        this.id = id;
//        this.sk = sk;
//        usUsuario = usuario;
        // declarando el socket a utilizar
        boolean i=true;
        while(i==true){
        if(sk==null)
        {
            try {
                log.info("asignacion de IP");
//                sk = new Socket("192.168.37.145", 10578);
                sk = new Socket("localhost", 10578);
                log.info("acepto la IP suministrada");
                i=false;
        }catch (IOException e)
        {
            log.info("no hay destino de conexion");
//            f.mostrarMensajeIp();
            continue;
        }
         catch (Exception ex) {
            log.info("contrsuctor hiloEjecucion, otra excepcion a cracion de socket");
            new ExceptionFlujo(ex);
        }
        }
        }
        // declarando flujos de entreda y salida
         try
        {
         dis = new DataInputStream(sk.getInputStream());
         dos = new DataOutputStream(sk.getOutputStream());
        }catch(Exception ex)
        {
            log.info(" constructor hilosEjecucion declaracion flujos entreda salida");
            new ExceptionFlujo(ex);
        }

        
    }

      public Usuario getUsUsuario() {
        return usUsuario;
    }

    public void setUsUsuario(Usuario usUsuario) {
        this.usUsuario = usUsuario;
    }
    
    /**
     *  iniciador de cada hilo cliente
     */
     @Override
    public void run()  {

// hay que quitar esto
        try
        {
         dos.writeUTF("20");

        }catch(Exception ex)
        {
            log.info("metodo enviarMensajeServidor, mensaje de registro");
            new ExceptionFlujo(ex);
        }
         log.info("metodo enviarMensajeServidor, mensaje de inicio");
    }

     public void enviarMensajeConsulta()
     {
          /** escribir mensaje al servidor  */
         try
        {
             System.out.println(usUsuario.getIdUsuario()+" "+usUsuario.getContraseña()+"enviados");
         dos.writeUTF("1"+"&"+usUsuario.getIdUsuario()+"&"+usUsuario.getContraseña());

        }catch(Exception ex)
        {
            log.info("metodo enviarMensajeServidor mensaje de consulta");
            new ExceptionFlujo(ex);
        }

        verificador=1;
         /** recivir mensaje de servidor*/
//System.out.println("ent1");
//         String mensaje = "";
//        try
//        {
//System.out.println("ent2");
//         mensaje = dis.readUTF();
//         System.out.println("ent3");
//         log.info("metodo recibirmensaje asignar valores set get enviado:"+ mensaje);
//
//         if(!mensaje.equalsIgnoreCase("NA"))
//         {
//         usServicio = new userServicio();
//         usServicio.usuarioDivision(mensaje, usUsuario);
//         log.info(usUsuario.getIdUsuario()+" "+usUsuario.getContraseña()+" "+usUsuario.getPrimerNombre()+"  "+ usUsuario.getPrimerApellido());
//         }else
//         {
//             usUsuario.setIdUsuario("NA11111111234");
//             usUsuario.setContraseña("NA111111111123");
//         }
//        }catch(Exception e)
//        {
//            new ExceptionFlujo(e);
//        }
     }
     public void enviarMensajeServidorCierre()
    {

        try
        {
         dos.writeUTF("2&cierreCesion");

        }catch(Exception ex)
        {
            log.info("metodo enviarMensajeServidorCierre");
            new ExceptionFlujo(ex);
        }
    }
     public void enviarMensajeNoVisible()
    {
        
        try
        {
         dos.writeUTF("novisible");

        }catch(Exception ex)
        {
            log.info("metodo enviarMensajeNoVisible");
            new ExceptionFlujo(ex);
        }
        
    }
     public void recibirMensajesServidor() throws IOException{
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(sk.getInputStream());
//            dis = new DataInputStream(sk.getInputStream());
        } catch (IOException ex) {
            log.error("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            log.error("El socket no se creo correctamente. ");
        }

        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();

                
                if(mensaje.equalsIgnoreCase("inicioSesion"))
                {
                    if(!VentanaPrincipal.visible())
                    {
                        dos.writeUTF("novisible");
                        continue;
                    }else
                    {
                         dos.writeUTF("visible");
                        continue;
                    }
                }else
                    if(mensaje.equalsIgnoreCase("novisible"))
                {
                    continue;
                }else if(mensaje.equalsIgnoreCase("visible"))
                {
                    continue;
                }
                else if(mensaje.equalsIgnoreCase("okvisible"))
                {
                    System.out.println("llego mensaje visible");
                    continue;
                }
                else if(mensaje.equalsIgnoreCase("oknovisible"))
                {
                    System.out.println("llego mensaje novisible");
                    continue;
                }
                else
                if(mensaje.equalsIgnoreCase("abrirPortal"))
                {
                    dos.writeUTF("okabrirPortal");
                    VentanaPrincipal.quitarPortal();
                }else
                       if(mensaje.equalsIgnoreCase("cerrarPortal"))
                {
                        dos.writeUTF("okcerrarPortal");
                    VentanaPrincipal.colocarPortal();
                }
                   else
               if(mensaje.equalsIgnoreCase("ok1038098"))
                {
                    System.out.println("llego el mensaje ok");
                    continue;
                }
               else
                if(verificador==1)
                {

                    try
                    {

                     log.info("metodo recibirmensaje asignar valores set get enviado:"+ mensaje);

                     if(!mensaje.equalsIgnoreCase("NA"))
                     {
                         dos.writeUTF("3");
                     usServicio = new userServicio();
                     usServicio.usuarioDivision(mensaje, usUsuario);
                     log.info(usUsuario.getIdUsuario()+" "+usUsuario.getContraseña()+" "+usUsuario.getPrimerNombre()+"  "+ usUsuario.getPrimerApellido());
                     }else
                     {
                         usUsuario.setIdUsuario("NA11111111234");
                         usUsuario.setContraseña("NA111111111123");
                     }
                    }catch(Exception e)
                    {
                        new ExceptionFlujo(e);
                    }
                    verificador=0;
                }else{

//                    if(mensajeChat==null){
//                mensajeChat = new ClienteChat().getMensajesChat();
//                    }
//
//                mensajeChat.append(mensaje + "\n");
                }

               //mensajesChat.append(mensaje + System.lineSeparator());
            }catch(IOException e)
            {
                log.error("Error en Stream del socket" + e.getMessage());
                conectado = false;
                throw new IOException();
            }
            catch (Exception ex) {
               log.error("Error" + ex.getMessage());
                conectado = false;
                 new ExceptionFlujo(ex);
                System.exit(1);
            }
        }
    }
}


