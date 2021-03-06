/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author franc_000
 */
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JLocaleChooser;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;

public class VNomina extends javax.swing.JFrame {

    /**
     * Creates new form VNomina
     */
    public VNomina() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jButton1Calcular = new javax.swing.JButton();
        jButton2Registrar = new javax.swing.JButton();
        jButton3Cancelar = new javax.swing.JButton();
        jButton5Regresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1Identificacion = new javax.swing.JLabel();
        jLabel2Fecha = new javax.swing.JLabel();
        jLabel3Horames = new javax.swing.JLabel();
        jLabel4Horast = new javax.swing.JLabel();
        jTextField3Horast = new javax.swing.JTextField();
        jLabel5Salario = new javax.swing.JLabel();
        jMonthChoosermes = new com.toedter.calendar.JMonthChooser();
        jTextFieldIdentificacion = new javax.swing.JTextField();
        jButton1Buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4nombre = new javax.swing.JLabel();
        jLabel4HorasMes = new javax.swing.JLabel();
        jLabel4Salario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6MontoPagar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4montopagado = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(35, 202, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1Calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calcular.png"))); // NOI18N
        jButton1Calcular.setText("Calcular");

        jButton2Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagar.png"))); // NOI18N
        jButton2Registrar.setText("Pagar");
        jButton2Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2RegistrarActionPerformed(evt);
            }
        });

        jButton3Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar-boton-cuadrado-rojo-aspwa.gif"))); // NOI18N
        jButton3Cancelar.setText("Cancelar");
        jButton3Cancelar.setEnabled(false);

        jButton5Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Apps-Home-icona.gif"))); // NOI18N
        jButton5Regresar.setText("Regresar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jButton1Calcular)
                .addGap(64, 64, 64)
                .addComponent(jButton2Registrar)
                .addGap(71, 71, 71)
                .addComponent(jButton3Cancelar)
                .addGap(64, 64, 64)
                .addComponent(jButton5Regresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2Registrar)
                    .addComponent(jButton1Calcular)
                    .addComponent(jButton3Cancelar)
                    .addComponent(jButton5Regresar))
                .addGap(25, 25, 25))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1Identificacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1Identificacion.setText("Empleado");

        jLabel2Fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2Fecha.setText("Mes de Pago");

        jLabel3Horames.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3Horames.setText("Horas Mes");

        jLabel4Horast.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4Horast.setText("Horas Trabajadas");

        jTextField3Horast.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField3Horast.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3HorastKeyTyped(evt);
            }
        });

        jLabel5Salario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5Salario.setText("Salario");

        jMonthChoosermes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMonthChoosermesMouseClicked(evt);
            }
        });
        jMonthChoosermes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMonthChoosermesKeyPressed(evt);
            }
        });

        jTextFieldIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdentificacionActionPerformed(evt);
            }
        });
        jTextFieldIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIdentificacionKeyTyped(evt);
            }
        });

        jButton1Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono lupa.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel4nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4HorasMes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4Salario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1Identificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jTextFieldIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5Salario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4Salario, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4Horast)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3Horast, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2Fecha)
                                .addComponent(jLabel3Horames))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4HorasMes, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jMonthChoosermes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1Identificacion)
                    .addComponent(jTextFieldIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel4nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMonthChoosermes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2Fecha))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3Horames, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel4HorasMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4Horast)
                    .addComponent(jTextField3Horast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5Salario, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel4Salario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6MontoPagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6MontoPagar.setText("Monto a Pagar");

        jLabel4montopagado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4montopagado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4montopagado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6MontoPagar)
                        .addGap(59, 59, 59))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6MontoPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4montopagado, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(35, 202, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nómina");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2RegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2RegistrarActionPerformed

    private void jTextFieldIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdentificacionActionPerformed

    private void jMonthChoosermesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMonthChoosermesKeyPressed
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_jMonthChoosermesKeyPressed

    private void jMonthChoosermesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMonthChoosermesMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_jMonthChoosermesMouseClicked

    private void jTextField3HorastKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3HorastKeyTyped
        char c=evt.getKeyChar(); 
             
         
          if(Character.isLetter(c)) 
          { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
           }
    }//GEN-LAST:event_jTextField3HorastKeyTyped

    private void jTextFieldIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdentificacionKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar(); 
             
         
          if(Character.isLetter(c)) 
          { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
           }
    }//GEN-LAST:event_jTextFieldIdentificacionKeyTyped

    public JButton getjButton1Buscar() {
        return jButton1Buscar;
    }

    public JButton getjButton5Regresar() {
        return jButton5Regresar;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    

    public JMonthChooser getjMonthChoosermes() {
        return jMonthChoosermes;
    }

    
    public JButton getjButton1Calcular() {
        return jButton1Calcular;
    }

    public JButton getjButton3Cancelar() {
        return jButton3Cancelar;
    }

    public JLabel getjLabel1Identificacion() {
        return jLabel1Identificacion;
    }

   

    public JLabel getjLabel2Fecha() {
        return jLabel2Fecha;
    }

    public JLabel getjLabel3Horames() {
        return jLabel3Horames;
    }

    public JLabel getjLabel4Horast() {
        return jLabel4Horast;
    }

    public JLabel getjLabel5Salario() {
        return jLabel5Salario;
    }

    public JLabel getjLabel6MontoPagar() {
        return jLabel6MontoPagar;
    }

    

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JLabel getjLabel4HorasMes() {
        return jLabel4HorasMes;
    }

    public JLabel getjLabel4Salario() {
        return jLabel4Salario;
    }

    public JLabel getjLabel4montopagado() {
        return jLabel4montopagado;
    }

    public JLabel getjLabel4nombre() {
        return jLabel4nombre;
    }


          

    public JTextField getjTextField3Horast() {
        return jTextField3Horast;
    }

    

    public JTree getjTree1() {
        return jTree1;
    }

    public JButton getjButton2Registrar() {
        return jButton2Registrar;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public JTextField getjTextFieldIdentificacion() {
        return jTextFieldIdentificacion;
    }

   


    public void agregarListener(ActionListener accion)   
{
    this.jButton1Calcular.addActionListener(accion);
    this.jButton2Registrar.addActionListener(accion);
    this.jButton3Cancelar.addActionListener(accion);
    this.jButton5Regresar.addActionListener(accion);    
    this.jButton1Buscar.addActionListener(accion);
    
}  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Buscar;
    private javax.swing.JButton jButton1Calcular;
    private javax.swing.JButton jButton2Registrar;
    private javax.swing.JButton jButton3Cancelar;
    private javax.swing.JButton jButton5Regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1Identificacion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2Fecha;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3Horames;
    private javax.swing.JLabel jLabel4HorasMes;
    private javax.swing.JLabel jLabel4Horast;
    private javax.swing.JLabel jLabel4Salario;
    private javax.swing.JLabel jLabel4montopagado;
    private javax.swing.JLabel jLabel4nombre;
    private javax.swing.JLabel jLabel5Salario;
    private javax.swing.JLabel jLabel6MontoPagar;
    private com.toedter.calendar.JMonthChooser jMonthChoosermes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3Horast;
    private javax.swing.JTextField jTextFieldIdentificacion;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    
}
