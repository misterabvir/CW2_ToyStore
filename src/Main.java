package src;

import src.views.ConsoleView;
import src.views.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleView();
        view.start();
    }
}
