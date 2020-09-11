package estancias.entidades;

import estancias.DAO.CasasDAO;

public class Comentarios {

    private Integer id;
    private String Comentario;
    private int idCasa;
    private Casas casa;
    private static CasasDAO casaDAO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) throws Exception {
        this.idCasa = idCasa;
        casa = casaDAO.buscarCasasPorID(idCasa);
    }

    public Casas getCasa() {
        return casa;
    }

    public Comentarios(Integer id, String Comentario, int idCasa) throws Exception {
        this.id = id;
        this.Comentario = Comentario;
        this.idCasa = idCasa;
        this.casa = casaDAO.buscarCasasPorID(idCasa);
    }
    public Comentarios() {
        this.id = null;
        this.Comentario = null;
        this.idCasa = 0;
        this.casa = null;
    }
}
