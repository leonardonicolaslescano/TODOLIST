package com.lescanapp.TODOList.items.service;

import com.lescanapp.TODOList.items.model.Item;

import java.util.List;

public interface IItemService {
    List<Item> findAllIncomplete();
    List<Item> findAllComplete();
    List<Item> findAll();
    void save(Item item);

    void delete(Long id);


}
