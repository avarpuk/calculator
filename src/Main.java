import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {

    public static final String TEXT = "\u001b[0m";
    public static final String ERROR = "\u001b[31;1m";
    public static final String SUCCESS = "\u001b[32;1m";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        String[] element = input.split(" ");
        try{
            if(!element[3].isEmpty()){
                System.out.println(ERROR + "Ошибка | " + TEXT + "Выражение имеет недопустимое количество операторов");
            }
        } catch (IndexOutOfBoundsException e){
            if(!element[1].matches("[-+*/]")) {
                System.out.println(ERROR + "Ошибка | " + TEXT + "Выражение имеет недопустимый оператор");
            } else if(element[0].matches("[0-9]+") && element[2].matches("[0-9]+") || element[0].matches("[IVXLCDM]+") && element[2].matches("[IVXLCDM]+")){
                String output = calc(input);
                System.out.println(output);
            } else {
                System.out.println(ERROR + "Ошибка | " + TEXT + "Выражение неверно");
            }
        }
    }

    public static String calc(String input) {
        Translate translate = new Translate();
        String[] element = input.split(" ");
        int answer = 0;
        String output;
        if (element[0].matches("[0-9]+") && element[2].matches("[0-9]+")) {
            int a = Integer.parseInt(element[0]);
            int b = Integer.parseInt(element[2]);
            if (a < 0 || a > 10 || b < 0 || b > 10) {
                System.out.println(ERROR + "Ошибка | " + TEXT + "Выражение неверно");
            } else {
                switch (element[1]) {
                    case "+":
                        answer = a + b;
                        break;
                    case "-":
                        answer = a - b;
                        break;
                    case "*":
                        answer = a * b;
                        break;
                    case "/":
                        answer = a / b;
                        break;
                }
            }
            output = String.valueOf(answer);
        } else {
            String aElement = element[0];
            String bElement = element[2];
            int a = translate.translateToArabic(aElement);
            int b = translate.translateToArabic(bElement);
            if (a < 0 || a > 10 || b < 0 || b > 10) {
                System.out.println(ERROR + "Ошибка | " + TEXT + "Выражение неверно");
            } else {
                switch (element[1]) {
                    case "+":
                        answer = a + b;
                        break;
                    case "-":
                        answer = a - b;
                        break;
                    case "*":
                        answer = a * b;
                        break;
                    case "/":
                        answer = a / b;
                        break;
                }
            }
            if(answer < 1 || answer > 3999){
                output = ERROR + "Ошибка! " + TEXT + "Выражение неверно";
            } else {
                output = translate.intToRoman(answer);
            }
        }
        return output;
    }
}