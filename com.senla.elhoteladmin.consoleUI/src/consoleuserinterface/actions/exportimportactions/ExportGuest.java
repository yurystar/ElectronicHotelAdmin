package consoleuserinterface.actions.exportimportactions;

import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVWrite;

public class ExportGuest implements IAction {
    CSVWrite csvWrite = new CSVWrite();

    @Override
    public void execute() {
        csvWrite.CSVWriteGuest();
    }
}
