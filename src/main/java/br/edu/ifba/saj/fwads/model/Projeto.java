package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public final class Projeto extends AbstractEntity{

    @Column
    @NotBlank
    @Size(min = 5)
    private String nome;
    @Column
    @NotBlank
    private Professor lider;
    @ManyToOne
    private List<Estudante> estudantes;
    @ManyToOne
    private List<Professor> professores;
    @Column
    private Feira feira;

    public Projeto(){}

    public Projeto(String nome, Professor professor){
        this.nome=nome;
        this.professores= new ArrayList<>();
        this.estudantes= new ArrayList<>();
        addProfessor(professor);
        this.lider=professor;
    }

    public List<Professor> getProfessores(){
        return List.copyOf(professores);
    }

    public List<Estudante> getEstudantes(){
        return List.copyOf(estudantes);
    }

    public void addProfessor(Professor professor){
        professores.add(professor);
        professor.addProjeto(this);
    }

    public void removeProfessor(Professor professor){
        professores.remove(professor);
        professor.removeProjeto(this);
    }

    public void addEstudante (Estudante estudante){
        estudantes.add(estudante);
        estudante.addProjeto(this);
    }

    public void removeEstudante (Estudante estudante){
        estudantes.remove(estudante);
        estudante.removeProjeto(this);
    }

    public void addFeira(Feira feira) {
        this.feira=feira;
    }

    public String getNome(){
        return nome;
    }

    public String getLider(){
        return lider.getNome();
    }

    
}
