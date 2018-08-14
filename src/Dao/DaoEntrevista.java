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
import Modelo.MEntrevista;
import java.sql.ResultSet;
import java.util.Date;

public class DaoEntrevista extends ClassConexionDAO
{   

    public void registrarEntrevista(MEntrevista mEnt)
    {
        String sql;
        
       sql = "INSERT INTO entrevista(descripcion, fecha, identrevistador, "; 
        sql = sql + "observaciones, modalidad, calificacion, codproyecto, salarioofertado, ";
        sql = sql + "salariopretendido, codtipoent, codcargo, idcandidato) VALUES ('";
        sql = sql + mEnt.getDescripcion() + "', '";
        sql = sql + mEnt.getFecha() +"', '";
        sql = sql + mEnt.getIdentrevistador() + "', '";
        sql = sql + mEnt.getObservacion() + "', '";
        sql = sql + mEnt.getModalidad() +"', '";
        sql = sql + mEnt.getCalificacion() +"', '";
        sql = sql + mEnt.getCodigoproyecto() + "', ";
        sql = sql + mEnt.getSalarioofertado() +", "; 
        sql = sql + mEnt.getSalariopretendido() +", ";
        sql = sql + mEnt.getCodigotipoentrevista() +", ";
        sql = sql + mEnt.getCodigocargo() +", '";
        sql = sql + mEnt.getIdcandidato() +"')";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
    }
    public ResultSet buscarEntrevistador(String identificador)
    {
        ResultSet buscarEnt;
        String sql;
       // identificador = identificador.trim();
        
        sql = "SELECT * FROM entrevistador WHERE identificador=" + Rutinas.Apost(identificador)+"";
        
        buscarEnt = PackageConeccion.ConeccionBD.consultar(sql);
        return buscarEnt;
    }   
    
    
     public ResultSet buscarEnt(String identificador, String cod)
    {
        ResultSet buscarEnt;
        String sql;
       
        
        sql = "SELECT * FROM entrevista WHERE idcandidato=" + Rutinas.Apost(identificador)+" and codtipoent=1 and codproyecto='"+cod+"'";
        
        buscarEnt = PackageConeccion.ConeccionBD.consultar(sql);
        return buscarEnt;
    }  
    
    //------------MODIFICADO-----------------
    public ResultSet BuscarProy(String id)
    {
        ResultSet ent;
        String sql;
        
        sql="SELECT fecha, proyecto.descripcion as pdesc, entrevistador.nombre as enombre, entrevistador.apellido as eapel, ";
        sql=sql + "tipoentrevista.descripcion as edesc, candidato.nombre as cnom, candidato.apellido as capel, ";
        sql=sql + "cargo.descripcion as cdesc, observaciones FROM proyecto, entrevista, entrevistador, tipoentrevista, candidato, cargo WHERE proyecto.codigo = '" + id + "' and ";
        sql=sql + "proyecto.codigo = entrevista.codproyecto and entrevistador.identificador=entrevista.identrevistador";
        sql=sql + " and tipoentrevista.codigo=entrevista.codtipoent and entrevista.idcandidato=candidato.identificador";
        sql=sql + " and cargo.codigo=entrevista.codcargo";
               
        
        ent = PackageConeccion.ConeccionBD.consultar(sql);
        
        return ent;
        
    }
    
      //------------MODIFICADO-----------------
    public ResultSet BuscarCand(String id)
    {
        ResultSet ent;
        String sql;
        
        sql="SELECT fecha, proyecto.descripcion as pdesc, entrevistador.nombre as enombre, entrevistador.apellido as eapel,";
        sql=sql + "tipoentrevista.descripcion as edesc, candidato.nombre as cnom, candidato.apellido as capel, ";
        sql=sql + "cargo.descripcion as cdesc, observaciones";
        sql=sql + " FROM proyecto, entrevista, entrevistador, tipoentrevista, candidato, cargo WHERE candidato.nombre = '" + id + "' and ";
        sql=sql + "entrevista.idcandidato=candidato.identificador and proyecto.codigo = entrevista.codproyecto and entrevistador.identificador=entrevista.identrevistador";
        sql=sql + " and tipoentrevista.codigo=entrevista.codtipoent and entrevista.idcandidato=candidato.identificador and entrevista.codcargo=cargo.codigo";
               
        
        ent = PackageConeccion.ConeccionBD.consultar(sql);
        
        return ent;
        
    }
    
    //-----------NUEVO-----------
    //SELECT DISTINCT fecha, proyecto.descripcion as pdesc, entrevistador.nombre as enombre, entrevistador.apellido as eapel, tipoentrevista.descripcion as edesc, candidato.nombre as cnom, candidato.apellido as capel, cargo.descripcion as cdesc, observaciones FROM proyecto, entrevista, entrevistador, tipoentrevista, candidato, cargo WHERE entrevista.fecha BETWEEN '2016-09-09' AND '2016-11-11' 
    
    public ResultSet buscarEnt (Date fecini, Date fecfin)
    {
        ResultSet ent;
        String sql;
        
        sql= "SELECT DISTINCT fecha, proyecto.descripcion as pdesc, entrevistador.nombre as enombre, entrevistador.apellido as eapel,";
        sql= sql + "tipoentrevista.descripcion as edesc, candidato.nombre as cnom, candidato.apellido as capel, ";
        sql=sql + "cargo.descripcion as cdesc, observaciones";
        sql=sql + " FROM proyecto, entrevista, entrevistador, tipoentrevista, candidato, cargo WHERE ";
        sql=sql + "entrevista.fecha BETWEEN '" + fecini + "' AND '" + fecfin +"'";
        sql= sql + " AND candidato.identificador=entrevista.idcandidato AND entrevista.codtipoent=tipoentrevista.codigo AND ";
        sql=sql + "entrevista.codcargo=cargo.codigo and entrevista.codproyecto=proyecto.codigo";
        
        ent = PackageConeccion.ConeccionBD.consultar(sql);
        return ent;
    }
    
    //-----NUEVO---
    
     public ResultSet buscarFecNom (Date fecini, Date fecfin, String nom)
    {
        ResultSet ent;
        String sql;
        
        sql= "SELECT fecha, proyecto.descripcion as pdesc, entrevistador.nombre as enombre, entrevistador.apellido as eapel,";
        sql= sql + "tipoentrevista.descripcion as edesc, candidato.nombre as cnom, candidato.apellido as capel, ";
        sql=sql + "cargo.descripcion as cdesc, observaciones";
        sql=sql + " FROM proyecto, entrevista, entrevistador, tipoentrevista, candidato, cargo WHERE ";
        sql= sql + "candidato.nombre='" + nom +"' AND entrevista.idcandidato=candidato.identificador AND ";
        sql=sql + "entrevista.fecha BETWEEN '" + fecini + "' AND '" + fecfin +"'";
        sql= sql + " AND candidato.identificador=entrevista.idcandidato AND entrevista.codtipoent=tipoentrevista.codigo AND ";
        sql=sql + "entrevista.codcargo=cargo.codigo and entrevista.codproyecto=proyecto.codigo";
        
        
        ent = PackageConeccion.ConeccionBD.consultar(sql);
        return ent;
    }
     
     public ResultSet buscarFechProy(Date fecini, Date fecfin, String cod)
     {
        ResultSet ent;
        String sql;
        
        sql= "SELECT fecha, proyecto.descripcion as pdesc, entrevistador.nombre as enombre, entrevistador.apellido as eapel,";
        sql= sql + "tipoentrevista.descripcion as edesc, candidato.nombre as cnom, candidato.apellido as capel, ";
        sql=sql + "cargo.descripcion as cdesc, observaciones";
        sql=sql + " FROM proyecto, entrevista, entrevistador, tipoentrevista, candidato, cargo WHERE ";
        sql= sql + "proyecto.codigo='" + cod +"' AND entrevista.idcandidato=candidato.identificador AND ";
        sql=sql + "entrevista.fecha BETWEEN '" + fecini + "' AND '" + fecfin +"'";
        sql= sql + " AND candidato.identificador=entrevista.idcandidato AND entrevista.codtipoent=tipoentrevista.codigo AND ";
        sql=sql + "entrevista.codcargo=cargo.codigo and entrevista.codproyecto=proyecto.codigo";
        
        
        ent = PackageConeccion.ConeccionBD.consultar(sql);
        return ent; 
     }

public ResultSet buscarCandidato(String id)
    {
        ResultSet ent;
        String sql;
        
        sql="SELECT * FROM proyecto, entrevista, entrevistador, tipoentrevista, candidato WHERE candidato.identificador = '" + id +"' and ";
        sql=sql + "entrevista.idcandidato=candidato.identificador and proyecto.codigo = entrevista.codproyecto and entrevistador.identificador=entrevista.identrevistador";
        sql=sql + " and tipoentrevista.codigo=entrevista.codtipoent and entrevista.idcandidato=candidato.identificador";
               
        
        ent = PackageConeccion.ConeccionBD.consultar(sql);
        
        return ent;
        
    }
    
    public ResultSet buscarCargo(String cod)
    {
        ResultSet cargo;
        String sql;
        sql="SELECT cargo.descripcion as cdesc FROM cargoproyecto, proyecto, cargo WHERE proyecto.codigo='" + cod + "' ";
        sql=sql+"AND cargoproyecto.codproyecto=proyecto.codigo AND cargo.codigo=cargoproyecto.codcargo ";
        
        cargo=PackageConeccion.ConeccionBD.consultar(sql);
        
        return cargo;
    }
    
    public ResultSet buscCargComp()
    {
        ResultSet cargo;
        String sql;
        sql="SELECT * FROM cargo";
        
        cargo=PackageConeccion.ConeccionBD.consultar(sql);
        
        return cargo;
    }
    
    public ResultSet buscarTipoEntrevista()
    {
        ResultSet tEnt;
        String sql;
        
        sql = "SELECT * FROM tipoentrevista";
        
        tEnt = PackageConeccion.ConeccionBD.consultar(sql);
        return tEnt;
    }
    public ResultSet comboTipo(String cod)
    {
        ResultSet combo;
        String sql;
        
        sql = "SELECT * FROM tipoentrevista WHERE descripcion='"+ cod +"'";
        combo = PackageConeccion.ConeccionBD.consultar(sql);
        
        return combo;
    }
    public ResultSet buscarCargos(String cargo)
    {
        ResultSet cargos;
        String sql;
        sql = "SELECT * FROM cargo WHERE descripcion='"+ cargo +"'";
        cargos = PackageConeccion.ConeccionBD.consultar(sql);
        return cargos;
    }

    //------------AGREGADO-------------
    public ResultSet buscarEntrevista(String cod)
    {
        ResultSet cargos;
        String sql;
        sql = "SELECT * FROM entrevista WHERE codproyecto='"+ cod +"' and codtipoent=1";
        cargos = PackageConeccion.ConeccionBD.consultar(sql);
        return cargos;
    }
    
    public ResultSet buscarEntG(String idc, String cod)
    {
        ResultSet tE;
        String sql;
        sql = "SELECT * FROM entrevista WHERE codtipoent=1 AND codproyecto='" + cod +"' AND idcandidato='"+idc+"'";
        tE = PackageConeccion.ConeccionBD.consultar(sql);
        return tE;
    }

    

}
