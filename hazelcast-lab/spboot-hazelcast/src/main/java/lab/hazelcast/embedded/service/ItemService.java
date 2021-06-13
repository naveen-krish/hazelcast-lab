package lab.hazelcast.embedded.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lab.hazelcast.embedded.entities.Item;
import lab.hazelcast.embedded.entities.ItemRepository;

@Service
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> items() {
        return itemRepository.findAll();
    }

    @Cacheable(value = "items", key = "#id")
    public Item getItem(Integer id) {

        /*
         * try { Thread.sleep(5000); } catch (InterruptedException e) {
         * e.printStackTrace(); }
         */
        // Item item = itemRepository.findById(id).orElseThrow(RuntimeException::new);
        Item item = new Item();
        item.setId(1);
        item.setPrice(BigDecimal.valueOf(28.99));
        item.setProductName("SampleItem");

        logger.info("Loading data from DB {}", item);
        return item;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @CacheEvict(value = "items", key = "#id")
    public Item updateItem(Integer id, Item request) {
        Item item = getItem(id);
        item.setPrice(request.getPrice());
        item.setProductName(request.getProductName());
        return itemRepository.save(item);
    }
}