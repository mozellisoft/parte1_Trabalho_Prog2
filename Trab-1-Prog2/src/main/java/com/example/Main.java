package com.example;

import com.example.view.MedicoView;

public class Main {
    public static void main(String[] args) {
        try {
            MedicoView medicoView = new MedicoView();
            medicoView.exibirMenu();
        } catch (Exception e) {
            System.err.println("Erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        } finally {
            com.example.dao.ConexaoDAO.fecharConexao();
        }
    }
} 