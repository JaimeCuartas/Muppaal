package Parser.OperatorCommands;

import Parser.Command.Command;
import Parser.Receiver.Mutator;

public class Smi implements Command {
    private final Mutator mutantOperator;

    public Smi(Mutator mutantOperator){
        this.mutantOperator = mutantOperator;
    }

    public void execute(){
        this.mutantOperator.prepareSmiOperator();
    }
}