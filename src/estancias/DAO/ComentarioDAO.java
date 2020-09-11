package estancias.DAO;

import estancias.entidades.Comentarios;
import java.util.ArrayList;
import java.util.Collection;

public class ComentarioDAO extends DAO {

    public void guardarComentario(Comentarios comentario) throws Exception {
        try {
            if (comentario == null) {
                throw new Exception("Debe indicar la estancia");
            }
            //Armo el sql
            String sql = "INSERT "
                    + "  INTO comentarios (id_comentario,id_casa,comentario)"
                    + "VALUES ("
                    + comentario.getId() + ","
                    + comentario.getIdCasa()+ ","                 
                    + comentario.getComentario()+ ");";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarComentario(Comentarios comentario) throws Exception {
        try {
            if (comentario == null) {
                throw new Exception("Debe indicar la estancia que desea modificar");
            }
            //Armo el sql
            String sql = "UPDATE familias"
                    + "   SET id_casa = " + comentario.getIdCasa()+ ","
                    + "comentario= " + comentario.getComentario()+ " "
                    + " WHERE id_comentario= " + comentario.getId()+ ";";
            //Ejecuto el sql            
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarComentario(int idComentario) throws Exception {
        try {
            //Armo el sql
            String sql = "DELETE         "
                    + "  FROM  comentarios "
                    + " WHERE id_comentario = " + idComentario + ";";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Comentarios buscarComentarioPorID(int idComentario) throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT id_comentario,id_casa,comentario "
                    + "  FROM comentarios "
                    + " WHERE id_comentario = " + idComentario + ";";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorremos el resultado de la consulta
            Comentarios comentario = null;
            while (resultado.next()) {
                comentario = new Comentarios();
                comentario.setId(resultado.getInt(1));
                comentario.setIdCasa(resultado.getInt(2));
                comentario.setComentario(resultado.getString(3));              
            }
            return comentario;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Comentarios> listarComentarios() throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT * "
                    + "  FROM comentarios;";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Comentarios comentario = null;
            Collection<Comentarios> comentarios = new ArrayList();
            while (resultado.next()) {
                 comentario = new Comentarios();
                comentario.setId(resultado.getInt(1));
                comentario.setIdCasa(resultado.getInt(2));
                comentario.setComentario(resultado.getString(3));                
                comentarios.add(comentario);
            }
            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }   
}
