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


import Dao.DaoCliente;
import Libreria.Rutinas;
import Modelo.MCliente;
import Vista.VCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class CCliente implements ActionListener,KeyListener {
    private VCliente formCliente;
    private char Operacion;
    
        public CCliente(){
            formCliente = new VCliente();
            formCliente.agregarListener(this);
            formCliente.setVisible(true);                        
            formCliente.getjTextFieldCodigo().requestFocusInWindow();
            habilitarCliente(false);
        }
    
    private void limpiarCodigo()
    {
        formCliente.getjTextFieldCodigo().setText("");
    }
           
    private void limpiarCampos()
    {        
        formCliente.getjTextFieldRazonSocial().setText("");
        formCliente.getjTextFieldEstado_Provincia().setText("");
        formCliente.getjTextFieldTelefono().setText("");
        formCliente.getjTextFieldCorreo().setText("");
        formCliente.getjComboBoxPaises().setSelectedIndex(0);
    }
    
    private void habilitarBusqueda(boolean estado)
    {
        formCliente.getjButtonBuscar().setEnabled(estado);
        formCliente.getjTextFieldCodigo().setEnabled(estado);
    }
    
    private void habilitarCliente(boolean estado)
    {
        formCliente.getjTextFieldRazonSocial().setEnabled(estado);
        formCliente.getjTextFieldCorreo().setEnabled(estado);
        formCliente.getjComboBoxPaises().setEnabled(estado);
        formCliente.getjTextFieldEstado_Provincia().setEnabled(estado);
        formCliente.getjTextFieldTelefono().setEnabled(estado);
        formCliente.getjButtonGuardar().setEnabled(estado);
        formCliente.getjButtonEliminar().setEnabled(estado);
        formCliente.getjButtonCancelar().setEnabled(estado);
        
    }
    
           
    private void cancelar(){
        limpiarCodigo();
        limpiarCampos();
        habilitarCliente(false);
        habilitarBusqueda(true);
        formCliente.getjTextFieldCodigo().requestFocusInWindow();
    }
    

    
    private void buscar() throws SQLException
    {
        if (formCliente.getjTextFieldCodigo().getText().trim().length()==0)
        {
            Rutinas.Aviso("Codigo de Cliente vacio", "");
            formCliente.getjTextFieldCodigo().requestFocusInWindow();
            return;
        }
        else{
            
        
        DaoCliente daoClie = new DaoCliente();
        ResultSet regCliente;
        
        regCliente = daoClie.buscarCliente(formCliente.getjTextFieldCodigo().getText());
        if(regCliente.next()){ 
            if(regCliente.getString("estatus").equals("E"))
            {   
                JOptionPane.showMessageDialog(null, "El cliente se encuentra"
                        + " eliminado, para activarlo comuniquese "
                        + "con el administrador.");                   
                cancelar();
                formCliente.getjButtonCancelar().setEnabled(true);
                return;
            }
            else{
            
            Operacion = 'M';
            formCliente.getjTextFieldRazonSocial().setText(regCliente.getString("nombre").trim());
            formCliente.getjTextFieldCorreo().setText(regCliente.getString("correo").trim());
            formCliente.getjComboBoxPaises().setSelectedItem(regCliente.getString("pais").trim());
            formCliente.getjTextFieldEstado_Provincia().setText(regCliente.getString("estado_provincia").trim());
            formCliente.getjTextFieldTelefono().setText(regCliente.getString("telefono").trim());    
            habilitarBusqueda(false);
            habilitarCliente(true);
            }
        }
        else{
            Operacion = 'I';
            habilitarCliente(true);          
            formCliente.getjButtonEliminar().setEnabled(false);
            formCliente.getjTextFieldRazonSocial().setRequestFocusEnabled(true);
            formCliente.getjTextFieldTelefono().setRequestFocusEnabled(true);
            formCliente.getjTextFieldCorreo().setRequestFocusEnabled(true);
            }
        regCliente.close(); 
        }
    }
    
    private boolean validarCampos()
    {
        if (formCliente.getjTextFieldCodigo().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingrese un Identificador", "");
            formCliente.getjTextFieldCodigo().requestFocusInWindow();
            return false;
        }
        
        if (formCliente.getjTextFieldRazonSocial().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingrese la Razon Social", "");
            formCliente.getjTextFieldRazonSocial().requestFocusInWindow();
            return false;
        }
        
        if (formCliente.getjComboBoxPaises().getSelectedIndex()==0)    
        {
            Rutinas.Aviso("Seleccione un País", "");
            formCliente.getjComboBoxPaises().requestFocusInWindow();
            return false;      
        }
        
        if (formCliente.getjTextFieldEstado_Provincia().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingrese un Estado/Provincia", "");
            formCliente.getjTextFieldEstado_Provincia().requestFocusInWindow();
            return false;
        }
        
        if (formCliente.getjTextFieldTelefono().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingrese un Telefono", "");
            formCliente.getjTextFieldTelefono().requestFocusInWindow();
            return false;
        }
        
        if (formCliente.getjTextFieldCorreo().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingrese un Correo", "");
            formCliente.getjTextFieldCorreo().requestFocusInWindow();
            return false;
        }
        
        if (!isEmail(formCliente.getjTextFieldCorreo().getText()))
        {
            Rutinas.Aviso ("Correo Invalido","");
            formCliente.getjTextFieldCorreo().requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    private void Guardar(){
        habilitarCliente(true);
           
       DaoCliente daoClie= new DaoCliente();
       MCliente mc;
       
       mc = new MCliente(formCliente.getjTextFieldCodigo().getText().trim(),
                      formCliente.getjTextFieldRazonSocial().getText().trim(),
               formCliente.getjTextFieldCorreo().getText().trim(),
                        (String)formCliente.getjComboBoxPaises().getSelectedItem(),
                      formCliente.getjTextFieldEstado_Provincia().getText().trim(),
                      formCliente.getjTextFieldTelefono().getText().trim());
       
       switch(Operacion)
       {
           case 'I':{
               if(!validarCampos())
               {                   
                   Rutinas.Aviso("DEBE LLENAR TODOS LOS DATOS", "");                   
               }
               else
               {
                    daoClie.insertcliente(mc);
                    Rutinas.Aviso("Registro Realizado Satisfactoriamente", "");
                    cancelar();
               }
           }break;
           case 'M':{
               daoClie.modificarCliente(mc);           
                Rutinas.Aviso("Actualización Exitosa", "");
                cancelar();
           }
       }        
    }
    
    private void Eliminar() throws SQLException
    {
        DaoCliente daoClie= new DaoCliente();
        MCliente mc;
        mc = new MCliente(formCliente.getjTextFieldCodigo().getText().trim(),
                          formCliente.getjTextFieldRazonSocial().getText().trim(),
                          formCliente.getjTextFieldCorreo().getText().trim(),
                          (String)formCliente.getjComboBoxPaises().getSelectedItem(),
                          formCliente.getjTextFieldEstado_Provincia().getText().trim(),
                          formCliente.getjTextFieldTelefono().getText().trim());
                    
        ResultSet regCliente;
        regCliente = daoClie.buscarProyAct(formCliente.getjTextFieldCodigo().getText());
        if (regCliente.next())
        {
            Rutinas.Aviso("El cliente tiene proyecto(s) activo(s), en estos momentos no puede ser eliminado", "");
            cancelar();
        }
        else
        {
            int resp;
        resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminarlo?", "Alerta!", JOptionPane.YES_NO_OPTION);
        daoClie.eliminarCliente(mc);
        cancelar();
        }
        
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource().equals(formCliente.getjButtonGuardar()))  
      {
        Guardar();
      } 
       
       if (ae.getSource().equals(formCliente.getjButtonCancelar()))  
      {
         cancelar(); 
      }
      
      if (ae.getSource().equals(formCliente.getjButtonRegresar()))  
      {
            formCliente.dispose();  
      }
      
      if (ae.getSource().equals(formCliente.getjButtonBuscar()))
      {
           try {
               buscar();
               habilitarBusqueda(false);
           } catch (SQLException ex) {
               Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
      }
      
      if (ae.getSource().equals(formCliente.getjButtonEliminar()))
      {
           try {
               Eliminar();
           } catch (SQLException ex) {
               Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
          
      }
       
    }
    
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }        
    }
    

    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getSource().equals(formCliente.getjTextFieldCodigo()))
        {
            CodigoKeyTyped(ke);
        }
        
        if (ke.getSource().equals(formCliente.getjTextFieldRazonSocial()))
        {
            RazonSocialKeyTyped (ke);
        }
        
        if (ke.getSource().equals(formCliente.getjTextFieldEstado_Provincia()))
        {
            Estado_ProvinciaKeyTyped (ke);
        }
        
        
    }
    
    public void CodigoKeyTyped(KeyEvent ke)
    {
        if (formCliente.getjTextFieldCodigo().getText().trim().length()==15)
        {
            ke.consume();
        }
    }
    
    public void RazonSocialKeyTyped(KeyEvent ke)
    {
        if (formCliente.getjTextFieldRazonSocial().getText().trim().length()==30)
        {
            ke.consume();
        }
    }
    
    public void Estado_ProvinciaKeyTyped(KeyEvent ke)
    {
        if (formCliente.getjTextFieldEstado_Provincia().getText().trim().length()==20)
        {
            ke.consume();
        }
    }
    
    

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    
}
