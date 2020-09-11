package estancias.entidades;

import estancias.DAO.CasasDAO;
import java.util.Collection;
import java.util.Date;

public class casaService {

    private CasasDAO casaDAO = new CasasDAO();

    public void casaDisponibleAgosto() throws Exception {
        //Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
        Collection<Casas> lista;
        System.out.println("Las casas disponibles en agosto son");
        lista = casaDAO.listarCasasDisponiblesAgosto();
        for (Casas casas : lista) {
            System.out.println(casas.toString());
        }
    }

    public void casasPrecioActualizadoRU() throws Exception {
        Collection<Casas> lista;
        System.out.println("Las casas del RU con el precio actualizado son");
        lista = casaDAO.listarCasasDisponiblesRU();
        for (Casas ca : lista) {
            casaDAO.modificarPrecioCasasRU(ca);
        }
        lista = casaDAO.listarCasasDisponiblesRU();
        for (Casas ca : lista) {
            System.out.println(ca.toString());
        }
    }

    public void CasasPorPais() throws Exception {
        casaDAO.listarCasasDisponiblesPorMundo();
    }

    public void CasasLimpias() throws Exception {
        Collection<Casas> lista;
        lista = casaDAO.listarCasasLimpias();
        System.out.println("Las casas limpias son");
        for (Casas ca : lista) {
            System.out.println(ca.toString());
        }
    }

    public boolean casaDisponible(Date calen,int tiempoEstadia) throws Exception {

//Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
        Collection<Casas> lista;
        System.out.println("Las casas disponibles en " + calen.getDate() + "/" + (calen.getMonth() + 1) + "/" + (calen.getYear()+1900) + "  son");
        lista = casaDAO.listarCasasDisponiblesIntroduciendoDia(calen, tiempoEstadia);
        for (Casas casas : lista) {
            System.out.println(casas.toString());
        }
        return !lista.isEmpty();
    }
}
