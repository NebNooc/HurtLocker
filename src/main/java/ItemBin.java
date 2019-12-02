import java.util.ArrayList;

public class ItemBin {

    private ArrayList<Item> itemBin;

    public ItemBin() {
        itemBin = new ArrayList<>();
    }

    public ArrayList<Item> getItemBin() {
        return itemBin;
    }

    public void addToItemBin(Item item) {
        itemBin.add(item);
    }
}
