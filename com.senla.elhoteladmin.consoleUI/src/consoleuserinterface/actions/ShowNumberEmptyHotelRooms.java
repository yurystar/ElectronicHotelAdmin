package consoleuserinterface.actions;

import com.senla.elhoteladmin.service.RoomService;

public class ShowNumberEmptyHotelRooms implements IAction {
    private final RoomService roomService = RoomService.getInstance();


    @Override
    public void execute() {
        System.out.println("Количество свободных номеров - " + roomService.getNumberEmptyHotelRooms());
        System.out.println();
    }
}
