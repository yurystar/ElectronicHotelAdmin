package consoleuserinterface.actions.exportimportactions;

import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVRead;

public class ImportGuest implements IAction {

    @Override
    public void execute() {
        CSVRead.CSVReadGuest();
    }
}
