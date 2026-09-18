/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.usuario.interfaces.Autenticavel;

/**
 *
 * @author mariorocha
 */
public class Usuario implements Autenticavel{
    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private String genero;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    
    // Constructor completo
    public Usuario(String nome, String cpf, String dataDeNascimento, String genero, String telefone, String email, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }
    // Constructor vazio
    public Usuario() {
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean autenticar(String login, String senha) {
        // Retorna true caso os dados sejam iguais ou false caso sejam falsos
        return login.equals(this.login) && senha.equals(this.senha);   
    }
    
}
