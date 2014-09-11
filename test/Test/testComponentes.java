/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import ControlException.ExceptionFlujo;
import ControlUsuario.userServicio;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator2
 */
public class testComponentes {
   
    public testComponentes() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
//     public void hello() {}
    @Test
    public void asigancionAtributosLoggueoTest(){
        DataOutputStream dos;
        Socket sk;
        DataInputStream dis;
        String respuesta = null;

        userServicio s = new userServicio();
        try {

            sk = new Socket("localhost", 10578);
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());

            dos.writeUTF(s.getUsuario()+"&"+s.getContraseña()+"&"+
                    s.getFechaInicio()+"&"+s.getHoraInicio()+"&");

            respuesta = dis.readUTF();
            dis.close();
            dos.close();
            sk.close();

        } catch (Exception ex) {
            new ExceptionFlujo(ex);
        }
         s.asignacionAtributos("oscar&mera&28/08/2014&9:30&");
         assertEquals("oscar",s.getUsuario());
         assertEquals("mera",s.getContraseña());
         assertEquals("28/08/2014",s.getFechaInicio());
       assertEquals("9:30",s.getHoraInicio());
    }
}
