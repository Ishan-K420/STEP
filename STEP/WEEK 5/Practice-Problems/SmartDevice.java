import java.time.LocalDateTime;
import java.util.UUID;

public class SmartDevice {
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;

    private String encryptionKeyHash;
    private String adminPasswordHash;

    private String deviceName;
    private boolean isEnabled;

    private final LocalDateTime startupTime;

    public SmartDevice(String deviceName) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now();
        this.serialNumber = UUID.randomUUID().toString();
        this.deviceName = deviceName;
        this.isEnabled = true;
        this.startupTime = LocalDateTime.now();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public LocalDateTime getManufacturingDate() {
        return manufacturingDate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public long getUptime() {
        return java.time.Duration.between(startupTime, LocalDateTime.now()).getSeconds();
    }

    public int getDeviceAge() {
        return LocalDateTime.now().getYear() - manufacturingDate.getYear();
    }

    public void setEncryptionKey(String key) {
        this.encryptionKeyHash = Integer.toString(key.hashCode());
    }

    public void setAdminPassword(String password) {
        this.adminPasswordHash = Integer.toString(password.hashCode());
    }

    public boolean validateEncryptionKey(String key) {
        return encryptionKeyHash != null && encryptionKeyHash.equals(Integer.toString(key.hashCode()));
    }

    public boolean validateAdminPassword(String password) {
        return adminPasswordHash != null && adminPasswordHash.equals(Integer.toString(password.hashCode()));
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String name) {
        this.deviceName = name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public void resetDevice() {
        encryptionKeyHash = null;
        adminPasswordHash = null;
    }

    public static void main(String[] args) {
        SmartDevice device = new SmartDevice("MyDevice");
        System.out.println(device.getDeviceId());
        System.out.println(device.getManufacturingDate());
        System.out.println(device.getSerialNumber());
        System.out.println(device.getUptime());
        System.out.println(device.getDeviceAge());

        device.setEncryptionKey("secureKey");
        device.setAdminPassword("adminPass");

        System.out.println(device.validateEncryptionKey("secureKey"));     // true
        System.out.println(device.validateAdminPassword("wrongPass"));     // false

        device.setDeviceName("My New Device");
        device.setEnabled(false);

        System.out.println(device.getDeviceName());
        System.out.println(device.isEnabled());

        device.resetDevice();
        System.out.println(device.validateEncryptionKey("secureKey"));     // false
    }
}
