public class Adventure {
    private Map map;
    private Player player;

    public Adventure(){
        this.map = new Map();
        this.player = new Player(map.getCurrentRoom());
    }

    public Player getPlayer() {
        return player;
    }

}
