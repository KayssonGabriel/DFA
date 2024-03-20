import javax.swing.*;

public class Main {
    static int[] aceitacao = {2};
    static int estadoInicial = 0;
    static int[][][] transicoes = {
            {{0, 1}, {0}},
            {{}, {2}},
            {{}, {}}
    };

    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog("Digite a entrada");

        //Processamento
        int[] estados = {estadoInicial};
        int[] estadosFinais = testar(entrada, estados, 0);

        //verificar se a cadeia é valida
        if (aceita(estadosFinais)) {
            System.out.println("Cadeia valida");
        } else {
            System.out.println("Cadeia invalida");
        }

    }

    //função backtraking recursiva
    private static int[] testar(String entrada, int[] estados, int posicao) {
        if (entrada == null) return null;
        if (posicao == entrada.length()) {
            imprime(entrada, estados[0], posicao);
            if (aceita(estados)) {
                return estados;
            }
            System.out.println("<<backtrack>> Fim da cadeia");
            return null;
        }
        char simbolo = entrada.charAt(posicao);
        if (simbolo != '0' && simbolo != '1') return null;
        int elemento = simbolo - '0';
        for (int i : estados) {
            imprime(entrada, i, posicao);
            int[] novosEstados = transicoes[i][elemento];
            if (novosEstados.length == 0) {
                System.out.println("<<backtrack>> Sem opcoes");
                continue;
            }
            int[] transicoes = testar(entrada, novosEstados, posicao + 1);
            if (transicoes != null) return transicoes;
        }
        return null;
    }

    private static boolean aceita(int[] estados) {
        if (estados == null) return false;
        for (int i : estados) {
            for (int j : aceitacao) {
                if (i == j) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void imprime(String entrada, int estado, int posicao) {
        System.out.print(entrada.substring(0, posicao));
        System.out.print("[q" + estado + "]");
        System.out.println(entrada.substring(posicao));
    }
}