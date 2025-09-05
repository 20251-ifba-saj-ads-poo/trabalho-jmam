package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.Date;



public class Feira extends AbstractEntity {
    
    private String nome;
    private Date data;
    private ArrayList<Projeto> projetos;

    public Feira(){}

    public Feira(String nome/*, Date data*/){
        this.nome=nome;
        //this.data=data;
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
