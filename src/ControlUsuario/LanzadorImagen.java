/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Elelegido
 */
public class LanzadorImagen implements ActionListener
    {
        private int indicativo;
        private VentanaPrincipal f1;
        private Timer timer;
        private int dx=1,dy=1;
        private int x=477;
        private int y=66;

        public LanzadorImagen(int indicativo, VentanaPrincipal f)
        {
            this.indicativo = indicativo;
            f1=f;
            // Timer
        timer = new Timer(10, this); // cada 5ms llama actionPerformed
        timer.start();
        }

        public void actionPerformed(ActionEvent e) {


            if(y<150)
            {
               y+=dy;
               f1.cambiarImagenY(y);
            }else
           if(indicativo==1)
           {
               f1.cambiarImagenUnlock();
               indicativo=0;
           }else
               if(x>150)
           {
                   x-=dx;
                   f1.cambiarImagenX(x);
               }else
           if(y==150 && x==150)
           {
               f1.quitarPortal();
               y = 477;
               x = 66;
               f1.cambiarImagenLock();
               timer.stop();
           }
        }


    }