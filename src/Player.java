import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;

    public Player(Room startingRoom){
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
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
        return currentRoom.getRoomName() + currentRoom.getRoomDescription() + "\nItems: " + currentRoom.getItemsInRoom();
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

    public void dropItem(String itemName){
        for(Item item : inventory){
            if (item.getName().equalsIgnoreCase(itemName.toLowerCase())){
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
        return inv;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
