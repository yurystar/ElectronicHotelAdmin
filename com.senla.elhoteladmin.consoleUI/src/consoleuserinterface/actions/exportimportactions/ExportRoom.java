package consoleuserinterface.actions.exportimportactions;

import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVWrite;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ExportRoom implements IAction {

    @Override
    public void execute() {
        CSVWrite.CSVWriteRoom();
    }
}
