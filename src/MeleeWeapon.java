public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String name, String description, int durability, int hitDamgage){
        super(name, description, durability,hitDamgage);
    }

    public int attack(){
        return super.getDamage();
    }

    @Override
    public int durationUses() {
        return 0;
    }
}
