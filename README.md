# Teste Prático

Este projeto em Java foi desenvolvido com o objetico de gerenciar uma lista de funcionários. Ele inclui funcionalidades para inserção, remoção, atualização e impressão de informações de funcionários, além de agrupar e manipular dados de acordo com os critérios passados.

## Estrutura do Projeto

O projeto contém as seguintes classes principais:

- `Pessoa`: Classe base que contém atributos comuns como nome e data de nascimento.
- `Funcionario`: Subclasse de `Pessoa`, adiciona atributos específicos de funcionários, como salário e função.
- `Principal`: Classe que contém o método `main` para executar as operações solicitadas.

## Funcionalidades

1. **Inserção de Funcionários**: Cria e adiciona funcionários à lista.
2. **Remoção de Funcionários**: Remove um funcionário específico da lista.
3. **Impressão de Funcionários**: Exibe informações detalhadas dos funcionários formatadas corretamente.
4. **Atualização de Salários**: Aplica um aumento de 10% nos salários dos funcionários.
5. **Agrupamento por Função**: Organiza os funcionários em um mapa baseado em suas funções.
6. **Impressão por Grupo de Função**: Mostra os funcionários agrupados por função.
7. **Aniversariantes de Outubro e Dezembro**: Lista os funcionários que fazem aniversário nesses meses.
8. **Funcionário com Maior Idade**: Identifica e imprime o funcionário mais velho.
9. **Ordem Alfabética**: Lista todos os funcionários em ordem alfabética.
10. **Total de Salários**: Calcula a soma dos salários de todos os funcionários.
11. **Comparação com Salário Mínimo**: Mostra quantos salários mínimos cada funcionário ganha.

## Como Executar

Para executar este projeto, você precisará ter o Java instalado em sua máquina. Clone o projeto para seu ambiente local e utilize uma IDE de sua escolha (VsCode, Eclipse, IntelliJ, NetBeans, etc.) para abri-lo.

1. Abra o terminal ou prompt de comando.
2. Navegue até a pasta do projeto.
3. Compile o código com o comando `javac -d ./bin ./src/main/java/com/domain/*.java ./src/main/java/com/utils/*.java ./src/main/java/com/Principal.java`.
4. Execute o programa com o comando `java -XX:+ShowCodeDetailsInExceptionMessages -cp ./bin main.java.com.Principal`.
