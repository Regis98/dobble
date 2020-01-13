package websocket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import messages.responses.AmIWinnerResponse;
import messages.responses.InitResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.*;

import java.lang.reflect.Type;

public class CustomStompSessionHandler extends StompSessionHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(CustomStompSessionHandler.class);

    private String clientID;

    public CustomStompSessionHandler(String clientID) {
        this.clientID = clientID;
    }

    public String getClientID() {
        return clientID;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/topic/initReply-" + clientID, new InitStompFrameHandler());
        session.subscribe("/topic/nextTurnReply-" + clientID, new NextTurnStompFrameHandler());
    }

    @Override
    public void handleException(StompSession session,
                                StompCommand command,
                                StompHeaders headers,
                                byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        logger.error("Got an transport exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("Received : " + payload);
    }
}

class InitStompFrameHandler implements StompFrameHandler {
    private Logger logger = LoggerFactory.getLogger(InitStompFrameHandler.class);

    private NotifyService notifyService;

    /*public CustomStompFrameHandler(NotifyService notifyService) {
        this.notifyService = notifyService;
    }*/

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            logger.info("Received: {}", (String)payload);
            //InitResponse response = mapper.readValue((String)payload, InitResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class NextTurnStompFrameHandler implements StompFrameHandler {
    private Logger logger = LoggerFactory.getLogger(NextTurnStompFrameHandler.class);

    private NotifyService notifyService;

    /*public CustomStompFrameHandler(NotifyService notifyService) {
        this.notifyService = notifyService;
    }*/

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            logger.info("Received: {}", (String)payload);
            //AmIWinnerResponse amIWinnerResponse = mapper.readValue((String)payload, AmIWinnerResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}