package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.model.Bill_Item;
import hcmute.edu.vn.userservice.repository.BillItemRepository;
import hcmute.edu.vn.userservice.service.BillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillItemServiceImpl implements  BillItemService{
    @Autowired
    private BillItemRepository billItemRepository;


    @Override
    public Bill_Item addBillItem(Bill_Item bill_item) {
        return billItemRepository.save(bill_item);
    }
}
