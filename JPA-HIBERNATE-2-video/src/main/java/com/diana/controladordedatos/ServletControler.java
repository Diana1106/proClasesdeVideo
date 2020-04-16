package com.diana.controladordedatos;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diana.model.Producto;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acction = request.getParameter("btn");
		EntityManager em;
		EntityManagerFactory emf;
		
		emf = Persistence.createEntityManagerFactory("JPA-HIBERNATE-2-video");
		em = emf.createEntityManager();
		
		Producto pr = new Producto();
		
		try {
		String id = request.getParameter("Id_pro");
		String nombreProducto = request.getParameter("Nproductos");
		String precioProducto = request.getParameter("Pproductos");
		String cantidadProducto = request.getParameter("Cproductos");
		String totalProducto = request.getParameter("Tproductos");
		
		
		
		pr.setIdProductos(Integer.parseInt(id));
		pr.setNombreProducto(nombreProducto);
		pr.setPrecioProducto(Double.parseDouble(precioProducto));
		pr.setCantidadProducto(Integer.parseInt(cantidadProducto));
		pr.setTotalProducto(Double.parseDouble(totalProducto));
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (acction.equals("agregar")){
		  //System.out.println("SOY AGREGAR");
			
			em.getTransaction().begin();
			em.persist(pr);
			em.flush();
			em.getTransaction().commit();
		  
		}else if(acction.equals("eliminar")){
		  //System.out.println("SOY ELIMINAR");
			
			
			pr = em.getReference(Producto.class, pr.getIdProductos());
			em.getTransaction().begin();
			em.remove(pr);
			em.flush();
			em.getTransaction().commit();
		

		}else if(acction.equals("modificar")){
		  //System.out.println("SOY MODIFICAR");
			
			em.getTransaction().begin();
			em.merge(pr);
			em.flush();
			em.getTransaction().commit();

		}
		response.sendRedirect("index.jsp");
		
	}

}
