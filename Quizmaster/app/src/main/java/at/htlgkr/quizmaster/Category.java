package at.htlgkr.quizmaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Category {
    private String name;
    private List<Item> categoryItems;

    public Category(String name) {
        this.name = name;
        this.categoryItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Item item){
        categoryItems.add(item);
    }

    public Item getRandomCategoryItems() {
        Random random = new Random();
        return categoryItems.get(random.nextInt(categoryItems.size()));
    }
}
