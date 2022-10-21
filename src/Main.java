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
                return;
            } else if(element[0].matches("[0-9]+") && element[2].matches("[0-9]+") || element[0].matches("[IVXLCDM]+") && element[2].matches("[IVXLCDM]+")){
                String output = calc(input);
                System.out.println(output);
            } else {
                System.out.println(ERROR + "Ошибка | " + TEXT + "Выражение неверно");
                return;
            }
        }
    }

    public static String calc(String input) {
        String[] element = input.split(" ");
        int answer = 0;
        String output = null;
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
            int a = translateToArabic(element[0]);
            int b = translateToArabic(element[2]);
        }
        return output;
    }

    public static int translateToArabic(String input){


        return Integer.parseInt(input);
    }
}


/*
    Ввод выражения

    Деление выражения на элементы (первое число, знак, второе число) - деление через знак пробела

    Проверка выражения на ( 1. число от 1 до 10;
                            2. целые числа)

    Проверка выражения на ( 1. На разные системы исчисления;
                            2. На имеющиеся операции)
    Счёт

    Проверка выражения на отрицательные числа при римской системе

    Вывод результата

 */