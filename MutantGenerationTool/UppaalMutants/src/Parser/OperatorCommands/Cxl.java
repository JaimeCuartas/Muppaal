package Parser.OperatorCommands;

import Parser.Command.Command;
import Parser.Receiver.Mutator;

public class Cxl implements Command {
    private final Mutator mutantOperator;

    public Cxl(Mutator mutantOperator){
        this.mutantOperator = mutantOperator;
    }

    public void execute(){
        this.mutantOperator.prepareCxlOperator();
    }
}