package estancias.entidades;

import estancias.DAO.CasasDAO;

public class Familia {

    private int id;
    private String nombre;
    private int edad_minima;
    private int edad_maxima;
    private int num_hijos;
    private String email;
    private int id_casa;
    private Casas casa;
    private static CasasDAO casaDAO = new CasasDAO();

    public Familia() {
        this.id = 0;
        this.nombre = null;
        this.edad_minima = 0;
        this.edad_maxima = 0;
        this.num_hijos = 0;
        this.email = null;
        id_casa = 0;
    }

    public Familia(int id, String nombre, int edad_minima, int edad_maxima, int num_hijos, String email, Casas casa, int id_casa) throws Exception {
        this.id = id;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
        this.id_casa = id_casa;
        this.casa = casaDAO.buscarCasasPorID(id_casa);
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) throws Exception {
        this.id_casa = id_casa;
        this.casa = casaDAO.buscarCasasPorID(id_casa);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }

    public int getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(int edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public int getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(int num_hijos) {
        this.num_hijos = num_hijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Casas getCasa() {
        return casa;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Familia{" + "id=" + id + ", nombre=" + nombre + ", edad_minima=" + edad_minima + ", edad_maxima=" + edad_maxima + ", num_hijos=" + num_hijos + ", email=" + email + ", id_casa=" + id_casa + ", casa=" + casa + '}';
    }
    
}
