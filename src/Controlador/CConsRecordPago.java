/*
*    Proyecto de Laboratorio 1 (Sección 1)
*     Integrantes:
*     Canelon Valmore CI:
*     Cohen Kevin  CI:
*     Jiménez Jaimary CI: 22263583
*     Lugo Brisleidy CI:
*     Serrano Joselyn CI:
*/
package Controlador;

import Controlador.*;
import Dao.DaoNomina;
import Vista.VConsultaRecord;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CConsRecordPago implements ActionListener, KeyListener{
    
    private VConsultaRecord vCRecord;

    public CConsRecordPago() {
        
        vCRecord= new VConsultaRecord();
        vCRecord.agregarListener(this);
        vCRecord.setVisible(true); 
        vCRecord.getjTextFieldTotalPagado().setEditable(false);
     
        cancelar();
                
    }
    

    private void cancelar()
    {
        Calendar cal=new GregorianCalendar();
        int mes=cal.get(Calendar.MONTH);
        int anno=cal.get(Calendar.YEAR);
        vCRecord.getjTextFieldTotalPagado().setText("");
        vCRecord.getjTextFieldBusq().setText("");
        vCRecord.getjComboBoxBusqrecord().setSelectedIndex(0);
        vCRecord.getjComboBoxBusqrecord().setEnabled(true);
        vCRecord.getjButtonBuscar().setEnabled(true);
        vCRecord.getjButtonCancelar().setEnabled(false);
        vCRecord.getjTextFieldBusq().setEditable(true);
        vCRecord.getjRadioButtonbusqmes().setSelected(false);
        vCRecord.getjMonthChooserMeses().setEnabled(false);
        vCRecord.getjMonthChooserMeses().setMonth(mes);
        vCRecord.getjYearChooserRecord().setYear(anno);
        vCRecord.getjYearChooserRecord().setEnabled(false);
        vCRecord.getjRadioButtonbusqmes().setEnabled(true);
        vCRecord.getjYearChooserRecord().setMaximum(anno);
        vCRecord.getjTextFieldBusq().setRequestFocusEnabled(true);
        limpiarTabla();
        
    }
    
    private void CargarGridEmpleado() throws SQLException
    {
        int Fila=0;
        ResultSet carg;
       DefaultTableModel modelo = (DefaultTableModel) 
               vCRecord.getjTableRecord().getModel();
        DaoNomina daoNom = new DaoNomina();
       carg = daoNom.buscarxemp(vCRecord.getjTextFieldBusq().getText().trim());
        
       if(!carg.next())
        {
             JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
            cancelar();
            return;
        }
       else
       { float record=0;
        do
        {
             String id=carg.getString("identificador");
            String nombre=carg.getString("nombre");
            String apel=carg.getString("apellido");
            float pago=carg.getFloat("montoneto");
           
            
            vCRecord.getjTableRecord().setValueAt(id, Fila, 0);
            vCRecord.getjTableRecord().setValueAt(nombre, Fila, 1);
            vCRecord.getjTableRecord().setValueAt(apel, Fila, 2);
            vCRecord.getjTableRecord().setValueAt(pago, Fila, 3);
            
            record+=pago;
            Fila++;
            modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String monto= String.valueOf(record);
        vCRecord.getjTextFieldTotalPagado().setText(monto);
        
        
     }
        
    }
    
    private void limpiarTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel)
                vCRecord.getjTableRecord().getModel();
    int i=0;
        while (i <vCRecord.getjTableRecord().getRowCount()) {
           modelo.removeRow(i);
               }
        modelo.addRow(new Object[]{"", "", "", ""});

    }
    
    
    
    private void CargarGridProyecto() throws SQLException
    {
       
        int Fila=0;
        ResultSet carg;
        DefaultTableModel modelo = (DefaultTableModel)
                vCRecord.getjTableRecord().getModel();
        DaoNomina daoNom = new DaoNomina();
        
        String busq=vCRecord.getjTextFieldBusq().getText().trim();
        carg = daoNom.buscarxproy(busq);
        
        if(!carg.next())
        {
            JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
            cancelar();
            return;
        }
        else{
            float record=0;
        do
        {
            String id=carg.getString("identificador");
            String nombre=carg.getString("nombre");
            String apel=carg.getString("apellido");
            float pago=carg.getFloat("montoneto");
           
            
            vCRecord.getjTableRecord().setValueAt(id, Fila, 0);
            vCRecord.getjTableRecord().setValueAt(nombre, Fila, 1);
            vCRecord.getjTableRecord().setValueAt(apel, Fila, 2);
            vCRecord.getjTableRecord().setValueAt(pago, Fila, 3);
            record+=pago;
            Fila++;
         modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String monto= String.valueOf(record);
        vCRecord.getjTextFieldTotalPagado().setText(monto);
        }
    
       
        
    }
    private void CargarGridMes() throws SQLException
    {
        DefaultTableModel modelo = (DefaultTableModel) vCRecord.getjTableRecord().getModel();
      
        int anno= vCRecord.getjYearChooserRecord().getYear();
        int Fila=0;
       
       
        DaoNomina daoNom= new DaoNomina();
        ResultSet carg;
        int mes = vCRecord.getjMonthChooserMeses().getMonth()+1;
        carg = daoNom.buscarxmes(mes,anno);
        
        if(!carg.next())
        {
            JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
            return;
        }
        else
        { float record=0;
        do
        {
            String id=carg.getString("identificador");
            String nombre=carg.getString("nombre");
            String apel=carg.getString("apellido");
            float pago=carg.getFloat("montoneto");
        
            vCRecord.getjTableRecord().setValueAt(id, Fila, 0);
            vCRecord.getjTableRecord().setValueAt(nombre, Fila, 1);
            vCRecord.getjTableRecord().setValueAt(apel, Fila, 2);
            vCRecord.getjTableRecord().setValueAt(pago, Fila, 3);     
            record+=pago;
            Fila++;
           modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String monto= String.valueOf(record);
        vCRecord.getjTextFieldTotalPagado().setText(monto);
        }
        
       
    }
    
     private void CargarGridMesxEmp() throws SQLException
    {
        DefaultTableModel modelo = (DefaultTableModel) 
                vCRecord.getjTableRecord().getModel();
        
        int anno= vCRecord.getjYearChooserRecord().getYear();
        int Fila=0;
       
       
        DaoNomina daoNom= new DaoNomina();
        ResultSet carg;
        int mes = vCRecord.getjMonthChooserMeses().getMonth()+1;
        String emp=vCRecord.getjTextFieldBusq().getText().trim();
        carg = daoNom.buscarxMesyEmp(mes,anno,emp);
        
        if(!carg.next())
        {
            JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
            cancelar();
            return;
        }
        else
        {
            float record=0;
        do
        {
            String id=carg.getString("identificador");
            String nombre=carg.getString("nombre");
            String apel=carg.getString("apellido");
            float pago=carg.getFloat("montoneto");
        
            vCRecord.getjTableRecord().setValueAt(id, Fila, 0);
            vCRecord.getjTableRecord().setValueAt(nombre, Fila, 1);
            vCRecord.getjTableRecord().setValueAt(apel, Fila, 2);
            vCRecord.getjTableRecord().setValueAt(pago, Fila, 3);     
            record+=pago;
            Fila++;
             modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String monto= String.valueOf(record);
        vCRecord.getjTextFieldTotalPagado().setText(monto);
        }
       
    }
     
      private void CargarGridMesxProy() throws SQLException
    {
        DefaultTableModel modelo = (DefaultTableModel) 
                vCRecord.getjTableRecord().getModel();
     
        int anno= vCRecord.getjYearChooserRecord().getYear();
        int Fila=0;
       
       
        DaoNomina daoNom= new DaoNomina();
        ResultSet carg;
        int mes = vCRecord.getjMonthChooserMeses().getMonth()+1;
        String proy=vCRecord.getjTextFieldBusq().getText().trim();
        carg = daoNom.buscarxMesyProy(mes,anno,proy);
        
        if(!carg.next())
        {
            JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
            cancelar();
            return;
        }
        else
        { float record=0;
        do
        {
            String id=carg.getString("identificador");
            String nombre=carg.getString("nombre");
            String apel=carg.getString("apellido");
            float pago=carg.getFloat("montoneto");
        
            vCRecord.getjTableRecord().setValueAt(id, Fila, 0);
            vCRecord.getjTableRecord().setValueAt(nombre, Fila, 1);
            vCRecord.getjTableRecord().setValueAt(apel, Fila, 2);
            vCRecord.getjTableRecord().setValueAt(pago, Fila, 3);     
            record+=pago;
            Fila++;
             modelo.addRow(new Object[]{"", "", "", ""});
        }while(carg.next());
        String monto= String.valueOf(record);
        vCRecord.getjTextFieldTotalPagado().setText(monto);
        
        }
       
    }
      
    private void Buscar()
    {
          if(vCRecord.getjTextFieldBusq().getText().length()==0 && 
                  !vCRecord.getjRadioButtonbusqmes().isSelected()
                  && vCRecord.getjComboBoxBusqrecord().getSelectedIndex()==0)
          {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo de busqueda"
                                         + "o seleccionar un mes");
            cancelar();
            return;
          }
          else{
          
           deshabilitar(false);
           if((vCRecord.getjRadioButtonbusqmes().isSelected()) && 
                   (vCRecord.getjTextFieldBusq().getText().length()==0))
            {
            try {
                CargarGridMes();
            } catch (SQLException ex) {
                Logger.getLogger(CConsRecordPago.class.getName()).log(
                                 Level.SEVERE, null, ex);
            }
          
            }
            else
            {
                if((vCRecord.getjComboBoxBusqrecord().getSelectedIndex()==1) &&
                        (!vCRecord.getjRadioButtonbusqmes().isSelected()))
                {
                    try {
                        CargarGridProyecto();
                    } catch (SQLException ex) {
                        Logger.getLogger(CConsRecordPago.class.getName()).log(
                                         Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    if((vCRecord.getjComboBoxBusqrecord().getSelectedIndex()==2) &&
                        (!vCRecord.getjRadioButtonbusqmes().isSelected()))
                    {
                    try {
                        CargarGridEmpleado();
                    } catch (SQLException ex) {
                        Logger.getLogger(CConsRecordPago.class.getName()).log(
                                         Level.SEVERE, null, ex);
                    }
                    }
                    else
                    {
                        if((vCRecord.getjComboBoxBusqrecord().getSelectedIndex()==2) &&
                        (vCRecord.getjRadioButtonbusqmes().isSelected()))
                        {
                           try {
                            CargarGridMesxEmp();
                           } catch (SQLException ex) {
                           Logger.getLogger(CConsRecordPago.class.getName()).log(
                                            Level.SEVERE, null, ex);
                        }
                        }
                        else
                        {
                            try {
                                CargarGridMesxProy();
                            } catch (SQLException ex) {
                                Logger.getLogger(CConsRecordPago.class.getName()).log(
                                                 Level.SEVERE, null, ex);
                            }
                                
                        }
                       
                    
                  
                  }
                }
            }
        }
           
    }      
    private void deshabilitar(boolean estado)
    {
         vCRecord.getjTextFieldBusq().setEditable(estado);
         vCRecord.getjComboBoxBusqrecord().setEnabled(estado);
         vCRecord.getjMonthChooserMeses().setEnabled(estado);
         vCRecord.getjYearChooserRecord().setEnabled(estado);
         vCRecord.getjRadioButtonbusqmes().setEnabled(estado);
         vCRecord.getjButtonBuscar().setEnabled(estado);
         vCRecord.getjButtonCancelar().setEnabled(!estado);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vCRecord.getjButtonCancelar()))
        {
            cancelar();
            return;
        }
        
        
        if(e.getSource().equals(vCRecord.getjButtonBuscar()))
        {
              Buscar(); 
              vCRecord.getjButtonCancelar().setEnabled(true);
                    
            
        }
        if(e.getSource().equals(vCRecord.getjButtonRegresar()))
        {
            vCRecord.dispose();
        }
        
        if(e.getSource().equals(vCRecord.getjComboBoxBusqrecord()))
        {
            if(vCRecord.getjComboBoxBusqrecord().getSelectedIndex()==0)
            {
                vCRecord.getjTextFieldBusq().setEditable(false);
                cancelar();
                return;
            }
            else
            {
                vCRecord.getjTextFieldBusq().setEnabled(true);
                
                 vCRecord.getjTextFieldBusq().setEditable(true);
                 vCRecord.getjButtonCancelar().setEnabled(true);
                 return;
            }
        }
        
    
    }
private void  NombreskeyTyped(KeyEvent e)
{
  if (vCRecord.getjTextFieldBusq().getText().trim().length()==10)  
   {
       
              
     e.consume(); 
   }  
}  

    public void BusqKeyTyped(KeyEvent e)
    {
        char car = e.getKeyChar();
        if(car==(char)KeyEvent.VK_SPACE)
            e.consume();
        
        
    }


    @Override 
    public void keyTyped(KeyEvent e) 
{
    if(e.getSource().equals(vCRecord.getjTextFieldBusq()))
    {
       
        NombreskeyTyped(e);
        vCRecord.getjButtonBuscar().setEnabled(true);
        
    }
    
    if(e.getSource().equals(vCRecord.getjComboBoxBusqrecord()))
    {
        BusqKeyTyped(e);
    }
}

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    private void CargarGridApellido() {
       // throw new UnsupportedOperationException("Not supported yet."); 
      //To change body of generated methods, choose Tools | Templates.
    }
}

