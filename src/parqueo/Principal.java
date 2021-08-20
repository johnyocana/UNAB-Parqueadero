package parqueo;

public class Principal {

    public static void main(String[] args) {
        System.out.println("- PARQUEADERO -");
        Vehiculo moto1 = new Vehiculo("ABC123", "MOTO");
        Vehiculo moto2 = new Vehiculo("ABC124", "MOTO");
        Vehiculo moto3 = new Vehiculo("ABC125", "MOTO");

        Vehiculo carro1 = new Vehiculo("ABC126", "CARRO");
        Vehiculo carro2 = new Vehiculo("ABC127", "CARRO");
        Vehiculo carro3 = new Vehiculo("ABC128", "CARRO");

        Parqueadero p = new Parqueadero();
        for (int i = 0; i < 10; i++) {
            p.addMoto(moto1);

        }

        for (int i = 0; i < 18; i++) {
            p.addCarro(carro1);

        }
        
        p.imprimeMotos();
        p.imprimeCarros();
        
        p.addMoto(moto2);
        p.addMoto(moto3);
        
        p.addCarro(carro2);
        p.addCarro(carro3);

        long vpagar = p.salir("ABC123", "MOTO");
        System.out.println("PAGA :"+vpagar);
        
        p.imprimeMotos();
        p.imprimeCarros();

        vpagar = p.salir("ABC124", "MOTO");
        System.out.println("PAGA :"+vpagar);
        
        p.imprimeMotos();
        p.imprimeCarros();

        vpagar = p.salir("ABC126", "CARRO");
        System.out.println("PAGA :"+vpagar);
                
        p.imprimeMotos();
        p.imprimeCarros();
        
        vpagar = p.salir("ABC127", "CARRO");
        System.out.println("PAGA :"+vpagar);
        
        p.imprimeMotos();
        p.imprimeCarros();

        System.out.println("RECAUDADO TOTAL: " + p.consultaValorRecaudado());

    }
}
