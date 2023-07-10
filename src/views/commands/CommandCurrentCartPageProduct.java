package src.views.commands;


import src.views.Executable;

/** Команда "Получить информацию по текущему продукту в корзине" */
public class CommandCurrentCartPageProduct implements Command{

    private Executable executable;
    
    public CommandCurrentCartPageProduct(Executable executable){
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.getCurrentCartPage();
    }
    
    @Override
    public String toString() {
        return "update page";
    }
}
