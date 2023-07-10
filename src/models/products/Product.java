package src.models.products;

public interface Product {

    String getTitle();
    String getTags();
    double getPrice();
    void addTag(Tag tag);
    void removeTag(Tag tag);

    boolean isTagged(Tag tag);
    Tag[] getTagsArray();
}