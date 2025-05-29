package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgres {
    private static final String URL = "jdbc:postgresql://localhost:5432/trab_part1";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
                conexao.close();
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
} 