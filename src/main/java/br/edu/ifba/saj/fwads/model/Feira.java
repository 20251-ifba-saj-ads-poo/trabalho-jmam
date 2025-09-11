package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;



public class Feira extends AbstractEntity {
    @NotBlank
    private String nome;
    @NotBlank
    private Date data;
    @OneToMany
    private ArrayList<Projeto> projetos;

    public Feira(){}

    public Feira(String nome/*, Date data*/){
        this.nome=nome;
        //this.data='00/00/00';
        this.projetos = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void addProjeto(Projeto projeto){
        projetos.add(projeto);
        projeto.addFeira(this);
    }
}
