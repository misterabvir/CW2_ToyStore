package src.models.items;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import src.Keys;
import src.models.products.Product;
import src.models.products.Tag;

public class ToyItem implements ProductItem, Serializable  {

    private final String id;
    private final Product product;
    private Integer amount;
    private double discount;

    public ToyItem(String id, Product product, int amount, double discount) {

        this.id = id;
        this.product = product;
        this.amount = amount;
        setDiscount(discount);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public Integer getAmount() {
        return this.amount;
    }

    @Override
    public void increaseAmount() {
        this.amount += 1;
    }

    @Override
    public void decreaseAmount() {
        if (this.amount > 0) {
            this.amount -= 1;
        }
    }

    @Override
    public double getDiscount() {
        return this.discount;
    }

    @Override
    public void setDiscount(double discount) {

        if (discount >= 0 && discount <= 1) {
            this.discount = discount;
        }
    }

    @Override
    public double getPrice(boolean enableDiscount) {
        double result = product.getPrice();
        if (enableDiscount) {
            result *= discount;
        }
        return result;
    }

    @Override
    public double getTotalPrice(boolean enableDiscount) {
        double result = product.getPrice() * amount;
        if (enableDiscount) {
            result *= discount;
        }
        return result;
    }

    @Override
    public boolean isTagged(Tag tag) {
        return product.isTagged(tag);
    }

    @Override
    public Map<String, String> detail() {
        Map<String, String> map = new HashMap<>();
        map.put(Keys.TITLE.getKey(), this.product.getTitle());
        map.put(Keys.TAGS.getKey(), this.product.getTags());
        map.put(Keys.AMOUNT.getKey(), this.amount.toString());
        map.put(Keys.PRICE.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getPrice(false)));
        map.put(Keys.DISCOUNT.getKey(), String.format("%.1f%%", (100 - this.discount * 100)));
        map.put(Keys.SPECIAL.getKey(), String.format(String.format(Keys.MONEY_FORMAT.getKey(), this.getPrice(true))));
        return map;
    }

    @Override
    public Map<String, String> result() {
        Map<String, String> map = new HashMap<>();
        map.put(Keys.TITLE.getKey(), this.product.getTitle());
        map.put(Keys.PRICE.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getPrice(false)));
        map.put(Keys.PRICE_TOTAL.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getTotalPrice(false)));
        map.put(Keys.SPECIAL.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getPrice(true)));
        map.put(Keys.SPECIAL_TOTAL.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getTotalPrice(true)));
        map.put(Keys.AMOUNT.getKey(), this.amount.toString());
        return map;
    }
}
