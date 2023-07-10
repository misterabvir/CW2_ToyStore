package src.views.commands;


import src.views.Executable;

/** Команда "Получить информацию по текущему продукту в магазине" */
public class CommandCurrentShopPageProduct implements Command{

    private Executable executable;
    
    public CommandCurrentShopPageProduct(Executable executable){
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.getCurrentShopPage();
    }
    
    @Override
    public String toString() {
        return "update page";
    }
}
