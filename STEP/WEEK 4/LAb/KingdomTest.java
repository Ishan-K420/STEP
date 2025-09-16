abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    int spellCapacity;

    public WizardTower(String name, int power, String location, int spellCapacity) {
        super(name, power, location, true);
        this.spellCapacity = spellCapacity;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " casts a powerful spell with " + spellCapacity + " slots.");
    }
}

class EnchantedCastle extends MagicalStructure {
    int defenseRating;

    public EnchantedCastle(String name, int power, String location, int defenseRating) {
        super(name, power, location, true);
        this.defenseRating = defenseRating;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " raises defense shield with rating " + defenseRating + ".");
    }
}

public class KingdomTest {
    public static void main(String[] args) {
        MagicalStructure tower = new WizardTower("Merlin's Tower", 80, "Hilltop", 5);
        MagicalStructure castle = new EnchantedCastle("Royal Castle", 50, "Valley", 100);

        tower.castMagicSpell();
        castle.castMagicSpell();

        if (tower instanceof WizardTower && castle instanceof EnchantedCastle) {
            System.out.println("Special Effect: Dragon Guard activated!");
        }
    }
}