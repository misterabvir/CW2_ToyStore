package src.views.commands;

import src.views.Executable;

/** Команда "Получить информацию по предыдущему продукту в корзине" */
public class CommandPreviousCartPageProduct implements Command {
    private Executable executable;

    public CommandPreviousCartPageProduct(Executable executable) {
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.getPreviousCartPage();
    }

    @Override
    public String toString() {
        return "previous page";
    }
}
