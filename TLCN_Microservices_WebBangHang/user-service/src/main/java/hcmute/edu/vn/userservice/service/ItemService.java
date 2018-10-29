package hcmute.edu.vn.userservice.service;

import hcmute.edu.vn.userservice.model.Items;

import java.util.List;

public interface ItemService {
    Items findById(int id);
    List<Items> findAllItems();
}
