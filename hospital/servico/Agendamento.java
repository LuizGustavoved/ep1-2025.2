package hospital.servico;

import hospital.entidade.Consulta;
import hospital.entidade.Pacientes;
import hospital.entidade.Medicos;
import hospital.servico.CalculadoraPlano;
import java.time.LocalDateTime;

public class Agendamento {
    public static Consulta agendarConsulta(Medicos medicos, Pacientes pacientes, String descricao, LocalDateTime horario){
        if (!medicos.simDisponivel(horario)){
            throw new IllegalArgumentException("Médico " + medicos.getNome() + "indisponível neste horário: " + horario);
        }
        double custo = medicos.getCustoConsulta();
        double valorFinal = CalculadoraPlano.calcularValorFinal(pacientes, custo);
        Consulta consulta = new Consulta(medicos, pacientes, descricao, horario, valorFinal);
        pacientes.adicionarConsulta(consulta);
        medicos.adicionarConsulta(consulta);
        return consulta;
    }
}
