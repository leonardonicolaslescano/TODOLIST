package com.lescanapp.TODOList.items.service;

import com.lescanapp.TODOList.items.event.ItemChangeStatusEvent;
import com.lescanapp.TODOList.items.model.Item;
import com.lescanapp.TODOList.items.repo.ItemRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemService implements IItemService{
    @Autowired
    private final ItemRepo itemRepo;


    public ItemService(ItemRepo itemRepo){
        this.itemRepo=itemRepo;
    }


    public List<Item> findAll(){return (List<Item>) itemRepo.findAll();}
    public List<Item> findAllComplete(){return (List<Item>) itemRepo.getCompletedItems();}
    public List<Item> findAllIncomplete(){return (List<Item>) itemRepo.getIncompletedItems();}

    @EventListener(ItemChangeStatusEvent.class)
    private void itemChangeStatus(ItemChangeStatusEvent event) {
        itemRepo.setItemComplete(event.getId(), event.isComplete());
    }

    public void save(Item item) {itemRepo.save(item);}

    public void delete(Long id) {itemRepo.delete(id);}

}
