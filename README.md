# Simulação de autômato finito

Exercício de Linguagens Formais e Autômatos em Java. Embora o repositório se chame DFA, a tabela em [src/Main.java](src/Main.java) permite que, do estado inicial, o símbolo `0` leve a mais de um estado. O programa explora essas alternativas recursivamente e verifica se existe um caminho da entrada até o estado de aceitação `q2`.

## Como executar

Use um JDK e um ambiente gráfico com suporte a Swing:

```bash
javac -encoding UTF-8 -d build src/Main.java
java -cp build Main
```

Digite uma cadeia com `0` e `1` na caixa de diálogo. O terminal mostra os estados visitados e informa se a cadeia é válida. Por exemplo, `01` é aceita e `10` é rejeitada. A atividade original está no [PDF da disciplina](LFA%20-%20DFA%2020_03_2024.pdf).
