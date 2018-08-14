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
import Modelo.MAsignarCand;


public class DaoAsigCand extends ClassConexionDAO{
    
    public void AsigCand(MAsignarCand MAsig)
    {        
        String sql;
        sql = "INSERT INTO modopago(idcandidato, tipomoneda, sueldo, tipopago) VALUES (";
        sql=sql + Rutinas.Apost(MAsig.getIdCand()) + ", ";
        sql=sql + "'" + MAsig.getTMoneda() + "'" + ", ";
        sql=sql + MAsig.getSueldo() + ", ";
        sql=sql + "'" + MAsig.getTPago() + "'" + ")";
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
        
    }
    
    public void ActualizarCand(MAsignarCand MAsig)
    {
        String sql;
        sql="UPDATE candidato SET estatus='E' WHERE identificador='" + MAsig.getIdCand() + "'";
        
        
        PackageConeccion.ConeccionBD.ejecutar(sql);
                
        
    }
    
}
