package Parser.OperatorCommands;

import Parser.Command.Command;
import Parser.Receiver.Mutator;

public class Tmi implements Command {
    private final Mutator mutantOperator;

    public Tmi(Mutator mutantOperator){
        this.mutantOperator = mutantOperator;
    }

    public void execute(){
        this.mutantOperator.prepareTmiOperator();
    }
}