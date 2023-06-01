package user.domain.common;

public enum UserType {
    OTAKU("OTAKU"),
    SAD("sad"),
    FUN("fun"),
    ANGRY("angry");

    private final String value;

    public String getValue() {
        return value;
    }

    UserType(String value) {
        this.value = value;
    }
}
