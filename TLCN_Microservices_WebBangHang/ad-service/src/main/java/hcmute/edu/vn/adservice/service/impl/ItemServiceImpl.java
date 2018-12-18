package hcmute.edu.vn.adservice.service.impl;

import hcmute.edu.vn.adservice.exception.NotFoundException;
import hcmute.edu.vn.adservice.api.v1.dto.ItemDTO;
import hcmute.edu.vn.adservice.api.v1.mapper.ItemMapper;
import hcmute.edu.vn.adservice.model.Items;
import hcmute.edu.vn.adservice.repository.ItemRepository;
import hcmute.edu.vn.adservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public ItemDTO findById(int id, int status) {
        Optional<Items> items = itemRepository.findByIdAndStatus(id,status);
        if(!items.isPresent())
            throw new NotFoundException("Item Not Found !!!");
        return items.map(itemMapper::ItemToItemDTO).get();
    }

    @Override
    public Items findById(int id) {
        Optional<Items> items = itemRepository.findById(id);
        if(!items.isPresent())
            throw new NotFoundException("Item Not Found !!!");
        return items.get();
    }

    @Override
    public Items dtoToItem(ItemDTO itemDTO){
        Items items = new Items();
        items.setId(itemDTO.getId());
        items.setName(itemDTO.getName());
        items.setStatus(itemDTO.getStatus());
        items.setPrice(itemDTO.getPrice());
        items.setDescription(itemDTO.getDescription());
        return items;
    }

    @Override
    public Items updateItem(ItemDTO itemDTO,int id){
        Items update = itemRepository.findById(id).get();
        update.setName(itemDTO.getName());
        update.setStatus(itemDTO.getStatus());
        update.setPrice(itemDTO.getPrice());
        update.setDescription(itemDTO.getDescription());
        return update;
    }

    @Override
    public Items saveItem(Items items) {
        return itemRepository.save(items);
    }

    @Override
    public Items deleteItem(int id,int status) {
        Items deleteItem = itemRepository.findById(id).get();
        deleteItem.setStatus(status);
        return itemRepository.save(deleteItem);
    }

    @Override
    public List<Items> findAll(int status) {
        return itemRepository.findAll();
    }
}
