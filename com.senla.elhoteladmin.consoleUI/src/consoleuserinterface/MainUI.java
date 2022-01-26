package consoleuserinterface;

import com.senla.elhoteladmin.serialization.WrapperDeserialize;
import consoleuserinterface.userservice.MenuController;

public class MainUI {

    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        WrapperDeserialize.deserialize();
        System.out.println("===================================================================================");
        menuController.run();
    }
}
