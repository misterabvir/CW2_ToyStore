package src.views.commands;

import src.views.Executable;

public class CommandBuy implements Command {

    private Executable executable;
    
    public CommandBuy(Executable executable){
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.buy();
    }
    
    @Override
    public String toString() {
        return "Buy";
    }
    
}
