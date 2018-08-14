/*
*    Proyecto de Laboratorio 1 (Sección 1)
*     Integrantes:
*     Canelon Valmore CI: 22270191
*     Cohen Kevin  CI: 20670359
*     Jiménez Jaimary CI: 22263583
*     Lugo Brisleidy CI: 22181168
*     Serrano Joselyn CI: 22271356
*/
package Controlador;

import Dao.DaoFeriado;
import Vista.VFeriado;
import Modelo.MFeriado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CFeriado implements ActionListener,KeyListener
{
    private VFeriado formFeriado;
    private char operacion; 
    
    public CFeriado(){
        
        formFeriado = new VFeriado();
        formFeriado.agregarActionListener(this);
        formFeriado.setVisible(true);
        formFeriado.getJDateChooserFeriado().setRequestFocusEnabled(true);
        
        habilitarCampos(false);
        
        
        
        formFeriado.getJDateChooserFeriado().getDateEditor().getUiComponent()
                .addKeyListener(new java.awt.event.KeyListener() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent e)
          {               
            DateChooserFeriadoKeyTyped(e);
       
          }
           //---------------------------

            @Override
            public void keyPressed(KeyEvent ke) {
               // throw new UnsupportedOperationException("Not supported yet."); 
               //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               // throw new UnsupportedOperationException("Not supported yet.");
                //To change body of generated methods, choose Tools | Templates.
            }
       
           
        });        
    }
   
    
  //--------------------------
private void DateChooserFeriadoKeyTyped(KeyEvent e)
{
  char tecla;
  tecla=e.getKeyChar();
  
  if (tecla=='/')
  {
   return; 
  }
  
  if (tecla<'0' || tecla>'9')
  {
   e.consume();
  }
}

       
  //------------------------- 
    private void modificar(){
        formFeriado.getjTextFieldDescripcion().setRequestFocusEnabled(true);
       
      if(formFeriado.getJDateChooserFeriado().getDate()==null){
       JOptionPane.showMessageDialog(null, "Seleccione una fecha");
          formFeriado.getJDateChooserFeriado().requestFocus();
          return;  
      }
     
      else if(formFeriado.getjTextFieldDescripcion().getText().trim().length()==0){
               JOptionPane.showMessageDialog(null, "Ingrese una descripción");
                formFeriado.getjTextFieldDescripcion().requestFocusInWindow();
                return;
        }
      else {
           DaoFeriado daoferiado=new DaoFeriado();
           MFeriado mf;
            mf= new MFeriado(formFeriado.getJDateChooserFeriado().getDate(),
                       formFeriado.getjTextFieldDescripcion().getText().trim());
        
            
           switch (operacion)
           {
               case 'I':
                        formFeriado.getjButtonEliminar().setEnabled(false);
                        daoferiado.insertFeriado(mf);
                        JOptionPane.showMessageDialog(null, "Registro Realizado"
                                                       + "Satisfactoriamente");
                        break;
               case 'M':
                       formFeriado.getjButtonEliminar().setEnabled(false);
                       daoferiado.modificarFeriado(mf);
                       JOptionPane.showMessageDialog(null,"Actualización Exitosa");
            
           }
           
        limpiarCampos();
          
      }
    }
  //-------------------------
    private void eliminar(){
  
             Date fecha;
             DaoFeriado daoferiado= new DaoFeriado();
             fecha=formFeriado.getJDateChooserFeriado().getDate();
              int resp = JOptionPane.showConfirmDialog(null,"¿Esta Seguro?",
                         "Alerta", JOptionPane.YES_NO_OPTION);
            if(resp==0){
             daoferiado.eliminarFeriado(fecha);
             JOptionPane.showMessageDialog(null, "Fecha eliminada "
                                           + "satisfactoriamente");
            }
             limpiarCampos();
             habilitarCampos(false);
                      
    }
  
    private void limpiarCampos(){
        formFeriado.getjTextFieldDescripcion().setText("");
        formFeriado.getJDateChooserFeriado().setDate(null);         
        deshabilitarCampos(true);
        formFeriado.getjTextFieldDescripcion().setEnabled(false);
        operacion=' ';
        habilitarCampos(false);
        
    }
  
    private void cancelar(){
        limpiarCampos();
        formFeriado.getjButtonEliminar().setEnabled(false);
        
    }


    private void descripcionKeyTyped(KeyEvent e){
        if(formFeriado.getjTextFieldDescripcion().getText().trim().length()==50)
        {
            e.consume();
        }
    }
  
   private void habilitarCampos(boolean estado){
       formFeriado.getjTextFieldDescripcion().setEnabled(estado);
       formFeriado.getjButtonCancelar().setEnabled(estado);
       formFeriado.getjButtonModificar().setEnabled(estado);

      
   }
  
   private void deshabilitarCampos(boolean estado)
   {
        formFeriado.getjButtonBuscar().setEnabled(estado);
        formFeriado.getJDateChooserFeriado().setEnabled(estado);
   }

    @Override
    public void keyTyped(KeyEvent ke) {
       if (ke.getSource().equals(formFeriado.getjTextFieldDescripcion())) 
       {
         descripcionKeyTyped(ke);  
       }  
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); 
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet.");
       //To change body of generated methods, choose Tools | Templates.
    }
    //---------------------------------
private void BuscarFecha() throws SQLException
{
         
           
  DaoFeriado daoFeriado=new DaoFeriado(); 
  ResultSet regisFecha;
  
  
 regisFecha=daoFeriado.buscarFeriado(formFeriado.getJDateChooserFeriado()
                                     .getDate());
  if (regisFecha.next())
    {
      operacion='M';  
      formFeriado.getjButtonEliminar().setEnabled(true);
      formFeriado.getjTextFieldDescripcion().setText(
                  regisFecha.getString("descripcion").trim());  
      
    }  
  else
  {
      
      operacion='I';
      formFeriado.getjTextFieldDescripcion().setRequestFocusEnabled(true);
      formFeriado.getjButtonEliminar().setEnabled(false);
      
      
      
  }
  habilitarCampos(true);
  deshabilitarCampos(false); 
  regisFecha.close();
  
    
}        

   
    @Override
    public void actionPerformed(ActionEvent ae) {
        
     
         if(ae.getSource().equals(formFeriado.getjButtonCancelar())){ 
             cancelar();
         }
         
         if(ae.getSource().equals(formFeriado.getjButtonModificar())){
             modificar();
         }
         
         if(ae.getSource().equals(formFeriado.getjButtonEliminar())){
             eliminar();
             cancelar();
         }
         if(ae.getSource().equals(formFeriado.getjButtonSalir())){
             formFeriado.dispose();
         }
         
         
         if(ae.getSource().equals(formFeriado.getjButtonBuscar())){
            if(formFeriado.getJDateChooserFeriado().getDate()==null){
              JOptionPane.showMessageDialog(null, "Seleccione una fecha");
              formFeriado.getJDateChooserFeriado().requestFocus();
              return;  
              }
            else{
            try {
                BuscarFecha();
            } catch (SQLException ex) {
              Logger.getLogger(CFeriado.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            }
         }

    }
            
}
    
