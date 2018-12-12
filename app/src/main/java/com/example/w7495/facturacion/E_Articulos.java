package com.example.w7495.facturacion;

class E_Articulos {

    public E_Articulos(int codigo, String nombre, String fecha, double total){
        this.codigo=codigo;
        this.nombre=nombre;
        this.fecha=fecha;
        this.total=total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    int codigo;
    String nombre;
    String fecha;
    double total;
}
