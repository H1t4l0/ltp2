import java.util.Scanner;

public class placaCarro5_4 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String placa;
        String dataMulta;
        float valormulta;
        String letras = "";
        String numeros = "";
        byte cont;
        char flag;
        boolean valido;
        float soma = 0;
        float media = 0;
        byte contPessoas = 0;
        float menor = 0;
        //concerta o calculo do mes fevereiro e a menor multa
        //System.out.printf("");
        do {
            //placa do veuculo
            do {
                System.out.printf("Insira a placa do veiculo: ");
                placa = leia.next(); // GVP5566
            } while (placa.length() != 7);

            try {
                letras = placa.substring(0, 3);
                numeros = placa.substring(3);

                for (cont = 0; cont < letras.length(); cont++) {
                    Character.digit(letras.charAt(cont), 10);
                }
                for (cont = 0; cont < numeros.length(); cont++) {
                    Integer.parseInt(numeros);
                }
            } catch (Exception e) {
                System.out.printf("A conversão da placa deu errado\n");
            }
            System.out.println(letras + numeros);

            // data da multa
            do{
                do {
                    System.out.printf("Insira a data da multa(DD/MM/AAAA): ");
                    dataMulta = leia.next(); //(DD/MM/AAAA)
                } while (dataMulta.length() != 10);

                valido = dataEhValida(dataMulta);

                if(!valido){
                    System.out.println("data inválida");
                }
            }while (!valido);

            //valor da multa
            do {
                System.out.printf("Valor da multa: ");
                valormulta = leia.nextFloat();
            } while (valormulta < 0);

            System.out.printf("Deseja continuar(s/n)\n");
            flag = leia.next().charAt(0);

            contPessoas ++;
            soma += valormulta;
            media = soma / contPessoas;
            if(valormulta > menor){
                menor = valormulta;
            }


        } while (flag != 's');

        System.out.println("Soma: " + soma);
        System.out.println("media: " + media);
        System.out.println("menor: " + menor);

    }

    public static boolean dataEhValida(String _dataMulta) {
        int dia = 0, mes = 0, ano = 0;
        byte i;
        boolean dataValida = false;
        try {
            for (i = 0; i < 4; i++) {
                if(i < 2){
                    dia = Integer.parseInt(_dataMulta.substring(0,2));
                    mes = Integer.parseInt(_dataMulta.substring(3, 5));
                }
                else if(i < 4){
                    ano = Integer.parseInt(_dataMulta.substring(6));
                }
            }

        } catch (Exception e) {
            System.out.printf("conversão da data da multa deu errado\n");
        }
        if((mes > 0 && mes <= 12) && (ano <= 2023)){
            if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 12){
                if(dia > 0 && dia <= 31){
                    return dataValida = true;
                }
            }
            else if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
                if(dia > 0 && dia <= 30){
                    return dataValida = true;
                }
            }
            else if(mes == 2){
                if(ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)){
                    if(dia > 0 && dia <= 29){
                        return dataValida = true;
                    }
                    else{
                        if(dia > 0 && dia <= 28){
                            return dataValida = true;
                        }
                    }
                }
            }
        }
        return dataValida;
    }
}


