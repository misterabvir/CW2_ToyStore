package src.views.commands;

import src.views.Executable;

/** Команда "Получить информацию по предыдущему продукту в магазине" */
public class CommandPreviousShopPageProduct implements Command {
    private Executable executable;

    public CommandPreviousShopPageProduct(Executable executable) {
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.getPreviousShopPage();
    }

    @Override
    public String toString() {
        return "previous page";
    }
}
