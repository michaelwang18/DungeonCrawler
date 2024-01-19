public class Item {
    private String name;
    private String description;
    private int count;

    public Item(String name, String description, int count){
        this.name = name;
        this.description = description;
        this.count = count;
    }

    public void use(){
        count--;
    }

    public void gain(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
