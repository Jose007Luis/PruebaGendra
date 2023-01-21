package com.pruebajl.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebajl.demo.models.DocumentoModel;
import com.pruebajl.demo.repositories.DocumentoRepository;

@Service
public class DocumentoService {

    @Autowired
    DocumentoRepository documentoRepository;
    
    public ArrayList<DocumentoModel> obtenerDocumentos(){
        try{
            ArrayList<DocumentoModel> listTodos =(ArrayList<DocumentoModel>)documentoRepository.findAll();

            ArrayList<DocumentoModel> listTodosRegreso = new ArrayList<DocumentoModel>();

            for (var item : listTodos) {
                DocumentoModel datos = new DocumentoModel();
                datos.setIdOrdenDocumento(item.getIdOrdenDocumento()); 
                datos.setDocumento(item.getDocumento()); 
                datos.setIdCliente(item.getIdCliente()); 
                datos.setIdProducto(item.getIdProducto()); 
                //datos.setCliente(item.getCliente());
                //datos.setProductos(item.getProductos());

                listTodosRegreso.add(datos);
            }

            return listTodosRegreso;
            //return (ArrayList<DocumentoModel>) documentoRepository.findAll();
        }
        catch(Exception ex){
            //Console.print(ex.getMessage().toString());
            return null;
        }
    }

    public Optional<DocumentoModel> obtenerPorId(Long id){
        return documentoRepository.findById(id);
    }

    public ArrayList<DocumentoModel> obtenerPorDocumento(String documento){

        ArrayList<DocumentoModel> listTodos =(ArrayList<DocumentoModel>)documentoRepository.findByDocumento(documento);

        ArrayList<DocumentoModel> listTodosRegreso = new ArrayList<DocumentoModel>();

        for (var item : listTodos) {
            DocumentoModel datos = new DocumentoModel();
            datos.setIdOrdenDocumento(item.getIdOrdenDocumento()); 
            datos.setDocumento(item.getDocumento()); 
            datos.setIdCliente(item.getIdCliente()); 
            datos.setIdProducto(item.getIdProducto()); 
            //datos.setCliente(item.getCliente());
            //datos.setProductos(item.getProductos());

            listTodosRegreso.add(datos);
        }

        return listTodosRegreso;
    }

    public DocumentoModel guardarDocumento(DocumentoModel documento){
        return documentoRepository.save(documento);
    }


    public DocumentoModel actualizarDocumento(DocumentoModel documento){

        DocumentoModel datos = new  DocumentoModel();
        datos.setIdOrdenDocumento(documento.getIdOrdenDocumento());
        datos.setDocumento(documento.getDocumento());
        datos.setIdCliente(documento.getIdCliente());
        datos.setIdProducto(documento.getIdProducto());

        return documentoRepository.save(datos);
    }

    public boolean eliminarDocumento(Long id){
        try{
            documentoRepository.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
