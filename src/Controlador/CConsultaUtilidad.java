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

import Dao.DaoProyecto;
import Libreria.Rutinas;
import Vista.VConsultaUtilidad;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joselyn
 */
public class CConsultaUtilidad implements ActionListener, KeyListener{
    private VConsultaUtilidad VUtil;
    
    public CConsultaUtilidad()
    {
        VUtil = new VConsultaUtilidad();
        VUtil.agregarListener(this);
        VUtil.setVisible(true);  
        
        VUtil.getjTextFieldBusq().addKeyListener(this);
    }
    
    private void Cancelar()
    {
       
        VUtil.getjTextFieldBusq().setText("");
        VUtil.getjTextFieldUtilidad().setText("");
        VUtil.getjButtonBuscar().setEnabled(false);
        VUtil.getjRadioButtonMes().setSelected(false);
        VUtil.getjRadioButtonPro().setSelected(false);
        VUtil.getjRadioButtonMes().setEnabled(true);
        VUtil.getjRadioButtonPro().setEnabled(true);
        VUtil.getjButtonCancelar().setEnabled(false);
        
    }
    
    private void utiProy() throws SQLException
    {
        ResultSet uti;
        DaoProyecto daoP=new DaoProyecto();
        uti=daoP.utilidadProy(VUtil.getjTextFieldBusq().getText());
        
        ResultSet proy;
        proy=daoP.BuscarP(VUtil.getjTextFieldBusq().getText().trim());
        
        if(!proy.next())
        {
             Rutinas.Aviso("El proyecto no se encuentra registrado", "");
             Cancelar();
             return;
        }
        
        float acum=0;
        float ingreso=0;
        
        if(uti.next())
        {
            do{
                ingreso+=uti.getFloat("monto");
                
                
                
            }   while(uti.next());
        }
        
        uti=daoP.buscarNom(VUtil.getjTextFieldBusq().getText());
        
        if(uti.next())
        {
            do{
                acum+=uti.getFloat("montoneto");
            }while(uti.next())     ;
        }
                
        
        float utilidad=ingreso-acum;
        String util = "" + utilidad +"";
        VUtil.getjTextFieldUtilidad().setText(util);
        
        uti.close();
    }
    
    
    private void utiMes() throws SQLException
    {
        ResultSet uti;
        DaoProyecto daoP=new DaoProyecto();
        uti=daoP.buscarIng(VUtil.getjMonthChooserMeses().getMonth()+1, calcAnnoActual());
        
        float acum=0;
        float ingreso=0;
        
        if(uti.next())
        {
            do{
                ingreso+=uti.getFloat("monto");
                
                
            }   while(uti.next())     ;
        }
        
        uti=daoP.buscarEg(VUtil.getjMonthChooserMeses().getMonth()+1, calcAnnoActual());
        
        if(uti.next())
        {
            do{
                acum+=uti.getFloat("montoneto");
                
            }while(uti.next())     ;
        }
                
        
        float utilidad=ingreso-acum;
        String util = "" + utilidad +"";
        VUtil.getjTextFieldUtilidad().setText(util);
        
        uti.close();
    }
    
    private void utiProMes() throws SQLException
    {
        ResultSet uti;
        DaoProyecto daoP=new DaoProyecto();
        uti=daoP.UtilidadProyecto(VUtil.getjTextFieldBusq().getText().trim(), VUtil.getjMonthChooserMeses().getMonth()+1, calcAnnoActual());
        
        ResultSet proy;
        proy=daoP.BuscarP(VUtil.getjTextFieldBusq().getText().trim());
        
        if(!proy.next())
        {
             Rutinas.Aviso("El proyecto no se encuentra registrado", "");
             Cancelar();
             return;
        }
        
        float acum=0;
        float montoIngreso=0;
        if(uti.next())
        {
            
            do
            {
                acum+=uti.getInt("montoneto");          //acumula el monto neto pagado a los candidatos en $
                montoIngreso=uti.getInt("monto");
            }while(uti.next());
            
        }
            
        
             float montoUtilidad=montoIngreso-acum;
            String mont=""+montoUtilidad+"";
        
            VUtil.getjTextFieldUtilidad().setText(mont);
        
       
    }
    
    private int calcUltDia()
    {
        Calendar calFin = Calendar.getInstance();
        int anno=calcAnnoActual();
        
        int mes=VUtil.getjMonthChooserMeses().getMonth();
        calFin.set(anno, mes, 1);
        
        int fec=calFin.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        return fec;
    }
    
    private int calcAnnoActual()
    {
        Calendar c1 = Calendar.getInstance();
        int anno=c1.get(Calendar.YEAR);
        return anno;
    }
    
    
     public void actionPerformed(ActionEvent e) {
         
         if(e.getSource().equals(VUtil.getjRadioButtonPro()))
         {
             if(VUtil.getjRadioButtonPro().isSelected()){
                 VUtil.getjTextFieldBusq().setEnabled(true);
                 VUtil.getjButtonBuscar().setEnabled(true);
                 VUtil.getjButtonCancelar().setEnabled(true);
             }
             else{
                 VUtil.getjTextFieldBusq().setEnabled(false);
             }
             return;
         }
         
          if (e.getSource().equals(VUtil.getjButtonCancelar()))  
        {
             Cancelar(); 
             return;
        }  
          if(e.getSource().equals(VUtil.getjButtonRegresar()))
        {
            VUtil.dispose();
            return;
        }
          
          
          if(e.getSource().equals(VUtil.getjRadioButtonMes()))
          {
              if(VUtil.getjRadioButtonMes().isSelected())
              {
                
                  VUtil.getjMonthChooserMeses().setEnabled(true);
                  VUtil.getjButtonBuscar().setEnabled(true);
                  VUtil.getjButtonCancelar().setEnabled(true);
              }
              else
              {
                 
                  VUtil.getjMonthChooserMeses().setEnabled(false);
              }
              return;
          }
              
          
          
          if(e.getSource().equals(VUtil.getjButtonBuscar()))
          {
              VUtil.getjRadioButtonMes().setEnabled(false);
              VUtil.getjRadioButtonPro().setEnabled(false);
              VUtil.getjMonthChooserMeses().setEnabled(false);
              VUtil.getjTextFieldBusq().setEnabled(false);
              if((VUtil.getjRadioButtonPro().isSelected()) && (!VUtil.getjRadioButtonMes().isSelected()))
              {
                  try {
                      utiProy();
                  } catch (SQLException ex) {
                      Logger.getLogger(CConsultaUtilidad.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  return;
              }
              
              if((VUtil.getjRadioButtonPro().isSelected()) && (VUtil.getjRadioButtonMes().isSelected()))
              {
                  try {
                      utiProMes();
                  } catch (SQLException ex) {
                      Logger.getLogger(CConsultaUtilidad.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  return;
              }
              
              if((!VUtil.getjRadioButtonPro().isSelected()) && (VUtil.getjRadioButtonMes().isSelected()))
              {
                  try {
                      utiMes();
                  } catch (SQLException ex) {
                      Logger.getLogger(CConsultaUtilidad.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          }
          return;
          
     }

     
     public void codKeyTyped(KeyEvent e)
     {
         
        if (VUtil.getjTextFieldBusq().getText().trim().length()==10)  
        {
            e.consume(); 
        }  
     }
    @Override
    public void keyTyped(KeyEvent e) {
        codKeyTyped(e);    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        }

    @Override
    public void keyReleased(KeyEvent e) {
        }
}
