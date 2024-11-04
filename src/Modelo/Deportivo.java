package Modelo;

public class Deportivo extends Calzado {

    //Atributos
    protected String tipoDeporte;
    protected String tipoMaterial;

    //Constructor
    public Deportivo(Producto producto, String diaVenta,
                     int numeroCalzado, String tipoDeporte,
                     String tipoMaterial) {
        super(producto, diaVenta, numeroCalzado);
        this.tipoDeporte = tipoDeporte;
        this.tipoMaterial = tipoMaterial;
    }

    //Getters and Setters
    public String getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(String tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    //Métodos
    //Impuesto Material

    public int impuestoMaterial() {
        int impuestoMaterial;
        if (this.tipoMaterial.equalsIgnoreCase("Cuero")) {
            impuestoMaterial = Math.round(this.getProducto().getValorBase() * 15 / 100);
        } else if (this.tipoMaterial.equalsIgnoreCase("Lona")) {
            impuestoMaterial = Math.round(this.getProducto().getValorBase() * 6 / 100);
        } else {
            impuestoMaterial = -1;
        }
        return impuestoMaterial;
    }

    @Override
    public int valorAPagar() {
        int valorAPagar;
        if(this.getProducto().getStock()>0){
          valorAPagar=valorVenta()+impuestoIva()+impuestoMaterial();
          this.getProducto().setStock(this.getProducto().getStock()-1);
          return valorAPagar;
        }else{
            valorAPagar=-1;
            return valorAPagar;
        }
    }
}