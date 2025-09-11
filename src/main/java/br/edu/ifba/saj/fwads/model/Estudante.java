package br.edu.ifba.saj.fwads.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class Estudante extends Usuario{

    @NotBlank
    private Projeto projeto;

    public Estudante(@Email String email,@NotBlank @Size(min=5) String nome, @NotBlank @Size(min = 11, max = 11) String cpf) {
        super(email, nome,cpf);        
    }

    public Estudante(@Email String email, @NotBlank @Size(min=5) String login,@NotBlank @Size(min=5) String senha,@NotBlank String nome,@NotBlank @Size(min = 11, max = 11) String cpf) {
        super(email, login, senha, nome,cpf);        
    }

    /*public List<Projeto> getProjetos(){
        return List.copyOf(projetos);
    }

    public void addProjeto(Projeto projeto){
        projetos.add(projeto);
    }

    public void removeProjeto(Projeto projeto){
        projetos.remove(projeto);
    }*/

    public void setProjeto(Projeto projeto){
        this.projeto=projeto;
    }

    public Projeto getProjeto(){
        return projeto;
    }



}

