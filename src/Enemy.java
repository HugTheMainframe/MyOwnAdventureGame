public class Enemy {
    private int health;
    private String name;
    private String description;
    private Item currentWeapon;

    public Enemy(String name, String description, int health, Item currentWeapon){
        this.name = name;
        this.description = description;
        this.health = health;
        this.currentWeapon = currentWeapon;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Item getCurrentWeapon(){
        return currentWeapon;
    }

    public void setCurrentWeapon(Item name){
        this.currentWeapon = currentWeapon;
    }

    @Override
    public String toString(){
        String enemyInfo = "";
        enemyInfo += name + ", " + description;
        return enemyInfo;
    }
}
