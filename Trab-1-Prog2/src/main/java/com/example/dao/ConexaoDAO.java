package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/trab_part1";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";
    
    private static Connection conexao;
    
    public static Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Driver JDBC não encontrado: " + e.getMessage());
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
            }
        }
        return conexao;
    }
    
    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
} 