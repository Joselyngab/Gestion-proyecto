/*
*    Proyecto de Laboratorio 1 (Sección 1)
*     Integrantes:
*     Canelon Valmore CI: 22270191
*     Cohen Kevin  CI: 20670359
*     Jiménez Jaimary CI: 22263583
*     Lugo Brisleidy CI: 22181168
*     Serrano Joselyn CI: 22271356
*/
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class VFalta extends javax.swing.JFrame {

    /**
     * Creates new form VFaltas
     */
    public VFalta() {
        initComponents();
        this.setTitle("Registro de faltas");
        this.jPanelFalta.setBorder(javax.swing.BorderFactory.createTitledBorder("Falta del empleado"));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanelFalta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jLabelMotivo = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabelTipo = new javax.swing.JLabel();
        jLabelCantHoras = new javax.swing.JLabel();
        jTextFieldCantHoras = new javax.swing.JTextField();
        jLabelFechaFalta = new javax.swing.JLabel();
        jDateChooserFechaFalta = new com.toedter.calendar.JDateChooser();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneMotivo = new javax.swing.JTextPane();
        jPanelOpciones = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jPanelEncabezado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelFalta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCodigo.setText("Identificador");

        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });
        jTextFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoKeyTyped(evt);
            }
        });

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNombre.setText("Nombre");

        jLabelMotivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMotivo.setText("Motivo");

        jComboBoxTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Justificada", "No justificada" }));

        jLabelTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTipo.setText("Tipo");

        jLabelCantHoras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCantHoras.setText("Cantidad de horas");

        jTextFieldCantHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCantHorasKeyTyped(evt);
            }
        });

        jLabelFechaFalta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFechaFalta.setText("Fecha");

        jDateChooserFechaFalta.setMaxSelectableDate(new java.util.Date(253370782903000L));

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono lupa.png"))); // NOI18N
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPaneMotivo);

        javax.swing.GroupLayout jPanelFaltaLayout = new javax.swing.GroupLayout(jPanelFalta);
        jPanelFalta.setLayout(jPanelFaltaLayout);
        jPanelFaltaLayout.setHorizontalGroup(
            jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFaltaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFaltaLayout.createSequentialGroup()
                        .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFaltaLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabelCodigo))
                            .addGroup(jPanelFaltaLayout.createSequentialGroup()
                                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFaltaLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabelNombre)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelFaltaLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jTextFieldNombre)
                                .addContainerGap())))
                    .addGroup(jPanelFaltaLayout.createSequentialGroup()
                        .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFaltaLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabelFechaFalta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserFechaFalta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanelFaltaLayout.createSequentialGroup()
                                        .addComponent(jLabelTipo)
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelFaltaLayout.createSequentialGroup()
                                                .addComponent(jLabelCantHoras)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldCantHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanelFaltaLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabelMotivo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 54, Short.MAX_VALUE))))
        );
        jPanelFaltaLayout.setVerticalGroup(
            jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFaltaLayout.createSequentialGroup()
                .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFaltaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelFaltaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addGap(31, 31, 31)
                .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTipo)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelFechaFalta)
                        .addComponent(jDateChooserFechaFalta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabelMotivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFaltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCantHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCantHoras))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelOpciones.setBackground(new java.awt.Color(35, 202, 204));
        jPanelOpciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar-boton-cuadrado-rojo-aspwa.gif"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Apps-Home-icona.gif"))); // NOI18N
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Save_37110a.gif"))); // NOI18N
        jButtonRegistrar.setText("Guardar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jButtonRegistrar)
                .addGap(69, 69, 69)
                .addComponent(jButtonCancelar)
                .addGap(65, 65, 65)
                .addComponent(jButtonRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOpcionesLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonRegistrar)
                    .addComponent(jButtonRegresar))
                .addContainerGap())
        );

        jPanelEncabezado.setBackground(new java.awt.Color(35, 202, 204));
        jPanelEncabezado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelEncabezado.setPreferredSize(new java.awt.Dimension(673, 489));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro de Faltas");

        javax.swing.GroupLayout jPanelEncabezadoLayout = new javax.swing.GroupLayout(jPanelEncabezado);
        jPanelEncabezado.setLayout(jPanelEncabezadoLayout);
        jPanelEncabezadoLayout.setHorizontalGroup(
            jPanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEncabezadoLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEncabezadoLayout.setVerticalGroup(
            jPanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEncabezadoLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEncabezado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jPanelOpciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jPanelFalta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jPanelFalta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(816, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldCantHorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantHorasKeyTyped
        char c=evt.getKeyChar(); 
             
         
          if(Character.isLetter(c)) 
          { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
           }
    }//GEN-LAST:event_jTextFieldCantHorasKeyTyped

    private void jTextFieldCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyTyped
        
    }//GEN-LAST:event_jTextFieldCodigoKeyTyped

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public JTextPane getjTextPaneMotivo() {
        return jTextPaneMotivo;
    }

    

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public JButton getjButtonRegistrar() {
        return jButtonRegistrar;
    }

    public JButton getjButtonRegresar() {
        return jButtonRegresar;
    }

    public JComboBox<String> getjComboBoxTipo() {
        return jComboBoxTipo;
    }

    public JDateChooser getjDateChooserFechaFalta() {
        return jDateChooserFechaFalta;
    }

    public JLabel getjLabelCantHoras() {
        return jLabelCantHoras;
    }

    public JLabel getjLabelCodigo() {
        return jLabelCodigo;
    }

    public JLabel getjLabelFechaFalta() {
        return jLabelFechaFalta;
    }

    public JLabel getjLabelMotivo() {
        return jLabelMotivo;
    }

    public JLabel getjLabelNombre() {
        return jLabelNombre;
    }

    public JLabel getjLabelTipo() {
        return jLabelTipo;
    }

    public JPanel getjPanelFalta() {
        return jPanelFalta;
    }

    public JPanel getjPanelOpciones() {
        return jPanelOpciones;
    }

    public JTextField getjTextFieldCantHoras() {
        return jTextFieldCantHoras;
    }

    public JTextField getjTextFieldCodigo() {
        return jTextFieldCodigo;
    }

    
    public JTextField getjTextFieldNombre() {
        return jTextFieldNombre;
    }

    
    
    public void agregarListener(ActionListener accion)
    {
        this.jButtonRegistrar.addActionListener(accion);
        this.jButtonCancelar.addActionListener(accion);
        this.jButtonRegresar.addActionListener(accion);
        this.jButtonBuscar.addActionListener(accion);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooserFechaFalta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCantHoras;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelFechaFalta;
    private javax.swing.JLabel jLabelMotivo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JPanel jPanelEncabezado;
    private javax.swing.JPanel jPanelFalta;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldCantHoras;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextPane jTextPaneMotivo;
    // End of variables declaration//GEN-END:variables
}
