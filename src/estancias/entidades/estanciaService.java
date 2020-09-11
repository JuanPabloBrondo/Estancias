package estancias.entidades;

import estancias.DAO.EstanciasDAO;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class estanciaService {

    EstanciasDAO estanciaDAO = new EstanciasDAO();

    public void listaDeEstancias() throws Exception {
        Collection<Estancias> lista = null;
        lista = estanciaDAO.listarEstancias();
        System.out.println("Los clientes y sus casas son...");
        for (Estancias es : lista) {
            System.out.println(es.getCliente().toString());
            System.out.println(es.getCasa().toString());
        }
    }

    public void agregarEstancias() throws Exception {
        casaService cS=new casaService();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Collection<Estancias> lista = estanciaDAO.listarEstancias();
        System.out.println("Ingrese el nombre del huesped");
        String nombreHuesped = leer.next();
        System.out.println("Ahora a cargar la fecha de estadia");
        System.out.println("Ingrese el año");
        int anio = leer.nextInt();
        System.out.println("Ingrese el número de mes");
        int mes = leer.nextInt();
        System.out.println("Ingrese el día");
        int dia = leer.nextInt();
        Date fechaDesde = new Date(anio-1900, mes-1, dia);

        System.out.println("Ahora a cargar la fecha de vuelta");
        System.out.println("Ingrese el año");
        anio = leer.nextInt();
        System.out.println("Ingrese el número de mes");
        mes = leer.nextInt();
        System.out.println("Ingrese el día");
        dia = leer.nextInt();
        Date fechaHasta = new Date(anio-1900, mes-1, dia);
        int tiempoEstancia = fechaHasta.compareTo(fechaHasta);
        if(!cS.casaDisponible(fechaDesde, tiempoEstancia)) {
            System.out.println("No hay casas para esos días");
        } else {        
        System.out.println("Ingrese el id del Cliente (1 al 7)");
        int idCliente = leer.nextInt();
        System.out.println("Ingrese el id de la Casa disponible");
        int idCasa = leer.nextInt();
        Estancias estadia = new Estancias(lista.size() + 1, nombreHuesped, fechaDesde, fechaHasta, idCliente, idCasa);
        estanciaDAO.guardarEstancia(estadia);
        lista = estanciaDAO.listarEstancias();
        System.out.println("La lista de estancias ahora son...");
        for (Estancias es : lista) {
            System.out.println(es.toString());
        }
        }
    }

}
