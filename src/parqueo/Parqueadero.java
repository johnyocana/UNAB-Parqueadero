package parqueo;

import java.util.Date;

public class Parqueadero {

    public final int CUPOSCARRO = 18, CUPOSMOTO = 10;

    private int valorMinMoto = 30, valorMinCarro = 60;

    private Vehiculo[] espaciosC = new Vehiculo[CUPOSCARRO];
    private Vehiculo[] espaciosM = new Vehiculo[CUPOSMOTO];

    private long valorRecaudado;

    private boolean existeCarro(Vehiculo carro) {
        for (int i = 0; i < CUPOSCARRO; i++) {
            if (espaciosC[i] != null && espaciosC[i].consultaPlaca().equals(carro.consultaPlaca())) {
                return true;
            }
        }
        return false;
    }

    public boolean addCarro(Vehiculo carro) {
        if (this.existeCarro(carro) == true) {
            return false;
        }
        for (int i = 0; i < CUPOSCARRO; i++) {
            if (espaciosC[i] == null) {
                Date fecha = new Date();
                espaciosC[i] = carro;
                espaciosC[i].asignarHoraEntrada(fecha);
                return true;
            }
        }
        return false;
    }

    private boolean existeMoto(Vehiculo moto) {
        for (int i = 0; i < CUPOSMOTO; i++) {
            if (espaciosM[i] != null && espaciosM[i].consultaPlaca().equals(moto.consultaPlaca())) {
                return true;
            }
        }
        return false;
    }

    public boolean addMoto(Vehiculo moto) {
        if (this.existeMoto(moto) == true) {
            return false;
        }
        for (int i = 0; i < CUPOSMOTO; i++) {
            if (espaciosM[i] == null) {
                Date fecha = new Date();
                espaciosM[i] = moto;
                espaciosM[i].asignarHoraEntrada(fecha);
                return true;
            }
        }
        return false;
    }

    public long salir(String placa, String tipo) {
        if (tipo.equals("MOTO")) {
            for (int i = 0; i < CUPOSMOTO; i++) {
                Vehiculo elveh = espaciosM[i];
                //if (espaciosM[i].consultaPlaca().equals(placa))
                if (elveh != null && elveh.consultaPlaca().equals(placa)) {
                    Date fecha = new Date();
                    elveh.asignarHoraSalida(fecha);
                    long valorvehiculo = elveh.calcularPago(valorMinMoto);
                    espaciosM[i] = null;
                    this.valorRecaudado += valorvehiculo;
                    return valorvehiculo;
                }
            }

        } else if (tipo.equals("CARRO")) {
            for (int i = 0; i < CUPOSCARRO; i++) {
                Vehiculo elveh = espaciosC[i];
                //if (espaciosM[i].consultaPlaca().equals(placa))
                if (elveh != null && elveh.consultaPlaca().equals(placa)) {
                    Date fecha = new Date();
                    elveh.asignarHoraSalida(fecha);
                    long valorvehiculo = elveh.calcularPago(valorMinCarro);
                    espaciosC[i] = null;
                    this.valorRecaudado += valorvehiculo;
                    return valorvehiculo;
                }
            }
        }

        return -1;
    }

    public void asignarValorMinMoto(int valor) {
        this.valorMinMoto = valor;
    }

    public int consultaValorMinMoto() {
        return this.valorMinMoto;
    }

    public void asignarValorMinCarro(int valor) {
        this.valorMinCarro = valor;
    }

    public int consultaValorMinCarro() {
        return this.valorMinCarro;
    }

    public long consultaValorRecaudado() {
        return this.valorRecaudado;
    }

    public void imprimeMotos() {
        System.out.print("MOTOS  -> ");
        for (int i = 0; i < espaciosM.length; i++) {
            if (espaciosM[i] != null) {
                System.out.print("(ESPACIO " + (i + 1) + " -> " + espaciosM[i].consultaPlaca() + ") ");
            }

        }
        System.out.println("");
    }

    public void imprimeCarros() {
        System.out.print("CARROS -> ");
        for (int i = 0; i < espaciosC.length; i++) {
            if (espaciosC[i] != null) {
                System.out.print("(ESPACIO " + (i + 1) + " -> " + espaciosC[i].consultaPlaca() + ") ");
            }

        }
        System.out.println("");
    }

    public int cuposDisponiblesCarro() {
        int disponibles = 0;
        for (int i = 0; i < espaciosC.length; i++) {
            if (espaciosC[i] == null) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public int cuposDisponiblesMoto() {
        int disponibles = 0;
        for (int i = 0; i < espaciosM.length; i++) {
            if (espaciosM[i] == null) {
                disponibles++;
            }
        }
        return disponibles;

    }
}
