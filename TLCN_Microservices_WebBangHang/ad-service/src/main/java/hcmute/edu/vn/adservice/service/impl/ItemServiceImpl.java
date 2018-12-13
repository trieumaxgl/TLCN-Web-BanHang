package hcmute.edu.vn.adservice.service.impl;

import hcmute.edu.vn.adservice.api.v1.dto.ItemDTO;
import hcmute.edu.vn.adservice.api.v1.mapper.ItemMapper;
import hcmute.edu.vn.adservice.model.Items;
import hcmute.edu.vn.adservice.repository.ItemRepository;
import hcmute.edu.vn.adservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public ItemDTO findById(int id, int status) {
        return itemRepository.findByIdAndStatus(id, status)
                .map(itemMapper::ItemToItemDTO).get();
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
