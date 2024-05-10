public class RangedWeapon extends Weapon{

    public RangedWeapon(String name, String description, int shortsLeft, int rangedDamage){
        super(name, description, shortsLeft, rangedDamage);
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int durationUses() {
        return 0;
    }
}
