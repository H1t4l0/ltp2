import java.util.Scanner;

public class idade5_1 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String hoje;
        String nasc;
        int result;

        System.out.printf("Insira a data de hoje: ");
        hoje = leia.nextLine(); // 14/04/2023

        System.out.printf("Insira a data de nascimento: ");
        nasc = leia.nextLine(); // 16/02/2001

        System.out.printf("idade: %d", calcularIdade(hoje, nasc));

    }
    public static int calcularIdade(String hoje, String nasc){
        int diaNasc = Integer.parseInt(nasc.substring(0,2));
        int mesNasc = Integer.parseInt(nasc.substring(3,5));
        int anoNasc = Integer.parseInt(nasc.substring(6));

        int diaHj = Integer.parseInt(hoje.substring(0,2));
        int mesHj = Integer.parseInt(hoje.substring(3,5));
        int anoHj = Integer.parseInt(hoje.substring(6));

        int idade = anoHj - anoNasc;

        if(mesNasc > mesHj || mesHj == mesNasc && diaNasc > diaHj){
            idade -= 1;
        }
        return idade;

    }

}
