package com.setec.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.Data;

@Service
@Data
public class MyTelegramBot {
    @Value("${token_bot}")
    private String token_bot;
    @Value("${chat_id}")
    private long chat_id;
    
    private TelegramBot bot;
    
    public SendResponse send(String message) {
        if (bot == null) {
            bot = new TelegramBot(token_bot);
        }
        
        SendResponse sendMessage =
        		bot.execute(new SendMessage(chat_id, message));

        return sendMessage;
    }
}
