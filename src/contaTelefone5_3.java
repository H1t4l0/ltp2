import java.util.Scanner;

public class contaTelefone5_3 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String horaInicial;
        String horaFinal;
        int hora1 = 0, hora2 = 0;
        int min1 = 0,min2 = 0;
        boolean convercao;
        boolean horarioValido;
        float valorTotal = 0;

        do{
            System.out.printf("hora inicial: ");
            horaInicial = leia.next();

            System.out.printf("hora final: ");
            horaFinal = leia.next();

            try {
                hora1 = Integer.parseInt(horaInicial.substring(0,2));
                hora2 = Integer.parseInt(horaFinal.substring(0,2));
                min1 = Integer.parseInt(horaInicial.substring(3));
                min2 =Integer.parseInt(horaFinal.substring(3));
                convercao = true;
            } catch (NumberFormatException e){
                System.out.printf("Não conformes os parâmetros\n");
                convercao = false;
            }

            horarioValido = horaEhValida(hora1, hora2, min1, min2);


        }while(hora1 >= hora2 || !convercao || !horarioValido );

        System.out.println("hora1: " + hora1);
        System.out.println("hora2: " + hora2);
        System.out.println("min1: " + min1);
        System.out.println("min2: " + min2);

        valorTotal = calcularTelefone(hora1,hora2,min1, min2);

        System.out.printf("Valor da conta %.2f", valorTotal);

    }
    public static boolean horaEhValida(int h1, int h2, int m1, int m2){
        boolean horario = false;
        if((h1 >= 0 || h2 >= 0) && (h1 <= 23 || h2 <= 23)){
           if((m1 >= 0 || m2 >= 0) && (m1 <= 59 || m2 <= 59 )){
               return horario = true;
           }
        }

        return horario;

    }
    public static float calcularTelefone(int h1, int h2, int m1, int m2){
        float valorConta = 0;
        if(h1 >= 0 && h2 < 6){
            valorConta = (((h2 - h1) * 60) + (m2-m1)) * (float)0.15;
        }

        return valorConta;
    }

}
