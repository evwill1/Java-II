package module5.solve;

import java.util.*;

class GodricsMedievalStore  {
    private String name;
    private Map<String, Double> items;

    // Construct store
    public GodricsMedievalStore(String name) {
        this.name = name;
        this.items = new HashMap<>();
    }

    // get name
    public String getName() {
        return name;
    }

    // Construct item with price
    public void addItem(String item, Double price) {
        items.put(item, price);
    }

    // display items depends on store
    public Map<String, Double> getItems() {
        return items;
    }

    // remove item from store when buying
    public void removeItem(String item) {
        items.remove(item);
    }

}
