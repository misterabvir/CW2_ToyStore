package src.models;

import java.util.*;

import src.Keys;
import src.models.items.ToyItem;
import src.models.products.Tag;
import src.models.products.Toy;
import src.models.storages.Storage;
import src.models.storages.repositories.BinDB;
import src.models.storages.repositories.DB;

public class Service {
    private Storage<ToyItem> shop;
    private final Storage<ToyItem> cart;
    private final DB<Storage<ToyItem>> repository;

    public Service() {
        repository = new BinDB<>();
        getShop();
        cart = new Storage<>();
    }

    private void getShop() {
        shop = repository.load();
        if (shop == null) {
            getNewProducts();
        }
    }

    public void getNewProducts() {
        if(shop == null){
            shop = new Storage<>();
        }

        Random rand = new Random();

        for (int i = 0; i < rand.nextInt(5, 20); i++) {
            String name = "toy" + rand.nextInt(1, 30);
            ToyItem item = (ToyItem)shop.search(name);
            if(item != null){
                item.increaseAmount();
            } else { 
                List<Tag> tags = new ArrayList<>();
                for(int j = 0; j < Tag.values().length; j++){
                    if(rand.nextInt()%5 == 0 && tags.size() < 3) {
                        tags.add(Tag.values()[j]);
                    }
                }  
                Toy toy = new Toy(name, rand.nextInt(1000, 10000) / 100.0D, tags.stream().toArray(Tag[]::new));
                item = new ToyItem(UUID.randomUUID().toString(), toy, rand.nextInt(100), (rand.nextDouble() + 9) / 10.0D);
                shop.add(item);
            }
        }
        repository.save(shop);
    }

    public Map<String, String> getCurrentShopProductItem() {
        return nullCheck(shop.getCurrent());
    }

    public Map<String, String> getNextShopProductItem() {
        return nullCheck(shop.getNext());
    }

    public Map<String, String> getPrevShopProductItem() {
        return nullCheck(shop.getPrev());
    }

    public Map<String, String> getCurrentCartProductItem() {
        return nullCheck(cart.getCurrent());
    }

    public Map<String, String> getNextCartProductItem() {
        return nullCheck(cart.getNext());
    }

    public Map<String, String> getPrevCartProductItem() {
        return nullCheck(cart.getPrev());
    }

    public void addToCart() {
        ToyItem shopItem = shop.getCurrent();
        if (shopItem == null) {
            return;
        }
        shopItem.decreaseAmount();
        if (shopItem.getAmount() == 0) {
            shop.remove(shopItem);
        }
        ToyItem cartItem = cart.getItem(shopItem.getId());
        if (cartItem != null) {
            cartItem.increaseAmount();
        } else {
            cart.add(new ToyItem(shopItem.getId(), shopItem.getProduct(), 1, shopItem.getDiscount()));
        }
    }

    public void removeFromCart() {
        ToyItem cartItem = cart.getCurrent();
        if (cartItem == null) {
            return;
        }
        cartItem.decreaseAmount();
        if (cartItem.getAmount() == 0) {
            cart.remove(cartItem);
        }
        ToyItem shopItem = shop.getItem(cartItem.getId());
        if (shopItem != null) {
            shopItem.increaseAmount();
        } else {
            shop.add(new ToyItem(cartItem.getId(), cartItem.getProduct(), 1, cartItem.getDiscount()));
        }
    }

    public List<Map<String, String>> getCartDetail() {
        Map<String, String> map = new HashMap<>();
        map.put(Keys.PRICE_TOTAL.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), cart.priceAll(false)));
        map.put(Keys.SPECIAL_TOTAL.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), cart.priceAll(true)));
        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);
        list.addAll(cart.getList());
        return list;
    }

    private Map<String, String> nullCheck(ToyItem item) {
        if (item == null) {
            return null;
        }
        return item.detail();
    }

    public Map<String, String> getAmountInCart() {
        Map<String, String> map = new HashMap<>();
        int amount = 0;
        for (ToyItem toyItem : cart) {
            amount += toyItem.getAmount();
        }
        map.put(Keys.AMOUNT.getKey(), String.format("%d", amount));
        return map;
    }

    public void buy() {
        cart.clear();
        repository.save(shop);
    }
}
