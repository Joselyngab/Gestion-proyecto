/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Dao.DaoNomina;
import Libreria.Rutinas;

import Vista.VConsultarHoT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author franc_000
 */
public class CConsHorasTrabajadas implements ActionListener, KeyListener
{
    private VConsultarHoT vHorasT;

    public CConsHorasTrabajadas() {
        Calendar cal=new GregorianCalendar();
        int anno=cal.get(Calendar.YEAR);
        vHorasT= new VConsultarHoT();
        vHorasT.agregarListener(this);
        vHorasT.setVisible(true); 
        vHorasT.getjTextFieldTotalPagado().setEditable(false);
        vHorasT.getjMonthChooserMeses().setEnabled(false);
        vHorasT.getjYearChooserRecord().setEnabled(false);
        vHorasT.getjButtonCancelar().setEnabled(false);
        vHorasT.getjYearChooserRecord().setMaximum(anno);
        vHorasT.getjTextFieldBusq().setRequestFocusEnabled(true);
        limpiarTabla();
                
    }
       private void cancelar()
    {
        Calendar cal=new GregorianCalendar();
        int mes=cal.get(Calendar.MONTH);
        int anno=cal.get(Calendar.YEAR);
         vHorasT.getjTextFieldTotalPagado().setText("");
         vHorasT.getjTextFieldBusq().setText("");
         vHorasT.getjComboBoxBusqrecord().setSelectedIndex(0);
         vHorasT.getjComboBoxBusqrecord().setEnabled(true);
         vHorasT.getjButtonBuscar().setEnabled(true);
         vHorasT.getjButtonCancelar().setEnabled(false);
         vHorasT.getjTextFieldBusq().setEditable(true);
         vHorasT.getjRadioButtonbusqmes().setSelected(false);
         vHorasT.getjMonthChooserMeses().setEnabled(false);
         vHorasT.getjMonthChooserMeses().setMonth(mes);
         vHorasT.getjYearChooserRecord().setYear(anno);
         vHorasT.getjYearChooserRecord().setEnabled(false);
         vHorasT.getjRadioButtonbusqmes().setEnabled(true);
         
         vHorasT.getjRadioButtonbusqmes().setEnabled(true);
        limpiarTabla();
        
    }
          private void limpiarTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel) vHorasT.getjTableHoras().getModel();
    int i=0;
        while (i <vHorasT.getjTableHoras().getRowCount()) {
           modelo.removeRow(i);
               }
        modelo.addRow(new Object[]{"", "", "", ""});

    }
          
          private void CargarGridProyecto() throws SQLException
    {
       
        int Fila=0;
        ResultSet carg;
        DefaultTableModel modelo = (DefaultTableModel) vHorasT.getjTableHoras().getModel();
        DaoNomina daoNom = new DaoNomina();
        
        String busq=vHorasT.getjTextFieldBusq().getText().trim();
        carg = daoNom.buscarxproy1(busq);
        
        if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            cancelar();
            return;
        }
        else{
            int horast=0;
        do
        {
            String id=carg.getString("identificador").trim();
            String nombre=carg.getString("nombre").trim();
            String apel=carg.getString("apellido").trim();
            int horas=carg.getInt("nrohorastrab");
           
            
            vHorasT.getjTableHoras().setValueAt(id, Fila, 0);
            vHorasT.getjTableHoras().setValueAt(nombre, Fila, 1);
            vHorasT.getjTableHoras().setValueAt(apel, Fila, 2);
            vHorasT.getjTableHoras().setValueAt(horas, Fila, 3);
            horast+=horas;
            Fila++;
         modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String total= String.valueOf(horast);
        vHorasT.getjTextFieldTotalPagado().setText(total);
        }
    
       
        
    }
   private void CargarGridEmpleado() throws SQLException
    {
        int Fila=0;
        ResultSet carg;
       DefaultTableModel modelo = (DefaultTableModel) vHorasT.getjTableHoras().getModel();
        DaoNomina daoNom = new DaoNomina();
       carg = daoNom.buscarxemp1(vHorasT.getjTextFieldBusq().getText().trim());
        
       if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            cancelar();
            return;
        }
       else
       { 
           int  horast=0;
        do
        {
             String id=carg.getString("identificador").trim();
            String nombre=carg.getString("nombre").trim();
            String apel=carg.getString("apellido").trim();
            int horas =carg.getInt("nrohorastrab");
           
            
            vHorasT.getjTableHoras().setValueAt(id, Fila, 0);
            vHorasT.getjTableHoras().setValueAt(nombre, Fila, 1);
            vHorasT.getjTableHoras().setValueAt(apel, Fila, 2);
            vHorasT.getjTableHoras().setValueAt(horas, Fila, 3);
            horast+=horas;
            Fila++;
            
            modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String total= String.valueOf(horast);
        vHorasT.getjTextFieldTotalPagado().setText(total);
        }         
        
    }
   private void CargarGridMes() throws SQLException
    {
        DefaultTableModel modelo = (DefaultTableModel) vHorasT.getjTableHoras().getModel();
      
        int anno= vHorasT.getjYearChooserRecord().getYear();
        int Fila=0;
       
       
        DaoNomina daoNom= new DaoNomina();
        ResultSet carg;
        int mes = vHorasT.getjMonthChooserMeses().getMonth()+1;
        carg = daoNom.buscarxmes1(mes,anno);
        
        if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            return;
        }
        else
       { 
           int  horast=0;
        do
        {
             String id=carg.getString("identificador").trim();
            String nombre=carg.getString("nombre").trim();
            String apel=carg.getString("apellido").trim();
            int horas =carg.getInt("nrohorastrab");
           
            
            vHorasT.getjTableHoras().setValueAt(id, Fila, 0);
            vHorasT.getjTableHoras().setValueAt(nombre, Fila, 1);
            vHorasT.getjTableHoras().setValueAt(apel, Fila, 2);
            vHorasT.getjTableHoras().setValueAt(horas, Fila, 3);
            horast+=horas;
            Fila++;
            
            modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String total= String.valueOf(horast);
        vHorasT.getjTextFieldTotalPagado().setText(total);
        }     
       
    }
    
     private void CargarGridMesxEmp() throws SQLException
    {
        DefaultTableModel modelo = (DefaultTableModel) vHorasT.getjTableHoras().getModel();
        
        int anno= vHorasT.getjYearChooserRecord().getYear();
        int Fila=0;
       
       
        DaoNomina daoNom= new DaoNomina();
        ResultSet carg;
        int mes = vHorasT.getjMonthChooserMeses().getMonth()+1;
        String emp=vHorasT.getjTextFieldBusq().getText().trim();
        carg = daoNom.buscarxMesyEmp1(mes,anno,emp);
        
        if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            return;
        }
       else
       { 
           int  horast=0;
        do
        {
             String id=carg.getString("identificador").trim();
            String nombre=carg.getString("nombre").trim();
            String apel=carg.getString("apellido").trim();
            int horas =carg.getInt("nrohorastrab");
           
            
            vHorasT.getjTableHoras().setValueAt(id, Fila, 0);
            vHorasT.getjTableHoras().setValueAt(nombre, Fila, 1);
            vHorasT.getjTableHoras().setValueAt(apel, Fila, 2);
            vHorasT.getjTableHoras().setValueAt(horas, Fila, 3);
            horast+=horas;
            Fila++;
            
            modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String total= String.valueOf(horast);
        vHorasT.getjTextFieldTotalPagado().setText(total);
        }         
       
    }
     
      private void CargarGridMesxProy() throws SQLException
    {
        DefaultTableModel modelo = (DefaultTableModel) vHorasT.getjTableHoras().getModel();
     
        int anno= vHorasT.getjYearChooserRecord().getYear();
        int Fila=0;
       
       
        DaoNomina daoNom= new DaoNomina();
        ResultSet carg;
        int mes = vHorasT.getjMonthChooserMeses().getMonth()+1;
        String proy=vHorasT.getjTextFieldBusq().getText().trim();
        carg = daoNom.buscarxMesyProy1(mes,anno,proy);
        
        if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            cancelar();
            return;
        }
        else
       { 
           int  horast=0;
        do
        {
             String id=carg.getString("identificador").trim();
            String nombre=carg.getString("nombre").trim();
            String apel=carg.getString("apellido").trim();
            int horas =carg.getInt("nrohorastrab");
           
            
            vHorasT.getjTableHoras().setValueAt(id, Fila, 0);
            vHorasT.getjTableHoras().setValueAt(nombre, Fila, 1);
            vHorasT.getjTableHoras().setValueAt(apel, Fila, 2);
            vHorasT.getjTableHoras().setValueAt(horas, Fila, 3);
            horast+=horas;
            Fila++;
            
            modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String total= String.valueOf(horast);
        vHorasT.getjTextFieldTotalPagado().setText(total);
        }         
       
    }
   
       private void Buscar()
    {
          if(vHorasT.getjTextFieldBusq().getText().length()==0 && 
                  (!vHorasT.getjRadioButtonbusqmes().isSelected()))
          {
            Rutinas.Aviso("Debe llenar el campo de búsqueda o seleccionar un mes", "");
          }
          else{
          
           deshabilitar(false);
           if((vHorasT.getjRadioButtonbusqmes().isSelected()) && 
                   (vHorasT.getjTextFieldBusq().getText().length()==0))
            {
            try {
                CargarGridMes();
            } catch (SQLException ex) {
                Logger.getLogger(CConsRecordPago.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            }
            else
            {
                if((vHorasT.getjComboBoxBusqrecord().getSelectedIndex()==1) &&
                        (!vHorasT.getjRadioButtonbusqmes().isSelected()))
                {
                    try {
                        CargarGridProyecto();
                    } catch (SQLException ex) {
                        Logger.getLogger(CConsRecordPago.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    if((vHorasT.getjComboBoxBusqrecord().getSelectedIndex()==2) &&
                        (!vHorasT.getjRadioButtonbusqmes().isSelected()))
                    {
                    try {
                        CargarGridEmpleado();
                    } catch (SQLException ex) {
                        Logger.getLogger(CConsRecordPago.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    else
                    {
                        if((vHorasT.getjComboBoxBusqrecord().getSelectedIndex()==2) &&
                        (vHorasT.getjRadioButtonbusqmes().isSelected()))
                        {
                           try {
                            CargarGridMesxEmp();
                           } catch (SQLException ex) {
                           Logger.getLogger(CConsRecordPago.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        else
                        {
                            try {
                                CargarGridMesxProy();
                            } catch (SQLException ex) {
                                Logger.getLogger(CConsRecordPago.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                
                        }
                       
                    
                  
                  }
                }
            }
        }
           
    }         
   
        private void deshabilitar(boolean estado)
     {    
         vHorasT.getjTextFieldBusq().setEditable(estado);
         vHorasT.getjComboBoxBusqrecord().setEnabled(estado);
         vHorasT.getjMonthChooserMeses().setEnabled(estado);
         vHorasT.getjYearChooserRecord().setEnabled(estado);
         vHorasT.getjRadioButtonbusqmes().setEnabled(estado);
         vHorasT.getjButtonBuscar().setEnabled(estado);
         vHorasT.getjButtonCancelar().setEnabled(!estado);
        
        
    }
    
          
    @Override
    public void actionPerformed(ActionEvent e) {
         
        if(e.getSource().equals(vHorasT.getjButtonCancelar()))
        {
            cancelar();
            return;
        }
        
        
        if(e.getSource().equals(vHorasT.getjButtonBuscar()))
        {
              Buscar(); 
              vHorasT.getjButtonCancelar().setEnabled(true);
                    
            
        }
        if(e.getSource().equals(vHorasT.getjButtonRegresar()))
        {
            vHorasT.dispose();
        }
        
        if(e.getSource().equals(vHorasT.getjComboBoxBusqrecord()))
        {
            if(vHorasT.getjComboBoxBusqrecord().getSelectedIndex()==0)
            {
                vHorasT.getjTextFieldBusq().setEditable(false);
                cancelar();
                return;
            }
            else
            {
                vHorasT.getjTextFieldBusq().setEnabled(true);
                
                 vHorasT.getjTextFieldBusq().setEditable(true);
                 vHorasT.getjButtonCancelar().setEnabled(true);
                 return;
            }
        }
        
    
    
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
