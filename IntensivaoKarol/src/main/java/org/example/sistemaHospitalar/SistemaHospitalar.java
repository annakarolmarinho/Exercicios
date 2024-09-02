package org.example.sistemaHospitalar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SistemaHospitalar {
    private Integer IdSistemaHospitalar;
    private List<Hospital> hospitais;

    public SistemaHospitalar(Integer idSistemaHospitalar, List<Hospital> hospital) {
        IdSistemaHospitalar = idSistemaHospitalar;
        this.hospitais = hospital;
    }

    public void adicionarHospital(Hospital hospital){
        this.hospitais.add(hospital);
    }

    public void transferirPaciente(Integer idHospitalOrigem, Integer idHospitalDestino, Integer idPaciente){
        if (idHospitalDestino.equals(idHospitalOrigem)) {
            return;
        }
        Paciente paciente = null;
        Hospital origem = null;
        Hospital destino = null;

        for (int i = 0; i <= this.hospitais.size() - 1; i++) {
            if (this.hospitais.get(i).getIdHospital().equals(idHospitalOrigem)) {
                origem = this.hospitais.get(i);
            }
            if (this.hospitais.get(i).getIdHospital().equals(idHospitalDestino)) {
                destino = this.hospitais.get(i);
            }
        }

        if (origem == null || destino == null) {
            return;
        }

        for (Paciente pacienteInPacientes : origem.getPacientes()) {
            if (pacienteInPacientes.getIdPaciente().equals(idPaciente)) paciente = pacienteInPacientes;
        }

        List<Paciente> pacientesOrigem = new ArrayList<>(origem.getPacientes());
        pacientesOrigem.remove(paciente);
        origem.setPacientes(pacientesOrigem);

        List<Paciente> pacientesDestino = new ArrayList<>(destino.getPacientes());
        pacientesDestino.add(paciente);
        destino.setPacientes(pacientesDestino);
    }

    public Paciente obterPacientePeloId(Integer idPaciente){
        for (Hospital hospitais1 : hospitais) {
            for (Paciente paciente : hospitais1.getPacientes()) {
                if (idPaciente.equals(paciente.getIdPaciente())){
                    return paciente;
                }
            }
        }
        return null;
    }

    public Paciente obterPacientePeloNome(String nomePaciente){
        Optional<Paciente> pacienteOptional = this.hospitais
                .stream()
                .flatMap(hospital -> hospital.getPacientes().stream())
                .filter(paciente -> paciente.getNome().equals(nomePaciente))
                .findFirst();
//        for (Hospital hospital : hospitais) {
//            for (Paciente paciente : hospital.getPacientes()) {
//                if(nomePaciente == paciente.getNome()){
//                    return paciente;
//                }
//            }
//        }
//        return null ;
        return pacienteOptional.orElse(null);
    }

    public List<Hospital> listarHospitaisPeloTipo(Tipo tipoHospital){
        return this.hospitais.stream()
                .filter(hospital -> hospital.getTipo().equals(tipoHospital))
                .toList();
//        List<Hospital> listarHospitalPeloTipo = new ArrayList<>();
//        for (Hospital hospitai : hospitais) {
//            if(tipoHospital == hospitai.getTipo()){
//                listarHospitalPeloTipo.add(hospitai);
//            }
//        }
//        return listarHospitalPeloTipo;
    }

    public void removerHospital(Integer idHospital){
        this.hospitais = this.hospitais.stream()
                .filter(hospital -> !hospital.getIdHospital().equals(idHospital))
                .toList();
//        for (int i = 0; i <= this.hospitais.size() - 1; i++) {
//            if (this.hospitais.get(i).getIdHospital().equals(idHospital)) {
//                this.hospitais.remove(i);
//            }
//        }
    }

    public Hospital buscarHospital(Integer idHospital){
        return this.hospitais
                .stream()
                .filter(hospital -> hospital.getIdHospital().equals(idHospital))
                .findFirst()
                .orElse(null);
//        for (Hospital hospital : hospitais) {
//            if (idHospital == hospital.getIdHospital()){
//                return hospital;
//            }
//        }
//        return null;
    }

    public List<Paciente> listarPacientesDoHospital(Integer idHospital){
        return this.hospitais
                .stream()
                .filter(hospital -> hospital.getIdHospital().equals(idHospital))
                .findFirst()
                .get()
                .getPacientes();
//        for (Hospital hospital : hospitais) {
//            if (idHospital == hospital.getIdHospital()){
//               return hospital.getPacientes();
//            }
//        }
//        return null;
    }


    public Integer getIdSistemaHospitalar() {
        return IdSistemaHospitalar;
    }

    public void setIdSistemaHospitalar(Integer idSistemaHospitalar) {
        IdSistemaHospitalar = idSistemaHospitalar;
    }

    public List<Hospital> getHospitais() {
        return hospitais;
    }

    public void setHospitais(List<Hospital> hospitais) {
        this.hospitais = hospitais;
    }
}
