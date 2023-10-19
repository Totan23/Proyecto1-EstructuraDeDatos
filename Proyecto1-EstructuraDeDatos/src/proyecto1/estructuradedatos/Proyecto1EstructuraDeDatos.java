/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1.estructuradedatos;
import FileManagement.subirArchivo;

/**
 *
 * @author jonathanpizzurro
 */
public class Proyecto1EstructuraDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Establece el estilo de la interfaz según el sistema operativo */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(subirArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Crea y muestra el formulario */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new subirArchivo().setVisible(true);
            }
        });
    }
    
}
