package consoleuserinterface;

import com.senla.daoservice.serialization.WrapperDeserialize;
import consoleuserinterface.userservice.MenuController;

public class MainUI {

    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        WrapperDeserialize wrapperDeserialize = WrapperDeserialize.getInstance();
        wrapperDeserialize.deserialize();
        System.out.println("===================================================================================");
        menuController.run();
    }
}
