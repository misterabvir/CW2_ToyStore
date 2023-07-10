package src.views.commands;

import src.views.Executable;

/** Команда "Получить информацию по следующему продукту в корзине" */
public class CommandNextCartPageProduct implements Command {

    private Executable executable;
    
    public CommandNextCartPageProduct(Executable executable){
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.getNextCartPage();
    }
    
    @Override
    public String toString() {
        return "next page";
    }  
}
