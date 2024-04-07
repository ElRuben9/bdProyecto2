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
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
       
        
         // Agregar ActionListener al botón TramiteLicencia
       TramiteLicencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear instancia de la clase TramiteLicencia
                TramiteLicencia tramite = new TramiteLicencia();
                // Hacer visible la instancia creada
                tramite.setVisible(true);
                // Cerrar la ventana actual (Inicio)
                dispose();
            }
        });
        // Agregar ActionListener al botón TramitePlacas
        TramitePlacas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear instancia de la clase TramitePlacas
                TramitePlacas tramite = new TramitePlacas();
                // Hacer visible la instancia creada
                tramite.setVisible(true);
                // Cerrar la ventana actual (Inicio)
                dispose();
            }
        });
        // Agregar ActionListener al botón Consultas
        Consultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear instancia de la clase Consultas
                Consultas consultas = new Consultas();
                // Hacer visible la instancia creada
                consultas.setVisible(true);
                // Cerrar la ventana actual (Inicio)
                dispose();
            }
        });
        // Agregar ActionListener al botón Reportes
        Reportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear instancia de la clase Reportes
                Reportes reportes = new Reportes();
                // Hacer visible la instancia creada
                reportes.setVisible(true);
                // Cerrar la ventana actual (Inicio)
                dispose();
            }
        });
        // Agregar ActionListener al botón InsertarPersonas
        InsertarPersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear instancia de la clase InsertarPersonas
                InsertarPersonas insertar = new InsertarPersonas();
                // Hacer visible la instancia creada
                insertar.setVisible(true);
                // Cerrar la ventana actual (Inicio)
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TramitePlacas = new javax.swing.JToggleButton();
        TramiteLicencia = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        Consultas = new javax.swing.JToggleButton();
        Reportes = new javax.swing.JToggleButton();
        InsertarPersonas = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(101, 118, 136));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inicio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        TramitePlacas.setBackground(new java.awt.Color(160, 11, 43));
        TramitePlacas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TramitePlacas.setForeground(new java.awt.Color(255, 255, 255));
        TramitePlacas.setText(" Tramite de placas");
        TramitePlacas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TramitePlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TramitePlacasActionPerformed(evt);
            }
        });
        jPanel1.add(TramitePlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 190, 50));

        TramiteLicencia.setBackground(new java.awt.Color(160, 11, 43));
        TramiteLicencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TramiteLicencia.setForeground(new java.awt.Color(255, 255, 255));
        TramiteLicencia.setText("Tramite de licencia");
        TramiteLicencia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(TramiteLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 190, 50));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(218, 184, 87));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(218, 184, 86));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 60));

        Consultas.setBackground(new java.awt.Color(160, 11, 43));
        Consultas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Consultas.setForeground(new java.awt.Color(255, 255, 255));
        Consultas.setText("Consultas");
        Consultas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Consultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultasActionPerformed(evt);
            }
        });
        jPanel1.add(Consultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 190, 50));

        Reportes.setBackground(new java.awt.Color(160, 11, 43));
        Reportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Reportes.setForeground(new java.awt.Color(255, 255, 255));
        Reportes.setText("Reportes");
        Reportes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 190, 50));

        InsertarPersonas.setBackground(new java.awt.Color(160, 11, 43));
        InsertarPersonas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InsertarPersonas.setForeground(new java.awt.Color(255, 255, 255));
        InsertarPersonas.setText("Insertar personas");
        InsertarPersonas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(InsertarPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 190, 50));

        jToggleButton1.setText("jToggleButton1");
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 190, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void TramitePlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TramitePlacasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TramitePlacasActionPerformed

    private void ConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultasActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Consultas;
    private javax.swing.JToggleButton InsertarPersonas;
    private javax.swing.JToggleButton Reportes;
    private javax.swing.JToggleButton TramiteLicencia;
    private javax.swing.JToggleButton TramitePlacas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
