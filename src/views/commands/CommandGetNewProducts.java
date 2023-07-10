package src.views.commands;

import src.views.Executable;

/** Команда "Получить информацию по текущему продукту в корзине" */
public class CommandGetNewProducts implements Command {


    private Executable executable;
    
    public CommandGetNewProducts(Executable executable){
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.getNewProducts();
    }
    
    @Override
    public String toString() {
        return "get new products";
    }
}
