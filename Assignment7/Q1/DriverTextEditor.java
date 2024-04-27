package Assignment7.Q1;
import Assignment7.Q1.Enums.*;

public class DriverTextEditor {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.addCharacter('H', Font.ARIAL, Size.SIZE_12, Color.BLACK);
        doc.addCharacter('e', Font.ARIAL, Size.SIZE_12, Color.BLACK);
        doc.addCharacter('l', Font.VERDANA, Size.SIZE_16, Color.RED);
        doc.addCharacter('l', Font.VERDANA, Size.SIZE_16, Color.RED);
        doc.addCharacter('o', Font.CALIBRI, Size.SIZE_14, Color.BLUE);
        doc.addCharacter('W', Font.ARIAL, Size.SIZE_12, Color.BLACK);
        doc.addCharacter('o', Font.CALIBRI, Size.SIZE_14, Color.BLUE);
        doc.addCharacter('r', Font.ARIAL, Size.SIZE_12, Color.BLACK);
        doc.addCharacter('l', Font.VERDANA, Size.SIZE_16, Color.RED);
        doc.addCharacter('d', Font.ARIAL, Size.SIZE_12, Color.BLACK);
        doc.addCharacter('C', Font.ARIAL, Size.SIZE_12, Color.BLACK);
        doc.addCharacter('S', Font.ARIAL, Size.SIZE_12, Color.BLACK);
        doc.addCharacter('5', Font.CALIBRI, Size.SIZE_14, Color.RED);
        doc.addCharacter('8', Font.CALIBRI, Size.SIZE_16, Color.RED);
        doc.addCharacter('0', Font.CALIBRI, Size.SIZE_16, Color.BLUE);
        doc.addCharacter('0', Font.CALIBRI, Size.SIZE_14, Color.BLUE);

        // Print the document content
        System.out.println("Document Content:");
        System.out.println(doc.getContent());


        // Save the document to a file
        String filename = "document.txt";
        doc.saveToFile(filename);
        System.out.println("Document saved to file: " + filename);

        // Load the document from the file into a new Document object
        Document loadedDoc = new Document();
        loadedDoc.loadFromFile(filename);

        // Update the font of an existing character (e.g., change font of 'l' to calibri) Call the method to update the character properties
        loadedDoc.updateCharacterProperties('l', Font.CALIBRI, Size.SIZE_14, Color.RED);

        // Add a new character with the updated font
        char newChar = '!';
        loadedDoc.addCharacter(newChar, Font.CALIBRI, Size.SIZE_16, Color.BLUE);

        // Print the document content after updating the character properties
        System.out.println("\nDocument Content After Updating Character Properties:");
        System.out.println(loadedDoc.getContent());

        // Save the updated document back to the file
        loadedDoc.saveToFile(filename);
        System.out.println("Updated document saved to file: " + filename);

    }
}
