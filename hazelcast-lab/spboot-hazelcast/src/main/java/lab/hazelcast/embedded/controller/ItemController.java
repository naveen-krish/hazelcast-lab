package lab.hazelcast.embedded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.hazelcast.embedded.entities.Item;
import lab.hazelcast.embedded.service.ItemService;

@RestController
@RequestMapping(path = "/items/")
public class ItemController {

    @Autowired
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Integer id) {
        return itemService.getItem(id);
    }

    @PostMapping("/")
    public Item createItem(@RequestBody Item request) {
        return itemService.createItem(request);
    }

    @PutMapping("/{id}")
    public Item createItem(@PathVariable Integer id, @RequestBody Item request) {
        return itemService.updateItem(id, request);
    }
}