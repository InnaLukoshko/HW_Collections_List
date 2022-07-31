import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class General {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        ListUsers.users.add(new Users("kevin98", "khUt54"));

        try {
            showMenu();
        } catch (Exception e) {
            System.out.println("Ошибка ввода!!!");
        }
    }

    private static void showMenu() throws Exception {
        System.out.println("Первоначальная коллекция пользователей");
        ListUsers.users.forEach(x -> System.out.println(x + " "));
        System.out.println("");
        System.out.println("Введите цифру, обозначающую действие:" +
                "\n1 - добавить нового пользователя" +
                "\n2 - удалить существующего пользователя" +
                "\n3 - проверить, существует ли пользователь" +
                "\n4 - изменить логин существующего пользователя" +
                "\n5 - изменить пароль существующего пользователя");
        int number = Integer.parseInt(reader.readLine());;

        switch (number) {
            case 1:
                ListUsers.add();
                break;
            case 2:
                ListUsers.delete();
                break;
            case 3:
                ListUsers.find();
                break;
            case 4:
                ListUsers.changeLogin();
                break;
            case 5:
                ListUsers.changePassword();
                break;
            default:
                throw new IllegalAccessException("НЕВЕРНЫЙ ВВОД");
        }

    }
}
