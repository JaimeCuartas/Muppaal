package Parser.OperatorCommands;

import Parser.Command.Command;
import Parser.Receiver.Mutator;

public class Tad implements Command {
    private final Mutator mutantOperator;

    public Tad(Mutator mutantOperator){
        this.mutantOperator = mutantOperator;
    }

    public void execute(){
        this.mutantOperator.prepareTadOperator();
    }
}
