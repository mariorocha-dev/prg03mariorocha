/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.ifba.usuario.validar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mariorocha
 */
public class ValidadorUsuarioTest {
    ValidadorUsuario usuarioTeste;
    public ValidadorUsuarioTest() {
        this.usuarioTeste = new ValidadorUsuario("12345", "Mario", "12343234311", "25/12/2003", "Masculino", "(74)92123-9088", "mario@gmail.com", "mariorocha-dev", "batata123");
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    // Testa se o sistema reconhce que o tamanho é valido
    @Test
    void testIsTamanhoValidoCpf(){
        usuarioTeste.setCpf("12321232121");
        boolean expected = true;
        boolean actual = usuarioTeste.isTamanhoValidoCpf();
        assertEquals(expected, actual);
    }
    // Testa se o sistema reconhece o tamanho inválido
    @Test
    void testIsNotTamanhoValidoCpf(){
        usuarioTeste.setCpf("1"); // Tamanho invalido
        boolean expected = false;
        boolean actual = usuarioTeste.isTamanhoValidoCpf();
        assertEquals(expected, actual);
    }
    // Testa se o sistema reconhece quando a palavra é proibida
    @Test
    void testContemPalavraProibida(){
        usuarioTeste.setLogin("root"); // palavra proibida
        boolean expected = true;
        boolean actual = usuarioTeste.contemPalavraProibida();
        assertEquals(expected, actual);
    }
    // Testa se o sistema reconhece quando a palavra é permitida
    @Test
    void testNotContemPalavraProibida(){
        usuarioTeste.setLogin("Mario"); // Palavra que deve ser aceita
        boolean expected = false;
        boolean actual = usuarioTeste.contemPalavraProibida();
        assertEquals(expected, actual);
    }
    // Testa se o sistema reconhece se as senhas são iguais
    @Test
    void testIsSenhasIguais(){
        usuarioTeste.setSenha("12345"); // senha igual a do construtor
        boolean expected = true;
        boolean actual = usuarioTeste.isSenhasIguais();
        assertEquals(expected, actual);
    }
    // Teste se o sistema reconhecem quando elas nao sao iguais
    @Test
    void testIsNotSenhasIguais(){
        usuarioTeste.setSenha("macai23"); // senha diferente a do construtor
        boolean expected = false;
        boolean actual = usuarioTeste.isSenhasIguais();
        assertEquals(expected, actual);
    }
    // Testa se o sistema reconhece quando existe um campo vazio
    @Test
    void testIsCamposVazios(){
        // adiciono um campo vazio
        usuarioTeste.setCpf("");
        boolean expected = true;
        boolean actual = usuarioTeste.isCamposVazios();
        assertEquals(expected, actual);
    }
    // Testa se o sistema reconhece quando todos os campos estão preenchidos
    @Test
    void testIsNotCamposVazios(){
        boolean expected = false;
        boolean actual = usuarioTeste.isCamposVazios();
        assertEquals(expected, actual);
    }
}
