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

import Dao.DaoFalta;
import Libreria.Rutinas;
import Vista.VConsultaFalta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class CConsultaFalta implements ActionListener, KeyListener
{
    private VConsultaFalta formConsultaFalta;
        public CConsultaFalta()
        {
            formConsultaFalta = new VConsultaFalta();
            formConsultaFalta.agregarListener(this);
            formConsultaFalta.setVisible(true);
            formConsultaFalta.getjTextFieldFiltroBusq().addKeyListener(this);
            formConsultaFalta.getjTableFaltas().setEnabled(false);
            cancelar();
            //habilitarConsultaFalta(false);
            //habilitarFechas(false);
            limpiarTabla();
            
            formConsultaFalta.getjDateChooserFechaI().getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                DateChooserFechasKeyTyped(ke);
            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {

            }
        
         });
            
            formConsultaFalta.getjDateChooserFechaF().getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                DateChooserFechasKeyTyped(ke);
            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {

            }
        
         });
        }
            
        private void habilitarConsultaFalta(boolean estado)
    {    
        formConsultaFalta.getjButtonBuscar().setEnabled(estado);
        formConsultaFalta.getjButtonCancelar().setEnabled(estado);
               
    }
        
        private void habilitarBusqCmb(boolean estado)
        {
        formConsultaFalta.getjTextFieldFiltroBusq().setEditable(estado);
        }
        
        private void habilitarBusqueda(boolean estado)
        {
            formConsultaFalta.getjComboBoxFiltroBusq().setEnabled(estado);
            formConsultaFalta.getjRadioButtonFiltroBusq().setEnabled(estado);
            
        }
        
        private void habilitarFechas(boolean estado)
        {
            formConsultaFalta.getjDateChooserFechaI().setEnabled(estado);
            formConsultaFalta.getjDateChooserFechaF().setEnabled(estado);
        }
        
        private void cancelar()
        {
            formConsultaFalta.getjTextFieldFiltroBusq().setText("");
            formConsultaFalta.getjTextFieldFiltroBusq().setEditable(false);
            formConsultaFalta.getjButtonBuscar().setEnabled(false);
            formConsultaFalta.getjButtonCancelar().setEnabled(false);
            formConsultaFalta.getjComboBoxFiltroBusq().setSelectedIndex(0);
            formConsultaFalta.getjRadioButtonFiltroBusq().setEnabled(true);
            formConsultaFalta.getjRadioButtonFiltroBusq().setSelected(false);
            formConsultaFalta.getjDateChooserFechaI().setCalendar(null);
            formConsultaFalta.getjDateChooserFechaF().setCalendar(null);
            formConsultaFalta.getjDateChooserFechaI().getDateEditor().setEnabled(false);
            formConsultaFalta.getjDateChooserFechaF().getDateEditor().setEnabled(false);
            formConsultaFalta.getjDateChooserFechaI().setEnabled(false);
            formConsultaFalta.getjDateChooserFechaF().setEnabled(false);
            formConsultaFalta.getjButtonBuscar().setEnabled(true);
            habilitarConsultaFalta(false);
            habilitarBusqueda(true);
            formConsultaFalta.getjComboBoxFiltroBusq().requestFocusInWindow();
            limpiarTabla();
        }
        
        private void limpiarTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel) formConsultaFalta.getjTableFaltas().getModel();
    int i=0;
        while (i <formConsultaFalta.getjTableFaltas().getRowCount()) {
           modelo.removeRow(i);
               }
        modelo.addRow(new Object[]{"", "", "", "", ""});

    }
        
        private void cargarGridEmpleado() throws SQLException
        {
            
            int Fila=0;
            ResultSet carg;
            DefaultTableModel modelo = (DefaultTableModel) formConsultaFalta.getjTableFaltas().getModel();
            DaoFalta daoFalta = new DaoFalta();
            carg = daoFalta.buscarxEmpleado(formConsultaFalta.getjTextFieldFiltroBusq().getText().trim());
            
            if(!carg.next())
            {
                Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
                cancelar();
            }
            
            do
            {
                Date fecha=carg.getDate("fecha");
                String fechaConver=Rutinas.FormatoFecha(fecha);
                String idcand=carg.getString("cid");
                String nom=carg.getString("nombre").trim() + " " + carg.getString("apellido").trim();
                String mot=carg.getString("descripcion").trim();
                String tip=carg.getString("ptipo");
                int canth=carg.getInt("cantidadhoras");
                
                formConsultaFalta.getjTableFaltas().setValueAt(fechaConver, Fila, 0);
                formConsultaFalta.getjTableFaltas().setValueAt(idcand, Fila, 1);
                formConsultaFalta.getjTableFaltas().setValueAt(nom, Fila, 2);
                formConsultaFalta.getjTableFaltas().setValueAt(mot, Fila, 3);
                formConsultaFalta.getjTableFaltas().setValueAt(tip, Fila, 4);
                formConsultaFalta.getjTableFaltas().setValueAt(canth, Fila, 5);
                Fila++;
                modelo.addRow(new Object[]{"", "", "", "", ""});
            }while(carg.next());          
        }
        
        private void cargarGridFecha() throws SQLException
        {
            int Fila=0;
            ResultSet carg;
            DefaultTableModel modelo = (DefaultTableModel) formConsultaFalta.getjTableFaltas().getModel();
            DaoFalta daoFalta = new DaoFalta();
            carg = daoFalta.buscarxFecha(formConsultaFalta.getjDateChooserFechaI().getDate(),
                                         formConsultaFalta.getjDateChooserFechaF().getDate());
            if(!carg.next())
            {
                Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
                cancelar();
            }
            
            do
            {
                Date fecha=carg.getDate("fecha");
                String fechaConver=Rutinas.FormatoFecha(fecha);
                String idcand=carg.getString("cid");
                String nom=carg.getString("nombre").trim() + " " + carg.getString("apellido").trim();
                String mot=carg.getString("descripcion").trim();
                String tip=carg.getString("ptipo");
                int canth=carg.getInt("cantidadhoras");
                
                formConsultaFalta.getjTableFaltas().setValueAt(fechaConver, Fila, 0);
                formConsultaFalta.getjTableFaltas().setValueAt(idcand, Fila, 1);
                formConsultaFalta.getjTableFaltas().setValueAt(nom, Fila, 2);
                formConsultaFalta.getjTableFaltas().setValueAt(mot, Fila, 3);
                formConsultaFalta.getjTableFaltas().setValueAt(tip, Fila, 4);
                formConsultaFalta.getjTableFaltas().setValueAt(canth, Fila, 5);
                Fila++;
                modelo.addRow(new Object[]{"", "", "", "", ""});                
            }while(carg.next());
        }
        
        private void cargarGridEmpFecha() throws SQLException
        {
            int Fila=0;
            ResultSet carg;
            DefaultTableModel modelo = (DefaultTableModel) formConsultaFalta.getjTableFaltas().getModel();
            DaoFalta daoFalta = new DaoFalta();
            carg = daoFalta.buscarxEmpFecha(formConsultaFalta.getjDateChooserFechaI().getDate(),
                                         formConsultaFalta.getjDateChooserFechaF().getDate(), 
                                         formConsultaFalta.getjTextFieldFiltroBusq().getText());
            if(!carg.next())
            {
                Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
                cancelar();
            }
            
            do
            {
                Date fecha=carg.getDate("fecha");
                String fechaConver=Rutinas.FormatoFecha(fecha);
                String idcand=carg.getString("cid");
                String nom=carg.getString("nombre").trim() + " " + carg.getString("apellido").trim();
                String mot=carg.getString("descripcion").trim();
                String tip=carg.getString("ptipo");
                int canth=carg.getInt("cantidadhoras");
                
                formConsultaFalta.getjTableFaltas().setValueAt(fechaConver, Fila, 0);
                formConsultaFalta.getjTableFaltas().setValueAt(idcand, Fila, 1);
                formConsultaFalta.getjTableFaltas().setValueAt(nom, Fila, 2);
                formConsultaFalta.getjTableFaltas().setValueAt(mot, Fila, 3);
                formConsultaFalta.getjTableFaltas().setValueAt(tip, Fila, 4);
                formConsultaFalta.getjTableFaltas().setValueAt(canth, Fila, 5);
                Fila++;
                modelo.addRow(new Object[]{"", "", "", "", ""});                
            }while(carg.next());
        }
        
        private void buscar()
        {
            if(formConsultaFalta.getjTextFieldFiltroBusq().getText().length()==0 &&
                    (formConsultaFalta.getjComboBoxFiltroBusq().getSelectedIndex()==1))
            {
                    Rutinas.Aviso("Dato de busqueda vacio", "");
                    formConsultaFalta.getjTextFieldFiltroBusq().requestFocusInWindow();
                    return;
                }
            
            if(formConsultaFalta.getjComboBoxFiltroBusq().getSelectedIndex()==1 &&
                    (!formConsultaFalta.getjRadioButtonFiltroBusq().isSelected()))
            {
                try {
                    cargarGridEmpleado();
                    habilitarBusqueda(false);
                    habilitarConsultaFalta(false);
                    habilitarBusqCmb(false);
                    formConsultaFalta.getjButtonCancelar().setEnabled(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CConsultaFalta.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            if(formConsultaFalta.getjRadioButtonFiltroBusq().isSelected() &&
                    (formConsultaFalta.getjComboBoxFiltroBusq().getSelectedIndex()==1))
            {
                try {
                    cargarGridEmpFecha();
                } catch (SQLException ex) {
                    Logger.getLogger(CConsultaFalta.class.getName()).log(Level.SEVERE, null, ex);
                }
                habilitarBusqueda(false);
                habilitarConsultaFalta(false);
                habilitarBusqCmb(false);
                formConsultaFalta.getjButtonCancelar().setEnabled(true);
            }
            
            if(formConsultaFalta.getjRadioButtonFiltroBusq().isSelected())
        {
            
             if(formConsultaFalta.getjDateChooserFechaI().getDate()==null)
            {
                Rutinas.Aviso("Debe colocar una fecha de inicio para la búsqueda", "Advertencia");
                return;
            }
             if(formConsultaFalta.getjDateChooserFechaF().getDate()==null)
            {
                Rutinas.Aviso("Debe colocar una fecha final para la búsqueda", "Advertencia");
                return;
            }
             
             if(formConsultaFalta.getjDateChooserFechaF().getDate().before(formConsultaFalta.getjDateChooserFechaI().getDate()))
             {
                 Rutinas.Aviso("La fecha final no deber ser menor que la fecha inicial", "Advertencia");
                 return;
             }
             
             if(formConsultaFalta.getjRadioButtonFiltroBusq().isSelected() && 
                     (formConsultaFalta.getjComboBoxFiltroBusq().getSelectedIndex()==0))
             {
                 try {
                    cargarGridFecha();
                    habilitarBusqueda(false);
                    habilitarConsultaFalta(false);
                    habilitarBusqCmb(false);
                    formConsultaFalta.getjButtonCancelar().setEnabled(true);
                 } catch (SQLException ex) {
                     Logger.getLogger(CConsultaFalta.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
     
        }
            
            
        }
            
            
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(formConsultaFalta.getjButtonBuscar()))
        {
            buscar();
        }
        
        if (ae.getSource().equals(formConsultaFalta.getjButtonCancelar()))
        {
            cancelar();
        }
        
        if (ae.getSource().equals(formConsultaFalta.getjButtonRegresar()))
        {
            formConsultaFalta.dispose();
        }
        
        if(ae.getSource().equals(formConsultaFalta.getjComboBoxFiltroBusq()))
        {
            if(formConsultaFalta.getjComboBoxFiltroBusq().getSelectedIndex()==1)
            {
                habilitarConsultaFalta(true);
                habilitarBusqCmb(true);
                formConsultaFalta.getjTextFieldFiltroBusq().requestFocusInWindow();
            }
            
        }
        
        if(ae.getSource().equals(formConsultaFalta.getjRadioButtonFiltroBusq()))
        {
            if(formConsultaFalta.getjRadioButtonFiltroBusq().isSelected())
            {
                habilitarFechas(true);
                habilitarConsultaFalta(true);
            }
        }
    }

    
    private void DateChooserFechasKeyTyped(KeyEvent ke)
    {
        char tecla;
        tecla=ke.getKeyChar();
  
        if (tecla=='/')
        return;   
  
        if (tecla<'0' || tecla>'9')
        ke.consume();
    }
    
    
    public void FiltroBusqKeyTyped(KeyEvent ke)
    {
        if (formConsultaFalta.getjTextFieldFiltroBusq().getText().trim().length()==20)
        {
            ke.consume();
        }
    }
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
                
        if (ke.getSource().equals(formConsultaFalta.getjTextFieldFiltroBusq()))
        {
            FiltroBusqKeyTyped(ke);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

  
}
