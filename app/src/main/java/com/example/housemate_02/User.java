package com.example.housemate_02;

public class User {
    private String Nome;
    private String Cognome;
    private String Email;
    private String Password;

    public User() {
        Nome = "Nome";
        Cognome = "Cognome";
        Email = "email";
        Password = "password";
    }

    public User(String nome, String cognome, String email, String password) {
        Nome = nome;
        Cognome = cognome;
        Email = email;
        Password = password;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
