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
import Libreria.Rutinas;
import Vista.VConsultaEntrevista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class CConsultarEntrevista implements ActionListener,KeyListener{
    private VConsultaEntrevista VEnt;
     public CConsultarEntrevista() 
    {
        VEnt = new VConsultaEntrevista();
        VEnt.agregarListener(this);
        VEnt.setVisible(true);
        
        VEnt.getjTextFieldBusq().addKeyListener(this);
        
        
        VEnt.getjDateChooserFecFinal().getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                DateChooserKeyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
         });        
        
        
        VEnt.getjDateChooserFecInicial().getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                DateChooserKeyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
         });        
    }
     
     private void Cancelar()
     {

         VEnt.getjTextFieldBusq().setText("");
         //VEnt.getjTextFieldBusq().setEditable(false);
        
         VEnt.getjButtonBuscar().setEnabled(false);
         VEnt.getjComboBoxBusqEnt().setSelectedIndex(0);
         VEnt.getjRadioButtonFecha().setSelected(false);
         VEnt.getjDateChooserFecFinal().setCalendar(null);
         VEnt.getjDateChooserFecInicial().setCalendar(null);
         VEnt.getjDateChooserFecFinal().getDateEditor().setEnabled(false);
         VEnt.getjDateChooserFecInicial().getDateEditor().setEnabled(false);
         VEnt.getjDateChooserFecFinal().setEnabled(false);
         VEnt.getjDateChooserFecInicial().setEnabled(false);
         VEnt.getjButtonBuscar().setEnabled(false);
         VEnt.getjButtonCancelar().setEnabled(false);
         VEnt.getjComboBoxBusqEnt().setEnabled(true);
         VEnt.getjRadioButtonFecha().setEnabled(true);
        limpiarTabla();
     }
     
      private void limpiarTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel) VEnt.getjTableCandidato().getModel();
    int i=0;
        while (i <VEnt.getjTableCandidato().getRowCount()) {
           modelo.removeRow(i);
               }
        modelo.addRow(new Object[]{"", "", "", "", "", ""});

    }

    private void CargarGridProy() throws SQLException 
    {
        DefaultTableModel modelo = (DefaultTableModel) VEnt.getjTableCandidato().getModel();
        int Fila=0;
        ResultSet carg;
       // DaoAsigCand daoAsig = new DaoAsigCand();
        DaoEntrevista daoEnt = new DaoEntrevista();
       carg = daoEnt.BuscarProy(VEnt.getjTextFieldBusq().getText().trim());
        
       if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            Cancelar();
            return;
        }
       
        do
        {
             Date fecha=carg.getDate("fecha");
            String desc=carg.getString("pdesc");
            String ent=carg.getString("enombre");
            String tipo=carg.getString("edesc");
            String cand=carg.getString("cnom");
            String cargo=carg.getString("cdesc");
            String obs=carg.getString("observaciones");
            
            VEnt.getjTableCandidato().setValueAt(fecha, Fila, 0);
            VEnt.getjTableCandidato().setValueAt(desc, Fila, 1);
            VEnt.getjTableCandidato().setValueAt(ent, Fila, 2);
            VEnt.getjTableCandidato().setValueAt(tipo, Fila, 3);
            VEnt.getjTableCandidato().setValueAt(cand, Fila, 4);
            VEnt.getjTableCandidato().setValueAt(cargo, Fila, 5);
            VEnt.getjTableCandidato().setValueAt(obs, Fila, 6);
            Fila++;
            modelo.addRow(new Object[]{"", "", "", "", "", ""});
        }while(carg.next());
    }
    
     private void CargarGridCand() throws SQLException 
    {
        DefaultTableModel modelo = (DefaultTableModel) VEnt.getjTableCandidato().getModel();
        int Fila=0;
        ResultSet carg;
      
        DaoEntrevista daoEnt = new DaoEntrevista();
        String id=VEnt.getjTextFieldBusq().getText().trim();
       carg = daoEnt.BuscarCand(id);
        
       if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            Cancelar();
            return;
        }
       
        do
        {
             Date fecha=carg.getDate("fecha");
            String desc=carg.getString("pdesc");
            String ent=carg.getString("enombre");
            String tipo=carg.getString("edesc");
            String cand=carg.getString("cnom");
            String cargo=carg.getString("cdesc");
            String obs=carg.getString("observaciones");
            
            VEnt.getjTableCandidato().setValueAt(fecha, Fila, 0);
            VEnt.getjTableCandidato().setValueAt(desc, Fila, 1);
            VEnt.getjTableCandidato().setValueAt(ent, Fila, 2);
            VEnt.getjTableCandidato().setValueAt(tipo, Fila, 3);
            VEnt.getjTableCandidato().setValueAt(cand, Fila, 4);
            VEnt.getjTableCandidato().setValueAt(cargo, Fila, 5);
            VEnt.getjTableCandidato().setValueAt(obs, Fila, 6);
            Fila++;
            modelo.addRow(new Object[]{"", "", "", "", "", ""});
        }while(carg.next());
    }
     
     private void CargarGridFecha() throws SQLException 
    {
        DefaultTableModel modelo = (DefaultTableModel) VEnt.getjTableCandidato().getModel();
        int Fila=0;
        ResultSet carg;
       // DaoAsigCand daoAsig = new DaoAsigCand();
        DaoEntrevista daoEnt = new DaoEntrevista();
     
       carg = daoEnt.buscarEnt(VEnt.getjDateChooserFecInicial().getDate(), VEnt.getjDateChooserFecFinal().getDate());
        
       if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            Cancelar();
            return;
        }
       
        do
        {
             Date fecha=carg.getDate("fecha");
            String desc=carg.getString("pdesc");
            String ent=carg.getString("enombre");
            String tipo=carg.getString("edesc");
            String cand=carg.getString("cnom");
            String cargo=carg.getString("cdesc");
            String obs=carg.getString("observaciones");
            
            VEnt.getjTableCandidato().setValueAt(fecha, Fila, 0);
            VEnt.getjTableCandidato().setValueAt(desc, Fila, 1);
            VEnt.getjTableCandidato().setValueAt(ent, Fila, 2);
            VEnt.getjTableCandidato().setValueAt(tipo, Fila, 3);
            VEnt.getjTableCandidato().setValueAt(cand, Fila, 4);
            VEnt.getjTableCandidato().setValueAt(cargo, Fila, 5);
            VEnt.getjTableCandidato().setValueAt(obs, Fila, 6);
            Fila++;
            modelo.addRow(new Object[]{"", "", "", "", "", ""});
        }while(carg.next());
    }
     
     private void CargarGridFecNom() throws SQLException 
    {
        DefaultTableModel modelo = (DefaultTableModel) VEnt.getjTableCandidato().getModel();
        int Fila=0;
        ResultSet carg;
       
        DaoEntrevista daoEnt = new DaoEntrevista();
     
       carg = daoEnt.buscarFecNom(VEnt.getjDateChooserFecInicial().getDate(), VEnt.getjDateChooserFecFinal().getDate(), VEnt.getjTextFieldBusq().getText());
        
       if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            Cancelar();
            return;
        }
       
        do
        {
             Date fecha=carg.getDate("fecha");
            String desc=carg.getString("pdesc");
            String ent=carg.getString("enombre");
            String tipo=carg.getString("edesc");
            String cand=carg.getString("cnom");
            String cargo=carg.getString("cdesc");
            String obs=carg.getString("observaciones");
            
            VEnt.getjTableCandidato().setValueAt(fecha, Fila, 0);
            VEnt.getjTableCandidato().setValueAt(desc, Fila, 1);
            VEnt.getjTableCandidato().setValueAt(ent, Fila, 2);
            VEnt.getjTableCandidato().setValueAt(tipo, Fila, 3);
            VEnt.getjTableCandidato().setValueAt(cand, Fila, 4);
            VEnt.getjTableCandidato().setValueAt(cargo, Fila, 5);
            VEnt.getjTableCandidato().setValueAt(obs, Fila, 6);
            Fila++;
            modelo.addRow(new Object[]{"", "", "", "", "", ""});
        }while(carg.next());
    }
     
     
       private void cargarGridFecProy() throws SQLException 
    {
        DefaultTableModel modelo = (DefaultTableModel) VEnt.getjTableCandidato().getModel();
        int Fila=0;
        ResultSet carg;
       // DaoAsigCand daoAsig = new DaoAsigCand();
        DaoEntrevista daoEnt = new DaoEntrevista();
     
       carg = daoEnt.buscarFechProy(VEnt.getjDateChooserFecInicial().getDate(), VEnt.getjDateChooserFecFinal().getDate(), VEnt.getjTextFieldBusq().getText());
        
       if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            Cancelar();
            return;
        }
       
        do
        {
             Date fecha=carg.getDate("fecha");
            String desc=carg.getString("pdesc");
            String ent=carg.getString("enombre");
            String tipo=carg.getString("edesc");
            String cand=carg.getString("cnom");
            String cargo=carg.getString("cdesc");
            String obs=carg.getString("observaciones");
            
            VEnt.getjTableCandidato().setValueAt(fecha, Fila, 0);
            VEnt.getjTableCandidato().setValueAt(desc, Fila, 1);
            VEnt.getjTableCandidato().setValueAt(ent, Fila, 2);
            VEnt.getjTableCandidato().setValueAt(tipo, Fila, 3);
            VEnt.getjTableCandidato().setValueAt(cand, Fila, 4);
            VEnt.getjTableCandidato().setValueAt(cargo, Fila, 5);
            VEnt.getjTableCandidato().setValueAt(obs, Fila, 6);
            Fila++;
            modelo.addRow(new Object[]{"", "", "", "", "", ""});
        }while(carg.next());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource().equals(VEnt.getjButtonCancelar()))
        {
            Cancelar();
            VEnt.getjTextFieldBusq().setEnabled(false);
            return;
        }
   
     
     if(e.getSource().equals(VEnt.getjComboBoxBusqEnt()))
     {
               VEnt.getjTextFieldBusq().setEnabled(true);
                VEnt.getjButtonCancelar().setEnabled(true);
          
     }
     
     
        if(e.getSource().equals(VEnt.getjRadioButtonFecha()))
        {
            if(VEnt.getjRadioButtonFecha().isSelected())
            {
            VEnt.getjDateChooserFecFinal().setEnabled(true);
            VEnt.getjDateChooserFecInicial().setEnabled(true);
            VEnt.getjButtonBuscar().setEnabled(true);
            VEnt.getjButtonCancelar().setEnabled(true);
          
            }

        }
        if(e.getSource().equals(VEnt.getjButtonRegresar()))
        {
            VEnt.dispose();
        }
        
        if(e.getSource().equals(VEnt.getjButtonBuscar()))
        {
           
             if(VEnt.getjRadioButtonFecha().isSelected())
        {
            
             if(VEnt.getjDateChooserFecInicial().getDate()==null)
            {
                Rutinas.Aviso("Debe colocar una fecha de inicio para la búsqueda", "Advertencia");
                return;
            }
             if(VEnt.getjDateChooserFecFinal().getDate()==null)
            {
                Rutinas.Aviso("Debe colocar una fecha final para la búsqueda", "Advertencia");
                return;
            }
             
             if(VEnt.getjDateChooserFecFinal().getDate().before(VEnt.getjDateChooserFecInicial().getDate()))
             {
                 Rutinas.Aviso("La fecha final no deber ser menor que la fecha inicial", "Advertencia");
                 return;
             }
     
        }
        else
        {
             if(VEnt.getjTextFieldBusq().getText().length()==0)
            {
                Rutinas.Aviso("Debe llenar el campo de búsqueda", "");
                return;
            }
        }
        VEnt.getjTextFieldBusq().setEnabled(false);
        VEnt.getjComboBoxBusqEnt().setEnabled(false);
        VEnt.getjButtonBuscar().setEnabled(false);
        VEnt.getjRadioButtonFecha().setEnabled(false);
        VEnt.getjDateChooserFecFinal().setEnabled(false);
        VEnt.getjDateChooserFecInicial().setEnabled(false);
            
            if(VEnt.getjRadioButtonFecha().isSelected()&& (VEnt.getjComboBoxBusqEnt().getSelectedIndex()==0))
            {
                try {
                                CargarGridFecha();
                            } catch (SQLException ex) {
                                Logger.getLogger(CConsultarEntrevista.class.getName()).log(Level.SEVERE, null, ex);
                            }
                return;
            }
            
            if(VEnt.getjRadioButtonFecha().isSelected() && (VEnt.getjComboBoxBusqEnt().getSelectedIndex()==1))
            {
                try {
                    CargarGridFecNom();
                } catch (SQLException ex) {
                    Logger.getLogger(CConsultarEntrevista.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
            }
            else
            {
                if(VEnt.getjRadioButtonFecha().isSelected() && (VEnt.getjComboBoxBusqEnt().getSelectedIndex()==2))
                {     
                    try {
                        cargarGridFecProy();
                    } catch (SQLException ex) {
                        Logger.getLogger(CConsultarEntrevista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                return;
                }
            }
            
            if(!VEnt.getjRadioButtonFecha().isSelected())
            {   
                
                
                if(VEnt.getjComboBoxBusqEnt().getSelectedIndex()==2)
                {
                    try {
                        CargarGridProy();
                    } catch (SQLException ex) {
                        Logger.getLogger(CConsultarEntrevista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return;
                }
                else
                {
                    if(VEnt.getjComboBoxBusqEnt().getSelectedIndex()==1)
                    {
                        try {
                            CargarGridCand();
                        } catch (SQLException ex) {
                            Logger.getLogger(CConsultarEntrevista.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return;
                    }
                  
                }
                
            }
           
            
        } 
        
    }

    private void  NombreskeyTyped(KeyEvent e)
{
        if (VEnt.getjTextFieldBusq().getText().trim().length()==20)  
    {
         e.consume(); 
    }
} 
    
    private void DateChooserKeyTyped(KeyEvent e)
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
    
    
private void  codigokeyTyped(KeyEvent e)
{
  if (VEnt.getjTextFieldBusq().getText().trim().length()==10)  
   {
       
              
     e.consume(); 
   }  
  
  
}  
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(VEnt.getjTextFieldBusq()))
    {
        
     NombreskeyTyped(e);   
        VEnt.getjButtonBuscar().setEnabled(true);
        VEnt.getjButtonCancelar().setEnabled(true);
        
        if(VEnt.getjComboBoxBusqEnt().getSelectedIndex()==2)
        {
            codigokeyTyped(e);
        }
        else
            NombreskeyTyped(e);
        
    }
        
        
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
           }

    @Override
    public void keyReleased(KeyEvent e) {
          }

    private void CargarGridFec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    