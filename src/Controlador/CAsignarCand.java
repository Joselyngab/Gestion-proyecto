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
import Dao.DaoProyecto;
import Libreria.Rutinas;
import Vista.VAsignarCand;
import Vista.VPago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class CAsignarCand implements ActionListener, MouseListener, KeyListener {

     private VAsignarCand VAsig;

    public CAsignarCand() throws SQLException {
        VAsig = new VAsignarCand();
        VAsig.agregarListener(this);
        VAsig.agListener(this);
        VAsig.setVisible(true);
        //CargarGrid();
        
        VAsig.getjTextFieldBusqProy().addKeyListener(this);
    }
    
    VPago Vp=new VPago();
    
    private void Cancelar()
    {
        VAsig.getjButtonBuscar().setEnabled(false);
        VAsig.getjButtoncancelar().setEnabled(false);
        VAsig.getjTextFieldBusqProy().setText("");
        VAsig.getjTextFieldDesc().setText("");
        limpiarTabla();
    }
    
    private void limpiarTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel) VAsig.getjTableList().getModel();
    int i=0;
        while (i <VAsig.getjTableList().getRowCount()) {
           modelo.removeRow(i);
               }
        modelo.addRow(new Object[]{"", "", "", "", "", ""});

    }
    
    
    //----------MODIFICADO-------------------
     private void CargarGridAsig() throws SQLException
    {
         DefaultTableModel modelo = (DefaultTableModel) VAsig.getjTableList().getModel();
         
          java.util.Date fechahoy = new Date();             //Obtiene la fecha actual
          
        int Fila=0;
        ResultSet carg;
       
        DaoProyecto DaoP = new DaoProyecto();
        carg = DaoP.BuscarProyectoCand(VAsig.getjTextFieldBusqProy().getText());
        
        
       
            if(!carg.next())
            {
                Rutinas.Aviso("No se han encontrado coincidencias", "ERROR");
                return;
            }
            else
            {
                Date fecha=carg.getDate("fecha");
        
                if(fecha.before(fechahoy))
                {
                    Rutinas.Aviso("El proyecto ha caducado por lo que no se pueden asignar candidatos. Por favor seleccione un nuevo proyecto", "ERROR");
                    Cancelar();
                    return;
                }
                else
                {
                    if("S".equals(carg.getString("estatus")))
                    {
                        Rutinas.Aviso("El proyecto está suspendido. Por favor seleccione un nuevo proyecto", "");
                        Cancelar();
                        return;
                    }
                }
            }
            VAsig.getjTextFieldDesc().setText(carg.getString("pdesc"));
        
        do
        {
            String id=carg.getString("identificador");
            String nombre=carg.getString("nombre").trim();
            String apel=carg.getString("apellido");
            String cargo=carg.getString("cdesc");
           
            
            
            VAsig.getjTableList().setValueAt(id, Fila, 0);
            VAsig.getjTableList().setValueAt(nombre, Fila, 1);
            VAsig.getjTableList().setValueAt(apel, Fila, 2);
            VAsig.getjTableList().setValueAt(cargo, Fila, 3);
           
            
            Fila++;
                   modelo.addRow(new Object[]{"", "", "", "", "", ""});
        }while(carg.next());
        
            VAsig.getjButtonBuscar().setEnabled(false);
            VAsig.getjTextFieldBusqProy().setEditable(false);
    }
     
    private void Buscar()
    {
        
       
        
        if(VAsig.getjTextFieldBusqProy().getText().trim().length()==0)
        {
            
            Rutinas.Aviso("Favor Ingrese la descripción de la búsqueda", "ADVERTENCIA");
            return;
        }
        else
        {
            try {
                    CargarGridAsig();
                } catch (SQLException ex) {
                    Logger.getLogger(CAsignarCand.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
    }
    //TERMINAR DE ACOMODAR
    private void CargarGrid() throws SQLException
    {
        int Fila=0;
        ResultSet carg;
       // DaoAsigCand daoAsig = new DaoAsigCand();
        DaoCandidato daoCand = new DaoCandidato();
        carg = daoCand.buscarCandidato("22271356");
        
        while(carg.next())
        {
            VAsig.getjTableList().setValueAt(carg.getString("identificador"), Fila, 0);
            VAsig.getjTableList().setValueAt(carg.getString("nombre"), Fila, 1);
            VAsig.getjTableList().setValueAt(carg.getString("apellido"), Fila, 2);
            VAsig.getjTableList().setValueAt(carg.getString("telefono"), Fila, 3);
            Fila++;
            
        }
        
    }
    
    private void BuscarProy() throws SQLException
    {
        ResultSet Busq;
        DaoProyecto DaoProy = new DaoProyecto();
        
        String cod = (String) VAsig.getjTextFieldBusqProy().getText().trim();
        Busq = DaoProy.BuscarP(cod);
        
        while(Busq.next())
        {
            VAsig.getjTextFieldDesc().setText(Busq.getString("descripcion"));
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(VAsig.getjButtonRegresar()))
        {
            VAsig.dispose();
        }
        else
        {
            if(e.getSource().equals(VAsig.getjButtoncancelar()))
            {
                Cancelar();
            }
            else
                if(e.getSource().equals(VAsig.getjButtonBuscar()))
                {
                    Buscar();
                
                }
        }
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    public void BusqKeyTyped(KeyEvent e)
    {
        char car = e.getKeyChar();
        if(car==(char)KeyEvent.VK_SPACE)
            e.consume();
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        if(e.getSource().equals(VAsig.getjTextFieldBusqProy()))
        {
            VAsig.getjButtonBuscar().setEnabled(true);
            VAsig.getjButtoncancelar().setEnabled(true);
            BusqKeyTyped(e);
            
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
     
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
}
