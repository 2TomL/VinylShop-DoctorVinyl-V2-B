package be.doctorvinylrecords.model;

public enum Category {
    DEEP_HOUSE("Deep House"),
    TECH_HOUSE("Tech House"),
    PROGRESSIVE_HOUSE("Progressive House"),
    ELECTRO_HOUSE("Electro House"),

    DETROIT_TECHNO("Detroit Techno"),
    MINIMAL_TECHNO("Minimal Techno"),
    ACID_TECHNO("Acid Techno"),

    TRANCE("Trance"),
    PROGRESSIVE_TRANCE("Progressive Trance"),

    DRUM_AND_BASS("Drum and Bass"),
    JUNGLE("Jungle"),
    NU_SKOOL_BREAKS("Nu Skool Breaks"),
    BIG_BEAT("Big Beat"),
    DUBSTEP("Dubstep"),

    HARDCORE("Hardcore"),

    AMBIENT("Ambient"),

    EXPERIMENTAL("Experimental");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}