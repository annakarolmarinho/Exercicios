package org.example.sistemaHospitalar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SistemaHospitalarTest {

    private final List<Hospital> hospitals;
    private final SistemaHospitalar sistemaHospitalar;

    public SistemaHospitalarTest() {
        this.hospitals = new ArrayList<>();
        this.sistemaHospitalar = new SistemaHospitalar(1, this.hospitals);
    }

    private List<Paciente> buildPacientesHospital1() {
        return Arrays.asList(
            new Paciente(1, "José", 22, Sexo.MASCULINO),
            new Paciente(2, "Anna", 20, Sexo.FEMININO),
            new Paciente(3, "Ana", 47, Sexo.FEMININO),
            new Paciente(4, "Kalil", 22, Sexo.MASCULINO)
        );
    }

    private List<Paciente> buildPacientesHospital2() {
        return Arrays.asList(
                new Paciente(5, "Anna", 22, Sexo.FEMININO),
                new Paciente(6, "William", 22, Sexo.MASCULINO),
                new Paciente(7, "João", 25, Sexo.MASCULINO),
                new Paciente(8, "Petena", 25, Sexo.MASCULINO)
        );
    }

    @BeforeEach()
    public void beforeAll() {
        hospitals.add(new Hospital(1, "São Luis", "São Paulo", Tipo.GERAL));
        hospitals.add(new Hospital(2, "São Maranhão", "Maranhão", Tipo.ESPECIALIZADO));
        this.hospitals.get(0).setPacientes(buildPacientesHospital1());
        this.hospitals.get(1).setPacientes(buildPacientesHospital2());
        this.sistemaHospitalar.setHospitais(hospitals);
    }

    @Test
    void verificarQuantidadeHospitais() {
        assertEquals(this.sistemaHospitalar.getHospitais().size(), 2);
    }

    @org.junit.jupiter.api.Test
    void obterPacientePeloId() {
        Paciente paciente = this.sistemaHospitalar.obterPacientePeloId(2);

        Assertions.assertEquals(paciente.getIdPaciente(), 2);
        Assertions.assertEquals(paciente.getIdade(), 20);
        Assertions.assertEquals(paciente.getSexo(), Sexo.FEMININO);
        Assertions.assertEquals(paciente.getNome(), "Anna");
    }

    @org.junit.jupiter.api.Test
    void obterPacientePeloNome() {
        Paciente paciente = this.sistemaHospitalar.obterPacientePeloNome("José");

        Assertions.assertEquals(paciente.getIdPaciente(), 1);
        Assertions.assertEquals(paciente.getIdade(), 22);
        Assertions.assertEquals(paciente.getSexo(), Sexo.MASCULINO);
    }

    @org.junit.jupiter.api.Test
    void listarHospitaisPeloTipo() {
        List<Hospital> hospitalList = this.sistemaHospitalar.listarHospitaisPeloTipo(Tipo.GERAL);

        assertEquals(hospitalList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void removerHospital() {
        this.sistemaHospitalar.removerHospital(1);

        assertEquals(this.sistemaHospitalar.getHospitais().size(), 1);
    }

    @org.junit.jupiter.api.Test
    void buscarHospital() {
        Hospital hospital = this.sistemaHospitalar.buscarHospital(1);

        assertEquals(hospital.getIdHospital(), 1);
        assertEquals(hospital.getNome(), "São Luis");
        assertEquals(hospital.getTipo(), Tipo.GERAL);
        assertEquals(hospital.getEndereco(), "São Paulo");
    }

    @org.junit.jupiter.api.Test
    void listarPacientesDoHospital() {
        List<Paciente> pacientes = this.sistemaHospitalar.listarPacientesDoHospital(1);

        assertEquals(pacientes.size(), 4);
    }


    @org.junit.jupiter.api.Test
    void transferirPaciente1Para2() {

        Paciente paciente = this.sistemaHospitalar.getHospitais().getFirst().getPacientes().getFirst();

        this.sistemaHospitalar.transferirPaciente(1, 2, paciente.getIdPaciente());

        Hospital hospitalDestino = this.sistemaHospitalar.getHospitais().get(1);

        assertEquals(this.sistemaHospitalar.getHospitais().get(0).getPacientes().size(), 3);
        assertEquals(hospitalDestino.getPacientes().size(), 5);

        assertTrue(hospitalDestino.getPacientes().stream().anyMatch(pac -> pac.getNome().equals(pac.getNome())));
    }

    @org.junit.jupiter.api.Test
    void transferirPaciente2Para1() {

        Paciente paciente = this.sistemaHospitalar.getHospitais().getLast().getPacientes().getLast();

        this.sistemaHospitalar.transferirPaciente(2, 1, paciente.getIdPaciente());

        Hospital hospitalDestino = this.sistemaHospitalar.getHospitais().get(1);

        assertEquals(this.sistemaHospitalar.getHospitais().get(0).getPacientes().size(), 5);
        assertEquals(hospitalDestino.getPacientes().size(), 3);

        assertTrue(hospitalDestino.getPacientes().stream().anyMatch(pac -> pac.getNome().equals(pac.getNome())));
    }
}