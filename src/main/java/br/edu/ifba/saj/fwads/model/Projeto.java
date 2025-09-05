package br.edu.ifba.saj.fwads.model;
import java.util.ArrayList;
import java.util.List;
public final class Projeto extends AbstractEntity{
    
    private String nome;
    private ArrayList<Professor> professores;
    private Professor lider;
    private List<Estudante> estudantes;
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
