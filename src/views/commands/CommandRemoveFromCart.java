package src.views.commands;

import src.views.Executable;

/** Команда "Удалить продукт из корзины" */
public class CommandRemoveFromCart implements Command {

    private Executable executable;

    public CommandRemoveFromCart(Executable executable) {
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.removeFromCart();
    }

    @Override
    public String toString() {
        return "remove from cart";
    }

}
