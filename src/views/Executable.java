package src.views;

/** Выполняющий действия */
public interface Executable {
    /** Получить представление текущего продукта в магазине */
    void getCurrentShopPage();

    /** Получить представление следующего продукта в магазине */
    void getNextShopPage();

    /** Получить представление предыдущего продукта в магазине */
    void getPreviousShopPage();

    /** Получить представление текущего продукта в корзине */
    void getCurrentCartPage();

    /** Получить представление следующего продукта в корзине */
    void getNextCartPage();

    /** Получить представление предыдущего продукта в корзине */
    void getPreviousCartPage();

    /** Добавить в корзину */
    void addToCart();

    /** Удалить из корзины */
    void removeFromCart();

    /** Перейти в корзину */
    void goToCart();

    /** Перейти в магазин */
    void goToShop();

    /** Выход */
    void Quit();

    void buy();

    void getNewProducts();
}
