package pl.dobblepolskab.gui.events;

import gamecontent.DifficultyLevel;
import javafx.event.Event;
import javafx.event.EventType;

public class GameStartedEvent extends Event {
    public static final EventType<GameStartedEvent> SINGLEPLAYER_STARTED_EVENT_TYPE = new EventType<>("SingleplayerStartedEvent");
    public static final EventType<GameStartedEvent> MULTIPLAYER_STARTED_EVENT_TYPE = new EventType<>("MultiplayerStartedEvent");

    private DifficultyLevel level;
    private int botsCount;
    private int duration;

    public GameStartedEvent(EventType<? extends Event> eventType, DifficultyLevel level) {
        super(eventType);

        this.level = level;
    }

    public GameStartedEvent(EventType<? extends Event> eventType, DifficultyLevel level, int botsCount, int duration) {
        super(eventType);

        this.level = level;
        this.botsCount = botsCount;
        this.duration = duration;
    }

    public DifficultyLevel getDifficultyLevel() {
        return level;
    }

    public int getBotsCount() {
        return botsCount;
    }

    public int getDuration() {
        return duration;
    }
}
