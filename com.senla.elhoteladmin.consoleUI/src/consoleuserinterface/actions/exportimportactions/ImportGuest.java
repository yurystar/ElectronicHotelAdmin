package consoleuserinterface.actions.exportimportactions;

import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVRead;

public class ImportGuest implements IAction {
    CSVRead csvRead = new CSVRead();

    @Override
    public void execute() {
        csvRead.CSVReadGuest();
    }
}
