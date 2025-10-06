package hospital.servico;
import hospital.entidade.Pacientes;

public class CalculadoraPlano {
    private static double descontoJovem = 0.22;
    private static final double descontoAdulto = 0.18;
    private static final int idadeLimite = 40;

    public static double calcularValorFinal(Pacientes paciente, double valorBase) {
        if (!paciente.possuiPlano()) {
            return valorBase;
        }
        double taxaDesconto;
        if (paciente.getIdade() < idadeLimite) {
            taxaDesconto = descontoJovem;

        } else {
            taxaDesconto = descontoAdulto;
        }
        double valorDesconto = valorBase * taxaDesconto;
        return valorBase - valorDesconto;
    }
}


