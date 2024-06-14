package main.java.com.domain;
import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return this.nome;
    }

    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }

    public Pessoa(){};
}