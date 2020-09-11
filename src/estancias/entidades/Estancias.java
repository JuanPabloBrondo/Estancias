
package estancias.entidades;

import estancias.DAO.CasasDAO;
import estancias.DAO.ClientesDAO;
import java.util.Date;

public class Estancias {

    private Integer id;
    private String nombreHuesped;
    private Date fechaDesde;
    private Date fechHasta;
    private Clientes cliente;
    private Casas casa;
    private int idCliente;
    private int idCasa;
    private static CasasDAO casaDAO=new CasasDAO();
    private static ClientesDAO clienteDAO=new ClientesDAO();

    public Estancias(Integer id, String nombreHuesped, Date fechaDesde, Date fechaHasta,int idCliente, int idCasa) throws Exception {
        this.id = id;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechHasta = fechaHasta;
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        casa = casaDAO.buscarCasasPorID(idCasa);
        cliente = clienteDAO.buscarClientesPorID(idCliente);
    }

    public Estancias() {
        this.id = 0;
        this.nombreHuesped = null;
        this.fechaDesde = null;
        this.fechHasta = null;
        this.cliente = null;
        this.casa = null;
        this.idCliente = 0;
        this.idCasa = 0;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public Casas getCasa() {
        return casa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechHasta() {
        return fechHasta;
    }

    public void setFechHasta(Date fechHasta) {
        this.fechHasta = fechHasta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) throws Exception {
        this.idCliente = idCliente;
        cliente = clienteDAO.buscarClientesPorID(idCliente);
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) throws Exception {
        this.idCasa = idCasa;
        casa = casaDAO.buscarCasasPorID(idCasa);
    }

    @Override
    public String toString() {
        return "Estancias{" + "id=" + id + ", nombreHuesped=" + nombreHuesped + ", fechaDesde=" + fechaDesde + ", fechHasta=" + fechHasta + ", cliente=" + cliente + ", casa=" + casa + ", idCliente=" + idCliente + ", idCasa=" + idCasa + '}';
    }

}
