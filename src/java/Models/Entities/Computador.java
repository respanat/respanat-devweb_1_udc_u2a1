package Models.Entities;

public class Computador {
    private Integer id;
    private String marca;
    private String categoria;
    private String marcaCpu;
    private String velocidadCpu;
    private String tecnologiaRam;
    private String capacidadRam;
    private String tecnologiaDisco;
    private String capacidadDisco;
    private Integer numPuertosUSB;
    private Integer numPuertosHDMI;
    private String marcaMonitor;
    private Double pulgadas;
    private Double precio;

    public Computador() {
    }

    public Computador(Integer id, String marca, String categoria, String marcaCpu, String velocidadCpu, String tecnologiaRam, String capacidadRam, String tecnologiaDisco, String capacidadDisco, Integer numPuertosUSB, Integer numPuertosHDMI, String marcaMonitor, Double pulgadas, Double precio) {
        this.id = id;
        this.marca = marca;
        this.categoria = categoria;
        this.marcaCpu = marcaCpu;
        this.velocidadCpu = velocidadCpu;
        this.tecnologiaRam = tecnologiaRam;
        this.capacidadRam = capacidadRam;
        this.tecnologiaDisco = tecnologiaDisco;
        this.capacidadDisco = capacidadDisco;
        this.numPuertosUSB = numPuertosUSB;
        this.numPuertosHDMI = numPuertosHDMI;
        this.marcaMonitor = marcaMonitor;
        this.pulgadas = pulgadas;
        this.precio = precio;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarcaCpu() {
        return marcaCpu;
    }

    public void setMarcaCpu(String marcaCpu) {
        this.marcaCpu = marcaCpu;
    }

    public String getVelocidadCpu() {
        return velocidadCpu;
    }

    public void setVelocidadCpu(String velocidadCpu) {
        this.velocidadCpu = velocidadCpu;
    }

    public String getTecnologiaRam() {
        return tecnologiaRam;
    }

    public void setTecnologiaRam(String tecnologiaRam) {
        this.tecnologiaRam = tecnologiaRam;
    }

    public String getCapacidadRam() {
        return capacidadRam;
    }

    public void setCapacidadRam(String capacidadRam) {
        this.capacidadRam = capacidadRam;
    }

    public String getTecnologiaDisco() {
        return tecnologiaDisco;
    }

    public void setTecnologiaDisco(String tecnologiaDisco) {
        this.tecnologiaDisco = tecnologiaDisco;
    }

    public String getCapacidadDisco() {
        return capacidadDisco;
    }

    public void setCapacidadDisco(String capacidadDisco) {
        this.capacidadDisco = capacidadDisco;
    }

    public Integer getNumPuertosUSB() {
        return numPuertosUSB;
    }

    public void setNumPuertosUSB(Integer numPuertosUSB) {
        this.numPuertosUSB = numPuertosUSB;
    }

    public Integer getNumPuertosHDMI() {
        return numPuertosHDMI;
    }

    public void setNumPuertosHDMI(Integer numPuertosHDMI) {
        this.numPuertosHDMI = numPuertosHDMI;
    }

    public String getMarcaMonitor() {
        return marcaMonitor;
    }

    public void setMarcaMonitor(String marcaMonitor) {
        this.marcaMonitor = marcaMonitor;
    }

    public Double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(Double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Computador{" +
               "id=" + id +
               ", marca='" + marca + '\'' +
               ", categoria='" + categoria + '\'' +
               ", marcaCpu='" + marcaCpu + '\'' +
               ", velocidadCpu='" + velocidadCpu + '\'' +
               ", tecnologiaRam='" + tecnologiaRam + '\'' +
               ", capacidadRam='" + capacidadRam + '\'' +
               ", tecnologiaDisco='" + tecnologiaDisco + '\'' +
               ", capacidadDisco='" + capacidadDisco + '\'' +
               ", numPuertosUSB=" + numPuertosUSB +
               ", numPuertosHDMI=" + numPuertosHDMI +
               ", marcaMonitor='" + marcaMonitor + '\'' +
               ", pulgadas=" + pulgadas +
               ", precio=" + precio +
               '}';
    }
}









