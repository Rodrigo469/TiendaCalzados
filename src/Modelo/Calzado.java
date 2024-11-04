package Modelo;

public abstract class Calzado extends Producto{
    //Atributos
    protected Producto producto;
    protected String diaVenta;
    protected int numeroCalzado;
 //Constructor
    public Calzado(Producto producto, String diaVenta, int numeroCalzado) {
        this.producto = producto;
        this.diaVenta = diaVenta;
        this.numeroCalzado = numeroCalzado;
    }
//Getters and Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDiaVenta() {
        return diaVenta;
    }

    public void setDiaVenta(String diaVenta) {
        this.diaVenta = diaVenta;
    }

    public int getNumeroCalzado() {
        return numeroCalzado;
    }

    public void setNumeroCalzado(int numeroCalzado) {
        this.numeroCalzado = numeroCalzado;
    }

    //Métodos
    //valorVenta
    public int valorVenta(){
        int valorVenta;
        if(this.getDiaVenta().equalsIgnoreCase("Semana")){
            valorVenta=this.getProducto().getValorBase()
                    +Math.round(this.getProducto().getValorBase()*15/100);
        }else if(this.getDiaVenta().equalsIgnoreCase("Dia de semana")){
            valorVenta=this.getProducto().getValorBase()+
                    Math.round(this.getProducto().getValorBase()*24/100);
        }else{
            valorVenta=-1;
        }
        return valorVenta;
    }

    //Impuesto Iva
    public int impuestoIva(){
        return Math.round(this.valorVenta()*19/100);
    }
    public abstract int valorAPagar();
}
