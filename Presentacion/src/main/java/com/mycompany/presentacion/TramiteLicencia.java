/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.presentacion;

import DAOS.ILicenciaDAO;
import DAOS.IPersonaDAO;
import DAOS.PersonaDAO;
import DAOS.LicenciaDAO;
import dto.NuevoLicenciaDTO;
import entidadesJPA.Licencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import negocio.RegistroLicenciaBO;

public class TramiteLicencia extends javax.swing.JFrame {

    private String nombre;
    private String APaterno;
    private String AMaterno;
    private String rfc;
    private String nacimiento;
    private String telefono;
    private String tiempoVigencia;
    private boolean tieneDiscapacidad;
    private RegistroLicenciaBO registroLicenciaBO;

    /**
     *
     * @author diana (Modificaciones: Antonio)
     * 
     */
    public TramiteLicencia() {
        initComponents();
        ILicenciaDAO licenciaDAO = new LicenciaDAO(); // Reemplaza LicenciaDAO con la implementación real
        IPersonaDAO personaDAO = new PersonaDAO(); // Reemplaza PersonaDAO con la implementación real
        
        registroLicenciaBO = new RegistroLicenciaBO(licenciaDAO, personaDAO);

      

        // ActionListener para el BotonNombre
        TextFieldNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre = TextFieldNombre.getText();
            }
        });

        // ActionListener para el BotonRFC
        TextFieldRFC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rfc = TextFieldRFC.getText();
            }
        });

        // ActionListener para el BotonNacimiento
        JDCNacimiento.getDateEditor().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Date selectedDate = JDCNacimiento.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    nacimiento = sdf.format(selectedDate);
                }
            }
        });

        // ActionListener para el BotonTelefono
        TextFieldTelefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telefono = TextFieldTelefono.getText();
            }
        });

        // ActionListener para el ComboBox TiempoVigencia
        TiempoVigencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoVigencia = (String) TiempoVigencia.getSelectedItem();
                actualizarCosto(); // Llamar al método actualizarCosto() cuando cambia la selección
            }
        });

        // ActionListener para el ComboBox Discapacidad
        Discapacidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) Discapacidad.getSelectedItem();
                tieneDiscapacidad = seleccion.equals("SI");
                actualizarCosto(); // Llamar al método actualizarCosto() cuando cambia la selección
            }
        });

        // ActionListener para el botón Regresar
        Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana actual (TramiteLicencia)
                new Inicio().setVisible(true); // Crear una nueva instancia de la clase Inicio y hacerla visible
            }
        });

        // ActionListener para el botón Realizar Trámite
        RealizarTramite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar la longitud del número de teléfono
                String telefono = TextFieldTelefono.getText().trim();
                if (telefono.length() != 10) {
                    JOptionPane.showMessageDialog(null, "El número de teléfono debe tener 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                    TextFieldTelefono.setText(""); // Limpiar el campo de texto
                    TextFieldTelefono.requestFocus(); // Poner el foco en el campo de texto para que el usuario pueda corregirlo
                    return; // Salir del método si la validación del teléfono falla
                }

                // Si la validación del teléfono pasa, continuar con el proceso
                int costoFinal = Integer.parseInt(TextFieldCosto.getText());

                // Mostrar el mensaje con el costo antes de confirmar el trámite
                JOptionPane.showMessageDialog(null, "El costo del trámite es: $" + costoFinal + "\nTrámite realizado con éxito");

                // Cerrar la ventana actual (TramiteLicencia)
                dispose();

                // Crear una nueva instancia de la clase Inicio y hacerla visible
                new Inicio().setVisible(true);
            }
        });
    }

    private void actualizarCosto() {
        int costoNormal = 0;
        int costoDiscapacitados = 0;

        switch (tiempoVigencia) {
            case "1 AÑO":
                costoNormal = 600;
                costoDiscapacitados = 200;
                break;
            case "2 AÑOS":
                costoNormal = 900;
                costoDiscapacitados = 500;
                break;
            case "3 AÑOS":
                costoNormal = 1100;
                costoDiscapacitados = 700;
                break;
        }

        // Aplicar descuento en caso de discapacidad
        if (tieneDiscapacidad) {
            TextFieldCosto.setText(String.valueOf(costoDiscapacitados));
        } else {
            TextFieldCosto.setText(String.valueOf(costoNormal));
        }
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
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TiempoVigencia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Discapacidad = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        TextFieldCosto = new javax.swing.JTextField();
        Regresar = new javax.swing.JToggleButton();
        RealizarTramite = new javax.swing.JButton();
        TextFieldRFC = new javax.swing.JTextField();
        TextFieldNombre = new javax.swing.JTextField();
        TextFieldAMaterno = new javax.swing.JTextField();
        TextFieldTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TextFieldAPaterno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JDCNacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(101, 118, 136));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(218, 184, 87));
        jLabel8.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Trámite de licencia");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jTextField2.setBackground(new java.awt.Color(218, 184, 87));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 55));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("RFC:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 37, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Apellido Materno:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Telefono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tiempo de vigencia:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 140, 20));

        TiempoVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 AÑO", "2 AÑOS", "3 AÑOS" }));
        TiempoVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiempoVigenciaActionPerformed(evt);
            }
        });
        jPanel1.add(TiempoVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 80, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Discapacidad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        Discapacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        Discapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscapacidadActionPerformed(evt);
            }
        });
        jPanel1.add(Discapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Costo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, -1));

        TextFieldCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCostoActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 60, -1));

        Regresar.setBackground(new java.awt.Color(160, 11, 43));
        Regresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setText("Regresar ");
        Regresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        jPanel1.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 130, 30));

        RealizarTramite.setBackground(new java.awt.Color(160, 11, 43));
        RealizarTramite.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RealizarTramite.setForeground(new java.awt.Color(255, 255, 255));
        RealizarTramite.setText("Realizar trámite");
        RealizarTramite.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RealizarTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealizarTramiteActionPerformed(evt);
            }
        });
        jPanel1.add(RealizarTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 180, 30));

        TextFieldRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldRFCActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 260, 30));

        TextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldNombreActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 260, 30));

        TextFieldAMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldAMaternoActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 260, 30));

        TextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 260, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Apellido Paterno:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        TextFieldAPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldAPaternoActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 260, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));
        jPanel1.add(JDCNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 260, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void TextFieldRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldRFCActionPerformed

    private void TextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldNombreActionPerformed

    private void TextFieldAPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldAPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldAPaternoActionPerformed

    private void TextFieldAMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldAMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldAMaternoActionPerformed

    private void TextFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldTelefonoActionPerformed

    private void TiempoVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiempoVigenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TiempoVigenciaActionPerformed

    private void DiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiscapacidadActionPerformed

    private void TextFieldCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldCostoActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegresarActionPerformed

    private void RealizarTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarTramiteActionPerformed
        // Verificar si algún campo está vacío
        if (TextFieldRFC.getText().isEmpty() || TextFieldNombre.getText().isEmpty() || TextFieldAPaterno.getText().isEmpty() || TextFieldAMaterno.getText().isEmpty() || TextFieldTelefono.getText().isEmpty() || JDCNacimiento.getDate() == null || TiempoVigencia.getSelectedItem() == null || Discapacidad.getSelectedItem() == null) {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(null, "No se han llenado todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Validar la longitud del número de teléfono
            String telefono = TextFieldTelefono.getText().trim();
            if (telefono.length() != 10) {
                JOptionPane.showMessageDialog(null, "El número de teléfono debe tener 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                TextFieldTelefono.setText(""); // Limpiar el campo de texto
                TextFieldTelefono.requestFocus(); // Poner el foco en el campo de texto para que el usuario pueda corregirlo
                return; // Salir del método si la validación del teléfono falla
            }

            // Crear una instancia de NuevoLicenciaDTO con los datos necesarios
            NuevoLicenciaDTO nuevoLicenciaDTO = new NuevoLicenciaDTO();
            nuevoLicenciaDTO.setNumeroLicencia(TextFieldRFC.getText()); // Aquí deberías establecer el número de licencia adecuado

            // Convertir la duración de la vigencia seleccionada en años
            String duracionVigenciaTexto = (String) TiempoVigencia.getSelectedItem();
            int duracionVigencia = Integer.parseInt(duracionVigenciaTexto.split(" ")[0]);

            // Calcular la fecha de expedición
            Date fechaExpedicion = JDCNacimiento.getDate();

            // Calcular la fecha de vencimiento sumando la duración de la vigencia a la fecha de expedición
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaExpedicion);
            calendar.add(Calendar.YEAR, duracionVigencia);

            // Establecer la fecha de expedición y la fecha de vencimiento en el objeto nuevoLicenciaDTO
            nuevoLicenciaDTO.setFechaExpedicion(fechaExpedicion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            nuevoLicenciaDTO.setVigencia(new java.sql.Date(calendar.getTimeInMillis()).toLocalDate());

            // Llamar al método registrarLicencia pasando el nuevoLicenciaDTO
            Licencia licencia = registroLicenciaBO.registrarLicencia(nuevoLicenciaDTO);

            // Mostrar el mensaje con el costo antes de confirmar el trámite
            JOptionPane.showMessageDialog(null, "El costo del trámite es: $" + licencia.getCosto() + "\nTrámite realizado con éxito");

            // Cerrar la ventana actual (TramiteLicencia)
            dispose();

            new Inicio().setVisible(true);
        }
    }//GEN-LAST:event_RealizarTramiteActionPerformed

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
            java.util.logging.Logger.getLogger(TramiteLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TramiteLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TramiteLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TramiteLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TramiteLicencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Discapacidad;
    private com.toedter.calendar.JDateChooser JDCNacimiento;
    private javax.swing.JButton RealizarTramite;
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JTextField TextFieldAMaterno;
    private javax.swing.JTextField TextFieldAPaterno;
    private javax.swing.JTextField TextFieldCosto;
    private javax.swing.JTextField TextFieldNombre;
    private javax.swing.JTextField TextFieldRFC;
    private javax.swing.JTextField TextFieldTelefono;
    private javax.swing.JComboBox<String> TiempoVigencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
