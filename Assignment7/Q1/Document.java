package Assignment7.Q1;

import Assignment7.Q1.Enums.Color;
import Assignment7.Q1.Enums.Font;
import Assignment7.Q1.Enums.Size;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Document {
    private List<Character> characters = new ArrayList<>();
    private Map<String, CharacterProps> propsMap = new HashMap<>();

    public void addCharacter(char c, Font font, Size size, Color color) {
        // Create a CharacterProps object with the provided font, size, and color
        CharacterProps props = new CharacterProps(font, color, size);

        // Check if the propsMap already contains the CharacterProps object
        if (!propsMap.containsValue(props)) {
            // If not, put the CharacterProps object into the map using its string representation as the key
            propsMap.put(props.toString(), props);
        }

        // Create a new Character object with the provided character and its associated CharacterProps
        Character character = new Character(c, props);

        // Add the Character object to the characters list
        characters.add(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }
    public String getContent() {
        StringBuilder content = new StringBuilder();
        for (Character character : characters) {
            content.append(character.getCharacterInfo()).append("\n");
        }
        return content.toString();
    }


    public String getCharacterPropInfo() {

        StringBuilder sb = new StringBuilder();

        sb.append("Total number of Character Props: ");
        sb.append(propsMap.size());
        sb.append("\n"); 

        for (String key : propsMap.keySet()) {
            sb.append(key);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character character : characters) {
                writer.write(character.getCharacter() + "," + character.getProperties().getFont() +
                        "," + character.getProperties().getSize() + "," + character.getProperties().getColor() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    char c = parts[0].charAt(0);
                    Font font = Font.valueOf(parts[1]);
                    Size size = Size.valueOf(parts[2]);
                    Color color = Color.valueOf(parts[3]);
                    addCharacter(c, font, size, color);
                } else {
                    System.out.println("Invalid line in file: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCharacterProperties(char characterToUpdate, Font newFont, Size newSize, Color newColor) {
        for (Character character : characters) {
            if (character.getCharacter() == characterToUpdate) {
                character.getProperties().setFont(newFont);
                character.getProperties().setSize(newSize);
                character.getProperties().setColor(newColor);
            }
        }
    }
}