import java.util.ArrayList;

public class Room {
    private String roomName;
    private String roomDescription;
    private Room northConnection;
    private Room southConnection;
    private Room eastConnection;
    private Room westConnection;
    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies;

    public Room(String roomName, String roomDescription){
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.northConnection = null;
        this.southConnection = null;
        this.eastConnection = null;
        this.westConnection = null;
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public void setNorthConnection(Room room){
        this.northConnection = room;
    }

    public void setEastConnection(Room room){
        this.eastConnection = room;
    }

    public void setSouthConnection(Room room){
        this.southConnection = room;
    }

    public void setWestConnection(Room room){
        this.westConnection = room;
    }

    public Room getNorthConnection(){
        return northConnection;
    }

    public Room getSouthConnection(){
        return southConnection;
    }

    public Room getWestConnection(){
        return westConnection;
    }

    public Room getEastConnection() {
        return eastConnection;
    }

    public String getRoomName(){
        return roomName;
    }

    public String getRoomDescription(){
        return roomDescription;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void addItems(Item items){
        getItems().add(items);
    }
    public String getItemsInRoom(){
        String itemslist = "";
        for(Item itemsHere : items){
            itemslist += itemsHere.toString();
        }
        return itemslist;
    }
    public void removeItem(Item items){
        getItems().remove(items);
    }

    public void addEnemies(Enemy enemy){
        enemies.add(enemy);
    }

    public String getEnemiesInRoom(){
        String enemyList = "";
        for(Enemy ene : enemies){
            enemyList += ene.toString();
        }
        return enemyList;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
