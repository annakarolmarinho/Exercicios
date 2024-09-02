package org.example.sistemaHospitalar;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private Integer idHospital;
    private String nome;
    private String endereco;
    private Tipo tipo;
    private Integer capacidadeHospital;
    private Integer quantidadePacientes;
    private List<Paciente> pacientes;

    public Hospital(Integer idHospital, String nome, String endereco, Tipo tipo) {
        this.idHospital = idHospital;
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.pacientes = new ArrayList<>();
        this.capacidadeHospital = 0;
        this.quantidadePacientes = 0;
    }

    public void incrementarPacientes(){
        this.quantidadePacientes++;
    }

    public Integer getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(Integer idHospital) {
        this.idHospital = idHospital;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidadeHospital() {
        return capacidadeHospital;
    }

    public void setCapacidadeHospital(Integer capacidadeHospital) {
        this.capacidadeHospital = capacidadeHospital;
    }

    public Integer getQuantidadePacientes() {
        return quantidadePacientes;
    }

    public void setQuantidadePacientes(Integer quantidadePacientes) {
        this.quantidadePacientes = quantidadePacientes;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
