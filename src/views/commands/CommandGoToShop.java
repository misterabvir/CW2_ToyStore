package src.views.commands;

import src.views.Executable;

/** Команда "Прейти в магазин" */
public class CommandGoToShop implements Command {

    private Executable executable;

    public CommandGoToShop(Executable executable) {
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.goToShop();
    }

    @Override
    public String toString() {
        return "go to shop";
    }
}
