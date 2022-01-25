package consoleuserinterface.actions;

import com.senla.elhoteladmin.service.GuestService;

public class ShowGuestsHotel implements IAction {
    private final GuestService guestService = GuestService.getInstance();

    @Override
    public void execute() {
        System.out.println("Список всех гостей - \n" + guestService.getGuestsHotel());
        System.out.println();
    }
}
