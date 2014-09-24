/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SesionUsuario.java
 *
 * Created on 29/08/2014, 10:58:36 AM
 */

package ControlUsuario;

import ControlException.ExceptionFlujo;
import Entidades.Usuario;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Yamit Cardozo
 */
public class SesionUsuario extends javax.swing.JFrame implements ActionListener{

    /**
     *  log para almacenar informacion de errores
     */
    private Logger log = Logger.getLogger(ConectorCliente.class);
    Usuario usuario;
     /**
     *  socket para hacer la comunicacion de cliente servidor
     */
    protected Socket sk;

    private final GridBagConstraints constraints;
    private final JButton apagar, cerrarCesion,reiniciar;

    /** Creates new form SesionUsuario */

    public JButton boton(String subtitulo)
    {
        JButton b = new JButton(subtitulo);
        b.setActionCommand(subtitulo);
        b.addActionListener(this);
        getContentPane().add(b, constraints);
        return b;



    }

    public SesionUsuario() {


        super("SesionUsuario");

        getContentPane().setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(3, 10, 3, 10);

        cerrarCesion = boton("cerrarSesion");
        apagar = boton("apagar");
        reiniciar = boton("reiniciar");

          this.setBounds(1000, 0, 350, 80);
          this.setResizable(false); // Evita que se pueda estirar la ventana
          this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // Deshabilita el boton de cierre de la ventana
          this.setVisible(true);
//                initComponents();
//
//                this.setBounds(1000, 0, 350, 80);
//                 this.setResizable(false); // Evita que se pueda estirar la ventana
//                this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // Deshabilita el boton de cierre de la ventana
//                 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                 this.setVisible(true);

                 
//                this.usuario = usuario;
//                 try {
//            sk = new Socket("192.168.1.146", 10578);
//        } catch (Exception ex) {
//            log.info(" constructor hilosEjecucion");
//            new ExceptionFlujo(ex);
//        }
//                prueba.addActionListener(this);
    }

     

    /**
 * Iniciar el hilo(Thread) con tiempo estimado con las excepciones propias de este,
 * IllegalArgumentException, InterruptedException
 */
//public void iniciar(){
//
//      ArrayList<Thread> clients = new ArrayList<Thread>();
//        log.info("metodo iniciar de la clase ConectorCliente");
//        for(int i=0; i < 1; i++) {
//            hil = new hilosEjecucion(i, usuario, sk);
//            clients.add(hil);
//        }
//        for (Thread thread : clients)  {
//            try
//            {
//              thread.sleep(5000);
//              thread.start();
//            }
//            catch(Exception e)
//            {
//                new ExceptionFlujo(e);
//            }
//
//
//        }
//}
//
//public void iniciar()
//{
//    int i = 0;
//    log.info("metodo iniciar de la clase ConectorCliente");
//    hil = new hilosEjecucion(i, usuario, sk);
//    hil.run();
//}


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrarCesion = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCerrarCesion.setText("Cerrar Sesion");
        btnCerrarCesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCesionActionPerformed(evt);
            }
        });

        btnReiniciar.setText("reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        btnApagar.setText("apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(btnCerrarCesion)
                .add(18, 18, 18)
                .add(btnReiniciar)
                .add(18, 18, 18)
                .add(btnApagar)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCerrarCesion)
                    .add(btnApagar)
                    .add(btnReiniciar))
                .addContainerGap(266, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCesionActionPerformed
        // TODO add your handling code here:
          // ejecucionexe("shutdown -l");
         hilosEjecucion hil = new hilosEjecucion();
         hil.enviarMensajeServidorCierre();
         System.exit(1);
    }//GEN-LAST:event_btnCerrarCesionActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
           ejecucionexe("shutdown -r");
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        // TODO add your handling code here:
             ejecucionexe("shutdown -s");
    }//GEN-LAST:event_btnApagarActionPerformed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                SesionUsuario s = new SesionUsuario();
//                s.setVisible(true);
//                s.setLocationRelativeTo(null); // centrar en pantalla
//                s.setLocation(1100,0);
//                s.setResizable(false);
//                s.setSize(250,80);
//            }
//        });
//    }

    void ejecucionexe(String hilera){
         try
        {
        Runtime.getRuntime().exec(hilera);
        }
         catch (SecurityException e)
        {
             e.fillInStackTrace();
            // System.out.println("existe administrador de seguridad no puede crear subproceso");
        }
        catch (IOException e){
            e.fillInStackTrace();
            //System.out.println("error en el flujo de datos entrada o salida");
        }
        catch (NullPointerException e){
            e.fillInStackTrace();
            //System.out.println(" el comando de .exe es nulo");
        }
        catch(IllegalArgumentException e){
            e.fillInStackTrace();
            //System.out.println(" el comando de .exe esta vacio");
        }
    }

    public void inicio(){
                //SesionUsuario s = new SesionUsuario();
//                s.setVisible(true);
//                s.setLocationRelativeTo(null); // centrar en pantalla
//                s.setLocation(1100,0);
//                s.setResizable(false);
//                s.setSize(250,80);
//                this.setBounds(1100, 0, 250, 80);
//                this.setVisible(true);
//                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                this.setLocationRelativeTo(null); // centrar en pantalla
                //this.setLocation(1100,0);
//                this.setResizable(false);
               // this.setSize(250,80);
    }

     public void actionPerformed(ActionEvent e) {
        if ("cerrarSesion" == e.getActionCommand())
        {
             hilosEjecucion hil = new hilosEjecucion();
             hil.enviarMensajeServidorCierre();
             System.exit(1);
        }else if("apagar" == e.getActionCommand())
        {

        }else if("reiniciar" == e.getActionCommand()){}
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCerrarCesion;
    private javax.swing.JButton btnReiniciar;
    // End of variables declaration//GEN-END:variables

   
    

    

}
