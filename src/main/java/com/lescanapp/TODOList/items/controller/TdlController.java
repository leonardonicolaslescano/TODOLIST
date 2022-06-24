package com.lescanapp.TODOList.items.controller;

import com.lescanapp.TODOList.items.event.ItemChangeStatusEvent;
import com.lescanapp.TODOList.items.model.Item;
import com.lescanapp.TODOList.items.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TdlController {

    private final IItemService itemService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private ItemEventsBus itemEventsBus;

    public TdlController(IItemService itemService) {this.itemService=itemService;}


    @GetMapping({"/", "/TdlView"})
    public String start (Model model) {
        var item = new Item();
        model.addAttribute("item", item);
        if(itemService.findAll() != null) {
            model.addAttribute("listItems", itemService.findAllIncomplete());
            model.addAttribute("listItemsComplete", itemService.findAllComplete());
        }
        return "TdlView";
    }

    @RequestMapping("itemStatusChange/{id}/{complete}")
    private String itemStatusChange(@PathVariable(value = "id") long id, @PathVariable(value = "complete") boolean complete) {
        eventPublisher.publishEvent(new ItemChangeStatusEvent(id, complete));
        return "redirect:/TdlView";
    }

    @RequestMapping("add")
    public String add(Item item) {
        itemService.save(item);
        return "redirect:/TdlView";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        itemService.delete(id);
        return "redirect:/TdlView";
    }



}
