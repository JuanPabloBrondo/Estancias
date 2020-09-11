package estancias.DAO;

import estancias.entidades.Estancias;
import java.util.ArrayList;
import java.util.Collection;

public class EstanciasDAO extends DAO {

    public void guardarEstancia(Estancias estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("Debe indicar la estancia");
            }
            //Armo el sql
            String sql = "INSERT "
                    + "  INTO estancias (id_estancia,id_cliente,id_casa,nombre_huesped,fecha_desde,fecha_hasta)"
                    + "VALUES ("
                    + estancia.getId() + ","
                    + estancia.getIdCliente()+ ","
                    + estancia.getIdCasa() + ",'"
                    + estancia.getNombreHuesped() + "','"
                    + (estancia.getFechaDesde().getYear()+1900)+"-"+(estancia.getFechaDesde().getMonth()+1)+"-"+estancia.getFechaDesde().getDate() + "','"
                    +(estancia.getFechHasta().getYear()+1900)+"-"+(estancia.getFechHasta().getMonth()+1)+"-"+estancia.getFechHasta().getDate() + "');";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarEstancia(Estancias estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("Debe indicar la estancia que desea modificar");
            }
            //Armo el sql
            String sql = "UPDATE familias"
                    + "   SET id_cliente = " + estancia.getIdCliente()+ ","
                    + "id_casa= " + estancia.getIdCasa()+ ","
                    + "nombre_huesped='" + estancia.getNombreHuesped() + "',"
                    + "fecha_desde=" + estancia.getFechaDesde() + ","
                    + "fecha_hasta= " + estancia.getFechHasta() + " "
                    + " WHERE id_estancia= " + estancia.getId() + ";";
            //Ejecuto el sql            
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarEstancia(int idEstancia) throws Exception {
        try {
            //Armo el sql
            String sql = "DELETE         "
                    + "  FROM estancias "
                    + " WHERE id_estancia = " + idEstancia + ";";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Estancias buscarEstanciasPorID(int idEstancia) throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT id_estancia,id_cliente,id_casa,nombre_huesped,fecha_desde,fecha_hasta"
                    + "  FROM familias "
                    + " WHERE id_familia = " + idEstancia + ";";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorremos el resultado de la consulta
            Estancias estancia = null;
            while (resultado.next()) {
                estancia = new Estancias();
                estancia.setId(resultado.getInt(1));
                estancia.setIdCliente(resultado.getInt(2));
                estancia.setIdCasa(resultado.getInt(3));
                estancia.setNombreHuesped(resultado.getString(4));
                estancia.setFechaDesde(resultado.getDate(5));
                estancia.setFechHasta(resultado.getDate(6));
            }
            return estancia;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Estancias> listarEstancias() throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT * "
                    + "  FROM estancias;";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Estancias estancia = null;
            Collection<Estancias> estancias = new ArrayList();
            while (resultado.next()) {
                estancia = new Estancias();
                estancia.setId(resultado.getInt(1));
                estancia.setIdCliente(resultado.getInt(2));
                estancia.setIdCasa(resultado.getInt(3));
                estancia.setNombreHuesped(resultado.getString(4));
                estancia.setFechaDesde(resultado.getDate(5));
                estancia.setFechHasta(resultado.getDate(6));
                estancias.add(estancia);
            }
            return estancias;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

}
