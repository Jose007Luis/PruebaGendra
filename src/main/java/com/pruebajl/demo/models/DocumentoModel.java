package com.pruebajl.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Documentos")
public class DocumentoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int IdOrdenDocumento;

    private String documento;
    private int idCliente;
    private int idProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
	private ClienteModel cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
	private ProductoModel productos;

    public int getIdOrdenDocumento() {
        return IdOrdenDocumento;
    }

    public void setIdOrdenDocumento(int idOrdenDocumento) {
        IdOrdenDocumento = idOrdenDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public ProductoModel getProductos() {
        return productos;
    }

    public void setProductos(ProductoModel productos) {
        this.productos = productos;
    }
}
