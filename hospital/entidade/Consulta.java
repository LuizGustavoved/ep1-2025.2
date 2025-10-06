package hospital.entidade;

import java.time.LocalDateTime;

public class Consulta {
    public enum StatusConsulta{AGENDADA, CONCLUIDA, CANCELADA}

    private Medicos medico;
    private Pacientes paciente;
    private String descricao;
    private LocalDateTime dataHorario;
    private StatusConsulta status;
    private double valorFinal;

    public Consulta(Medicos medico, Pacientes paciente, String descricao, LocalDateTime dataHorario, double valorFinal){
        this.paciente = paciente;
        this.medico = medico;
        this.descricao = descricao;
        this.dataHorario = dataHorario;
        this.status = StatusConsulta.AGENDADA;
        this.valorFinal = valorFinal;

    }
    public String toCSV(){
        return paciente.getCpf() + "," + medico.getCrm() + "," + descricao + "," + dataHorario + "," + status.name();
    }
    public Pacientes getPacientes() {
        return paciente;
    }
    public Medicos getMedicos() {
        return medico;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDateTime getDataHorario() {
        return dataHorario;
    }
    public void concluirConsulta(){
        this.status = StatusConsulta.CONCLUIDA;
    }
    public void cancelarConsulta(){
        this.status = StatusConsulta.CANCELADA;
    }
    public StatusConsulta getStatus() {
        return status;
    }
    public double getValorFinal() {
        return valorFinal;}
    public String toString(){
        return "Consulta com: " + medico.getNome() + " | Paciente: " + paciente.getNome() + " em " + dataHorario + " para " + descricao + " está " + status;
    }
}
