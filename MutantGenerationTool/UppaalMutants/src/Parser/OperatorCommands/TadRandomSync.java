package Parser.OperatorCommands;

import Parser.Command.Command;
import Parser.Receiver.Mutator;

public class TadRandomSync implements Command {
    private final Mutator mutantOperator;

    public TadRandomSync(Mutator mutantOperator){
        this.mutantOperator = mutantOperator;
    }

    public void execute(){
        this.mutantOperator.prepareTadRandomSyncOperator();
    }
}
