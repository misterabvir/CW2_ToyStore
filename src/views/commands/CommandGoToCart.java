package src.views.commands;

import src.views.Executable;

/** Команда "Прейти в корзину" */
public class CommandGoToCart implements Command {

    private Executable executable;

    public CommandGoToCart(Executable executable) {
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.goToCart();
    }

    @Override
    public String toString() {
        return "go to cart";
    }
}
