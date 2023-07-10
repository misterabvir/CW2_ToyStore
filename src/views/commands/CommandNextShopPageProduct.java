package src.views.commands;

import src.views.Executable;

/** Команда "Получить информацию по следующему продукту в магазине" */
public class CommandNextShopPageProduct implements Command {

    private Executable executable;

    public CommandNextShopPageProduct(Executable executable) {
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.getNextShopPage();
    }

    @Override
    public String toString() {
        return "next page";
    }
}
