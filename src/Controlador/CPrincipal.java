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

import Vista.VMenuPrin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CPrincipal implements ActionListener {
    private VMenuPrin formMenuPrin;
    
    public CPrincipal()
    {
        formMenuPrin= new VMenuPrin();
        formMenuPrin.agregarListener(this);
        formMenuPrin.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource().equals(formMenuPrin.getjMenuItemferiado())) {
            new CFeriado();
            
        }
        
        if (ae.getSource().equals(formMenuPrin.getjMenuItemconsrecord())) {
            new CConsRecordPago();
            
        }
        if(ae.getSource().equals(formMenuPrin.getjMenuItemconscandidatos())){
            try {
                new CConsultaCandidato();
            } catch (SQLException ex) {
                Logger.getLogger(CPrincipal.class.getName()).log(Level.SEVERE,
                                                                 null, ex);
            }
        }
        if(ae.getSource().equals(formMenuPrin.getjMenuItemconsentrevistas())){
            new CConsultarEntrevista();
        }
        
        if(ae.getSource().equals(formMenuPrin.getjMenuItemconsutilidad())) {
            new CConsultaUtilidad();
        }
        
        if(ae.getSource().equals(formMenuPrin.getjMenuItemAsigCand())){
            try {
                new CAsignarCand();
            } catch (SQLException ex) {
                Logger.getLogger(CPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (ae.getSource().equals(formMenuPrin.getjMenuItemgestcandidato())) {
            new CCandidato ();
        }
         
        if (ae.getSource().equals(formMenuPrin.getjMenuItemregnomina()))  {
            new CNomina ();
        }
        
        if (ae.getSource().equals(formMenuPrin.getjMenuItemgestclientes())) {
            new CCliente();
        }
        
        if (ae.getSource().equals(formMenuPrin.getjMenuItemconsfaltas())) {
            new CConsultaFalta();
        }
        
        if(ae.getSource().equals(formMenuPrin.getjMenuItemgestentrevistas())) {
            try {
                new CEntrevista();
            } catch (SQLException ex) {
                Logger.getLogger(CPrincipal.class.getName()).log(Level.SEVERE,
                                 null, ex);
            }
        }
        if(ae.getSource().equals(formMenuPrin.getjMenuItemgestproyectos()))  {
            try {
                new CProyecto();
            } catch (SQLException ex) {
                Logger.getLogger(CPrincipal.class.getName()).log(Level.SEVERE,
                                 null, ex);
            }
        }
        if(ae.getSource().equals(formMenuPrin.getjMenuItemregfaltas())) {
            new CFalta();
        }
        if(ae.getSource().equals(formMenuPrin.getjMenuItemIngreso())) {
            new CRegIngresos();
        }
        
        
    }
    
    
    
}
