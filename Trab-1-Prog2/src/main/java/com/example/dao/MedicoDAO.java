package com.example.dao;

import com.example.model.Medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    
    public void inserir(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Médico não pode ser nulo");
        }
        if (medico.getNome() == null || medico.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do médico é obrigatório");
        }
        if (medico.getCrm() == null || medico.getCrm().trim().isEmpty()) {
            throw new IllegalArgumentException("CRM do médico é obrigatório");
        }
        if (medico.getEspecialidade() == null || medico.getEspecialidade().trim().isEmpty()) {
            throw new IllegalArgumentException("Especialidade do médico é obrigatória");
        }

        String sql = "INSERT INTO medico (nome, crm, especialidade) VALUES (?, ?, ?)";
        
        try (Connection conn = ConexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setString(3, medico.getEspecialidade());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    medico.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir médico: " + e.getMessage());
        }
    }
    
    public Medico buscarPorId(int id) {
        String sql = "SELECT * FROM medico WHERE id = ?";
        
        try (Connection conn = ConexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Medico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("crm"),
                        rs.getString("especialidade")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar médico por ID: " + e.getMessage());
        }
        return null;
    }
    
    public List<Medico> listarTodos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medico ORDER BY nome";
        
        try (Connection conn = ConexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                medicos.add(new Medico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("crm"),
                    rs.getString("especialidade")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar médicos: " + e.getMessage());
        }
        return medicos;
    }
    
    public void atualizar(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Médico não pode ser nulo");
        }
        if (medico.getId() <= 0) {
            throw new IllegalArgumentException("ID do médico inválido");
        }
        if (medico.getNome() == null || medico.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do médico é obrigatório");
        }
        if (medico.getCrm() == null || medico.getCrm().trim().isEmpty()) {
            throw new IllegalArgumentException("CRM do médico é obrigatório");
        }
        if (medico.getEspecialidade() == null || medico.getEspecialidade().trim().isEmpty()) {
            throw new IllegalArgumentException("Especialidade do médico é obrigatória");
        }

        String sql = "UPDATE medico SET nome = ?, crm = ?, especialidade = ? WHERE id = ?";
        
        try (Connection conn = ConexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setString(3, medico.getEspecialidade());
            stmt.setInt(4, medico.getId());
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new RuntimeException("Médico não encontrado para atualização");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar médico: " + e.getMessage());
        }
    }
    
    public void excluir(int id) {
        String sql = "DELETE FROM medico WHERE id = ?";
        
        try (Connection conn = ConexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new RuntimeException("Médico não encontrado para exclusão");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir médico: " + e.getMessage());
        }
    }
} 