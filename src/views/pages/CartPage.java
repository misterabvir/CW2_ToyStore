package src.views.pages;

import java.util.ArrayList;
import java.util.List;

import src.views.Executable;
import src.views.commands.Command;
import src.views.commands.CommandBuy;
import src.views.commands.CommandGoToShop;
import src.views.commands.CommandNextCartPageProduct;
import src.views.commands.CommandPreviousCartPageProduct;
import src.views.commands.CommandQuit;
import src.views.commands.CommandRemoveFromCart;

/** Меню корзины */
public class CartPage implements Page {

    private List<Command> commands;

    public CartPage(Executable executable){
        commands = new ArrayList<>();
        commands.add(new CommandPreviousCartPageProduct(executable));
        commands.add(new CommandNextCartPageProduct(executable));
        commands.add(new CommandRemoveFromCart(executable));
        commands.add(new CommandGoToShop(executable));
        commands.add(new CommandBuy(executable));
        commands.add(new CommandQuit(executable));
    }

    public void execute(int index) {
        if (index >= 0 && index < commands.size()) {
            commands.get(index).execute();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int index = 1;
        for (Command command : commands) {
            builder.append(index++).append(". ").append(command.toString()).append("\r\n");
        }
        return builder.toString();
    }

    @Override
    public int size() {
        return commands.size();
    }

}
