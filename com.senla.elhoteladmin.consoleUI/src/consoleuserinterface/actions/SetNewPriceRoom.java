package consoleuserinterface.actions;

import com.senla.elhoteladmin.service.RoomService;
import consoleuserinterface.utils.ScanUtil;

public class SetNewPriceRoom implements IAction {
    private final RoomService roomService = RoomService.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты и новую цену- ");
        roomService.setNewPriceRoom(ScanUtil.getInt(), ScanUtil.getInt());
        System.out.println("Новая цена установлена.\n");
    }
}
