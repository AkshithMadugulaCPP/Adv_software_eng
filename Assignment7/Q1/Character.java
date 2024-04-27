package Assignment7.Q1;

public class Character {
    private final char character;
    private final CharacterProps properties;

    public Character(char character, CharacterProps properties) {
        this.character = character;
        this.properties = properties;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterProps getProperties() {
        return properties;
    }

    public String getCharacterInfo() {
        return String.format("Character: %c, Font: %s, Size: %s, Color: %s", character, properties.getFont(), properties.getSize(), properties.getColor());
    }
}