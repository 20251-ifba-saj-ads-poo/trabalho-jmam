package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Feira extends AbstractEntity {
    @NotBlank
    private String nome;
    @NotBlank
    private Date data;
    
    @OneToMany(mappedBy = "feira")
    private List<Projeto> projetos;

    public Feira(){}

    public Feira(String nome/*, Date data*/){
        this.nome=nome;
        //this.data='00/00/00';
        
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    

    
}
