package br.edu.ifba.saj.fwads.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Professor extends Usuario{
    
    
    @ManyToMany(mappedBy = "professores")
    private List<Projeto> projetos;

    public Professor() {  
    }
    
    public Professor(@NotBlank @Email String email, @NotBlank @Size(min=5) String nome, @NotBlank @Size(min = 11, max = 11) String cpf) {
        super(email,email,cpf, nome, cpf);
    }

    public Professor(@NotBlank @Email String email, @NotBlank @Size(min=5) String login,@NotBlank @Size(min=5) String senha,@NotBlank String nome,@NotBlank @Size(min = 11, max = 11) String cpf) {
        super(email, login, senha, nome,cpf);
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    





}