package hcmute.edu.vn.nuservice.service;

import hcmute.edu.vn.nuservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.nuservice.model.Items;

import java.util.List;

public interface ItemService {
    Items findById(int id);
    List<Items> findAllItems();
}
