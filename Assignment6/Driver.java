package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Iterator;

public class Driver {

    public static void main(String[] args){

        ChatServer mediator = new ChatServer();
        User Akshith = new User(mediator, "Akshith");
        User Ruchitha = new User(mediator, "Ruchitha");
        User Meghana = new User(mediator, "Meghana");
        mediator.registerUser(Akshith);
        mediator.registerUser(Ruchitha);
        mediator.registerUser(Meghana);

        System.out.println();
        System.out.println("---------------------------------MESSAGING-----------------------------------------------");
        // 1 Users can send messages to one or more other users through the chat server.
        Akshith.send(new ArrayList<User>(Arrays.asList(Ruchitha)), "Hello Ruchitha it's Akshith!");

        Akshith.send(new ArrayList<User>(Arrays.asList(Meghana)), "Hello Meghana it's Akshith!");

        // message to multiple ppl
        Ruchitha.send(new ArrayList<User>(Arrays.asList(Akshith, Meghana)), "Hello Akshith and Meghana it's Ruchitha!");

        Meghana.send(new ArrayList<User>(Arrays.asList(Akshith)), "Hello Akshith, How are you doing ?");

        Akshith.send(new ArrayList<User>(Arrays.asList(Meghana)), "Iam doing great!");

        System.out.println("---------------------------UNDO--------------------------------------------------");

        // 2  Users can undo the last message they sent using the Memento design pattern.
        System.out.println("Current last message for Akshith is :-");
        System.out.println(Akshith.getLastMessageSent());
        System.out.println("After deleting last message, Current last message for Akshith is :-");
        Akshith.undoLastMessageSent();
        System.out.println(Akshith.getLastMessageSent());
        System.out.println("------------------------------BLOCK--------------------------------------------------");
        // 3 Users can block messages from specific users using the Mediator design pattern.
        Akshith.blockUser(Meghana);
        Meghana.send(new ArrayList<User>(Arrays.asList(Akshith)), "Did you just block me ?");
        System.out.println("-----------------------------CHAT HISTORY------------------------------------------------------");

        // 4  Users can receive messages from other users and view the chat history for a specific user.
        Iterator searchAHistoryForC = Akshith.iterator(Ruchitha);
        while(searchAHistoryForC.hasNext()){
            System.out.println(searchAHistoryForC.next());
        }

    }

}