package Assignment6;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatServer {
    
    private ArrayList<User> registeredUsers;
    private HashMap<User, ArrayList<User>> blockedUsers;

    public ChatServer(){
        this.registeredUsers = new ArrayList<User>();
        this.blockedUsers = new HashMap<User, ArrayList<User>>();
    }

    public void registerUser(User user){
        this.registeredUsers.add(user);
        if(!blockedUsers.containsKey(user)){
            blockedUsers.put(user, new ArrayList<User>());
        }
        System.out.println(user.getUserName() + " registered.");
    }

    public void unregisterUser(User user){
        this.registeredUsers.remove(user);
        if(blockedUsers.containsKey(user)){
            blockedUsers.remove(user);
        }
    }

    public boolean sendMessage(Message message){
        User sender = message.getSender();
        boolean success = true;
        ArrayList<User> recipients = message.getRecipients();
        for(User recipient: recipients){
            if(registeredUsers.contains(recipient)){
                if(!this.blockedUsers.get(recipient).contains(sender)){
                    System.out.println(
                        sender.getUserName() + " sent a message at ("
                        + message.getTimestamp() + ") to "
                        + recipient.getUserName() + " saying: "
                        + message.getMessageContent()
                    );
                    recipient.receiveMessage(message);
                }
                else{
                    System.out.println(
                        "Mediator blocked messages from " 
                        + sender.getUserName() + " to "
                        + recipient.getUserName() + "."
                    );
                    success =  false;
                }
            }
            else{
                System.out.println(
                    "\nMediator has not registered users to send messages from cannot send messages from "
                    + sender.getUserName() + " to "
                    + recipient.getUserName() + "."
                );
                success =  false;
            }
        }
        return success;

    }

    public void blockUser(User blocker, User blocked){
        ArrayList<User> blockedByBlocker = this.blockedUsers.get(blocker);
        blockedByBlocker.add(blocked);
    }

}
