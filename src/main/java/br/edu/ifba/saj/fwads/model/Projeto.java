package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
    
    @ManyToMany (targetEntity = Professor.class)
    private List<Professor> professores;

    

    @ManyToOne
    private Feira feira;

    public Projeto(){}

    public Projeto(@NotBlank @Size(min=5) String nome, @NotBlank Professor professor) throws Exception{
        setNome(nome);
        setLider(professor);
        professores = new ArrayList<Professor>();
        professores.add(professor);
    }

    public void setFeira(Feira feira) {
        this.feira = feira;
    }

    public String getNome(){
        return nome;
    }

    public Professor getLider(){
        return lider;
    }

    public void setNome(String nome) throws Exception {
        if(!nome.equals(""))
            this.nome = nome;
        else
            throw new Exception ("Nome não pode ser deixado em branco");
    }

    public void setLider(Professor lider) throws Exception {
        if(lider!=null)
            this.lider = lider;
        else
            throw new Exception ("É obrigatório selecionar um professor");
    }

    public List<Estudante> getEstudante() {
        return List.copyOf(estudante);
    }

    
    public void addEstudante(Estudante estudante) {
        this.estudante.add(estudante);
    }

    public Feira getFeira() {
        return feira;
    }

    public void removeEstudante(Estudante estudante){
        this.estudante.remove(estudante);
    }

    public void setEstudante(List<Estudante> estudante) {
        this.estudante = estudante;
    }

    public List<Professor> getProfessores() {
        return List.copyOf(professores);
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public void addProfessor(Professor professor) {
        if(!professores.contains(professor))
            this.professores.add(professor);
    }

}
