package hcmute.edu.vn.nuservice.service.impl;

import hcmute.edu.vn.nuservice.exception.NotFoundException;
import hcmute.edu.vn.nuservice.model.Items;
import hcmute.edu.vn.nuservice.repository.ItemRepository;
import hcmute.edu.vn.nuservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Items findById(int id) {
        Optional<Items> item = itemRepository.findById(id);
        if(!item.isPresent())
            throw new NotFoundException("Product Not Found !!!");

        return item.get();
    }

    @Override
    public List<Items> findAllItems() {
        List<Items> items = itemRepository.findAll();
        if (items.isEmpty())
            throw new NotFoundException("Product is Empty !!!");
        return items;
    }
}
