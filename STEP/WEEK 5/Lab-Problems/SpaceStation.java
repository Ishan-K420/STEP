import java.util.*;

final class SecurityClearance {
    private final String clearanceId;
    private final String level;
    private final String[] authorizedSections;
    private final long expirationDate;

    public SecurityClearance(String id, String level, String[] sections, long expiration) {
        this.clearanceId = id;
        this.level = level;
        this.authorizedSections = sections.clone();
        this.expirationDate = expiration;
    }

    public boolean canAccess(String section) {
        return Arrays.asList(authorizedSections).contains(section);
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expirationDate;
    }
}

final class CrewRank {
    private final String rankName;
    private final int level;
    private final String[] permissions;

    private CrewRank(String rankName, int level, String[] permissions) {
        this.rankName = rankName;
        this.level = level;
        this.permissions = permissions.clone();
    }

    public static CrewRank createCadet() {
        return new CrewRank("Cadet", 1, new String[]{"Basic Access"});
    }

    public String getRankName() { return rankName; }
}

class SpaceCrew {
    private final String crewId;
    private final SecurityClearance clearance;
    private final CrewRank initialRank;
    private CrewRank currentRank;

    public SpaceCrew(String id, SecurityClearance clearance, CrewRank rank) {
        this.crewId = id;
        this.clearance = clearance;
        this.initialRank = rank;
        this.currentRank = rank;
    }

    public boolean canAccessSection(String section) {
        return clearance.canAccess(section) && !clearance.isExpired();
    }
}

public class SpaceStation {
    public static void main(String[] args) {
        SecurityClearance clearance = new SecurityClearance("SC-001", "High", new String[]{"Lab", "Control"}, System.currentTimeMillis() + 1_000_000);
        CrewRank cadet = CrewRank.createCadet();
        SpaceCrew crew = new SpaceCrew("Crew123", clearance, cadet);

        System.out.println("Access to Lab: " + crew.canAccessSection("Lab"));
        System.out.println("Access to Engine Room: " + crew.canAccessSection("Engine Room"));
    }
}
