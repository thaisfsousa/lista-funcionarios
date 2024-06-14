package main.java.com.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.com.domain.Funcionario;


public class Utils {
    static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void imprime(String str){
        System.out.println(str);
    }

    public static String formataData(LocalDate data){
        return data.format(formatoData);
    }

    public static String formataValor(BigDecimal salario){
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMANY);
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        String formattedNumber = format.format(salario);
        return (formattedNumber);
    }

    public static List<Funcionario> criaListaFuncionarios(String file) throws ParseException{
        List<Funcionario> funcionarios = new ArrayList<>();
        String arquivo = file;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                funcionarios.add(new Funcionario(dados[0], LocalDate.parse(dados[1], formatoData), new BigDecimal(dados[2]), dados[3]));
            }
        } catch (IOException e) {}
        imprime("\nLista de funcionários criada.\n");
        return funcionarios;
    }

    public static void removeFuncionario(List<Funcionario> funcionarios, String str){
        funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(str));
        imprime("\nFuncionário "+ str + " removido.\n");
    }

    public static void imprimeFuncionarios(List<Funcionario> funcionarios){
        imprime("\nQuadro de Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            imprime("Nome: " + funcionario.getNome() + "\t| Data de Nascimento: " + formataData(funcionario.getDataNascimento()) + "\t| Salário: " 
            + formataValor(funcionario.getSalario()) + "\t| Função: " + funcionario.getFuncao()+ "\n");
        }
    }

    public static void aumentaSalario(List<Funcionario> funcionarios, int percentual){
        Double value = (percentual / 100.0) + 1;
        BigDecimal aumento = (new BigDecimal(value)).setScale(2, RoundingMode.HALF_UP);
        for (Funcionario funcionario : funcionarios) {
            BigDecimal novoSalario = funcionario.getSalario().multiply(aumento);
            funcionario.setSalario(novoSalario);
        }
        imprime("\nSalários aumentados em " + percentual + "%.\n");
    }

    public static Map<String, List<Funcionario>> agrupaFuncionarios(List<Funcionario> funcionarios){
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        imprime("\nFuncionários agrupados por função.\n");
        return funcionariosPorFuncao;
    }

    public static void imprimeFuncionariosMapeados(Map<String, List<Funcionario>> funcionariosMapeados){
        imprime("\nFuncionários Agrupados:");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosMapeados.entrySet()) {
            imprime("\nFunção: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                imprime("Nome: " + funcionario.getNome() + "\t| Data de Nascimento: " + formataData(funcionario.getDataNascimento()) + "\t| Salário: " 
                + formataValor(funcionario.getSalario()));
            }
        }
    }

    public static void funcionariosAniversario(List<Funcionario> funcionarios, int meses[]){
        for (int mes : meses) {
            imprime("\nAniversariantes no mês: "+ mes + "\n");
            for (Funcionario funcionario : funcionarios) {
                int mesNasc = funcionario.getDataNascimento().getMonthValue();
                if (mesNasc == mes) {
                    imprime("Nome: " + funcionario.getNome() + "\t| Data de Nascimento: " + formataData(funcionario.getDataNascimento()) + ".\n");
                }
            }
        }
    }

    public static void funcionarioMaiorIdade(List<Funcionario> funcionarios){
        Funcionario maisVelho = funcionarios.get(0);
        for (Funcionario funcionario : funcionarios){
            if (maisVelho.getDataNascimento().getYear() > funcionario.getDataNascimento().getYear()){
                maisVelho = funcionario;
            }
        }
        imprime("Funcionário com maior idade: \nNome: " + maisVelho.getNome() + "\t| Idade: " + (LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear()) + ".\n");
    }

    public static void imprimeOrdemAlfabetica(List<Funcionario> funcionarios){
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        imprime("Listando funcionários em ordem alfabética:\n");
        imprimeFuncionarios(funcionarios);
    }

    public static void imprimeSalario(List<Funcionario> funcionarios){
        BigDecimal total = funcionarios.stream()
            .map(Funcionario::getSalario)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        imprime("Valor Total dos Salários dos Funcionários: \n" + formataValor(total) + ".\n");
    }

    public static void salariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo){
        imprime("Quantidade de salários minimos recebida por funcionário:\n");
        for (Funcionario funcionario : funcionarios){
            BigDecimal salarios = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            imprime("Nome: " + funcionario.getNome() + "\t| Quantidade de salários mínimos: " + salarios + ".\n");
        }
    }
}
