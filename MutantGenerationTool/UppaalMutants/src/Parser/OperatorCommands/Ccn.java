package Parser.OperatorCommands;

import Parser.Command.Command;
import Parser.Receiver.Mutator;

public class Ccn implements Command {
    private final Mutator mutantOperator;

    public Ccn(Mutator mutantOperator){
        this.mutantOperator = mutantOperator;
    }

    public void execute(){
        this.mutantOperator.prepareCcnOperator();
    }
}
