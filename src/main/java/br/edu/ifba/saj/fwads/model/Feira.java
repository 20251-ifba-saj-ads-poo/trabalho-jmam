package br.edu.ifba.saj.fwads.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Feira extends AbstractEntity {
    @Column
    @NotBlank
    private String nome;
    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @OneToMany(mappedBy = "feira")
    private List<Projeto> projetos;

    public Feira(){}

    public Feira(String nome, Date data) throws Exception{
        setNome(nome);
        setData(data);        
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

    public void setData(Date data) throws Exception {       
        if(!data.before(new Date()))
            this.data = data;
        else
            throw new Exception ("Data inválida");
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public void addProjeto(Projeto projeto){
        projetos.add(projeto);
    }
    
    public void removeProjeto(Projeto projeto){
        projetos.remove(projeto);
    }

    
}
