package br.edu.ifba.saj.fwads.model;

import java.util.Calendar;
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
    private Calendar dataCriacao;
    @OneToOne
    private Professor criador;
    @Temporal(TemporalType.DATE)
    private Calendar dataModificacao;
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

    
}