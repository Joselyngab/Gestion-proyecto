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

import com.toedter.components.JLocaleChooser;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VCliente extends javax.swing.JFrame {

    
    public VCliente() {
        initComponents();
        this.setTitle("Gestión Cliente");
        this.jPanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelOpciones = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jPanelDatos = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelRazonSocial = new javax.swing.JLabel();
        jTextFieldRazonSocial = new javax.swing.JTextField();
        jLabelEstado_Provincia = new javax.swing.JLabel();
        jTextFieldEstado_Provincia = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelCorreo = new javax.swing.JLabel();
        jTextFieldCorreo = new javax.swing.JTextField();
        jLabelPais = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jComboBoxPaises = new javax.swing.JComboBox<>();
        jPanelEncabezado = new javax.swing.JPanel();
        jLabelEncabezado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelOpciones.setBackground(new java.awt.Color(35, 204, 204));
        jPanelOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Save_37110a.gif"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/remi_inconnu_Trash_1s.gif"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jButtonGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButtonEliminar)
                .addGap(62, 62, 62)
                .addComponent(jButtonCancelar)
                .addGap(59, 59, 59)
                .addComponent(jButtonRegresar)
                .addGap(99, 99, 99))
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonRegresar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelDatos.setToolTipText("");
        jPanelDatos.setName(""); // NOI18N

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCodigo.setText("Identificador");

        jTextFieldCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jLabelRazonSocial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRazonSocial.setText("Razón Social");

        jTextFieldRazonSocial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldRazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRazonSocialActionPerformed(evt);
            }
        });

        jLabelEstado_Provincia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEstado_Provincia.setText("Estado/Provincia");

        jTextFieldEstado_Provincia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldEstado_Provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEstado_ProvinciaActionPerformed(evt);
            }
        });

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTelefono.setText("Teléfono");

        jTextFieldTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefonoActionPerformed(evt);
            }
        });
        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });

        jLabelCorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCorreo.setText("Correo");

        jTextFieldCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreoActionPerformed(evt);
            }
        });

        jLabelPais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPais.setText("País");

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono lupa.png"))); // NOI18N
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jComboBoxPaises.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Afghanistán", "Albania", "Alemania", "Andorra", "Angola", "Anguilla", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbayán", "Bahamas", "Bahrein", "Bangladesh", "Barbados", "Belarús", "Bélgica", "Belice", "Benin", "Bhután", "Birmania", "Bolivia", "Bosnia-Herzegovina", "Botswana", "Brasil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Camboya", "Camerún", "Canadá", "Chad", "Chile", "China", "Chipre", "Colombia", "Comoras", "Congo", "Congo R. D.", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Djibouti", "Ecuador", "Egipto", "El Salvador", "Emiratos Arabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopia", "Fiji", "Filipinas", "Finlandia", "Francia", "Gabon", "Gambia", "Georgia", "Ghana", "Grecia", "Granada", "Guatemala", "Guinea", "Guinea-Bissau", "Guinea Ecuatorial", "Guyana", "Haiti", "Honduras", "Hungria", "Islandia", "India", "Indonesia", "Iran", "Iraq", "Irlanda", "Israel", "Italia", "Jamaica", "Japón", "Jordania", "Kazajstán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Letonia", "Libano", "Lesotho", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macedonia", "Madagascar", "Malawi", "Malasia", "Maldivas", "Mali", "Malta", "Marruecos", "Marshall", "Mauricio", "Mauritania", "México", "Micronesia", "Moldova", "Mónaco", "Mongolia", "Mozambique", "Namibia", "Naurú", "Nepal", "Nicaragua", "Niger", "Nigeria", "Noruega", "Nueva Zelandia", "Omán", "Países Bajos", "Pakistán", "Palau", "Panamá", "Papúa-Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal", "Qatar", "Reino Unido", "Rep. Centroafricana", "Rep. Checa", "Rep. Dominicana", "Ruanda", "Rumania", "Rusia", "Salomon Islands", "Samoa", "San Marino", "San Cristóbal-Nevis", "Santa Lucía", "Santa Sede (Vaticano)", "São Tomé y Principe", "St.Vincente las Grenadinas", "Senegal", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Sudáfrica", "Sudán", "Suecia", "Suiza", "Suriname", "Swazilandia", "Tailandia", "Taiwán", "Tanzania", "Tayikistán", "Togo", "Tonga", "Trinidad y Tabago", "Túnez", "Turkmenistan", "Turquia", "Tuvalu", "Ucraina", "Uganda", "Uruguay", "Uzbekistán", "Vanuatu", "Venezuela", "Vietnam", "Yémen", "Yugoslavia", "Zambia", "Zimbabwe" }));

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelCodigo))
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabelPais))
                            .addComponent(jComboBoxPaises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabelTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRazonSocial)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelEstado_Provincia))
                            .addComponent(jTextFieldEstado_Provincia)
                            .addComponent(jTextFieldRazonSocial)
                            .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabelCorreo)))
                .addGap(31, 31, 31))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(jLabelCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabelPais))
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jComboBoxPaises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTelefono)
                            .addComponent(jLabelCorreo))
                        .addGap(7, 7, 7)
                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRazonSocial)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabelEstado_Provincia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEstado_Provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanelEncabezado.setBackground(new java.awt.Color(0, 204, 204));
        jPanelEncabezado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelEncabezado.setPreferredSize(new java.awt.Dimension(673, 489));

        jLabelEncabezado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEncabezado.setText("Gestión de Clientes");

        javax.swing.GroupLayout jPanelEncabezadoLayout = new javax.swing.GroupLayout(jPanelEncabezado);
        jPanelEncabezado.setLayout(jPanelEncabezadoLayout);
        jPanelEncabezadoLayout.setHorizontalGroup(
            jPanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEncabezadoLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabelEncabezado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEncabezadoLayout.setVerticalGroup(
            jPanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEncabezadoLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabelEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
            .addComponent(jPanelOpciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(816, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jTextFieldRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRazonSocialActionPerformed

    private void jTextFieldEstado_ProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEstado_ProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEstado_ProvinciaActionPerformed

    private void jTextFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefonoActionPerformed

    private void jTextFieldCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCorreoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jTextFieldCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyTyped
        
    }//GEN-LAST:event_jTextFieldCodigoKeyTyped

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped
        char c=evt.getKeyChar(); 
             
         
          if(Character.isLetter(c)) 
          { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
           }
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped

       

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public JButton getjButtonRegresar() {
        return jButtonRegresar;
    }

    public JButton getjButtonEliminar() {
        return jButtonEliminar;
    }


    public JButton getjButtonGuardar() {
        return jButtonGuardar;
    }

    public JLabel getjLabelCodigo() {
        return jLabelCodigo;
    }

    public JLabel getjLabelCorreo() {
        return jLabelCorreo;
    }

    public JLabel getjLabelEstado_Provincia() {
        return jLabelEstado_Provincia;
    }

    public JLabel getjLabelRazonSocial() {
        return jLabelRazonSocial;
    }

    public JLabel getjLabelTelefono() {
        return jLabelTelefono;
    }

    public JPanel getjPanelDatos() {
        return jPanelDatos;
    }

    public JPanel getjPanelOpciones() {
        return jPanelOpciones;
    }

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }


    public JComboBox<String> getjComboBoxPaises() {
        return jComboBoxPaises;
    }

    public JLabel getjLabelPais() {
        return jLabelPais;
    }


    public JTextField getjTextFieldCodigo() {
        return jTextFieldCodigo;
    }

    public JTextField getjTextFieldCorreo() {
        return jTextFieldCorreo;
    }

    public JTextField getjTextFieldEstado_Provincia() {
        return jTextFieldEstado_Provincia;
    }

    public JTextField getjTextFieldRazonSocial() {
        return jTextFieldRazonSocial;
    }

    public JTextField getjTextFieldTelefono() {
        return jTextFieldTelefono;
    }

    public void agregarListener(ActionListener accion){
        this.jButtonGuardar.addActionListener(accion);
        this.jButtonEliminar.addActionListener(accion);
        this.jButtonRegresar.addActionListener(accion);
        this.jButtonCancelar.addActionListener(accion);
        this.jButtonBuscar.addActionListener(accion);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JComboBox<String> jComboBoxPaises;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelEncabezado;
    private javax.swing.JLabel jLabelEstado_Provincia;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelRazonSocial;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelEncabezado;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldEstado_Provincia;
    private javax.swing.JTextField jTextFieldRazonSocial;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
