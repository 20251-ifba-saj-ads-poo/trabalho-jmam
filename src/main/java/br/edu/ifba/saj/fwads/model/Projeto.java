package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public final class Projeto extends AbstractEntity{

    @Column
    @NotBlank
    @Size(min = 5)
    private String nome;
    
    @ManyToOne
    private Professor lider;
    
    @ManyToMany
    private List<Estudante> estudantes;
    
    @ManyToMany
    private List<Professor> professores;
    
    @ManyToOne
    private Feira feira;

    public Projeto(){}

    public Projeto(@NotBlank @Size(min=5) String nome, @NotBlank Professor professor){
        this.nome=nome;
        this.lider=professor;
    }

    public List<Professor> getProfessores(){
        return List.copyOf(professores);
    }

    public List<Estudante> getEstudantes(){
        return List.copyOf(estudantes);
    }


    public void setFeira(Feira feira) {
        this.feira = feira;
    }

    public String getNome(){
        return nome;
    }

    public String getLider(){
        return lider.getNome();
    }

    
}
