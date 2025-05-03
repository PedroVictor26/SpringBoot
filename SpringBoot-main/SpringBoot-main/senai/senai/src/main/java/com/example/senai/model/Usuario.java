package com.example.senai.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Obrigatorio")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "Obrigatorio")
    @Email(message = "Email tem que ser valido")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Obrigatorio")
    @Size(min = 3, message = "Minimo 3 caracteres")
    @Column(nullable = false)
    private String senha;

    public Usuario() {
    }

    public Usuario(long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
