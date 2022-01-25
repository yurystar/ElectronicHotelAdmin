package consoleuserinterface.actions.exportimportactions;

import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVWrite;

public class ExportGuest implements IAction {
    @Override
    public void execute() {
        CSVWrite.CSVWriteGuest();
    }
}
