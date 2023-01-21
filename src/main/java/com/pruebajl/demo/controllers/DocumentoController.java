package com.pruebajl.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebajl.demo.Services.DocumentoService;
import com.pruebajl.demo.models.DocumentoModel;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class DocumentoController {

    @Autowired
    DocumentoService documentoService;
    
    @GetMapping("/allOrdenesDocumentos")   
    public ArrayList<DocumentoModel> obtenerDocumentos() {
        return documentoService.obtenerDocumentos();
    }
    
    @GetMapping("obtieneDocumentoPorId/{id}")
    public Optional<DocumentoModel> obtieneDocumentoPorId(@PathVariable("id") Long id) {
        return documentoService.obtenerPorId(id);
    }

    @GetMapping("obtieneDocumentoPorDocumento/documento")
    public ArrayList<DocumentoModel> obtieneDocumentoPorDocumento(@RequestParam("documento") String documento) {
        return this.documentoService.obtenerPorDocumento(documento);
    }

    @PostMapping("/guardarDocumento")  
    public DocumentoModel guardarDocumento(@RequestBody DocumentoModel documento) {
        return this.documentoService.guardarDocumento(documento);
    }

    @PostMapping("/actualizarDocumento")  
    public DocumentoModel actualizarDocumento(@RequestBody DocumentoModel documento) {
        return this.documentoService.actualizarDocumento(documento);
    }

    @PostMapping("eliminarDocumentoPorId/{id}")
    public String eliminarDocumentoPorId(@PathVariable("id") Long id){
        boolean ok = this.documentoService.eliminarDocumento(id);
        if(ok){
            return "Documento eliminado con el id" + id;
        }else{  
            return "No se pudo eliminar el documento con el id" + id;
        }

    }
}
