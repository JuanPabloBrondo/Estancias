package estancias.DAO;

import estancias.entidades.Clientes;
import java.util.ArrayList;
import java.util.Collection;

public class ClientesDAO extends DAO {

    public void guardarCliente(Clientes cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe indicar la estancia");
            }
            //Armo el sql
            String sql = "INSERT "
                    + "  INTO familias (id_cliente,nombre,calle,numero,codigo_postal,ciudad,pais,email)"
                    + "VALUES ("
                    + cliente.getId() + ",'"
                    + cliente.getNombre() + "','"
                    + cliente.getCalle() + "',"
                    + cliente.getNumero() + ","
                    + cliente.getCodigoPostal() + ",'"
                    + cliente.getCiudad() + "','"
                    + cliente.getPais() + "','"
                    + cliente.getEmail() + "');";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarCliente(Clientes cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe indicar la estancia que desea modificar");
            }
            //Armo el sql
            String sql = "UPDATE familias"
                    + "   SET  nombre= '" + cliente.getNombre() + "',"
                    + "calle='" + cliente.getCalle() + "',"
                    + "numero=" + cliente.getNombre() + ","
                    + "codigo_postal= " + cliente.getCodigoPostal() + ","
                    + "ciudad='" + cliente.getCiudad() + "',"
                    + "pais='" + cliente.getPais() + "',"
                    + "email='" + cliente.getEmail() + "'"
                    + " WHERE id_cliente= " + cliente.getId() + ";";
            //Ejecuto el sql            
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarCliente(int idCliente) throws Exception {
        try {
            //Armo el sql
            String sql = "DELETE         "
                    + "  FROM clientes "
                    + " WHERE id_cliente = " + idCliente + ";";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Clientes buscarClientesPorID(int idCliente) throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT * "
                    + "  FROM clientes "
                    + " WHERE id_cliente = " + idCliente + ";";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorremos el resultado de la consulta
            Clientes cliente = null;
            while (resultado.next()) {
                cliente = new Clientes();
                cliente.setId(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigoPostal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));
            }
            return cliente;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Clientes> listarClientes() throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT * "
                    + "  FROM clientes;";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Clientes cliente = null;
            Collection<Clientes> clientes = new ArrayList();
            while (resultado.next()) {
                cliente = new Clientes();
                cliente.setId(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigoPostal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));                
                clientes.add(cliente);
            }
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

}
