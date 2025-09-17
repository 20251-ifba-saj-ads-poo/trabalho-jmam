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
    @Size(min = 11, max = 11)
    private String cpf;


    public Usuario(){}

    public Usuario(String email, String login, String senha, String nome, String cpf) throws Exception {
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

    public void setEmail(String email) throws Exception {       
        if(email.contains("@ifba.com"))
            this.email = email;
        else
            throw new Exception("Email inválido / Formato aceito -@ifba.com "); 
    }
    @Override
    public String toString() {
        return "Usuario [senha=" + senha + ", login=" + login + ", email=" + email + "]";
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public void setCPF(String cpf) throws Exception {
        if(cpf!=null && cpf.matches("\\d+") && cpf.length()==11)
            this.cpf=cpf;
        else
            throw new Exception("CPF inválido / Formato aceito 11 digitos numericos sem pontuação"); 
    }

    public String getCPF(){
        return cpf;
    }

}
