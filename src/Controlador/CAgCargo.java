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

import Dao.DaoEntrevista;
import Dao.DaoProyecto;
import Libreria.Rutinas;

import Vista.VAgregarCargo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CAgCargo implements ActionListener{

   private  VAgregarCargo vCarg;
    
    public CAgCargo(String cod, String desc) throws SQLException {
        
        
        vCarg = new VAgregarCargo();
        vCarg.agListener(this);
        vCarg.setVisible(true);
        
        vCarg.getjTextFieldCodigo().setText(cod);
        vCarg.getjTextFieldDesc().setText(desc);
        
        cargarCombo();
    }
    


     private void cargarCombo() throws SQLException
    {
        DaoEntrevista daoE = new DaoEntrevista();
        ResultSet cargo;
       
        cargo=daoE.buscCargComp();
        
        while(cargo.next())
        {
            String cdesc=cargo.getString("descripcion");
            vCarg.getjComboBoxCargo().addItem(cdesc);
        }
    }
     
      private String comboCargoAspirado()
    {
        return (String) vCarg.getjComboBoxCargo().getModel().getSelectedItem();
    }
      
      private void agregar() throws SQLException
      {
        ResultSet cargo;
        DaoEntrevista daoE = new DaoEntrevista();
         
        cargo=daoE.buscarCargos(comboCargoAspirado());
         
          int codcarg;
         if(cargo.next())
         {
             codcarg=cargo.getInt("codigo");
         }else   
             return;
         
         DaoProyecto daoP=new DaoProyecto();
         
           ResultSet val;
           
            val = daoP.validarCargo(vCarg.getjTextFieldCodigo().getText(), codcarg);
            
            if(val.next())
            {
                
                Rutinas.Aviso("Cargo agregado previamente a este proyecto", "Advertencia");
                return;
            }
            else
            {
         daoP.agCargo(vCarg.getjTextFieldCodigo().getText(), codcarg);
         Rutinas.Aviso("Cargo agregado con éxito", "");
        } 
      }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vCarg.getjComboBoxCargo()))
        {
            if(vCarg.getjComboBoxCargo().getSelectedIndex()==0)
            {
                vCarg.getjButtonAgregar().setEnabled(false);
                return;
            }
            else
            {
                vCarg.getjButtonAgregar().setEnabled(true);
                return;
            }
        }
        
        if(e.getSource().equals(vCarg.getjButtonAgregar()))
        {
            try {
                agregar();
            } catch (SQLException ex) {
                Logger.getLogger(CAgCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
            vCarg.getjButtonAgregar().setEnabled(false);
            vCarg.getjComboBoxCargo().setSelectedIndex(0);
            return;
        }
        
        if(e.getSource().equals(vCarg.getjButtonRegresar()))
        {
            vCarg.dispose();
            
        }
        
        
    }
      
      
 
    
}
