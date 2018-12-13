package hcmute.edu.vn.uservice.service;

import hcmute.edu.vn.uservice.model.Items;

import java.util.List;

public interface ItemService {
    Items findById(int id);
    List<Items> findAllItems();
}
