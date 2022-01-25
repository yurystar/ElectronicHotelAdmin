package consoleuserinterface.actions;

import com.senla.elhoteladmin.controller.AdminControllerSingleton;
import consoleuserinterface.utils.ScanUtil;

public class SetRoomStatusAsOnRepair implements IAction{
    private final AdminControllerSingleton adminControllerSingleton = AdminControllerSingleton.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты - ");
        adminControllerSingleton.setRoomStatusAsOnRepair(ScanUtil.getInt());
        System.out.println("Статус изменен.\n");
        System.out.println();
    }
}
