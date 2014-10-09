/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import controlUsuario.JOptionPaneConTimeOut;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;

/**
 *
 * @author Yamit Cardozo
 */
public class VentanaPrincipal extends JFrame implements ActionListener{

    static hilosEjecucion h = null;
    static VentanaPrincipal f;
    static fram frameAux = null;

    private final GridBagConstraints constraints;
    private final Border border =
        BorderFactory.createLoweredBevelBorder();
    private final JTextField txtUsuario;
    private final JPasswordField ptwPassword;
    private final JLabel lblUsuario,lblPassword,lblImagen,lblImagenSesion;
    private final JButton btnEnviar,btnRegistro;

    private JPasswordField makePasswordFiel()
    {
        JPasswordField t = new JPasswordField(15);
        t.setBorder(border);
        getContentPane().add(t, constraints);
        return t;
    }
    private JLabel makeLabel(String text) {
        JLabel t = new JLabel(text);
        t.setFont(new Font("Arial",Font.BOLD,18));
        getContentPane().add(t, constraints);
        return t;
    }
    private JTextField makeText() {
        JTextField t = new JTextField(15);
        t.setBorder(border);
        getContentPane().add(t, constraints);
        return t;
    }

     private JButton makeButton(String caption) {
        JButton b = new JButton();
        b.setActionCommand(caption);
        b.addActionListener(this);
        getContentPane().add(b, constraints);
        return b;
    }

    public VentanaPrincipal()
    {
            int posx=0;
            int posy=0;
         // padre Pane
          getContentPane().setLayout(new GridBagLayout());
          constraints = new GridBagConstraints();
          constraints.insets = new Insets(20, 5, 20,5);

            constraints.ipadx = 80;
            

            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 2;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.CENTER;
            lblImagenSesion = makeLabel("");

            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.gridwidth = 1;
            constraints.gridx = 0;
            constraints.gridy = 1;
            lblUsuario = makeLabel("Usuario");

            constraints.gridx = 0;
            constraints.gridy = 2;
            lblPassword = makeLabel("Password");

            constraints.gridx = 1;
            constraints.gridy = 1;
            txtUsuario = makeText();

            constraints.gridx = 1;
            constraints.gridy = 2;
            ptwPassword = makePasswordFiel();


            constraints.ipadx = 20;
            constraints.ipady = 20;
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 2;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.insets = new Insets(20, 0, 0,0);
            btnEnviar = makeButton("btnEnviar");

            constraints.ipadx = 0;
            constraints.ipady = 0;
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 2;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.insets = new Insets(20, 0, 0,0);
            btnRegistro = makeButton("btnRegistro");
            btnRegistro.setText("Registrarse");
            btnRegistro.setFont(new Font("Arial",Font.BOLD,10));
            btnRegistro.setForeground(Color.BLUE);

            constraints.ipadx = 20;
            constraints.ipady = 20;
            constraints.gridx = 3;
            constraints.gridy = 1;
            constraints.gridheight = 3;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.insets = new Insets(0, 20, 0,0);
            lblImagen = makeLabel("");

            // imagenes
            lblImagenSesion.setIcon(new
        javax.swing.ImageIcon(getClass().getResource("/Imagenes/images.jpg")));
             lblImagen.setIcon(new
        javax.swing.ImageIcon(getClass().getResource("/Imagenes/lock.png")));
             btnEnviar.setIcon(new
        javax.swing.ImageIcon(getClass().getResource("/Imagenes/next.png")));

//              this.setUndecorated(true);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//              this.setDefaultCloseOperation( DO_NOTHING_ON_CLOSE  );//evita cerra jframe con ALT+C
//        this.setExtendedState( MAXIMIZED_BOTH );//maximizado
//        this.setAlwaysOnTop(true);//siempre al frente
////        nueva instancia de jBlocked pasando como parametros e este JFrame
//        new jBloqueo( this ).block();

            //Display the window.
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            setVisible(true);
    }
    

    public static void  quitarPortal()
    {
        f.setVisible(false);
        if(h!=null)
        {
        h.enviarMensajeNoVisible();
        }
    }

    public static void colocarPortal()
    {
        f.setVisible(true);
    }
    public static boolean visible()
    {
        return f.isVisible();
    }
    public void cambiarImagenY(int numero)
    {
        lblImagen.setLocation(478, numero);
    }
     public void cambiarImagenX(int numero)
    {

        lblImagen.setLocation(numero, 200);
    }
     public void cambiarImagenUnlock()
     {
//           lblImagen.setIcon(new javax.swing.ImageIcon("C:\\Users\\Elelegido\\Documents\\NetBeansProjects\\6.5\\RepositorioControlUsuario\\imagenes\\unlock.png"));
            lblImagen.setIcon(new
        javax.swing.ImageIcon(getClass().getResource("/Imagenes/unlock.png")));
     }
     public void cambiarImagenLock()
     {
//         lblImagen.setIcon(new javax.swing.ImageIcon("C:\\Users\\Elelegido\\Documents\\NetBeansProjects\\6.5\\RepositorioControlUsuario\\imagenes\\lock.png"));
         lblImagen.setIcon(new
        javax.swing.ImageIcon(getClass().getResource("/Imagenes/lock.png")));
     }
     public void mostrarMensajeIp()
     {
         JOptionPane.showInternalMessageDialog(rootPane,"socket cerrado o no encotro servidor","conexion Socket",JOptionPane.ERROR_MESSAGE);
     }
     public static void mostrarMensajeChat(String mensaje)
     {
            if(frameAux==null){
            frameAux = new fram();
            }
            JOptionPaneConTimeOut.visualizaDialogo(frameAux, mensaje,"mensaje chat" , 9000);
         }
     public static  void ApagarEquipo()
     {
         ejecucionexe("shutdown -s");
     }
     static  void ejecucionexe(String hilera){
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

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equalsIgnoreCase("btnEnviar")){
        System.out.println("entro aqui");

         String user = txtUsuario.getText();
        String pass = new String(ptwPassword.getPassword());

        if(user.equalsIgnoreCase("ocamilo.lopera") && pass.equalsIgnoreCase("1152439790"))
        {
            txtUsuario.setText("");
            ptwPassword.setText("");
            LanzadorImagen l = new LanzadorImagen(1,f);
//            h.enviarMensajeNoVisible();
        }else if(user.equalsIgnoreCase("yamit.cardozo") && pass.equalsIgnoreCase("1038098543"))
        {
             txtUsuario.setText("");
            ptwPassword.setText("");
            LanzadorImagen l = new LanzadorImagen(1,f);
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "campo vacio ingrese informacion solicitada");
        }
//        if(user.equals("") || pass.equals("")){
//            JOptionPane.showMessageDialog(null, "campo vacio ingrese informacion solicitada");
//        }else{
//                String usuari ="na";
//                String contraseñ = "na";
//                Usuario u=null;
////                hilosEjecucion h=null;
//
//            try {
//                System.out.println("entro");
//                h = new hilosEjecucion();
//
//                u = new Usuario();
//                   u.setIdUsuario(user);
//                 u.setContraseña(pass);
//
////                 h.setUsUsuario(u);
////                 h.run();
////                 u = h.getUsUsuario();
////
////                   usuari = u.getIdUsuario();
////                   contraseñ= u.getContraseña();
//                   System.out.println("entro1");
//
//            } catch (Exception ex) {
//                 System.out.println(usuari+"   "+ contraseñ);
//            }
//
//
//
//                 // condiciones de valides
//
//                if(usuari.equals(user)){
//
//                    if(contraseñ.equals(pass)){
//
//                        this.setVisible(false);
//                        SesionUsuario q = new SesionUsuario();
//                    try {
//                        h.recibirMensajesServidor();
//                    } catch (IOException ex) {
//                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    }else{
//                        JOptionPane.showMessageDialog(this, "contraseña incorrecta");
//                    }
//
//                }else{
//                    JOptionPane.showMessageDialog(this, "usuario no existe");
//                }
//        }
        }else
        {
            System.out.println("entro en btnRegistro");
                Point p = lblImagen.getLocation();
                int x = p.x;
                int y = p.y;
        }
    }

    public static void main(String[] args){

             try
            {
                 JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(new SubstanceMagmaLookAndFeel());
//            SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


//            Servidor s = new Servidor();
//            s.start();

             f = new VentanaPrincipal();

            int i=0;
        do
        {
          h = new hilosEjecucion(f);
          h.start();
        try {
            h.recibirMensajesServidor();
        } catch ( IOException ex) {
            System.out.println("streem null no puede seguir enviando datos main");
            h.stop();
            h = null;
        }
        }
        while(i==0);

           }
}
