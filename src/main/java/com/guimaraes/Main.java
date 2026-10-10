package com.guimaraes;

import com.guimaraes.dao.FornecedorDAO;
import com.guimaraes.dao.FornecedorDAOImpl;
import com.guimaraes.model.Fornecedor;
import com.guimaraes.service.FornecedorService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        FornecedorDAO fornecedorDAO = new FornecedorDAOImpl();
        FornecedorService fornecedorService = new FornecedorService(fornecedorDAO);

        List<Fornecedor> fornecedores =  fornecedorDAO.listarTodos();
        for (Fornecedor fornecedor1 : fornecedores){
            IO.println(fornecedor1.toString());
        }
        IO.println("-----------------------------------------------");

        Fornecedor fornecedorBuscado1 = fornecedorDAO.buscarPorId(
                UUID.fromString("05935b32-94f6-4e18-a729-ff97ea0b61a6")
        );

        Fornecedor fornecedorBuscado2 = fornecedorDAO.buscarPorCNPJ("324009");

        IO.println(fornecedorBuscado1.toString());
        IO.println("-----------------------------------------------");
        IO.println(fornecedorBuscado2.toString());
    }
}
