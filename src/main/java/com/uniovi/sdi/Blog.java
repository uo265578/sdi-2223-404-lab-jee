package com.uniovi.sdi;
public class Blog {
    private String name;
    private String comentario;
    private String fecha;

    public Blog() {
    }

    public Blog(String name, String comentario, String fecha) {
        this.name = name;
        this.comentario = comentario;
        this.fecha = fecha;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}