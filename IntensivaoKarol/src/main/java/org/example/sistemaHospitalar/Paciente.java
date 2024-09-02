package org.example.sistemaHospitalar;

public class Paciente {
    private Integer idPaciente;
    private String nome;
    private Integer idade;
    private Sexo sexo;

    public Paciente(Integer idPaciente, String nome, Integer idade, Sexo sexo) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
