package com.pruebajl.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebajl.demo.models.DocumentoModel;

@Repository
public interface DocumentoRepository extends CrudRepository<DocumentoModel, Long>{

    //nos permite filtrar por docuemnto
    public abstract ArrayList<DocumentoModel>findByDocumento(String documento);
    
}
