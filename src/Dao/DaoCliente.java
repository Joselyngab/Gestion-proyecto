/*
*    Proyecto de Laboratorio 1 (Sección 1)
*     Integrantes:
*     Canelon Valmore CI: 22270191
*     Cohen Kevin  CI: 20670359
*     Jiménez Jaimary CI: 22263583
*     Lugo Brisleidy CI: 22181168
*     Serrano Joselyn CI: 22271356
*/
package Dao;

import Libreria.Rutinas;
import Modelo.ClassConexionDAO;
import Modelo.MCliente;
import java.sql.ResultSet;


public class DaoCliente extends ClassConexionDAO{
    
    public void insertcliente(MCliente mc){
        String sql;
        sql="INSERT INTO cliente(identificador, nombre, correo, pais, estatus,";
        sql=sql+"estado_provincia, telefono) VALUES(";
        sql=sql + Rutinas.Apost(mc.getCodigo()) + ",";
        sql=sql + Rutinas.Apost(mc.getRazonsocial()) + ",";
        sql=sql + Rutinas.Apost(mc.getCorreo()) + ",";
        sql=sql + Rutinas.Apost(mc.getNacionalidad())+ ",";
        sql=sql + "'A',";
        sql=sql + Rutinas.Apost(mc.getEstado_provincia())+ ",";
        sql=sql + Rutinas.Apost(mc.getTelefono())+ ")";
        
         PackageConeccion.ConeccionBD.ejecutar(sql);  
    }
    
    public void modificarCliente(MCliente mc)
    {
        String sql;
        sql="UPDATE cliente SET ";
        sql= sql + "nombre=" + Rutinas.Apost(mc.getRazonsocial()) + ",";
        sql= sql + "correo=" + Rutinas.Apost(mc.getCorreo()) + ",";
        sql= sql + "pais=" + Rutinas.Apost(mc.getNacionalidad()) + ",";
        sql= sql + "estatus='A',";
        sql= sql + "estado_provincia=" + Rutinas.Apost(mc.getEstado_provincia()) + ",";
        sql= sql + "telefono=" + Rutinas.Apost(mc.getTelefono());
        sql= sql + " WHERE identificador=" + Rutinas.Apost(mc.getCodigo());
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
    }
    
    public ResultSet buscarCliente(String identificador)
    {
        ResultSet regCliente;
        
        String sql;
        sql= "SELECT * FROM cliente WHERE identificador=";
        sql = sql + Rutinas.Apost(identificador)+"";
        
        regCliente = PackageConeccion.ConeccionBD.consultar(sql);
        return regCliente;           
    }
    
    
    public void eliminarCliente(MCliente mc)
    {
       String sql;       
       sql=" UPDATE cliente SET estatus= 'E'" ;
      
       sql= sql + " WHERE identificador=" + Rutinas.Apost(mc.getCodigo());
       
       PackageConeccion.ConeccionBD.ejecutar(sql);        
    }
    
    public ResultSet buscarProyAct(String ident) // Debe ir en el DaoProyecto
    {
        ResultSet regCliente;
        String sql;
        ident = ident.trim();
        
        sql= "SELECT * FROM cliente,proyecto WHERE codigo= ";
        sql= sql + Rutinas.Apost(ident) + " AND cliente.identificador=proyecto.idcliente";
        sql= sql + " AND proyecto.estatus='A'"+"";
        
        regCliente = PackageConeccion.ConeccionBD.consultar(sql);
        return regCliente;
    }
    
}
