public abstract class Weapon extends Item {
    private int remainingUses;
    private int damage;

    public Weapon(String name, String description, int remainingUses, int damage){
        super(name, description);
        this.remainingUses = remainingUses;
        this.damage = damage;
    }

    public abstract int attack();

    public abstract int durationUses();

    public int getDamage(){
        return damage;
    }

}
