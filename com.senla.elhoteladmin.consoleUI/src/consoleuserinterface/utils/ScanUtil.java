package consoleuserinterface.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScanUtil {

    public static Integer getInt() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число: ");
            if (input.hasNextInt()) {
                return input.nextInt();
            } else {
                System.out.println("Это не число! Попробуйте еще раз.\n");
                input.next();
            }
        }
    }

    public static String getStr() {
        Scanner input = new Scanner(System.in);
        String s = null;
        while (true) {
            System.out.println("Введите слово: ");
            if (input.hasNext()) {
                s = input.next();
                if (s.chars().allMatch(Character::isLetter)) {
                    return s;
                } else System.out.println("Ошибка! Введите корректную информацию.");
            } else {
                System.out.println("Введите информацию.\n");

            }
        }
    }

    public static LocalDate getDate() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inputDate;

        while(true){
            System.out.print("Введите данные в формате ГГГГ-ММ-ДД:");
            String date = scanner.next();
            try {
                inputDate = LocalDate.parse(date, formatter);
                return inputDate;
            } catch (Exception e) {
                System.err.println("Ошибка! Введите дату в корректном формате.");
            }
        }
    }
}
