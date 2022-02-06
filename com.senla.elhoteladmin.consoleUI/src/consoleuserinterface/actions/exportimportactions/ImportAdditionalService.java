package consoleuserinterface.actions.exportimportactions;

import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVRead;

public class ImportAdditionalService implements IAction {
    CSVRead csvRead = new CSVRead();

    @Override
    public void execute() {
        csvRead.CSVReadAddServ();
    }
}
