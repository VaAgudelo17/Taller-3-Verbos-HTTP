package com.agudelo.servicioverboshttp.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agudelo.servicioverboshttp.model.Producto;
import com.agudelo.servicioverboshttp.service.ProductoService;

@RestController
@RequestMapping("/api/v1")

public class ProductoController {
	@Autowired
    private ProductoService productoService;
	

	@PostMapping("/productos")
	public void save(@RequestBody Producto producto) {
		productoService.save(producto);
	}
	

	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getAllProductos() {
	    List<Producto> productos = productoService.findAll();
	    if (productos.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(productos, HttpStatus.OK);
	}
    

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable String id) {
        Optional<Producto> producto = productoService.findById(id);  
        if (producto.isPresent()) {
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PutMapping("/producto/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable String id, @RequestBody Producto producto) {
    	if (!producto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }
        Optional<Producto> existingProducto = productoService.findById(id);
        if (!existingProducto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        
        try {
            Producto updatedProducto = productoService.updateProducto(producto);
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }
    

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable String id) {
        productoService.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

    @RequestMapping(value = "/producto/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> checkProductoById(@PathVariable String id) {
        Optional<Producto> producto = productoService.findById(id);
        return producto.isPresent() ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @PatchMapping("/producto/{id}")
    public ResponseEntity<Producto> updateProductoPrecio(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        Optional<Producto> productoExistente = productoService.findById(id);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            if (updates.containsKey("precio")) {
                double nuevoPrecio = Double.parseDouble(updates.get("precio").toString());
                producto.setPrecio(nuevoPrecio);
                Producto productoActualizado = productoService.updateProducto(producto);
                return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
        }
        
    }
    
   
    @RequestMapping(value = "/producto/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsForProductoById(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ALLOW, "GET, POST, PUT, DELETE, PATCH");
        return ResponseEntity.ok().headers(headers).build();
    }
    
    
   
    
}