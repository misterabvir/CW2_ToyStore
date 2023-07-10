package src.views.commands;

import src.views.Executable;

/** Команда "Выход" */
public class CommandQuit implements Command {
    private Executable executable;

    public CommandQuit(Executable executable) {
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.Quit();
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
