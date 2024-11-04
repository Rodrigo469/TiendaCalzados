package Modelo;

public class Mujer extends Formal{
    protected int alturaTaco;

    public Mujer(Producto producto, String diaVenta,
                 int numeroCalzado, String color, int alturaTaco) {
        super(producto, diaVenta, numeroCalzado, color);
        this.alturaTaco = alturaTaco;
    }

    public int getAlturaTaco() {
        return alturaTaco;
    }

    public void setAlturaTaco(int alturaTaco) {
        this.alturaTaco = alturaTaco;
    }

    @Override
    public int descuento() {
        int descuento=0;
        if (this.alturaTaco > 10) {
         descuento=this.valorVenta()*20/100;
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
