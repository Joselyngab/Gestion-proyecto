/*
*    Proyecto de Laboratorio 1 (Sección 1)
*     Integrantes:
*     Canelon Valmore CI: 22270191
*     Cohen Kevin  CI: 20670359
*     Jiménez Jaimary CI: 22263583
*     Lugo Brisleidy CI: 22181168
*     Serrano Joselyn CI: 22271356
*/
package Modelo;

public class MCandidato 
{
    
    private String identificador;
    private String nombre;
    private String apellido;
    private String sexo;
    private String telefono;
    private String correo;
    private String nacionalidad;
    private String estadoProvincia;
    private String curriculum;
         

    public MCandidato(String identificador, 
                      String nombre, 
                      String apellido, 
                      String sexo,
                      String telefono, 
                      String correo,  
                      String nacionalidad,
                      String estadoProvincia,
                      String curriculum) 
    {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.telefono = telefono;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
        this.estadoProvincia = estadoProvincia;
        this.curriculum = curriculum;
    }

    public MCandidato() {
        this.apellido="";
        this.correo="";
        this.estadoProvincia="";
        this.nacionalidad="";
        this.nombre="";
        this.sexo="";
        this.telefono="";
        this.identificador="";
        
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstadoProvincia() {
        return estadoProvincia;
    }

    public void setEstadoProvincia(String estadoProvincia) {
        this.estadoProvincia = estadoProvincia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    }

