import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int num;
        int resto;
        int denominador = 1;

        System.out.printf("Numero: ");
        num = leia.nextInt();

        System.out.printf("numero divido por 10: %d\n", num / 10);// numeros a esquerda
        System.out.printf("resto do numero: %d\n", num % 10);// numeros a direira

    }
}
