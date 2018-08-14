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
import Modelo.MCandidato;
import java.sql.ResultSet;

public class DaoCandidato extends ClassConexionDAO
{
       public void insertarCandidato (MCandidato mc)
    {
        String sql; 
        sql=" INSERT INTO candidato(identificador, nombre, apellido, correo, nacionalidad,";
        sql=sql+ "estado_provincia, estatus, curriculum, telefono, sexo)";
        sql=sql+" VALUES (";
        sql=sql+Rutinas.Apost(mc.getIdentificador())+",";
        sql=sql+Rutinas.Apost(mc.getNombre())+",";
        sql=sql+Rutinas.Apost(mc.getApellido())+",";
        sql=sql+Rutinas.Apost(mc.getCorreo())+",";
        sql=sql+Rutinas.Apost(mc.getNacionalidad())+",";
        sql=sql+Rutinas.Apost(mc.getEstadoProvincia())+",";
        sql=sql+"'A',";
        sql=sql+Rutinas.Apost(mc.getCurriculum())+ ",";
        sql=sql+Rutinas.Apost(mc.getTelefono())+ ",";
        sql=sql+Rutinas.Apost(mc.getSexo())+")";
    
      
     PackageConeccion.ConeccionBD.ejecutar(sql);    }
   
    public void modificarCandidato (MCandidato mc)
    {
        String sql;
        sql="UPDATE candidato SET  nombre=";
        sql=sql+Rutinas.Apost(mc.getNombre())+",";
        sql=sql+"apellido="+Rutinas.Apost(mc.getApellido())+",";
        sql=sql+"correo="+Rutinas.Apost(mc.getCorreo())+",";
        sql=sql+"nacionalidad="+Rutinas.Apost(mc.getNacionalidad())+",";
        sql=sql+"estado_provincia="+Rutinas.Apost(mc.getEstadoProvincia())+",";
        sql=sql+"curriculum="+Rutinas.Apost(mc.getCurriculum())+",";
        sql=sql+"telefono="+Rutinas.Apost(mc.getTelefono())+",";
        sql=sql+"sexo="+Rutinas.Apost(mc.getSexo());
        sql=sql+" WHERE identificador="+Rutinas.Apost(mc.getIdentificador())+"";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
    }   



public void eliminarCandidato (String idcand){
        
       String sql;
       
       sql=" UPDATE candidato SET estatus= 'S'" ;
      
       sql= sql + " WHERE identificador=" + Rutinas.Apost(idcand)+"";      
       PackageConeccion.ConeccionBD.ejecutar(sql);
        
    }             
    public void insertCualidades(String desc,String idcand)
    {
        String sql;
        
        sql="INSERT INTO cualidadcandidato(idcandidato, descripcion)";
        sql=sql+"VALUES ("+Rutinas.Apost(idcand)+",";
        sql=sql+Rutinas.Apost(desc)+")";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
        
        
    }


            
    public ResultSet buscarCandidato (String identificador)
    {
        ResultSet regcandidato;
        
        String sql;
        
        sql = "Select * from candidato Where identificador=";
        sql = sql + Rutinas.Apost(identificador)+"";
        
        regcandidato = PackageConeccion.ConeccionBD.consultar(sql);
        
        return regcandidato; 
    }
    
    public ResultSet BuscarNombre(String nombre)
    {
        ResultSet Cand;
        
        String sql;
        sql = "Select * from candidato Where nombre='" + nombre + "'";
        
        Cand=PackageConeccion.ConeccionBD.consultar(sql);
        return Cand;
    }
    
    public ResultSet BuscarApellido(String apel)
    {
        ResultSet Cand;
        
        String sql;
        sql = "Select * from candidato Where apellido='" + apel + "'";
        
        Cand=PackageConeccion.ConeccionBD.consultar(sql);
        return Cand;
    }
      
public ResultSet BuscarCualidad (String palabra, String id)
{
        ResultSet cand;
        
        String sql;
        
        sql="SELECT * FROM cualidadcandidato Where cualidadcandidato.descripcion='" + palabra + "' ";
        sql=sql + "and cualidadcandidato.idcandidato='"+id+"'";
        cand =PackageConeccion.ConeccionBD.consultar(sql);
        
        return cand;

}

 public ResultSet buscarCualidades (String identificador)
    {
       ResultSet cual;
       String sql;
       sql = "Select * from cualidadcandidato where idcandidato='"+ identificador+"'";
       cual = PackageConeccion.ConeccionBD.consultar(sql);
       return cual;
    } 
public void eliminarCualidad(String id)
{
    String sql;
    sql="DELETE FROM cualidadcandidato WHERE idcandidato='"+id+"'";
    PackageConeccion.ConeccionBD.ejecutar(sql);
    
            
}

public ResultSet buscarPal(String id)
{
    ResultSet b;
    String sql;
    sql="SELECT * FROM cualidadcandidato WHERE idcandidato='"+id+"'";
    b=PackageConeccion.ConeccionBD.consultar(sql);
    return b;
}
 
public ResultSet BuscarPalabra (String palabra)
{
        ResultSet cand;
        
        String sql;
        
        sql="SELECT * FROM cualidadcandidato, candidato Where cualidadcandidato.descripcion='" + palabra + "' ";
        sql=sql + "and cualidadcandidato.idcandidato=candidato.identificador";
        cand =PackageConeccion.ConeccionBD.consultar(sql);
        
        return cand;

}

//----------------AGREGADO----------------
    public void liberarCandidato (String idcand)
    {
        
       String sql;
       
       sql=" UPDATE candidato SET estatus= 'A'" ;
      
       sql= sql + " WHERE identificador=" + Rutinas.Apost(idcand)+"";      
       PackageConeccion.ConeccionBD.ejecutar(sql);
        
    }    

    //--------------NUEVO-------------------
    
    public ResultSet bCandidato()
    {
        ResultSet cand;
        String sql;
        sql="SELECT * FROM candidato";
        
        cand =PackageConeccion.ConeccionBD.consultar(sql);
        
        return cand;

    }
    

            }


