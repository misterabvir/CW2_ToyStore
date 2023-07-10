package src.models.items;

import java.util.Map;

import src.models.products.Product;
import src.models.products.Tag;

public interface ProductItem {

    String getId();
    Product getProduct();
    Integer getAmount();
    void increaseAmount();
    void decreaseAmount();
    double getDiscount();
    void setDiscount(double discount);
    double getPrice(boolean enableDiscount);
    double getTotalPrice(boolean enableDiscount);
    boolean isTagged(Tag tag);
    Map<String, String> result();
    Map<String, String> detail();
}
