package com.example.view;

import com.example.controller.MedicoController;
import com.example.model.Medico;
import java.util.List;
import java.util.Scanner;

public class MedicoView {
    private final MedicoController controller;
    private final Scanner scanner;
    
    public MedicoView() {
        this.controller = new MedicoController();
        this.scanner = new Scanner(System.in);
    }
    
    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== MENU MÉDICO ===");
            System.out.println("1. Cadastrar Médico");
            System.out.println("2. Buscar Médico");
            System.out.println("3. Listar Médicos");
            System.out.println("4. Atualizar Médico");
            System.out.println("5. Excluir Médico");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarMedico();
                    break;
                case 2:
                    buscarMedico();
                    break;
                case 3:
                    listarMedicos();
                    break;
                case 4:
                    atualizarMedico();
                    break;
                case 5:
                    excluirMedico();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    private void cadastrarMedico() {
        System.out.println("\n=== CADASTRO DE MÉDICO ===");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        
        try {
            controller.cadastrarMedico(nome, crm, especialidade);
            System.out.println("Médico cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar médico: " + e.getMessage());
        }
    }
    
    private void buscarMedico() {
        System.out.println("\n=== BUSCAR MÉDICO ===");
        
        System.out.print("ID do médico: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        try {
            Medico medico = controller.buscarMedico(id);
            if (medico != null) {
                System.out.println("\nMédico encontrado:");
                System.out.println(medico);
            } else {
                System.out.println("Médico não encontrado!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar médico: " + e.getMessage());
        }
    }
    
    private void listarMedicos() {
        System.out.println("\n=== LISTA DE MÉDICOS ===");
        
        try {
            List<Medico> medicos = controller.listarMedicos();
            if (medicos.isEmpty()) {
                System.out.println("Nenhum médico cadastrado!");
            } else {
                medicos.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar médicos: " + e.getMessage());
        }
    }
    
    private void atualizarMedico() {
        System.out.println("\n=== ATUALIZAR MÉDICO ===");
        
        System.out.print("ID do médico: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Novo CRM: ");
        String crm = scanner.nextLine();
        
        System.out.print("Nova especialidade: ");
        String especialidade = scanner.nextLine();
        
        try {
            controller.atualizarMedico(id, nome, crm, especialidade);
            System.out.println("Médico atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar médico: " + e.getMessage());
        }
    }
    
    private void excluirMedico() {
        System.out.println("\n=== EXCLUIR MÉDICO ===");
        
        System.out.print("ID do médico: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        try {
            controller.excluirMedico(id);
            System.out.println("Médico excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir médico: " + e.getMessage());
        }
    }
} 