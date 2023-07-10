package src.models.products;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Toy implements  Product, Serializable {
    private String title;
    private List<Tag> tags;
    private double price;


    public Toy(String title, double price, Tag[] tags){
        this.tags = Arrays.asList(tags);
        this.title = title;
        this.price = price;
    }

    public void setPrice(Double price){
        this.price = price;
    }


    //#region implements product
    @Override
    public void addTag(Tag tag){
        tags.add(tag);
    }
    @Override
    public void removeTag(Tag tag){
        tags.remove(tag);
    }

    @Override
    public boolean isTagged(Tag tag) {
        return tags.contains(tag);
    }


    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getTags() {
        StringBuilder builder = new StringBuilder();
        for (Tag tag : this.tags){
            builder.append("#").append(tag.toString()).append(" ");
        }
        return builder.toString();
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return  "   " + this.title + "\r\n" +
                "   " + this.getTags() + "\r\n";
    }
    //#endregion

    @Override
    public Tag[] getTagsArray() {
        return (Tag[])tags.toArray();
    }
}
