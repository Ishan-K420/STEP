import java.time.LocalDateTime;
import java.util.*;

public class SecureConfiguration {
    public static final String APPLICATION_NAME = "MyApp";
    public static final String VERSION = "1.0.0";
    public static final int MAX_CONNECTIONS = 100;
    public static final long DEFAULT_TIMEOUT = 3000;

    private final String configId;
    private final LocalDateTime creationTime;
    private final Set<String> allowedOperations;

    private final Map<String, String> serverSettings;
    private final List<String> userPermissions;
    private final Properties securityRules;

    private final byte[] encryptedData;
    private final long checksum;

    public SecureConfiguration(String configId, Set<String> allowedOperations,
                               Map<String, String> serverSettings, List<String> userPermissions,
                               Properties securityRules, byte[] encryptedData) {
        this.configId = configId;
        this.creationTime = LocalDateTime.now();
        this.allowedOperations = new HashSet<>(allowedOperations);
        this.serverSettings = new HashMap<>(serverSettings);
        this.userPermissions = new ArrayList<>(userPermissions);
        this.securityRules = new Properties();
        this.securityRules.putAll(securityRules);
        this.encryptedData = encryptedData.clone();
        this.checksum = calculateChecksum();
    }

    private long calculateChecksum() {
        return Arrays.hashCode(encryptedData)
                + serverSettings.hashCode()
                + userPermissions.hashCode()
                + allowedOperations.hashCode();
    }

    public String getConfigId() {
        return configId;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Set<String> getAllowedOperations() {
        return new HashSet<>(allowedOperations);
    }

    public Map<String, String> getServerSettings() {
        return new HashMap<>(serverSettings);
    }

    public List<String> getUserPermissions() {
        return new ArrayList<>(userPermissions);
    }

    public Properties getSecurityRules() {
        Properties copy = new Properties();
        copy.putAll(securityRules);
        return copy;
    }

    public boolean isValid() {
        return checksum == calculateChecksum();
    }

    public long getConfigAge() {
        return java.time.Duration.between(creationTime, LocalDateTime.now()).toMinutes();
    }

    public boolean hasPermission(String permission) {
        return userPermissions.contains(permission);
    }

    public String getSettingValue(String key, String defaultValue) {
        return serverSettings.getOrDefault(key, defaultValue);
    }

    public boolean addUserPermission(String permission) {
        if (!userPermissions.contains(permission)) {
            userPermissions.add(permission);
            return true;
        }
        return false;
    }

    public boolean removeUserPermission(String permission) {
        return userPermissions.remove(permission);
    }

    public void updateServerSetting(String key, String value) {
        serverSettings.put(key, value);
    }

    public void addSecurityRule(String rule, String value) {
        securityRules.setProperty(rule, value);
    }

    public static void main(String[] args) {
        Map<String, String> settings = new HashMap<>();
        settings.put("host", "localhost");
        settings.put("port", "8080");

        List<String> permissions = new ArrayList<>(Arrays.asList("READ", "WRITE", "DELETE"));
        Set<String> allowedOps = new HashSet<>(Arrays.asList("backup", "restore"));
        Properties rules = new Properties();
        rules.setProperty("rule1", "enabled");

        byte[] encryptedData = new byte[] {1, 2, 3};

        SecureConfiguration config = new SecureConfiguration("config1", allowedOps, settings, permissions, rules, encryptedData);

        System.out.println(config.getConfigId());
        System.out.println(config.getCreationTime());
        System.out.println(config.getSettingValue("host", "defaultHost"));
        System.out.println(config.hasPermission("WRITE"));
        System.out.println(config.isValid());
    }
}
