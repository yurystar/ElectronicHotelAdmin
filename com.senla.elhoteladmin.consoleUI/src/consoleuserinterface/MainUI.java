package consoleuserinterface;

import com.senla.elhoteladmin.serialization.WrapperDeserialize;
import consoleuserinterface.userservice.MenuController;

import java.io.IOException;

public class MainUI {

    public static void main(String[] args) throws IOException {
        MenuController menuController = new MenuController();
        WrapperDeserialize.deserialize();
        System.out.println("===================================================================================");
        menuController.run();
    }
}
