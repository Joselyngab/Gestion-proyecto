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
import Modelo.MFeriado;
import java.sql.ResultSet;
import java.util.Date;



public class DaoFeriado extends ClassConexionDAO{
    
    public void insertFeriado(MFeriado mf){
       
        
        String sql;
        sql="INSERT INTO feriado(fecha, descripcion, estatus) VALUES (";
        sql=sql + Rutinas.Apost(mf.getFecha().toString()) + ",";
        sql=sql + Rutinas.Apost(mf.getDescripcion()) + ",";
        sql=sql + "'F')";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
        
        
        
    }
    
    public void modificarFeriado(MFeriado mf){
      String sql;
       sql=" UPDATE feriado SET descripcion=";
       sql= sql + Rutinas.Apost(mf.getDescripcion());  
       sql= sql + " WHERE fecha=" + Rutinas.Apost(mf.getFecha().toString());
       
       PackageConeccion.ConeccionBD.ejecutar(sql);
    }
    
    public void eliminarFeriado(Date fecha){
        
       String sql;
       
       sql=" DELETE FROM feriado" ;
       sql= sql + " WHERE fecha=" + Rutinas.Apost(fecha.toString());
       
       PackageConeccion.ConeccionBD.ejecutar(sql);
        
    }
    
    public ResultSet buscarFeriado(Date fecha){
        
        ResultSet regferiado;
        
        String sql;
        
        sql = "Select * from feriado Where fecha=";
        sql = sql + Rutinas.Apost(fecha.toString())+" and estatus='F'";
        
        regferiado = PackageConeccion.ConeccionBD.consultar(sql);
        
        return regferiado;     
    }
    
}
