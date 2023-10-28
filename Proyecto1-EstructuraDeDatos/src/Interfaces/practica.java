/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Grafos.Grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author guzzo
 */
public class practica extends javax.swing.JFrame {
    Grafo graph;
    
    /**
     * Creates new form practica
     */
    public practica() {
        initComponents();
        this.setVisible(true);
        graph = new Grafo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        añadir_rela = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        eliminar_rela = new javax.swing.JButton();
        usuario1 = new javax.swing.JTextField();
        usuario2 = new javax.swing.JTextField();
        añadir_usuario1 = new javax.swing.JButton();
        eliminar_usuario1 = new javax.swing.JButton();
        graficar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datos = new javax.swing.JTextArea();
        Buscar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        añadir_rela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        añadir_rela.setText("Añadir Relacion");
        añadir_rela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadir_relaActionPerformed(evt);
            }
        });
        jPanel1.add(añadir_rela, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, -1, -1));
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 170, -1));

        eliminar_rela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminar_rela.setText("Eliminar Relacion");
        eliminar_rela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_relaActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar_rela, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 120, -1));
        jPanel1.add(usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 250, -1));
        jPanel1.add(usuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 170, -1));

        añadir_usuario1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        añadir_usuario1.setText("Añadir Usuario");
        añadir_usuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadir_usuario1ActionPerformed(evt);
            }
        });
        jPanel1.add(añadir_usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        eliminar_usuario1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminar_usuario1.setText("Eliminar Usuario");
        eliminar_usuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_usuario1ActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar_usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 140, -1));

        graficar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        graficar.setText("Graficar grafo");
        graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficarActionPerformed(evt);
            }
        });
        jPanel1.add(graficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        datos.setColumns(20);
        datos.setRows(5);
        jScrollPane1.setViewportView(datos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 400, 470));

        Buscar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Buscar1.setText("Buscar Archivo");
        Buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(Buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficarActionPerformed
        // TODO add your handling code here:
        graph.graficar(graph);
        
    }//GEN-LAST:event_graficarActionPerformed

    private void añadir_usuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadir_usuario1ActionPerformed
        // TODO add your handling code here:
        if (!usuario.getText().contains("@")){
            usuario.setText("@"+usuario.getText());
        }
        graph.agregarVertice(usuario.getText());
        datos.setText(graph.imprimir());
    }//GEN-LAST:event_añadir_usuario1ActionPerformed

    private void eliminar_usuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_usuario1ActionPerformed
        // TODO add your handling code here:
        if (!usuario.getText().contains("@")){
            usuario.setText("@"+usuario.getText());
        }
        graph.eliminarVertice(usuario.getText());
        datos.setText(graph.imprimir());

    }//GEN-LAST:event_eliminar_usuario1ActionPerformed

    private void añadir_relaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadir_relaActionPerformed
        // TODO add your handling code here:
        if (!usuario2.getText().contains("@")){
            usuario2.setText("@"+usuario2.getText());
        }if (!usuario1.getText().contains("@")){
            usuario1.setText("@"+usuario1.getText());
        }
        graph.agregaRelacion(usuario2.getText(), usuario1.getText());
        datos.setText(graph.imprimir());

    }//GEN-LAST:event_añadir_relaActionPerformed

    private void eliminar_relaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_relaActionPerformed
        // TODO add your handling code here:
        if (!usuario2.getText().contains("@")){
            usuario2.setText("@"+usuario2.getText());
        }if (!usuario1.getText().contains("@")){
            usuario1.setText("@"+usuario1.getText());
        }
        graph.eliminarRelacion(usuario2.getText(), usuario1.getText());
        datos.setText(graph.imprimir());

    }//GEN-LAST:event_eliminar_relaActionPerformed

    private void Buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int selection = fileChooser.showOpenDialog(this);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            Grafo grafo = new Grafo();
            boolean comprobacion = false;

            try ( BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    if (linea.equals("usuarios")) {
                        comprobacion = true;
                        continue;
                    }
                    if (linea.equals("relaciones")) {
                        comprobacion = false;
                        continue;
                    }
                    if (comprobacion) {
                        String usuario = linea.split(",")[0].trim(); 
                        grafo.agregarVertice(usuario); 
                    } else {
                        String[] relacion = linea.split(",");
                        if (relacion.length >= 2) {
                            String usuario1 = relacion[0].trim();
                            String usuario2 = relacion[1].trim();
                            grafo.agregaRelacion(usuario1, usuario2);
                        }
                    }
                }
                graph = grafo;
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }}
    }//GEN-LAST:event_Buscar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new practica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar1;
    private javax.swing.JButton añadir_rela;
    private javax.swing.JButton añadir_usuario1;
    private javax.swing.JTextArea datos;
    private javax.swing.JButton eliminar_rela;
    private javax.swing.JButton eliminar_usuario1;
    private javax.swing.JButton graficar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField usuario;
    private javax.swing.JTextField usuario1;
    private javax.swing.JTextField usuario2;
    // End of variables declaration//GEN-END:variables
}
