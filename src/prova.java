import java.util.Scanner;
public class prova {
    static int numAp[] = new int[100];
    static String descricao[] = new String[100];
    static float preco[] = new float[100];
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        byte cont;
        char flag;
        int pesquisaAp;

        for(cont = 0; cont < 100; cont++){
            do{
                System.out.printf("Insira o numero do ap: ");
                numAp[cont] = leia.nextInt();
            }while(numAp[cont] < 101 || numAp[cont] > 150);

            System.out.printf("Descrição: ");
            descricao[cont] = leia.next();

            do{
                System.out.printf("Insira o valor: ");
                preco[cont] = leia.nextFloat();
            }while(preco[cont] < 0);

            System.out.printf("Desejar continuar (s/n): ");
            flag = leia.next().charAt(0);

            if(flag != 'n'){
                break;
            }

        }
        do{
            System.out.printf("Pesquisa o numero do ap: ");
            pesquisaAp = leia.nextInt();

            calcularConta(pesquisaAp, cont);

        }while(pesquisaAp != 0);

    }
    public static void calcularConta(int pesquisaAp, int contHops){
        float soma = 0;
        System.out.printf("numero do ap: %d\n", pesquisaAp);
        for(byte i = 0; i <= contHops; i++){
            if(pesquisaAp == numAp[i]){
                soma+=preco[i];
                if(descricao[i].equalsIgnoreCase("null") || descricao[i].equals("")){
                    System.out.printf("Nada\n");
                }
                System.out.printf("%s\t\t%.2f\n", descricao[i], preco[i]);
            }

        }
        System.out.printf("Soma = %.2f\n", soma);
    }
}
