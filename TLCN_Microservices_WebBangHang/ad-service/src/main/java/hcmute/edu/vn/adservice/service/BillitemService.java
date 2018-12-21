package hcmute.edu.vn.adservice.service;

import hcmute.edu.vn.adservice.model.Bill_Item;

import java.util.List;

public interface BillitemService {
    List<Bill_Item> retrieveAllBillItem(int id);
}
