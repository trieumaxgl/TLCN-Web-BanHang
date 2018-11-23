package hcmute.edu.vn.adminservice.service;

import hcmute.edu.vn.adminservice.api.v1.dto.ItemDTO;
import hcmute.edu.vn.adminservice.model.Items;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    ItemDTO findById(int id, int delFlag);

    Items saveItem(Items items);

    Items deleteItem(int id, int delFlag);

    List<Items> findAll(int delFlag);
}
