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
                calc(input);
            } else {
                System.out.println(ERROR + "Ошибка | " + TEXT + "Выражение неверно");
                return;
            }
        }
    }

    public static String calc(String input){
        String[] element = input.split(" ");
        if(element[0].matches("[0-9]+") && element[2].matches("[0-9]+")){
            int a = Integer.parseInt(element[0]);
            int b = Integer.parseInt(element[2]);
            if(a < 0 || a > 10 || b < 0 || b > 10){
                System.out.println(ERROR + "Ошибка | " + TEXT + "Выражение неверно");
            } else {
                switch (element[1]) {
                    case "+":
                        int sum = a + b;
                        System.out.println(SUCCESS + "Результат вычисления = "+ TEXT + sum);
                        break;
                    case "-":
                        int dif = a - b;
                        System.out.println(SUCCESS + "Результат вычисления = "+ TEXT + dif);
                        break;
                    case "*":
                        int prod = a * b;
                        System.out.println(SUCCESS + "Результат вычисления = "+ TEXT + prod);
                        break;
                    case "/":
                        int quot = a / b;
                        System.out.println(SUCCESS + "Результат вычисления = "+ TEXT +  quot);
                        break;
                }
            }
        } else {
            // РИМСКИЕ ЧИСЛА
        }
        return input;
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