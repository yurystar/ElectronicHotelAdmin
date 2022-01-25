package consoleuserinterface.actions.exportimportactions;

import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVRead;

public class ImportRoom implements IAction {

    @Override
    public void execute() {
        CSVRead.CSVReadRoom();
    }
}
