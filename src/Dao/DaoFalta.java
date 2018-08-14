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
import Modelo.MFalta;
import java.sql.ResultSet;
import java.util.Date;


public class DaoFalta extends ClassConexionDAO{
    
    public void registrarFaltas(MFalta mf)
    {
        String sql;
        sql="INSERT INTO permiso(idcandidato, descripcion, fecha, estatus,";
        sql=sql + "cantidadhoras) VALUES (";
        sql=sql + Rutinas.Apost(mf.getIdCandidato())+ ",";
        sql=sql + Rutinas.Apost(mf.getDescripcion())+",";
        sql=sql + Rutinas.Apost(mf.getFecha().toString())+",";
        sql=sql + Rutinas.Apost(mf.getEstatus())+",";
        sql=sql + mf.getCanthoras()+ ")";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);         
    }
    
    public ResultSet buscarxEmpleado(String idcandidato)
    {
        ResultSet falt;
        String sql;
        
        sql = "SELECT fecha, candidato.identificador as cid, nombre, apellido,";
        sql = sql + "descripcion, permiso.estatus as ptipo, cantidadhoras FROM candidato, permiso WHERE candidato.identificador=";
        sql = sql + Rutinas.Apost(idcandidato) + " AND candidato.identificador=permiso.idcandidato";
        
        falt= PackageConeccion.ConeccionBD.consultar(sql);
        
        return falt;
    }
    
    public ResultSet buscarxFecha(Date fechai, Date fechaf)
    {
        ResultSet falt;
        String sql;
        
        sql = "SELECT DISTINCT fecha, candidato.identificador as cid, nombre, apellido,";
        sql = sql + "descripcion, permiso.estatus as ptipo, cantidadhoras FROM candidato, permiso WHERE ";
        sql = sql + "permiso.fecha BETWEEN '" + fechai + "' AND '" + fechaf + "'";
        sql = sql + " AND candidato.identificador=permiso.idcandidato";
        
        falt = PackageConeccion.ConeccionBD.consultar(sql);
        return falt;
    }
    
    public ResultSet buscarxEmpFecha(Date fechai, Date fechaf, String idcandidato)
    {
        ResultSet falt;
        String sql;
        
        sql = "SELECT DISTINCT fecha, candidato.identificador as cid, nombre, apellido,";
        sql = sql + "descripcion, permiso.estatus as ptipo, cantidadhoras FROM candidato, permiso WHERE candidato.identificador=";
        sql = sql + Rutinas.Apost(idcandidato) + " AND fecha BETWEEN '" + fechai + "' AND '" + fechaf + "'";
        sql = sql + " AND candidato.identificador=permiso.idcandidato";
        
        falt = PackageConeccion.ConeccionBD.consultar(sql);
        return falt;
    }
    
}
