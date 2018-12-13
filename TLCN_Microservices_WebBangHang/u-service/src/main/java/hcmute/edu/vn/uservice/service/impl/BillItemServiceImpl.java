package hcmute.edu.vn.uservice.service.impl;

import hcmute.edu.vn.uservice.model.Bill_Item;
import hcmute.edu.vn.uservice.repository.BillItemRepository;
import hcmute.edu.vn.uservice.service.BillItemService;
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
