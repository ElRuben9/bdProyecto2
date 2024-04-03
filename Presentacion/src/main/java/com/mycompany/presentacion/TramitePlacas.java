/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author diana
 */
public class TramitePlacas extends javax.swing.JFrame {

    /**
     * Creates new form TramitePlacas
     */
    public TramitePlacas() {
        initComponents();
        // Agregar ActionListener al botón Automovil Nuevo
        AutomovilNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear instancia del JFrame TramitePlacasNuevo
                TramitePlacasNuevo tramitePlacasNuevo = new TramitePlacasNuevo();
                // Hacer visible la instancia creada
                tramitePlacasNuevo.setVisible(true);
                // Cerrar la ventana actual (TramitePlacas)
                dispose();
            }
        });
        // Agregar ActionListener al botón Automovil Usado
        AutomovilUsado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear instancia del JFrame TramitePlacasUsado
                TramitePlacasUsado tramitePlacasUsado = new TramitePlacasUsado();
                // Hacer visible la instancia creada
                tramitePlacasUsado.setVisible(true);
                // Cerrar la ventana actual (TramitePlacas)
                dispose();
            }
        });
        // Agregar ActionListener al botón Regresar
        Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Regresar a la ventana anterior (Inicio)
                Inicio inicio = new Inicio();
                // Hacer visible la ventana Inicio
                inicio.setVisible(true);
                // Cerrar la ventana actual (TramitePlacas)
                dispose();
            }
        });
        
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        AutomovilNuevo = new javax.swing.JButton();
        AutomovilUsado = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(101, 118, 136));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tramite de placas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 350, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 200, 10));

        jTextField1.setBackground(new java.awt.Color(218, 184, 87));
        jTextField1.setMargin(new java.awt.Insets(101, 118, 136, 136));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 60));

        AutomovilNuevo.setBackground(new java.awt.Color(160, 11, 43));
        AutomovilNuevo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AutomovilNuevo.setForeground(new java.awt.Color(255, 255, 255));
        AutomovilNuevo.setText("Automovil Nuevo");
        jPanel1.add(AutomovilNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 200, 40));

        AutomovilUsado.setBackground(new java.awt.Color(160, 11, 43));
        AutomovilUsado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AutomovilUsado.setForeground(new java.awt.Color(255, 255, 255));
        AutomovilUsado.setText("Automovil Usado");
        jPanel1.add(AutomovilUsado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 200, 40));

        Regresar.setBackground(new java.awt.Color(160, 11, 43));
        Regresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setText("Regresar");
        jPanel1.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(TramitePlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TramitePlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TramitePlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TramitePlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TramitePlacas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AutomovilNuevo;
    private javax.swing.JButton AutomovilUsado;
    private javax.swing.JButton Regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}