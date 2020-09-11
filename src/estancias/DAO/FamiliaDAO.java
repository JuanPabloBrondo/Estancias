package estancias.DAO;

import estancias.entidades.Familia;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO {

    public void guardarFamilia(Familia familia) throws Exception {
        try {
            if (familia == null) {
                throw new Exception("Debe indicar la familia");
            }
            //Armo el sql
            String sql = "INSERT "
                    + "  INTO familias (id_familia,nombre,edad_minima,edad_maxima,num_hijos,email,id_casa_familia)"
                    + "VALUES ("
                    + familia.getId() + ","
                    + "'" + familia.getNombre() + "'" + ","
                    + familia.getEdad_minima() + ","
                    + familia.getEdad_maxima() + ","
                    + familia.getNum_hijos() + ","
                    + "'" + familia.getEmail() + "',"
                    + familia.getId_casa() + ");";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarFamilia(Familia familia) throws Exception {
        try {
            if (familia == null) {
                throw new Exception("Debe indicar la familia que desea modificar");
            }
            //Armo el sql
            String sql = "UPDATE Usuario"
                    + "   SET nombre = " + "'" + familia.getNombre() + "'" + ","
                    + "edad_minima= " + familia.getEdad_minima() + ","
                    + "edad_maxima=" + familia.getEdad_maxima() + ","
                    + "num_hijos=" + familia.getNum_hijos() + ","
                    + "email= '" + familia.getEmail() + "',"
                    + "id_casa_familia=" + familia.getCasa().getId() + " "
                    + " WHERE id_familia= " + familia.getId() + ";";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarFamilia(int idFamilia) throws Exception {
        try {
            //Armo el sql
            String sql = "DELETE         "
                    + "  FROM familias "
                    + " WHERE id_familia = " + idFamilia + ";";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Familia buscarFamiliaPorID(int idFamilia) throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT id_familia,nombre,edad_minima,edad_maxima,num_hijos,email,id_casa_familia"
                    + "  FROM familias "
                    + " WHERE id_familia = " + idFamilia + ";";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorremos el resultado de la consulta
            Familia familia = null;
            while (resultado.next()) {
                familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa(resultado.getInt(7));
            }
            return familia;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public List<Familia> listarFamilia() throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT * "
                    + "  FROM familias;";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Familia familia = null;
            List<Familia> familias = new ArrayList();
            while (resultado.next()) {
                familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa(resultado.getInt(7));
                familias.add(familia);
            }
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public List<Familia> Familias3Hijos() throws Exception {
        try {
            //Armo el sql
            String sql = "select * from familias where num_hijos>=3 and edad_maxima<10;";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Familia familia = null;
            List<Familia> familias = new ArrayList();

            while (resultado.next()) {
                familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa(resultado.getInt(7));
                familias.add(familia);
            }
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public List<Familia> FamiliasTerminanConY() throws Exception {
        try {
            //Armo el sql
            String sql = "select * from familias where nombre like ('%y');";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Familia familia = null;
            List<Familia> familias = new ArrayList();

            while (resultado.next()) {
                familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa(resultado.getInt(7));
                familias.add(familia);
            }
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public List<Familia> listarFamiliaPorsql(String sql) throws Exception {
        try {
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Familia familia = null;
            List<Familia> familias = new ArrayList();
            while (resultado.next()) {
                familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa(resultado.getInt(7));
                familias.add(familia);
            }
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }
}
