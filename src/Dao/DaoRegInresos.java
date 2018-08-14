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

import Modelo.ClassConexionDAO;
import Modelo.MIngresos;
import java.sql.ResultSet;

/**
 *
 * @author Joselyn
 */
public class DaoRegInresos extends ClassConexionDAO
{
        public void regIngreso(MIngresos mi)
        {
            String sql;
            
            sql="INSERT INTO ingreso (monto, mes, anno, codproyecto) VALUES (";
            sql= sql + mi.getMonto() + ", " + mi.getMes() + ", "+ mi.getAnno() + ", '" + mi.getCodProy() +"')";
            
            PackageConeccion.ConeccionBD.ejecutar(sql);
        }
        
        public ResultSet buscIng(String cod, int mes)
        {
            ResultSet ing;
            String sql;
            
            sql="SELECT * FROM ingreso WHERE codproyecto='"+cod+"' and mes="+mes+"";
            
            ing=PackageConeccion.ConeccionBD.consultar(sql);
            
            return ing;
        }
}
