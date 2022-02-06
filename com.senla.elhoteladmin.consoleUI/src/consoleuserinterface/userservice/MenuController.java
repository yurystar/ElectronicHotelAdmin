package consoleuserinterface.userservice;

import com.senla.daoservice.serialization.WrapperSerialize;

import java.util.Scanner;

public class MenuController {
    Builder builder;
    Navigator navigator;

    public MenuController() {
        this.builder = new Builder();
        this.navigator = new Navigator();
    }

    public void run() {
        WrapperSerialize wrapperSerialize = WrapperSerialize.getInstance();
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        Integer index;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                if (index == -1) {

                    wrapperSerialize.serialize();
                    System.out.println("Вы вышли из программы.");
                    return;
                }
                navigator.navigate(index);
                navigator.printMenu();
            } else {
                System.out.println("Это не число! Попробуйте еще раз.");
                scanner.next();
            }
        }
    }
}
