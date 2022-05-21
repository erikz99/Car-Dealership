package bg.fmi.web.development.car.dealership.model;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return "ROLE_" + this.name;
    }
}
