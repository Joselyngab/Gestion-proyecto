

package Modelo;


public class ClassConexionDAO 
{	
   public ClassConexionDAO() 
     {
       super();	
       PackageConeccion.ConeccionBD.establecerPropiedadesConeccion("ConexionBD", 
                                                                   "jdbc.driver", 
                                                                   "jdbc.url", 
                                                                   "jdbc.nombrebd", 
                                                                   "jdbc.usuario",
                                                                   "jdbc.password");
       }	

}
