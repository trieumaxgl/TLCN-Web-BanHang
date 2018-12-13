package hcmute.edu.vn.adservice.controller;

import hcmute.edu.vn.adservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.adservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.adservice.api.v1.dto.ItemDTO;
import hcmute.edu.vn.adservice.api.v1.mapper.ItemMapper;
import hcmute.edu.vn.adservice.model.Items;
import hcmute.edu.vn.adservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    ItemMapper itemMapper;

    @GetMapping
    public DataReturnList<ItemDTO> getAllItems() {

        //get all product was not deleted
        DataReturnList<ItemDTO> dataReturnList = new DataReturnList<>();
        dataReturnList.setMessage("get all items");
        dataReturnList.setData(itemService.findAll(0)
                .stream()
                .map(itemMapper::ItemToItemDTO)
                .collect(Collectors.toList()));

        return dataReturnList;
    }

    @GetMapping("/{id}")
    public DataReturnOne<ItemDTO> getItem(@PathVariable(value = "id") int id){
        //get all product was not deleted
        DataReturnOne<ItemDTO> returnOne = new DataReturnOne<>();
        returnOne.setMessage("get item");
        returnOne.setData(itemService.findById(id, 0));

        return returnOne;
    }

    @PostMapping
    public ResponseEntity<Object> createItem(@RequestBody Items items) {
        Items saveItem = itemService.saveItem(items);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        saveItem.getId()
                ).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping()
    public ResponseEntity<Object> updateItem(Items items) {
        return ResponseEntity.ok(itemService.saveItem(items));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMajor(@PathVariable(value = "id") int id){

        //set delflag was deleted
        return ResponseEntity.ok(itemService.deleteItem(id, 1));
    }
}
