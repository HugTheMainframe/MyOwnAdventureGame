import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int health;
    private Item currentWeapon;

    public Player(Room startingRoom){
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
        this.health = 100;
        this.currentWeapon = null;
    }

    public String goNorth() {
        if (currentRoom.getNorthConnection() != null) {
            currentRoom = currentRoom.getNorthConnection();
            return getRoomNameAndDescription();
        }
        return "There is no room that way...";
    }

    public String goSouth(){
        if(currentRoom.getSouthConnection() != null) {
            currentRoom = currentRoom.getSouthConnection();
            return getRoomNameAndDescription();
        }
        return "There is no room that way...";
    }

    public String goEast(){
        if(currentRoom.getEastConnection() != null) {
            currentRoom = currentRoom.getEastConnection();
            return getRoomNameAndDescription();
        }
        return "There is no room that way...";
    }

    public String goWest(){
        if(currentRoom.getWestConnection() != null) {
            currentRoom = currentRoom.getWestConnection();
            return getRoomNameAndDescription();
        }
        return "There is no room that way...";
    }

    public String getRoomNameAndDescription(){
        String roomInfo = "";
        roomInfo += currentRoom.getRoomName() + currentRoom.getRoomDescription();
        if(!currentRoom.getItems().isEmpty()){
            roomInfo += "\nItems:" + currentRoom.getItemsInRoom();
        }
        if(!currentRoom.getEnemies().isEmpty()){
            roomInfo += "\nEnemies! Prepare yourself:\n" + currentRoom.getEnemiesInRoom();
        }
        return roomInfo;
    }

    public void takeItem(String itemName){
        for(Item item : currentRoom.getItems()){
            if(item.getName().equalsIgnoreCase(itemName.toLowerCase())){
                inventory.add(item);
                currentRoom.removeItem(item);
                return;
            }
        }
    }

    public void dropItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName.toLowerCase())) {
                currentRoom.addItems(item);
                inventory.remove(item);
                return;
            }
        }
    }

    public String showInventory(){
        String inv = "";
        for(Item item : inventory){
            inv += item.toString();
        }
        if(currentWeapon != null) {
            inv += "\nyour current equipped weapon: " + currentWeapon;
        }
        return inv;
    }

    public void eat(String name){
        for (Item item : currentRoom.getItems()){
          if(item.getName().equalsIgnoreCase(name.toLowerCase())){
              if(item instanceof Food){
                  setHealth(((Food) item).getHealth());
                  currentRoom.removeItem(item);
                  return;
              } else {
                  System.out.println("Item not edible...");
              }
          }
        }
        for (Item item : inventory){
            if(item.getName().equalsIgnoreCase(name.toLowerCase())){
                if(item instanceof Food){
                    setHealth(((Food) item).getHealth());
                    inventory.remove(item);
                    return;
                } else {
                    System.out.println("Item not edible...");
                }
            }
        }
    }

    public void equipWeapon(String name){
        for(Item weap : inventory){
            if(weap.getName().equalsIgnoreCase(name.toLowerCase())){
                if(weap instanceof Weapon){
                    if(currentWeapon == null) {
                        currentWeapon = weap;
                        inventory.remove(weap);
                        System.out.println("You have equipped: " + weap);
                        return;
                    } else {
                        inventory.add(currentWeapon);
                        currentWeapon = weap;
                        inventory.remove(weap);
                        System.out.println("You have equipped; " + weap);
                        return;
                    }
                } else {
                    System.out.println("Item not a weapon");
                }
            }
        }
    }

    public void attack(String enemy){
            if(currentWeapon instanceof Weapon){
                Weapon playerWeapon = (Weapon) currentWeapon;
                int damage = playerWeapon.attack();
                if(!currentRoom.getEnemiesInRoom().isEmpty()) {
                    for(Enemy target : currentRoom.getEnemies()){
                        if(target.getName().equalsIgnoreCase(enemy.toLowerCase())){
                            System.out.println("You attack " + target.getName() + " with " + damage);
                            target.setHealth(-damage);
                            System.out.println("Enemy health now " + target.getHealth());
                            if(target.getHealth() < 0){
                                System.out.println("Your slayed the enemy");
                                Item enemybody = new Item("dead" + target.getName(), "slayed");
                                currentRoom.addItems(target.getCurrentWeapon());
                                System.out.println("enemy dropped" + target.getCurrentWeapon());
                                currentRoom.addItems(enemybody);
                                currentRoom.removeEnemies(target);
                                return;
                            } else {
                                Weapon enemyWeapon = (Weapon) target.getCurrentWeapon();
                                int enemyDamage = enemyWeapon.attack();
                                System.out.println("Enemy " + target.getName() + " attacks you with " + enemyDamage);
                                setHealth(-enemyDamage);
                                System.out.println("Your health now " + health);
                                return;
                            }
                        } else {
                            System.out.println("No enemy with that name...");
                        }
                    }
                } else {
                    System.out.println("you attack the air, why?!?!");
                }
            } else {
                System.out.println("You have no weapon equipped.");
            }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health += health;
    }
}
