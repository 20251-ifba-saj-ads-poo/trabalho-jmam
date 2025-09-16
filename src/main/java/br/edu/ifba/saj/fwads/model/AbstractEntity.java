package br.edu.ifba.saj.fwads.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.Type;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @OneToOne
    private Professor criador;
    @Temporal(TemporalType.DATE)
    private Date dataModificacao;
    @OneToOne
    private Professor modificador;

    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractEntity)) {
            return false; // null or other class
        }
        AbstractEntity other = (AbstractEntity) obj;

        if (id != null) {
            return id.equals(other.id);
        }
        return super.equals(other);
    }

    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao() {
        this.dataCriacao = new Date();
    }

    public Professor getCriador() {
        return criador;
    }

    public void setCriador(Professor criador) {
        this.criador = criador;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao() {
        this.dataModificacao = new Date();
    }

    public Professor getModificador() {
        return modificador;
    }

    public void setModificador(Professor modificador) {
        this.modificador = modificador;
    }

    
}