package br.edu.ifba.saj.fwads.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario extends AbstractEntity {

    @Column
    @NotBlank
    @Size(min = 5)
    private String senha;
    @Column
    @NotBlank
    @Size(min = 5)
    private String login;
    @Column
    @Email
    private String email;
    @Column
    @NotBlank
    private String nome;
    @Column
    @NotBlank
    private String cpf;


    public Usuario(){}

    public Usuario(String email, String login, String senha, String nome, String cpf) {
        setSenha(senha);
        setLogin(login);
        setEmail(email);
        setNome(nome);
        setCPF(cpf);
    }

    

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Usuario [senha=" + senha + ", login=" + login + ", email=" + email + "]";
    }

    public String getNome(){
        return nome;
    }

    private void setNome(String nome) {
        this.nome=nome;
    }

    private void setCPF(String cpf) {
        this.cpf=cpf;
    }

}
