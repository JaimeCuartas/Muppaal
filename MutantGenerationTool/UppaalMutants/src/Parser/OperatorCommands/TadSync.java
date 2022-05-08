package Parser.OperatorCommands;

import Parser.Command.Command;
import Parser.Receiver.Mutator;

public class TadSync implements Command {
    private final Mutator mutantOperator;
    private String chanSync;

    public TadSync(Mutator mutantOperator, String chanSync){
        this.mutantOperator = mutantOperator;
        this.chanSync = chanSync;
    }

    public void execute(){
        if(!this.chanSync.equals("")){
            this.mutantOperator.prepareTadSyncOperator(this.chanSync);
        }
    }
}