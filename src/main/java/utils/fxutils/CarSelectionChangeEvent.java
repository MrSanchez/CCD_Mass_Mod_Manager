package utils.fxutils;

import javafx.event.Event;
import javafx.event.EventType;

public class CarSelectionChangeEvent extends Event
{
    public static EventType<CarSelectionChangeEvent> ON_CHANGE = new EventType<>("ON_CHANGE");

    public CarSelectionChangeEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
