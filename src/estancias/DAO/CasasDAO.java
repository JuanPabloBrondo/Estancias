package estancias.DAO;

import estancias.entidades.Casas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CasasDAO extends DAO {

    public void guardarCasas(Casas casa) throws Exception {
        try {
            if (casa == null) {
                throw new Exception("Debe indicar la estancia");
            }
            //Armo el sql
            String sql = "INSERT "
                    + "  INTO familias (id_casa,calle,numero,codigo_postal,ciudad,pais,fecha_desde,fecha_hasta,tiempo_minimo,tiempo_maximo,precio_habitacion,tipo_vivienda)"
                    + "VALUES ("
                    + casa.getId() + ",'"
                    + casa.getCalle() + "',"
                    + casa.getNumero() + ",'"
                    + casa.getCodigoPostal() + "','"
                    + casa.getCiudad() + "','"
                    + casa.getPais() + "','"
                    + casa.getFechaDesde() + "','"
                    + casa.getFechaHasta() + "',"
                    + casa.getTiempoMinimo() + ","
                    + casa.getTiempoMaximo() + ","
                    + casa.getPrecioHabitacion() + ",'"
                    + casa.getTipoVivienda()
                    + "');";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarCasas(Casas casa) throws Exception {
        try {
            if (casa == null) {
                throw new Exception("Debe indicar la estancia que desea modificar");
            }
            //Armo el sql
            String sql = "UPDATE casas"
                    + "   SET  calle= '" + casa.getCalle() + "',"
                    + "numero=" + casa.getNumero() + ","
                    + "codigo_postal='" + casa.getCodigoPostal() + "',"
                    + "ciudad='" + casa.getCiudad() + "',"
                    + "pais='" + casa.getPais() + "',"
                    + "fecha_desde='" + casa.getFechaDesde() + "',"
                    + "fecha_hasta='" + casa.getFechaHasta() + "',"
                    + "tiempo_minimo=" + casa.getTiempoMinimo() + ","
                    + "tiempo_maximo=" + casa.getTiempoMaximo() + ","
                    + "precio_habitacion=" + casa.getPrecioHabitacion() + ","
                    + "tipo_vivienda='" + casa.getTipoVivienda() + "' "
                    + " WHERE id_casa= " + casa.getId() + ";";
            //Ejecuto el sql            
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarCasa(int idCasa) throws Exception {
        try {
            //Armo el sql
            String sql = "DELETE         "
                    + "  FROM casas "
                    + " WHERE id_casa = " + idCasa + ";";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Casas buscarCasasPorID(int idCasa) throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT id_casa,calle,numero,codigo_postal,ciudad,pais,fecha_desde,fecha_hasta,tiempo_minimo,tiempo_maximo,precio_habitacion,tipo_vivienda "
                    + "  FROM casas "
                    + " WHERE id_casa = " + idCasa + ";";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorremos el resultado de la consulta
            Casas casa = null;
            while (resultado.next()) {
                casa = new Casas();
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getString(7));
                casa.setFechaHasta(resultado.getString(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
            }
            return casa;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Casas> listarCasas() throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT * "
                    + "  FROM casas;";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Casas casa = null;
            Collection<Casas> casas = new ArrayList();
            while (resultado.next()) {
                casa = new Casas();
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getString(7));
                casa.setFechaHasta(resultado.getString(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public Collection<Casas> listarCasasDisponiblesIntroduciendoDia(Date calen,int tiempoEstadia) throws Exception {
        try {
            //Armo el sql
            String sql = " select * from casas  where fecha_desde<='2020-08-01' and fecha_hasta>=date_add('"+(calen.getYear()+1900)+"-"+(calen.getMonth()+1)+"-"+calen.getDate()+"',interval "+tiempoEstadia+" day) " +
" and id_casa not in (select id_casa from estancias where (fecha_hasta>='2020-08-01'  and  fecha_desde<=date_add('"+(1900+calen.getYear())+"-"+(calen.getMonth()+1)+"-"+calen.getDate()+"',interval "+tiempoEstadia+" day)));";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Casas casa = null;
            Collection<Casas> casas = new ArrayList();
            while (resultado.next()) {
                casa = new Casas();
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getString(7));
                casa.setFechaHasta(resultado.getString(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }

            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public void modificarPrecioCasasRU(Casas casa) throws Exception {
        try {
            if (casa == null) {
                throw new Exception("Debe indicar la estancia que desea modificar");
            }
            //Armo el sql
            String sql = "UPDATE casas"
                    + "   SET  calle= '" + casa.getCalle() + "',"
                    + "numero=" + casa.getNumero() + ","
                    + "codigo_postal='" + casa.getCodigoPostal() + "',"
                    + "ciudad='" + casa.getCiudad() + "',"
                    + "pais='" + casa.getPais() + "',"
                    + "fecha_desde='" + casa.getFechaDesde() + "',"
                    + "fecha_hasta='" + casa.getFechaHasta() + "',"
                    + "tiempo_minimo=" + casa.getTiempoMinimo() + ","
                    + "tiempo_maximo=" + casa.getTiempoMaximo() + ","
                    + "precio_habitacion=" + casa.getPrecioHabitacion() / 1.05 + ","
                    + "tipo_vivienda='" + casa.getTipoVivienda() + "' "
                    + " WHERE id_casa= " + casa.getId() + " and pais='Reino Unido';";
            //Ejecuto el sql            
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Casas> listarCasasDisponiblesRU() throws Exception {
        try {
            //Armo el sql
            String sql = "select * from casas where pais='Reino Unido'";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Casas casa = null;
            Collection<Casas> casas = new ArrayList();
            while (resultado.next()) {
                casa = new Casas();
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getString(7));
                casa.setFechaHasta(resultado.getString(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }

            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public void listarCasasDisponiblesPorMundo() throws Exception {
        try {
            //Armo el sql
            String sql = "select pais,count(*) from casas group by pais;";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            System.out.println("País     Casas");
            while (resultado.next()) {
                System.out.println(resultado.getString(1) + " : " + resultado.getInt(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public Collection<Casas> listarCasasLimpias() throws Exception {
        try {
            //Armo el sql
            String sql = "select ca.* from casas ca,comentarios co where ca.id_casa=co.id_casa and co.comentario like ('%limpia%') and ca.pais like ('Reino Unido') group by ca. id_casa;";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Casas casa = null;
            Collection<Casas> casas = new ArrayList();
            while (resultado.next()) {
                casa = new Casas();
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getString(7));
                casa.setFechaHasta(resultado.getString(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }
      public Collection<Casas> listarCasasDisponiblesAgosto() throws Exception {
        try {
            //Armo el sql
            String sql = "select * from casas  where fecha_desde<='2020-08-01' and fecha_hasta>='2020-08-31' " +
" and id_casa not in (select id_casa from estancias where (fecha_hasta>='2020-08-01'  and  fecha_desde<='2020-08-31'));";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Casas casa = null;
            Collection<Casas> casas = new ArrayList();
            while (resultado.next()) {
                casa = new Casas();
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getString(7));
                casa.setFechaHasta(resultado.getString(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }

            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }
}
