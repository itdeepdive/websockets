package com.itdeepdive.user.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/websocketsubscriber")
	public void greeting(RequestMessage message) throws Exception {
		Thread.sleep(10); // simulated delay
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("hello", new String("Trilok"));
		messagingTemplate.convertAndSend("/topic/greetings", new ResponseMessage("Hello, " + message.getName() + "!"), headers);
	}

}
