package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Iterator;

public class Driver {

    public static void main(String[] args){

        ChatServer mediator = new ChatServer();
        User a = new User(mediator, "person1");
        User b = new User(mediator, "person2");
        User c = new User(mediator, "person3");
        mediator.registerUser(a);
        mediator.registerUser(b);
        mediator.registerUser(c);

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        // 1 Users can send messages to one or more other users through the chat server.
        Message aToB = new Message(
                a,
                new ArrayList<User>(Arrays.asList(b)),
                "Hello person2 it's person1!"
        );
        a.send(aToB);
        a.saveLastMessageSent(aToB);

        Message aToC = new Message(
                a,
                new ArrayList<User>(Arrays.asList(c)),
                "Hello person3 it's person1!"
        );
        a.send(aToC);
        a.saveLastMessageSent(aToC);

        // message to multiple ppl
        Message bToAC = new Message(
                b,
                new ArrayList<User>(Arrays.asList(a, c)),
                "Hello person1 and person3 it's person2!"
        );
        b.send(bToAC);
        b.saveLastMessageSent(bToAC);

        Message cToA = new Message(
                c,
                new ArrayList<User>(Arrays.asList(a)),
                "Hello person1, How are you doing ?"
        );
        c.send(cToA);
        c.saveLastMessageSent(cToA);

        Message aToC2 = new Message(
                a,
                new ArrayList<User>(Arrays.asList(c)),
                "Iam doing great!"
        );
        a.send(aToC2);

        System.out.println("--------------------------------------------------------------------------------------");

        // 2  Users can undo the last message they sent using the Memento design pattern.
        System.out.println("Current last message is :-");
        System.out.println(a.getLastMessageSent());
        System.out.println("After deleting last message, Current last message is :-");
        a.undoLastMessageSent();
        System.out.println(a.getLastMessageSent());
        System.out.println("--------------------------------------------------------------------------------------");
        // 3 Users can block messages from specific users using the Mediator design pattern.
        a.blockUser(c);
        c.send(cToA);
        System.out.println("--------------------------------------------------------------------------------------");

        // 4  Users can receive messages from other users and view the chat history for a specific user.
        Iterator searchAHistoryForC = a.iterator(c);
        while(searchAHistoryForC.hasNext()){
            System.out.println(searchAHistoryForC.next());
        }

    }

}