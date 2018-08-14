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
import Dao.DaoRegInresos;
import Libreria.Rutinas;
import Modelo.MIngresos;
import Vista.VRegIngresos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRegIngresos implements ActionListener, KeyListener {
    
    private VRegIngresos vReg;

    public CRegIngresos() {
        vReg = new VRegIngresos();
        vReg.agregarListener(this);   
        vReg.setVisible(true);    
        vReg.getjTextFieldIdentificacion().addKeyListener(this);

    }

    public void registrar() throws SQLException
    {
        
        if(vReg.getjTextField5MontoPagar().getText().length()==0)
        {
            Rutinas.Aviso("Debe ingresar el monto", "Advertencia");
            return;
        }
        
        Calendar c1 = Calendar.getInstance();
        int anno=c1.get(Calendar.YEAR);
        
        DaoRegInresos daoI=new DaoRegInresos();
        MIngresos mi;
        
        float monto=Float.valueOf(vReg.getjTextField5MontoPagar().getText());
        
        ResultSet ing;
        
        ing=daoI.buscIng(vReg.getjTextFieldIdentificacion().getText(), 
                         vReg.getjMonthChoosermes().getMonth()+1);
        
        if(ing.next())
        {
            Rutinas.Aviso("Ya se ha realizado un pago para este proyecto en "
                            + "este mes, por favor seleccione otro mes", "");
            return;
        }
        
        mi=new MIngresos(monto, vReg.getjMonthChoosermes().getMonth()+1, anno,
                          vReg.getjTextFieldIdentificacion().getText().trim());
     
        
        daoI.regIngreso(mi);
    
        Rutinas.Aviso("Ingreso registrado exitosamente", "");
        cancelar();
    }
    
    private void cancelar()
    {
        vReg.getjTextField5MontoPagar().setText("");
        vReg.getjTextField5MontoPagar().setEditable(false);
        vReg.getjButton1Buscar().setEnabled(false);
        vReg.getjButton3Cancelar().setEnabled(false);
        
        vReg.getjTextFieldIdentificacion().setEnabled(true);
        vReg.getjTextField1Nombre().setText("");
        vReg.getjTextFieldIdentificacion().setText("");
        vReg.getjMonthChoosermes().setEnabled(false);
        vReg.getjButtonProcesar().setEnabled(false);
    }
    private void buscarProyecto() throws SQLException
    {
        DaoProyecto DaoP = new DaoProyecto();
  
        ResultSet BProyecto;
        
        if(vReg.getjTextFieldIdentificacion().getText().trim().length()==0) {
                Rutinas.Aviso("El campo de código del proyecyo está vacío", "");
                vReg.getjTextFieldIdentificacion().requestFocusInWindow();
                return;
            }
        
        BProyecto = DaoP.BuscarP(vReg.getjTextFieldIdentificacion().getText().trim());
        
        if(!BProyecto.next()) {
                Rutinas.Aviso("El proyecto no se encuentra registrado", "");
        }
        else {
            vReg.getjTextFieldIdentificacion().setEnabled(false);
            vReg.getjTextField1Nombre().setText(BProyecto.getString("descripcion"));
            vReg.getjTextField5MontoPagar().setEditable(true);
            vReg.getjMonthChoosermes().setEnabled(true);
            vReg.getjMonthChoosermes().setEnabled(true);
            vReg.getjButtonProcesar().setEnabled(true);
            
        }
    }
    
    
        
        
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vReg.getjButton3Cancelar())){
            cancelar();
            return;
        }
        
        if(e.getSource().equals(vReg.getjButton5Regresar())) {
            vReg.dispose();
            return;
        }
        
        if(e.getSource().equals(vReg.getjButton1Buscar())) {
            try {
                buscarProyecto() ;
            } catch (SQLException ex) {
                Logger.getLogger(CRegIngresos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        
        if(e.getSource().equals(vReg.getjButtonProcesar()))  {
            try {
                registrar();
            } catch (SQLException ex) {
                Logger.getLogger(CRegIngresos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
            if (e.getSource().equals(vReg.getjTextFieldIdentificacion()))  {
                vReg.getjButton1Buscar().setEnabled(true);
                vReg.getjButton3Cancelar().setEnabled(true);
            }
    }

    @Override
    public void keyPressed(KeyEvent e) {
            }

    @Override
    public void keyReleased(KeyEvent e) {
        }
    
    
    
}
