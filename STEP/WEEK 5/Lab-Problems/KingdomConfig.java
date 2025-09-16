import java.util.*;

final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final Map<String, Integer> resourceLimits;

    public KingdomConfig(String kingdomName, int foundingYear, String[] allowedStructureTypes, Map<String, Integer> resourceLimits) {
        if (kingdomName == null || kingdomName.isEmpty()) throw new IllegalArgumentException("kingdomName cannot be null or empty");
        if (foundingYear <= 0) throw new IllegalArgumentException("foundingYear must be positive");
        if (allowedStructureTypes == null || allowedStructureTypes.length == 0) throw new IllegalArgumentException("allowedStructureTypes cannot be null or empty");
        if (resourceLimits == null) throw new IllegalArgumentException("resourceLimits cannot be null");

        this.kingdomName = kingdomName;
        this.foundingYear = foundingYear;

        this.allowedStructureTypes = allowedStructureTypes.clone(); // defensive copy
        this.resourceLimits = Collections.unmodifiableMap(new HashMap<>(resourceLimits));
    }

    public String getKingdomName() {
        return kingdomName;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public String[] getAllowedStructureTypes() {
        return allowedStructureTypes.clone();
    }

    public Map<String, Integer> getResourceLimits() {
        return resourceLimits;
    }

    public static KingdomConfig createDefaultKingdom() {
        String[] types = {"WizardTower", "EnchantedCastle", "MysticLibrary", "DragonLair"};
        Map<String, Integer> limits = new HashMap<>();
        limits.put("gold", 10000);
        limits.put("mana", 5000);
        return new KingdomConfig("DefaultKingdom", 1200, types, limits);
    }

    public static KingdomConfig createFromTemplate(String type) {
        switch(type.toLowerCase()) {
            case "royal":
                return new KingdomConfig("RoyalKingdom", 1500, new String[]{"EnchantedCastle", "MysticLibrary"}, Map.of("gold", 20000, "mana", 8000));
            case "wild":
                return new KingdomConfig("Wildlands", 1000, new String[]{"WizardTower", "DragonLair"}, Map.of("gold", 5000, "mana", 2000));
            default:
                return createDefaultKingdom();
        }
    }
}
