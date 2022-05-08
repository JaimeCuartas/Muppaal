package Parser.OperatorCommands;

import Parser.Command.Command;
import Parser.Receiver.Mutator;

public class SmiNoRedundant implements Command {
    private final Mutator mutantOperator;

    public SmiNoRedundant(Mutator mutantOperator){
        this.mutantOperator = mutantOperator;
    }

    public void execute(){
        this.mutantOperator.prepareSmiNoRedundantOperator();
    }
}