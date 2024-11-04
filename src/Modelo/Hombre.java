package Modelo;

public class Hombre extends Formal{
    public Hombre(Producto producto, String diaVenta,
                  int numeroCalzado,
                  String color) {
        super(producto, diaVenta, numeroCalzado, color);
    }

    @Override
    public int descuento() {
        int descuento=0;
        if(this.getColor().equalsIgnoreCase("Verde")||
                this.getColor().equalsIgnoreCase("Rojo")){
            descuento=this.valorVenta()*25/100;
            return descuento;
        }else{
            return descuento;
        }
    }

    @Override
    public int valorAPagar() {
        int valorAPagar;
        if(this.getProducto().getStock()>0){
            valorAPagar=valorVenta()-descuento()+impuestoEspecifico()+impuestoIva();
            this.getProducto().setStock(this.getProducto().getStock()-1);
            return valorAPagar;
        }else{
            valorAPagar=-1;
            return valorAPagar;
        }
    }
}
