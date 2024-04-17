package com.agudelo.servicioverboshttp.service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agudelo.servicioverboshttp.model.Producto;
import com.agudelo.servicioverboshttp.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class ProductoService {
	private static final Logger log = LoggerFactory.getLogger(ProductoService.class);
	
	 @Autowired
	    private ProductoRepository productoRepository;

	    public List<Producto> findAll() {
	    	return productoRepository.findAll();
	    }

	    public Optional<Producto> findById(String id) {
	    	Optional<Producto> producto = productoRepository.findById(id);
	        log.info("Buscando producto con ID: {}", id);
	        if (producto.isPresent()) {
	            log.info("Producto encontrado: {}", producto.get());
	        } else {
	            log.info("Producto no encontrado con ID: {}", id);
	        }
	        return producto;
	    }

	    

	    public Producto updateProducto(Producto producto) {
	    	 try {
	    	        return productoRepository.save(producto);
	    	    } catch (Exception e) {
	    
	    	        log.error("Error updating product: " + producto, e);
	    	        return null;
	    	    }
	    }

	    public void deleteProducto(String id) {

	    	 try {
	    	        productoRepository.deleteById(id);
	    	    } catch (Exception e) {
	    	        log.error("Error deleting product with ID: " + id, e);
	    	        throw new RuntimeException("Error deleting the product");
	    	    }
	    	   
	    }
	    
	    public Producto save(Producto producto) {
	    	try {
	            return productoRepository.save(producto);
	        } catch (Exception e) {
	            log.error("Error saving product: " + producto, e);
	            return null;
	        }  
	    }
	

}
