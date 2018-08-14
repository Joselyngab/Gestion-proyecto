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
import Dao.DaoCandidato;
import Libreria.Rutinas;
import Modelo.MEntrevista;
import Vista.VEntrevista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CEntrevista implements ActionListener, KeyListener 
{
    private VEntrevista vEnt;
    private char operacion;
    
    public CEntrevista() throws SQLException 
    {
        vEnt = new VEntrevista();
        vEnt.agregarListener(this);
        vEnt.setVisible(true);
        
        vEnt.getjDateChooserFecha().addKeyListener(this);
        vEnt.getjTextFieldIdCandidato().addKeyListener(this);
        vEnt.getjTextFieldIdEntrevistador().addKeyListener(this);
        vEnt.getjTextFieldCodigoProyecto().addKeyListener(this);
        
        vEnt.getjTextFieldCodigoProyecto().requestFocusInWindow();
        habilitarCampos(false);
        cargarComboTipoEnt();
    }
//===================================================================    
    private void cargarCombo() throws SQLException
    {
        DaoEntrevista daoE = new DaoEntrevista();
        ResultSet cargo;
        String proy=vEnt.getjTextFieldCodigoProyecto().getText();
        cargo=daoE.buscarCargo(proy);
        
        while(cargo.next())
        {
            String cdesc=cargo.getString("cdesc");
            vEnt.getjComboBoxCargoAspirado().addItem(cdesc);
        }
    }
//===================================================================    
    private void cargarComboTipoEnt() throws SQLException
    {
        DaoEntrevista daoTp = new DaoEntrevista();
        ResultSet tEnt;
        tEnt=daoTp.buscarTipoEntrevista();
        while(tEnt.next())
        {
            vEnt.getjComboBoxTipo().addItem(tEnt.getString("descripcion"));
        }
    }
    private String comboTipoEntrevista()
    {
        return  (String) vEnt.getjComboBoxTipo().getModel().getSelectedItem();
    }
    private String comboCargoAspirado()
    {
        return (String) vEnt.getjComboBoxCargoAspirado().getModel().getSelectedItem();
    }
//===================================================================
    private void cancelar()
    {
       limpiarCampos();   
       vEnt.getjTextFieldCodigoProyecto().setEnabled(true);
       
    }
//===================================================================
    private void registrar() throws SQLException
    {
        DaoEntrevista daoE = new DaoEntrevista();
        MEntrevista mEnt;
      
        if(vEnt.getjTextFieldDescripcionEntrevista().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingresar la descripción", "");
            vEnt.getjTextFieldDescripcionEntrevista().requestFocusInWindow();
            return;
        }
        if (vEnt.getjComboBoxTipo().getSelectedIndex()==0)    
        {
            Rutinas.Aviso("Seleccione el tipo de entrevista", "");
            vEnt.getjComboBoxTipo().requestFocusInWindow();
            return;      
        }
        if(vEnt.getjDateChooserFecha().getDate()==null)
        {
            Rutinas.Aviso("Seleccione la fecha", "");
            vEnt.getjDateChooserFecha().requestFocusInWindow();
            return;
        }
        if(vEnt.getjTextFieldIdEntrevistador().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingrese el identificador del entrevistador", "");
            vEnt.getjTextFieldIdEntrevistador().requestFocusInWindow();
            return;
        }
        if(vEnt.getjTextFieldIdCandidato().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingrese el identificador del candidato", "");
            vEnt.getjTextFieldIdCandidato().requestFocusInWindow();
            return;
        }
        if (vEnt.getjComboBoxCargoAspirado().getSelectedIndex()==0)    
        {
            Rutinas.Aviso("Seleccione el cargo aspirado", "");
            vEnt.getjComboBoxCargoAspirado().requestFocusInWindow();
            return;      
        }
        if(vEnt.getjTextFieldSalarioOfertado().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingresar el salario ofertado", "");
            vEnt.getjTextFieldSalarioOfertado().requestFocusInWindow();
            return;
        }
        if(vEnt.getjTextFieldSalarioOfertado().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingresar el salario pretendido", "");
            vEnt.getjTextFieldSalarioPretendido().requestFocusInWindow();
        }
        if (vEnt.getjComboBoxCalificacion().getSelectedIndex()==0)    
        {
            Rutinas.Aviso("Seleccione la calificación", "");
            vEnt.getjComboBoxCalificacion().requestFocusInWindow();
            return;      
        }
        if (vEnt.getjComboBoxModalidad().getSelectedIndex()==0)    
        {
            Rutinas.Aviso("Seleccione la modalidad", "");
            vEnt.getjComboBoxModalidad().requestFocusInWindow();
            return;      
        }
        if(vEnt.getjTextAreaObservacion().getText().trim().length()==0)
        {
            Rutinas.Aviso("Ingrese la observación", "");
            vEnt.getjTextAreaObservacion().requestFocusInWindow();
            return;
        }
        
        String comboEntrevista = comboTipoEntrevista();
        ResultSet codtip=daoE.comboTipo(comboEntrevista);
        int ct;
        if(codtip.next())
        {
            
            ct=codtip.getInt("codigo");
        }
        else
            return;
        
        String comboCargo = comboCargoAspirado();
        ResultSet codcargo = daoE.buscarCargos(comboCargo);
        int cc;
        if(codcargo.next())
        {
            cc = codcargo.getInt("codigo");
        }
        else
            return;
                
        String desc=vEnt.getjTextFieldDescripcionEntrevista().getText();
        Date fecha = vEnt.getjDateChooserFecha().getDate();
        String identrevistador = vEnt.getjTextFieldIdEntrevistador().getText();
        String observacion = vEnt.getjTextAreaObservacion().getText();
        String modalidad = (String)vEnt.getjComboBoxModalidad().getSelectedItem();
        String cal = (String)vEnt.getjComboBoxCalificacion().getSelectedItem();
        String codproyecto = vEnt.getjTextFieldCodigoProyecto().getText();
        Float salarioPretendido = Float.valueOf(vEnt.getjTextFieldSalarioOfertado().getText());
        Float salarioOfertado = Float.valueOf(vEnt.getjTextFieldSalarioPretendido().getText());
        String idcandidato = vEnt.getjTextFieldIdCandidato().getText();
        
        ResultSet gen;
        gen=daoE.buscarEntG(idcandidato, codproyecto);
        if(gen.next())
            {
                Rutinas.Aviso("Ya se registró una entrevista general a este candidato para este proyecto. Por favor seleccione otro tipo de entrevista", "");
                vEnt.getjComboBoxTipo().requestFocusInWindow();
                
                vEnt.getjTextFieldSalarioOfertado().setText("0.0");
                vEnt.getjTextFieldSalarioPretendido().setText("0.0");
                
                return;
            }
        else
        {
        mEnt = new MEntrevista(desc,
                               fecha,
                               identrevistador,
                               observacion,
                               modalidad,
                               cal,
                               codproyecto,
                               salarioPretendido,
                               salarioOfertado,
                               ct,
                               cc,
                               idcandidato);
        daoE.registrarEntrevista(mEnt);
        Rutinas.Aviso("La entrevista se ha registrado exitosamente", "");
        limpiarCampos();
           vEnt.getjTextFieldCodigoProyecto().setEnabled(true);
        }
    }
//===================================================================
    private void buscarProyecto() throws SQLException
    {
        DaoProyecto daoPro = new DaoProyecto();
        ResultSet bPro;
            
        bPro = daoPro.BuscarP(vEnt.getjTextFieldCodigoProyecto().getText());
               
        if(bPro.next())
        {
            vEnt.getjTextFieldDescripcion().setText(bPro.getString("descripcion").trim());
            
            vEnt.getjTextFieldCodigoProyecto().setEnabled(false);
            vEnt.getjTextFieldDescripcionEntrevista().requestFocusInWindow();
            vEnt.getjButtonBuscarProyecto().setEnabled(false);
            vEnt.getjTextAreaObservacion().setEnabled(true);
            deshabilitar(true);
            cargarCombo();
        }
        else
        {
            if(vEnt.getjTextFieldCodigoProyecto().getText().trim().length()==0)
            {
                Rutinas.Aviso("Ingrese el código", "");
                vEnt.getjTextFieldCodigoProyecto().setText("");
                vEnt.getjTextFieldCodigoProyecto().requestFocusInWindow();
                return;
            }else {
                Rutinas.Aviso("El identificador no existe", "");
                vEnt.getjTextFieldCodigoProyecto().setText("");
                vEnt.getjButtonCancelar().setEnabled(false);
                vEnt.getjTextFieldCodigoProyecto().requestFocusInWindow();
                return;
            }
        } 
    }
    private void buscarEntrevistador() throws SQLException
    {
        DaoEntrevista  daoEnt = new DaoEntrevista();
        ResultSet entrevistador;
        entrevistador = daoEnt.buscarEntrevistador(vEnt.getjTextFieldIdEntrevistador().getText().trim());

        if(entrevistador.next())
        {
            vEnt.getjTextFieldNombreEntrevistador().setText(entrevistador.getString("nombre").trim());
            vEnt.getjTextFieldApellidoEntrevistador().setText(entrevistador.getString("apellido").trim());
            
            vEnt.getjTextFieldApellidoEntrevistador().setEnabled(false);
            vEnt.getjButtonBuscarEntrevistador().setEnabled(false);
            vEnt.getjButtonBuscarEntrevistador().setEnabled(false);
            vEnt.getjTextFieldIdCandidato().requestFocusInWindow();
        }
        else
        {
            if(vEnt.getjTextFieldIdEntrevistador().getText().trim().length()==0)
            {
                Rutinas.Aviso("Ingrese el identificador", "");
                vEnt.getjTextFieldIdEntrevistador().setText("");
                vEnt.getjTextFieldIdEntrevistador().requestFocusInWindow();
                return;
            }else {
                Rutinas.Aviso("El identificador no existe", "");
                
                vEnt.getjTextFieldIdEntrevistador().requestFocusInWindow();
                return;
            }
        }
    }
//===================================================================    
    private void buscarCandidato() throws SQLException
    {
        DaoCandidato daoCa = new DaoCandidato();
        ResultSet bCan;

        bCan = daoCa.buscarCandidato(vEnt.getjTextFieldIdCandidato().getText().trim());
        if(bCan.next())
        {
            vEnt.getjTextFieldNombreCandidato().setText(bCan.getString("nombre").trim());
            vEnt.getjTextFieldApellidoCandidato().setText(bCan.getString("apellido").trim());

            vEnt.getjComboBoxCargoAspirado().setEnabled(true);
            vEnt.getjComboBoxCalificacion().setEnabled(true);
            vEnt.getjComboBoxModalidad().setEnabled(true);
        }
        else
        {
            if(vEnt.getjTextFieldIdCandidato().getText().trim().length()==0)
                {
                    Rutinas.Aviso("Ingrese el identificador del Candidato", "");
                    vEnt.getjTextFieldIdCandidato().requestFocusInWindow();
                    return;
                }else {
                    Rutinas.Aviso("No existe", "");
                    vEnt.getjTextFieldIdCandidato().requestFocusInWindow();
                    return;
                }
        }
}
//===================================================================
    private void limpiarCampos()
    {
        vEnt.getjButtonRegistrar().setEnabled(false);
        vEnt.getjButtonCancelar().setEnabled(false);
        
        vEnt.getjTextFieldDescripcion().setText("");
        vEnt.getjTextFieldDescripcion().setEnabled(false);
        vEnt.getjTextFieldCodigoProyecto().setText("");
        vEnt.getjTextFieldCodigoProyecto().requestFocusInWindow();
        
        vEnt.getjButtonBuscarCandidato().setEnabled(false);
        vEnt.getjTextFieldIdCandidato().setText("");
        vEnt.getjTextFieldIdCandidato().setEnabled(false);
        vEnt.getjTextFieldIdCandidato().setText("");
        vEnt.getjTextFieldNombreCandidato().setText("");
        vEnt.getjTextFieldNombreCandidato().setEnabled(false);
        vEnt.getjTextFieldApellidoCandidato().setText("");
        vEnt.getjTextFieldApellidoCandidato().setEnabled(false);
        
        vEnt.getjButtonBuscarEntrevistador().setEnabled(false);
        vEnt.getjTextFieldIdEntrevistador().setText("");
        vEnt.getjTextFieldIdEntrevistador().setEnabled(false);
        vEnt.getjButtonBuscarEntrevistador().setEnabled(false);
        vEnt.getjTextFieldIdEntrevistador().setText("");
        vEnt.getjTextFieldNombreEntrevistador().setText("");
        vEnt.getjTextFieldNombreEntrevistador().setEditable(false);
        vEnt.getjTextFieldApellidoEntrevistador().setText("");
        vEnt.getjTextFieldApellidoEntrevistador().setEditable(false);
        vEnt.getjTextFieldDescripcionEntrevista().setEnabled(false);
        vEnt.getjTextFieldDescripcionEntrevista().setText("");
       
        vEnt.getjDateChooserFecha().setDate(null);
        vEnt.getjDateChooserFecha().setEnabled(false);
        vEnt.getjComboBoxCalificacion().setSelectedIndex(0);
        vEnt.getjComboBoxCalificacion().setEnabled(false);
        vEnt.getjComboBoxModalidad().setSelectedIndex(0);
        vEnt.getjComboBoxModalidad().setEnabled(false);
        vEnt.getjComboBoxTipo().setSelectedIndex(0);
        vEnt.getjComboBoxTipo().setEnabled(false);
        vEnt.getjTextFieldSalarioOfertado().setEnabled(false);
        vEnt.getjTextFieldSalarioOfertado().setText("");
        vEnt.getjTextFieldSalarioPretendido().setEnabled(false);
        vEnt.getjTextFieldSalarioPretendido().setText("");
        vEnt.getjTextAreaObservacion().setText("");
        vEnt.getjTextAreaObservacion().setEnabled(false);
        
        vEnt.getjTextFieldSalarioOfertado().setText("0.0");
        vEnt.getjTextFieldSalarioPretendido().setText("0.0");
        
        deshabilitar(true);
        habilitarCampos(false);
    }
//===================================================================
    private void deshabilitar(boolean d)
    {
        vEnt.getjTextFieldDescripcionEntrevista().setEnabled(d);
        vEnt.getjTextFieldIdCandidato().setEnabled(d);
        vEnt.getjTextFieldIdEntrevistador().setEnabled(d);
        vEnt.getjButtonBuscarCandidato().setEnabled(d);
        vEnt.getjButtonBuscarEntrevistador().setEnabled(d);
        vEnt.getjComboBoxTipo().setEnabled(d);
        vEnt.getjDateChooserFecha().setEnabled(d);
        vEnt.getjButtonRegistrar().setEnabled(d);
    }
//===================================================================
    private void habilitarCampos(boolean h)
    {
        vEnt.getjButtonRegistrar().setEnabled(h);
        vEnt.getjButtonCancelar().setEnabled(h);
        vEnt.getjButtonBuscarEntrevistador().setEnabled(h);
        vEnt.getjTextFieldDescripcionEntrevista().setEnabled(h);
        vEnt.getjButtonBuscarCandidato().setEnabled(h);
        //vEnt.getjButtonBuscarProyecto().setEnabled(h);
        
        vEnt.getjTextFieldDescripcion().setEnabled(h);
        vEnt.getjComboBoxTipo().setEnabled(h);
        vEnt.getjDateChooserFecha().setEnabled(h);
        vEnt.getjTextFieldIdEntrevistador().setEnabled(h);
        vEnt.getjTextFieldNombreEntrevistador().setEnabled(h);
        vEnt.getjTextFieldApellidoEntrevistador().setEnabled(h);
        
        vEnt.getjTextFieldIdCandidato().setEnabled(h);
        vEnt.getjTextFieldNombreCandidato().setEnabled(h);
        vEnt.getjTextFieldApellidoCandidato().setEnabled(h);
        
        vEnt.getjTextFieldSalarioOfertado().setEnabled(h);
        vEnt.getjTextFieldSalarioPretendido().setEnabled(h);
        vEnt.getjComboBoxCalificacion().setEnabled(h);
        vEnt.getjComboBoxModalidad().setEnabled(h);
    //    vEnt.getjTextAreaObservacion().setEnabled(h);
        vEnt.getjComboBoxCargoAspirado().setEnabled(h);
    }
//===================================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(vEnt.getjComboBoxTipo()))
        {
            if(vEnt.getjComboBoxTipo().getSelectedIndex()==1)
            {
                vEnt.getjTextFieldSalarioOfertado().setText("0.0");
                vEnt.getjTextFieldSalarioPretendido().setText("0.0");
                vEnt.getjTextFieldSalarioOfertado().setEnabled(true);
                vEnt.getjTextFieldSalarioPretendido().setEnabled(true);
            }
            else
            {
                
                vEnt.getjTextFieldSalarioOfertado().setText("0.0");
                vEnt.getjTextFieldSalarioPretendido().setText("0.0");
                vEnt.getjTextFieldSalarioOfertado().setEnabled(false);
                vEnt.getjTextFieldSalarioPretendido().setEnabled(false);
            
            }       
            return;
        }
        if(e.getSource().equals(vEnt.getjButtonCancelar()))
        {
            cancelar();
            return;
        }
        if(e.getSource().equals(vEnt.getjButtonRegistrar()))
        {
            try {
                registrar();
            } catch (SQLException ex) {
                Logger.getLogger(CEntrevista.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        if(e.getSource().equals(vEnt.getjButtonRegresar()))
        {
            vEnt.dispose();
        }
        if(e.getSource().equals(vEnt.getjButtonBuscarProyecto()))
        {
            try 
            {
                buscarProyecto();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(CProyecto.class.getName()).log(Level.SEVERE, null,ex);
            }
            return;
        }
        
        if(e.getSource().equals(vEnt.getjButtonBuscarEntrevistador()))
        {
            try {
                buscarEntrevistador();
            } catch (SQLException ex) {
                Logger.getLogger(CEntrevista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource().equals(vEnt.getjButtonBuscarCandidato()))
        {
            try {
                buscarCandidato();
            } catch (SQLException ex) {
                Logger.getLogger(CCandidato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource().equals(vEnt.getjComboBoxTipo()))
        {
            comboTipoEntrevista();
            return;
        }
        if(e.getSource().equals(vEnt.getjComboBoxCargoAspirado()))
        {
            comboCargoAspirado();
            return;
        }
    }
//===================================================================
    private void codigoProyectokeyTyped(KeyEvent e)
    {
        if(vEnt.getjTextFieldCodigoProyecto().getText().trim().length()==10)
        {
            e.consume();
            return;
        }
    }
    private void descripcionEntrevistakeyTyped(KeyEvent e)
    {
        if(vEnt.getjTextFieldDescripcionEntrevista().getText().trim().length()==80)
        {
            e.consume();
            return;
        }
    }
    private void idEntrevistadorkeyTyped(KeyEvent e)
    {
        if(vEnt.getjTextFieldIdEntrevistador().getText().trim().length()==10)
        {
            e.consume();
            return;
        }
    }
    private void idCandidatokeyTyped(KeyEvent e)
    {
        if(vEnt.getjTextFieldIdCandidato().getText().trim().length()==10)
        {
            e.consume();
            return;
        }
    }
    private void observacioneskeyTyped(KeyEvent e)
    {
        if(vEnt.getjTextAreaObservacion().getText().trim().length()==100)
        {
            e.consume();
            return;
        }
    }     
//=================================================================== 
    @Override
    public void keyTyped(KeyEvent e) 
    {        
        if(e.getSource().equals(vEnt.getjTextFieldCodigoProyecto()))
        {
            codigoProyectokeyTyped(e);
            vEnt.getjButtonBuscarProyecto().setEnabled(true);
            vEnt.getjButtonCancelar().setEnabled(true);
        }
        if(e.getSource().equals(vEnt.getjTextFieldIdEntrevistador()))
        {
            idEntrevistadorkeyTyped(e);
        }
        if(e.getSource().equals(vEnt.getjTextFieldIdCandidato()))
        {
            idCandidatokeyTyped(e);
        }
        if(e.getSource().equals(vEnt.getjTextAreaObservacion()))
        {
            observacioneskeyTyped(e);
        }
    }
//=================================================================== 
    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
