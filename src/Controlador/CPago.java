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

import Dao.DaoAsigCand;
import Dao.DaoCandidato;
import Dao.DaoEntrevista;

import Libreria.Rutinas;
import Modelo.MAsignarCand;
import Vista.VAsignarCand;
import Vista.VPago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CPago implements ActionListener{

    
    private VPago Vp;
    
    public CPago(String  id, String cargo, String cod) throws SQLException {
        Vp=new VPago();
        Vp.agregarListener(this);
        Vp.setVisible(true);
        
        ResultSet BusqC;
        
        DaoCandidato DaoC=new DaoCandidato();
        BusqC = DaoC.buscarCandidato(id);
        if (BusqC.next())
        {
            
        
        Vp.getjTextFieldIdent().setText(BusqC.getString("identificador"));
        String nomb=BusqC.getString("nombre").trim();
        nomb=nomb + " " + BusqC.getString("apellido").trim();
        Vp.getjTextFieldCand1().setText(nomb);
        Vp.getjTextFieldCargo().setText(cargo);
        
        Vp.getjTextFieldCand1().requestFocus();
        
    }    
       
        DaoEntrevista daoE=new DaoEntrevista();
        ResultSet obs = daoE.buscarEnt(id, cod);
        if(obs.next()) {
            String obser = obs.getString("observaciones").trim();
            Vp.getjTextArea1().setText(obser);
        }
                
        
    }
    
    private String TipoPago()
    {
        if(Vp.getjComboBox2().getSelectedIndex()==1){
            return "H";
        }
        else{
            
            return "S";
        }
    }
    
    private String TipoMoneda()
    {
        if(Vp.getjComboBox1().getSelectedIndex()==1){
            return "D";
        }
        else{
            if(Vp.getjComboBox1().getSelectedIndex()==2) {
                return "E";
            }
            else{
                return "B";
            }
        }
            
        
    }
            
       
   private void Validar()
   {
        if(Vp.getjComboBox2().getSelectedIndex()==0){//Tipo pago
            Rutinas.Aviso("Favor Seleccione un Tipo de pago", "");
            Vp.getjComboBox2().requestFocus();
            return;
        }
       
        if(Vp.getjComboBox1().getSelectedIndex()==0){   //Tipo de moneda 
            
            Rutinas.Aviso("Favor Seleccione un Tipo de moneda", "");
            Vp.getjComboBox1().requestFocus();
            return;
        }
        
        if(Vp.getjTextFieldSueldo().getText()=="0" ||
           Vp.getjTextFieldSueldo().getText()==" ") {
            Rutinas.Aviso("Favor Introduzca el salario acordado", "");
            Vp.getjComboBox1().requestFocus();
            return;
        }
    }
    private void Registrar ()
    {
        DaoAsigCand DaoAs = new DaoAsigCand();
        MAsignarCand ma;
       
        String tipm;
        String tipag;
        Validar();
        
        tipm=TipoMoneda();
        tipag=TipoPago();
        
        float sueld=0;
        sueld=Float.valueOf(Vp.getjTextFieldSueldo().getText().trim());
        
        ma = new MAsignarCand(Vp.getjTextFieldIdent().getText().trim(),
                              Float.valueOf(Vp.getjTextFieldSueldo()
                              .getText().trim()),tipm, tipag);

        DaoAs.AsigCand(ma);
        DaoAs.ActualizarCand(ma);
                Rutinas.Aviso("El candidato fue asignado de manera exitosa", "");
                Vp.getjButtonAsignar().setEnabled(false);
                Vp.getjTextFieldSueldo().setEditable(false);
                


    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(Vp.getjButtonRegresar()))
        {
            Vp.dispose();
            VAsignarCand vAsig=new VAsignarCand();
            try {
                new CAsignarCand();
            } catch (SQLException ex) {
                Logger.getLogger(CPago.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
        
        
        
      if(e.getSource().equals(Vp.getjButtonAsignar()))
      {
          Registrar ();
      }
        
    }

}
