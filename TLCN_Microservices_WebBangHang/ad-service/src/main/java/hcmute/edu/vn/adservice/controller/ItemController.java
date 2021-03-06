package hcmute.edu.vn.adservice.controller;

import hcmute.edu.vn.adservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.adservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.adservice.exception.NotFoundException;
import hcmute.edu.vn.adservice.api.v1.dto.Attach_FileDTO;
import hcmute.edu.vn.adservice.api.v1.dto.ItemDTO;
import hcmute.edu.vn.adservice.api.v1.mapper.ItemMapper;
import hcmute.edu.vn.adservice.model.Attach_File;
import hcmute.edu.vn.adservice.model.Items;
import hcmute.edu.vn.adservice.service.Attach_FileService;
import hcmute.edu.vn.adservice.service.ItemService;
import hcmute.edu.vn.adservice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/admin/items")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    Attach_FileService attach_fileService;
    @Autowired
    ItemMapper itemMapper;

    @Autowired
    TypeService typeService;

    @GetMapping("/load")
    public DataReturnList<ItemDTO> getAllItems() {

        //get all product was not deleted
        DataReturnList<ItemDTO> dataReturnList = new DataReturnList<>();
        dataReturnList.setMessage("get all items");
        dataReturnList.setData(itemService.findAll(1)
                .stream()
                .map(itemMapper::ItemToItemDTO)
                .collect(Collectors.toList()));

        return dataReturnList;
    }

    @GetMapping("/search")
    public DataReturnOne<ItemDTO> getItem(@RequestParam(required = false) int id){
        //get all product was not deleted
        DataReturnOne<ItemDTO> returnOne = new DataReturnOne<>();
        returnOne.setMessage("get item");
        returnOne.setData(itemService.findById(id, 1));

        return returnOne;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createItem(@RequestBody ItemDTO itemDTO) {
        Items items = itemService.dtoToItem(itemDTO);
        items.setTypes(typeService.findById(itemDTO.getTypesId(),1));
        itemService.saveItem(items);
        DataReturnOne<ItemDTO> returnOne = new DataReturnOne<>();

        try {
            returnOne.setMessage("Them thanh cong");
            returnOne.setSuccess("true");
            returnOne.setData(itemMapper.ItemToItemDTO(items));
        }
        catch (NotFoundException ex) {
            returnOne.setSuccess("false");
            returnOne.setMessage("Them that bai");
        }
        return ResponseEntity.ok(returnOne);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Object> updateItem(@RequestBody ItemDTO itemDTO,@PathVariable(value="id") int id) {
        Items items = itemService.updateItem(itemDTO,id);
        items.setTypes(typeService.findById(itemDTO.getTypesId(),1));
        return ResponseEntity.ok(itemService.saveItem(items));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(itemService.deleteItem(id,0));
    }
    @PostMapping("/image")
    public ResponseEntity<Object> createImage(@RequestBody Attach_FileDTO attachFileDTO) {
        Attach_File attachFile = attach_fileService.dtoToAttachFile(attachFileDTO);
        attachFile.setItems(itemService.findById(attachFileDTO.getItemId()));
        attach_fileService.saveAttachFile(attachFile);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(
                        attachFile.getId()
                ).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/getAttachFile")
    public  DataReturnList<Attach_FileDTO> getItemsByAttachFile(@RequestParam(required = false) int id){

        DataReturnList<Attach_FileDTO> dataReturnList = new DataReturnList<>();
        dataReturnList.setMessage("get all items");
        dataReturnList.setData(attach_fileService.findItemAttachFile(id));

        return dataReturnList;
    }
    @GetMapping("/getType")
    public  DataReturnList<ItemDTO> getItemByType(@RequestParam(required = false) int typesId){

        DataReturnList<ItemDTO> dataReturnList = new DataReturnList<>();
        dataReturnList.setMessage("get all items");
        dataReturnList.setData(itemService.findItemType(typesId));

        return dataReturnList;
    }
    @GetMapping("/getAllAttachFile")
    public  DataReturnList<Attach_FileDTO> getAllAttachFile(){

        DataReturnList<Attach_FileDTO> dataReturnList = new DataReturnList<>();
        dataReturnList.setMessage("get all items");
        dataReturnList.setData(attach_fileService.findAll());

        return dataReturnList;
    }

    @PostMapping("/updateImage/{id}")
    public ResponseEntity<Object> updateImage(@RequestBody Attach_FileDTO attachFileDTO,@PathVariable(value="id") int id) {
        Attach_File attachFile = attach_fileService.findById(attachFileDTO,id);
        DataReturnOne<Attach_File> returnOne = new DataReturnOne<>();
        returnOne.setMessage("Thay doi anh thanh cong");
        returnOne.setSuccess("true");
        returnOne.setData(attachFile);
        return ResponseEntity.ok(returnOne);
    }
}
