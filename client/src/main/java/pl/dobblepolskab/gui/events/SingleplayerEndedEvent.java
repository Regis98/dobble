package pl.dobblepolskab.gui.events;

import javafx.event.Event;
import javafx.event.EventType;
import gamecontent.DifficultyLevel;

public class SingleplayerEndedEvent extends Event {
    public static final EventType<SingleplayerEndedEvent> SINGLEPLAYER_ENDED_EVENT_TYPE = new EventType<>("SingleplayerEndedEvent");

    private DifficultyLevel level;
    private long score;

    public SingleplayerEndedEvent(EventType<? extends Event> eventType, DifficultyLevel level, long score) {
        super(eventType);

        this.level = level;
        this.score = score;
    }

    public DifficultyLevel getDifficultyLevel() {
        return level;
    }

    public long getScore() {
        return score;
    }
}
