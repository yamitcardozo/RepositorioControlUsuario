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

import java.io.IOException;

/**
 *
 * @author Administrator2
 */
public class SesionUsuario extends javax.swing.JFrame {

    /** Creates new form SesionUsuario */
    public SesionUsuario() {
                initComponents();
    }
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
                    .add(btnReiniciar)
                    .add(btnApagar))
                .addContainerGap(266, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCesionActionPerformed
        // TODO add your handling code here:
           ejecucionexe("shutdown -l");
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
                SesionUsuario s = new SesionUsuario();
                s.setVisible(true);
                s.setLocationRelativeTo(null); // centrar en pantalla
                s.setLocation(1100,0);
                s.setResizable(false);
                s.setSize(250,80);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCerrarCesion;
    private javax.swing.JButton btnReiniciar;
    // End of variables declaration//GEN-END:variables

}
