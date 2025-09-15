package br.edu.ifba.saj.fwads.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    
    //@ManyToOne
    //private List<Estudante> estudantes;
    
    //@ManyToOne
    //private List<Professor> professores;
    
    @OneToMany(mappedBy="projeto")
    private List<Estudante> estudante;
    //@ManyToOne
    //private List<Professor> professores;

    @ManyToOne
    private Feira feira;

    public Projeto(){}

    public Projeto(@NotBlank @Size(min=5) String nome, @NotBlank Professor professor){
        this.nome=nome;
        this.lider=professor;
    }

    /*public List<Professor> getProfessores(){
        return List.copyOf(professores);
    }

    public List<Estudante> getEstudantes(){
        return List.copyOf(estudantes);
    }*/


    


    public void setFeira(Feira feira) {
        this.feira = feira;
    }

    public String getNome(){
        return nome;
    }

    public Professor getLider(){
        return lider;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLider(Professor lider) {
        this.lider = lider;
    }

    public List<Estudante> getEstudante() {
        return List.copyOf(estudante);
    }

    public void setEstudante(Estudante estudante) {
        this.estudante.add(estudante);
    }

    public Feira getFeira() {
        return feira;
    }

    public void removeEstudante(Estudante estudante){
        this.estudante.remove(estudante);
    }
}
