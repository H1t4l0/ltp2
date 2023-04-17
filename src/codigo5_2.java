import java.util.Scanner;

public class codigo5_2 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String numero;
        boolean valido;
        String codigo = "";
        int verificador = 0;

        do {
            do{
                System.out.printf("Insira os numeros: ");
                numero = leia.next(); //"821 324 312 69"
            }while (numero.length() < 11 || numero.length() > 11);
            try{
                codigo = numero.substring(0,9);
                verificador = Integer.parseInt(numero.substring(9));;
                valido = true;
            }catch (NumberFormatException e){
                System.out.printf("O codigo digitado não pode ser convertido ! Digite Novamente\n");
                valido = false;
            }
        }while(! valido);

        calcularCodigo(codigo);

        System.out.printf("Finalizado!!!\n");

    }//main
    public static void calcularCodigo(String cod1 ){
        int soma = 0;
        int multi = 1;
        int ver1 , ver2;

        for(byte i = 0; i < cod1.length(); i++){
            soma += Character.digit(cod1.charAt(i), 10);
            multi *= Character.digit(cod1.charAt(i),10);
        }
        ver1 = soma;
        ver2 = multi;

        if(ver1 == ver2){
            System.out.printf("Digito Correto\n");
        }
        else{
            System.out.printf("Digito invalido\n");
        }


    }

}
