/*
*    Proyecto de Laboratorio 1 (Sección 1)
*     Integrantes:
*     Canelon Valmore CI:
*     Cohen Kevin  CI:
*     Jiménez Jaimary CI: 22263583
*     Lugo Brisleidy CI:
*     Serrano Joselyn CI:
*/
package Vista;


import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;


public class VFeriado extends javax.swing.JFrame {

    /**
     * Creates new form VCalendario
     */
    public VFeriado() {
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

        jPanelcalendario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jDateChooserferiado = new com.toedter.calendar.JDateChooser();
        jButtonBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonmodificar = new javax.swing.JButton();
        jButtoneliminar = new javax.swing.JButton();
        jButtoncancelar = new javax.swing.JButton();
        jButtonsalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelcalendario.setBackground(new java.awt.Color(204, 204, 204));
        jPanelcalendario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Fecha:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Descripción: ");

        jTextFieldDescripcion.setBackground(java.awt.SystemColor.control);
        jTextFieldDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescripcionActionPerformed(evt);
            }
        });

        jDateChooserferiado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserferiadoKeyTyped(evt);
            }
        });

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono lupa.png"))); // NOI18N

        javax.swing.GroupLayout jPanelcalendarioLayout = new javax.swing.GroupLayout(jPanelcalendario);
        jPanelcalendario.setLayout(jPanelcalendarioLayout);
        jPanelcalendarioLayout.setHorizontalGroup(
            jPanelcalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelcalendarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelcalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanelcalendarioLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelcalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelcalendarioLayout.createSequentialGroup()
                        .addComponent(jDateChooserferiado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanelcalendarioLayout.setVerticalGroup(
            jPanelcalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelcalendarioLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanelcalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelcalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooserferiado, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanelcalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        jPanel1.setBackground(new java.awt.Color(35, 202, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Save_37110a.gif"))); // NOI18N
        jButtonmodificar.setText("Guardar");
        jButtonmodificar.setPreferredSize(new java.awt.Dimension(50, 50));

        jButtoneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/remi_inconnu_Trash_1s.gif"))); // NOI18N
        jButtoneliminar.setText("Eliminar");
        jButtoneliminar.setEnabled(false);
        jButtoneliminar.setPreferredSize(new java.awt.Dimension(50, 50));

        jButtoncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar-boton-cuadrado-rojo-aspwa.gif"))); // NOI18N
        jButtoncancelar.setText("Cancelar");
        jButtoncancelar.setAlignmentX(0.5F);
        jButtoncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtoncancelar.setPreferredSize(new java.awt.Dimension(50, 50));

        jButtonsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Apps-Home-icona.gif"))); // NOI18N
        jButtonsalir.setText("Regresar");
        jButtonsalir.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButtonmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButtoneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButtoncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jButtonsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButtoneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtoncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(35, 202, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fechas Feriadas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelcalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jPanelcalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(816, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooserferiadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserferiadoKeyTyped
        //this.enable(false);
    }//GEN-LAST:event_jDateChooserferiadoKeyTyped

    private void jTextFieldDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescripcionActionPerformed

   public JTextField getjTextFieldDescripcion() {
       
       return jTextFieldDescripcion;      
   }
 //-----------------------------
   public JDateChooser getJDateChooserFeriado(){
       
       return jDateChooserferiado;
   }
 //------------------------------        
   public JButton getjButtonCancelar()
    {
        return jButtoncancelar;
    }


//-----------------------------
    public JButton getjButtonSalir() 
    {
        return jButtonsalir;
    }
//-------------------------------
     public JButton getjButtonModificar() 
    {
        return jButtonmodificar;
    }
//--------------------

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }
     
//-------------------------------
    public JButton getjButtonEliminar() 
    {
        return jButtoneliminar;
    }
   public void agregarActionListener(ActionListener accion){
       
      
       this.jButtonmodificar.addActionListener(accion);
       this.jButtoncancelar.addActionListener(accion);
       this.jButtoneliminar.addActionListener(accion);
       this.jButtonsalir.addActionListener(accion);
       
       this.jButtonBuscar.addActionListener(accion);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtoncancelar;
    private javax.swing.JButton jButtoneliminar;
    private javax.swing.JButton jButtonmodificar;
    private javax.swing.JButton jButtonsalir;
    private com.toedter.calendar.JDateChooser jDateChooserferiado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelcalendario;
    private javax.swing.JTextField jTextFieldDescripcion;
    // End of variables declaration//GEN-END:variables
}
