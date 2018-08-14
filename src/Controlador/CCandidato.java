
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Dao.DaoCandidato;
import Dao.DaoFeriado;
import Libreria.Rutinas;
import Modelo.MCandidato;
import Vista.VCandidato;
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
//import java.awt.Desktop;
//import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author franc_000
 */
public class CCandidato implements ActionListener, KeyListener
{
    private VCandidato formCandidato;   
    private char operacion;
    private Integer Fila = 0;

    public CCandidato() 
    {
        formCandidato = new VCandidato();
        formCandidato.agregarListener(this);
        formCandidato.setVisible(true);
       
        habilitarCandidato(false);
        limpiarGrid();
        
        formCandidato.getjTextField1Curriculum().addKeyListener(this);
        formCandidato.getjTextField1Nombre().addKeyListener(this);
        formCandidato.getjTextField2Apellido().addKeyListener(this);
        formCandidato.getjTextField3Identificacion().addKeyListener(this);
        formCandidato.getjTextField4Telefono().addKeyListener(this);
        formCandidato.getjTextField5Correo().addKeyListener(this);
        formCandidato.getjTextField6estadoprovincia().addKeyListener(this);
        
        
    }
//-------------------------
private void cancelar()
{ 
  limpiarCampos ();
  limpiarGrid ();
  formCandidato.getEliminar().setEnabled (false);
}        

//-------------------------- 
private void buscar() throws SQLException
{
     if(formCandidato.getjTextField3Identificacion().getText().trim().length()==0)
     {
                Rutinas.Aviso("Ingrese el identificador", "");
                formCandidato.getjTextField3Identificacion().requestFocusInWindow();
      }
     else
     {    
       DaoCandidato daoCandidato = new DaoCandidato ();
        ResultSet regiscandidato;
  
       regiscandidato = daoCandidato.buscarCandidato(formCandidato.getjTextField3Identificacion().getText());
       if (regiscandidato.next())
       {
      if(regiscandidato.getString("estatus").equals("A"))
      {
      operacion = 'M';
      formCandidato.getEliminar().setEnabled(true);
      formCandidato.getjTextField1Nombre().setText(regiscandidato.getString("nombre").trim());
      formCandidato.getjTextField2Apellido().setText(regiscandidato.getString("apellido").trim());
      formCandidato.getjTextField4Telefono().setText(regiscandidato.getString("telefono").trim());
      formCandidato.getjTextField5Correo().setText(regiscandidato.getString("correo").trim());
      formCandidato.getjComboBox1Nacionalidad().setSelectedItem(regiscandidato.getString("nacionalidad").trim());
      formCandidato.getjTextField6estadoprovincia().setText(regiscandidato.getString("estado_provincia").trim());
      formCandidato.getjTextField1Curriculum().setText(regiscandidato.getString("curriculum").trim());
      CargarGrid();
      
      if(regiscandidato.getString("sexo").equals("F"))
      {
          formCandidato.getjComboBox1Sexo().setSelectedIndex(1);
          
      }
      else{
          formCandidato.getjComboBox1Sexo().setSelectedIndex(2);
      }
      }
      else
      {
          JOptionPane.showMessageDialog(null, 
                                       "El candidato se encuentra eliminado"
                                       + ",Si desea activarlo comuniquese con "
                                       + "el administrador.");
          cancelar();
          return;
      }
      }
          
    else
    { 
      operacion = 'I';
      formCandidato.getEliminar().setEnabled(true);
      formCandidato.getjTextField1Nombre().setRequestFocusEnabled(true);
      formCandidato.getjTextField2Apellido().setRequestFocusEnabled(true);
      formCandidato.getjTextField4Telefono().setRequestFocusEnabled(true);
      formCandidato.getjTextField5Correo().setRequestFocusEnabled(true);
    }
  
      habilitarCandidato(true);
      desabilitarCampos (false);
      regiscandidato.close ();
   }
}
 
private String sexo()
{
    
   if (formCandidato.getjComboBox1Sexo().getSelectedIndex()==1)
   {
       return "F";
   }
   else
   {
           return "M";
       
   }
}




private void modificar () throws SQLException
{
    habilitarCandidato (true);
    DaoCandidato daoCandi=new DaoCandidato();
     MCandidato mCandi;
    if (formCandidato.getjTextField2Apellido().getText().trim().length()==0)    
      {
      Rutinas.Aviso("Ingrese un Apellido", "");
      formCandidato.getjTextField2Apellido().requestFocusInWindow();
      return;      
       }  
    if (formCandidato.getjTextField1Nombre().getText().trim().length()==0)    
      {
      Rutinas.Aviso("Ingrese un Nombre", "");
      formCandidato.getjTextField1Nombre().requestFocusInWindow();
      return;      
      }  
    if (formCandidato.getjTextField5Correo().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingrese un Correo", "");
            formCandidato.getjTextField5Correo().requestFocusInWindow();
            return;
        }
    if (!isEmail(formCandidato.getjTextField5Correo().getText()))
      {
      Rutinas.Aviso ("Correo Invalido","");
      }
  
    if (formCandidato.getjTextField4Telefono().getText().trim().length()==0)
     { 
        Rutinas.Aviso("Ingrese un Telefono", "");
        formCandidato.getjTextField1Nombre().requestFocusInWindow();
        return;
     }
    if (formCandidato.getjTextField6estadoprovincia().getText().trim().length()==0)
     {
       Rutinas.Aviso("Ingrese un Estado/Provincia", "");
       formCandidato.getjTextField6estadoprovincia().requestFocusInWindow();
       return;
     }
    if (formCandidato.getjComboBox1Nacionalidad().getSelectedIndex()==0)
       {
       Rutinas.Aviso("Ingrese una Nacionalidad", "");
       formCandidato.getjComboBox1Nacionalidad().requestFocusInWindow();
       return;
        }
     if (formCandidato.getjComboBox1Sexo().getSelectedIndex()==0)
        {
       Rutinas.Aviso("Ingrese un Sexo", "");
       formCandidato.getjComboBox1Sexo().requestFocusInWindow();
       return;
         }
    String sex = sexo();
   mCandi=new MCandidato(formCandidato.getjTextField3Identificacion().getText(), 
                         formCandidato.getjTextField1Nombre().getText(), 
                         formCandidato.getjTextField2Apellido().getText(), 
                         sex,
                         formCandidato.getjTextField4Telefono().getText(), 
                         formCandidato.getjTextField5Correo().getText(), 
                         (String) formCandidato.getjComboBox1Nacionalidad().getSelectedItem(),
                         formCandidato.getjTextField6estadoprovincia().getText(),
                         formCandidato.getjTextField1Curriculum().getText()) ;
                         String desccualidad=(String) formCandidato.getjTable1Cualidades().getValueAt(Fila, 0);
                         String idcand= formCandidato.getjTextField3Identificacion().getText().trim();
                         
   switch(operacion)
   {   
       case 'I':
                
                daoCandi.insertarCandidato(mCandi);
                //daoCandi.insertCualidades(desccualidad, idcand);
                Grabar ();
                JOptionPane.showMessageDialog(null, "Registro Realizado Satisfactoriamente");
                break;
       case 'M':
           
                ResultSet b;
                b=daoCandi.buscarPal(formCandidato.getjTextField3Identificacion().getText());
                if(b.next())
                {
                    daoCandi.eliminarCualidad(formCandidato.getjTextField3Identificacion().getText());
                }
                
                Grabar ();
                 daoCandi.modificarCandidato(mCandi);
                 JOptionPane.showMessageDialog(null, "Actualización Exitosa");
                
     }
   limpiarCampos ();
   limpiarGrid ();
}
 

private void Grabar() throws SQLException    
{
  Integer Fila;
  String Palabra;
  DaoCandidato daoCandi=new DaoCandidato();
  ResultSet pal;
  for (Fila=0;Fila<formCandidato.getjTable1Cualidades().getRowCount();Fila++)  
  {
     Palabra=(String) formCandidato.getjTable1Cualidades().getValueAt(Fila, 0); 
     Palabra=Palabra.trim();
     
         if (Palabra.length() > 0)
        {
             daoCandi.insertCualidades(Palabra, formCandidato.getjTextField3Identificacion().getText().trim());  
         
        }  
  
  }
  
  
}     
 private void CargarGrid() throws SQLException
    {
     
        int Fila=0;
       
       
        DaoCandidato daoCan= new DaoCandidato();
        ResultSet cuali;
        
        cuali = daoCan.buscarCualidades(formCandidato.getjTextField3Identificacion().getText().trim());
        if(cuali.next())
        
        {  int horast=0;
        do
        {
            String pala=cuali.getString("descripcion").trim();
            
           
            
            formCandidato.getjTable1Cualidades().setValueAt(pala, Fila, 0);
            
            Fila++;
            
        }while(cuali.next());
        
        } 
        else 
        return;
       
    }
   
private void eliminar()
{
      String id;
             DaoCandidato daocan= new DaoCandidato();
             id=formCandidato.getjTextField3Identificacion().getText().trim();
             int resp = JOptionPane.showConfirmDialog(null,"¿Esta Seguro?", "Alerta", JOptionPane.YES_NO_OPTION);
            if(resp==0){ 
                daocan.eliminarCandidato(id);
                JOptionPane.showMessageDialog(null, "Registro Eliminado Satisfactoriamente");
                
            }
            
            
      limpiarCampos ();
      limpiarGrid();
      habilitarCandidato (false);
     
}

   
    public void nombreKeyTyped (KeyEvent e)
    {
        if (formCandidato.getjTextField1Nombre().getText().trim().length()==20)  
          {
              e.consume(); 
          }  
    }
     
    public void apellidoKeyTyped (KeyEvent e)
    {
        if (formCandidato.getjTextField2Apellido().getText().trim().length()==20)
        {
            e.consume();
        }
    }
    
    private void identificacionKeyTyped (KeyEvent e)
    {
      if (formCandidato.getjTextField3Identificacion().getText().trim().length()==10)  
          e.consume();
    }
    private void correoKeyTyped (KeyEvent e)
    {
      if (formCandidato.getjTextField5Correo().getText().trim().length()==50)  
          e.consume();
    }
    private void curriculumKeyTyped (KeyEvent e)
    {
      if (formCandidato.getjTextField1Curriculum().getText().trim().length()==100)  
          e.consume();
    }
    private void telefonoKeyTyped (KeyEvent e)
    {
      if (formCandidato.getjTextField4Telefono().getText().trim().length()==10)  
          e.consume();
    }
    private void estadoprovinciaKeyTyped (KeyEvent e)
    {
      if (formCandidato.getjTextField6estadoprovincia().getText().trim().length()==20)  
          e.consume();
    }
    private boolean isEmail(String correo) 
    {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            //System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }        
    }
    
    private void habilitarCandidato (boolean Estado)
    {
        formCandidato.getjTextField1Nombre().setEnabled(Estado);
        formCandidato.getjTextField2Apellido().setEnabled(Estado);
        formCandidato.getjTextField4Telefono().setEnabled(Estado);
        formCandidato.getjTextField5Correo().setEnabled(Estado);
        formCandidato.getjTextField6estadoprovincia().setEnabled(Estado);
        formCandidato.getjTextField6estadoprovincia().setEnabled(Estado);
        formCandidato.getModificar().setEnabled(Estado);
        formCandidato.getCancelar().setEnabled(Estado);
        formCandidato.getEliminar().setEnabled (Estado);
        
        formCandidato.getjButton1Adjuntar().setEnabled(Estado);
        formCandidato.getjComboBox1Sexo().setEnabled (Estado);
        formCandidato.getjComboBox1Nacionalidad().setEnabled(Estado);
        
        
    }
    
    private void desabilitarCampos (boolean estado)
    {
        formCandidato.getjButton2Buscar().setEnabled(estado);
        formCandidato.getjTextField3Identificacion().setEnabled(estado);
        
    }
    
    private void limpiarCampos ()
    {
       formCandidato.getjTextField3Identificacion().setEnabled(true);
       formCandidato.getjTextField3Identificacion().setRequestFocusEnabled(true);
       formCandidato.getjButton2Buscar().setEnabled(true);
       formCandidato.getjTextField1Nombre().setText("");
       formCandidato.getjTextField2Apellido().setText("");
       formCandidato.getjTextField3Identificacion().setText("");
       formCandidato.getjTextField4Telefono().setText("");
       formCandidato.getjTextField5Correo().setText("");
       //formCandidato.getCualidades().setText("");
       formCandidato.getjTextField1Curriculum().setText("");
       formCandidato.getjComboBox1Nacionalidad().setSelectedIndex(0);
       formCandidato.getjComboBox1Sexo().setSelectedIndex(0);
       formCandidato.getjTextField6estadoprovincia().setText("");
       formCandidato.getjTextField1Nombre().setEnabled(false);
       formCandidato.getjTextField2Apellido().setEnabled(false);
       formCandidato.getjTextField4Telefono().setEnabled(false);
       formCandidato.getjTextField5Correo().setEnabled(false);
       formCandidato.getjTextField6estadoprovincia().setEnabled(false);
       formCandidato.getjTextField6estadoprovincia().setEnabled(false);
      // formCandidato.getCualidades().setEnabled(false);
       formCandidato.getjTextField1Curriculum().setEnabled(false);
  
  
  habilitarCandidato (false);
  desabilitarCampos(true);
  operacion = ' ';
    }
    
    private void limpiarGrid()    
      {
    Integer Fila;
  
  for (Fila=0;Fila<formCandidato.getjTable1Cualidades().getRowCount();Fila++)  
  {
     formCandidato.getjTable1Cualidades().setValueAt("", Fila, 0);      
  }  
    
       }   
    @Override
    public void keyTyped(KeyEvent e) 
    {
        if (e.getSource().equals(formCandidato.getjTextField1Nombre())) 
       {
         nombreKeyTyped (e);
       }  
        
        if (e.getSource().equals(formCandidato.getjTextField2Apellido()))
        {
            apellidoKeyTyped (e);
        }
        if (e.getSource().equals(formCandidato.getjTextField3Identificacion()))
        {
            identificacionKeyTyped (e);
        }
        if (e.getSource().equals(formCandidato.getjTextField1Curriculum()))
        {
            curriculumKeyTyped (e);
        }
      if (e.getSource().equals(formCandidato.getjTextField5Correo()))
        {
            correoKeyTyped (e);
        }
      if (e.getSource().equals(formCandidato.getjTextField4Telefono()))
        {
            telefonoKeyTyped (e);
        }
      if (e.getSource().equals(formCandidato.getjTextField4Telefono()))
        {
             estadoprovinciaKeyTyped (e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        
    }
     //--------------------
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      
      //---------
      if (e.getSource().equals(formCandidato.getModificar()))
      {
          try {
              modificar();
          } catch (SQLException ex) {
              Logger.getLogger(CCandidato.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      //------------
      if (e.getSource().equals(formCandidato.getCancelar()))  
      {
         cancelar(); 
      }  
      //----------
       if (e.getSource().equals(formCandidato.getEliminar()))  
      {
         eliminar(); 
      } 
     
     //--
     if (e.getSource().equals(formCandidato.getSalir()))  
      {
        formCandidato.dispose();  
      } 
     if (e.getSource().equals(formCandidato.getjButton2Buscar()))
     {
         try {
             buscar();
         } catch (SQLException ex) {
             Logger.getLogger(CCandidato.class.getName()).log(Level.SEVERE, null,ex);
         }
             
     }
    }

    

}

