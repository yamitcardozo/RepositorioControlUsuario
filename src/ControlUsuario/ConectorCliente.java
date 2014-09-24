/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlException.ExceptionFlujo;
import Entidades.Usuario;
import java.util.ArrayList;
import org.apache.log4j.Logger;



/**
 *
 * @author Administrator2
 */
public class ConectorCliente {
    /**
     *  log para almacenar informacion de errores
     */
    private Logger log = Logger.getLogger(ConectorCliente.class);
    Usuario usuario;

    public ConectorCliente (Usuario usuario)
    {
        this.usuario = usuario;
    }
/**
 * Iniciar el hilo(Thread) con tiempo estimado con las excepciones propias de este,
 * IllegalArgumentException, InterruptedException
 */
public void iniciar(){

      ArrayList<Thread> clients = new ArrayList<Thread>();
        log.info("metodo iniciar de la clase ConectorCliente");
        for(int i=0; i < 1; i++) {
//            clients.add(new hilosEjecucion(i,usuario));
        }
        for (Thread thread : clients)  {
            try
            {
              thread.sleep(5000);
              thread.start();
            }
            catch(Exception e)
            {
                new ExceptionFlujo(e);
            }
                
            
        }
}
    /*
    Socket cliente;
    int puerto = 9000;
    String ip = "192.168.37.130";
    BufferedReader entrada,teclado;
    PrintStream salida;

    public void iniciar(){
        String dato;
        try{
            cliente = new Socket(ip,puerto);
            entrada = new BufferedReader
                    ( new InputStreamReader(cliente.getInputStream()));
            teclado = new BufferedReader(new InputStreamReader(System.in));
            String tec = teclado.readLine();
            salida = new PrintStream(cliente.getOutputStream());
            salida.println(tec);
            String msg = entrada.readLine();
            dato = msg;
            System.out.println("datos usuario : " + msg);

            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();

        }catch(Exception e){}
    }*/
}
