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
import Modelo.MProyecto;
import java.sql.ResultSet;


public class DaoProyecto extends ClassConexionDAO
{
    public void registrarProyecto(MProyecto MPro)
    {
        String sql;
  
        sql = "INSERT INTO proyecto(codigo, descripcion, fechainicio, ";
        sql = sql + "fechaculminacion, idcliente, estatus, monto, horas) VALUES (";
        sql = sql + Rutinas.Apost(MPro.getCodigo())+ ",";
        sql = sql + Rutinas.Apost(MPro.getDescripcion()) + ",";      
        sql = sql + Rutinas.Apost(MPro.getFechainicio().toString()) + ","; 
        sql = sql + Rutinas.Apost(MPro.getFechafin().toString()) + ","; 
        sql = sql + Rutinas.Apost(MPro.getIdcliente()) +",";
        sql = sql + "'A',";
        sql = sql + MPro.getMonto() + ",";
        sql = sql + MPro.getHoras() +")";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
    }
//===================================================    
    public ResultSet buscarProyectoCliente(String codigo)
    {
        
        ResultSet buscarProyecto;
        String sql;
        codigo = codigo.trim();
        
        sql = "SELECT * FROM proyecto,cliente WHERE codigo = ";
        sql = sql + Rutinas.Apost(codigo) +"and proyecto.idcliente=cliente.identificador"+"" ;
        buscarProyecto = PackageConeccion.ConeccionBD.consultar(sql);
        return buscarProyecto;
    }
//===================================================    
    public void modificarProyecto(MProyecto Mpro)
    {
        String sql;
        
        sql = "UPDATE proyecto SET ";
        sql = sql + "descripcion=" + Rutinas.Apost(Mpro.getDescripcion()) +",";
        sql = sql + "fechainicio=" + Rutinas.Apost(Mpro.getFechainicio().toString()) +",";
        sql = sql + "fechaculminacion=" + Rutinas.Apost(Mpro.getFechafin().toString()) +",";
        sql = sql + "idcliente=" + Rutinas.Apost(Mpro.getIdcliente()) +",";
        sql = sql + "monto=" + Mpro.getMonto()+",";
        sql = sql + "horas=" + Mpro.getHoras();
        sql = sql + "WHERE codigo=" + Rutinas.Apost(Mpro.getCodigo())+"";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
    }
    
    
   
    
    public void eliminarProyecto(String cod)
    {
        String sql;
        
        sql = "UPDATE proyecto SET estatus= 'S'";
        sql = sql + " WHERE codigo=" + Rutinas.Apost(cod)+"";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
    }
    
    public ResultSet BuscarP(String codigo)
    {
        ResultSet BuscarProyecto;
        String sql;
        
        
        sql = "SELECT * FROM proyecto WHERE codigo = ";
        sql = sql + Rutinas.Apost(codigo) + "";
       
        BuscarProyecto = PackageConeccion.ConeccionBD.consultar(sql);
        return BuscarProyecto;
    }
    
    
    //----------------MODIFICADO---------------
    
     public ResultSet BuscarProyectoCand(String codigo)
    {
        
        ResultSet BuscarProyecto;
        String sql;
        codigo = codigo.trim();
        
        sql = "SELECT identificador, nombre, apellido, cargo.descripcion as cdesc, proyecto.descripcion as pdesc, proyecto.estatus as estatus,";
        sql= sql + "fechaculminacion as fecha FROM proyecto,candidato,entrevista, cargo WHERE proyecto.codigo = ";
        sql = sql + Rutinas.Apost(codigo) +" and proyecto.codigo=entrevista.codproyecto ";
        sql= sql + "and entrevista.idcandidato=candidato.identificador and cargo.codigo=entrevista.codcargo and candidato.estatus='A'";
        BuscarProyecto = PackageConeccion.ConeccionBD.consultar(sql);
        return BuscarProyecto;
    }
     
   //------------Búsqueda de ingresos y egresos para el cálculo de la utilidad por proyecto----
     
     public ResultSet utilidadProy(String cod)
     {
         ResultSet uti;
         String sql;
         
         sql="SELECT * FROM ingreso WHERE ingreso.codproyecto='" + cod +"'";
         uti=PackageConeccion.ConeccionBD.consultar(sql);
         return uti;
     }
     
     public ResultSet buscarNom (String cod)
     {
         ResultSet uti;
         String sql;
         
         sql="SELECT * FROM nomina, entrevista WHERE entrevista.codproyecto='" + cod +"' and entrevista.idcandidato=nomina.idcandidato";
         sql=sql+" and codtipoent=1";
         uti=PackageConeccion.ConeccionBD.consultar(sql);
         return uti;
     }
     //---modificado---
     //Este método se utiliza para la consulta de utilidad, para buscar por proyecto, proyecto y mes
     public ResultSet UtilidadProyecto(String cod, int mes, int anno)
     {
         ResultSet uti;
         String sql;
         sql="select * from ingreso, entrevista, nomina where ingreso.mes=" + mes +" and ingreso.codproyecto='" + cod +"' ";
         sql= sql+ "and ingreso.anno=" + anno + " and entrevista.codtipoent=1 and entrevista.codproyecto=ingreso.codproyecto";
         sql=sql + "  and entrevista.idcandidato=nomina.idcandidato and nomina.mes=ingreso.mes and nomina.anno=ingreso.anno";
         
         uti=PackageConeccion.ConeccionBD.consultar(sql);
         return uti;
     }
     //--------para la consulta de utilidad por mes
     
     public ResultSet buscarIng (int mes, int anno)
     {
         ResultSet uti;
         String sql;
         
         sql="SELECT * FROM ingreso WHERE mes="+mes+" and anno="+anno+"";
         
         uti=PackageConeccion.ConeccionBD.consultar(sql);
         return uti;
     }
     
     
     public ResultSet buscarEg (int mes, int anno)
     {
         ResultSet uti;
         String sql;
         
         sql="SELECT * FROM nomina WHERE mes="+mes+" and anno="+anno+"";
         
         uti=PackageConeccion.ConeccionBD.consultar(sql);
         return uti;
     }
     //----NUEVO----
     
     public void agCargo(String codp, int codc)
     {
         String sql;
         sql= "INSERT INTO cargoproyecto(codproyecto, codcargo) VALUES('"+codp+"', '"+codc+"')"; 
         PackageConeccion.ConeccionBD.ejecutar(sql);
    
     }
     public ResultSet validarCargo(String codp, int codc)
     {
         ResultSet cargo;
         String sql;
         
         sql="SELECT * FROM cargoproyecto WHERE codproyecto='"+codp+"' and codcargo="+codc+"";
         
         cargo=PackageConeccion.ConeccionBD.consultar(sql);
         return cargo;
     } 
    
     //-------------------AGREGADO-----------
     public ResultSet buscarProyecActivo()
     {
         ResultSet cargo;
         String sql;
         
         sql="SELECT * FROM proyecto WHERE estatus='A'";
         
         cargo=PackageConeccion.ConeccionBD.consultar(sql);
         return cargo;
     }
     //-----AGREGADO---------
     
    public void actualizarProyecto(String cod)
    {
        String sql;
        
        sql = "UPDATE proyecto SET estatus= 'S'";
        sql = sql + " WHERE codigo=" + Rutinas.Apost(cod)+"";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
    }
    
    public ResultSet buscarcarg(String cod)
    {
        ResultSet c;
        String sql;
        sql="SELECT * FROM cargoproyecto WHERE codproyecto='"+cod+"'";
        c=PackageConeccion.ConeccionBD.consultar(sql);
        return c;
    }
}
