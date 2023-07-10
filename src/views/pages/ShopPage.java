package src.views.pages;

import java.util.ArrayList;
import java.util.List;

import src.views.Executable;
import src.views.commands.Command;
import src.views.commands.CommandAddToCart;
import src.views.commands.CommandGetNewProducts;
import src.views.commands.CommandGoToCart;
import src.views.commands.CommandNextShopPageProduct;
import src.views.commands.CommandPreviousShopPageProduct;
import src.views.commands.CommandQuit;

/** Меню магазина */
public class ShopPage implements Page {
    private final List<Command> commands;

    public ShopPage(Executable executable){
        commands = new ArrayList<>();
        commands.add(new CommandPreviousShopPageProduct(executable));
        commands.add(new CommandNextShopPageProduct(executable));
        commands.add(new CommandAddToCart(executable));
        commands.add(new CommandGoToCart(executable));
        commands.add(new CommandGetNewProducts(executable));
        commands.add(new CommandQuit(executable));
    }

    public void execute(int index){
        if(index >= 0 && index < commands.size()){
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

    public int size() {
        return commands.size();
    }
}
