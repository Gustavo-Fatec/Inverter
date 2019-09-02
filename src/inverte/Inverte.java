package inverte;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class Inverte {

    private int vetor[];
    private int tamanho;

    public Inverte(int capMax) {
        vetor = new int[capMax];
        tamanho = 0;
    }

    public void adicionaFinal(int e) {
        if (vetor.length == tamanho) {
            JOptionPane.showMessageDialog(null,"ERRO! Lista Cheia");
            System.exit(0);
        } else {
            vetor[tamanho] = e;
            tamanho++;
        }
    }

    public int removeInicio() {
        int resp = -1;
        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null,"ERRO! Lista Cheia");
            System.exit(0);
        } else {
            resp = vetor[0];
            for (int i = 0; i < tamanho; i++) {
                vetor[i] = vetor[i + 1];
            }
            tamanho--;
        }
        return resp;
    }

    public int capacidade() {
        return vetor.length;
    }

    //método incompleto.
    public String toString() {
        int j;
        int aux = 0;
        String s = "";
//        for (int i = 0; i < tamanho; i++) {
//            s += vetor[i];
//        } 
        for (j = 0; j < vetor.length / 2; j++) {

            aux = vetor[j];
            vetor[j] = vetor[(vetor.length - 1) - j];
            vetor[(vetor.length - 1) - j] = aux;

        }
        for (j = 0; j < vetor.length; j++) {
             s += " " +vetor[j];
        }
        return  s;

    }

    public static void main(String[] args) {
        Inverte inverte = new Inverte(4);
        int e;
        String opcoes[] = {"Adicionar elemento", "Remover elemento", "Inverter", "Sair"};
        for (int i = 0; i < inverte.capacidade(); i++) {
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu", 0,
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            if (escolha == 0) {
                e = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número: "));
                inverte.adicionaFinal(e);
                i--;
            }
            if (escolha == 1) {
                JOptionPane.showMessageDialog(null, "Item " + inverte.removeInicio() + " removido !");
                i--;
            }
            if (escolha == 2) {
                JOptionPane.showMessageDialog(null, inverte.toString());
                i--;
            }
            if (escolha == 3) {
                int reply = JOptionPane.showConfirmDialog(null, "Deseja realmente sair ?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        }
    }
}

