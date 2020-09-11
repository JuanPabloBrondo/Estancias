package estancias.entidades;

import estancias.DAO.FamiliaDAO;
import java.util.List;

public class familiaService {

    private FamiliaDAO familiaDAO = new FamiliaDAO();

    public List<Familia> familiasConMenosDe3Hijos() throws Exception {
        try {
            List<Familia> Lista = familiaDAO.Familias3Hijos();
            System.out.println("Las familias con al menos 3 hijos y una edad máxima inferior a 10 son");
            for (Familia fa : Lista) {
                System.out.println(fa.toString());
            }
            return Lista;
        } catch (Exception e) {
            throw new Exception("Falló de sistema");
        }
    }

    public List<Familia> familiasQueTerminanEnY() throws Exception {
        try {
            List<Familia> Lista = familiaDAO.FamiliasTerminanConY();
            System.out.println("Las familias que su nombre termina con Y son");
            for (Familia fa : Lista) {
                System.out.println(fa.toString());
            }
            return Lista;
        } catch (Exception ex) {
            throw new Exception("Falló de sistema");
        }

    }
    
    public List<Familia> familiasconhotmail() throws Exception {
        try {
            List<Familia> Lista = familiaDAO.listarFamiliaPorsql("select * from familias where email like ('%hotmail%');");
            System.out.println("Las familias que usan hotmail son");
            for (Familia fa : Lista) {
                System.out.println(fa.toString());
            }
            return Lista;
        } catch (Exception ex) {
            throw new Exception("Falló de sistema");
        }

    }
}
