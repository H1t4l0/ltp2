import java.util.Scanner;

public class codigo5_2 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String numero;
        boolean valido;
        String codigo = "";
        int verificador = 0;
        byte cont;

        do {
            do{
                System.out.printf("Insira os numeros: ");
                numero = leia.next(); //"821 324 312 24
                                    //82132431224
            }while (numero.length() != 11);

            if(numero.equalsIgnoreCase("fim")){
                break;
            }

            if(numero.length() != 11){
                System.out.printf("Quantidade invalida\n");
            }
            else{
                try{
                    for(cont = 0; cont < 11; cont++){
                        Character.digit(numero.charAt(cont), 10);
                    }
                }catch(Exception e){
                    System.out.printf("Todos não foram válidos\n");
                }
            }

        }while(numero.equalsIgnoreCase("fim"));

        calcularCodigo(numero);

        System.out.printf("Finalizado!!!\n");

    }//main
    public static void calcularCodigo(String cod1 ){
        int soma = 0;
        int multi = 1;
        int ver1 , ver2;

        for(byte i = 0; i < 9; i++){
            soma += Character.digit(cod1.charAt(i), 10);
            multi *= Character.digit(cod1.charAt(i),10);
        }
        ver1 = soma / 10;
        ver2 = multi - ((multi / 10) * 10);

        if(ver1 == Character.digit(cod1.charAt(9),10) && ver2 == Character.digit(cod1.charAt(10),10) ){
            System.out.printf("Digito Correto\n");
        }
        else{
            System.out.printf("Digito Errado\n");
        }

    }

}
