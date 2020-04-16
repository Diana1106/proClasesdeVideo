package com.diana.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	@Override
	public String toString() {
		return "Producto [idProductos=" + idProductos + ", cantidadProducto=" + cantidadProducto + ", nombreProducto="
				+ nombreProducto + ", precioProducto=" + precioProducto + ", totalProducto=" + totalProducto + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_productos")
	private int idProductos;

	@Column(name="cantidad_producto")
	private int cantidadProducto;

	@Column(name="nombre_producto")
	private String nombreProducto;

	@Column(name="precio_producto")
	private double precioProducto;

	@Column(name="total_producto")
	private double totalProducto;

	public Producto() {
	}

	public int getIdProductos() {
		return this.idProductos;
	}

	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}

	public int getCantidadProducto() {
		return this.cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioProducto() {
		return this.precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public double getTotalProducto() {
		return this.totalProducto;
	}

	public void setTotalProducto(double totalProducto) {
		this.totalProducto = totalProducto;
	}

}