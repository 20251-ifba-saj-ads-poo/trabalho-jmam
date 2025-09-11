package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Professor extends Usuario{
    @OneToMany
    private List<Projeto> projetos;

    public Professor() {  
        projetos=new ArrayList<>();       
    }

<<<<<<< HEAD
    public Professor(@Email String email,@NotBlank @Size(min=5) String nome, @NotBlank @Size(min = 11, max = 11) String cpf) {
        super(email, nome,cpf);
=======
    public Professor(String email, String nome, String cpf) {
        super(email,email,cpf, nome,cpf);
>>>>>>> 84b5fcd43212f67e82355e545ae1b42c18f670d3
        projetos=new ArrayList<>();        
    }

    public Professor(@Email String email, @NotBlank @Size(min=5) String login,@NotBlank @Size(min=5) String senha,@NotBlank String nome,@NotBlank @Size(min = 11, max = 11) String cpf) {
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