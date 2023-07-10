package src.presenters;

import src.models.Service;

import java.util.List;
import java.util.Map;

/** Представление */
public class Presenter {

    private Service service;

    /** Представление */
    public Presenter() {
        service = new Service();
    }

    /** Получение текущего продукта в магазине */
    public Map<String, String> getCurrentShopProduct() {
        return service.getCurrentShopProductItem();
    }

    /** Получение следующего продукта в магазине */
    public Map<String, String> getNextShopProduct() {
        return service.getNextShopProductItem();
    }

    /** Получение предыдущего продукта в магазине */
    public Map<String, String> getPreviousShopProduct() {
        return service.getPrevShopProductItem();
    }

    /** Получение текущего продукта в корзине */
    public Map<String, String> getCurrentCartProduct() {
        return service.getCurrentCartProductItem();
    }

    /** Получение следующего продукта в корзине */
    public Map<String, String> getNextCartProduct() {
        return service.getNextCartProductItem();
    }

    /** Получение предыдущего продукта в корзине */
    public Map<String, String> getPreviousCartProduct() {
        return service.getPrevCartProductItem();
    }

    /** Добавить продукт из магазина в корзину */
    public Map<String, String> addToCart() {
        service.addToCart();
        return getCurrentShopProduct();
    }

    /** Удалить продукт из корзины */
    public Map<String, String> removeFromCart() {
        service.removeFromCart();
        return getCurrentShopProduct();
    }

    /** Получить подробности по товарам в корзине */
    public List<Map<String, String>> getCartDetail() {
        return service.getCartDetail();
    }

    /** Получить количество товаров в корзине */
    public Map<String, String> getAmountInCart() {
        return service.getAmountInCart();
    }

    /** купить  */
    public void buy() {
        service.buy();
    }

    public void getNewProducts() {
        service.getNewProducts();
    }
}
