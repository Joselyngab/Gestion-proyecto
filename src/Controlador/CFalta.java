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
import Dao.DaoFalta;
import Libreria.Rutinas;
import Modelo.MFalta;
import Vista.VFalta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Valmore Canelon
 */
public class CFalta implements ActionListener, KeyListener
{
    private VFalta formFaltas;
    
    public CFalta()
    {
        formFaltas = new VFalta();
        formFaltas.agregarListener(this);
        formFaltas.setVisible(true);
        
        formFaltas.getjTextFieldNombre().setEditable(false);
        formFaltas.getjTextFieldCodigo().requestFocusInWindow();
        habilitarFaltas(false);   
        formFaltas.getjTextFieldCantHoras().addKeyListener(this);
        
        formFaltas.getjDateChooserFechaFalta().getDateEditor().getUiComponent()
                   .addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                DateChooserFechaFaltaKeyTyped(ke);
            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {

            }
        
         });
    }
    
    private void habilitarFaltas(boolean estado)
    {
        formFaltas.getjComboBoxTipo().setEnabled(estado);
        formFaltas.getjDateChooserFechaFalta().setEnabled(estado);
        formFaltas.getjTextPaneMotivo().setEnabled(estado);
        formFaltas.getjComboBoxTipo().setEnabled(estado);
        formFaltas.getjTextFieldCantHoras().setEnabled(estado); 
        formFaltas.getjButtonRegistrar().setEnabled(estado);
        formFaltas.getjButtonCancelar().setEnabled(estado);
    }
    
    private void cancelar()
    {
        formFaltas.getjTextFieldCodigo().setText("");
        formFaltas.getjTextFieldCodigo().requestFocusInWindow();
        formFaltas.getjTextFieldNombre().setText("");
        formFaltas.getjDateChooserFechaFalta().setDate(null);
        formFaltas.getjTextPaneMotivo().setText("");
        formFaltas.getjComboBoxTipo().setSelectedIndex(0);
        formFaltas.getjTextFieldCantHoras().setText("");
        formFaltas.getjButtonBuscar().setEnabled(true);
        habilitarFaltas(false);
    }
    
    private boolean validarCampos()
    {
        if (formFaltas.getjDateChooserFechaFalta().getDate()==null)
        {
            Rutinas.Aviso("Seleccione una fecha", "");
            formFaltas.getjDateChooserFechaFalta().requestFocusInWindow();
            return false;
        }
        
        if (formFaltas.getjComboBoxTipo().getSelectedIndex()==0)
        {
                Rutinas.Aviso("Seleccione tipo de falta", "");
                formFaltas.getjComboBoxTipo().requestFocusInWindow();
                return false;
        }
            
        if(formFaltas.getjTextPaneMotivo().getText().trim().length()==0)
        {
                    Rutinas.Aviso("Motivo de la falta vacio", "");
                    formFaltas.getjTextPaneMotivo().requestFocusInWindow();
                    return false;
        }
        
        if(formFaltas.getjTextFieldCantHoras().getText().length()==0)
        {
            Rutinas.Aviso("Ingrese cantidad de horas", "");
            formFaltas.getjTextFieldCantHoras().requestFocusInWindow();
            return false;                                                                 
        }          
        return true;
    }
    
    private void buscar() throws SQLException
    {
         if(formFaltas.getjTextFieldCodigo().getText().trim().length()==0)
        {
                Rutinas.Aviso("Ingrese el identificador del candidato", "");
                formFaltas.getjTextFieldCodigo().requestFocusInWindow();
                return;
        }
         
        DaoCandidato daoFalt = new DaoCandidato();
        ResultSet regFaltas;
        
        regFaltas = daoFalt.buscarCandidato(formFaltas.getjTextFieldCodigo()
                                           .getText());
        if(regFaltas.next())
        {
            if(regFaltas.getString("estatus").equals("E"))
            {
                formFaltas.getjTextFieldNombre().setText(
                regFaltas.getString("nombre").trim()+ " " +
                regFaltas.getString("apellido").trim());
                habilitarFaltas(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El candidato no se "
                        + "encuentra laborando"
                        + " para la empresa, por tal motivo, "
                        + "no se le puede procesar permisos.");
                cancelar();
                return;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "La identificación que ha "
                                      + "ingresado no se encuentra registrada");
            cancelar();
            return;
        }
        regFaltas.close();
    }
    
    private int obtenerDiaSemana(Date d){
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(d);
	return cal.get(Calendar.DAY_OF_WEEK);		
}
    
    private void registrar()
    {
        validarCampos();
        
        DaoFalta daoFalta= new DaoFalta();
        MFalta mf;
        mf= new MFalta(formFaltas.getjTextFieldCodigo().getText(),
                       formFaltas.getjTextPaneMotivo().getText(),
                       formFaltas.getjDateChooserFechaFalta().getDate(),
                       (String) formFaltas.getjComboBoxTipo().getSelectedItem(),
                        Integer.decode(formFaltas.getjTextFieldCantHoras()
                        .getText()));
        
        if(obtenerDiaSemana(formFaltas.getjDateChooserFechaFalta().getDate())==1 ||
           obtenerDiaSemana(formFaltas.getjDateChooserFechaFalta().getDate())==7)
        {
            JOptionPane.showMessageDialog(null, "No se pueden registrar "
                                      + "faltas los días sábados y domingos.");
            cancelar();
        }
        else
        {      
             daoFalta.registrarFaltas(mf);
             cancelar();
             habilitarFaltas(false);     
        }
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(formFaltas.getjButtonRegistrar()))  
        {
            registrar();   
        }
        
        if (ae.getSource().equals(formFaltas.getjButtonCancelar()))  
        {
            cancelar();   
        }
        
        if (ae.getSource().equals(formFaltas.getjButtonRegresar()))  
        {
            formFaltas.dispose();  
        }
        if (ae.getSource().equals(formFaltas.getjButtonBuscar()))
        {
            try {
                buscar();
            } catch (SQLException ex) {
              Logger.getLogger(CFalta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void CodigoKeyTyped(KeyEvent ke)
    {
        if (formFaltas.getjTextFieldCodigo().getText().trim().length()==2)
        {
            ke.consume();
        }
    }
    
    private void MotivoKeyTyped(KeyEvent ke)
    {
        if (formFaltas.getjTextPaneMotivo().getText().trim().length()==30)
        {
            ke.consume();
        }
    }
    
    private void CantHorasKeyTyped(KeyEvent ke)
    {
        if (formFaltas.getjTextFieldCantHoras().getText().trim().length()==1)
        {
            ke.consume();
        }
    }
    
    
    
private void DateChooserFechaFaltaKeyTyped(KeyEvent ke)
{
  char tecla;
  tecla=ke.getKeyChar();
  if (tecla=='/')
  {
   return; 
  }
  if (tecla<'0' || tecla>'9')
  {
     ke.consume();
  }
  
}
   
    
   
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
        
        if (ke.getSource().equals(formFaltas.getjTextFieldCodigo()))
        {
            CodigoKeyTyped(ke);
        }
        
        if (ke.getSource().equals(formFaltas.getjTextPaneMotivo()))
        {
            MotivoKeyTyped(ke);
        }
        
        if (ke.getSource().equals(formFaltas.getjTextFieldCantHoras()))
        {
            CantHorasKeyTyped(ke);
        }
        
        if (ke.getSource().equals(formFaltas.getjDateChooserFechaFalta()))
        {
            DateChooserFechaFaltaKeyTyped(ke);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    
    }
    
    
}