package Controladora;

import Modelo.Calzado;
import Modelo.Deportivo;
import Modelo.Hombre;
import Modelo.Mujer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TiendaCalzado {
    //Atributos
    private ArrayList<Calzado> tienda;

    //Constructor

    public TiendaCalzado(ArrayList<Calzado> tienda) {
        this.tienda = tienda;
    }

    //Constructor vacio
    public TiendaCalzado() {

    }

    //Getters and Setters
    public ArrayList<Calzado> getTienda() {
        return tienda;
    }

    public void setTienda(ArrayList<Calzado> tienda) {
        this.tienda = tienda;
    }
    //Métodos logica de app

    //Buscar calzados

    public int buscarCalzado(String codigoCalzado) {
        for (int i = 0; i < tienda.size(); i++) {
            if (tienda.get(i).getProducto().getCodigo().
                    compareToIgnoreCase(codigoCalzado) == 0) {//encontre el calzado
                return i;
            }
        }
        return -1;//no lo encontre
    }

    //agregar calzados deportivos a la coleccion
    public void ingresarCalzadosDeportivos(Deportivo deportivo) {
        if (this.buscarCalzado(deportivo.getProducto().getCodigo()) == -1) {
            //si no esta lo agrego
            tienda.add(deportivo);
        }
    }

    //agregar calzados mujer a la coleccion
    public void ingresarCalzadosMujer(Mujer mujer) {
        if (this.buscarCalzado(mujer.getProducto().getCodigo()) == -1) {
            //si no esta lo agrego
            tienda.add(mujer);
        }
    }

    //agregar calzados hombre a la coleccion
    public void ingresarCalzadosHombres(Hombre hombre) {
        if (this.buscarCalzado(hombre.getProducto().getCodigo()) == -1) {
            //si no esta lo agrego
            tienda.add(hombre);
        }
    }

    //Método para buscar solo calzados de mujer
    public String calzadoMujer() {
        String mensaje = "";
        Mujer mujer = null;

        for (int i = 0; i < tienda.size(); i++) {
            //como puedo saber si un objeto es una instancia de una clase
            if (tienda.get(i) instanceof Mujer) {//es un objeto tipo mujer
                mujer = (Mujer) tienda.get(i);

                mensaje = mensaje + " Dia de venta: " + mujer.getDiaVenta() +
                        " Altura del taco: " + mujer.getAlturaTaco() +
                        " y descuento: $" + mujer.descuento();
            }
        }
        return mensaje;
    }

    //Método para calcular el valorVenta de un calzado en particular
    public String valorVenta(String codigoCalzado){
        int calzadoEncontrado=buscarCalzado(codigoCalzado);
        if(buscarCalzado(codigoCalzado)==-1){
            return "El calzado no se encuentra en la tienda.";
        }else{
            return "El valor de venta del calzado es: "+
                    tienda.get(calzadoEncontrado).valorVenta()+
                    ""+"y el nro de calzado es: "+
                    tienda.get(calzadoEncontrado).getNumeroCalzado();
                                    }
    }

  //Métodos para identificar cuales son los calzados top(valorVenta>80000)

  public  String calzadosTop(){
        String mensaje = "";
        int suma=0;

        for(int i=0;i<tienda.size();i++){
            if(tienda.get(i).valorVenta()>80000){//es un calzado top
                suma=suma +tienda.get(i).getProducto().getStock();
            }
        }
        mensaje="tienes "+ suma + " calzados top(> $80000) en stock. Ojo";
        return  mensaje;

  }

  //Método impuesto especifico

    public int totalImpuestoEspecifico(){
        int total=0;
        Mujer mujer =null;
        Hombre hombre = null;

        for(int i=0;i<tienda.size();i++){
            if(tienda.get(i) instanceof Mujer){ //Es un calzado de mujer
                mujer=(Mujer)tienda.get(i);
                total = total + (mujer.getProducto().getStock()+mujer.impuestoEspecifico());
            }else if(tienda.get(i)instanceof  Hombre){
                hombre=(Hombre)tienda.get(i);
                total = total + (hombre.getProducto().getStock()+hombre.impuestoEspecifico());
            }
        }
        return total;
    }

    //Método totalDescuento

    public int totalDescuento(){
        int total=0;
        Mujer mujer =null;
        Hombre hombre = null;

        for(int i=0;i<tienda.size();i++){
            if(tienda.get(i) instanceof Mujer){ //Es un calzado de mujer
                mujer=(Mujer)tienda.get(i);
                total = total + (mujer.getProducto().getStock()+mujer.descuento());
            }else if(tienda.get(i)instanceof  Hombre){
                hombre=(Hombre)tienda.get(i);
                total = total + (hombre.getProducto().getStock()+hombre.descuento());
            }
        }
        return total;
    }







}
