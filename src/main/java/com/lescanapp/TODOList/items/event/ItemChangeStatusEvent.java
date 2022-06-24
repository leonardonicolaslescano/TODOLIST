package com.lescanapp.TODOList.items.event;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
@Getter
@Setter
public class ItemChangeStatusEvent {
    long id;
    boolean complete;

    public ItemChangeStatusEvent(long id, boolean complete) {
        this.id = id;
        this.complete = complete;
    }
}
