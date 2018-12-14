package com.java.messageReceiver;

import com.java.message.Message;

import java.util.ArrayList;
import java.util.List;

public class messageReceiver {


        private static List<Message> messageList ;

        private Message message;


        public messageReceiver(Message message){
            if(messageList == null){
                messageList = new ArrayList<Message>();
            }
            this.message = message;
            addMessage(message);
        }

        public static void addMessage(Message message){
            if(message != null){
                messageList.add(message);
            }
            int count=messageList.size();
        }


    }


