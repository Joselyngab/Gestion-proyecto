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
import Dao.DaoCliente;
import Dao.DaoEntrevista;
import Dao.DaoProyecto;
import Libreria.Rutinas;
import Modelo.MProyecto;
import Vista.VProyecto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CProyecto implements ActionListener, KeyListener
{
   private VProyecto VPro;
   private char operacion;
    
    public CProyecto() throws SQLException 
    {
        VPro = new VProyecto();
        VPro.agregarLitener(this);
        VPro.setVisible(true);
        
        VPro.getjTextFieldRazonSoc().setEditable(false);
        habilitar(false);
        
        actualizar();
        
        VPro.getjDateChooserFechaInicio().addKeyListener(this);
        VPro.getjDateChooserFechaFin().addKeyListener(this);
        VPro.getjTextFieldHoras().addKeyListener(this);
        
         
        VPro.getjDateChooserFechaInicio().getDateEditor().getUiComponent()
                .addKeyListener(new java.awt.event.KeyListener() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent e){               
            DateChooserFechaKeyTyped(e);
       
          }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
               //To change body of generated methods, choose Tools | Templates.
            }
          
        }); 
         
        VPro.getjDateChooserFechaFin().getDateEditor().getUiComponent()
                .addKeyListener(new java.awt.event.KeyListener() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent e){               
            DateChooserFechaKeyTyped(e);
       
          }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
               //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
               //throw new UnsupportedOperationException("Not supported yet."); 
              //To change body of generated methods, choose Tools | Templates.
            }
          
        }); 
     } 
//===========================================
 private void DateChooserFechaKeyTyped(KeyEvent e)
{
  char tecla;
  tecla=e.getKeyChar();
  
  if (tecla=='/') {
   return; 
  }
  
  if (tecla<'0' || tecla>'9') {
   e.consume();
  }
}
//============================================ 
    private void Registrar() throws SQLException
    {
        DaoProyecto DaoF = new DaoProyecto();
        MProyecto MPro;
        habilitar(true);
        
        if(VPro.getjTextFieldBuscarProyecto().getText().trim().length()==0) {
            Rutinas.Aviso("Ingresar el identificador", "");
            VPro.getjTextFieldBuscarProyecto().requestFocusInWindow();
            return;
        }
        if(VPro.getjTextFieldDescripcion().getText().trim().length()==0) {
            Rutinas.Aviso("Ingresar la descripción", "");
            VPro.getjTextFieldDescripcion().requestFocusInWindow();
            return;
        }
        
        if(VPro.getjTextFieldBuscarCliente().getText().trim().length()==0) {
            Rutinas.Aviso("Ingresar el identificador", "");
            VPro.getjTextFieldBuscarCliente().requestFocusInWindow();
            return;
        }
        if(VPro.getjDateChooserFechaFin().getDate().before(
           VPro.getjDateChooserFechaInicio().getDate())) {
            Rutinas.Aviso("La fecha es incorrecta", "");
            return;
        }
       
        MPro = new MProyecto(VPro.getjTextFieldBuscarProyecto().getText().trim(),
                             VPro.getjTextFieldDescripcion().getText().trim(),
                             VPro.getjDateChooserFechaInicio().getDate(),
                             VPro.getjDateChooserFechaFin().getDate(), 
                             VPro.getjTextFieldBuscarCliente().getText().trim(),
                             Float.valueOf(VPro.getjTextFieldMonto().getText().trim()),
                             Integer.decode(VPro.getjTextFieldHoras().getText().trim()));
        switch(operacion)
        {
            case 'I': 
                      ResultSet cargo;
                      cargo=DaoF.buscarcarg(VPro.getjTextFieldBuscarProyecto().getText());
                      if(cargo.next())
                      {
                          DaoF.registrarProyecto(MPro);
                          Rutinas.Aviso("El Proyecto ha sido ingresado exitosamente", "");
                      }
                      else
                      {
                          Rutinas.Aviso("Debe agregar al menos un cargo al Proyecto", "");
                          return;
                      }
                      break;
            case 'M': DaoF.modificarProyecto(MPro);
                      Rutinas.Aviso("El Proyecto ha sido modificación exitosamente", "");
        }
        limpiarCampos();
    }   
//============================================
    private void Eliminar()
    {
        String cod;
        DaoProyecto daoproy= new DaoProyecto();
       
        cod= VPro.getjTextFieldBuscarProyecto().getText().trim();
        daoproy.eliminarProyecto(cod);
        Rutinas.Aviso("El Proyecto ha sido eliminado exitosamente", "");
        limpiarCampos();
    }
//============================================
    private void actualizar() throws SQLException
    {
        DaoProyecto daoP=new DaoProyecto();
        ResultSet proy;
    
        java.util.Date fechahoy = new Date();  
        proy=daoP.buscarProyecActivo();
        Date fecculm;
        if(proy.next())
        {
            do{
                fecculm=proy.getDate("fechaculminacion");
                if(fecculm.before(fechahoy))
                {
                    
                    DaoEntrevista daoE=new DaoEntrevista();
                    ResultSet ent;
                    ent=daoE.buscarEntrevista(proy.getString("codigo").trim());
                    
                    if(ent.next())
                    {
                        DaoCandidato daoC=new DaoCandidato();
                        do{
                            daoC.liberarCandidato(ent.getString("idcandidato").trim());
                        }while(ent.next());
                    }
                    daoP.actualizarProyecto(proy.getString("codigo").trim());
                }
            }while(proy.next());
        }
    }
//============================================
    private void buscarProyecto() throws SQLException
    {
        DaoProyecto DaoP = new DaoProyecto();
        ResultSet BProyecto;
        BProyecto = DaoP.buscarProyectoCliente(VPro.getjTextFieldBuscarProyecto().getText().trim());
        
        if(BProyecto.next())
        {
            if(BProyecto.getString("estatus").equals("S"))
            {   
                Rutinas.Aviso("El proyecto se encuentra suspendido, Para "
                            + "reactivarlo por favor comuníquese con el administrador.", "");
                cancelar();
                return;
            }else{   
                operacion='M';
                VPro.getjTextFieldDescripcion().setText(BProyecto.getString("descripcion").trim());
                VPro.getjDateChooserFechaInicio().setDate(BProyecto.getDate("fechainicio"));
                VPro.getjDateChooserFechaFin().setDate(BProyecto.getDate("fechaculminacion"));
                VPro.getjTextFieldBuscarCliente().setText(BProyecto.getString("idcliente").trim());
                VPro.getjTextFieldRazonSoc().setText(BProyecto.getString("nombre").trim());
                VPro.getjTextFieldMonto().setText(BProyecto.getString("monto"));
                VPro.getjTextFieldHoras().setText(BProyecto.getString("horas"));
                
                habilitar(true);
                deshabilitar(false);
            }
        } else{
            if(VPro.getjTextFieldBuscarProyecto().getText().trim().length()==0)
            {
                Rutinas.Aviso("El campo está vacío", "");
                VPro.getjTextFieldBuscarProyecto().requestFocusInWindow();
                return;
            }
            int resp = JOptionPane.showConfirmDialog(null, "El Proyecto no existe. ¿Desea registrarlo?", "", JOptionPane.YES_NO_OPTION);
            if(resp != 1){
                operacion='I'; 
                habilitar(true);
                deshabilitar(false);
                BProyecto.close();
            } else{
                limpiarCampos();

            /* habilitar(true);
             deshabilitar(false);
             BProyecto.close(); */
            }
           } 
    }
    private void buscarCliente() throws SQLException
    {
        DaoCliente daop= new DaoCliente();
        ResultSet cliente;
        
        cliente = daop.buscarCliente(VPro.getjTextFieldBuscarCliente().getText());
        if(cliente.next())
        {
                
                VPro.getjTextFieldRazonSoc().setText(cliente.getString("nombre").trim());
                VPro.getjButtonRegistrar().setEnabled(true);
        }
        else
        {
            Rutinas.Aviso("El cliente no se encuentra registrado","");
        }
    }
//===============================================     
    private void cancelar()
    {
        limpiarCampos();
        VPro.getjButtonEliminar().setEnabled(false);
    }
//===============================================  
    private void limpiarCampos( )
    {
        VPro.getjTextFieldBuscarProyecto().requestFocusInWindow();
        VPro.getjTextFieldBuscarProyecto().setText("");
        VPro.getjTextFieldDescripcion().setText("");
        VPro.getjTextFieldDescripcion().setEditable(false);
        
        VPro.getjTextFieldHoras().setText("");
        VPro.getjTextFieldHoras().setEditable(false);
        
        VPro.getjButtonBuscarCliente().setEnabled(false);
        VPro.getjTextFieldBuscarCliente().setText("");
        VPro.getjTextFieldBuscarCliente().setEditable(false);
        VPro.getjTextFieldRazonSoc().setText("");
        VPro.getjTextFieldMonto().setText("");
        VPro.getjTextFieldMonto().setEditable(false);
        
        VPro.getjDateChooserFechaFin().setDate(null);
        VPro.getjDateChooserFechaFin().setEnabled(false);
        VPro.getjDateChooserFechaInicio().setDate(null);
        VPro.getjDateChooserFechaInicio().setEnabled(false);
        
        habilitar(false);
        deshabilitar (true);
        operacion = ' '; 
    }
//================================================    
    private void habilitar(boolean e)
    {
        VPro.getjTextFieldDescripcion().setEditable(e);
        VPro.getjTextFieldHoras().setEditable(e);
        
        VPro.getjButtonBuscarCliente().setEnabled(e);
        VPro.getjTextFieldBuscarCliente().setEditable(e);
        
        VPro.getjDateChooserFechaInicio().setEnabled(e);
        VPro.getjDateChooserFechaFin().setEnabled(e);
        VPro.getjTextFieldMonto().setEditable(e);
        
        VPro.getjButtonCargo().setEnabled(e);
        VPro.getjButtonCancelar().setEnabled(e);
        VPro.getjButtonEliminar().setEnabled(e);
        VPro.getjButtonRegistrar().setEnabled(e);
    }
//=================================================      
    private void deshabilitar(boolean d)
    {
        VPro.getjButtonBuscarProyecto().setEnabled(d);
        VPro.getjTextFieldBuscarProyecto().setEditable(d);
    }
//============================================
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource().equals(VPro.getjButtonCargo()))
        {
           String cod;
           cod=VPro.getjTextFieldBuscarProyecto().getText();
           String desc;
           desc=VPro.getjTextFieldDescripcion().getText();
           
          // VPro.dispose();
            try {
                new CAgCargo(cod, desc);
            } catch (SQLException ex) {
                Logger.getLogger(CProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
    
        if(e.getSource().equals(VPro.getjButtonRegistrar()))
        {
            try {
                Registrar();
            } catch (SQLException ex) {
                Logger.getLogger(CProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        
        if(e.getSource().equals(VPro.getjButtonEliminar()))
        {
            Eliminar();
            return;
        }
        
        if(e.getSource().equals(VPro.getjButtonCancelar()))
        {
            cancelar();
            return;
        }
        
        if(e.getSource().equals(VPro.getjButtonBuscarProyecto()))
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
        
        if(e.getSource().equals(VPro.getjButtonBuscarCliente()))
        {
            try {
                buscarCliente();
            } catch (SQLException ex) {
                Logger.getLogger(CProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        
        if(e.getSource().equals(VPro.getjButtonRegresar()))
        {
            VPro.dispose();
            return;
        }
    }
//============================================    
    private void BuscarProyectokeyTyped(KeyEvent e)
    {
       if(VPro.getjTextFieldBuscarProyecto().getText().trim().length()==10)
        {
            e.consume();
            return;
        }
    }
    private void DescripcionkeyTyped(KeyEvent e)
    {
       if(VPro.getjTextFieldDescripcion().getText().trim().length()==40)
        {
            e.consume();
            return;
        }
    }     
    private void BuscarClientekeyTyped(KeyEvent e)
    {    
        if(VPro.getjTextFieldBuscarCliente().getText().trim().length()==10)
        {
            e.consume();
            return;
        }
    }
    private void RazonSocialkeyTyped(KeyEvent e)
    {
        if(VPro.getjTextFieldRazonSoc().getText().trim().length()==30)
        {
            e.consume();
            return;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
        if(e.getSource().equals(VPro.getjTextFieldBuscarProyecto()))
        {
            BuscarProyectokeyTyped(e);    
        }
        if(e.getSource().equals(VPro.getjTextFieldDescripcion()))
        {
           DescripcionkeyTyped(e);
        }
        
        if(e.getSource().equals(VPro.getjTextFieldBuscarCliente()))
        {
            BuscarClientekeyTyped(e);
        }
        if(e.getSource().equals(VPro.getjTextFieldRazonSoc()))
        {
            RazonSocialkeyTyped(e);
        }
        
        VPro.getjButtonCancelar().setEnabled(true);
    }
//============================================
    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
