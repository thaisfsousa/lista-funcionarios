package main.java.com;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import main.java.com.domain.Funcionario;

import static main.java.com.utils.Utils.*;

public class Principal {

    public static void main(String[] args) throws Exception {
        int[] meses = {10, 12};
        List<Funcionario> funcionarios = criaListaFuncionarios("resources/Funcionarios.txt");
        removeFuncionario(funcionarios, "João");
        imprimeFuncionarios(funcionarios);
        aumentaSalario(funcionarios, 10);
        Map<String, List<Funcionario>> funcionariosAgrupados = agrupaFuncionarios(funcionarios);
        imprimeFuncionariosMapeados(funcionariosAgrupados);
        funcionariosAniversario(funcionarios, meses);
        funcionarioMaiorIdade(funcionarios);
        imprimeOrdemAlfabetica(funcionarios);
        imprimeSalario(funcionarios);
        salariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }
}
