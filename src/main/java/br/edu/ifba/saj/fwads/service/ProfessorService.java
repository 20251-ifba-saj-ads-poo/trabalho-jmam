package br.edu.ifba.saj.fwads.service;

import java.util.Map;
import java.util.NoSuchElementException;

import br.edu.ifba.saj.fwads.exception.LoginInvalidoException;
import br.edu.ifba.saj.fwads.model.Professor;

public class ProfessorService extends Service<Professor> {

    public ProfessorService() {
        super(Professor.class);
    }

    public Professor validaLogin(String login, String senha) throws LoginInvalidoException {
        try {
            return findByMap(Map.of("login", login, "senha", senha)).getFirst();
        } catch (NoSuchElementException e) {
            throw new LoginInvalidoException(
                "Não foi possível localizar o usuário " + login + ", ou a senha esta errada");
        }
    }
}
