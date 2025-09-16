package br.edu.ifba.saj.fwads.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Estudante extends Usuario{

    //@ManyToMany(mappedBy = "estudantes")
    //private List<Projeto> projetos;

    @ManyToOne
    private Projeto projeto;

    public Estudante(){}

    public Estudante(@Email String email,@NotBlank @Size(min=5) String nome, @NotBlank @Size(min = 11, max = 11) String cpf) {
        super(email, email, cpf, nome,cpf);        
    }

    public Estudante(@Email String email, @NotBlank @Size(min=5) String login,@NotBlank @Size(min=5) String senha,@NotBlank String nome,@NotBlank @Size(min = 11, max = 11) String cpf) {
        super(email, login, senha, nome,cpf);        
    }

    /*public List<Projeto> getProjetos() {
        return projetos;
    }*/
    public Projeto getProjeto(){
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String nomeProjeto(){
        if(projeto!=null)
            return projeto.getNome();
        return "";
    }
    




}

