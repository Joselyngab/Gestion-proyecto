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

import Dao.DaoCandidato;
import Libreria.Rutinas;
import Vista.VConsultaCandidato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Joselyn
 */
public class CConsultaCandidato implements ActionListener, KeyListener{
    
    private VConsultaCandidato VCand;

    public CConsultaCandidato() throws SQLException {
        VCand = new VConsultaCandidato();
        VCand.agregarListener(this);
        VCand.setVisible(true);
       busqCand();
        
        VCand.getjTextFieldBusq().addKeyListener(this);
                
    }
    
    private void busqCand() throws SQLException
    {
        DaoCandidato daoC;
        daoC= new DaoCandidato();
        ResultSet busq;
        busq=daoC.bCandidato();
        
        if(!busq.next())
        {
            Rutinas.Aviso("No existen candidatos registrados", "");
            return;
        }
    }

    private void cancelar()
    {
        VCand.getjTextFieldBusq().setText("");
        VCand.getjComboBoxBusqCand().setSelectedIndex(0);
        VCand.getjComboBoxBusqCand().setEnabled(true);
        VCand.getjButtonBuscar().setEnabled(false);
        VCand.getjButtonCancelar().setEnabled(false);
        VCand.getjTextFieldBusq().setEnabled(false);
        limpiarTabla();
        
    }
    
    private void CargarGridPalabras() throws SQLException
    {
        int Fila=0;
        ResultSet carg;
       DefaultTableModel modelo = (DefaultTableModel) VCand.getjTableCandidato().getModel();
        DaoCandidato daoCand = new DaoCandidato();
       carg = daoCand.BuscarPalabra(VCand.getjTextFieldBusq().getText().trim().toString());
        
       if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            return;
        }
       
        do
        {
             String id=carg.getString("identificador").trim();
            String nombre=carg.getString("nombre").trim();
            String apel=carg.getString("apellido").trim();
            String tlf=carg.getString("telefono").trim();
            String correo=carg.getString("correo").trim();
            String nac=carg.getString("nacionalidad").trim();
            
            VCand.getjTableCandidato().setValueAt(id, Fila, 0);
            VCand.getjTableCandidato().setValueAt(nombre, Fila, 1);
            VCand.getjTableCandidato().setValueAt(apel, Fila, 2);
            VCand.getjTableCandidato().setValueAt(nac, Fila, 3);
            VCand.getjTableCandidato().setValueAt(tlf, Fila, 4);
            VCand.getjTableCandidato().setValueAt(correo, Fila, 5);

            
            Fila++;
            modelo.addRow(new Object[]{"", "", "", "", "", ""});
        }while(carg.next());
     
        
    }
    
    private void limpiarTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel) VCand.getjTableCandidato().getModel();
    int i=0;
        while (i <VCand.getjTableCandidato().getRowCount()) {
           modelo.removeRow(i);
               }
        modelo.addRow(new Object[]{"", "", "", "", "", ""});

    }
    
    
    
    private void CargarGridNombre() throws SQLException
    {
         DefaultTableModel modelo = (DefaultTableModel) VCand.getjTableCandidato().getModel();
        int Fila=0;
        ResultSet carg;
      
        DaoCandidato daoCand = new DaoCandidato();
        
        String busq=VCand.getjTextFieldBusq().getText().trim();
        carg = daoCand.BuscarNombre(busq);
        
        if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            cancelar();
            return;
        }
        
        do
        {
            String id=carg.getString("identificador").trim();
            String nombre=carg.getString("nombre").trim();
            String apel=carg.getString("apellido").trim();
            String tlf=carg.getString("telefono").trim();
            String correo=carg.getString("correo").trim();
            String nac=carg.getString("nacionalidad").trim();
            
            VCand.getjTableCandidato().setValueAt(id, Fila, 0);
            VCand.getjTableCandidato().setValueAt(nombre, Fila, 1);
            VCand.getjTableCandidato().setValueAt(apel, Fila, 2);
            VCand.getjTableCandidato().setValueAt(nac, Fila, 3);
            VCand.getjTableCandidato().setValueAt(tlf, Fila, 4);
            VCand.getjTableCandidato().setValueAt(correo, Fila, 5);

            Fila++;
            modelo.addRow(new Object[]{"", "", "", "", "", ""});
        }while(carg.next());
        
       
        
    }
    private void CargarGridApel() throws SQLException
    {
        int Fila=0;
        ResultSet carg;
       
        DaoCandidato daoCand = new DaoCandidato();
        carg = daoCand.BuscarApellido(VCand.getjTextFieldBusq().getText());
        
        if(!carg.next())
        {
            Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
            return;
        }
        
        do
        {
            String id=carg.getString("identificador").trim();
            String nombre=carg.getString("nombre").trim();
            String apel=carg.getString("apellido").trim();
            String tlf=carg.getString("telefono").trim();
            String correo=carg.getString("correo").trim();
            String nac=carg.getString("nacionalidad").trim();
                    
            
            
            VCand.getjTableCandidato().setValueAt(id, Fila, 0);
            VCand.getjTableCandidato().setValueAt(nombre, Fila, 1);
            VCand.getjTableCandidato().setValueAt(apel, Fila, 2);
            VCand.getjTableCandidato().setValueAt(nac, Fila, 3);
            VCand.getjTableCandidato().setValueAt(tlf, Fila, 4);
            VCand.getjTableCandidato().setValueAt(correo, Fila, 5);
            
            Fila++;
        }while(carg.next());
        
       
        
    }
    private void Buscar()
    {
        if(VCand.getjTextFieldBusq().getText().length()==0)
            Rutinas.Aviso("Debe llenar el campo de búsqueda", "");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(VCand.getjButtonCancelar()))
        {
            cancelar();
            return;
        }
        
        
        if(e.getSource().equals(VCand.getjButtonBuscar()))
        {
            Buscar();
            VCand.getjTextFieldBusq().setEnabled(false);
            VCand.getjButtonBuscar().setEnabled(false);
            VCand.getjComboBoxBusqCand().setEnabled(false);
            
            if(VCand.getjComboBoxBusqCand().getSelectedIndex()==3)
            {
            try {
                CargarGridPalabras();
            } catch (SQLException ex) {
                Logger.getLogger(CConsultaCandidato.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
            }
            else
            {
                if(VCand.getjComboBoxBusqCand().getSelectedIndex()==1)
                {
                    try {
                        CargarGridNombre();
                    } catch (SQLException ex) {
                        Logger.getLogger(CConsultaCandidato.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    if (VCand.getjComboBoxBusqCand().getSelectedIndex()==2)
                    {
                        try {
                            CargarGridApel();
                        } catch (SQLException ex) {
                                Logger.getLogger(CConsultaCandidato.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                    
                }
                    
            }
        }
        if(e.getSource().equals(VCand.getjButtonRegresar()))
        {
            VCand.dispose();
        }
        
        if(e.getSource().equals(VCand.getjComboBoxBusqCand()))
        {
            if(VCand.getjComboBoxBusqCand().getSelectedIndex()==0)
            {
                VCand.getjTextFieldBusq().setEnabled(false);
                cancelar();
                return;
            }
            else
            {
                VCand.getjTextFieldBusq().setEnabled(true);
                
                 
                 VCand.getjButtonCancelar().setEnabled(true);
                 return;
            }
        }
        
       
    }
private void  NombreskeyTyped(KeyEvent e)
{
  if (VCand.getjTextFieldBusq().getText().trim().length()==20)  
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
    if(e.getSource().equals(VCand.getjTextFieldBusq()))
    {
       
        NombreskeyTyped(e);
        VCand.getjButtonBuscar().setEnabled(true);
        
    }
    
    if(e.getSource().equals(VCand.getjComboBoxBusqCand()))
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

