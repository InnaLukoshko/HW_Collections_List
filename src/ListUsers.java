import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListUsers {
    public static List<Users> users = new ArrayList<>();

    public static void add() throws Exception {
        Users u = null;
        System.out.println("Введите логин");
        String newLogin;
        do {
            newLogin = enterLogin();
            for (Users user : users) {
                u = user;
                if (user.getLogin().equals(newLogin)) {
                    System.out.println("Введенный логин уже существует. Введите новый логин");
                } else {
                    System.out.println("Введите пароль");
                    users.add(new Users(newLogin,enterPassword()));
                }
            }
        } while (u.getLogin().equals(newLogin));
    }

    public static void delete() throws IOException { // не получилось
        System.out.println("Введите логин пользователя, которого хотите удалить");
        String deleteLogin = enterLogin();
        for (Users user : users) {
            if (user.getLogin().equals(deleteLogin)) {
                users.remove(new Users(deleteLogin));
            }
        }
        System.out.println("Изменённая коллекция пользователей");
        users.forEach(x -> System.out.println(x + " "));
    }

    public static void find() throws IOException {
        System.out.println("Введите логин пользователя, которого хотите проверить на наличие в базе");
        String isLoginInBase = enterLogin();
//        users.contains(isLoginInBase);
        for (Users user : users) {
            if (user.getLogin().equals(isLoginInBase)) {
                System.out.println("Пользователь зарегистрирован");
            } else {
                System.out.println("Пользователь НЕ зарегистрирован");
            }
        }
    }

    public static void changeLogin() throws IOException { //пыталась сделать через индекс
        System.out.println("Введите логин пользователя, который хотите изменить");
        String changedLogin = enterLogin();
//        int index = users.indexOf(changedLogin);
        System.out.println("Введите новый логин");
        String newChangedLogin = enterLogin();
//        users.set(index,newChangedLogin);

        for (Users user : users) {
            if (user.getLogin().equals(changedLogin)) {
                 user.setLogin(newChangedLogin);
            }
        }
        System.out.println("Изменённая коллекция пользователей");
        users.forEach(x -> System.out.println(x + " "));
    }

    public static void changePassword() throws IOException {
        System.out.println("Введите логин пользователя, пароль которого хотите изменить");
        String loginNewPassword = enterLogin();
        for (Users user : users) {
            if (user.getLogin().equals(loginNewPassword)) {
                System.out.println("Введите новый пароль");
                user.setPassword(enterPassword());
            }
        }
        System.out.println("Изменённая коллекция пользователей");
        users.forEach(x -> System.out.println(x + " "));
    }

    private static String enterLogin() throws IOException {
        return General.reader.readLine();
    }
    private static String enterPassword() throws IOException {
        return General.reader.readLine();
    }
}
