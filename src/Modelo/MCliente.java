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


public class MCliente {
    
        private String codigo;
        private String razonsocial;
        private String correo;
        private String nacionalidad;
        private String estado_provincia;
        private String telefono;
            

    public MCliente(String codigo, String razonsocial, String correo, String nacionalidad,
                    String estado_provincia, String telefono) {
        this.codigo = codigo;
        this.razonsocial = razonsocial;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
        this.estado_provincia = estado_provincia;
        this.telefono = telefono;
        
    }
            

    public MCliente()
    {
    this.codigo = "";
    this.razonsocial = "";
    this.correo = "";
    this.nacionalidad = "";
    this.estado_provincia = "";
    this.telefono = "";
    
    
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstado_provincia() {
        return estado_provincia;
    }

    public void setEstado_provincia(String estado_provincia) {
        this.estado_provincia = estado_provincia;
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

}