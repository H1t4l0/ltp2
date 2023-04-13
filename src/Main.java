import java.util.Scanner;

public class Main {
    static String vetCidade[] = new String[] {"belohorizonte", "saopaulo", "riodejaneiro", "salvador", "curitiba"};
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String nome[] = new String[100];
        int entrada;
        int saida;
        String tipoQuarto;
        String cidade;
        byte i;
        float conta[] = new float[100];
        float somaConta = 0;
        int cont = 0;
        float media = 0;

        for (i = 0; i < 100; i++) {
            System.out.printf("\nfim - para sair\n");
            // nome
            System.out.printf("Insira o nome: ");
            nome[i] = leia.nextLine();
            if (nome[i].equalsIgnoreCase("fim")) {
                break;
            }
            // entrada não pode ser maior que saida
            do {
                // entrada
                do {
                    System.out.printf("Insira o dia da entrada: ");
                    entrada = leia.nextInt();
                } while (entrada < 0 || entrada > 31);
                // saida
                do {
                    System.out.printf("Insira o dia da saida: ");
                    saida = leia.nextInt();
                } while (saida < 0 || saida > 31);
            } while (entrada > saida);
            leia.nextLine();
            // tipo de quarto
            System.out.printf("\nTipos de quartos\nSTANDARD - 120 por dia\nLUXO - 150 por dia\nSUPER-LUXO - 180 por dia\n\n");
            do {
                System.out.printf("Insira o tipo de quarto: ");
                tipoQuarto = leia.nextLine();
            } while (!tipoQuarto.equalsIgnoreCase("standard") && !tipoQuarto.equalsIgnoreCase("luxo") && !tipoQuarto.equalsIgnoreCase("superluxo"));
            // cidade
            System.out.printf("Insira a cidade: ");
            cidade = leia.nextLine();
            // calcular
            boolean validar = cidadeEhValida(cidade);
            if (validar) {
                System.out.printf("\nCidade válida\n");
                conta[i] = calcularConta(entrada, saida, tipoQuarto);
                somaConta += conta[i];
                cont++;
            } else {
                System.out.printf("Cidade inválida\n");
            }
        }
        System.out.printf("\nNome\t\t\tvalorConta\n");
        System.out.printf("---------------\t\t-------\n");
        media = somaConta / cont;
        System.out.printf("media = %.2f", media);
        for(i = 0; i < cont; i++){
            if(conta[i] > media){

                System.out.printf("%s\t\t%.2f\n", nome[i], conta[i]);

            }
        }
    }

    public static boolean cidadeEhValida(String pesquisaCidade) {
        boolean encontrou = false;
        for (byte i = 0; i < 5; i++) {
            if (pesquisaCidade.equalsIgnoreCase(vetCidade[i])) {
                return encontrou = true;
            }
        }
        return encontrou;
    }

    public static float calcularConta(int entrada, int saida, String tipoQuarto) {
        float valorConta = 0;
        if (tipoQuarto.equalsIgnoreCase("standard")) {
            valorConta = (saida - entrada) * (float) 120;
        } else if (tipoQuarto.equalsIgnoreCase("luxo")) {
            valorConta = (saida - entrada) * (float) 150;
        } else if (tipoQuarto.equalsIgnoreCase("superluxo")) {
            valorConta = (saida - entrada) * (float) 180;
        }

        return valorConta;
    }

}