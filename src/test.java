import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int dia = 0, mes = 0, ano = 0;
        String _dataMulta;
        byte i;

        System.out.println("Insira a data da multa (dd/mm/aaaa): ");
        _dataMulta = leia.next();

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

        System.out.println(dia + "/" + mes + "/" + ano);
    }
}
