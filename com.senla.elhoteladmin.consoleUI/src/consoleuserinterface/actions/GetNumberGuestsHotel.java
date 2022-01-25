package consoleuserinterface.actions;

import com.senla.elhoteladmin.service.GuestService;

public class GetNumberGuestsHotel implements IAction {
    private final GuestService guestService = GuestService.getInstance();

    @Override
    public void execute() {
        System.out.println("Общее количество гостей отеля - " + guestService.getNumberGuestsHotel());
        System.out.println();
    }
}
