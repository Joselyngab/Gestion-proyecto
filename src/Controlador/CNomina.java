/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


/**
 *
 * @author franc_000
 */
import Dao.DaoNomina;
import Libreria.Rutinas;
import Modelo.MNomina;
import Vista.VNomina;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

        
public class CNomina implements ActionListener, PropertyChangeListener
{
    
    private VNomina formNomina;
    private char operacion;
    
    public CNomina() 
    {
        formNomina = new VNomina();
        formNomina.agregarListener(this);
        formNomina.setVisible(true);
        formNomina.getjMonthChoosermes().addPropertyChangeListener(this);
        
        habilitarCampos (false);
        formNomina.getjButton2Registrar().setEnabled(false);
        
     
    }
   
    
 private void buscar () throws SQLException
 {
    if(formNomina.getjTextFieldIdentificacion().getText().trim().length()==0)
    {
        Rutinas.Aviso("Ingrese el identificador", "");
        formNomina.getjTextFieldIdentificacion().requestFocusInWindow();
        return;
    }
    else 
    {
       DaoNomina daoNomina = new DaoNomina ();
       ResultSet regisnomina;
       formNomina.getjButton3Cancelar().setEnabled(true);
       habilitarCampos(true);

    
    regisnomina = daoNomina.buscarnomina(formNomina.getjTextFieldIdentificacion().getText());
 

    
    if (!regisnomina.next())
    {
        Rutinas.Aviso("El empleado no se encuentra registrado", "ERROR");
            cancelar();
            return;
       
    }
    else 
    {
         int horasMes = 0;
        
        formNomina.getjLabel4nombre().setText(regisnomina.getString("nombre").trim());
        formNomina.getjLabel4Salario().setText(regisnomina.getString("sueldo").trim());
    }
      habilitarCampos(true);
      desabilitarCampos (false);
      regisnomina.close();
 }
     }


    private void cancelar()
{
  limpiarCampos ();
  
  
}        
   private void habilitarCampos (boolean Estado)
   {
       formNomina.getjTextField3Horast().setEnabled(Estado);
       formNomina.getjButton3Cancelar().setEnabled(Estado);
       formNomina.getjButton1Calcular().setEnabled(Estado);
       formNomina.getjMonthChoosermes().setEnabled(Estado);
       //formNomina.getjButton2Registrar().setEnabled(Estado);
   }
   private void desabilitarCampos (boolean estado)
    {
        formNomina.getjButton1Buscar().setEnabled(estado);
        formNomina.getjTextFieldIdentificacion().setEnabled(estado);
        
    }
   private void limpiarCampos ( )
   {
  formNomina.getjLabel4HorasMes().setText("");
  formNomina.getjTextField3Horast().setText("");
  formNomina.getjLabel4montopagado().setText(" ");
  formNomina.getjLabel4Salario().setText(" ");
  formNomina.getjLabel4nombre().setText(" ");
  formNomina.getjTextFieldIdentificacion().setText(" ");
  formNomina.getjLabel2().setText(" ");
  formNomina.getjButton2Registrar().setEnabled(false);
  habilitarCampos (false);
  desabilitarCampos(true);
  
  
   }
//--------------------------
       public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
       //---------------------------------
private double calcular() throws SQLException
{
    DaoNomina daoNomina= new DaoNomina();
    ResultSet bnomina;
    double montoneto=0;
    if (formNomina.getjTextField3Horast().getText().trim().length()==0)    
     {
      Rutinas.Aviso("Ingrese Horas Trabajadas", "");
      formNomina.getjTextField3Horast().requestFocusInWindow();
         //return;      
       }  
    else
    {
    bnomina = daoNomina.buscarnomina(formNomina.getjTextFieldIdentificacion().getText());
    if(bnomina.next())
    {
        String tipop=bnomina.getString("tipopago").trim();
        String tipom=bnomina.getString("tipomoneda").trim();
        double salario=bnomina.getFloat("sueldo");
        int horasmes= calcularDiasMes ();
        double montopagado = 0;
        
        int horasT=Integer.decode(formNomina.getjTextField3Horast().getText());
        double montoxhora;

        if ("S".equals(tipop))
            
        {      
            montoxhora = salario/horasmes;
            if ("E".equals(tipom))
              
            {       
                montoneto = montoxhora * horasT;
                montopagado = montoneto * 0.90;
                double s =redondearDecimales(montopagado,2);
                String m=""+s+"";
                formNomina.getjLabel4montopagado().setText(m);
                formNomina.getjLabel2().setText("Euros");
                campos ();
                return montoneto;
                
            }
            else
            {
            if ("B".equals(tipom))
            {
                
                montoneto = montoxhora * horasT;
                montopagado = montoneto * 9.95;
                double s =redondearDecimales(montopagado,2);
                String m=""+s+"";
                formNomina.getjLabel4montopagado().setText(m);
                formNomina.getjLabel2().setText("Bs");
                campos ();
                return montoneto;
            }
            
           else
            {
               
                montoneto = montoxhora * horasT;
                montopagado = montoneto; 
                double s =redondearDecimales(montopagado,2);
                String m=""+s+"";
                formNomina.getjLabel4montopagado().setText(m);
                formNomina.getjLabel2().setText("$");
                campos ();
                return montoneto;
            }}
        }
    
        else 
        {
            
             if ("E".equals(tipom))
              
            {
                
                montoneto = salario * horasT;
                montopagado = montoneto * 0.90;
                double s =redondearDecimales(montopagado,2);
                String m=""+s+"";
                formNomina.getjLabel4montopagado().setText(m);
                formNomina.getjLabel2().setText("Euros");
                campos ();
                return montoneto;
            }
            else
            {
            if ("B".equals(tipom))
            {
                
                montoneto = salario * horasT;
                montopagado = montoneto * 9.95;
                double s =redondearDecimales(montopagado,2);
                String m=""+s+"";
                formNomina.getjLabel4montopagado().setText(m);
                formNomina.getjLabel2().setText("Bs");
                campos ();
                return montoneto;
            }
            
           else
            {
                
                montoneto = salario * horasT;
                montopagado = montoneto;
                double s =redondearDecimales(montopagado,2);
                String m=""+s+"";
               formNomina.getjLabel4montopagado().setText(m);
                formNomina.getjLabel2().setText("$");
                campos ();
            }}
          
            
        }
        
    }
   
   // return montoneto;
}  
    return montoneto;
} 
    
    
    public void campos ( )
    {
        formNomina.getjButton2Registrar().setEnabled(true);
        formNomina.getjButton1Calcular().setEnabled(false);
        formNomina.getjTextField3Horast().setEnabled(false);
        formNomina.getjMonthChoosermes().setEnabled(false);
    }
    private void registrar () throws SQLException
            
    {
         if (formNomina.getjLabel4montopagado().getText().trim().length()==0)    
             {
           Rutinas.Aviso("Monto a Pagar no puede estar vacio", "");
           formNomina.getjLabel4montopagado().requestFocusInWindow();
           return;
               }
       DaoNomina daonomina=new DaoNomina();
       ResultSet resulmes;
        
      resulmes = daonomina.buscarmes(formNomina.getjTextFieldIdentificacion().getText(),formNomina.getjMonthChoosermes().getMonth()+1);
 
    if (resulmes.next())
      {
        Rutinas.Aviso("Ya se le pagó ese mes al empleado", "ERROR");
            cancelar();
            return; 
       }
       
       else  
        {
                
        //DaoNomina daonomina=new DaoNomina();
        MNomina mn;
        int mes=formNomina.getjMonthChoosermes().getMonth()+1;
        double montoneto  = calcular();
        
        mn= new MNomina( formNomina.getjTextFieldIdentificacion().getText().trim(),
                        Integer.decode(formNomina.getjTextField3Horast().getText()),
                        mes, (float) montoneto,
                        Float.valueOf(formNomina.getjLabel4montopagado().getText().trim()), calcAnnoActual());           
       
        daonomina.insertNomina(mn);
        JOptionPane.showMessageDialog(null, "Pago Realizado Satisfactoriamente");
        limpiarCampos ();
        formNomina.getjButton2Registrar().setEnabled(false);
    }
    
        
    }
//...............................
    //-------cálculo del última día de un mes---------
     private int calcUltDia()
    {
        Calendar calFin = Calendar.getInstance();
        int anno=calcAnnoActual();
        
        int mes=formNomina.getjMonthChoosermes().getMonth();
        calFin.set(anno, mes, 1);
        
        int fec=calFin.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        return fec;
    }
    
     //-----cálculo del año actual-------
    private int calcAnnoActual()
    {
        Calendar c1 = Calendar.getInstance();
        int anno=c1.get(Calendar.YEAR);
        return anno;
    }
    
     
private int calcularDiasMes() throws SQLException
{
   
    DaoNomina daoNomina = new DaoNomina ();
    ResultSet resulferi;
    resulferi = daoNomina.buscarFeriado(formNomina.getjMonthChoosermes().getMonth()+1,calcUltDia(),calcAnnoActual());
    
    Calendar cal = GregorianCalendar.getInstance(); 
    cal.set(Calendar.DAY_OF_MONTH, 1); 
    cal.set(Calendar.MONTH,formNomina.getjMonthChoosermes().getMonth());
    int mes = formNomina.getjMonthChoosermes().getMonth(); 
    int diaAContar = 7; 
    int diaContar2=1;
    int cuenta = 0; 
    int cuenta2=0;
    int diasH= 0;
    int contfer = 0;
    int horasMes = 0;

     while (cal.get(Calendar.MONTH)==mes){ 
     if (cal.get(Calendar.DAY_OF_WEEK) == diaAContar || 
        cal.get(Calendar.DAY_OF_WEEK) == diaContar2 ) {
       cuenta++; 
     }
     cal.add(Calendar.DAY_OF_MONTH, 1);
     cuenta2++;
         
     }
     
     if (resulferi.next())
     {
        do
        {
            contfer++;
        }while (resulferi.next());
     }
     
    diasH = cuenta2 - cuenta - contfer;
    horasMes= diasH * 8;
    String h=""+horasMes+"";
   // formNomina.getjLabel4HorasMes().setText(h);
      return horasMes;
 }

 private void identificacionKeyTyped (KeyEvent e)
    {
      if (formNomina.getjTextFieldIdentificacion().getText().trim().length()==10)  
          e.consume();
    }
 private void horasKeyTyped (KeyEvent e)
    {
      if (formNomina.getjTextField3Horast().getText().trim().length()==10)  
          e.consume();
    }
 
    //--------------------
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
      if (e.getSource().equals(formNomina.getjButton1Calcular()))  
      {
           try {
              calcular();
          } catch (SQLException ex) {
              Logger.getLogger(CNomina.class.getName()).log(Level.SEVERE, null, ex);
          }
      }  
      //---------
      if (e.getSource().equals(formNomina.getjButton3Cancelar()))  
      {
         cancelar(); 
      }  
      //----------
     if (e.getSource().equals(formNomina.getjButton2Registrar()))  
      {
          try {
              registrar ();
          } catch (SQLException ex) {
              Logger.getLogger(CNomina.class.getName()).log(Level.SEVERE, null, ex);
          }
      }  
     //--
     if (e.getSource().equals(formNomina.getjButton5Regresar()))  
      {
        formNomina.dispose();  
      }
     
     if(e.getSource().equals(formNomina.getjButton1Buscar()))
      {
          try {
              buscar();
          } catch (SQLException ex) {
              Logger.getLogger(CNomina.class.getName()).log(Level.SEVERE, null, ex);
          }
      }  
      
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
              if (pce.getSource().equals(formNomina.getjMonthChoosermes()))
      {
          try {
              String calculo = ""+calcularDiasMes ()+"";
              formNomina.getjLabel4HorasMes().setText(calculo);
          } catch (SQLException ex) {
              Logger.getLogger(CNomina.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
      }

    }
}
