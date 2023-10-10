package lab4.bicycle.model;

/**
 * Permission класс
 */
public enum Permission {

    BICYCLES_READ("bicycles:read"),
    BICYCLES_WRITE("bicycles:write");

    private final String permission;

    /**
     * Конструктор для Permission
     *
     * @param permission permission
     */
    Permission(String permission) {
        this.permission = permission;
    }

    /**
     * Getter permission
     *
     * @return permission
     */
    public String getPermission() {
        return permission;
    }
}
