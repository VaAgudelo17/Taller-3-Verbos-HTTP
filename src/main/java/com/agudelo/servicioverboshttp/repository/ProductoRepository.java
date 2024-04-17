package com.agudelo.servicioverboshttp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agudelo.servicioverboshttp.model.Producto;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {
	
	

}
