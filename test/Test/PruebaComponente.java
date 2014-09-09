/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.uispec4j.Button;
import org.uispec4j.TextBox;
import org.uispec4j.UISpec4J;
import org.uispec4j.Window;

/**
 *
 * @author Administrator2
 */
public class PruebaComponente {

    public PruebaComponente() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        //setAdapter(new MainClassAdapter(Main.class, new String[0]));
    }
 

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//    @Test
//    public void testAdd()
//    {
//        //JFrame view = new JFrame();
//        /* Note: Window, TextBox, and Button are UISpec4J classes */
//        Window win = new Window(f);
//        TextBox entry = win.getInputTextBox("txtUsuario");
//        entry.appendText("roger");
//        Button plus = win.getButton("btnEnviar");
//        plus.click();
//        //TextBox result = win.getTextBox("Result");
//        /* Standard JUnit assert */
//         assertEquals("5", entry.getText());
//    }
     static {
      UISpec4J.init();
    }
    @Test
    public void testSomething() {
   // ...perform your tests here...
    }
    @Test
    public void datosArchivo(){

    }
}