package src.views.commands;

import src.views.Executable;

/** Команда "Добавить продукт в корзину" */
public class CommandAddToCart implements Command{
    private Executable executable;
    
    public CommandAddToCart(Executable executable){
        this.executable = executable;
    }

    @Override
    public void execute() {
        executable.addToCart();
    }
    
    @Override
    public String toString() {
        return "add to cart";
    }
}
