package consoleuserinterface.actions;

import com.senla.elhoteladmin.controller.AdminControllerSingleton;

public class ShowListGuestsAndTheirRoomsSortedByCheckOutDays implements IAction {
    private final AdminControllerSingleton adminControllerSingleton = AdminControllerSingleton.getInstance();

    @Override
    public void execute() {
        System.out.println("Список гостей и их номеров" +
                adminControllerSingleton.getListGuestsAndTheirRoomsSortedByCheckOutDays());
        System.out.println();
    }
}
