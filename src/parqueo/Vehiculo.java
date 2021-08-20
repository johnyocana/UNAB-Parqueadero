package parqueo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Vehiculo {

    private String placa;
    private Date horaEntrada;
    private Date horaSalida;
    private long valorPagar;
    private String tipo;

    public Vehiculo(String placa, String tipo) {
        this.placa = placa;
        this.tipo = tipo.trim().toUpperCase();

    }

    public String consultaPlaca() {
        return this.placa;
    }

    public String consultaTipo() {
        return this.tipo;
    }

    public Date consultaHoraEntrada() {
        return this.horaEntrada;
    }

    public void asignarHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date consultaHoraSalida() {
        return this.horaSalida;
    }

    public void asignarHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public long consultaValorPagar() {
        return this.valorPagar;
    }

    public long calcularPago(int valorMinuto) {

        long diff = this.horaSalida.getTime() - this.horaEntrada.getTime();
        long minutos = TimeUnit.MILLISECONDS.toMinutes(diff);
        if (minutos == 0) {
            minutos = 1;
        }
        //int minutos = 34;//difer hrafin-horafin; 
        this.valorPagar = minutos * valorMinuto;
        return this.valorPagar;
    }
}
