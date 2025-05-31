package com.example.controller;

import com.example.dao.MedicoDAO;
import com.example.model.Medico;
import java.util.List;

public class MedicoController {
    private final MedicoDAO medicoDAO;
    
    public MedicoController() {
        this.medicoDAO = new MedicoDAO();
    }
    
    public void cadastrarMedico(String nome, String crm, String especialidade) {
        Medico medico = new Medico();
        medico.setNome(nome);
        medico.setCrm(crm);
        medico.setEspecialidade(especialidade);
        
        medicoDAO.inserir(medico);
    }
    
    public Medico buscarMedico(int id) {
        return medicoDAO.buscarPorId(id);
    }
    
    public List<Medico> listarMedicos() {
        return medicoDAO.listarTodos();
    }
    
    public void atualizarMedico(int id, String nome, String crm, String especialidade) {
        Medico medico = new Medico();
        medico.setId(id);
        medico.setNome(nome);
        medico.setCrm(crm);
        medico.setEspecialidade(especialidade);
        
        medicoDAO.atualizar(medico);
    }
    
    public void excluirMedico(int id) {
        medicoDAO.excluir(id);
    }
} 