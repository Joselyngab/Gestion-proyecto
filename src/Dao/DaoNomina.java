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
import Modelo.MNomina;
import java.sql.ResultSet;
import java.util.Date;

public class DaoNomina extends ClassConexionDAO{
    
    public void insertNomina(MNomina mn){
       
        
        String sql;
        sql="Insert INTO nomina(nrohorastrab, montopagado, idcandidato, mes, montoneto, anno) VALUES (";
        sql=sql + mn.getNroHoras()+",";
        sql=sql + mn.getMontopagado()+",";
        sql=sql + Rutinas.Apost(mn.getIdcandidato()) + ",";
        sql=sql + mn.getMes() + ","; 
        sql=sql + mn.getMontoneto()+", "+ mn.getAnno()+")";
        
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
        
        
       
    
   }
//para la consulta record
  public ResultSet buscarxmes(int mes,int anno){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select *";
       sql=sql+"from nomina,candidato where nomina.mes="+mes;
       sql=sql+"and nomina.anno="+anno+"and nomina.idcandidato=candidato.identificador"+"";
       
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
   }
   
    public ResultSet buscarxemp(String emp){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select montoneto,identificador,nombre,apellido from nomina,candidato";
       sql=sql+" where idcandidato="+ Rutinas.Apost(emp);
       sql=sql+" and nomina.idcandidato=candidato.identificador"+"";
       
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
   }
     public ResultSet buscarxproy(String proy){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select montoneto,identificador,";
       sql=sql+"nombre,apellido from nomina,entrevista,candidato,tipoentrevista where";
       sql=sql+" entrevista.codproyecto="+Rutinas.Apost(proy);
       sql=sql+"and entrevista.idcandidato=candidato.identificador";
       sql=sql+" and nomina.idcandidato=candidato.identificador and ";
       sql=sql+"entrevista.codtipoent=1 and entrevista.codtipoent=tipoentrevista.codigo"+"";
       
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
   }
      public ResultSet buscarxMesyEmp(int mes,int anno,String emp){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select *";
       sql=sql+"from nomina,candidato where nomina.mes="+mes+" and nomina.anno=";
       sql=sql+anno+" and nomina.idcandidato="+Rutinas.Apost(emp);
       sql=sql + "and candidato.identificador=nomina.idcandidato"+"";
       
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
   }
       public ResultSet buscarxMesyProy(int mes,int anno,String proy){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select nombre, apellido, montoneto, identificador from nomina,entrevista,";
       sql=sql+"candidato where nomina.mes="+mes+" and nomina.anno="+anno;
       sql=sql+"and entrevista.codproyecto="+Rutinas.Apost(proy);
       sql=sql+"and nomina.idcandidato=candidato.identificador ";
       sql=sql+"and nomina.idcandidato=entrevista.idcandidato"+"";
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
       }
       
 public ResultSet buscarnomina(String idcand){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select * from candidato,modopago where candidato.identificador="+Rutinas.Apost(idcand)+" and";
       sql=sql+" modopago.idcandidato=candidato.identificador and candidato.estatus='E'";
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
       }
       
       public ResultSet Buscarp(String id)
       {
            ResultSet resultnom;
       String sql; 
      
       sql = "Select * from nomina where idcandidato='" + id + "'";
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;
       }     
          
         public ResultSet buscarFeriado (int mes, int ultdia, int anno)
              
      {
          ResultSet resulferi;
          String sql;
          sql = "Select * from feriado where fecha between '"+anno+"-"+ mes +"-01' and '"+anno+"-"+mes+"-"+ultdia+"'";
          resulferi = PackageConeccion.ConeccionBD.consultar(sql);
          return resulferi;
      }
         
             public ResultSet buscarxproy1 (String proy)
         {
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select nrohorastrab,identificador,";
       sql=sql+"nombre,apellido from nomina,entrevista,candidato where";
       sql=sql+" entrevista.codproyecto="+Rutinas.Apost(proy);
       sql=sql+"and entrevista.idcandidato=candidato.identificador";
       sql=sql+" and nomina.idcandidato=candidato.identificador"+"";
       
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

      }
         
        public ResultSet buscarxemp1 (String emp){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select nrohorastrab,identificador,nombre,apellido from nomina,candidato where idcandidato=";
       sql=sql + Rutinas.Apost(emp)+"and nomina.idcandidato=candidato.identificador"+"";
       
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
   } 
               //Este
        public ResultSet buscarxMesyEmp1(int mes,int anno,String emp){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select *";
       sql=sql+"from nomina,candidato where nomina.mes="+mes+" and nomina.anno=";
       sql=sql+anno+" and nomina.idcandidato="+Rutinas.Apost(emp);
       sql=sql + "and candidato.identificador=nomina.idcandidato"+"";
       
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
   }
        //Este
       public ResultSet buscarxMesyProy1(int mes,int anno,String proy){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select nombre, apellido, nrohorastrab, identificador from nomina,entrevista,";
       sql=sql+"candidato where nomina.mes="+mes+" and nomina.anno="+anno;
       sql=sql+"and entrevista.codproyecto="+Rutinas.Apost(proy);
       sql=sql+"and nomina.idcandidato=candidato.identificador ";
       sql=sql+"and nomina.idcandidato=entrevista.idcandidato"+"";
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
       }
       ///Este 
       public ResultSet buscarxmes1(int mes,int anno){
       
       ResultSet resultnom;
       String sql; 
       
       sql="Select *";
       sql=sql+"from nomina,candidato where nomina.mes="+mes;
       sql=sql+"and nomina.anno="+anno+"and nomina.idcandidato=candidato.identificador"+"";
       
       resultnom = PackageConeccion.ConeccionBD.consultar(sql);
       return resultnom;

       
   }
    //// Este   
        public ResultSet buscarmes (String id, int mes)
        {
          ResultSet resulmes;
          String sql;
          
          sql = "Select * from nomina where mes = "+mes+"and idcandidato= '"+id+"'";
          resulmes = PackageConeccion.ConeccionBD.consultar(sql);
           return resulmes;
        }

}

