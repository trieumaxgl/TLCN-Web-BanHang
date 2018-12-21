package hcmute.edu.vn.adservice.service;

import hcmute.edu.vn.adservice.api.v1.dto.ItemDTO;
import hcmute.edu.vn.adservice.model.Items;

import java.util.List;

public interface ItemService {

    ItemDTO findById(int id, int status);

    Items findById(int id);

    Items dtoToItem(ItemDTO itemDTO);

    Items saveItem(Items items);

    Items deleteItem(int id,int status);

    Items updateItem(ItemDTO itemDTO, int id);

    List<ItemDTO> findItemType(int typesId);

    List<Items> findAll(int status);
}
