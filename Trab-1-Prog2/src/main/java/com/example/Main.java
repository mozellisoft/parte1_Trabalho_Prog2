package com.example;

import com.example.dao.MedicoDAO;
import com.example.model.Medico;

public class Main {
    public static void main(String[] args) {
        try {
            MedicoDAO medicoDAO = new MedicoDAO();
            
            
            System.out.println("Inserindo médico...");
            Medico medico = new Medico();
            medico.setNome("Dr. João Silva");
            medico.setCrm("12345-SP");
            medico.setEspecialidade("Cardiologia");
            medicoDAO.inserir(medico);
            System.out.println("Médico inserido com sucesso! ID: " + medico.getId());
            
            
            System.out.println("\nBuscando médico...");
            Medico medicoBuscado = medicoDAO.buscarPorId(medico.getId());
            System.out.println("Médico encontrado: " + medicoBuscado);
            
            
            System.out.println("\nAtualizando médico...");
            medicoBuscado.setNome("Dr. João Silva Santos");
            medicoDAO.atualizar(medicoBuscado);
            System.out.println("Médico atualizado com sucesso!");
            
            
            System.out.println("\nListando todos os médicos...");
            medicoDAO.listarTodos().forEach(System.out::println);
            
            
            System.out.println("\nExcluindo médico...");
            medicoDAO.excluir(medico.getId());
            System.out.println("Médico excluído com sucesso!");
            
        } catch (Exception e) {
            System.err.println("Erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        } finally {
            
            com.example.dao.ConexaoDAO.fecharConexao();
        }
    }
} 