package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.List;


public class Estudante extends Usuario{
    
    private List<Projeto> projetos;

    public Estudante(String email, String nome, String cpf) {
        super(email, nome,cpf);
        projetos=new ArrayList<>();        
    }

    public Estudante(String email, String login, String senha, String nome,String cpf) {
        super(email, login, senha, nome,cpf);
        projetos=new ArrayList<>();        
    }

    public List<Projeto> getProjetos(){
        return List.copyOf(projetos);
    }

    public void addProjeto(Projeto projeto){
        projetos.add(projeto);
    }

    public void removeProjeto(Projeto projeto){
        projetos.remove(projeto);
    }

}

