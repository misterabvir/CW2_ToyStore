package src.views;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import src.Keys;
import src.presenters.Presenter;
import src.views.pages.CartPage;
import src.views.pages.Page;
import src.views.pages.ShopPage;

public class ConsoleView implements View, Executable {
    private boolean isWork;
    private Page currentPage;
    private final Scanner scanner;
    private final ShopPage shopPage;
    private final CartPage cartPage;
    private final Presenter presenter;
    private final String SHOP = "TOY STORE > in shop";
    private final String CART = "TOY STORE > in cart";

    public ConsoleView() {
        scanner = new Scanner(System.in);
        presenter = new Presenter();
        shopPage = new ShopPage(this);
        cartPage = new CartPage(this);
        currentPage = shopPage;
        isWork = true;
    }

    // #region implements View
    @Override
    public void start() {
        Dialog(0);
        while (isWork) {
            Dialog(getIntInput() - 1);
        }
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }
    // #endregion

    // #region implements executable
    @Override
    public void getCurrentShopPage() {
        printPage(SHOP, presenter.getCurrentShopProduct());
        printAmount(presenter.getAmountInCart());
    }

    @Override
    public void getNextShopPage() {
        printPage(SHOP, presenter.getNextShopProduct());
        printAmount(presenter.getAmountInCart());
    }

    @Override
    public void getPreviousShopPage() {
        printPage(SHOP, presenter.getPreviousShopProduct());
        printAmount(presenter.getAmountInCart());
    }

    @Override
    public void getCurrentCartPage() {
        printPage(CART, presenter.getCurrentCartProduct());
        printDetail(presenter.getCartDetail());
    }

    @Override
    public void getNextCartPage() {
        printPage(CART, presenter.getNextCartProduct());
        printDetail(presenter.getCartDetail());
    }

    @Override
    public void getPreviousCartPage() {
        printPage(CART, presenter.getPreviousCartProduct());
        printDetail(presenter.getCartDetail());
    }

    @Override
    public void addToCart() {
        presenter.addToCart();
        printPage(SHOP, presenter.getCurrentShopProduct());
        printAmount(presenter.getAmountInCart());
    }

    @Override
    public void removeFromCart() {
        presenter.removeFromCart();
        printPage(CART, presenter.getCurrentCartProduct());
        printDetail(presenter.getCartDetail());
    }

    @Override
    public void goToCart() {
        currentPage = cartPage;
        printPage(CART, presenter.getCurrentCartProduct());
        printDetail(presenter.getCartDetail());
    }

    @Override
    public void goToShop() {
        currentPage = shopPage;
        printPage(SHOP, presenter.getCurrentShopProduct());
        printAmount(presenter.getAmountInCart());
    }

    @Override 
    public void getNewProducts(){
        presenter.getNewProducts();
        printPage(SHOP, presenter.getCurrentShopProduct());
        printAmount(presenter.getAmountInCart());
    }


    @Override
    public void buy(){
        presenter.buy();
        printPage(CART, presenter.getCurrentCartProduct());
        printDetail(presenter.getCartDetail());
    }

    @Override
    public void Quit() {
        isWork = false;
    }
    // #endregion

    // #region Рендер страниц
    /** Отрисовка страницы с товаром */
    private void printPage(String titlePage, Map<String, String> dataPage) {
        if (dataPage == null) {
            print(String.format(Templates.PAGE_EMPTY.getTemplate(), titlePage));        
            return;
        }
        print(String.format(Templates.PAGE.getTemplate(),
                titlePage,
                dataPage.get(Keys.TITLE.getKey()),
                dataPage.get(Keys.TAGS.getKey()),
                dataPage.get(Keys.AMOUNT.getKey()),
                dataPage.get(Keys.PRICE.getKey()),
                dataPage.get(Keys.DISCOUNT.getKey()),
                dataPage.get(Keys.SPECIAL.getKey())));
    }

    /** Отрисовка страницы с количеством товаров в корзине */
    private void printAmount(Map<String, String> dataAmount) {
        if (dataAmount == null) {
            return;
        }
        print(String.format(Templates.CART_AMOUNT.getTemplate(), dataAmount.get(Keys.AMOUNT.getKey())));
    }

    /** Отрисовка с результатами выбранных товаров в корзине */
    private void printDetail(List<Map<String, String>> dataResult) {
        if (dataResult == null) {
            return;
        }
        print(Templates.CART_TITLE_ITEM.getTemplate());
        for (int i = 1; i < dataResult.size(); i++) {
            print(String.format(Templates.CART_ITEM.getTemplate(),
                    String.format("%d", (i)),
                    dataResult.get(i).get(Keys.TITLE.getKey()),
                    dataResult.get(i).get(Keys.AMOUNT.getKey()),
                    dataResult.get(i).get(Keys.PRICE.getKey()),
                    dataResult.get(i).get(Keys.SPECIAL.getKey()),
                    dataResult.get(i).get(Keys.PRICE_TOTAL.getKey()),
                    dataResult.get(i).get(Keys.SPECIAL_TOTAL.getKey())));
        }
        print(String.format(Templates.CART_RESULT.getTemplate(),
                dataResult.get(0).get(Keys.PRICE_TOTAL.getKey()),
                dataResult.get(0).get(Keys.SPECIAL_TOTAL.getKey())));
    }
    // #endregion

    /** Очистить консоль */
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /** Основной диалог */
    private void Dialog(int number) {
        clearScreen();
        currentPage.execute(number);
        print(currentPage.toString() + "\r\n");
    }

    /** Получение выбора пункта меню */
    private int getIntInput() {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.matches("[0-9]+")) {
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= shopPage.size()) {
                    return number;
                }
            }
        } while (true);
    }
}