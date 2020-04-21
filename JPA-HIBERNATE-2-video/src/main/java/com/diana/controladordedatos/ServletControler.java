package com.diana.controladordedatos;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diana.DAO.ProductoDao;
import com.diana.model.Producto;
import com.google.gson.Gson;
import com.sun.beans.util.Cache;

/**
 * Servlet implementation class ServletControler
 */
public class ServletControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Producto pr = new Producto();
		ProductoDao prd = new ProductoDao();
		
		String id = null;
		String nombreProducto = null;
		String precioProducto = null;
		String cantidadProducto = null;
		String totalProducto = null;
		
		try {
			id = request.getParameter("Id_pro");
			nombreProducto = request.getParameter("Nproductos");
			precioProducto = request.getParameter("Pproductos");
			cantidadProducto = request.getParameter("Cproductos");
			totalProducto = request.getParameter("Tproductos");
			
			pr.setIdProductos(Integer.parseInt(id));
			pr.setNombreProducto(nombreProducto);
			pr.setPrecioProducto(Double.parseDouble(precioProducto));
			pr.setCantidadProducto(Integer.parseInt(cantidadProducto));
			pr.setTotalProducto(Double.parseDouble(totalProducto));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	
		
		String acction = request.getParameter("btn");
		
		
		if (acction.equals("GUARDAR")){
			pr.setIdProductos(Integer.parseInt(id));
			pr.setNombreProducto(nombreProducto);
			pr.setPrecioProducto(Double.parseDouble(precioProducto));
			pr.setCantidadProducto(Integer.parseInt(cantidadProducto));
			pr.setTotalProducto(Double.parseDouble(totalProducto));
		
			prd.agregarDatos(pr);	
		}
		else if(acction.equals("ACTUALIZAR")){
			pr.setIdProductos(Integer.parseInt(id));
			pr.setNombreProducto(nombreProducto);
			pr.setPrecioProducto(Double.parseDouble(precioProducto));
			pr.setCantidadProducto(Integer.parseInt(cantidadProducto));
			pr.setTotalProducto(Double.parseDouble(totalProducto));
		
		prd.actualizarDatos(pr);
		}
		
	else if(acction.equals("ELIMINAR")){
		pr.setIdProductos(Integer.parseInt(id));
	    prd.eliminarDatos(pr);
	}
		
		
		
		
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDao prdao = new ProductoDao();
		
		Gson json = new Gson();
		
		try {
			
			response.getWriter().append(json.toJson(prdao.productoLista ()));
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

}
