enum CrewRank {
    CADET, OFFICER, COMMANDER, CAPTAIN, ADMIRAL
}

class SpaceCrew {
    private final String crewId;
    private final String homePlanet;
    private final CrewRank initialRank;
    private CrewRank currentRank;
    private int missionCount;
    private int skillLevel;
    private static final String STATION_NAME = "Stellar Odyssey";

    public SpaceCrew() {
        this("Unknown", CrewRank.CADET, 0, 1);
    }

    public SpaceCrew(String homePlanet, CrewRank rank) {
        this(homePlanet, rank, 0, 1);
    }

    public SpaceCrew(String homePlanet, CrewRank rank, int missions, int skill) {
        this.crewId = "CREW-" + (int)(Math.random() * 1000);
        this.homePlanet = homePlanet;
        this.initialRank = rank;
        this.currentRank = rank;
        this.missionCount = missions;
        this.skillLevel = skill;
    }

    public final String getCrewIdentification() {
        return crewId + " from " + homePlanet;
    }

    public final boolean canBePromoted() {
        return currentRank != CrewRank.ADMIRAL;
    }

    public void promote() {
        if (canBePromoted()) {
            currentRank = CrewRank.values()[currentRank.ordinal() + 1];
            System.out.println(crewId + " promoted to " + currentRank);
        } else {
            System.out.println(crewId + " cannot be promoted further.");
        }
    }

    public void displayStatus() {
        System.out.printf("ID: %s | Home: %s | Rank: %s | Missions: %d | Skill: %d%n",
                crewId, homePlanet, currentRank, missionCount, skillLevel);
    }

    public static void main(String[] args) {
        SpaceCrew c1 = new SpaceCrew("Earth", CrewRank.CADET);
        SpaceCrew c2 = new SpaceCrew("Mars", CrewRank.OFFICER, 5, 10);

        c1.displayStatus();
        c2.displayStatus();
        c1.promote();
        c2.promote();
    }
}
