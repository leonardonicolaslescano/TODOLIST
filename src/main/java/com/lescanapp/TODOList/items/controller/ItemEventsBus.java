package com.lescanapp.TODOList.items.controller;

import com.lescanapp.TODOList.items.event.ItemChangeStatusEvent;

import java.util.function.Consumer;

public interface ItemEventsBus {

    void subscribe(Consumer<ItemChangeStatusEvent> itemCompleteEventConsumer);

    void publish(ItemChangeStatusEvent itemChangeStatusEvent);

}
