package Assignment7.Q1;
import Assignment7.Q1.Enums.*;

public class CharacterProps {
    private Font font;
    private Color color;
    private Size size;

    public CharacterProps(Font font, Color color, Size size) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return font.toString() + size.toString() + color.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CharacterProps) {
            CharacterProps other = (CharacterProps) obj;
            return font.equals(other.font) && size == other.size && color.equals(other.color);
        }
        return false;
    }
}